package com.company.dao.factory;

import com.company.dao.impl.UserDao;

public class DaoFactory {
    private static final DaoFactory INSTANCE = new DaoFactory();

    private final UserDao userDao = new UserDao();

    private DaoFactory() {
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public static DaoFactory getInstance() {
        return INSTANCE;
    }
}
