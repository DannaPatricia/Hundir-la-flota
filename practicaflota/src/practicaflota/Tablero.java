package practicaflota;

public class Tablero {
    protected Ficha tablero[][];
    protected Ficha tableroAux[][] = new Ficha[10][10];
    protected Ficha tableroIA[][];

    public Tablero() {
        tableroIA = new Ficha[10][10];
        tablero = new Ficha[10][10];
    }

    public Ficha[][] getTableroIA() {
        return tableroIA;
    }

    public void setTableroIA(Ficha[][] tableroIA) {
        this.tableroIA = tableroIA;
    }

    public Ficha[][] getTablero() {
        return tablero;
    }

    public void setTablero(Ficha[][] tablero) {
        this.tablero = tablero;
    }

    public void llenarTableros(Ficha tablero[][], Ficha tableroIA[][]) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                Ficha agua = new Ficha("agua");
                tablero[i][j] = agua;
            }
        }
        for (int i = 0; i < tableroIA.length; i++) {
            for (int j = 0; j < tableroIA[i].length; j++) {
                Ficha agua = new Ficha("agua");
                tableroIA[i][j] = agua;
            }
        }
    }

//TABLERO AUXILIAR PARA COMPROBAR QUE EL BARCO CABE
    public void llenarTableroAux() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                Ficha agua = new Ficha("agua");
                tableroAux[i][j] = agua;
            }
        }
    }

//MOSTRAR MIENTRAS COLOCA BARCOS
    public void mostrarTableroJugador() {
        int numero = 0;
        System.out.println("     	 MAR JUGADOR 1");
        System.out.println("     A  B  C  D  E  F  G  H  I  J ");
        System.out.println("");
        for (int i = 0; i < tablero.length; i++) {
            System.out.print(numero + "   ");
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.print(tablero[i][j].getContenido());
            }
            System.out.println("");
            numero++;
        }
    }

//METODO QUE IMPIDE QUE UN BARCO SE COLOQUE EN CASILLAS CONTIGUAS O ENCIMA DE OTRO
    public boolean validarCasilla(int nVeces, int coordenada1, int coordenada2, String sentido, Ficha tablero[][]) {
        boolean valido = false;
        if (sentido.equalsIgnoreCase("h")) {
            for (int j = 0; j < nVeces; j++) {
                if (tablero[coordenada1][coordenada2].isOcupado() == true) {
                    valido = false;
                    break;
                } else {
                    valido = true;
                }
                coordenada2++;
            }
        } else if (sentido.equalsIgnoreCase("v")) {
            for (int j = 0; j < nVeces; j++) {
                if (tablero[coordenada1][coordenada2].isOcupado() == true) {
                    valido = false;
                    break;
                } else {
                    valido = true;
                }
                coordenada1++;
            }
        }
        return valido;
    }

