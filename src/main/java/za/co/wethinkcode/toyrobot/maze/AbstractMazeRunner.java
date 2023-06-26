package za.co.wethinkcode.toyrobot.maze;
import za.co.wethinkcode.toyrobot.Command;
import za.co.wethinkcode.toyrobot.Robot;
import za.co.wethinkcode.toyrobot.world.IWorld;

import java.util.List;

public abstract class AbstractMazeRunner extends Command implements MazeRunner{

    private Robot robot ;
    private IWorld.Direction edgeDirection ;
    private String name ;

    public AbstractMazeRunner(Robot robot , IWorld.Direction edgeDirection,String name){
        super("mazerun");
        this.robot = robot ;
        this.name = name ;
        this.edgeDirection = edgeDirection ;
    }

    public boolean execute(Robot target) {
        mazeRun(this.robot, this.edgeDirection);
        return true;
    }

    public static AbstractMazeRunner create(Robot robot , String instructions){
        IWorld.Direction direction = handleInstructions(instructions);
        List<String> mazes = List.of("empty","random","simple","designed");
        if (robot.getMaze() == null || mazes.contains(robot.getMaze().getName())){
            return new defaultMazeRunner(robot, direction);
        }
        return null ;
    }

    public static IWorld.Direction handleInstructions(String instructions){
        String[] args = instructions.split(" ");
        if (args.length == 1 ){
            return IWorld.Direction.UP;
        }else if (args.length > 1){
            if (args[1].equalsIgnoreCase("top")){
                return IWorld.Direction.UP;
            }else if (args[1].equalsIgnoreCase("bottom")){
                return IWorld.Direction.DOWN ;
            }else if (args[1].equalsIgnoreCase("right")){
                return IWorld.Direction.RIGHT;
            }else if (args[1].equalsIgnoreCase("left")){
                return IWorld.Direction.LEFT;
            }
        }
        return IWorld.Direction.UP;
    }

}
