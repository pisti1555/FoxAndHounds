package hu.nye.progtech.Beadando;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.sql.Connection;

public class PlayerDatabaseTest {

    @Mock
    PlayerDatabase pd;

    @Mock
    Connection c;

    @BeforeEach
    void bfe() {
        pd = new PlayerDatabase(c);
    }


    @Test
    void osszStatTest() {

    }

    @Test
    void createTableIfNotExistsTest() {

    }

    @Test
    void findPlayerTest() {

    }
}
