package practicaflota;

import java.util.*;

public class Jugador {
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_RESET = "\u001B[0m";
	protected Tablero tableros = new Tablero();
	protected Ficha[] velero = new Ficha[4];
	protected Ficha[] buque = new Ficha[2];
	protected Ficha[] portaviones = new Ficha[1];
	protected Ficha[] fragata = new Ficha[3];
	protected Ficha casillaAgua;
	protected Ficha casillaDada;
	protected Ficha casillaTocada;
	protected Scanner sc;

	public Jugador(Scanner sc) {
		this.sc = sc;
		this.casillaAgua = new Ficha("agua");
		this.casillaDada = new Ficha("casillaDada");
		this.casillaTocada = new Ficha("casillaTocada");
		this.velero = rellenarFichas("velero", velero);
		this.buque = rellenarFichas("buque", buque);
		this.portaviones = rellenarFichas("portaviones", portaviones);
		this.fragata = rellenarFichas("fragata", fragata);
	}
	
	public Ficha[] rellenarFichas(String nombreFicha, Ficha array[]) {
		for (int i = 0; i < array.length; i++) {
			Ficha f1 = new Ficha(nombreFicha, null);
			array[i] = f1;
		}
		return array;
	}

	public int cambiarCoordenada(String caracter) {
		return caracter.charAt(0) - 'A';
	}

	public int validarCoordenada1() {
		boolean valido = false;
		int coordenada1 = 0;
		do {
			try {
				System.out.println("Introduce la coordenada1 (fila)");
				coordenada1 = sc.nextInt();
				if (coordenada1 > 9 || coordenada1 < 0) {
					System.out.println(
							ANSI_GREEN + "Coordenada no válida, debe estar comprendido entre 0 y 9." + ANSI_RESET);
					valido = false;
				} else {
					valido = true;
				}
			} catch (InputMismatchException e) {
				System.out.println(ANSI_GREEN + "Coordenada no válida, introduzca un número." + ANSI_RESET);
				sc.next();
			}
		} while (valido == false);
		return coordenada1;
	}

	public int validarCoordenada2() {
		boolean valido = false;
		int coordenada2 = 0;
		do {
			try {
				System.out.println("Introduce la coordenada2 (columna)");
				String caracter = sc.next().toUpperCase();
				coordenada2 = cambiarCoordenada(caracter);
				if (coordenada2 > 9 || coordenada2 < 0 || caracter.length() > 1) {
					System.out.println(ANSI_GREEN + "Coordenada no válida, introduce una letra (A - J)." + ANSI_RESET);
					valido = false;
				} else {
					valido = true;
				}
			} catch (Exception e) {
				System.out.println(ANSI_GREEN + "Coordenada no válida, introduce una letra." + ANSI_RESET);
				sc.next();
			}
		} while (valido == false);
		return coordenada2;
	}

	public String validarSentido() {
		String sentido = "";
		boolean valido = false;
		do {
			System.out.println("Introduce sentido (escribe V/H)");
			sentido = sc.next().toUpperCase();
			if (sentido.length() > 1) {
				System.out.println(ANSI_GREEN + "Sentido no válido, introduzca V o H" + ANSI_RESET);
			} else if (!sentido.equals("V") && !sentido.equals("H")) {
				System.out.println(ANSI_GREEN + "Sentido no válido, introduzca V o H" + ANSI_RESET);
			} else {
				valido = true;
			}
		} while (valido == false);
		return sentido;
	}

