package practicaflota;

import java.util.Scanner;

public class JugadorIA extends Jugador {
    private int coordenada1Guardado;
    private int coordenada2Guardado;

    public JugadorIA(Scanner sc) {
        super(sc);
    }

    public int generarCoordenada1() {
        int coordenada1 = (int) (Math.random() * 10);
        return coordenada1;
    }

    public int generarCoordenada2() {
        int coordenada2 = (int) (Math.random() * 10);
        return coordenada2;
    }

    public String cambiarParaMostrarCoordenada2(int coordenada2) {
        String coordenada2String = "";
        switch (coordenada2) {
            case 0:
                coordenada2String = " A";
                break;
            case 1:
                coordenada2String = " B";
                break;
            case 2:
                coordenada2String = " C";
                break;
            case 3:
                coordenada2String = " D";
                break;
            case 4:
                coordenada2String = " E";
                break;
            case 5:
                coordenada2String = " F";
                break;
            case 6:
                coordenada2String = " G";
                break;
            case 7:
                coordenada2String = " H";
                break;
            case 8:
                coordenada2String = " I";
                break;
            case 9:
                coordenada2String = " J";
                break;
            default:
                break;
        }
        return coordenada2String;
    }

    public String generarSentido() {
        int opcion = (int) (Math.random() * 2 + 1);
        String sentido = "";
        switch (opcion) {
            case 1: {
                sentido = "V";
                break;
            }
            case 2: {
                sentido = "H";
                break;
            }
            default:
                break;
        }
        return sentido;
    }

    @Override
    public void pedirCoordenadas() {
        for (int i = 0; i < velero.length; i++) {
            int coordenada1 = generarCoordenada1();
            int coordenada2 = generarCoordenada2();
            String sentido = generarSentido();
            i = i - colocarBarcos(velero[i], 1, coordenada1, coordenada2, sentido);
        }
        for (int i = 0; i < buque.length; i++) {
            int coordenada1 = generarCoordenada1();
            int coordenada2 = generarCoordenada2();
            String sentido = generarSentido();
            i = i - colocarBarcos(buque[i], 3, coordenada1, coordenada2, sentido);
        }
        for (int i = 0; i < fragata.length; i++) {
            int coordenada1 = generarCoordenada1();
            int coordenada2 = generarCoordenada2();
            String sentido = generarSentido();
            i = i - colocarBarcos(fragata[i], 2, coordenada1, coordenada2, sentido);
        }
        for (int i = 0; i < portaviones.length; i++) {
            int coordenada1 = generarCoordenada1();
            int coordenada2 = generarCoordenada2();
            String sentido = generarSentido();
            i = i - colocarBarcos(portaviones[i], 4, coordenada1, coordenada2, sentido);
        }
    }

    @Override
    public int colocarBarcos(Ficha ficha, int nVeces, int coordenada1, int coordenada2, String sentido) {
        int i = 0;
        boolean barcoCabe = tableros.comprobarBarcoCabe(nVeces, coordenada1, coordenada2, sentido, ficha);
        if (barcoCabe == true) {
            boolean valido = tableros.validarCasilla(nVeces, coordenada1, coordenada2, sentido,
                    tableros.getTableroIA());
            if (valido == true) {
                tableros.colocarBarcosTableroIA(ficha, nVeces, coordenada1, coordenada2, sentido,
                        tableros.getTableroIA());
                i = 0;
                return i;
            } else {
                i = 1;
                return i;
            }
        } else {
            i = 1;
            return i;
        }
    }

//METODO PARA COMPORBAR SI YA SE HA ATACADO ESA CASILLA
    @Override
    public int[] comprobarAtacado(Ficha tableroContrario[][], int coordenada1, int coordenada2) {
        boolean valido = false;
        int coordenadas[] = new int[2];
        do {
            if (tableroContrario[coordenada1][coordenada2].isDado() == true) {
                coordenada1 = generarCoordenada1();
                coordenada2 = generarCoordenada2();
                coordenadas[0] = coordenada1;
                coordenadas[1] = coordenada2;
                valido = false;
            } else {
                valido = true;
            }
        } while (valido == false);
        return coordenadas;
    }

    public boolean[] atacarTableroIA(Ficha tableroContrario[][]) {
        int coordenada1 = generarCoordenada1();
        int coordenada2 = generarCoordenada2();
        int coordenadas[] = new int[2];
        boolean[] tocadOHundido = new boolean[2];
        boolean tocado = false;
        boolean hundido = false;
        if (tableroContrario[coordenada1][coordenada2].isDado() == true) {
            coordenadas = comprobarAtacado(tableroContrario, coordenada1, coordenada2);
            coordenada1 = coordenadas[0];
            coordenada2 = coordenadas[1];
        }
        String coordenada2String = cambiarParaMostrarCoordenada2(coordenada2);
        System.out.println("Coordenadas: " + coordenada1 + "," + coordenada2String);
        if (tableroContrario[coordenada1][coordenada2].getTipoFicha().equals("agua")) {
            tableroContrario[coordenada1][coordenada2] = casillaDada;
            System.out.println("Agua");
        } else {
            int vida = tableroContrario[coordenada1][coordenada2].getVida();
            tableroContrario[coordenada1][coordenada2].setVida(vida - 1);
            if (tableroContrario[coordenada1][coordenada2].getVida() == 0) {
                System.out.println("TOCADO Y HUNDIDO");
                hundido = true;
            } else {
                System.out.println("TOCADO");
                guardarCoordenada(tableroContrario, coordenada1, coordenada2);
            }
            tocado = true;
            tableroContrario[coordenada1][coordenada2] = casillaTocada;
            tocadOHundido[0] = tocado;
            tocadOHundido[1] = hundido;
        }
        return tocadOHundido;
    }

    public void guardarCoordenada(Ficha tableroContrario[][], int coordenada1, int coordenada2) {
        Ficha ficha = tableroContrario[coordenada1][coordenada2];
        for (int i = 0; i < tableroContrario.length; i++) {
            for (int j = 0; j < tableroContrario[0].length; j++) {
                Ficha f1 = tableroContrario[i][j];
                if (ficha.getSentido().equalsIgnoreCase("h")) {
                    if (f1.equals(ficha) && j != coordenada2) {
                        coordenada1Guardado = i;
                        coordenada2Guardado = j;
                        break;
                    }
                } else {
                    if (f1.equals(ficha) && i != coordenada1) {
                        coordenada1Guardado = i;
                        coordenada2Guardado = j;
                        break;
                    }
                }
            }
        }
    }

    public boolean[] atacarOtravez(Ficha tableroContrario[][]) {
        boolean tocadoOHundido[] = new boolean[2];
        boolean tocado = false;
        boolean hundido = false;
        int coordenada1 = coordenada1Guardado;
        int coordenada2 = coordenada2Guardado;
        int vida = tableroContrario[coordenada1][coordenada2].getVida();
        tableroContrario[coordenada1][coordenada2].setVida(vida - 1);
        String coordenada2String = cambiarParaMostrarCoordenada2(coordenada2);
        System.out.println("Coordenadas: " + coordenada1 + "," + coordenada2String);
        if (tableroContrario[coordenada1][coordenada2].getVida() == 0) {
            System.out.println("TOCADO Y HUNDIDO");
            hundido = true;
        } else {
            System.out.println("TOCADO");
            guardarCoordenada(tableroContrario, coordenada1, coordenada2);
        }
        tocado = true;
        tocadoOHundido[0] = tocado;
        tocadoOHundido[1] = hundido;
        tableroContrario[coordenada1][coordenada2] = casillaTocada;
        return tocadoOHundido;
    }
}
