package practicaflota;

import java.util.Scanner;

public class Juego {
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_RESET = "\u001B[0m";
	private Jugador jugador1;
	private JugadorIA jugador2;
	private Ficha tablero[][];
	private Ficha tableroIA[][];

	protected Juego(Scanner sc) {
		this.jugador1 = new Jugador(sc);
		this.jugador2 = new JugadorIA(sc);
		this.tablero = jugador1.tableros.getTablero();
		this.tableroIA = jugador2.tableros.getTableroIA();
	}

	public void crearTableros() {
		jugador1.tableros.llenarTableros(tablero, tableroIA);
	}

	public void mostrarTableros() {
		System.out.println(ANSI_YELLOW
				+ "----------------------------------------------------------------------------------" + ANSI_RESET);
		System.out.println(ANSI_YELLOW + "     	MAR JUGADOR 1                  			MAR JUGADOR 2 ");
		System.out.println(
				"     A  B  C  D  E  F  G  H  I  J                   A  B  C  D  E  F  G  H  I  J " + ANSI_RESET);
		System.out.println("");
		int numero = 0;
		for (int i = 0; i < tablero.length; i++) {
			System.out.print(ANSI_YELLOW + numero + "   " + ANSI_RESET);
			for (int j = 0; j < tablero[i].length; j++) {
				System.out.print(tablero[i][j].getContenido());
			}
			System.out.print("             ");
			System.out.print(ANSI_YELLOW + numero + "   " + ANSI_RESET);
			for (int j = 0; j < tablero[i].length; j++) {
				System.out.print(tableroIA[i][j].getContenido());
			}
			System.out.println("");
			numero++;
		}
		System.out.println(ANSI_YELLOW
				+ "----------------------------------------------------------------------------------" + ANSI_RESET);
	}

	public void comenzarJuego() {
		crearTableros();
		System.out.println("VAS A COLOCAR LOS BARCOS");
		System.out.println("NOTA: No puedes colocar barcos contiguos");
		System.out.println("NOTA: Debes asegurarte de que los barcos quepan en el tablero");
		jugador1.pedirCoordenadas();
		jugador2.pedirCoordenadas();
		System.out.println("COMIENZA EL JUEGO");
		System.out.println("Introduce coordenadas para atacar al tablero contrario");
		mostrarReglas();
		mostrarTableros();
		atacarTableros();
	}

	public void mostrarReglas() {
		System.out.println("1- Cada jugador dispondrá de un tiro por turno, con excepciones");
		System.out.println("2- En caso de que un jugador le dé a un barco podrá tirar otra vez.");
		System.out.println("3- No puedes atacar una casilla ya atacada");
		System.out.println("4- Gana el jugador que hunda la flota del contrario");
		System.out.println("FICHAS:");
		System.out.println("1- Agua: o");
		System.out.println("2- Tocado: x");
	}

	public void atacarTableros() {
		boolean hayBarcosParaJugador = true;
		boolean hayBarcosParaIA = true;
		boolean tocadOHundido[] = new boolean[2];
		boolean tocado = false;
		boolean hundido = false;
		do {
			if (hayBarcosParaIA == true && hayBarcosParaJugador == true) {
				System.out.println("TURNO JUGADOR 1");
				boolean dado1 = jugador1.atacarTablero(tableroIA);
				hayBarcosParaJugador = jugador2.tableros.comprobarHayBarcos(tableroIA);
				mostrarTableros();
				while (dado1 == true && hayBarcosParaIA == true && hayBarcosParaJugador == true) {
					System.out.println("JUGADOR 1 VUELVES A TIRAR");
					dado1 = jugador1.atacarTablero(tableroIA);
					mostrarTableros();
					hayBarcosParaJugador = jugador2.tableros.comprobarHayBarcos(tableroIA);
				}
			}
			if (hayBarcosParaIA == true && hayBarcosParaJugador == true) {
				System.out.println("TURNO JUGADOR 2");
				tocadOHundido = jugador2.atacarTableroIA(tablero);
				tocado = tocadOHundido[0];
				hundido = tocadOHundido[1];
				hayBarcosParaIA = jugador1.tableros.comprobarHayBarcos(tablero);
				mostrarTableros();
				while (tocado == true && hayBarcosParaIA == true && hayBarcosParaIA == true) {
					System.out.println("JUGADOR 2 VUELVES A TIRAR");
					if (tocado == true && hundido == true) {
						tocadOHundido = jugador2.atacarTableroIA(tablero);
						tocado = tocadOHundido[0];
						hundido = tocadOHundido[1];
					} else if (tocado == true && hundido == false) {
						tocadOHundido = jugador2.atacarOtravez(tablero);
						tocado = tocadOHundido[0];
						hundido = tocadOHundido[1];
					}
					mostrarTableros();
					hayBarcosParaIA = jugador1.tableros.comprobarHayBarcos(tablero);
				}
			}
		} while (hayBarcosParaIA == true && hayBarcosParaJugador == true);
		if (hayBarcosParaIA == false) {
			System.out.println("JUGADOR 2 HA GANADO");
		} else {
			System.out.println("JUGADOR 1 HA GANADO");
		}
	}
}
