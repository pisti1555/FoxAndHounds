package hu.nye.progtech.beadando.menu;

import java.sql.SQLException;
import java.util.Scanner;

import hu.nye.progtech.beadando.database.Player;
import hu.nye.progtech.beadando.database.PlayerDatabase;
import hu.nye.progtech.beadando.game.Board;

/**
 * Menu, 2 fuggosege a jatekos-adatbazis es a tabla. Innen indulnak.
 */

public class Menu {
    private PlayerDatabase pd;
    private Board board;
    private Player player;
    private final Scanner scanner = new Scanner(System.in);

    public Menu(PlayerDatabase pd, Player player, Board board) {
        this.pd = pd;
        this.board = board;
        this.player = player;
    }

    /**
     * Inditjuk-e a jatekot, ha igen akkor megkeresi van-e mentesunk,
     * ha igen kiirja a statot, ha nem akkor letrehoz egy profilt.
     */
    public void start() throws SQLException {
        System.out.println("FOX AND HOUNDS\n");
        System.out.print("i = Indítás | n = Kilépés :: ");
        char start;

        while (true) {
            start = scanner.next().charAt(0);
            if (start == 'n' || start == 'N') {
                System.out.println("Viszlát máskor");
                System.exit(0);
            } else if (start == 'i' || start == 'I') {
                System.out.println("Jó játékot!\n");
                player.logIn(scanner);
                if (player.findPlayer()) {
                    pd.osszStat();
                } else {
                    player.ujPlayer();
                }
                break;
            } else {
                System.out.println("Ismeretlen parancs -- i/n");
            }
        }
    }

    /**
     * Eldonthetjuk mit szeretnenk csinalni.
     */
    public void menu() throws SQLException {
        while (true) {
            System.out.println();
            System.out.println("---------MENÜ---------");
            System.out.println("1 = Játék indítása");
            System.out.println("2 = Statisztikák megjelenítése");
            System.out.println("3 = Scoreboard");
            System.out.println("4 = Kilépés a játékból");
            System.out.println("----------------------");
            int valasztas = scanner.nextInt();
            switch (valasztas) {
                case 1: {
                    board.tablaLetrehoz();
                    board.jatek(pd);
                }
                break;
                case 2: {
                    pd.osszStat();
                }
                break;
                case 3: {
                    pd.scoreBoard();
                }
                break;
                case 4: {
                    System.out.println("Viszlát legközelebb");
                    System.exit(0);
                }
                break;
                default: {
                    System.out.println("Ismeretlen parancs\n");
                    menu();
                }
            }
        }
    }
}