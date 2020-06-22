package com.company.dao.impl;

import com.company.dao.AbstractDao;
import com.company.entity.User;
import com.company.pool.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements AbstractDao<User> {
    private static Logger logger = LogManager.getLogger();
    private static final String SELECT_ALL = "SELECT idUser, role, fio, login, password, access from movie_rating.user";
    private static final String SELECT_BY_ID = "SELECT idUser, role, fio, login, password, access from movie_rating.user where idUser =?";
    private static final String INSERT = "INSERT INTO `movie_rating`.`user` (`idUser`, `role`, `fio`, `login`, `password`, `access`) VALUES (?, ?, ?, ?, ?, ?);";

    @Override
    public List<User> findAll() {
        System.out.println("SELECT ALL METHOD");
        List<User> userList = new ArrayList<>();
        Connection connection = ConnectionPool.getInstance().borrow();
        System.out.println("CONNECTION BORROWED");
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_ALL)) {
            while (resultSet.next()) {
                User user = new User();
                user.setIdUser(resultSet.getInt(1));
                user.setRole(resultSet.getString(2));
                user.setFio(resultSet.getString(3));
                user.setLogin(resultSet.getString(4));
                user.setPassword(resultSet.getString(5));
                byte b = resultSet.getByte(6);
                user.setAccess(Boolean.parseBoolean(Byte.toString(b)));
                userList.add(user);
                System.out.println(user);
                System.out.println("=========================");
            }
        } catch (SQLException e) {
            logger.info(e);
        } finally {
            ConnectionPool.getInstance().forfeit(connection);
        }
        return userList;
    }

    @Override
    public User findById(int id) {
        User user = null;
        Connection connection = ConnectionPool.getInstance().borrow();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                user = new User();
                user.setIdUser(resultSet.getInt(1));
                user.setRole(resultSet.getString(2));
                user.setFio(resultSet.getString(3));
                user.setLogin(resultSet.getString(4));
                user.setPassword(resultSet.getString(5));
                byte b = resultSet.getByte(6);
                user.setAccess(Boolean.parseBoolean(Byte.toString(b)));
            }
        } catch (SQLException e) {
            logger.info(e);
        } finally {
            ConnectionPool.getInstance().forfeit(connection);
        }
        return user;
    }

    @Override
    public void create(User data) {
        Connection connection = ConnectionPool.getInstance().borrow();
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT)) {
            preparedStatement.setInt(1, data.getIdUser());
            preparedStatement.setString(2, data.getRole());
            preparedStatement.setString(3, data.getFio());
            preparedStatement.setString(4, data.getLogin());
            preparedStatement.setString(4, data.getPassword());
            preparedStatement.setByte(4, Byte.parseByte(String.valueOf(data.isAccess())));
            preparedStatement.execute();
        } catch (SQLException e) {
            logger.info(e);
        } finally {
            ConnectionPool.getInstance().forfeit(connection);
        }
    }

    @Override
    public void update(User data) {
        //TODO
    }

    @Override
    public void delete(User data) {
    }

    public User findByLogin(String login) {
        List<User> userList = findAll();
        User result = null;
        for (User user : userList) {
            if (user.getLogin().equals(login)) {
                result = user;
            }
        }
        return result;
    }
}
