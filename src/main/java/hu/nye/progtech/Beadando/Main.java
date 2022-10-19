package hu.nye.progtech.Beadando;

public class Main {
    public static void main(String[] args) {

        Menu menu = new Menu();
        PlayerDatabase playerDataBase = new PlayerDatabase();
        Board board = new Board();

        menu.start();
        playerDataBase.playerTxt();
        board.tablaLetrehoz();
        board.ismeteltLepes();


    }
}