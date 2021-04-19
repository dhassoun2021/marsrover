package com.david.kata.commands;

import com.david.kata.*;

import java.util.List;
import java.util.Optional;

public class ForwardCommand extends TranslateCommand {
    
    public ForwardCommand(Rover rover) {
       super(rover);
    }


    @Override
    public void translate() {
        rover.getCoordinate().forward(rover.getArea());
    }

}
