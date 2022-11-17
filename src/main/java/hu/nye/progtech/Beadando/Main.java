package hu.nye.progtech.Beadando;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        String URL = "jdbc:h2:tcp://localhost/~/PD";
        String un = "sa";
        String pw = "pass";
        Connection connection = DriverManager.getConnection(URL, un, pw);

        //ApplicationContext app = new AnnotationConfigApplicationContext("hu.nye.progtech.Beadando");
        //Menu menu = app.getBean(Menu.class);
        PlayerDatabase pd = new PlayerDatabase(connection);
        Board b = new Board();
        Menu menu = new Menu(pd, b);
        menu.start();
        menu.menu();



    }
}