package hu.nye.progtech.beadando;

import hu.nye.progtech.beadando.game.Position;
import hu.nye.progtech.beadando.game.Step;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class BoardTest {

    @Test
    void veresegTest() {
        Step s = new Step();
        boolean vereseg=false;
        Position f = new Position(4,7,1);
        int[][] tabla = new int[8][8];
        tabla[4][7]=1;
        tabla[5][6]=2;
        tabla[3][6]=2;

        if (!s.bfl(f,tabla) && !s.bll(f,tabla) && !s.jfl(f,tabla) && !s.jll(f,tabla)) {
            vereseg=true;
        }
        assertTrue(vereseg);
    }
}
