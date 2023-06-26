package za.co.wethinkcode.toyrobot.maze;

import za.co.wethinkcode.toyrobot.*;
import za.co.wethinkcode.toyrobot.world.IWorld;

import java.util.Random;

public class defaultMazeRunner extends AbstractMazeRunner{



    IWorld.Direction edgeDirection;
    int runGameCost = 0;
    public defaultMazeRunner(Robot robot,IWorld.Direction edgeDirection) {
        super(robot, edgeDirection,"default");

    }

    /**
     * Asks Mazerunner to start its mazerun.
     *
     * @param target        the instance of Robot to use to run the maze
     * @param edgeDirection the edge to try and reach, one of Direction.UP, RIGHT, DOWN, or LEFT
     * @return true if it was successful
     */
    @Override
    public boolean mazeRun(Robot target, IWorld.Direction edgeDirection) {
        mazeRunAll(target,edgeDirection);
        return true ;
    }

    /**
     * Returns the cost for the previous mazerun attempt:
     * <p>
     * - Each command that involves moving 1 or more steps must count the number of steps taken in that command towards the total steps.
     * - Each time your robot turns, it also counts as 1 step.
     * - Commands that fails because it is blocked by an obstacle or an edge must also count the steps involved in the command towards the total number of steps.
     *
     * @return the total cost in steps of most recent mazerun
     */
    @Override
    public int getMazeRunCost() {
        return this.runGameCost;
    }

    public void mazeRunAll(Robot target , IWorld.Direction direction){
        while(true){
            Position initialPosition = target.getWorld().getPosition();
            IWorld.Direction initialDirection = target.getWorld().getCurrentDirection();

            if (initialDirection.equals(direction) &&  checkDirection(target,direction)){
                target.setStatus("I am at the "+ edge(direction) + " edge. (Cost: "+runGameCost+" steps)");
                break;

            }else if (initialDirection.equals(direction)){
                Command command = Command.create("forward 1",target);
                target.handleCommand(command);
                Position newPosition = target.getWorld().getPosition();
                if (initialPosition.equals(newPosition)){
                    boolean handled = new Random().nextBoolean() ? target.handleCommand(new LeftCommand())
                            : target.handleCommand(new RightCommand());
                    target.handleCommand(new ForwardCommand("3"));
                    target.handleCommand(new ForwardCommand("3"));
                }else{
                    initialPosition = newPosition ;
                }
            }else if (!initialDirection.equals(direction)){
                boolean handled = new Random().nextBoolean() ? target.handleCommand(new RightCommand()) : target.handleCommand(new LeftCommand());
                target.handleCommand(new ForwardCommand("3"));
                target.handleCommand(new ForwardCommand("3"));

            }
            runGameCost ++;

        }

    }

    public boolean checkDirection(Robot target, IWorld.Direction direction){
        if (direction.equals(IWorld.Direction.UP)){
            return target.getWorld().atTopEdge();
        }else if (direction.equals(IWorld.Direction.RIGHT)){
            return target.getWorld().atRightEdge();
        }else if (direction.equals(IWorld.Direction.DOWN)){
            return target.getWorld().atBottomEdge();
        }else if (direction.equals(IWorld.Direction.LEFT)){
            return target.getWorld().atLeftEdge();
        }
        return true;
    }

    public String edge(IWorld.Direction direction){
        if (direction.equals(IWorld.Direction.UP)){
            return "top" ;
        }else if (direction.equals(IWorld.Direction.RIGHT)){
            return "right" ;
        }else if (direction.equals(IWorld.Direction.DOWN)){
            return "bottom" ;
        }else if (direction.equals(IWorld.Direction.LEFT)){
            return "left" ;
        }
        return "";
    }

}
