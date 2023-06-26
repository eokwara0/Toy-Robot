package za.co.wethinkcode.toyrobot.maze;

import org.junit.jupiter.api.Test;
import za.co.wethinkcode.toyrobot.Position;

import static org.junit.jupiter.api.Assertions.*;

class SimpleMazeTest {


    @Test
    void getObstacles() {
        Maze simpleMaze  = new SimpleMaze();
        assertEquals(1, simpleMaze.getObstacles().size());
    }

    @Test
    void blocksPath() {
        Maze simpleMaze = new SimpleMaze();
        assertFalse(simpleMaze.blocksPath(new Position(2,0), new Position(0,5)));
    }

    @Test
    void getName() {
        assertEquals("simple", new SimpleMaze().getName());
    }
}