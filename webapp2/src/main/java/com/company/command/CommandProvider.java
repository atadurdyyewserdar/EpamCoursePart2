package com.company.command;

import com.company.command.impl.CommandType;

import java.util.Optional;

public class CommandProvider {
    public static Optional<Commandd> defineCommand(String commandName) {
        Optional<Commandd> current;

        if (commandName == null || commandName.isBlank()) {
            return Optional.empty();
        }

        CommandType type = CommandType.valueOf(commandName.toUpperCase());
        current = Optional.of(type.getCommand());
        return current;
    }
}
