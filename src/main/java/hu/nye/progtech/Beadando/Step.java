package hu.nye.progtech.Beadando;

import java.util.Random;
import java.util.Scanner;

public class Step {

    Board board;
    
    private int[][] tabla;
    private final int FOX = 1;
    private final int DOG = 2;
    private Position fox;
    private Position[] dog;
    private final Scanner scanner = new Scanner(System.in);
    private final Random random = new Random();

    /*public int[][] tablaLetrehozz() {
        //TODO
    }
     */


    protected void tablaLetrehoz(int N) {
        tabla = new int[N][N];
        int mezo = tabla.length - 1;
        int kutyakSzama = N/2;
        dog = new Position[kutyakSzama];
        int kutyaSzamlalo = 0;

        for (int i = 0; i < tabla.length; i++) {
            for (int j = 0; j < tabla.length; j++) {
                tabla[i][j] = 0;
            }
        }

        if ((N / 2) % 2 == 0) {
            tabla[mezo][(mezo / 2) + 1] = FOX;
            fox = new Position(mezo, (mezo/2)+1, FOX);
            for (int i = 1; i < tabla.length; i += 2) {
                tabla[0][i] = DOG;
                dog[kutyaSzamlalo] = new Position(0, i, DOG);
                kutyaSzamlalo++;
            }
        } else {
            tabla[mezo][mezo / 2] = FOX;
            fox = new Position(mezo, mezo/2, FOX);
            for (int i = 1; i < tabla.length; i += 2) {
                tabla[0][i] = DOG;
                dog[kutyaSzamlalo] = new Position(0, i, DOG);
                kutyaSzamlalo++;
            }
        }
    }

    
    protected void lep(Position x) {

        if(x.tipus==1) {
            System.out.println("1 = Fel-Balra | 2 = Fel-Jobbra | 3 = Le-Balra | 4 = Le-Jobbra");
            int lepes = scanner.nextInt()-1;

            switch(lepes) {
                case 0: {
                    if (balraFelLepE(x, tabla)) {
                        tabla[x.sor-1][x.oszlop-1] = x.tipus;
                        tabla[x.sor][x.oszlop] = 0;
                        x.sor = x.sor-1;
                        x.oszlop = x.oszlop-1;
                    }else {
                        System.out.println("Helytelen lépés");
                        lep(x);
                    }
                }break;
                case 1: {
                    if (jobbraFelLepE(x, tabla)) {
                        tabla[x.sor-1][x.oszlop+1] = x.tipus;
                        tabla[x.sor][x.oszlop] = 0;
                        x.sor = x.sor-1;
                        x.oszlop = x.oszlop+1;
                    } else {
                        System.out.println("Helytelen lépés");
                        lep(x);
                    }
                }break;
                case 2: {
                    if (balraLeLepE(x, tabla)) {
                        tabla[x.sor + 1][x.oszlop - 1] = x.tipus;
                        tabla[x.sor][x.oszlop] = 0;
                        x.sor = x.sor + 1;
                        x.oszlop = x.oszlop - 1;
                    }else {
                        System.out.println("Helytelen lépés");
                        lep(x);
                    }
                }break;
                case 3: {
                    if (jobbraLeLepE(x, tabla)) {
                        tabla[x.sor+1][x.oszlop+1] = x.tipus;
                        tabla[x.sor][x.oszlop] = 0;
                        x.sor = x.sor+1;
                        x.oszlop = x.oszlop+1;
                    } else {
                        System.out.println("Helytelen lépés");
                        lep(x);
                    }
                }break;
            }
        }else {
            int lepes = random.nextInt(4);
            switch (lepes) {
                case 0: {
                    if (balraFelLepE(x, tabla)) {
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
                    if (jobbraFelLepE(x, tabla)) {
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
                    if (balraLeLepE(x, tabla)) {
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
                    if (jobbraLeLepE(x, tabla)) {
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


    protected int[][] tablaClone() {
        return tabla.clone();
    }

    protected boolean gyozelem(Position x) {
        if(x.sor==0) {
            return true;
        }else {
            return false;
        }
    }

    protected boolean balraFelLepE(Position x, int[][] tabla) {
        int s = x.sor;
        int o = x.oszlop;
        if(s-1>= 0) {
            if(o-1>= 0) {
                if(tabla[s-1][o-1]==0) {
                    return true;
                }else return false;
            }else return false;
        }else return false;
    }

    protected boolean balraLeLepE(Position x, int[][] tabla) {
        int s = x.sor;
        int o = x.oszlop;
        if(s+1< tabla.length) {
            if(o-1>= 0) {
                if(tabla[s+1][o-1]==0) {
                    return true;
                }else return false;
            }else return false;
        }else return false;
    }

    protected boolean jobbraFelLepE(Position x, int[][] tabla) {
        int s = x.sor;
        int o = x.oszlop;
        if(s-1>= 0) {
            if(o+1< tabla.length) {
                if(tabla[s-1][o+1]==0) {
                    return true;
                }else return false;
            }else return false;
        }else return false;
    }

    protected boolean jobbraLeLepE(Position x, int[][] tabla) {
        int s = x.sor;
        int o = x.oszlop;
        if(s+1< tabla.length) {
            if(o+1< tabla.length) {
                if(tabla[s+1][o+1]==0) {
                    return true;
                }else return false;
            }else return false;
        }else return false;
    }

    public Position getFox() {
        return fox;
    }

    public Position getDog() {
        int i = random.nextInt(dog.length-1);
        return dog[i];
    }
}