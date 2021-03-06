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
    private static final String SELECT_ALL = "SELECT idUser, role, fio, login, password, access , mail from movie_rating.user";
    private static final String SELECT_BY_ID = "SELECT idUser, role, fio, login, password, access, mail from movie_rating.user where idUser =?";
    private static final String INSERT = "INSERT INTO `movie_rating`.`user` (`role`, `fio`, `login`, `password`, `access`, `mail`) VALUES (?, ?, ?, ?, ?, ?);";

    @Override
    public List<User> findAll() {
        List<User> userList = new ArrayList<>();
        Connection connection = ConnectionPool.getInstance().borrow();
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
                user.setMail(resultSet.getString(7));
                user.setAccess(Boolean.parseBoolean(Byte.toString(b)));
                userList.add(user);
            }
        } catch (SQLException e) {
            logger.error(e);
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
                user = parseUser(resultSet);
            }
        } catch (SQLException e) {
            logger.error(e);
        } finally {
            ConnectionPool.getInstance().forfeit(connection);
        }
        return user;
    }

    @Override
    public void create(User data) {
        Connection connection = ConnectionPool.getInstance().borrow();
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT)) {
            preparedStatement.setString(1, data.getRole());
            preparedStatement.setString(2, data.getFio());
            preparedStatement.setString(3, data.getLogin());
            preparedStatement.setString(4, data.getPassword());
            preparedStatement.setBoolean(5, Boolean.parseBoolean(String.valueOf(data.isAccess())));
            preparedStatement.setString(6, data.getMail());
            preparedStatement.execute();
        } catch (SQLException e) {
            logger.error(e);
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
                logger.info("User found...");
                logger.info(user);
            }
        }
        return result;
    }

    private User parseUser(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setIdUser(resultSet.getInt(1));
        user.setRole(resultSet.getString(2));
        user.setFio(resultSet.getString(3));
        user.setLogin(resultSet.getString(4));
        user.setPassword(resultSet.getString(5));
        user.setAccess(resultSet.getBoolean(6));
        return user;
    }
}
