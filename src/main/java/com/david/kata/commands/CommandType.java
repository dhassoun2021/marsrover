package com.david.kata.commands;

import java.util.Arrays;
import java.util.Optional;

public enum CommandType {


    F('F'),
    B('B'),
    L('L'),
    R('R');

    private char command;

    CommandType (char command) {
        this.command = command;
    }

   public static CommandType fromCommand (char command) {
       Optional <CommandType> optionalCommandType = Arrays.stream(CommandType.values()).filter(c-> c.getCommand()== command).findFirst();
       return optionalCommandType.get();
    }

    public char getCommand() {
        return command;
    }
}
