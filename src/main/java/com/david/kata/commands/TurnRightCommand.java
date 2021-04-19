package com.david.kata.commands;

import com.david.kata.Coordinate;


public class TurnRightCommand implements Command {

    private Coordinate coordinate;

    public TurnRightCommand(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    @Override
    public void execute() {
        coordinate.turnRight();
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }
}
