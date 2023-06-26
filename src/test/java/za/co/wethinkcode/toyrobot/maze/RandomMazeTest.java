package za.co.wethinkcode.toyrobot.maze;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomMazeTest {

    @Test
    void getName() {
        assertEquals("random", new RandomMaze().getName());
    }
}