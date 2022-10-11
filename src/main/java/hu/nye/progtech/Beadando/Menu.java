package hu.nye.progtech.Beadando;

import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    PlayerDatabase player = new PlayerDatabase();

    public void start() {
        System.out.println("FOX AND HOUNDS\n");
        System.out.print("Mehet a játék? (i/n) :: ");
        char start;

        while(true) {
            start = scanner.next().charAt(0);
            if(start == 'n' || start == 'N') {
                System.out.println("Akkor viszlát");
                System.exit(0);
            }
            else if(start == 'i' || start == 'I') {
                System.out.println("Okés lets go\n");
                break;
            }
            else {
                System.out.println("Ismeretlen parancs -- i/n");
            }
        }
    }
}
