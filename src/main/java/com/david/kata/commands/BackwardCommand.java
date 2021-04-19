package com.david.kata.commands;

import com.david.kata.*;

import java.util.List;
import java.util.Optional;

public class BackwardCommand extends TranslateCommand {

    public BackwardCommand(Rover rover) {
        super(rover);
    }

    @Override
    public void translate() {
        rover.getCoordinate().backward(rover.getArea());
    }


}
