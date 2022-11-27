package hu.nye.progtech.beadando.game;

import hu.nye.progtech.beadando.menu.Menu;
import jakarta.xml.bind.JAXBException;

import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

/**
 * Lepes.
 */
public class Step {

    private int[][] tabla;
    private static final int FOX = 1;
    private static final int DOG = 2;
    private boolean exit = false;
    private boolean mentes = false;
    private Position fox;
    private Position[] dog;
    private final Scanner scanner = new Scanner(System.in);
    private final Random random = new Random();

    /**
     * Letrehoz n meretu tablat, feltolti babukkal, es a pozikat elmenti.
     */
    public void tablaLetrehoz(int n) {
        tabla = new int[n][n];
        int mezo = tabla.length - 1;
        int kutyakSzama = n / 2;
        dog = new Position[kutyakSzama];
        int kutyaSzamlalo = 0;

        for (int i = 0; i < tabla.length; i++) {
            for (int j = 0; j < tabla.length; j++) {
                tabla[i][j] = 0;
            }
        }

        if ((n / 2) % 2 == 0) {
            tabla[mezo][(mezo / 2) + 1] = FOX;
            fox = new Position(mezo, (mezo / 2) + 1, FOX);
            for (int i = 1; i < tabla.length; i += 2) {
                tabla[0][i] = DOG;
                dog[kutyaSzamlalo] = new Position(0, i, DOG);
                kutyaSzamlalo++;
            }
        } else {
            tabla[mezo][mezo / 2] = FOX;
            fox = new Position(mezo, mezo / 2, FOX);
            for (int i = 1; i < tabla.length; i += 2) {
                tabla[0][i] = DOG;
                dog[kutyaSzamlalo] = new Position(0, i, DOG);
                kutyaSzamlalo++;
            }
        }
    }

    public void pozicioKereses(int[][] innenMasol) {
        tabla = innenMasol;
        dog = new Position[tabla.length/2];
        int kutyaszamlalo = 0;
        for (int i = 0; i < tabla.length; i++) {
            for (int j = 0; j < tabla.length; j++) {
                if(tabla[i][j] == DOG) {
                    dog[kutyaszamlalo] = new Position(i, j, DOG);
                    kutyaszamlalo++;
                }
                if(tabla[i][j] == FOX) {
                    fox = new Position(i, j, FOX);
                }
            }
        }
    }

    /**
     * Lep a tablan akarmivel amit beadunk neki.
     */
    public void lep(Position x) {
        exit = false;
        mentes = false;

        if (x.tipus == 1) {
            System.out.println("1 = Fel-Balra | 2 = Fel-Jobbra | 3 = Le-Balra | 4 = Le-Jobbra | 9 = Kilépés");
            int lepes = scanner.nextInt() - 1;

            switch (lepes) {
                case 0: {
                    if (bfl(x, tabla)) {
                        tabla[x.sor - 1][x.oszlop - 1] = x.tipus;
                        tabla[x.sor][x.oszlop] = 0;
                        x.sor = x.sor - 1;
                        x.oszlop = x.oszlop - 1;
                    } else {
                        System.out.println("Helytelen lépés");
                        lep(x);
                    }
                }
                break;
                case 1: {
                    if (jfl(x, tabla)) {
                        tabla[x.sor - 1][x.oszlop + 1] = x.tipus;
                        tabla[x.sor][x.oszlop] = 0;
                        x.sor = x.sor - 1;
                        x.oszlop = x.oszlop + 1;
                    } else {
                        System.out.println("Helytelen lépés");
                        lep(x);
                    }
                }
                break;
                case 2: {
                    if (bll(x, tabla)) {
                        tabla[x.sor + 1][x.oszlop - 1] = x.tipus;
                        tabla[x.sor][x.oszlop] = 0;
                        x.sor = x.sor + 1;
                        x.oszlop = x.oszlop - 1;
                    } else {
                        System.out.println("Helytelen lépés");
                        lep(x);
                    }
                }
                break;
                case 3: {
                    if (jll(x, tabla)) {
                        tabla[x.sor + 1][x.oszlop + 1] = x.tipus;
                        tabla[x.sor][x.oszlop] = 0;
                        x.sor = x.sor + 1;
                        x.oszlop = x.oszlop + 1;
                    } else {
                        System.out.println("Helytelen lépés");
                        lep(x);
                    }
                }
                break;
                case 8 : {
                        kilepes();
                }break;
                default: {
                    System.out.println("Ismeretlen parancs");
                    lep(x);
                }
            }
        } else {
            int lepes = random.nextInt(4);
            switch (lepes) {
                case 0: {
                    if (bfl(x, tabla)) {
                        tabla[x.sor - 1][x.oszlop - 1] = x.tipus;
                        tabla[x.sor][x.oszlop] = 0;
                        x.sor = x.sor - 1;
                        x.oszlop = x.oszlop - 1;
                    } else {
                        int i = random.nextInt(dog.length - 1);
                        lep(dog[i]);
                    }
                }
                break;
                case 1: {
                    if (jfl(x, tabla)) {
                        tabla[x.sor - 1][x.oszlop + 1] = x.tipus;
                        tabla[x.sor][x.oszlop] = 0;
                        x.sor = x.sor - 1;
                        x.oszlop = x.oszlop + 1;
                    } else {
                        int i = random.nextInt(dog.length - 1);
                        lep(dog[i]);
                    }
                }
                break;
                case 2: {
                    if (bll(x, tabla)) {
                        tabla[x.sor + 1][x.oszlop - 1] = x.tipus;
                        tabla[x.sor][x.oszlop] = 0;
                        x.sor = x.sor + 1;
                        x.oszlop = x.oszlop - 1;
                    } else {
                        int i = random.nextInt(dog.length - 1);
                        lep(dog[i]);
                    }
                }
                break;
                case 3: {
                    if (jll(x, tabla)) {
                        tabla[x.sor + 1][x.oszlop + 1] = x.tipus;
                        tabla[x.sor][x.oszlop] = 0;
                        x.sor = x.sor + 1;
                        x.oszlop = x.oszlop + 1;
                    } else {
                        int i = random.nextInt(dog.length - 1);
                        lep(dog[i]);
                    }
                }
                break;
                default: {
                    int i = random.nextInt(dog.length - 1);
                    lep(dog[i]);
                }
            }
        }
    }

