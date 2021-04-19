package com.david.kata;

import com.david.kata.commands.CommandType;

public class Coordinate {

    private Position position;
    private Direction direction;

    public Coordinate(Position position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    
    public Position getPosition() {
        return position;
    }

    public Direction getDirection() {
        return direction;
    }

    public void forward(Area area) {
        updatePositionAfterForward(position,area);

    }

    public void backward(Area area) {
        updatePositionAfterBackward(position,area);
    }

    private Position getNextPositionBeforeForward (Area area) {
        Position position = new Position(getPosition().getX(), getPosition().getY());
        updatePositionAfterForward(position,area);
        return position;
    }

    public Position getNextPosition (Area area, CommandType commandType) {
        return (commandType == CommandType.F ? getNextPositionBeforeForward(area) : getNextPositionBeforeBackward(area));
    }

    private Position getNextPositionBeforeBackward (Area area) {
        Position position = new Position(getPosition().getX(), getPosition().getY());
        updatePositionAfterBackward(position,area);
        return position;
    }

    private void updatePositionAfterBackward (Position position, Area area) {
        switch(direction) {
            case EAST:
                position.setX(position.getX() == area.getMinX() ? area.getMaxX():position.getX() - 1);
                break;

            case WEST:
                position.setX(position.getX() == area.getMaxX() ? area.getMinX():position.getX() + 1);
                break;
            case NORTH:
                position.setY(position.getY() == area.getMinY() ? area.getMaxY():position.getY() - 1);
                break;
            case SOUTH:
                position.setY(position.getY() == area.getMaxY() ? area.getMinY():position.getY() + 1);
                break;
        }
    }

    private void updatePositionAfterForward (Position position, Area area) {
        switch(direction) {
            case EAST:
                position.setX(position.getX() == area.getMaxX() ? area.getMinX():position.getX() + 1);
                break;

            case WEST:
                position.setX(position.getX() == area.getMinX() ? area.getMaxX():position.getX() - 1);
                break;
            case NORTH:
                position.setY(position.getY() == area.getMaxY() ? area.getMinY():position.getY() + 1);
                break;
            case SOUTH:
                position.setY(position.getY() == area.getMinY() ? area.getMaxY():position.getY() - 1);
                break;
        }
    }

    public void turnRight() {
        direction = direction.next(CommandType.R);
    }

    public void turnLeft() {
        direction = direction.next(CommandType.L);
    }
}
