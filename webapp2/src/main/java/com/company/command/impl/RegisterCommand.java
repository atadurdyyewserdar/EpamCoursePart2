package com.company.command.impl;

import com.company.command.Commandd;
import com.company.command.PagePath;
import com.company.service.ClientService;
import com.company.service.factory.ServiceFactory;
import com.company.validator.UserValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterCommand implements Commandd {
    private static final String PARAM_LOGIN = "login";
    private static final String PARAM_PASSWORD = "password";
    private static final String PARAM_FIO = "fio";
    private static Logger logger = LogManager.getLogger();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page;
        String loginValue = request.getParameter(PARAM_LOGIN);
        String passValue = request.getParameter(PARAM_PASSWORD);
        String fioValue = request.getParameter(PARAM_FIO);

        if (loginValue != null && !loginValue.isBlank() && passValue != null && !passValue.isBlank()) {
            ClientService clientService = ServiceFactory.getInstance().getClientService();
            /* if (UserValidator.checkFio(fioValue) || UserValidator.checkLogin(loginValue)
                    || UserValidator.checkPassword(passValue)) {
                //TODO invalid data
                page = PagePath.REGISTER_PAGE;
            } */
            if (clientService.register(loginValue, passValue, fioValue)) {
                page = PagePath.LOGIN_PAGE;
            } else {
                page = PagePath.REGISTER_PAGE;
            }
        } else {
            page = PagePath.REGISTER_PAGE;
        }
        return page;
    }
}
