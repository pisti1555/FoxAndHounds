package hu.nye.progtech.beadando;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Futtatas.
 */
public class Main {
    /**
     * A main osztaly futtathato metodusa.
     */
    public static void main(String[] args) {

        new AnnotationConfigApplicationContext("hu.nye.progtech.beadando.configuration");
    }
}