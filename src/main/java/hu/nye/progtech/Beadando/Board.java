package hu.nye.progtech.Beadando;

import java.util.Scanner;

public class Board {
    private int NxN;
    public int mezo;
    private final int FOX = 1;
    private final int DOG = 2;
    private int[][] tabla;
    private int sor;
    private int oszlop;
    private int elozoSor;
    private int elozoOszlop;


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
            sor = mezo;
            oszlop = (mezo/2)+1;
            elozoSor = sor;
            elozoOszlop = oszlop;
            for (int i = 1; i < tabla.length; i += 2) {
                tabla[0][i] = DOG;
            }
        } else {
            tabla[mezo][mezo / 2] = FOX;
            sor = mezo;
            oszlop = mezo/2;
            elozoSor = sor;
            elozoOszlop = oszlop;
            for (int i = 1; i < tabla.length; i += 2) {
                tabla[0][i] = DOG;
            }
        }
    }

    public void tablaFrissit() {
        for (int i = 0; i < tabla.length; i++) {
            for (int j = 0; j < tabla.length; j++) {
                System.out.print(tabla[i][j] + "  ");
            }
            System.out.println("");
        }
    }

    public void lep() {
        Scanner scanner = new Scanner(System.in);
        int lepes;
        System.out.println("1 = Balra-Fel | 2 = Jobbra-Fel | 3 = Balra-Le | 4 = Jobbra-Le");
        while (true) {
            lepes = scanner.nextInt();
            if (lepes > 4 || lepes < 1) {
                System.out.println("Helytelen parancs");
            } else break;
        }

        while(sor == elozoSor && oszlop == elozoOszlop) {
            if(lepes == 1) {
                if (sor - 1 > mezo || oszlop - 1 > mezo) {
                    System.out.println("Helytelen lépés");
                    while (true) {
                        lepes = scanner.nextInt();
                        if (lepes > 4 || lepes < 1) {
                            System.out.println("Helytelen parancs");
                        } else break;
                    }
                } else {
                    if (tabla[sor - 1][oszlop - 1] == 0) {
                        tabla[sor - 1][oszlop - 1] = FOX;
                        tabla[sor][oszlop] = 0;
                        sor -= 1;
                        oszlop -= 1;
                        break;
                    }
                }
            } else if(lepes == 2) {
                if (sor - 1 > mezo || oszlop + 1 > mezo) {
                    System.out.println("Helytelen lépés");
                    while (true) {
                        lepes = scanner.nextInt();
                        if (lepes > 4 || lepes < 1) {
                            System.out.println("Helytelen parancs");
                        } else break;
                    }
                } else {
                    if (tabla[sor - 1][oszlop + 1] == 0) {
                        tabla[sor - 1][oszlop + 1] = FOX;
                        tabla[sor][oszlop] = 0;
                        sor -= 1;
                        oszlop += 1;
                        break;
                    }
                }
            } else if(lepes == 3) {
                if (sor + 1 > mezo || oszlop - 1 > mezo) {
                    System.out.println("Helytelen lépés");
                    while (true) {
                        lepes = scanner.nextInt();
                        if (lepes > 4 || lepes < 1) {
                            System.out.println("Helytelen parancs");
                        } else break;
                    }
                } else {
                    if (tabla[sor + 1][oszlop - 1] == 0) {
                        tabla[sor + 1][oszlop - 1] = FOX;
                        tabla[sor][oszlop] = 0;
                        sor += 1;
                        oszlop -= 1;
                        break;
                    }
                }
            } else if(lepes == 4) {
                if (sor + 1 > mezo || oszlop + 1 > mezo) {
                    System.out.println("Helytelen lépés");
                    while (true) {
                        lepes = scanner.nextInt();
                        if (lepes > 4 || lepes < 1) {
                            System.out.println("Helytelen parancs");
                        } else break;
                    }
                } else {
                    if (tabla[sor + 1][oszlop + 1] == 0) {
                        tabla[sor + 1][oszlop + 1] = FOX;
                        tabla[sor][oszlop] = 0;
                        sor += 1;
                        oszlop += 1;
                        break;
                    }
                }
            } else {
                System.out.println("Helytelen parancs");
                lepes = scanner.nextInt();
            }
        }
    }
}
