package com.david.kata;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class RoverTest {


    @Test
    public void shouldForwardWhenReceiveCommandF() {
        Rover rover = new Rover(new Coordinate(new Position(1,1),Direction.EAST),new Area(0,5,-1,4));
        rover.onCommand("f");
        Position expectedPosition = new Position (2,1);
        assertEquals(expectedPosition,rover.getCoordinate().getPosition());
    }

    @Test
    public void shouldBackwardWhenReceiveCommandB() {
        Rover rover = new Rover(new Coordinate(new Position(1,1),Direction.EAST),new Area(0,5,-1,4));
        rover.onCommand("b");
        Position expectedPosition = new Position (0,1);
        assertEquals(expectedPosition,rover.getCoordinate().getPosition());
    }

    @Test
    public void shouldTurnLeftWhenReceiveCommandB() {
        Rover rover = new Rover(new Coordinate(new Position(1,1),Direction.EAST),new Area(0,5,-1,4));
        rover.onCommand("l");
        Direction expectedDirection = Direction.NORTH;
        assertEquals(expectedDirection,rover.getCoordinate().getDirection());
    }

    @Test
    public void shouldTurnRightWhenReceiveCommandR() {
        Rover rover = new Rover(new Coordinate(new Position(1,1),Direction.EAST),new Area(0,5,-1,4));
        rover.onCommand("r");
        Direction expectedDirection = Direction.SOUTH;
        assertEquals(expectedDirection,rover.getCoordinate().getDirection());
    }

    @Test
    public void shouldHavePosition4_2AndDirectionEastWhenReceiveCommandFFRBLF() {
        Rover rover = new Rover(new Coordinate(new Position(1,1),Direction.EAST),new Area(0,5,-1,4));
        rover.onCommand("ffrblf");
        Direction expectedDirection = Direction.EAST;
        assertEquals(expectedDirection,rover.getCoordinate().getDirection());
        Position expectedPosition = new Position (4,2);
        assertEquals(expectedPosition,rover.getCoordinate().getPosition());
    }

    @Test
    public void shouldHavePosition0_4AndDirectionSouthWhenReceiveCommandFFRBLFFFRFFFF() {
        Rover rover = new Rover(new Coordinate(new Position(1,1),Direction.EAST),new Area(0,5,-1,4));
        rover.onCommand("ffrblfFFRFFFF");
        Direction expectedDirection = Direction.SOUTH;
        assertEquals(expectedDirection,rover.getCoordinate().getDirection());
        Position expectedPosition = new Position (0,4);
        assertEquals(expectedPosition,rover.getCoordinate().getPosition());
    }

    @Test
    public void shouldHavePosition2_1AndDirectionSouthWhenReceiveCommandFRFAndObstacleAt2_0() {
        List<Obstacle> obstacles = Arrays.asList(new Obstacle(new Position(2,0)));
        Rover rover = new Rover(new Coordinate(new Position(1,1),Direction.EAST),new Area(0,5,-1,4),obstacles);
        rover.onCommand("frf");
        Direction expectedDirection = Direction.SOUTH;
        assertEquals(expectedDirection,rover.getCoordinate().getDirection());
        Position expectedPosition = new Position (2,1);
        assertEquals(expectedPosition,rover.getCoordinate().getPosition());
    }

    @Test
    public void shouldThrowIllegallArgumentExceptionWhenCommandIsEmpty() {
        try {
            Rover rover = new Rover(new Coordinate(new Position(1, 1), Direction.EAST), new Area(0, 5, -1, 4));
            rover.onCommand("");
        } catch (IllegalArgumentException ex) {
            assertEquals("Command should not be empty",ex.getMessage());
        }

    }

    @Test
    public void shouldThrowIllegallArgumentExceptionWhenCommandIsIncorrect() {
        try {
            Rover rover = new Rover(new Coordinate(new Position(1, 1), Direction.EAST), new Area(0, 5, -1, 4));
            rover.onCommand("FRLA");
        } catch (IllegalArgumentException ex) {
            assertEquals("Command FRLA has invalid character",ex.getMessage());
        }

    }




}