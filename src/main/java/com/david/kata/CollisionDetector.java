package com.david.kata;


import java.util.Optional;

/**
 * Detect collision for the rover
 */
public class CollisionDetector {

    private Rover rover;


    public CollisionDetector(Rover rover) {
        this.rover = rover;
    }

    public boolean isCollision () {
        if (rover.getObstacles() == null || rover.getObstacles().isEmpty()) {
            return false;
        }
        Position nextPosition = rover.getCoordinate().getNextPosition(rover.getArea(), rover.getCurrentCommand());
        Optional<Obstacle> optionalObstacle = rover.getObstacles().stream().filter(o->o.getPosition().equals(nextPosition)).findFirst();
        return optionalObstacle.isPresent();
    }
}
