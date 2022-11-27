package hu.nye.progtech.beadando.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import hu.nye.progtech.beadando.database.Player;
import hu.nye.progtech.beadando.database.Stats;
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
        return new Menu(stat(), player(), board());
    }

    @Bean(initMethod = "runGame")
    Run run() {
        return new Run(menu(), stat());
    }

    @Bean
    Stats stat() {
        return new Stats(connection);
    }

    @Bean
    Player player() {
        return new Player(connection, stat());
    }

    @Bean
    Board board() {
        return new Board();
    }
}
