package hu.nye.progtech.beadando.game;

import java.sql.SQLException;
import java.util.Scanner;

import hu.nye.progtech.beadando.database.PlayerDatabase;



/**
 * Tabla.
 */
public class Board {
    private int nxn;
    private int[][] tabla;
    private boolean gyozott = false;
    private boolean vesztett = false;
    private Scanner scanner = new Scanner(System.in);
    private Step step = new Step();

    /**
     * Letrehozzuk az eredeti tablat, es inditja a lepes tabla letrehozasat is.
     */
    public void tablaLetrehoz() {
        System.out.print("Milyen legyen a tábla mérete? (minimum 4x4 / maximum 12x12) :: ");
        while (true) {
            nxn = scanner.nextInt();
            if (nxn < 4) {
                System.out.println();
                System.out.println("Minimum 4x4");
                System.out.print("Írd be újra: ");
            } else if (nxn > 12) {
                System.out.println();
                System.out.println("Maximum 12x12");
                System.out.print("Írd be újra: ");
            } else {
                System.out.println("Rendben a tábla mérete így " + nxn + "x" + nxn + " lett");
                System.out.println();
                break;
            }
        }
        tabla = new int[nxn][nxn];
        step.tablaLetrehoz(nxn);
    }

    /**
     * Kiirja a tablat.
     */
    private void tablaMegjelenit() {
        for (int i = 0; i < tabla.length; i++) {
            for (int j = 0; j < tabla.length; j++) {
                if (tabla[i][j] == 1) {
                    System.out.print("F" + "  ");
                } else if (tabla[i][j] == 2) {
                    System.out.print("D" + "  ");
                } else {
                    System.out.print("*" + "  ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Masolja a tablat.
     */
    private void tablaFrissit() {
        tabla = step.tablaClone();
    }

    /**
     * Ossze van szedve a jatek folyamata loopolva, amig nem nyerunk v vesztunk.
     */
    public void jatek(PlayerDatabase pd) throws SQLException {
        gyozott = false;
        vesztett = false;
        tablaFrissit();
        tablaMegjelenit();
        while (true) {
            step.lep(step.getFox());
            pd.megtettLepes();
            tablaFrissit();
            tablaMegjelenit();
            gyozelem(pd);
            if (gyozott) {
                break;
            }
            step.lep(step.getDog());
            tablaFrissit();
            tablaMegjelenit();
            vereseg(pd);
            if (vesztett) {
                break;
            }
        }
        pd.statValtozas();
    }

    /**
     * Megvizsgalja nyertuk-e mar, ha igen elvegzi a muveleteket.
     */
    private void gyozelem(PlayerDatabase pd) {
        if (step.gyozelem(step.getFox())) {
            gyozott = true;
            pd.gyozelem();
            System.out.println();
            System.out.println("Győzött a Róka!");
            System.out.println("Ezen a meccsen megtett lépések száma: " + pd.getLepesekSzama());
        }
    }

    /**
     * Megvizsgalja vesztettunk-e mar, ha igen elvegzi a muveleteket.
     */
    private void vereseg(PlayerDatabase pd) {
        Position fox = step.getFox();
        int[][] tabla = step.tablaClone();
        if (!step.bfl(fox, tabla) && !step.bll(fox, tabla) && !step.jfl(fox, tabla) && !step.jll(fox, tabla)) {
            vesztett = true;
            pd.vereseg();
            System.out.println("Győztek a kutyák!");
            System.out.println("Ezen a meccsen megtett lépések száma: " + pd.getLepesekSzama());
        }
    }
}