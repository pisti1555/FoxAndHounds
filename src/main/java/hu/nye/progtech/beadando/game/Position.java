package hu.nye.progtech.beadando.game;

/**
 * Lepesek nyomonkovetesehez kell.
 */
public class Position {
    public int sor;
    public int oszlop;
    public int tipus;

    public Position(int sor, int oszlop, int tipus) {
        this.sor = sor;
        this.oszlop = oszlop;
        this.tipus = tipus;
    }
}
