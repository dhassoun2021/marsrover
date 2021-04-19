package com.david.kata;

import com.david.kata.commands.*;
import com.david.kata.validator.CommandValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.david.kata.commands.CommandType.*;
import static com.david.kata.commands.Commands.COMMANDS;

/**
 * API to manage a rover
 */
public class Rover {

    private Coordinate coordinate;

    /**
     * Area where rover could move
     */
    private Area area;

    private List<Obstacle> obstacles = new ArrayList<>();

    /**
     * Current command executed by rover
     */
    private CommandType currentCommand;

    public Rover(Coordinate coordinate, Area area) {
        this.coordinate = coordinate;
        this.area = area;
        initCommands();
    }

    public Rover(Coordinate coordinate, Area area,List<Obstacle> obstacles) {
        this.coordinate = coordinate;
        this.area = area;
        this.obstacles = obstacles;
        initCommands();
    }

    private void initCommands () {
        COMMANDS.put(F,new ForwardCommand(this));
        COMMANDS.put(B,new BackwardCommand(this));
        COMMANDS.put(L,new TurnLeftCommand(coordinate));
        COMMANDS.put(R,new TurnRightCommand(coordinate));
    }

    /**
     * Execute a command entered by a user
     * @param command
     */
    public void onCommand (String command) {
        CommandValidator.checkRoverCommand(command);
        command = command.toUpperCase();
        char [] arraysCommand = command.toCharArray();
        for (char c: arraysCommand) {
            onCommand(c);
        }
    }

    private void onCommand (char c) {
        CommandType commandType = fromCommand(c);
        Command command = COMMANDS.get(commandType);
        setCurrentCommand(commandType);
        command.execute();
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public CommandType getCurrentCommand() {
        return currentCommand;
    }

    public void setCurrentCommand(CommandType currentCommand) {
        this.currentCommand = currentCommand;
    }

    public Area getArea() {
        return area;
    }

    public List<Obstacle> getObstacles() {
        return obstacles;
    }
}
