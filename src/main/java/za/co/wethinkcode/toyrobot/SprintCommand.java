package za.co.wethinkcode.toyrobot;

public class SprintCommand extends Command {

    public SprintCommand(String argument){
        super("sprint", argument);
    }


    @Override
    public boolean execute(Robot target) {
        int nrSteps = Integer.parseInt(getArgument());
        for (int num = nrSteps; num > 0; num --){
            Command forward = new ForwardCommand(String.valueOf(num));
            target.handleCommand(forward);
        }
        return true;
    }
}
