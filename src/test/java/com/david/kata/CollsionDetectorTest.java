package com.david.kata;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import static com.david.kata.commands.CommandType.F;

import java.util.Arrays;
import java.util.List;

public class CollsionDetectorTest {

    @Test
    public void collisionTrue () {
        List<Obstacle> obstacles = Arrays.asList(new Obstacle(new Position(2,1)));
        Rover rover = new Rover(new Coordinate(new Position(1,1),Direction.EAST),new Area(0,5,-1,4),obstacles);
        rover.setCurrentCommand(F);
        CollisionDetector collisionDetector = new CollisionDetector(rover);
        assertTrue(collisionDetector.isCollision());
    }

    @Test
    public void collisionFalse () {
        List<Obstacle> obstacles = Arrays.asList(new Obstacle(new Position(2,0)));
        Rover rover = new Rover(new Coordinate(new Position(2,1),Direction.EAST),new Area(0,5,-1,4),obstacles);
        rover.setCurrentCommand(F);
        CollisionDetector collisionDetector = new CollisionDetector(rover);
        assertFalse(collisionDetector.isCollision());
    }
}
