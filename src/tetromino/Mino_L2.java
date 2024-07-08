/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tetromino;

import java.awt.Color;

/**
 *
 * @author Alumno
 */
public class Mino_L2 extends Mino{

    public Mino_L2() { // Constructor
        create(Color.blue);
    }
    
    public void setXY(int x, int y){  // Método para establecer la posición del tetromino
        //   o
        //   o
        // o o
        b[0].x = x; // Establece la posición x del primer bloque
        b[0].y = y; // Establece la posición y del primer bloque
        b[1].x = b[0].x; // Establece la posición x del segundo bloque (mismo x que el primero)
        b[1].y = b[0].y - Block.SIZE; // Establece la posición y del segundo bloque (una posición arriba del primero)
        b[2].x = b[0].x; // Establece la posición x del tercer bloque (mismo x que el primero)
        b[2].y = b[0].y + Block.SIZE; // Establece la posición y del tercer bloque (una posición abajo del primero)
        b[3].x = b[0].x - Block.SIZE; // Establece la posición x del cuarto bloque (una posición a la izquierda del primero)
        b[3].y = b[0].y + Block.SIZE; // Establece la posición y del cuarto bloque (misma y que el tercero)
         
    }
    
    public void getDirection1(int x, int y){  // Método para obtener la dirección 1 (vertical invertida)
        //   o
        //   o
        // o o
        tempB[0].x = x; // Copia la posición x del primer bloque al bloque temporal
        tempB[0].y = y; // Copia la posición y del primer bloque al bloque temporal
        tempB[1].x = b[0].x; // Copia la posición x del segundo bloque al bloque temporal
        tempB[1].y = b[0].y - Block.SIZE; // Copia la posición y del segundo bloque al bloque temporal
        tempB[2].x = b[0].x; // Copia la posición x del tercer bloque al bloque temporal
        tempB[2].y = b[0].y + Block.SIZE;// Copia la posición y del tercer bloque al bloque temporal
        tempB[3].x = b[0].x - Block.SIZE; // Copia la posición x del cuarto bloque al bloque temporal
        tempB[3].y = b[0].y + Block.SIZE; // Copia la posición y del cuarto bloque al bloque temporal
        
        updateXY(1); // Actualiza las coordenadas de los bloques con la nueva dirección
        
    }
    public void getDirection2(){  // Método para obtener la dirección 2 (horizontal)
        // o
        // o o o
        tempB[0].x = b[0].x; // Copia la posición x del primer bloque al bloque temporal
        tempB[0].y = b[0].y;  // Copia la posición y del primer bloque al bloque temporal
        tempB[1].x = b[0].x + Block.SIZE; // Copia la posición x del segundo bloque al bloque temporal (una posición a la derecha del primero)
        tempB[1].y = b[0].y; // Copia la posición y del segundo bloque al bloque temporal
        tempB[2].x = b[0].x - Block.SIZE; // Copia la posición x del tercer bloque al bloque temporal (una posición a la izquierda del primero)
        tempB[2].y = b[0].y; // Copia la posición y del tercer bloque al bloque temporal
        tempB[3].x = b[0].x - Block.SIZE; // Copia la posición x del cuarto bloque al bloque temporal (misma x que el tercero)
        tempB[3].y = b[0].y - Block.SIZE; // Copia la posición y del cuarto bloque al bloque temporal (una posición arriba del primero)
        
        updateXY(2); // Actualiza las coordenadas de los bloques con la nueva dirección
        
    }
    public void getDirection3(){  // Método para obtener la dirección 3 (vertical)
        // o o
        // o
        // o
        tempB[0].x = b[0].x; // Copia la posición x del primer bloque al bloque temporal
        tempB[0].y = b[0].y; // Copia la posición y del primer bloque al bloque temporal
        tempB[1].x = b[0].x; // Copia la posición x del segundo bloque al bloque temporal
        tempB[1].y = b[0].y + Block.SIZE; // Copia la posición y del segundo bloque al bloque temporal (una posición abajo del primero)
        tempB[2].x = b[0].x; // Copia la posición x del tercer bloque al bloque temporal
        tempB[2].y = b[0].y - Block.SIZE; // Copia la posición y del tercer bloque al bloque temporal (una posición arriba del primero)
        tempB[3].x = b[0].x + Block.SIZE; // Copia la posición x del cuarto bloque al bloque temporal (una posición a la derecha del primero)
        tempB[3].y = b[0].y - Block.SIZE; // Copia la posición y del cuarto bloque al bloque temporal (misma y que el tercero)
        
        updateXY(3); // Actualiza las coordenadas de los bloques con la nueva dirección
        
    }
    public void getDirection4(){ // Método para obtener la dirección 4 (invertida horizontal)
        //
        // o o o
        //     o
        tempB[0].x = b[0].x; // Copia la posición x del primer bloque al bloque temporal
        tempB[0].y = b[0].y; // Copia la posición y del primer bloque al bloque temporal
        tempB[1].x = b[0].x - Block.SIZE; // Copia la posición x del segundo bloque al bloque temporal (una posición a la izquierda del primero)
        tempB[1].y = b[0].y; // Copia la posición y del segundo bloque al bloque temporal
        tempB[2].x = b[0].x + Block.SIZE; // Copia la posición x del tercer bloque al bloque temporal (una posición a la derecha del primero)
        tempB[2].y = b[0].y; // Copia la posición y del tercer bloque al bloque temporal
        tempB[3].x = b[0].x + Block.SIZE; // Copia la posición x del cuarto bloque al bloque temporal (misma x que el tercero)
        tempB[3].y = b[0].y + Block.SIZE; // Copia la posición y del cuarto bloque al bloque temporal (una posición abajo del primero)
        
        updateXY(4); // Actualiza las coordenadas de los bloques con la nueva dirección
        
    }
}
