package hu.nye.progtech.Beadando;

import java.io.*;
import java.util.Locale;

public class PlayerDatabase {
    private String nev;
    private int gyozelmekSzama = 0;
    private int veresegekSzama = 0;
    private int jatszottMeccsekSzama = 0;
    private int lepesekSzama = 0;

    public int osszGyozelmek;
    public int osszVereseg;
    public int osszJatszottMeccsek;
    public int osszLepesek;

    public void ujPlayerTxt() {
        BufferedWriter ir = null;
        try {
            ir = new BufferedWriter(new FileWriter(nev.toUpperCase(Locale.ROOT)+".txt"));
            ir.write(Integer.toString(0));
            ir.newLine();
            ir.write(Integer.toString(0));
            ir.newLine();
            ir.write(Integer.toString(0));
            ir.newLine();
            ir.write(Integer.toString(0));
            ir.close();
        } catch (IOException e) {
        e.printStackTrace();
    }
    }

    public void osszStat() {
        try {
            BufferedReader olvas = new BufferedReader(new FileReader(nev.toUpperCase(Locale.ROOT)+".txt"));
            osszGyozelmek = Integer.parseInt(olvas.readLine());
            osszVereseg = Integer.parseInt(olvas.readLine());
            osszJatszottMeccsek = Integer.parseInt((olvas.readLine()));
            osszLepesek = Integer.parseInt(olvas.readLine());
            olvas.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void statValtozas() {
        try {
            osszStat();
            BufferedWriter ir = new BufferedWriter(new FileWriter(nev.toUpperCase(Locale.ROOT)+".txt"));
            ir.write(Integer.toString(osszGyozelmek+gyozelmekSzama));
            ir.newLine();
            ir.write(Integer.toString(osszVereseg+veresegekSzama));
            ir.newLine();
            ir.write(Integer.toString(osszJatszottMeccsek+jatszottMeccsekSzama));
            ir.newLine();
            ir.write(Integer.toString(osszLepesek+lepesekSzama));
            ir.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void gyozelem() {
        this.setGyozelmekSzama(gyozelmekSzama++);
        this.setJatszottMeccsekSzama(jatszottMeccsekSzama++);
    }

    public void vereseg() {
        this.setVeresegekSzama(veresegekSzama++);
        this.setJatszottMeccsekSzama(jatszottMeccsekSzama++);
    }






    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public int getGyozelmekSzama() {
        return gyozelmekSzama;
    }

    public void setGyozelmekSzama(int gyozelmekSzama) {
        this.gyozelmekSzama = gyozelmekSzama;
    }

    public int getVeresegekSzama() {
        return veresegekSzama;
    }

    public void setVeresegekSzama(int veresegekSzama) {
        this.veresegekSzama = veresegekSzama;
    }

    public int getJatszottMeccsekSzama() {
        return jatszottMeccsekSzama;
    }

    public void setJatszottMeccsekSzama(int jatszottMeccsekSzama) {
        this.jatszottMeccsekSzama = jatszottMeccsekSzama;
    }

    public int getLepesekSzama() {
        return lepesekSzama;
    }

    public void setLepesekSzama(int lepesekSzama) {
        this.lepesekSzama = lepesekSzama;
    }

    public int getOsszGyozelmek() {
        return osszGyozelmek;
    }

    public void setOsszGyozelmek(int osszGyozelmek) {
        this.osszGyozelmek = osszGyozelmek;
    }

    public int getOsszVereseg() {
        return osszVereseg;
    }

    public void setOsszVereseg(int osszVereseg) {
        this.osszVereseg = osszVereseg;
    }

    public int getOsszJatszottMeccsek() {
        return osszJatszottMeccsek;
    }

    public void setOsszJatszottMeccsek(int osszJatszottMeccsek) {
        this.osszJatszottMeccsek = osszJatszottMeccsek;
    }

    public int getOsszLepesek() {
        return osszLepesek;
    }

    public void setOsszLepesek(int osszLepesek) {
        this.osszLepesek = osszLepesek;
    }
}
