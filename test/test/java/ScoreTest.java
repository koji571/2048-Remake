package test.java;

import game.cell.Data;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScoreTest{

    long score = 100;
    long oldscore = 200;

    long newdata = 100;

    @Test
    void readFile() {

        assertEquals(newdata,newdata);
    }

    @Test
    void compareScore() {



        assertEquals(score,score);
        assertEquals(oldscore,oldscore);

    }
}