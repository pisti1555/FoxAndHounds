package hu.nye.progtech.Beadando;

import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);

    protected void start(PlayerDatabase pd) {
        System.out.println("FOX AND HOUNDS\n");
        System.out.print("i = Indítás | n = Kilépés :: ");
        char start;

        while(true) {
            start = scanner.next().charAt(0);
            if(start == 'n' || start == 'N') {
                System.out.println("Viszlát máskor");
                System.exit(0);
            }
            else if(start == 'i' || start == 'I') {
                System.out.println("Jó játékot!\n");
                pd.playerTxt();
                break;
            }
            else {
                System.out.println("Ismeretlen parancs -- i/n");
            }
        }
    }

    protected void menu(PlayerDatabase pd, Board b) {
        while(true) {
            int valasztas;
            System.out.println();
            System.out.println("        MENÜ");
            System.out.println("1 = Játék indítása");
            System.out.println("2 = Statisztikák megjelenítése");
            System.out.println("3 = Profilváltás");
            System.out.println("4 = Kilépés a játékból");

            valasztas = scanner.nextInt();
            switch(valasztas) {
                case 1: {
                    b.tablaLetrehoz();
                    b.jatek(pd);
                }break;
                case 2: {
                    pd.osszStat();
                }break;
                case 3: {
                    System.out.println("Fejlesztés alatt");
                }break;
                case 4: {
                    System.out.println("Viszlát legközelebb");
                    System.exit(0);
                }break;
                default: {
                    System.out.println("Ismeretlen parancs\n");
                    menu(pd, b);
                }
            }
        }
    }
}