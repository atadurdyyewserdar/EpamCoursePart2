package com.company.command.impl;

import com.company.command.Commandd;

public enum CommandType {
    LOGIN(new LoginCommand()),
    REGISTER(new RegisterCommand());

    private Commandd command;

    CommandType(Commandd command) {
        this.command = command;
    }

    public Commandd getCommand() {
        return command;
    }
}
