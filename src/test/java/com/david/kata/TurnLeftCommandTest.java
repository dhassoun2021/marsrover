package com.david.kata;

import com.david.kata.commands.TurnLeftCommand;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TurnLeftCommandTest  {

    @Test
    public void turnLeftShouldGoToNorthWhenCurrentDirectionIsEast () {
        TurnLeftCommand turnLeftCommand = new TurnLeftCommand(new Coordinate(new Position(1,1),Direction.EAST));
        turnLeftCommand.execute();
        assertEquals(Direction.NORTH,turnLeftCommand.getCoordinate().getDirection());
    }

    @Test
    public void turnLeftShouldGoToEastWhenCurrentDirectionIsSouth () {
        TurnLeftCommand turnLeftCommand = new TurnLeftCommand(new Coordinate(new Position(1,1),Direction.SOUTH));
        turnLeftCommand.execute();
        assertEquals(Direction.EAST,turnLeftCommand.getCoordinate().getDirection());
    }

    @Test
    public void turnLeftShouldGoToSouthWhenCurrentDirectionIsWest () {
        TurnLeftCommand turnLeftCommand = new TurnLeftCommand(new Coordinate(new Position(1,1),Direction.WEST));
        turnLeftCommand.execute();
        assertEquals(Direction.SOUTH,turnLeftCommand.getCoordinate().getDirection());
    }

    @Test
    public void turnLeftShouldGoToWestWhenCurrentDirectionIsNorth () {
        TurnLeftCommand turnLeftCommand = new TurnLeftCommand(new Coordinate(new Position(1,1),Direction.NORTH));
        turnLeftCommand.execute();
        assertEquals(Direction.WEST,turnLeftCommand.getCoordinate().getDirection());
    }
}
