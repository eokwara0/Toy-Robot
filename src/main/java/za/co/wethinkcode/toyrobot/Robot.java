package za.co.wethinkcode.toyrobot;

import za.co.wethinkcode.toyrobot.maze.AbstractMaze;
import za.co.wethinkcode.toyrobot.maze.EmptyMaze;
import za.co.wethinkcode.toyrobot.maze.Maze;
import za.co.wethinkcode.toyrobot.maze.RandomMaze;
import za.co.wethinkcode.toyrobot.world.AbstractWorld;

import java.util.ArrayList;
import java.util.List;

public class Robot {



    public List<Command> history = new ArrayList<>();


    private final AbstractWorld world;
    private String status;
    private final String name;
    private Maze maze ;


    public Robot(String name) {
        this.name = name;
        this.status = "Ready";
        maze = new RandomMaze();
        this.world = AbstractWorld.create("text",maze);
    }
    public Robot(String name , String argument){
        this.name = name ;
        this.status = "Ready" ;
        Maze maze = AbstractMaze.create(argument.split(" ")[1]);
        this.world = AbstractWorld.create(argument.split(" ")[0], maze);
    }

    public String getStatus() {
        return this.status;
    }

    public Maze getMaze(){

        return this.maze ;

    }

    public AbstractWorld getWorld(){
        return this.world;
    }

    public void addHistory(Command command){
        this.history.add(command);
    }

    public List<Command> getHistory(){
        return this.history;
    }

    public boolean handleCommand(Command command) {
        boolean handled = command.execute(this);
        if (!command.getName().equalsIgnoreCase("sprint")){
            System.out.println(this);
        }
        return handled ;
    }

    @Override
    public String toString() {
        return "[" + this.world.getPosition().getX() + "," + this.world.getPosition().getY() + "] "
                + this.name + "> " + this.status;
    }


    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }
}