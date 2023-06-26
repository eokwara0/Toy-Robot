package za.co.wethinkcode.toyrobot.world;

import za.co.wethinkcode.toyrobot.Position;
import za.co.wethinkcode.toyrobot.maze.AbstractMaze;
import za.co.wethinkcode.toyrobot.maze.Maze;
import za.co.wethinkcode.toyrobot.Turtle.*;

import java.util.List;

public class TurtleWorld extends AbstractWorld{


    private Maze maze;
    private Turtle robot;

    public TurtleWorld(Maze maze){
        StdDraw.setCanvasSize(900,900);
        this.maze = maze;
        this.robot = new Turtle();
        this.robot.left(90);
        this.robot.speed(0);
        this.robot.penSize(0.5);

    }

    /**
     * Updates the position of your robot in the world by moving the nrSteps in the robots current direction.
     *
     * @param nrSteps steps to move in current direction
     * @return true if this does not take the robot over the world's limits, or into an obstacle.
     */
    @Override
    public UpdateResponse updatePosition(int nrSteps) {

        // newPositions
        int newX = getPosition().getX() ;
        int newY = getPosition().getY() ;

        // updating position

        if (Direction.UP.equals(getCurrentDirection())){
            newY = newY + nrSteps ;
        }else if (Direction.DOWN.equals(getCurrentDirection())){
            newY = newY - nrSteps ;
        }else if (Direction.RIGHT.equals(getCurrentDirection())){
            newX = newX + nrSteps ;
        }else if (Direction.LEFT.equals(getCurrentDirection())){
            newX = newX - nrSteps ;
        }

        // creating a new position
        Position nP = new Position(newX,newY);
        if(isNewPositionAllowed(nP)){
            if (this.maze.blocksPath(getPosition(), nP)){
                return UpdateResponse.FAILED_OBSTRUCTED;
            }else{
                this.position = nP;
                this.robot.goTo(this.position.getX(),this.position.getY());
                return UpdateResponse.SUCCESS;
            }
        }
        return UpdateResponse.FAILED_OUTSIDE_WORLD;
    }

    /**
     * Updates the current direction your robot is facing in the world by cycling through the directions UP, RIGHT, BOTTOM, LEFT.
     *
     * @param turnRight if true, then turn 90 degrees to the right, else turn left.
     */
    @Override
    public void updateDirection(boolean turnRight) {
        if (turnRight){
            this.robot.right(90);
        }else {
            this.robot.left(90);
        }
        if (Direction.UP.equals(getCurrentDirection())){
            this.currentDirection = turnRight ? Direction.RIGHT : Direction.LEFT ;
        }else if (Direction.RIGHT.equals(getCurrentDirection())){
            this.currentDirection = turnRight ? Direction.DOWN : Direction.UP ;
        }else if (Direction.DOWN.equals(getCurrentDirection())){
            this.currentDirection = turnRight ? Direction.LEFT : Direction.RIGHT ;
        }else if (Direction.LEFT.equals(getCurrentDirection())){
            this.currentDirection = turnRight ? Direction.UP : Direction.DOWN ;
        }
    }





    /**
     * Checks if the new position will be allowed, i.e. falls within the constraints of the world, and does not overlap an obstacle.
     *
     * @param position the position to check
     * @return true if it is allowed, else false
     */
    @Override
    public boolean isNewPositionAllowed(Position position) {

        return position.isIn(topLeft(),bottomRight());

    }



    /**
     * Reset the world by:
     * - moving current robot position to center 0,0 coordinate
     * - removing all obstacles
     * - setting current direction to UP
     */
    @Override
    public void reset() {

        this.position = CENTRE;
        this.currentDirection = Direction.UP;


    }

    /**
     * @return the list of obstacles, or an empty list if no obstacles exist.
     */
    @Override
    public List<Obstacle> getObstacles() {

        return this.maze.getObstacles();

    }

    /**
     * Gives opportunity to world to draw or list obstacles.
     */
    @Override
    public void showObstacles() {
        constraints();
        if (!this.maze.getName().equalsIgnoreCase("designed")){
            drawObstacles();
        } else {
            drawDesignedObstacles();
        }
        if (!this.maze.getObstacles().isEmpty()){
            System.out.println("There are some obstacles");
            for (Obstacle w : this.maze.getObstacles()){
                System.out.printf("- At position %d,%d (to %d,%d)\n",w.getBottomLeftX(),w.getBottomLeftY(), w.getBottomLeftX()+5, w.getBottomLeftY() + 5 );
            }
        }

    }

    public void drawObstacles(){
        List<Obstacle> obstacles = getObstacles();
        for(Obstacle obs : obstacles){
            this.robot.up();
            this.robot.goTo(obs.getBottomLeftX(), obs.getBottomLeftY());
            this.robot.down();
            for (int i : new int[]{1,2,3,4}){
                this.robot.forward(obs.getSize()-1);
                this.robot.right(90);
            }
            this.robot.up();
        }
        this.robot.home();
        this.robot.down();
        this.robot.penColor("red");
    }

    public  void drawDesignedObstacles(){
        List<Obstacle> obstacles = getObstacles();
        for(Obstacle obstacle : obstacles){
            this.robot.up();
            this.robot.goTo(obstacle.getBottomLeftX(), obstacle.getBottomLeftY());
            this.robot.down();
            this.robot.goTo(obstacle.getTopRightX(), obstacle.getTopRightY());
        }
        this.robot.up();
        this.robot.home();
        this.robot.down();
        this.robot.penColor("red");

    }


    public void constraints(){
        this.robot.up();
        this.robot.right(90);
        this.robot.goTo(this.TOP_LEFT.getX(), this.TOP_LEFT.getY());
        for(int sides : new int[]{200,400,200,400}){
            this.robot.down();
            this.robot.forward(sides);
            this.robot.right(90);
        }
        this.robot.up();
        this.robot.home();
        this.robot.down();
    }



}
