package hu.nye.progtech.Beadando;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class BoardTest {

    @Test
    void tablaLetrehoz() {
        StepTest s = new StepTest();
        s.tablaLetrehoz();
    }

    @Test
    void tablaFrissit() {
        StepTest s = new StepTest();
        s.tablaClone();
    }

    @Test
    void vereseg() {
        boolean vereseg=false;
        Step s = new Step();
        Position f = new Position(4,7,1);
        int[][] tabla = new int[8][8];
        tabla[4][7]=1;
        tabla[5][6]=2;
        tabla[3][6]=2;

        if (!s.balraFelLepE(f,tabla) && !s.balraLeLepE(f,tabla) && !s.jobbraFelLepE(f,tabla) && !s.jobbraLeLepE(f,tabla)) {
            vereseg=true;
        }
        assertTrue(vereseg);
    }



}
