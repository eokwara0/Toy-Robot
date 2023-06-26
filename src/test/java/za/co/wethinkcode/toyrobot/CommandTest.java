package za.co.wethinkcode.toyrobot;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandTest {

    @Test
    void getShutdownName() {
        Command test = new ShutdownCommand();
        assertEquals("off", test.getName());
    }

    @Test
    void executeShutdown() {
        Robot robot = new Robot("CrashTestDummy");
        Command shutdown = Command.create("shutdown",robot);
        assertFalse(shutdown.execute(robot));
        assertEquals("Shutting down...", robot.getStatus());
    }

    @Test
    void getForwardName() {
        ForwardCommand test = new ForwardCommand("100");
        assertEquals("forward", test.getName());
        assertEquals("100", test.getArgument());
    }

    @Test
    void executeForward() {
        Robot robot = new Robot("CrashTestDummy");
        Command forward100 = Command.create("forward 10",robot);
        assertTrue(forward100.execute(robot));
        Position expectedPosition = new Position(0, 0 + 10);
        assertEquals(expectedPosition, robot.getWorld().getPosition());
        assertEquals("Moved forward by 10 steps.", robot.getStatus());
    }

    @Test
    void getHelpName() {
        Command test = new HelpCommand();                                                               //<1>
        assertEquals("help", test.getName());
    }

    @Test
    void executeHelp() {
        Robot robot = new Robot("CrashTestDummy");
        Command help = Command.create("help",robot);
        assertTrue(help.execute(robot));
        assertEquals("I can understand these commands:\n" +
                "OFF  - Shut down robot\n" +
                "HELP - provide information about commands\n" +
                "FORWARD - move forward by specified number of steps, e.g. 'FORWARD 10'\n"+"" +
                "BACK - move back by specified number of steps, e.g. 'BACK 20'\n"+
                "SPRINT - move's recursively by specified number of steps, e.g. 'SPRINT 3'"+
                "LEFT - turns the robot to the left.\n"+
                "RIGHT - turns the robot to the right.\n"+
                "REPLAY - replays previous commands as specified by the range or number e.g. REPLAY 2 , REPLAY 4-2 , REPLAY REVERSED.", robot.getStatus());
    }

    @Test
    void createCommand() {
        Robot robot = new Robot("JSmash");
        Command forward = Command.create("forward 10",robot);                                                 //<1>
        assertEquals("forward", forward.getName());
        assertEquals("10", forward.getArgument());

        Command shutdown = Command.create("shutdown",robot);                                                  //<2>
        assertEquals("off", shutdown.getName());

        Command help = Command.create("help",robot);                                                          //<3>
        assertEquals("help", help.getName());
    }

    @Test
    void createInvalidCommand() {
        try {
            Command forward = Command.create("say hello", new Robot("Jsmash"));                                              //<4>
            fail("Should have thrown an exception");                                                    //<5>
        } catch (IllegalArgumentException e) {
            assertEquals("Unsupported command: say hello", e.getMessage());                             //<6>
        }
    }
}
