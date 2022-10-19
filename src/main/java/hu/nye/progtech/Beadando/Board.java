package hu.nye.progtech.Beadando;

import java.util.Scanner;

public class Board {
    public int mezo;
    private final int FOX = 1;
    private final int DOG = 2;
    private int[][] tabla;
    private int sor;
    private int oszlop;
    Scanner scanner = new Scanner(System.in);

    public void tablaLetrehoz() {
        System.out.print("Milyen legyen a tábla mérete? (minimum 4x4 / maximum 12x12) :: ");
        int NxN;
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
            sor = mezo;
            oszlop = (mezo / 2) + 1;
            for (int i = 1; i < tabla.length; i += 2) {
                tabla[0][i] = DOG;
            }
        } else {
            tabla[mezo][mezo / 2] = FOX;
            sor = mezo;
            oszlop = mezo / 2;
            for (int i = 1; i < tabla.length; i += 2) {
                tabla[0][i] = DOG;
            }
        }
    }

    public void tablaFrissit() {
        for (int i = 0; i < tabla.length; i++) {
            for (int j = 0; j < tabla.length; j++) {
                if (tabla[i][j] == FOX) {
                    System.out.print("F" + "  ");
                } else if (tabla[i][j] == DOG) {
                    System.out.print("D" + "  ");
                } else {
                    System.out.print("*" + "  ");
                }
            }
            System.out.println();
        }
    }

    public void lep() {
        System.out.println("1 = Fel-Balra | 2 = Fel - Jobbra | 3 = Le-Balra | 4 = Le-Jobbra");
        int lepes = scanner.nextInt();

        switch (lepes) {
            case 1: {
                if (sor - 1 > mezo || oszlop - 1 > mezo || sor - 1 < 0 || oszlop - 1 < 0) {
                    System.out.println("Helytelen lépés");
                    lep();
                } else {
                    if(tabla[sor-1][oszlop-1] == 0) {
                        tabla[sor-1][oszlop-1] = FOX;
                        tabla[sor][oszlop] = 0;
                        sor = sor-1;
                        oszlop = oszlop-1;
                    }else {
                        System.out.println("Helytelen lépés - Foglalt mező");
                        lep();
                    }
                }
            } break;

            case 2: {
                if (sor - 1 > mezo || oszlop + 1 > mezo || sor - 1 < 0 || oszlop + 1 < 0) {
                    System.out.println("Helytelen lépés");
                    lep();
                } else {
                    if(tabla[sor-1][oszlop+1] == 0) {
                        tabla[sor-1][oszlop+1] = FOX;
                        tabla[sor][oszlop] = 0;
                        sor = sor-1;
                        oszlop = oszlop+1;
                    }else {
                        System.out.println("Helytelen lépés - Foglalt mező");
                        lep();
                    }
                }
            } break;

            case 3: {
                if (sor + 1 > mezo || oszlop - 1 > mezo || sor + 1 < 0 || oszlop - 1 < 0) {
                    System.out.println("Helytelen lépés");
                    lep();
                } else {
                    if(tabla[sor+1][oszlop-1] == 0) {
                        tabla[sor+1][oszlop-1] = FOX;
                        tabla[sor][oszlop] = 0;
                        sor = sor+1;
                        oszlop = oszlop-1;
                    }else {
                        System.out.println("Helytelen lépés - Foglalt mező");
                        lep();
                    }
                }
            } break;

            case 4: {
                if (sor + 1 > mezo || oszlop + 1 > mezo || sor - 1 < 0 || oszlop + 1 < 0) {
                    System.out.println("Helytelen lépés");
                    lep();
                } else {
                    if(tabla[sor+1][oszlop+1] == 0) {
                        tabla[sor+1][oszlop+1] = FOX;
                        tabla[sor][oszlop] = 0;
                        sor = sor+1;
                        oszlop = oszlop+1;
                    }else {
                        System.out.println("Helytelen lépés - Foglalt mező");
                        lep();
                    }
                }
            } break;

            default: {
                System.out.println("Ismeretlen parancs");
                lep();
            }
        }
    }


    public void ismeteltLepes() {
        while(true) {
            System.out.println("sor: "+sor);
            System.out.println("oszlop: "+oszlop);
            tablaFrissit();
            lep();

        }
    }
}