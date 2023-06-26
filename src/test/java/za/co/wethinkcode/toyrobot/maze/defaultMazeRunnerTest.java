package za.co.wethinkcode.toyrobot.maze;

import org.junit.jupiter.api.Test;
import za.co.wethinkcode.toyrobot.Command;
import za.co.wethinkcode.toyrobot.Play;
import za.co.wethinkcode.toyrobot.Robot;
import za.co.wethinkcode.toyrobot.world.IWorld;
import za.co.wethinkcode.toyrobot.world.TextWorld;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class defaultMazeRunnerTest {

    @Test
    void mazeRun() {

        // setting input stream
        byte[] stream = "Hal\nmazerun\noff".getBytes();
        InputStream stream1 = new ByteArrayInputStream(stream);
        System.setIn(stream1);


        //setting output stream

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        //runGame
        Play.main(new String[] {"text","SimpleMaze"});

        assertEquals("What do you want to name your robot?\n" +
                "Hello Kiddo!\n" +
                "Loaded SimpleMaze\n" +
                "There are some obstacles\n" +
                "- At position 1,1 (to 6,6)\n" +
                "Hal> What must I do next?\n" +
                "[0,1] Hal> Moved forward by 1 steps.\n" +
                "[0,2] Hal> Moved forward by 1 steps.\n" +
                "[0,3] Hal> Moved forward by 1 steps.\n" +
                "[0,4] Hal> Moved forward by 1 steps.\n" +
                "[0,5] Hal> Moved forward by 1 steps.\n" +
                "[0,6] Hal> Moved forward by 1 steps.\n" +
                "[0,7] Hal> Moved forward by 1 steps.\n" +
                "[0,8] Hal> Moved forward by 1 steps.\n" +
                "[0,9] Hal> Moved forward by 1 steps.\n" +
                "[0,10] Hal> Moved forward by 1 steps.\n" +
                "[0,11] Hal> Moved forward by 1 steps.\n" +
                "[0,12] Hal> Moved forward by 1 steps.\n" +
                "[0,13] Hal> Moved forward by 1 steps.\n" +
                "[0,14] Hal> Moved forward by 1 steps.\n" +
                "[0,15] Hal> Moved forward by 1 steps.\n" +
                "[0,16] Hal> Moved forward by 1 steps.\n" +
                "[0,17] Hal> Moved forward by 1 steps.\n" +
                "[0,18] Hal> Moved forward by 1 steps.\n" +
                "[0,19] Hal> Moved forward by 1 steps.\n" +
                "[0,20] Hal> Moved forward by 1 steps.\n" +
                "[0,21] Hal> Moved forward by 1 steps.\n" +
                "[0,22] Hal> Moved forward by 1 steps.\n" +
                "[0,23] Hal> Moved forward by 1 steps.\n" +
                "[0,24] Hal> Moved forward by 1 steps.\n" +
                "[0,25] Hal> Moved forward by 1 steps.\n" +
                "[0,26] Hal> Moved forward by 1 steps.\n" +
                "[0,27] Hal> Moved forward by 1 steps.\n" +
                "[0,28] Hal> Moved forward by 1 steps.\n" +
                "[0,29] Hal> Moved forward by 1 steps.\n" +
                "[0,30] Hal> Moved forward by 1 steps.\n" +
                "[0,31] Hal> Moved forward by 1 steps.\n" +
                "[0,32] Hal> Moved forward by 1 steps.\n" +
                "[0,33] Hal> Moved forward by 1 steps.\n" +
                "[0,34] Hal> Moved forward by 1 steps.\n" +
                "[0,35] Hal> Moved forward by 1 steps.\n" +
                "[0,36] Hal> Moved forward by 1 steps.\n" +
                "[0,37] Hal> Moved forward by 1 steps.\n" +
                "[0,38] Hal> Moved forward by 1 steps.\n" +
                "[0,39] Hal> Moved forward by 1 steps.\n" +
                "[0,40] Hal> Moved forward by 1 steps.\n" +
                "[0,41] Hal> Moved forward by 1 steps.\n" +
                "[0,42] Hal> Moved forward by 1 steps.\n" +
                "[0,43] Hal> Moved forward by 1 steps.\n" +
                "[0,44] Hal> Moved forward by 1 steps.\n" +
                "[0,45] Hal> Moved forward by 1 steps.\n" +
                "[0,46] Hal> Moved forward by 1 steps.\n" +
                "[0,47] Hal> Moved forward by 1 steps.\n" +
                "[0,48] Hal> Moved forward by 1 steps.\n" +
                "[0,49] Hal> Moved forward by 1 steps.\n" +
                "[0,50] Hal> Moved forward by 1 steps.\n" +
                "[0,51] Hal> Moved forward by 1 steps.\n" +
                "[0,52] Hal> Moved forward by 1 steps.\n" +
                "[0,53] Hal> Moved forward by 1 steps.\n" +
                "[0,54] Hal> Moved forward by 1 steps.\n" +
                "[0,55] Hal> Moved forward by 1 steps.\n" +
                "[0,56] Hal> Moved forward by 1 steps.\n" +
                "[0,57] Hal> Moved forward by 1 steps.\n" +
                "[0,58] Hal> Moved forward by 1 steps.\n" +
                "[0,59] Hal> Moved forward by 1 steps.\n" +
                "[0,60] Hal> Moved forward by 1 steps.\n" +
                "[0,61] Hal> Moved forward by 1 steps.\n" +
                "[0,62] Hal> Moved forward by 1 steps.\n" +
                "[0,63] Hal> Moved forward by 1 steps.\n" +
                "[0,64] Hal> Moved forward by 1 steps.\n" +
                "[0,65] Hal> Moved forward by 1 steps.\n" +
                "[0,66] Hal> Moved forward by 1 steps.\n" +
                "[0,67] Hal> Moved forward by 1 steps.\n" +
                "[0,68] Hal> Moved forward by 1 steps.\n" +
                "[0,69] Hal> Moved forward by 1 steps.\n" +
                "[0,70] Hal> Moved forward by 1 steps.\n" +
                "[0,71] Hal> Moved forward by 1 steps.\n" +
                "[0,72] Hal> Moved forward by 1 steps.\n" +
                "[0,73] Hal> Moved forward by 1 steps.\n" +
                "[0,74] Hal> Moved forward by 1 steps.\n" +
                "[0,75] Hal> Moved forward by 1 steps.\n" +
                "[0,76] Hal> Moved forward by 1 steps.\n" +
                "[0,77] Hal> Moved forward by 1 steps.\n" +
                "[0,78] Hal> Moved forward by 1 steps.\n" +
                "[0,79] Hal> Moved forward by 1 steps.\n" +
                "[0,80] Hal> Moved forward by 1 steps.\n" +
                "[0,81] Hal> Moved forward by 1 steps.\n" +
                "[0,82] Hal> Moved forward by 1 steps.\n" +
                "[0,83] Hal> Moved forward by 1 steps.\n" +
                "[0,84] Hal> Moved forward by 1 steps.\n" +
                "[0,85] Hal> Moved forward by 1 steps.\n" +
                "[0,86] Hal> Moved forward by 1 steps.\n" +
                "[0,87] Hal> Moved forward by 1 steps.\n" +
                "[0,88] Hal> Moved forward by 1 steps.\n" +
                "[0,89] Hal> Moved forward by 1 steps.\n" +
                "[0,90] Hal> Moved forward by 1 steps.\n" +
                "[0,91] Hal> Moved forward by 1 steps.\n" +
                "[0,92] Hal> Moved forward by 1 steps.\n" +
                "[0,93] Hal> Moved forward by 1 steps.\n" +
                "[0,94] Hal> Moved forward by 1 steps.\n" +
                "[0,95] Hal> Moved forward by 1 steps.\n" +
                "[0,96] Hal> Moved forward by 1 steps.\n" +
                "[0,97] Hal> Moved forward by 1 steps.\n" +
                "[0,98] Hal> Moved forward by 1 steps.\n" +
                "[0,99] Hal> Moved forward by 1 steps.\n" +
                "[0,100] Hal> Moved forward by 1 steps.\n" +
                "[0,101] Hal> Moved forward by 1 steps.\n" +
                "[0,102] Hal> Moved forward by 1 steps.\n" +
                "[0,103] Hal> Moved forward by 1 steps.\n" +
                "[0,104] Hal> Moved forward by 1 steps.\n" +
                "[0,105] Hal> Moved forward by 1 steps.\n" +
                "[0,106] Hal> Moved forward by 1 steps.\n" +
                "[0,107] Hal> Moved forward by 1 steps.\n" +
                "[0,108] Hal> Moved forward by 1 steps.\n" +
                "[0,109] Hal> Moved forward by 1 steps.\n" +
                "[0,110] Hal> Moved forward by 1 steps.\n" +
                "[0,111] Hal> Moved forward by 1 steps.\n" +
                "[0,112] Hal> Moved forward by 1 steps.\n" +
                "[0,113] Hal> Moved forward by 1 steps.\n" +
                "[0,114] Hal> Moved forward by 1 steps.\n" +
                "[0,115] Hal> Moved forward by 1 steps.\n" +
                "[0,116] Hal> Moved forward by 1 steps.\n" +
                "[0,117] Hal> Moved forward by 1 steps.\n" +
                "[0,118] Hal> Moved forward by 1 steps.\n" +
                "[0,119] Hal> Moved forward by 1 steps.\n" +
                "[0,120] Hal> Moved forward by 1 steps.\n" +
                "[0,121] Hal> Moved forward by 1 steps.\n" +
                "[0,122] Hal> Moved forward by 1 steps.\n" +
                "[0,123] Hal> Moved forward by 1 steps.\n" +
                "[0,124] Hal> Moved forward by 1 steps.\n" +
                "[0,125] Hal> Moved forward by 1 steps.\n" +
                "[0,126] Hal> Moved forward by 1 steps.\n" +
                "[0,127] Hal> Moved forward by 1 steps.\n" +
                "[0,128] Hal> Moved forward by 1 steps.\n" +
                "[0,129] Hal> Moved forward by 1 steps.\n" +
                "[0,130] Hal> Moved forward by 1 steps.\n" +
                "[0,131] Hal> Moved forward by 1 steps.\n" +
                "[0,132] Hal> Moved forward by 1 steps.\n" +
                "[0,133] Hal> Moved forward by 1 steps.\n" +
                "[0,134] Hal> Moved forward by 1 steps.\n" +
                "[0,135] Hal> Moved forward by 1 steps.\n" +
                "[0,136] Hal> Moved forward by 1 steps.\n" +
                "[0,137] Hal> Moved forward by 1 steps.\n" +
                "[0,138] Hal> Moved forward by 1 steps.\n" +
                "[0,139] Hal> Moved forward by 1 steps.\n" +
                "[0,140] Hal> Moved forward by 1 steps.\n" +
                "[0,141] Hal> Moved forward by 1 steps.\n" +
                "[0,142] Hal> Moved forward by 1 steps.\n" +
                "[0,143] Hal> Moved forward by 1 steps.\n" +
                "[0,144] Hal> Moved forward by 1 steps.\n" +
                "[0,145] Hal> Moved forward by 1 steps.\n" +
                "[0,146] Hal> Moved forward by 1 steps.\n" +
                "[0,147] Hal> Moved forward by 1 steps.\n" +
                "[0,148] Hal> Moved forward by 1 steps.\n" +
                "[0,149] Hal> Moved forward by 1 steps.\n" +
                "[0,150] Hal> Moved forward by 1 steps.\n" +
                "[0,151] Hal> Moved forward by 1 steps.\n" +
                "[0,152] Hal> Moved forward by 1 steps.\n" +
                "[0,153] Hal> Moved forward by 1 steps.\n" +
                "[0,154] Hal> Moved forward by 1 steps.\n" +
                "[0,155] Hal> Moved forward by 1 steps.\n" +
                "[0,156] Hal> Moved forward by 1 steps.\n" +
                "[0,157] Hal> Moved forward by 1 steps.\n" +
                "[0,158] Hal> Moved forward by 1 steps.\n" +
                "[0,159] Hal> Moved forward by 1 steps.\n" +
                "[0,160] Hal> Moved forward by 1 steps.\n" +
                "[0,161] Hal> Moved forward by 1 steps.\n" +
                "[0,162] Hal> Moved forward by 1 steps.\n" +
                "[0,163] Hal> Moved forward by 1 steps.\n" +
                "[0,164] Hal> Moved forward by 1 steps.\n" +
                "[0,165] Hal> Moved forward by 1 steps.\n" +
                "[0,166] Hal> Moved forward by 1 steps.\n" +
                "[0,167] Hal> Moved forward by 1 steps.\n" +
                "[0,168] Hal> Moved forward by 1 steps.\n" +
                "[0,169] Hal> Moved forward by 1 steps.\n" +
                "[0,170] Hal> Moved forward by 1 steps.\n" +
                "[0,171] Hal> Moved forward by 1 steps.\n" +
                "[0,172] Hal> Moved forward by 1 steps.\n" +
                "[0,173] Hal> Moved forward by 1 steps.\n" +
                "[0,174] Hal> Moved forward by 1 steps.\n" +
                "[0,175] Hal> Moved forward by 1 steps.\n" +
                "[0,176] Hal> Moved forward by 1 steps.\n" +
                "[0,177] Hal> Moved forward by 1 steps.\n" +
                "[0,178] Hal> Moved forward by 1 steps.\n" +
                "[0,179] Hal> Moved forward by 1 steps.\n" +
                "[0,180] Hal> Moved forward by 1 steps.\n" +
                "[0,181] Hal> Moved forward by 1 steps.\n" +
                "[0,182] Hal> Moved forward by 1 steps.\n" +
                "[0,183] Hal> Moved forward by 1 steps.\n" +
                "[0,184] Hal> Moved forward by 1 steps.\n" +
                "[0,185] Hal> Moved forward by 1 steps.\n" +
                "[0,186] Hal> Moved forward by 1 steps.\n" +
                "[0,187] Hal> Moved forward by 1 steps.\n" +
                "[0,188] Hal> Moved forward by 1 steps.\n" +
                "[0,189] Hal> Moved forward by 1 steps.\n" +
                "[0,190] Hal> Moved forward by 1 steps.\n" +
                "[0,191] Hal> Moved forward by 1 steps.\n" +
                "[0,192] Hal> Moved forward by 1 steps.\n" +
                "[0,193] Hal> Moved forward by 1 steps.\n" +
                "[0,194] Hal> Moved forward by 1 steps.\n" +
                "[0,195] Hal> Moved forward by 1 steps.\n" +
                "[0,196] Hal> Moved forward by 1 steps.\n" +
                "[0,197] Hal> Moved forward by 1 steps.\n" +
                "[0,198] Hal> Moved forward by 1 steps.\n" +
                "[0,199] Hal> Moved forward by 1 steps.\n" +
                "[0,200] Hal> Moved forward by 1 steps.\n" +
                "[0,200] Hal> I am at the top edge. (Cost: 200 steps)\n" +
                "Hal> What must I do next?\n" +
                "[0,200] Hal> Shutting down...", outputStream.toString().trim());
    }


    @Test
    void mazeRunTop() {
        // setting input stream
        byte[] stream = "Hal\nmazerun top\noff".getBytes();
        InputStream stream1 = new ByteArrayInputStream(stream);
        System.setIn(stream1);


        //setting output stream

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        //runGame
        Play.main(new String[] {"text","SimpleMaze"});
        assertEquals("What do you want to name your robot?\n" +
                "Hello Kiddo!\n" +
                "Loaded SimpleMaze\n" +
                "There are some obstacles\n" +
                "- At position 1,1 (to 6,6)\n" +
                "Hal> What must I do next?\n" +
                "[0,1] Hal> Moved forward by 1 steps.\n" +
                "[0,2] Hal> Moved forward by 1 steps.\n" +
                "[0,3] Hal> Moved forward by 1 steps.\n" +
                "[0,4] Hal> Moved forward by 1 steps.\n" +
                "[0,5] Hal> Moved forward by 1 steps.\n" +
                "[0,6] Hal> Moved forward by 1 steps.\n" +
                "[0,7] Hal> Moved forward by 1 steps.\n" +
                "[0,8] Hal> Moved forward by 1 steps.\n" +
                "[0,9] Hal> Moved forward by 1 steps.\n" +
                "[0,10] Hal> Moved forward by 1 steps.\n" +
                "[0,11] Hal> Moved forward by 1 steps.\n" +
                "[0,12] Hal> Moved forward by 1 steps.\n" +
                "[0,13] Hal> Moved forward by 1 steps.\n" +
                "[0,14] Hal> Moved forward by 1 steps.\n" +
                "[0,15] Hal> Moved forward by 1 steps.\n" +
                "[0,16] Hal> Moved forward by 1 steps.\n" +
                "[0,17] Hal> Moved forward by 1 steps.\n" +
                "[0,18] Hal> Moved forward by 1 steps.\n" +
                "[0,19] Hal> Moved forward by 1 steps.\n" +
                "[0,20] Hal> Moved forward by 1 steps.\n" +
                "[0,21] Hal> Moved forward by 1 steps.\n" +
                "[0,22] Hal> Moved forward by 1 steps.\n" +
                "[0,23] Hal> Moved forward by 1 steps.\n" +
                "[0,24] Hal> Moved forward by 1 steps.\n" +
                "[0,25] Hal> Moved forward by 1 steps.\n" +
                "[0,26] Hal> Moved forward by 1 steps.\n" +
                "[0,27] Hal> Moved forward by 1 steps.\n" +
                "[0,28] Hal> Moved forward by 1 steps.\n" +
                "[0,29] Hal> Moved forward by 1 steps.\n" +
                "[0,30] Hal> Moved forward by 1 steps.\n" +
                "[0,31] Hal> Moved forward by 1 steps.\n" +
                "[0,32] Hal> Moved forward by 1 steps.\n" +
                "[0,33] Hal> Moved forward by 1 steps.\n" +
                "[0,34] Hal> Moved forward by 1 steps.\n" +
                "[0,35] Hal> Moved forward by 1 steps.\n" +
                "[0,36] Hal> Moved forward by 1 steps.\n" +
                "[0,37] Hal> Moved forward by 1 steps.\n" +
                "[0,38] Hal> Moved forward by 1 steps.\n" +
                "[0,39] Hal> Moved forward by 1 steps.\n" +
                "[0,40] Hal> Moved forward by 1 steps.\n" +
                "[0,41] Hal> Moved forward by 1 steps.\n" +
                "[0,42] Hal> Moved forward by 1 steps.\n" +
                "[0,43] Hal> Moved forward by 1 steps.\n" +
                "[0,44] Hal> Moved forward by 1 steps.\n" +
                "[0,45] Hal> Moved forward by 1 steps.\n" +
                "[0,46] Hal> Moved forward by 1 steps.\n" +
                "[0,47] Hal> Moved forward by 1 steps.\n" +
                "[0,48] Hal> Moved forward by 1 steps.\n" +
                "[0,49] Hal> Moved forward by 1 steps.\n" +
                "[0,50] Hal> Moved forward by 1 steps.\n" +
                "[0,51] Hal> Moved forward by 1 steps.\n" +
                "[0,52] Hal> Moved forward by 1 steps.\n" +
                "[0,53] Hal> Moved forward by 1 steps.\n" +
                "[0,54] Hal> Moved forward by 1 steps.\n" +
                "[0,55] Hal> Moved forward by 1 steps.\n" +
                "[0,56] Hal> Moved forward by 1 steps.\n" +
                "[0,57] Hal> Moved forward by 1 steps.\n" +
                "[0,58] Hal> Moved forward by 1 steps.\n" +
                "[0,59] Hal> Moved forward by 1 steps.\n" +
                "[0,60] Hal> Moved forward by 1 steps.\n" +
                "[0,61] Hal> Moved forward by 1 steps.\n" +
                "[0,62] Hal> Moved forward by 1 steps.\n" +
                "[0,63] Hal> Moved forward by 1 steps.\n" +
                "[0,64] Hal> Moved forward by 1 steps.\n" +
                "[0,65] Hal> Moved forward by 1 steps.\n" +
                "[0,66] Hal> Moved forward by 1 steps.\n" +
                "[0,67] Hal> Moved forward by 1 steps.\n" +
                "[0,68] Hal> Moved forward by 1 steps.\n" +
                "[0,69] Hal> Moved forward by 1 steps.\n" +
                "[0,70] Hal> Moved forward by 1 steps.\n" +
                "[0,71] Hal> Moved forward by 1 steps.\n" +
                "[0,72] Hal> Moved forward by 1 steps.\n" +
                "[0,73] Hal> Moved forward by 1 steps.\n" +
                "[0,74] Hal> Moved forward by 1 steps.\n" +
                "[0,75] Hal> Moved forward by 1 steps.\n" +
                "[0,76] Hal> Moved forward by 1 steps.\n" +
                "[0,77] Hal> Moved forward by 1 steps.\n" +
                "[0,78] Hal> Moved forward by 1 steps.\n" +
                "[0,79] Hal> Moved forward by 1 steps.\n" +
                "[0,80] Hal> Moved forward by 1 steps.\n" +
                "[0,81] Hal> Moved forward by 1 steps.\n" +
                "[0,82] Hal> Moved forward by 1 steps.\n" +
                "[0,83] Hal> Moved forward by 1 steps.\n" +
                "[0,84] Hal> Moved forward by 1 steps.\n" +
                "[0,85] Hal> Moved forward by 1 steps.\n" +
                "[0,86] Hal> Moved forward by 1 steps.\n" +
                "[0,87] Hal> Moved forward by 1 steps.\n" +
                "[0,88] Hal> Moved forward by 1 steps.\n" +
                "[0,89] Hal> Moved forward by 1 steps.\n" +
                "[0,90] Hal> Moved forward by 1 steps.\n" +
                "[0,91] Hal> Moved forward by 1 steps.\n" +
                "[0,92] Hal> Moved forward by 1 steps.\n" +
                "[0,93] Hal> Moved forward by 1 steps.\n" +
                "[0,94] Hal> Moved forward by 1 steps.\n" +
                "[0,95] Hal> Moved forward by 1 steps.\n" +
                "[0,96] Hal> Moved forward by 1 steps.\n" +
                "[0,97] Hal> Moved forward by 1 steps.\n" +
                "[0,98] Hal> Moved forward by 1 steps.\n" +
                "[0,99] Hal> Moved forward by 1 steps.\n" +
                "[0,100] Hal> Moved forward by 1 steps.\n" +
                "[0,101] Hal> Moved forward by 1 steps.\n" +
                "[0,102] Hal> Moved forward by 1 steps.\n" +
                "[0,103] Hal> Moved forward by 1 steps.\n" +
                "[0,104] Hal> Moved forward by 1 steps.\n" +
                "[0,105] Hal> Moved forward by 1 steps.\n" +
                "[0,106] Hal> Moved forward by 1 steps.\n" +
                "[0,107] Hal> Moved forward by 1 steps.\n" +
                "[0,108] Hal> Moved forward by 1 steps.\n" +
                "[0,109] Hal> Moved forward by 1 steps.\n" +
                "[0,110] Hal> Moved forward by 1 steps.\n" +
                "[0,111] Hal> Moved forward by 1 steps.\n" +
                "[0,112] Hal> Moved forward by 1 steps.\n" +
                "[0,113] Hal> Moved forward by 1 steps.\n" +
                "[0,114] Hal> Moved forward by 1 steps.\n" +
                "[0,115] Hal> Moved forward by 1 steps.\n" +
                "[0,116] Hal> Moved forward by 1 steps.\n" +
                "[0,117] Hal> Moved forward by 1 steps.\n" +
                "[0,118] Hal> Moved forward by 1 steps.\n" +
                "[0,119] Hal> Moved forward by 1 steps.\n" +
                "[0,120] Hal> Moved forward by 1 steps.\n" +
                "[0,121] Hal> Moved forward by 1 steps.\n" +
                "[0,122] Hal> Moved forward by 1 steps.\n" +
                "[0,123] Hal> Moved forward by 1 steps.\n" +
                "[0,124] Hal> Moved forward by 1 steps.\n" +
                "[0,125] Hal> Moved forward by 1 steps.\n" +
                "[0,126] Hal> Moved forward by 1 steps.\n" +
                "[0,127] Hal> Moved forward by 1 steps.\n" +
                "[0,128] Hal> Moved forward by 1 steps.\n" +
                "[0,129] Hal> Moved forward by 1 steps.\n" +
                "[0,130] Hal> Moved forward by 1 steps.\n" +
                "[0,131] Hal> Moved forward by 1 steps.\n" +
                "[0,132] Hal> Moved forward by 1 steps.\n" +
                "[0,133] Hal> Moved forward by 1 steps.\n" +
                "[0,134] Hal> Moved forward by 1 steps.\n" +
                "[0,135] Hal> Moved forward by 1 steps.\n" +
                "[0,136] Hal> Moved forward by 1 steps.\n" +
                "[0,137] Hal> Moved forward by 1 steps.\n" +
                "[0,138] Hal> Moved forward by 1 steps.\n" +
                "[0,139] Hal> Moved forward by 1 steps.\n" +
                "[0,140] Hal> Moved forward by 1 steps.\n" +
                "[0,141] Hal> Moved forward by 1 steps.\n" +
                "[0,142] Hal> Moved forward by 1 steps.\n" +
                "[0,143] Hal> Moved forward by 1 steps.\n" +
                "[0,144] Hal> Moved forward by 1 steps.\n" +
                "[0,145] Hal> Moved forward by 1 steps.\n" +
                "[0,146] Hal> Moved forward by 1 steps.\n" +
                "[0,147] Hal> Moved forward by 1 steps.\n" +
                "[0,148] Hal> Moved forward by 1 steps.\n" +
                "[0,149] Hal> Moved forward by 1 steps.\n" +
                "[0,150] Hal> Moved forward by 1 steps.\n" +
                "[0,151] Hal> Moved forward by 1 steps.\n" +
                "[0,152] Hal> Moved forward by 1 steps.\n" +
                "[0,153] Hal> Moved forward by 1 steps.\n" +
                "[0,154] Hal> Moved forward by 1 steps.\n" +
                "[0,155] Hal> Moved forward by 1 steps.\n" +
                "[0,156] Hal> Moved forward by 1 steps.\n" +
                "[0,157] Hal> Moved forward by 1 steps.\n" +
                "[0,158] Hal> Moved forward by 1 steps.\n" +
                "[0,159] Hal> Moved forward by 1 steps.\n" +
                "[0,160] Hal> Moved forward by 1 steps.\n" +
                "[0,161] Hal> Moved forward by 1 steps.\n" +
                "[0,162] Hal> Moved forward by 1 steps.\n" +
                "[0,163] Hal> Moved forward by 1 steps.\n" +
                "[0,164] Hal> Moved forward by 1 steps.\n" +
                "[0,165] Hal> Moved forward by 1 steps.\n" +
                "[0,166] Hal> Moved forward by 1 steps.\n" +
                "[0,167] Hal> Moved forward by 1 steps.\n" +
                "[0,168] Hal> Moved forward by 1 steps.\n" +
                "[0,169] Hal> Moved forward by 1 steps.\n" +
                "[0,170] Hal> Moved forward by 1 steps.\n" +
                "[0,171] Hal> Moved forward by 1 steps.\n" +
                "[0,172] Hal> Moved forward by 1 steps.\n" +
                "[0,173] Hal> Moved forward by 1 steps.\n" +
                "[0,174] Hal> Moved forward by 1 steps.\n" +
                "[0,175] Hal> Moved forward by 1 steps.\n" +
                "[0,176] Hal> Moved forward by 1 steps.\n" +
                "[0,177] Hal> Moved forward by 1 steps.\n" +
                "[0,178] Hal> Moved forward by 1 steps.\n" +
                "[0,179] Hal> Moved forward by 1 steps.\n" +
                "[0,180] Hal> Moved forward by 1 steps.\n" +
                "[0,181] Hal> Moved forward by 1 steps.\n" +
                "[0,182] Hal> Moved forward by 1 steps.\n" +
                "[0,183] Hal> Moved forward by 1 steps.\n" +
                "[0,184] Hal> Moved forward by 1 steps.\n" +
                "[0,185] Hal> Moved forward by 1 steps.\n" +
                "[0,186] Hal> Moved forward by 1 steps.\n" +
                "[0,187] Hal> Moved forward by 1 steps.\n" +
                "[0,188] Hal> Moved forward by 1 steps.\n" +
                "[0,189] Hal> Moved forward by 1 steps.\n" +
                "[0,190] Hal> Moved forward by 1 steps.\n" +
                "[0,191] Hal> Moved forward by 1 steps.\n" +
                "[0,192] Hal> Moved forward by 1 steps.\n" +
                "[0,193] Hal> Moved forward by 1 steps.\n" +
                "[0,194] Hal> Moved forward by 1 steps.\n" +
                "[0,195] Hal> Moved forward by 1 steps.\n" +
                "[0,196] Hal> Moved forward by 1 steps.\n" +
                "[0,197] Hal> Moved forward by 1 steps.\n" +
                "[0,198] Hal> Moved forward by 1 steps.\n" +
                "[0,199] Hal> Moved forward by 1 steps.\n" +
                "[0,200] Hal> Moved forward by 1 steps.\n" +
                "[0,200] Hal> I am at the top edge. (Cost: 200 steps)\n" +
                "Hal> What must I do next?\n" +
                "[0,200] Hal> Shutting down...", outputStream.toString().trim());
    }

}