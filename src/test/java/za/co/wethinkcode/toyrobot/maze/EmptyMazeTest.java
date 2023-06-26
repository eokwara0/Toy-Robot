package za.co.wethinkcode.toyrobot.maze;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmptyMazeTest {

    @Test
    void getObstacles() {
        Maze emptyMaze = new EmptyMaze();
        assertEquals(0, emptyMaze.getObstacles().size());
    }

    @Test
    void getName() {
        assertEquals("empty", new EmptyMaze().getName());
    }
}