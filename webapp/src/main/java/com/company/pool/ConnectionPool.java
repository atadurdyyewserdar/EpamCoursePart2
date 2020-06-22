package com.company.pool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConnectionPool {
    private static Logger logger = LogManager.getLogger();
    private static final String PROPERTIES_PATH = "database.properties";
    private BlockingQueue<Connection> available;
    private Queue<Connection> busy;
    private static Lock lock = new ReentrantLock();
    private int poolSize = 2;
    private static ConnectionPool INSTANCE;

    ConnectionPool() {
        available = new LinkedBlockingDeque<>();

        busy = new ArrayDeque<>();
        ResourceBundle resourceBundle = ResourceBundle.getBundle("database");
        String url = resourceBundle.getString("url");
        String driver = resourceBundle.getString("driver");
        String user = resourceBundle.getString("user");
        String password = resourceBundle.getString("password");
        try {
            Class.forName(driver);
            for (int i = 0; i < poolSize; i++) {
                Connection connection = DriverManager.getConnection(url, user, password);
                logger.info("Connection created");
                available.add(connection);
            }
        } catch (SQLException | ClassNotFoundException e) {
            logger.info(e);
        }
    }

    public static ConnectionPool getInstance() {
        if (INSTANCE == null) {
            lock.lock();
            try {
                if (INSTANCE == null) {
                    INSTANCE = new ConnectionPool();
                }
            } finally {
                lock.unlock();
            }
            return INSTANCE;
        }
        return INSTANCE;
    }

    public Connection borrow() {
        Connection connection = null;
        try {
            connection = available.take();
            busy.add(connection);
        } catch (InterruptedException e) {
            logger.info(e);
        }
        if (connection == null) {
            System.out.println("NULL CONNECTION");
        }
        return connection;
    }

    public void forfeit(Connection connection) {
        if (busy.contains(connection)) {
            busy.remove(connection);
            available.add(connection);
        }
    }

    private void deregisterDrivers() {
        Enumeration<Driver> drivers;
        drivers = DriverManager.getDrivers();
        while (drivers.hasMoreElements()) {
            java.sql.Driver driver = drivers.nextElement();
            try {
                DriverManager.deregisterDriver(driver);
            } catch (SQLException e) {
                logger.info(e);
            }
        }
    }

    public void destroyPool() {
        while (!available.isEmpty()) {
            try {
                available.take().close();
            } catch (SQLException | InterruptedException e) {
                logger.info(e);
            }
        }
        deregisterDrivers();
    }
}
