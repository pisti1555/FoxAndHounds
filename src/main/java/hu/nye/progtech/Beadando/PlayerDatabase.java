package hu.nye.progtech.Beadando;

import java.io.*;
import java.util.Scanner;

public class PlayerDatabase {
    private String nev;
    private int gyozelmekSzama = 0;
    private int veresegekSzama = 0;
    private int jatszottMeccsekSzama = 0;
    private static int lepesekSzama = 0;

    private int osszGyozelmek;
    private int osszVereseg;
    private int osszJatszottMeccsek;
    private int osszLepesek;

    protected void playerTxt() {
        Scanner scanner = new Scanner(System.in);
        BufferedWriter ir = null;
        try {
            System.out.println("Mi a neved: ");
            nev = scanner.nextLine();
            File player = new File("src\\main\\java\\hu\\nye\\progtech\\Beadando\\Players\\"+nev.toLowerCase()+".txt");
            if(!player.exists()) {
                System.out.println("Még nem létezik mentésed, létrehozásra került egy új ezen a néven");
                ir = new BufferedWriter(new FileWriter(player));
                ir.write(Integer.toString(0));
                ir.newLine();
                ir.write(Integer.toString(0));
                ir.newLine();
                ir.write(Integer.toString(0));
                ir.newLine();
                ir.write(Integer.toString(0));
                ir.close();
            } else {
                System.out.println("Van létező mentés " + nev + " néven az alábbi adatokkal:\n");
                osszStat();
            }
        } catch (IOException e) {
        e.printStackTrace();
    }
    }

    protected void osszStat() {
        try {
            BufferedReader olvas = new BufferedReader(new FileReader("src\\main\\java\\hu\\nye\\progtech\\Beadando\\Players\\"+nev.toLowerCase()+".txt"));
            osszGyozelmek = Integer.parseInt(olvas.readLine());
            osszVereseg = Integer.parseInt(olvas.readLine());
            osszJatszottMeccsek = Integer.parseInt((olvas.readLine()));
            osszLepesek = Integer.parseInt(olvas.readLine());
            olvas.close();
            System.out.println("Győzelmek: " + osszGyozelmek);
            System.out.println("Vereségek: "+ osszVereseg);
            System.out.println("Játszott meccsek: "+ osszJatszottMeccsek);
            System.out.println("Megtett lépések: "+ osszLepesek);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    protected void statValtozas() {
        try {
            BufferedReader olvas = new BufferedReader(new FileReader("src\\main\\java\\hu\\nye\\progtech\\Beadando\\Players\\"+nev.toLowerCase()+".txt"));
            osszGyozelmek = Integer.parseInt(olvas.readLine());
            osszVereseg = Integer.parseInt(olvas.readLine());
            osszJatszottMeccsek = Integer.parseInt((olvas.readLine()));
            osszLepesek = Integer.parseInt(olvas.readLine());
            olvas.close();
            BufferedWriter ir = new BufferedWriter(new FileWriter("src\\main\\java\\hu\\nye\\progtech\\Beadando\\Players\\"+nev.toLowerCase()+".txt"));
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
        lepesekSzama=0;
        gyozelmekSzama=0;
        veresegekSzama=0;
        jatszottMeccsekSzama=0;
    }

    protected void gyozelem() {
        gyozelmekSzama++;
        jatszottMeccsekSzama++;
    }

    protected void vereseg() {
        veresegekSzama++;
        jatszottMeccsekSzama++;
    }


    protected void megtettLepes() {
        lepesekSzama++;
    }

    public int getLepesekSzama() {
        return lepesekSzama;
    }

    protected void setGyozelmekSzama(int gyozelmekSzama) {
        this.gyozelmekSzama = gyozelmekSzama;
    }

    protected void setVeresegekSzama(int veresegekSzama) {
        this.veresegekSzama = veresegekSzama;
    }

    protected void setJatszottMeccsekSzama(int jatszottMeccsekSzama) {
        this.jatszottMeccsekSzama = jatszottMeccsekSzama;
    }
}