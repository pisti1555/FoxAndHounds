package hu.nye.progtech.Beadando;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class Config {

    Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/PD", "sa", "pass");

    public Config() throws SQLException {
    }

    @Bean(initMethod = "game")
    Menu menu(PlayerDatabase pd, Board b) {
        return new Menu(pd, b);
    }

    @Bean
    PlayerDatabase playerDatabase() {
        return new PlayerDatabase(connection);
    }

    @Bean
    Board board() {
        return new Board();
    }
}
