package com.company.service.impl;

import com.company.dao.factory.DaoFactory;
import com.company.dao.impl.UserDao;
import com.company.entity.User;
import com.company.service.ClientService;

public class ClientServiceImpl implements ClientService {
    @Override
    public boolean login(String login, String password) {
        UserDao userDao = DaoFactory.getInstance().getUserDao();
        User user = userDao.findByLogin(login);
        boolean result = false;
        if (user != null && user.getPassword().equals(password)) {
            result = true;
        }
        return result;
    }
}
