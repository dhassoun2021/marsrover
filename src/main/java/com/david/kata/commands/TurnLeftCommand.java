package com.david.kata.commands;

import com.david.kata.Coordinate;


public class TurnLeftCommand implements Command {

    private Coordinate coordinate;

    public TurnLeftCommand(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    @Override
    public void execute() {
        coordinate.turnLeft();
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }
}
