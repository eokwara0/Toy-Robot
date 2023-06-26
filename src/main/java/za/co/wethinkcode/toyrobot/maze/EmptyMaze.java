package za.co.wethinkcode.toyrobot.maze;

import za.co.wethinkcode.toyrobot.Position;
import za.co.wethinkcode.toyrobot.world.Obstacle;

import java.util.*;

public class EmptyMaze extends AbstractMaze{



    private List<Obstacle> obstacles;
    private String name ;

    public EmptyMaze(){
        this.name = "empty" ;
        createObstacles();
    }

    @Override
    public List<Obstacle> getObstacles() {
        return obstacles;
    }

    @Override
    public boolean blocksPath(Position a, Position b) {

        for (Obstacle w : obstacles){
            if (w.blocksPath(a,b)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void createObstacles() {
        this.obstacles = new ArrayList<>();
    }

    @Override
    public String getName() {
        return this.name ;
    }
}
