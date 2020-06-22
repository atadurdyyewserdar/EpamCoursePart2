package com.company.service.factory;

import com.company.service.ClientService;
import com.company.service.impl.ClientServiceImpl;

public class ServiceFactory {
    public static ServiceFactory instance = new ServiceFactory();

    private ClientService clientService = new ClientServiceImpl();

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return instance;
    }

    public ClientService getClientService() {
        return clientService;
    }

}
