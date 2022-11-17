package hu.nye.progtech.Beadando;

import org.codehaus.plexus.component.annotations.Component;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {
    PlayerDatabase pd;
    Board b;

    public Menu(PlayerDatabase pd, Board b) {
        this.pd = pd;
        this.b = b;
    }

    Scanner scanner = new Scanner(System.in);

    public void start() throws SQLException {
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
                pd.logIn();
                if(pd.findPlayer()) {
                    pd.osszStat();
                }else {
                    pd.ujPlayer();
                }
                break;
            }
            else {
                System.out.println("Ismeretlen parancs -- i/n");
            }
        }
    }

    protected void menu() throws SQLException {
        while(true) {
            int valasztas;
            System.out.println();
            System.out.println("---------MENÜ---------");
            System.out.println("1 = Játék indítása");
            System.out.println("2 = Statisztikák megjelenítése");
            System.out.println("3 = Profilváltás");
            System.out.println("4 = Kilépés a játékból");
            System.out.println("----------------------");

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
                    menu();
                }
            }
        }
    }
}