	public void pedirCoordenadas() {
		tableros.mostrarTableroJugador();
		for (int i = 0; i < velero.length; i++) {
			System.out.println("Vas a colocar " + (velero.length - i) + " veleros(tamaño 1):");
			int coordenada1 = validarCoordenada1();
			int coordenada2 = validarCoordenada2();
			String sentido = validarSentido();
			velero[i].setSentido(sentido);
			i = i - colocarBarcos(velero[i], 1, coordenada1, coordenada2, sentido);
		}
		for (int i = 0; i < buque.length; i++) {
			System.out.println("Vas a colocar " + (buque.length - i) + " buques(tamaño 3):");
			int coordenada1 = validarCoordenada1();
			int coordenada2 = validarCoordenada2();
			String sentido = validarSentido();
			buque[i].setSentido(sentido);
			i = i - colocarBarcos(buque[i], 3, coordenada1, coordenada2, sentido);
		}
		for (int i = 0; i < fragata.length; i++) {
			System.out.println("Vas a colocar " + (fragata.length - i) + " fragatas(tamaño 2):");
			int coordenada1 = validarCoordenada1();
			int coordenada2 = validarCoordenada2();
			String sentido = validarSentido();
			fragata[i].setSentido(sentido);
			i = i - colocarBarcos(fragata[i], 2, coordenada1, coordenada2, sentido);
		}
		for (int i = 0; i < portaviones.length; i++) {
			System.out.println("Vas a colocar 1 portaviones(tamaño 4):");
			int coordenada1 = validarCoordenada1();
			int coordenada2 = validarCoordenada2();
			String sentido = validarSentido();
			portaviones[i].setSentido(sentido);
			i = i - colocarBarcos(portaviones[i], 4, coordenada1, coordenada2, sentido);
		}
	}

	public int colocarBarcos(Ficha ficha, int nVeces, int coordenada1, int coordenada2, String sentido) {
		int i = 0;
		boolean barcoCabe = tableros.comprobarBarcoCabe(nVeces, coordenada1, coordenada2, sentido, casillaAgua);
		if (barcoCabe == true) {
			boolean valido = tableros.validarCasilla(nVeces, coordenada1, coordenada2, sentido, tableros.getTablero());
			if (valido == true) {
				tableros.colocarBarcosTablero(ficha, nVeces, coordenada1, coordenada2, sentido, tableros.getTablero());
				tableros.mostrarTableroJugador();
				i = 0;
				return i;
			} else {
				System.out.println(
						ANSI_GREEN + "La casilla esta ocupada / No puedes colocar un barco contiguo" + ANSI_RESET);
				tableros.mostrarTableroJugador();
				i = 1;
				return i;
			}
		} else {
			System.out.println(ANSI_GREEN + "El barco no cabe" + ANSI_RESET);
			tableros.mostrarTableroJugador();
			i = 1;
			return i;
		}
	}

	public int[] comprobarAtacado(Ficha tableroContrario[][], int coordenada1, int coordenada2) {
		boolean valido = false;
		int coordenadas[] = new int[2];
		do {
			if (tableroContrario[coordenada1][coordenada2].isDado() == true) {
				System.out.println("Ya has atacado esta coordenada");
				coordenada1 = validarCoordenada1();
				coordenada2 = validarCoordenada2();
				coordenadas[0] = coordenada1;
				coordenadas[1] = coordenada2;
				valido = false;
			} else {
				valido = true;
			}
		} while (valido == false);
		return coordenadas;
	}

	public boolean atacarTablero(Ficha tableroContrario[][]) {
		int coordenada1 = validarCoordenada1();
		int coordenada2 = validarCoordenada2();
		int coordenadas[] = new int[2];
		boolean dado = true;
		if (tableroContrario[coordenada1][coordenada2].isDado() == true) {
			coordenadas = comprobarAtacado(tableroContrario, coordenada1, coordenada2);
			coordenada1 = coordenadas[0];
			coordenada2 = coordenadas[1];
		}
		if (tableroContrario[coordenada1][coordenada2].getTipoFicha().equals("agua")) {
			tableroContrario[coordenada1][coordenada2] = casillaDada;
			System.out.println("Agua");
			dado = false;
		} else {
			int vida = tableroContrario[coordenada1][coordenada2].getVida();
			tableroContrario[coordenada1][coordenada2].setVida(vida - 1);
			if (tableroContrario[coordenada1][coordenada2].getVida() == 0) {
				System.out.println("TOCADO Y HUNDIDO");
			} else {
				System.out.println("TOCADO");
			}
			dado = true;
			tableroContrario[coordenada1][coordenada2] = casillaTocada;
		}
		return dado;
	}
}
