package hu.nye.progtech.Beadando;

import org.springframework.stereotype.Repository;

import java.io.*;
import java.sql.*;
import java.util.Scanner;

public class PlayerDatabase {
    private String nev;
    private int id;
    private int gyozelmekSzama = 0;
    private int veresegekSzama = 0;
    private int jatszottMeccsekSzama = 0;
    private static int lepesekSzama = 0;

    private int osszGyozelmek;
    private int osszVereseg;
    private int osszJatszottMeccsek;
    private int osszLepesek;

    Connection connection;

    public PlayerDatabase(Connection connection) {
        this.connection = connection;
    }

    /**

    protected void playerTxt() {
        Scanner scanner = new Scanner(System.in);
        BufferedWriter ir = null;
        try {
            System.out.println("Mi a neved: ");
            nev = scanner.nextLine();
            File player = new File("src\\main\\resources\\Players\\"+nev.toLowerCase()+".txt");
            if(!player.exists()) {
                System.out.println("Még nem létezik mentésed, létrehozásra került egy új ezen a néven");
                ir = new BufferedWriter(new FileWriter(player));
                ir.write(nev);
                ir.newLine();
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
            BufferedReader olvas = new BufferedReader(new FileReader("src\\main\\resources\\Players\\"+nev.toLowerCase()+".txt"));
            String temp = olvas.readLine();
            osszGyozelmek = Integer.parseInt(olvas.readLine());
            osszVereseg = Integer.parseInt(olvas.readLine());
            osszJatszottMeccsek = Integer.parseInt((olvas.readLine()));
            osszLepesek = Integer.parseInt(olvas.readLine());
            olvas.close();
            System.out.println("Név: " + nev);
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
            BufferedReader olvas = new BufferedReader(new FileReader("src\\main\\resources\\Players\\"+nev.toLowerCase()+".txt"));
            String temp = olvas.readLine();
            osszGyozelmek = Integer.parseInt(olvas.readLine());
            osszVereseg = Integer.parseInt(olvas.readLine());
            osszJatszottMeccsek = Integer.parseInt((olvas.readLine()));
            osszLepesek = Integer.parseInt(olvas.readLine());
            olvas.close();
            BufferedWriter ir = new BufferedWriter(new FileWriter("src\\main\\resources\\Players\\"+nev.toLowerCase()+".txt"));
            ir.write(nev);
            ir.newLine();
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
     **/

    public void createTableIfNotExists() throws SQLException {

        String command = "CREATE TABLE IF NOT EXISTS PLAYERDATABASE " +
                "(ID INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                " NEV VARCHAR(255), " +
                " JATSZOTTMECCSEK INTEGER, " +
                " GYOZELMEK INTEGER, " +
                " VERESEGEK INTEGER, " +
                " LEPESEK INTEGER)";

        Statement st = connection.createStatement();
        st.executeUpdate(command);
    }

    public void logIn() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Írd be a neved: ");
        nev = scanner.next();
    }

    public boolean findPlayer() throws SQLException {
        String find = "SELECT NEV FROM PLAYERDATABASE";
        Statement st = connection.createStatement();
        ResultSet resultSet = st.executeQuery(find);
        String nevv = null;
        int i=0;
        while (resultSet.next()) {
            nevv = resultSet.getString("NEV");
            if(nevv.equals(nev)) {
                i++;
            }
        }
        return i != 0;
    }

    public void osszStat() throws SQLException {
        System.out.println("Mentésed állapota: ");
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM PLAYERDATABASE WHERE NEV = '" + nev + "'");
        while(rs.next()) {
            id = rs.getInt("ID");
            nev = rs.getString("NEV");
            osszJatszottMeccsek = rs.getInt("JATSZOTTMECCSEK");
            osszGyozelmek = rs.getInt("GYOZELMEK");
            osszVereseg = rs.getInt("VERESEGEK");
            osszLepesek = rs.getInt("LEPESEK");

            System.out.println("Név: "+nev);
            System.out.println("Játszott meccsek száma: "+osszJatszottMeccsek);
            System.out.println("Győzelmek száma: "+osszGyozelmek);
            System.out.println("Vereségek száma: "+osszVereseg);
            System.out.println("Megtett lépések száma: "+osszLepesek);
        }
    }

    public void statValtozas() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM PLAYERDATABASE WHERE NEV = '" + nev + "'");
        while(rs.next()) {
            id = rs.getInt("ID");
            nev = rs.getString("NEV");
            osszJatszottMeccsek = rs.getInt("JATSZOTTMECCSEK");
            osszGyozelmek = rs.getInt("GYOZELMEK");
            osszVereseg = rs.getInt("VERESEGEK");
            osszLepesek = rs.getInt("LEPESEK");
        }

        String command = "UPDATE PLAYERDATABASE SET(JATSZOTTMECCSEK, GYOZELMEK, VERESEGEK, LEPESEK) = VALUES(?, ?, ?, ?) WHERE NEV = ?";
        PreparedStatement st = connection.prepareStatement(command);
        st.setInt(1, osszJatszottMeccsek+jatszottMeccsekSzama);
        st.setInt(2, osszGyozelmek+gyozelmekSzama);
        st.setInt(3, osszVereseg+veresegekSzama);
        st.setInt(4, osszLepesek+lepesekSzama);
        st.setString(5, nev);
        st.executeUpdate();
        lepesekSzama=0;
        gyozelmekSzama=0;
        veresegekSzama=0;
        jatszottMeccsekSzama=0;
    }

    public void ujPlayer() throws SQLException {
        String insert = "INSERT INTO PLAYERDATABASE (NEV, JATSZOTTMECCSEK, GYOZELMEK, VERESEGEK, LEPESEK) VALUES(?, 0, 0, 0, 0)";
        PreparedStatement st = connection.prepareStatement(insert);
        st.setString(1, nev);
        st.executeUpdate();
        System.out.println("Nem létezik mentésed, létrehozásra került egy új");
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

    public String getNev() {return nev;}
}