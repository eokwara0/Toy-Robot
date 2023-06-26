package za.co.wethinkcode.toyrobot.world;

import za.co.wethinkcode.toyrobot.Position;
import za.co.wethinkcode.toyrobot.maze.AbstractMaze;
import za.co.wethinkcode.toyrobot.maze.Maze;

import java.util.List;

public class TextWorld extends AbstractWorld{




    private Maze maze;

    public TextWorld(Maze maze){
        this.maze = maze;
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
        if ((!this.maze.getObstacles().isEmpty()) && !this.maze.getName().equalsIgnoreCase("designed")){
            System.out.println("There are some obstacles");
            for (Obstacle w : this.maze.getObstacles()){
                System.out.printf("- At position %d,%d (to %d,%d)\n",w.getBottomLeftX(),w.getBottomLeftY(), w.getBottomLeftX()+5, w.getBottomLeftY() + 5 );
            }
        }else if((!this.maze.getObstacles().isEmpty()) && this.maze.getName().equalsIgnoreCase("designed")){
            System.out.println("There are some obstacles");
            for (Obstacle w : this.maze.getObstacles()){
                System.out.printf("- At position %d,%d (to %d,%d)\n",w.getBottomLeftX(),w.getBottomLeftY(), w.getTopRightX(), w.getTopRightY());
            }
        }

    }

    public void showDesignedMaze(){

    }



}
