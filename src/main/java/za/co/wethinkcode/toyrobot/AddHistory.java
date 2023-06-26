package za.co.wethinkcode.toyrobot;


import java.util.Arrays;
import java.util.List;

public class AddHistory{
    private List<String> VALID_COMMANDS;
    private Command command;

    public AddHistory(Command command){
        this.command = command;
        VALID_COMMANDS = Arrays.asList("forward", "back", "left","right","sprint");
    }

    public void run (Robot target) {
        if (VALID_COMMANDS.contains(this.command.getName())){
            target.addHistory(this.command);
        }
    }
}
