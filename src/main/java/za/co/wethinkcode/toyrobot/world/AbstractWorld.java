package za.co.wethinkcode.toyrobot.world;

import za.co.wethinkcode.toyrobot.Position;
import za.co.wethinkcode.toyrobot.maze.Maze;

import java.util.List;

public  abstract class AbstractWorld implements IWorld{




    protected final Position TOP_LEFT = new Position(-100,200); // TOP_LEFT POSITION
    protected final Position BOTTOM_RIGHT = new Position(100,-200); // BOTTOM_RIGHT POSITION


    protected Position position; // ROBOT POSITION
    protected Direction currentDirection; // ROBOT CURRENT DIRECTION

    public AbstractWorld(){
        this.position = CENTRE;
        this.currentDirection = Direction.UP;
    }


    public static AbstractWorld create(String world , Maze maze){
        switch (world){

            case "text":
                return new TextWorld(maze);

            case "turtle":
                return new TurtleWorld(maze);

            default:
                throw new IllegalArgumentException("unsupported world argument "+world);
        }
    }



    @Override
    public boolean isAtEdge() {

        if (topLeft().getX() < getPosition().getX() && getPosition().getX()
                < bottomRight().getX() && getPosition().getY() == topLeft().getY()){
            return true;
        }else if (topLeft().getX() < getPosition().getX() && getPosition().getX()
                < bottomRight().getX() && getPosition().getY() == bottomRight().getY()){
            return true;
        }else if (getPosition().getY() > bottomRight().getY() && getPosition().getY()
                < topLeft().getY() && getPosition().getX() == topLeft().getX()){
            return true ;
        }else if (getPosition().getY() > bottomRight().getY() && getPosition().getY()
                < topLeft().getY() && getPosition().getX() == bottomRight().getX()){
            return true ;
        }
        return false;
    }

    /**
     * Retrieves the current position of the robot
     */
    @Override
    public Position getPosition() {
        return this.position;
    }

    /**
     * Gets the current direction the robot is facing in relation to a world edge.
     *
     * @return Direction.UP, RIGHT, DOWN, or LEFT
     */
    @Override
    public Direction getCurrentDirection() {
        return this.currentDirection ;
    }


    @Override
    public boolean atTopEdge(){
        return (topLeft().getX() <= getPosition().getX() && getPosition().getX()
                <= bottomRight().getX() && getPosition().getY() == topLeft().getY());
    }

    @Override
    public boolean atBottomEdge(){
        return (topLeft().getX() <= getPosition().getX() && getPosition().getX()
                <= bottomRight().getX() && getPosition().getY() == bottomRight().getY());
    }

    @Override
    public boolean atRightEdge(){
        return (getPosition().getY() >= bottomRight().getY() && getPosition().getY()
                <= topLeft().getY() && getPosition().getX() == bottomRight().getX());
    }

    @Override
    public boolean atLeftEdge(){
        return (getPosition().getY() >= bottomRight().getY() && getPosition().getY()
                <= topLeft().getY() && getPosition().getX() == topLeft().getX());
    }

    public Position topLeft(){
        return this.TOP_LEFT;
    }
    public Position bottomRight(){
        return this.BOTTOM_RIGHT;
    }

}
