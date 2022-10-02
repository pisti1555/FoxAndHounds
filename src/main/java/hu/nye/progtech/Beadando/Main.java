package hu.nye.progtech.Beadando;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        PlayerDatabase player = new PlayerDatabase();
        Board board = new Board();

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

        System.out.print("Mi a neved? :: ");
        player.setNev(scanner.next());
        System.out.println("\nHali " + player.getNev() + ", akkor kezdjünk el játszani\n");
        System.out.print("Milyen legyen a tábla mérete? (minimum 4x4 / maximum 12x12) :: ");
        while(true) {
            board.setNxN(scanner.nextInt());
            if(board.getNxN() < 4) {
                System.out.println();
                System.out.println("Minimum 4x4");
                System.out.print("Írd be újra: ");
            }
            else if(board.getNxN() > 12) {
                System.out.println();
                System.out.println("Maximum 12x12");
                System.out.print("Írd be újra: ");
            }
            else {
                System.out.println("Rendben a tábla mérete így " + board.getNxN() + "x" + board.getNxN() + " lett");
                System.out.println();
                break;
            }
        }

        //INNENTŐL

    }
}
