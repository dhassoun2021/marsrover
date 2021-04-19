package com.david.kata.commands;


import com.david.kata.Rover;

public abstract class BaseCommand {

    protected Rover rover;


    public BaseCommand(Rover rover) {
        this.rover = rover;
    }


    public Rover getRover() {
        return rover;
    }
}
