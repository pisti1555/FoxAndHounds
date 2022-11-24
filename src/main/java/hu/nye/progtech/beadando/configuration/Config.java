package hu.nye.progtech.beadando.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import hu.nye.progtech.beadando.database.Player;
import hu.nye.progtech.beadando.database.PlayerDatabase;
import hu.nye.progtech.beadando.game.Board;
import hu.nye.progtech.beadando.menu.Menu;
import hu.nye.progtech.beadando.menu.Run;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Springhez kellenek ezek a cuccok.
 */
@Configuration
public class Config {

    Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/PD", "sa", "pass");

    public Config() throws SQLException {
    }

    @Bean
    Menu menu() {
        return new Menu(playerDatabase(), player(), board());
    }

    @Bean(initMethod = "runGame")
    Run run() {
        return new Run(menu(), playerDatabase());
    }

    @Bean
    PlayerDatabase playerDatabase() {
        return new PlayerDatabase(connection);
    }

    @Bean
    Player player() {
        return new Player(connection, playerDatabase());
    }

    @Bean
    Board board() {
        return new Board();
    }
}