//METODO QUE ASIGNA COMO OCUPADAS LAS CASILLAS CONTIGUAS A LOS BARCOS
    public void asignarCasilla(Ficha ficha, int nVeces, int coordenada1, int coordenada2, String sentido,
            Ficha tablero[][]) {
        if (sentido.equalsIgnoreCase("h")) {
            for (int j = 0; j < nVeces; j++) {
                if (coordenada1 <= 5) {
                    try {
                        tablero[coordenada1][coordenada2] = ficha;
                        tablero[coordenada1 + 1][coordenada2].setOcupado(true);
                        tablero[coordenada1 - 1][coordenada2].setOcupado(true);
                    } catch (ArrayIndexOutOfBoundsException e) {
                    }
                }
                if (coordenada1 > 5) {
                    try {
                        tablero[coordenada1][coordenada2] = ficha;
                        tablero[coordenada1 - 1][coordenada2].setOcupado(true);
                        tablero[coordenada1 + 1][coordenada2].setOcupado(true);
                    } catch (ArrayIndexOutOfBoundsException e) {
                    }
                }
                if (coordenada2 <= 5) {
                    try {
                        tablero[coordenada1][coordenada2] = ficha;
                        tablero[coordenada1][coordenada2 + 1].setOcupado(true);
                        tablero[coordenada1][coordenada2 - 1].setOcupado(true);
                    } catch (ArrayIndexOutOfBoundsException e) {
                    }
                }
                if (coordenada2 > 5) {
                    try {
                        tablero[coordenada1][coordenada2] = ficha;
                        tablero[coordenada1][coordenada2 - 1].setOcupado(true);
                        tablero[coordenada1][coordenada2 + 1].setOcupado(true);
                    } catch (ArrayIndexOutOfBoundsException e) {
                    }
                }
                coordenada2++;
            }
        } else if (sentido.equalsIgnoreCase("v")) {
            for (int j = 0; j < nVeces; j++) {
                if (coordenada1 <= 5) {
                    try {
                        tablero[coordenada1][coordenada2] = ficha;
                        tablero[coordenada1 + 1][coordenada2].setOcupado(true);
                        tablero[coordenada1 - 1][coordenada2].setOcupado(true);
                    } catch (ArrayIndexOutOfBoundsException e) {
                    }
                }
                if (coordenada1 > 5) {
                    try {
                        tablero[coordenada1][coordenada2] = ficha;
                        tablero[coordenada1 - 1][coordenada2].setOcupado(true);
                        tablero[coordenada1 + 1][coordenada2].setOcupado(true);
                    } catch (ArrayIndexOutOfBoundsException e) {
                    }
                }
                if (coordenada2 <= 5) {
                    try {
                        tablero[coordenada1][coordenada2] = ficha;
                        tablero[coordenada1][coordenada2 + 1].setOcupado(true);
                        tablero[coordenada1][coordenada2 - 1].setOcupado(true);
                    } catch (ArrayIndexOutOfBoundsException e) {
                    }
                }
                if (coordenada2 > 5) {
                    try {
                        tablero[coordenada1][coordenada2] = ficha;
                        tablero[coordenada1][coordenada2 - 1].setOcupado(true);
                        tablero[coordenada1][coordenada2 + 1].setOcupado(true);
                    } catch (ArrayIndexOutOfBoundsException e) {
                    }
                }
                coordenada1++;
            }
        }
    }

    public boolean comprobarBarcoCabe(int nVeces, int coordenada1, int coordenada2, String sentido, Ficha agua) {
        llenarTableroAux();
        if (sentido.equalsIgnoreCase("h")) {
            try {
                for (int j = 0; j < nVeces; j++) {
                    tableroAux[coordenada1][coordenada2] = agua;
                    coordenada2++;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                return false;
            }
        }
        if (sentido.equalsIgnoreCase("v")) {
            try {
                for (int j = 0; j < nVeces; j++) {
                    tableroAux[coordenada1][coordenada2] = agua;
                    coordenada1++;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                return false;
            }
        }
        return true;
    }

    public boolean comprobarHayBarcos(Ficha tablero[][]) {
        boolean hayBarcos = false;
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j].getTipoFicha().equals("velero") || tablero[i][j].getTipoFicha().equals("buque")
                        || tablero[i][j].getTipoFicha().equals("portaviones")
                        || tablero[i][j].getTipoFicha().equals("fragata")) {
                    return true;
                } else {
                    hayBarcos = false;
                }
            }
        }
        return hayBarcos;
    }

    public void colocarBarcosTablero(Ficha ficha, int nVeces, int coordenada1, int coordenada2, String sentido,
            Ficha tablero[][]) {
        if (sentido.equalsIgnoreCase("h")) {
            asignarCasilla(ficha, nVeces, coordenada1, coordenada2, sentido, tablero);
            for (int j = 0; j < nVeces; j++) {
                tablero[coordenada1][coordenada2] = ficha;
                tablero[coordenada1][coordenada2].setSentido(sentido);
                coordenada2++;
            }
        }
        if (sentido.equalsIgnoreCase("v")) {
            asignarCasilla(ficha, nVeces, coordenada1, coordenada2, sentido, tablero);
            for (int j = 0; j < nVeces; j++) {
                tablero[coordenada1][coordenada2] = ficha;
                tablero[coordenada1][coordenada2].setSentido(sentido);
                coordenada1++;
            }
        }
    }

    public void colocarBarcosTableroIA(Ficha ficha, int nVeces, int coordenada1, int coordenada2, String sentido,
            Ficha tablero[][]) {
        if (sentido.equalsIgnoreCase("h")) {
            asignarCasilla(ficha, nVeces, coordenada1, coordenada2, sentido, tablero);
            for (int j = 0; j < nVeces; j++) {
                tablero[coordenada1][coordenada2] = ficha;
                tablero[coordenada1][coordenada2].setSentido(sentido);
                tablero[coordenada1][coordenada2].setContenido(" * ");
                coordenada2++;
            }
        }
        if (sentido.equalsIgnoreCase("v")) {
            asignarCasilla(ficha, nVeces, coordenada1, coordenada2, sentido, tablero);
            for (int j = 0; j < nVeces; j++) {
                tablero[coordenada1][coordenada2] = ficha;
                tablero[coordenada1][coordenada2].setSentido(sentido);
                tablero[coordenada1][coordenada2].setContenido(" * ");
                coordenada1++;
            }
        }
    }
}
