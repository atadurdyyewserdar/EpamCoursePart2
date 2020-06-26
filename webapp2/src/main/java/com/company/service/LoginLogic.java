package com.company.service;

import com.company.dao.factory.DaoFactory;
import com.company.dao.impl.UserDao;
import com.company.entity.User;

public class LoginLogic {
    public static boolean checkLogin(String login, String password) {
        UserDao userDao = DaoFactory.getInstance().getUserDao();
        User user = userDao.findByLogin(login);
        boolean result = false;
        if (user != null && user.getPassword().equals(password)) {
            result = true;
        }
        return result;
    }
}
