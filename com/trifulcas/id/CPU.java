package com.trifulcas.id;

import java.util.Random;

public class CPU implements IJugada {
  public CPU() {
  
  }
	
	@Override
	public String pedirJugada(String[] validas) {
		Random random = new Random();
    return validas[random.nextInt( validas.length)];
	}
}