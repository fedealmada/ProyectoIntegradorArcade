package tetromino;

import java.awt.Color;

public class Mino_Bar extends Mino {

      public Mino_Bar() { //constructor
            create(Color.cyan);
      }

      public void setXY(int x, int y) { //metodo para establecer la posicion del tetromino
            //
            // o o o o
            //
            b[0].x = x; // establece la posicion x del primer bloque
            b[0].y = y; //establece la posicion y del primer bloque
            b[1].x = b[0].x - Block.SIZE;// establece la posicion x del segundo bloque a la izquierda del primero
            b[1].y = b[0].y;// establece la misma posicion y para el segundo bloque
            b[2].x = b[0].x + Block.SIZE;// Establece la posicion x del tercer bloque a la derecha del primero
            b[2].y = b[0].y;// establece la misma posicion y para el tercer bloque
            b[3].x = b[0].x + Block.SIZE * 2;// establece la posicion x del cuarto bloque dos posiciones a la derecha del primero
            b[3].y = b[0].y;// establece la misma posicion y para el cuarto bloque
      }

      public void getDirection1() { // Método para obtener la direccion 1 (horizontal)
            //
            // o o o o
            // 
            tempB[0].x = b[0].x; // copia la posicion x del primer bloque al bloque temporal
            tempB[0].y = b[0].y; // Copia la posicion y del primer bloque al bloque temporal
            tempB[1].x = b[0].x - Block.SIZE;// Copia la posicion x del segundo bloque al bloque temporal
            tempB[1].y = b[0].y;// Copia la posicion y del segundo bloque al bloque temporal
            tempB[2].x = b[0].x + Block.SIZE; // Copia la posicion x del tercer bloque al bloque temporal
            tempB[2].y = b[0].y; // Copia la posicion y del tercer bloque al bloque temporal
            tempB[3].x = b[0].x + Block.SIZE * 2; // Copia la posicion x del cuarto bloque al bloque temporal
            tempB[3].y = b[0].y;// Copia la posicion y del cuarto bloque al bloque temporal

            updateXY(1); // Actualiza las coordenadas de los bloques con la nueva direccion
      }

      public void getDirection2() { //// Método para obtener la direccion 2 (vertical)
            //  o
            //  o
            //  o
            //  o
            tempB[0].x = b[0].x;// Copia la posicion x del primer bloque al bloque temporal
            tempB[0].y = b[0].y; // Copia la posicion y del primer bloque al bloque temporal
            tempB[1].x = b[0].x; // Copia la posicion x del segundo bloque al bloque temporal
            tempB[1].y = b[0].y - Block.SIZE;// Copia la posicion y del segundo bloque al bloque temporal (arriba del primero)
            tempB[2].x = b[0].x; // Copia la posicion x del tercer bloque al bloque temporal
            tempB[2].y = b[0].y + Block.SIZE; // Copia la posicion y del tercer bloque al bloque temporal (abajo del primero)
            tempB[3].x = b[0].x; // Copia la posicion x del cuarto bloque al bloque temporal
            tempB[3].y = b[0].y + Block.SIZE * 2;// Copia la posicion y del cuarto bloque al bloque temporal (dos posiciones abajo del primero)

            updateXY(2); // Actualiza las coordenadas de los bloques con la nueva direccion
      }

      public void getDirection3() { // Método para obtener la direccion 3 (igual que direccion 1)
            getDirection1(); // Usa la misma configuracion que la direccion 1 (horizontal)
      }

      public void getDirection4() { // Método para obtener la direccion 4 (igual que direccion 2)
            getDirection2();// Usa la misma configuracion que la direccion 2 (vertical)
      }
}
