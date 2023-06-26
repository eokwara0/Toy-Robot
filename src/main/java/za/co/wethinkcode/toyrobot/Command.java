package za.co.wethinkcode.toyrobot;

import za.co.wethinkcode.toyrobot.maze.AbstractMazeRunner;
import za.co.wethinkcode.toyrobot.maze.defaultMazeRunner;
import za.co.wethinkcode.toyrobot.world.IWorld;

import java.util.List;

public abstract class Command {
    private final String name;
    private String argument;

    public abstract boolean execute(Robot target);

    public Command(String name){
        this.name = name.trim().toLowerCase();
        this.argument = "";
    }

    public Command(String name, String argument) {
        this(name);
        this.argument = argument.trim().toLowerCase();
    }

    public String getName() {                                                                           //<2>
        return name;
    }

    public String getArgument() {
        return this.argument;
    }

    public static Command create(String instruction, Robot robot) {
        List<String> args = List.of(instruction.toLowerCase().trim().split(" "));
        switch (args.get(0)){
            case "shutdown":
            case "off":

                return new ShutdownCommand();

            case "help":

                return new HelpCommand();

            case "forward":

                return new ForwardCommand(args.get(1));

            case "back":

                return new BackCommand(args.get(1));

            case "right":

                return new RightCommand();

            case "left":

                return new LeftCommand();

            case "sprint":

                return new SprintCommand(args.get(1));

            case "mazerun":
                return AbstractMazeRunner.create(robot, instruction);

            case "replay":

                if (instruction.contains(" ")){
                    return new ReplayCommand(instruction.substring(7));

                }else{
                    return  new ReplayCommand();
                }
            default:
                throw new IllegalArgumentException("Unsupported command: " + instruction);
        }
    }

}

