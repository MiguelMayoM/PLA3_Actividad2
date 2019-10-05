package com.trifulcas.id;

import java.util.Arrays;
import java.util.Scanner;

public class Teclado implements IJugada {
	public Teclado() {

	}

	@Override
	public String pedirJugada(String[] validas) {
		Scanner entrada = new Scanner(System.in);
		String jugada;
		do {
			System.out.println("Introduzca la jugada(" + Arrays.toString(validas)+ ")");
			jugada=entrada.nextLine();
		} while(!Arrays.asList(validas).contains(jugada));
		return jugada;
	}
}