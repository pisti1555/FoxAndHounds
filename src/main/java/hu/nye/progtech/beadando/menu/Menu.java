package hu.nye.progtech.beadando.menu;

import java.io.File;
import java.sql.SQLException;
import java.util.Scanner;

import hu.nye.progtech.beadando.database.Player;
import hu.nye.progtech.beadando.database.Stats;
import hu.nye.progtech.beadando.game.Board;
import hu.nye.progtech.beadando.gamestatesave.SaveAndLoad;
import jakarta.xml.bind.JAXBException;

/**
 * Menu, 2 fuggosege a jatekos-adatbazis es a tabla. Innen indulnak.
 */

public class Menu {
    private Stats stat;
    private Board board;
    private Player player;
    private boolean betoltes = false;
    private final Scanner scanner = new Scanner(System.in);

    public Menu(Stats stat, Player player, Board board) {
        this.stat = stat;
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
                    stat.osszStat();
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
    public void menu() throws SQLException, JAXBException {
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
                    mentettJatekBetoltes();
                    if (!betoltes) {
                        board.tablaLetrehoz();
                    } else {
                        SaveAndLoad saveAndLoad = new SaveAndLoad();
                        saveAndLoad.load(stat.getNev(), board);
                        board.betoltes();
                    }
                    board.jatek(stat);
                }
                break;
                case 2: {
                    stat.osszStat();
                }
                break;
                case 3: {
                    stat.scoreBoard();
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

    /**
     * Betoltes mentesbol.
     */
    public void mentettJatekBetoltes() {
        File xml = new File("src//main//resources//" + stat.getNev() + ".xml");
        int valasz = 2;
        if (xml.exists()) {
            System.out.println("Előző alkalommal elmentetted a játékállást. Akarod betölteni?\n1 = Igen | 2 = Nem");
            valasz = scanner.nextInt();
            switch (valasz) {
                case 1: {
                    System.out.println("Betöltés");
                    betoltes = true;
                    // TODO
                }
                break;
                case 2: {
                    betoltes = false;
                    // TODO
                }
                break;
                default: {
                    System.out.println("Ismeretlen parancs");
                }
                break;
            }
        }
    }
}