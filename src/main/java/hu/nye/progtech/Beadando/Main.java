package hu.nye.progtech.Beadando;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();
        PlayerDatabase playerDataBase = new PlayerDatabase();
        Board board = new Board();
/*
        menu.start();
        System.out.print("Mi a neved? :: ");
        playerDataBase.setNev(scanner.next());
        System.out.println("\nHali " + playerDataBase.getNev() + "\n");

        File player = new File("src\\main\\java\\hu\\nye\\progtech\\Beadando\\Players\\"+playerDataBase.getNev().toLowerCase()+".txt");
        if(player.exists()) {
            System.out.println("Már létezik mentésed az alábbi adatokkal:\n");
            playerDataBase.osszStat(player);
            System.out.println("Győzelmek: "+playerDataBase.getOsszGyozelmek());
            System.out.println("Vereségek: "+playerDataBase.getOsszVereseg());
            System.out.println("Játszott meccsek: "+playerDataBase.getOsszJatszottMeccsek());
            System.out.println("Megtett lépések: "+playerDataBase.getOsszLepesek());
        } else {
            System.out.println("Még nem létezik a profilod, létrehoztunk neked egy újat!");
            playerDataBase.ujPlayerTxt(player);
        }

 */
        board.tablaLetrehoz();
        System.out.println(board.mezo);
        board.tablaFrissit();
        board.lep();
        board.tablaFrissit();
    }
}