package com.trifulcas.id;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

/*En otra práctica había usado FileWriter, ahora voy a usar otra clase para
  escribir en UTF8. Lo ideal sería dejar abierto y cerrar al final, pero he
  querido hacerlo lo más sencillo posible*/

public class Archivo implements IMostrar {
  @Override
  public void mostrar(String res){
    try {
      OutputStreamWriter archivo = new OutputStreamWriter(
        new FileOutputStream("partidas.txt", true), StandardCharsets.UTF_8
      );
      archivo.write(res + "\n");
      archivo.close();
    } catch(Exception e) {
      e.printStackTrace();
    }    
  }
}