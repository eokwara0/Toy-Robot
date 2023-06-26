package za.co.wethinkcode.toyrobot;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class PlayTest {

    @Test
    void main() {

        // inputStream
        InputStream stream = new ByteArrayInputStream("nelly\nforward 10\nright\nforward 99\nmazerun right\noff".getBytes());
        System.setIn(stream);

        // outStream
        ByteArrayOutputStream captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));

        Play.main(new String[]{"text", "EmptyMaze"});


        assertEquals("What do you want to name your robot?\n" +
                "Hello Kiddo!\n" +
                "Loaded EmptyMaze\n" +
                "nelly> What must I do next?\n" +
                "[0,10] nelly> Moved forward by 10 steps.\n" +
                "nelly> What must I do next?\n" +
                "[0,10] nelly> Turned right.\n" +
                "nelly> What must I do next?\n" +
                "[99,10] nelly> Moved forward by 99 steps.\n" +
                "nelly> What must I do next?\n" +
                "[100,10] nelly> Moved forward by 1 steps.\n" +
                "[100,10] nelly> I am at the right edge. (Cost: 1 steps)\n" +
                "nelly> What must I do next?\n" +
                "[100,10] nelly> Shutting down...",captor.toString().trim() );
    }
}