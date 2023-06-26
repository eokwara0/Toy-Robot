package za.co.wethinkcode.toyrobot.maze;

import java.util.*;

import za.co.wethinkcode.toyrobot.world.Obstacle;

public abstract class AbstractMaze implements Maze{


    public abstract void createObstacles();

    public static AbstractMaze create(String name){

        switch (name){
            case "EmptyMaze":
                return new EmptyMaze();

            case "RandomMaze":
                return new RandomMaze();

            case "SimpleMaze":
                return new SimpleMaze();

            case "DesignedMaze":
                return new designedMaze();
            default:
                throw new IllegalArgumentException("unsupported maze "+name);
        }
    }


}
