package hu.nye.progtech.beadando.menu;

import java.sql.SQLException;

import hu.nye.progtech.beadando.database.PlayerDatabase;

/**
 * Azert hogy futtassa a jatekot egyben.
 */
public class Run {
    Menu menu;
    PlayerDatabase pd;

    public Run(Menu menu, PlayerDatabase pd) {
        this.menu = menu;
        this.pd = pd;
    }

    /**
     * Futtato metodus.
     */
    public void runGame() throws SQLException {
        pd.createTableIfNotExists();
        menu.start();
        menu.menu();
    }
}
