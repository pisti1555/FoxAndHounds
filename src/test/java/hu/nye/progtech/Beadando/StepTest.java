package hu.nye.progtech.Beadando;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StepTest {

    @Test
    void tablaLetrehoz() {
        Step s = new Step();
        s.tablaLetrehoz(8);
        boolean elhelyezes = false;
        int[][] tabla = s.tablaClone();
        if(tabla[0][1]==2 && tabla[7][4]==1) {
            elhelyezes = true;
        }
        assertTrue(elhelyezes);
    }

    @Test
    void lep() {
        Position x = new Position(4,4,1);
        int[][] tabla = new int[8][8];
        short helyes=0;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tabla[i][j] = 0;
            }
        }
        tabla[4][4] = 1;
        tabla[x.sor+1][x.oszlop+1] = x.tipus;
        tabla[x.sor][x.oszlop] = 0;
        x.sor = x.sor+1;
        x.oszlop = x.oszlop+1;

        if(x.sor==5&&x.oszlop==5) {
            helyes++;
        }
        if(tabla[4][4]==0 && tabla[5][5]==x.tipus) {
            helyes++;
        }

        assertEquals(2, helyes);
    }

    @Test
    void tablaClone() {
        int[][] tabla = new int[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tabla[i][j] = 0;
            }
        }
        int[][] klon = tabla.clone();
        boolean egyezik = true;

        for (int i = 0; i < klon.length; i++) {
            for (int j = 0; j < klon.length; j++) {
                if(klon[i][j] != tabla[i][j]) {
                    egyezik = false;
                }
            }
        }
        assertTrue(egyezik);
    }

    @Test
    void gyozelemTrue() {
        Step s = new Step();
        Position x = new Position(0,1,1);
        assertTrue(s.gyozelem(x));
    }
    @Test
    void gyozelemFalse() {
        Step s = new Step();
        Position x = new Position(2,0,1);
        assertFalse(s.gyozelem(x));
    }

    @Test
    void balraFelLepENemMertSzelenVan() {
        Step s = new Step();
        Position x = new Position(7,0,1);
        int[][] tabla = new int[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tabla[i][j] = 0;
            }
        }
        assertFalse(s.balraFelLepE(x, tabla));
    }
    @Test
    void balraFelLepENemMertFentVan() {
        Step s = new Step();
        Position x = new Position(0,4,1);
        int[][] tabla = new int[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tabla[i][j] = 0;
            }
        }
        assertFalse(s.balraFelLepE(x, tabla));
    }
    @Test
    void balraFelLepEIgenMertSzelenVan() {
        Step s = new Step();
        Position x = new Position(7,7,1);
        int[][] tabla = new int[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tabla[i][j] = 0;
            }
        }
        assertTrue(s.balraFelLepE(x, tabla));
    }
    @Test
    void balraFelLepEIgenMertLentVan() {
        Step s = new Step();
        Position x = new Position(7,4,1);
        int[][] tabla = new int[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tabla[i][j] = 0;
            }
        }
        assertTrue(s.balraFelLepE(x, tabla));
    }

    @Test
    void balraLeLepENemMertLentVan() {
        Step s = new Step();
        Position x = new Position(7,4,1);
        int[][] tabla = new int[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tabla[i][j] = 0;
            }
        }
        assertFalse(s.balraLeLepE(x, tabla));
    }
    @Test
    void balraLeLepENemMertSzelenVan() {
        Step s = new Step();
        Position x = new Position(0,0,1);
        int[][] tabla = new int[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tabla[i][j] = 0;
            }
        }
        assertFalse(s.balraLeLepE(x, tabla));
    }
    @Test
    void balraLeLepEIgenMertFentVan() {
        Step s = new Step();
        Position x = new Position(0,4,1);
        int[][] tabla = new int[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tabla[i][j] = 0;
            }
        }
        assertTrue(s.balraLeLepE(x, tabla));
    }
    @Test
    void balraLeLepEIgenMertSzelenVan() {
        Step s = new Step();
        Position x = new Position(0,7,1);
        int[][] tabla = new int[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tabla[i][j] = 0;
            }
        }
        assertTrue(s.balraLeLepE(x, tabla));
    }

    @Test
    void jobbraFelLepENemMertFentVan() {
        Step s = new Step();
        Position x = new Position(0,4,1);
        int[][] tabla = new int[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tabla[i][j] = 0;
            }
        }
        assertFalse(s.jobbraFelLepE(x, tabla));
    }
    @Test
    void jobbraFelLepENemMertSzelenVan() {
        Step s = new Step();
        Position x = new Position(4,7,1);
        int[][] tabla = new int[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tabla[i][j] = 0;
            }
        }
        assertFalse(s.jobbraFelLepE(x, tabla));
    }
    @Test
    void jobbraFelLepEIgenMertLentVan() {
        Step s = new Step();
        Position x = new Position(7,4,1);
        int[][] tabla = new int[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tabla[i][j] = 0;
            }
        }
        assertTrue(s.jobbraFelLepE(x, tabla));
    }@Test
    void jobbraFelLepEIgenMertSzelenVan() {
        Step s = new Step();
        Position x = new Position(4,0,1);
        int[][] tabla = new int[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tabla[i][j] = 0;
            }
        }
        assertTrue(s.jobbraFelLepE(x, tabla));
    }

    @Test
    void jobbraLeLepENemMertLentVan() {
        Step s = new Step();
        Position x = new Position(7,4,1);
        int[][] tabla = new int[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tabla[i][j] = 0;
            }
        }
        assertFalse(s.jobbraLeLepE(x, tabla));
    }
    @Test
    void jobbraLeLepENemMertSzelenVan() {
        Step s = new Step();
        Position x = new Position(4,7,1);
        int[][] tabla = new int[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tabla[i][j] = 0;
            }
        }
        assertFalse(s.jobbraLeLepE(x, tabla));
    }
    @Test
    void jobbraLeLepEIegnMertFentVan() {
        Step s = new Step();
        Position x = new Position(0,4,1);
        int[][] tabla = new int[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tabla[i][j] = 0;
            }
        }
        assertTrue(s.jobbraLeLepE(x, tabla));
    }
    @Test
    void jobbraLeLepEIgenMertSzelenVan() {
        Step s = new Step();
        Position x = new Position(4,0,1);
        int[][] tabla = new int[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tabla[i][j] = 0;
            }
        }
        assertTrue(s.jobbraLeLepE(x, tabla));
    }
}