package practicaflota;

import java.util.*;

import javax.xml.validation.Validator;

public class HundirLaFlota extends Exception {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		mostrarMenu(sc);
	}

	public static void mostrarMenu(Scanner sc) {
		System.out.println("Bienvenido al HUNDE LA FLOTA DAW");
		int opcion = 0;
		boolean salir = false;
		do {
			boolean valido = false;
			do {
				System.out.println("Selecciona una opción: ");
				System.out.println("1. JUGAR");
				System.out.println("2. SALIR");
				try {
					opcion = sc.nextInt();
					if (opcion != 1 && opcion != 2) {
						System.out.println("Opcion no valida");
					}
					if (opcion == 1 || opcion == 2) {
						valido = true;
					}
				} catch (InputMismatchException e) {
					System.out.println("Introduce un valor entero.");
					sc.next();
					valido = false;
				}
			} while (valido == false);
			if (opcion == 2) {
				salir = true;
			} else if (opcion == 1) {
				Juego juego = new Juego(sc);
				juego.comenzarJuego();
				salir = preguntarJugar(sc);
			}
		} while (salir == false);
		System.out.println("Muchas gracias por jugar");
	}

//	METODO QUE PREGUNTARA SOBRE VOLVER A JUGAR, EN CASO AFIRMATIVO VOLVERA AL MENU
	public static boolean preguntarJugar(Scanner sc) {
		int opcion = 0;
		boolean salir = false;
		boolean valido = false;
		do {
			try {
				System.out.println("¿Quieres volver a jugar?");
				System.out.println("1. SI");
				System.out.println("2. NO");
				opcion = sc.nextInt();
				if (opcion != 1 && opcion != 2) {
					System.out.println("Opcion no valida");
					valido = false;
				}
				if (opcion == 1 || opcion == 2) {
					valido = true;
					if (opcion == 2) {
						salir = true;
					}
				}
			} catch (InputMismatchException e) {
				System.out.println("Introduce un valor entero.");
				sc.next();
				valido = false;
			}
		} while (valido == false);
		return salir;
	}
}
