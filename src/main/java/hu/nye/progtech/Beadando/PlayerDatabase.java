package hu.nye.progtech.Beadando;

public class PlayerDatabase {
    private String nev;
    private static int gyozelmekSzama;
    private static int veresegekSzama;
    private static int jatszottMeccsekSzama;

    public PlayerDatabase() {
        this.nev = nev;
        this.gyozelmekSzama = gyozelmekSzama;
        this.veresegekSzama = veresegekSzama;
        this.jatszottMeccsekSzama = jatszottMeccsekSzama;
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
}
