package za.co.wethinkcode.toyrobot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ForwardCommandTest {

    @Test
    void forwardOutOfBoundTest() {
        Robot robot = new Robot("nelly");
        robot.handleCommand(new ForwardCommand("203"));
        assertEquals("Sorry, I cannot go outside my safe zone.", robot.getStatus());
    }

    @Test
    void forward20Test() {
        Robot robot = new Robot("nelly");
        robot.handleCommand(new ForwardCommand("20"));
        assertEquals("Moved forward by 20 steps.", robot.getStatus());
    }
}