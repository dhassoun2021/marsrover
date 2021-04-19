package com.david.kata;

import java.util.Arrays;

public class BaseRoverTest {

    protected Rover initRover (int x,int y,Direction direction, Area area) {
        Rover rover = new Rover(new Coordinate(new Position(x,y),direction),area);
        return rover;
    }

    protected Rover initRover (int x,int y,Direction direction, Area area, Obstacle ... obstacles) {
        Rover rover = new Rover(new Coordinate(new Position(x,y),direction),area, Arrays.asList(obstacles));
        return rover;
    }
}
