package com.trifulcas.id;

public class Main {

	public static void main(String[] args) {
		Jugador miguel = new Jugador("Miguel", new Teclado());
    Jugador ordenador = new Jugador("Ordenador", new CPU());
    /*Con los 4 parámetros, inyectando un objeto Consola*/
    System.out.println("Inyectando/Pasando como parámetro un objeto Consola");
    Juego ppt = new Juego(miguel, ordenador, new JuegoPPTLS(), new Consola());
    ppt.jugar();

    /*Sólo con 3, para que el constructor tome como defecto la Consola*/ 
    System.out.println("No inyectando ningún objeto para mostrar, el constructor elige la consola por defecto");
    Juego ppt2 = new Juego(ordenador, miguel, new JuegoPPT());
    ppt2.jugar();
    
    /*Con los 4 parámetros, inyectando un objeto Archivo*/
    System.out.println("Inyectando/Pasando como parámetro un objeto Archivo");
    Juego ppt3 = new Juego(ordenador, miguel, new JuegoPPTLS(), new Archivo());
    ppt3.jugar();
	}
}