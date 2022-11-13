package hu.nye.progtech.Beadando;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.io.*;

public class PlayerDatabaseTest {
    @Test
    void osszStat() {
        int osszGyozelmek = 0;
        int osszVereseg = 0;
        int osszJatszottMeccsek = 0;
        int osszLepesek = 0;
        try {
            BufferedReader olvas = new BufferedReader(new FileReader("src\\test\\java\\hu\\nye\\progtech\\Beadando\\test.txt"));
            osszGyozelmek = Integer.parseInt(olvas.readLine());
            osszVereseg = Integer.parseInt(olvas.readLine());
            osszJatszottMeccsek = Integer.parseInt((olvas.readLine()));
            osszLepesek = Integer.parseInt(olvas.readLine());
            olvas.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        boolean okes = false;
        if(osszGyozelmek==5&&osszVereseg==5&&osszLepesek==5&&osszJatszottMeccsek==5) {
            okes = true;
        }
        assertTrue(okes);
    }
}
