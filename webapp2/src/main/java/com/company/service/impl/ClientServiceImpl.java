package com.company.service.impl;

import com.company.dao.DaoException;
import com.company.dao.factory.DaoFactory;
import com.company.dao.impl.UserDao;
import com.company.entity.User;
import com.company.service.ClientService;
import com.company.service.md5.Md5Apache;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ClientServiceImpl implements ClientService {
    private static Logger logger = LogManager.getLogger();

    @Override
    public boolean login(String login, String password) {
        UserDao userDao = DaoFactory.getInstance().getUserDao();
        User user = userDao.findByLogin(login);
        logger.debug("Login : " + login);
        logger.debug("Password: " + password);
        boolean result = false;
        String md5 = Md5Apache.md5Apache(password);
        if (user != null && user.getPassword().equals(md5)) {
            result = true;
            logger.debug("Password and login are true");
        }
        return result;
    }

    @Override
    public boolean register(String login, String password, String fio, String mail) {
        UserDao userDao = DaoFactory.getInstance().getUserDao();
        User user = userDao.findByLogin(login);
        boolean result = true;
        if (user != null) {
            logger.info("User already exists");
            result = false;
        } else {
            String md5Hex = Md5Apache.md5Apache(password);
            user = new User();
            user.setLogin(login);
            user.setPassword(md5Hex);
            user.setAccess(true);
            user.setRole("user");
            user.setFio(fio);
            user.setMail(mail);
            userDao.create(user);
        }
        return result;
    }
}
