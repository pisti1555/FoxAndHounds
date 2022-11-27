package hu.nye.progtech.beadando.menu;

import java.sql.SQLException;

import hu.nye.progtech.beadando.database.Stats;
import jakarta.xml.bind.JAXBException;

/**
 * Azert hogy futtassa a jatekot egyben.
 */
public class Run {
    Menu menu;
    Stats stat;

    public Run(Menu menu, Stats stat) {
        this.menu = menu;
        this.stat = stat;
    }

    /**
     * Futtato metodus.
     */
    public void runGame() throws SQLException, JAXBException {
        stat.createTableIfNotExists();
        menu.start();
        menu.menu();
    }
}
