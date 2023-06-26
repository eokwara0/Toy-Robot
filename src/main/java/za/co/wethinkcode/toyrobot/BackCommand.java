package za.co.wethinkcode.toyrobot;

import za.co.wethinkcode.toyrobot.world.IWorld.*;

public class BackCommand extends Command {

    public BackCommand(String argument) {
        super("back", argument);
    }

    @Override
    public boolean execute(Robot target) {
        // initialization
        int nrSteps = Integer.parseInt(getArgument());
        UpdateResponse response = target.getWorld().updatePosition(-nrSteps);

        // Setting status
        if (response.equals(UpdateResponse.SUCCESS)){
            target.setStatus("Moved back by "+nrSteps+" steps.");
        }else if (response.equals(UpdateResponse.FAILED_OBSTRUCTED)){
            target.setStatus("Sorry, there is an obstacle in the way.");
        } else {
            target.setStatus("Sorry, I cannot go outside my safe zone.");
        }

        return true;

    }

}

