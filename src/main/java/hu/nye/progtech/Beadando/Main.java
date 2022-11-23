package hu.nye.progtech.Beadando;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        new AnnotationConfigApplicationContext("hu.nye.progtech.Beadando");
    }
}