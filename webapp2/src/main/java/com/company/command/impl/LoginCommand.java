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

public class LoginCommand implements Commandd {

    private static final String PARAM_LOGIN = "login";
    private static final String PARAM_PASSWORD = "password";
    private static Logger logger = LogManager.getLogger();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page;
        String loginValue = request.getParameter(PARAM_LOGIN);
        String passValue = request.getParameter(PARAM_PASSWORD);

        if (loginValue != null && !loginValue.isBlank() && passValue != null && !passValue.isBlank()) {
            ClientService clientService = ServiceFactory.getInstance().getClientService();
            /*if (!UserValidator.checkLogin(loginValue) || !UserValidator.checkPassword(passValue)) {
                //TODO invalid login password
                page = PagePath.LOGIN_PAGE;
            }*/
             if (clientService.login(loginValue, passValue)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("User ")
                        .append(loginValue)
                        .append("logged in");
                logger.info(stringBuilder.toString());
                page = PagePath.MAIN_PAGE;
            } else {
                page = PagePath.LOGIN_PAGE;
            }
        } else {
            page = PagePath.LOGIN_PAGE;
        }
        return page;
    }
}
