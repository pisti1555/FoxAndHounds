package hu.nye.progtech.Beadando;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class BoardTest {

    Step s;

    @BeforeEach
    public void beforeEach() {
        s = new Step();
    }


    @Test
    void tablaFrissit() {
        StepTest st = new StepTest();
        st.tablaClone();
    }

    @Test
    void vereseg() {
        boolean vereseg=false;
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
