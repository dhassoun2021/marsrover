package com.david.kata.validator;

/**
 * Util class to validate command entered to move rover
 */
public final class CommandValidator {

    /**
     * Check rover command, a runtime exception is thrown if expression is not valid
     * @param command
     */
    public static void checkRoverCommand (String command) {
        if (command == null || command.trim().length() == 0) {
            throw new IllegalArgumentException("Command should not be empty");
        }
        if (!command.matches("(F|B|L|R|f|l|b|r)+")) {
            throw new IllegalArgumentException("Command " + command + " has invalid character");
        }
    }
}
