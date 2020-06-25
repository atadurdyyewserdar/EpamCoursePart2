package com.company.service.impl;

import com.company.dao.factory.DaoFactory;
import com.company.dao.impl.UserDao;
import com.company.entity.User;
import com.company.service.ClientService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ClientServiceImpl implements ClientService {
    private static Logger logger = LogManager.getLogger();

    @Override
    public boolean login(String login, String password) {

        UserDao userDao = DaoFactory.getInstance().getUserDao();
        User user = userDao.findByLogin(login);
        logger.info("Login : " + login);
        logger.info("Password: " + password);
        boolean result = false;
        if (user != null && user.getPassword().equals(password)) {
            result = true;
            logger.info("Password and login are true");
        }
        return result;
    }

    @Override
    public boolean register(String login, String password, String fio) {
        UserDao userDao = DaoFactory.getInstance().getUserDao();
        User user = userDao.findByLogin(login);
        boolean result = true;
        if (user != null) {
            logger.info("User already exists");
            result = false;
        } else {
            user = new User();
            user.setLogin(login);
            user.setPassword(password);
            user.setAccess(true);
            user.setRole("user");
            user.setFio(fio);
            userDao.create(user);
        }
        return result;
    }
}
