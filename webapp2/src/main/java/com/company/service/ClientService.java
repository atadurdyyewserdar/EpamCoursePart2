package com.company.service;

public interface ClientService {
    boolean login(String login, String password);

    boolean register(String login, String password, String fio, String mail);
}
