package test.java;

import game.cell.Cell;
import game.cell.Data;
import javafx.scene.Group;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Text;

import static org.junit.jupiter.api.Assertions.*;

class LogicTest extends Data {

    @Test
    public void canNotMove() {

        assertTrue(true );
        assertFalse(false);

    }

    @Test
    void haveEmptyCell() {

        assertEquals(0,0);
        assertEquals(1,1);
        assertEquals(2,2);

    }
}