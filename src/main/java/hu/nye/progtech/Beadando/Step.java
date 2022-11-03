package hu.nye.progtech.Beadando;

import java.util.Random;
import java.util.Scanner;

public class Step {
    
    private int[][] tabla;
    private final int FOX = 1;
    private final int DOG = 2;
    private Position fox;
    private Position[] dog;
    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();


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
            fox = new Position(mezo, (mezo/2)+1);
            for (int i = 1; i < tabla.length; i += 2) {
                tabla[0][i] = DOG;
                dog[kutyaSzamlalo] = new Position(0, i);
                kutyaSzamlalo++;
            }
        } else {
            tabla[mezo][mezo / 2] = FOX;
            fox = new Position(mezo, mezo/2);
            for (int i = 1; i < tabla.length; i += 2) {
                tabla[0][i] = DOG;
                dog[kutyaSzamlalo] = new Position(0, i);
                kutyaSzamlalo++;
            }
        }
    }

    
    protected void lep() {
        int mezo = tabla.length-1;
        System.out.println("1 = Fel-Balra | 2 = Fel-Jobbra | 3 = Le-Balra | 4 = Le-Jobbra");
        int lepes = scanner.nextInt();

        switch (lepes) {
            case 1: {
                if (fox.sor - 1 > mezo || fox.oszlop - 1 > mezo || fox.sor - 1 < 0 || fox.oszlop - 1 < 0) {
                    System.out.println("Helytelen lépés");
                    lep();
                } else {
                    if(tabla[fox.sor-1][fox.oszlop-1] == 0) {
                        tabla[fox.sor-1][fox.oszlop-1] = FOX;
                        tabla[fox.sor][fox.oszlop] = 0;
                        fox.sor = fox.sor-1;
                        fox.oszlop = fox.oszlop-1;
                    }else {
                        System.out.println("Helytelen lépés - Foglalt mező");
                        lep();
                    }
                }
            } break;

            case 2: {
                if (fox.sor - 1 > mezo || fox.oszlop + 1 > mezo || fox.sor - 1 < 0 || fox.oszlop + 1 < 0) {
                    System.out.println("Helytelen lépés");
                    lep();
                } else {
                    if(tabla[fox.sor-1][fox.oszlop+1] == 0) {
                        tabla[fox.sor-1][fox.oszlop+1] = FOX;
                        tabla[fox.sor][fox.oszlop] = 0;
                        fox.sor = fox.sor-1;
                        fox.oszlop = fox.oszlop+1;
                    }else {
                        System.out.println("Helytelen lépés - Foglalt mező");
                        lep();
                    }
                }
            } break;

            case 3: {
                if (fox.sor + 1 > mezo || fox.oszlop - 1 > mezo || fox.sor + 1 < 0 || fox.oszlop - 1 < 0) {
                    System.out.println("Helytelen lépés");
                    lep();
                } else {
                    if(tabla[fox.sor+1][fox.oszlop-1] == 0) {
                        tabla[fox.sor+1][fox.oszlop-1] = FOX;
                        tabla[fox.sor][fox.oszlop] = 0;
                        fox.sor = fox.sor+1;
                        fox.oszlop = fox.oszlop-1;
                    }else {
                        System.out.println("Helytelen lépés - Foglalt mező");
                        lep();
                    }
                }
            } break;

            case 4: {
                if (fox.sor + 1 > mezo || fox.oszlop + 1 > mezo || fox.sor - 1 < 0 || fox.oszlop + 1 < 0) {
                    System.out.println("Helytelen lépés");
                    lep();
                } else {
                    if(tabla[fox.sor+1][fox.oszlop+1] == 0) {
                        tabla[fox.sor+1][fox.oszlop+1] = FOX;
                        tabla[fox.sor][fox.oszlop] = 0;
                        fox.sor = fox.sor+1;
                        fox.oszlop = fox.oszlop+1;
                    }else {
                        System.out.println("Helytelen lépés - Foglalt mező");
                        lep();
                    }
                }
            } break;

            default: {
                System.out.println("Ismeretlen parancs");
                lep();
            }
        }
    }

    protected void kutyaLep() {
        int mezo = tabla.length-1;
        int i = random.nextInt(dog.length-1);
        int lepes = random.nextInt(4);

        switch(lepes) {
            case 0: {
                if (dog[i].sor - 1 > mezo || dog[i].oszlop - 1 > mezo || dog[i].sor - 1 < 0 || dog[i].oszlop - 1 < 0) {
                    kutyaLep();
                } else {
                    if(tabla[dog[i].sor-1][dog[i].oszlop-1] == 0) {
                        tabla[dog[i].sor-1][dog[i].oszlop-1] = DOG;
                        tabla[dog[i].sor][dog[i].oszlop] = 0;
                        dog[i].sor = dog[i].sor-1;
                        dog[i].oszlop = dog[i].oszlop-1;
                    }else {
                        kutyaLep();
                    }
                }
            }break;
            case 1: {
                if (dog[i].sor - 1 > mezo || dog[i].oszlop + 1 > mezo || dog[i].sor - 1 < 0 || dog[i].oszlop + 1 < 0) {
                    kutyaLep();
                } else {
                    if(tabla[dog[i].sor-1][dog[i].oszlop+1] == 0) {
                        tabla[dog[i].sor-1][dog[i].oszlop+1] = DOG;
                        tabla[dog[i].sor][dog[i].oszlop] = 0;
                        dog[i].sor = dog[i].sor-1;
                        dog[i].oszlop = dog[i].oszlop+1;
                    }else {
                        kutyaLep();
                    }
                }
            }break;
            case 2: {
                if (dog[i].sor + 1 > mezo || dog[i].oszlop - 1 > mezo || dog[i].sor + 1 < 0 || dog[i].oszlop - 1 < 0) {
                    kutyaLep();
                } else {
                    if(tabla[dog[i].sor+1][dog[i].oszlop-1] == 0) {
                        tabla[dog[i].sor+1][dog[i].oszlop-1] = DOG;
                        tabla[dog[i].sor][dog[i].oszlop] = 0;
                        dog[i].sor = dog[i].sor+1;
                        dog[i].oszlop = dog[i].oszlop-1;
                    }else {
                        kutyaLep();
                    }
                }
            }break;
            case 3: {
                if (dog[i].sor + 1 > mezo || dog[i].oszlop + 1 > mezo || dog[i].sor - 1 < 0 || dog[i].oszlop + 1 < 0) {
                    kutyaLep();
                } else {
                    if(tabla[dog[i].sor+1][dog[i].oszlop+1] == 0) {
                        tabla[dog[i].sor+1][dog[i].oszlop+1] = DOG;
                        tabla[dog[i].sor][dog[i].oszlop] = 0;
                        dog[i].sor = dog[i].sor+1;
                        dog[i].oszlop = dog[i].oszlop+1;
                    }else {
                        kutyaLep();
                    }
                }
            }break;
        }
    }

    protected int[][] tablaClone() {
        return tabla.clone();
    }

    protected boolean gyozelem() {
        if(fox.sor==0) {
            return true;
        }else {
            return false;
        }
    }

    protected boolean balraFelLepE() {
        int s = fox.sor;
        int o = fox.oszlop;
        if(s-1>= 0) {
            if(o-1>= 0) {
                if(tabla[s-1][o-1]==0) {
                    return true;
                }else return false;
            }else return false;
        }else return false;
    }

    protected boolean balraLeLepE() {
        int s = fox.sor;
        int o = fox.oszlop;
        if(s+1< tabla.length) {
            if(o-1>= 0) {
                if(tabla[s+1][o-1]==0) {
                    return true;
                }else return false;
            }else return false;
        }else return false;
    }

    protected boolean jobbraFelLepE() {
        int s = fox.sor;
        int o = fox.oszlop;
        if(s-1>= 0) {
            if(o+1< tabla.length) {
                if(tabla[s-1][o+1]==0) {
                    return true;
                }else return false;
            }else return false;
        }else return false;
    }

    protected boolean jobbraLeLepE() {
        int s = fox.sor;
        int o = fox.oszlop;
        if(s+1< tabla.length) {
            if(o+1< tabla.length) {
                if(tabla[s+1][o+1]==0) {
                    return true;
                }else return false;
            }else return false;
        }else return false;
    }
}
