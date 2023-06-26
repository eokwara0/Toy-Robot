package za.co.wethinkcode.toyrobot.maze;

import za.co.wethinkcode.toyrobot.Position;
import za.co.wethinkcode.toyrobot.world.Obstacle;
import za.co.wethinkcode.toyrobot.world.SquareObstacle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomMaze extends AbstractMaze{



    private final Position TOP_LEFT = new Position(-100,200); // TOP_LEFT POSITION
    private final Position BOTTOM_RIGHT = new Position(100,-200);

    private List<Obstacle> obstacles;

    private String name;

    public RandomMaze(){
        this.name =  "random";
        createObstacles();
    }


    @Override
    public void createObstacles() {

        List<Obstacle> obstacles = new ArrayList<>();
        Random random = new Random();

        for (int i = random.nextInt(20); i > 0 ; i--){
            int negX = random.nextBoolean() ? 1 : -1 ;
            int obsX = random.nextInt(BOTTOM_RIGHT.getX()) * negX;

            int negY = random.nextBoolean() ? 1 : -1;
            int obsY = random.nextInt(TOP_LEFT.getY()) * negY ;
            obstacles.add(new SquareObstacle(obsX,obsY));
        }
        this.obstacles = obstacles;

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
