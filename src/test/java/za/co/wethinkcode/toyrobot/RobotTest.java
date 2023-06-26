package za.co.wethinkcode.toyrobot;

import za.co.wethinkcode.toyrobot.world.*;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RobotTest {

    @Test
    void initialPosition() {
        Robot robot = new Robot("CrashTestDummy");
        assertEquals(IWorld.CENTRE, robot.getWorld().getPosition());
        assertEquals(IWorld.Direction.UP, robot.getWorld().getCurrentDirection());
    }

    @Test
    void dump() {
        Robot robot = new Robot("CrashTestDummy");
        assertEquals("[0,0] CrashTestDummy> Ready", robot.toString());
    }

    @Test
    void shutdown() {
        Robot robot = new Robot("CrashTestDummy");
        ShutdownCommand command = new ShutdownCommand();
        assertFalse(robot.handleCommand(command));
    }

    @Test
    void forward() {
        Robot robot = new Robot("CrashTestDummy");
        ForwardCommand command = new ForwardCommand("10");
        assertTrue(robot.handleCommand(command));
        Position expectedPosition = new Position(IWorld.CENTRE.getX(), IWorld.CENTRE.getY() + 10);
        assertEquals(expectedPosition, robot.getWorld().getPosition());
        assertEquals("Moved forward by 10 steps.", robot.getStatus());
    }

    @Test
    void forwardforward() {
        Robot robot = new Robot("CrashTestDummy");
        assertTrue(robot.handleCommand(new ForwardCommand("10")));
        assertTrue(robot.handleCommand(new ForwardCommand("5")));
        assertEquals("Moved forward by 5 steps.", robot.getStatus());
    }

    @Test
    void tooFarForward() {
        Robot robot = new Robot("CrashTestDummy");
        assertTrue(robot.handleCommand(new ForwardCommand("1000")));
        assertEquals(IWorld.CENTRE, robot.getWorld().getPosition());
        assertEquals("Sorry, I cannot go outside my safe zone.", robot.getStatus());
    }

    @Test
    void help() {
        Robot robot = new Robot("CrashTestDummy");
        Command command = new HelpCommand();
        assertTrue(robot.handleCommand(command));
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
}