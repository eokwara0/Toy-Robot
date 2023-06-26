package za.co.wethinkcode.toyrobot.maze;

import za.co.wethinkcode.toyrobot.Position;
import za.co.wethinkcode.toyrobot.world.Obstacle;
import za.co.wethinkcode.toyrobot.world.SquareObstacle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SimpleMaze extends AbstractMaze{



    private List<Obstacle> obstacles ;
    private String name ;
    public SimpleMaze(){
        this.name = "simple" ;
        createObstacles();
    }

    @Override
    public void createObstacles() {

        List<Obstacle> obsta = new ArrayList<>();
        obsta.add(new SquareObstacle(1,1));
        this.obstacles = obsta;

    }

    @Override
    public List<Obstacle> getObstacles() {
        return this.obstacles;
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
    public String getName() {
        return this.name ;
    }
}
