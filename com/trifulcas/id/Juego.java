package com.trifulcas.id;


public class Juego {
	private Jugador jugador1;
	private Jugador jugador2;
	private ILogica _iLogica;
  private IMostrar _iMostrar;

	private String[] jugadas;

	public String[] getJugadas() {
		return jugadas;
	}

	public void setJugadas(String[] jugadas) {
		this.jugadas = jugadas;
	}

	public Jugador getJugador1() {
		return jugador1;
	}

	public void setJugador1(Jugador jugador1) {
		this.jugador1 = jugador1;
	}

	public Jugador getJugador2() {
		return jugador2;
	}

	public void setJugador2(Jugador jugador2) {
		this.jugador2 = jugador2;
	}

	public Juego(Jugador jugador1, Jugador jugador2, ILogica ilogica, IMostrar imostrar) {
		this.jugador1 = jugador1;
		this.jugador2 = jugador2;
		_iLogica=ilogica;
		jugadas=_iLogica.validas();
    _iMostrar=imostrar;
	}

  public Juego(Jugador jugador1, Jugador jugador2, ILogica ilogica) {
		this(jugador1, jugador2, ilogica, new Consola());
	}

  //public String jugar(IMostrar imostrar) {
  /*Ahora jugar no devuelve ningún String para que imprima el Main, porque la
    variable de referencia de interfaz _iMostrar albergará un objeto que tomará
    ese String que antes se enviaba al Main y se lo pasará, sin salir del método
    .jugar(), al método .mostrar() del objeto que en cada caso sea elegido.
		En el único caso que vamos a tratar, la Consola*/
  public void jugar() {
    jugador1.pedirJugada(jugadas);
		jugador2.pedirJugada(jugadas);
		_iMostrar.mostrar(jugador1.getNombre() + " elige " + jugador1.getJugada());
    _iMostrar.mostrar(jugador2.getNombre() + " elige " + jugador2.getJugada());
    int res=_iLogica.comprobar(jugador1.getJugada(), jugador2.getJugada());
    /*Ponemos el resultado en una variable para no escribir tres veces la línea
      que llama al método .mostrar() del objeto referido por _iMostrar*/
    String resultado;
    if (res == 1) { resultado = jugador1.getNombre(); }
    else if (res == 2) { resultado = jugador2.getNombre(); }
    else {resultado = "Empate";}
    _iMostrar.mostrar(resultado);
  }
}