package com.company.dao;

import java.util.List;

public interface AbstractDao<T> {
    List<T> findAll();

    T findById(int id);

    void create(T data);

    void update(T data);

    void delete(T data);
}
