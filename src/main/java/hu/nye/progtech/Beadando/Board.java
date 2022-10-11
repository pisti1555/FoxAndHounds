package hu.nye.progtech.Beadando;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.Scanner;

public class Board {
    private int NxN;
    private int mezo;
    private final int FOX = 1;
    private final int DOG = 2;
    private int[][] tabla;


    public void tablaLetrehoz() {
        Scanner scanner = new Scanner(System.in);
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
        mezo = tabla.length - 1;
        for (int i = 0; i < tabla.length; i++) {
            for (int j = 0; j < tabla.length; j++) {
                tabla[i][j] = 0;
            }
        }

        if ((NxN / 2) % 2 == 0) {
            tabla[mezo][(mezo / 2) + 1] = FOX;
            for (int i = 1; i < tabla.length; i += 2) {
                tabla[0][i] = DOG;
            }
        } else {
            tabla[mezo][mezo / 2] = FOX;
            for (int i = 1; i < tabla.length; i += 2) {
                tabla[0][i] = DOG;
            }
        }
    }

    public void tablaMegjelenit() {
        for (int i = 0; i < tabla.length; i++) {
            for (int j = 0; j < tabla.length; j++) {
                System.out.print(tabla[i][j] + "  ");
            }
            System.out.println("");
        }
    }



    public int getNxN() {
        return NxN;
    }
    public void setNxN(int nxN) {
        NxN = nxN;
    }
    public int[][] getTabla() {
        return tabla;
    }
    public void setTabla(int[][] tabla) {
        this.tabla = tabla;
    }
}
