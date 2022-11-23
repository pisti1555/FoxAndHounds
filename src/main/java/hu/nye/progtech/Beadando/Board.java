package hu.nye.progtech.Beadando;

import java.sql.SQLException;
import java.util.Scanner;

public class Board {
    private int NxN;
    private int[][] tabla;
    private boolean gyozott = false;
    private boolean vesztett = false;
    private Scanner scanner = new Scanner(System.in);
    private Step step = new Step();


    protected void tablaLetrehoz() {
        System.out.print("Milyen legyen a tábla mérete? (minimum 4x4 / maximum 12x12) :: ");
        while (true) {
            NxN = scanner.nextInt();
            if (NxN < 4) {
                System.out.println();
                System.out.println("Minimum 4x4");
                System.out.print("Írd be újra: ");
            } else if (NxN > 12) {
                System.out.println();
                System.out.println("Maximum 12x12");
                System.out.print("Írd be újra: ");
            } else {
                System.out.println("Rendben a tábla mérete így " + NxN + "x" + NxN + " lett");
                System.out.println();
                break;
            }
        }
        tabla = new int[NxN][NxN];
        step.tablaLetrehoz(NxN);
    }

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

    private void tablaFrissit() {
        tabla = step.tablaClone();
    }

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
            if (gyozott) break;
            step.lep(step.getDog());
            tablaFrissit();
            tablaMegjelenit();
            vereseg(pd);
            if (vesztett) break;
        }
        pd.statValtozas();
    }

    private void gyozelem(PlayerDatabase pd) {
        if (step.gyozelem(step.getFox())) {
            gyozott = true;
            pd.gyozelem();
            System.out.println();
            System.out.println("Győzött a Róka!");
            System.out.println("Ezen a meccsen megtett lépések száma: " + pd.getLepesekSzama());
        }
    }

    private void vereseg(PlayerDatabase pd) {
        if (!step.balraFelLepE(step.getFox(), step.tablaClone()) && !step.balraLeLepE(step.getFox(), step.tablaClone()) && !step.jobbraFelLepE(step.getFox(), step.tablaClone()) && !step.jobbraLeLepE(step.getFox(), step.tablaClone())) {
            vesztett = true;
            pd.vereseg();
            System.out.println("Győztek a kutyák!");
            System.out.println("Ezen a meccsen megtett lépések száma: " + pd.getLepesekSzama());
        }
    }
}