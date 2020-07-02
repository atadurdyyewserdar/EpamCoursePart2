package com.company.dao;

import java.util.List;

public interface AbstractDao<T> {
    List<T> findAll() throws DaoException;

    T findById(int id) throws DaoException;

    void create(T data) throws DaoException;

    void update(T data) throws DaoException;

    void delete(T data) throws DaoException;
}
