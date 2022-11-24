package hu.nye.progtech.beadando.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * Letrehozza, megkeresi a jatekost.
 */
public class Player {

    private String nev;

    private final Connection connection;
    private final PlayerDatabase pd;

    public Player(Connection connection, PlayerDatabase pd) {
        this.connection = connection;
        this.pd = pd;
    }

    /**
     * Bekeri a neved.
     */
    public void logIn(Scanner scanner) {
        System.out.print("Írd be a neved: ");
        nev = scanner.next().toUpperCase();
        pd.setNev(nev);
    }

    /**
     * Arra van hogy megnezzuk uj-e a jatekos vagy jatszott-e mar.
     */
    public boolean findPlayer() throws SQLException {
        String find = "SELECT NEV FROM PLAYERDATABASE";
        Statement st = connection.createStatement();
        ResultSet resultSet = st.executeQuery(find);
        String nevv;
        int i = 0;
        while (resultSet.next()) {
            nevv = resultSet.getString("NEV");
            if (nevv.equals(nev)) {
                i++;
            }
        }
        return i != 0;
    }

    /**
     * Ha nem letezik a jatekos, ezzel szurunk be egy ujat.
     */
    public void ujPlayer() throws SQLException {
        String insert = "INSERT INTO PLAYERDATABASE (NEV, JATSZOTTMECCSEK, GYOZELMEK, VERESEGEK, LEPESEK) VALUES(?, 0, 0, 0, 0)";
        PreparedStatement st = connection.prepareStatement(insert);
        st.setString(1, nev);
        st.executeUpdate();
        System.out.println("Nem létezik mentésed, létrehozásra került egy új");
    }
}
