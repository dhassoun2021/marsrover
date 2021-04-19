package com.david.kata;

import com.david.kata.commands.CommandType;

/**
 * All posible direction for a rover
 */
public enum Direction {

    NORTH(0),
    EAST(1),
    SOUTH(2),
    WEST(3);

    private static final int  NUMBER_DIRECTION = 4;
    private final int flag;

    Direction(int flag) {
        this.flag = flag;
    }

    public int getFlag() {
        return flag;
    }


    /**
     * Compute next direction from commandType (L or R)
     * @param commandType
     * @return
     */
    Direction next(CommandType commandType) {
        int index = getIndex(commandType);
        return getDirection(index);
    }

    private int getIndex (CommandType commandType) {
        if (commandType != CommandType.R && commandType != CommandType.L) {
            throw new IllegalStateException("Cannot change direction for this command " + commandType);
        }
        int index = (commandType == CommandType.L) ? (flag-1+NUMBER_DIRECTION)%NUMBER_DIRECTION : (flag+1)%NUMBER_DIRECTION;
        return index;
    }

    private Direction getDirection(int index) {
        for (Direction direction :Direction.values()) {
            if (index == direction.getFlag()) {
                return direction;
            }
        }
        throw new IllegalStateException("Cannot find direction for index " + index);
    }
}
