package hu.nye.progtech.beadando;

import java.sql.SQLException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Futtatas.
 */
public class Main {
    /**
     * A main osztaly futtathato metodusa.
     */
    public static void main(String[] args) throws SQLException {

        new AnnotationConfigApplicationContext("hu.nye.progtech.beadando.configuration");
    }
}