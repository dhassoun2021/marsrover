package com.david.kata.commands;

import com.david.kata.CollisionDetector;
import com.david.kata.Coordinate;
import com.david.kata.Obstacle;
import com.david.kata.Rover;

import java.util.ArrayList;
import java.util.List;

/**
 * Command used for forward and backward command
 */
public abstract class TranslateCommand extends BaseCommand implements Command {

    protected CollisionDetector collisionDetector;

    public TranslateCommand (Rover rover) {
        super(rover);
        collisionDetector = new CollisionDetector(rover);
    }
    @Override
    public void execute() {
       if (!collisionDetector.isCollision())  {
           translate();
       }
    }

    public abstract void translate ();
}
