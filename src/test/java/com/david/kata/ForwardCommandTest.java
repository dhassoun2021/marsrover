package com.david.kata;


import com.david.kata.commands.CommandType;
import com.david.kata.commands.ForwardCommand;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ForwardCommandTest extends BaseRoverTest {


    @Test
    public void forwardWithEastDirection () {
        Rover rover = initRover(1,1, Direction.EAST,new Area(0,5,-1,4));
        ForwardCommand forwardCommand = new ForwardCommand(rover);
        forwardCommand.execute();
        Position expectedPosition = new Position (2,1);
        assertEquals(expectedPosition,forwardCommand.getRover().getCoordinate().getPosition());
    }

    @Test
    public void forwardWithEastDirectionShouldStayAtSamePositionWhenObstacle () {
        Obstacle obstacle = new Obstacle(new Position(2,1));
        Rover rover = initRover(1,1, Direction.EAST,new Area(0,5,-1,4),obstacle);
        rover.setCurrentCommand(CommandType.F);
        ForwardCommand forwardCommand = new ForwardCommand(rover);
        forwardCommand.execute();
        Position expectedPosition = new Position (1,1);
        assertEquals(expectedPosition,forwardCommand.getRover().getCoordinate().getPosition());
    }

    @Test
    public void forwardShouldGoToMinXWhenMaxXisReachedAndEastDirection () {
        Rover rover = initRover(5,1, Direction.EAST,new Area(0,5,-1,4));
        ForwardCommand forwardCommand = new ForwardCommand(rover);
        forwardCommand.execute();
        Position expectedPosition = new Position (0,1);
        assertEquals(expectedPosition,forwardCommand.getRover().getCoordinate().getPosition());
    }

    @Test
    public void forwardWithWestDirection () {
        Rover rover = initRover(1,1, Direction.WEST,new Area(0,5,-1,4));
        ForwardCommand forwardCommand = new ForwardCommand(rover);
        forwardCommand.execute();
        Position expectedPosition = new Position (0,1);
        assertEquals(expectedPosition,forwardCommand.getRover().getCoordinate().getPosition());
    }

    @Test
    public void forwardShouldGoToMaxXWhenMinXisReachedAndWestDirection () {
        Rover rover = initRover(0,1, Direction.WEST,new Area(0,5,-1,4));
        ForwardCommand forwardCommand = new ForwardCommand(rover);
        forwardCommand.execute();
        Position expectedPosition = new Position (5,1);
        assertEquals(expectedPosition,forwardCommand.getRover().getCoordinate().getPosition());
    }

    @Test
    public void forwardWithNorthDirection () {
        Rover rover = initRover(1,1, Direction.NORTH,new Area(0,5,-1,4));
        ForwardCommand forwardCommand = new ForwardCommand(rover);
        forwardCommand.execute();
        Position expectedPosition = new Position (1,2);
        assertEquals(expectedPosition,forwardCommand.getRover().getCoordinate().getPosition());
    }

    @Test
    public void forwardShouldGoToMinYWhenMaxYisReachedAndNorthDirection () {
        Rover rover = initRover(1,4, Direction.NORTH,new Area(0,5,-1,4));
        ForwardCommand forwardCommand = new ForwardCommand(rover);
        forwardCommand.execute();
        Position expectedPosition = new Position (1,-1);
        assertEquals(expectedPosition,forwardCommand.getRover().getCoordinate().getPosition());
    }

    @Test
    public void forwardWithSouthDirection () {
        Rover rover = initRover(1,1, Direction.SOUTH,new Area(0,5,-1,4));
        ForwardCommand forwardCommand = new ForwardCommand(rover);
        forwardCommand.execute();
        Position expectedPosition = new Position (1,0);
        assertEquals(expectedPosition,forwardCommand.getRover().getCoordinate().getPosition());
    }

    @Test
    public void forwardShouldGoToMaxYWhenMinYisReachedAndSouthDirection () {
        Rover rover = initRover(1,-1, Direction.SOUTH,new Area(0,5,-1,4));
        ForwardCommand forwardCommand = new ForwardCommand(rover);
        forwardCommand.execute();
        Position expectedPosition = new Position (1,4);
        assertEquals(expectedPosition,forwardCommand.getRover().getCoordinate().getPosition());
    }
}
