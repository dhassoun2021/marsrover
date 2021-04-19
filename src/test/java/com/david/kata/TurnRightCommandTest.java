package com.david.kata;

import com.david.kata.commands.TurnRightCommand;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TurnRightCommandTest {

    @Test
    public void turnRightShouldGoToSouthWhenCurrentDirectionIsEast () {
        TurnRightCommand turnRightCommand = new TurnRightCommand(new Coordinate(new Position(1,1),Direction.EAST));
        turnRightCommand.execute();
        assertEquals(Direction.SOUTH,turnRightCommand.getCoordinate().getDirection());
    }

    @Test
    public void turnRightShouldGoToEastWhenCurrentDirectionIsNorth () {
        TurnRightCommand turnRightCommand = new TurnRightCommand(new Coordinate(new Position(1,1),Direction.NORTH));
        turnRightCommand.execute();
        assertEquals(Direction.EAST,turnRightCommand.getCoordinate().getDirection());
    }

    @Test
    public void turnRightShouldGoToNorthWhenCurrentDirectionIsWest () {
        TurnRightCommand turnRightCommand = new TurnRightCommand(new Coordinate(new Position(1,1),Direction.WEST));
        turnRightCommand.execute();
        assertEquals(Direction.NORTH,turnRightCommand.getCoordinate().getDirection());
    }

    @Test
    public void turnRightShouldGoToWestWhenCurrentDirectionIsSouth () {
        TurnRightCommand turnRightCommand = new TurnRightCommand(new Coordinate(new Position(1,1),Direction.SOUTH));
        turnRightCommand.execute();
        assertEquals(Direction.WEST,turnRightCommand.getCoordinate().getDirection());
    }
}
