package za.co.wethinkcode.toyrobot;

public class HelpCommand extends Command {

    public HelpCommand() {
        super("help");
    }

    @Override
    public boolean execute(Robot target) {
        target.setStatus("I can understand these commands:\n" +
                "OFF  - Shut down robot\n" +
                "HELP - provide information about commands\n" +
                "FORWARD - move forward by specified number of steps, e.g. 'FORWARD 10'\n"+"" +
                "BACK - move back by specified number of steps, e.g. 'BACK 20'\n"+
                "SPRINT - move's recursively by specified number of steps, e.g. 'SPRINT 3'"+
                "LEFT - turns the robot to the left.\n"+
                "RIGHT - turns the robot to the right.\n"+
                "REPLAY - replays previous commands as specified by the range or number e.g. REPLAY 2 , REPLAY 4-2 , REPLAY REVERSED.");
        return true;
    }
}
