package com.david.kata;


import com.david.kata.commands.BackwardCommand;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BackwardCommandTest extends BaseRoverTest{

    @Test
    public void backwardWithEastDirection () {
        Rover rover = initRover(1,1,Direction.EAST,new Area(0,5,-1,4));
        BackwardCommand backwardCommand = new BackwardCommand(rover);
        backwardCommand.execute();
        Position expectedPosition = new Position (0,1);
        assertEquals(expectedPosition,backwardCommand.getRover().getCoordinate().getPosition());
    }

    @Test
    public void backwardWithEastDirectionAndObstacle () {
        Obstacle obstacle = new Obstacle(new Position(0,1));
        Rover rover = initRover(1,1,Direction.EAST,new Area(0,5,-1,4),obstacle);
        BackwardCommand backwardCommand = new BackwardCommand(rover);
        backwardCommand.execute();
        Position expectedPosition = new Position (1,1);
        assertEquals(expectedPosition,backwardCommand.getRover().getCoordinate().getPosition());
    }

    @Test
    public void backwardShouldGoToMaxXWhenMinXisReachedAndEastDirection () {
        Rover rover = initRover(0,1,Direction.EAST,new Area(0,5,-1,4));
        BackwardCommand backwardCommand = new BackwardCommand(rover);
        backwardCommand.execute();
        Position expectedPosition = new Position (5,1);
        assertEquals(expectedPosition,backwardCommand.getRover().getCoordinate().getPosition());
    }

    @Test
    public void backwardWithWestDirection () {
        Rover rover = initRover(1,1,Direction.WEST,new Area(0,5,-1,4));
        BackwardCommand backwardCommand = new BackwardCommand(rover);
        backwardCommand.execute();
        Position expectedPosition = new Position (2,1);
        assertEquals(expectedPosition,backwardCommand.getRover().getCoordinate().getPosition());
    }

    @Test
    public void backwardShouldGoToMinXWhenMaxXisReachedAndWestDirection () {
        Rover rover = initRover(5,1,Direction.WEST,new Area(0,5,-1,4));
        BackwardCommand backwardCommand = new BackwardCommand(rover);
        backwardCommand.execute();
        Position expectedPosition = new Position (0,1);
        assertEquals(expectedPosition,backwardCommand.getRover().getCoordinate().getPosition());
    }

    @Test
    public void backwardWithNorthDirection () {
        Rover rover = initRover(1,1,Direction.NORTH,new Area(0,5,-1,4));
        BackwardCommand backwardCommand = new BackwardCommand(rover);
        backwardCommand.execute();
        Position expectedPosition = new Position (1,0);
        assertEquals(expectedPosition,backwardCommand.getRover().getCoordinate().getPosition());
    }

    @Test
    public void backwardShouldGoToMaxYWhenMinYisReachedAndNorthDirection () {
        Rover rover = initRover(1,-1,Direction.NORTH,new Area(0,5,-1,4));
        BackwardCommand backwardCommand = new BackwardCommand(rover);
        backwardCommand.execute();
        Position expectedPosition = new Position (1,4);
        assertEquals(expectedPosition,backwardCommand.getRover().getCoordinate().getPosition());
    }

    @Test
    public void backwardWithSouthDirection () {
        Rover rover = initRover(1,1,Direction.SOUTH,new Area(0,5,-1,4));
        BackwardCommand backwardCommand = new BackwardCommand(rover);
        backwardCommand.execute();
        Position expectedPosition = new Position (1,2);
        assertEquals(expectedPosition,backwardCommand.getRover().getCoordinate().getPosition());
    }

    @Test
    public void backwardShouldGoToMaxYWhenMinYisReachedAndSouthDirection () {
        Rover rover = initRover(1,4,Direction.SOUTH,new Area(0,5,-1,4));
        BackwardCommand backwardCommand = new BackwardCommand(rover);
        backwardCommand.execute();
        Position expectedPosition = new Position (1,-1);
        assertEquals(expectedPosition,backwardCommand.getRover().getCoordinate().getPosition());
    }
}