    /**
     * Lemasolja a tablat.
     */
    public int[][] tablaClone() {
        return tabla.clone();
    }

    /**
     * Ha a roka sora a legfelsore er, akkor nyer es igazat ad vissza.
     */
    public boolean gyozelem(Position x) {
        if (x.sor == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Teszteli hogy lehetseges-e a lepes balra-fel.
     */
    public boolean bfl(Position x, int[][] tabla) {
        int s = x.sor;
        int o = x.oszlop;
        if (s - 1 >= 0) {
            if (o - 1 >= 0) {
                if (tabla[s - 1][o - 1] == 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * Teszteli hogy lehetseges-e a lepes balra-le.
     */
    public boolean bll(Position x, int[][] tabla) {
        int s = x.sor;
        int o = x.oszlop;
        if (s + 1 < tabla.length) {
            if (o - 1 >= 0) {
                if (tabla[s + 1][o - 1] == 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * Teszteli hogy lehetseges-e a lepes jobbra-fel.
     */
    public boolean jfl(Position x, int[][] tabla) {
        int s = x.sor;
        int o = x.oszlop;
        if (s - 1 >= 0) {
            if (o + 1 < tabla.length) {
                if (tabla[s - 1][o + 1] == 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * Teszteli hogy lehetseges-e a lepes jobbra-le.
     */
    public boolean jll(Position x, int[][] tabla) {
        int s = x.sor;
        int o = x.oszlop;
        if (s + 1 < tabla.length) {
            if (o + 1 < tabla.length) {
                if (tabla[s + 1][o + 1] == 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public void kilepes() {
        System.out.println("Biztosan ki akarsz lépni? 1 = Igen | 2 = Nem");
        int valasz = scanner.nextInt();
        switch(valasz) {
            case 1: {
                exit = true;
                mentes();
                break;
            }
            case 2: {
            }break;
            default: {
                System.out.println("Ismeretlen parancs");
                kilepes();
            }
        }
    }

    public void mentes() {
        System.out.println("El kívánja menteni a jelenlegi játékállást? 1 = Igen | 2 = Nem");
        int valasz = scanner.nextInt();
        switch(valasz) {
            case 1: {
                mentes = true;
                break;
            }
            case 2: {
            }break;
            default: {
                System.out.println("Ismeretlen parancs");
                mentes();
            }
        }
    }

    /**
     * public metodus visszaadja a rokat.
     */
    public Position getFox() {
        return fox;
    }

    /**
     * visszaad egy random kutyat a tombbol.
     */
    public Position getDog() {
        int i = random.nextInt(dog.length - 1);
        return dog[i];
    }

    public boolean isExit() {
        return exit;
    }

    public boolean isMentes() {
        return mentes;
    }
}