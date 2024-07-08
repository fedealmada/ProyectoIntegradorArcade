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
public class Mino_T extends Mino{

    public Mino_T() { // Constructor
        create(Color.magenta); // Crea el tetromino tipo T con el color magenta
    }
   
    public void setXY(int x, int y){ // Método para establecer la posición del tetromino
      //   o
      // o o o
        b[0].x = x; // Establece la posición x del primer bloque (centro)
        b[0].y = y; // Establece la posición y del primer bloque (centro)
        b[1].x = b[0].x; // Establece la posición x del segundo bloque (misma x que el primero)
        b[1].y = b[0].y - Block.SIZE; // Establece la posición y del segundo bloque (una posición arriba del primero)
        b[2].x = b[0].x - Block.SIZE; // Establece la posición x del tercer bloque (una posición a la izquierda del primero)
        b[2].y = b[0].y; // Establece la posición y del tercer bloque (misma y que el primero)
        b[3].x = b[0].x + Block.SIZE; // Establece la posición x del cuarto bloque (una posición a la derecha del primero)
        b[3].y = b[0].y; // Establece la posición y del cuarto bloque (misma y que el primero)
    }
    
    public void getDirection1(){ // Método para la primera dirección de rotación
        //   o 
        // o o o
        tempB[0].x = b[0].x; // Establece la posición x del primer bloque temporal
        tempB[0].y = b[0].y; // Establece la posición y del primer bloque temporal
        tempB[1].x = b[0].x; // Establece la posición x del segundo bloque temporal
        tempB[1].y = b[0].y - Block.SIZE; // Establece la posición y del segundo bloque temporal
        tempB[2].x = b[0].x - Block.SIZE; // Establece la posición x del tercer bloque temporal
        tempB[2].y = b[0].y; // Establece la posición y del tercer bloque temporal
        tempB[3].x = b[0].x + Block.SIZE; // Establece la posición x del cuarto bloque tempo
        tempB[3].y = b[0].y; // Establece la posición y del cuarto bloque temporal
        
        updateXY(1); // Actualiza las posiciones de los bloques a la dirección 1
    }
    public void getDirection2(){ // Método para la segunda dirección de rotación
        // o
        // o o
        // o
        tempB[0].x = b[0].x; // Establece la posición x del primer bloque temporal
        tempB[0].y = b[0].y; // Establece la posición y del primer bloque temporal
        tempB[1].x = b[0].x + Block.SIZE; // Establece la posición x del segundo bloque temporal
        tempB[1].y = b[0].y; // Establece la posición y del segundo bloque temporal
        tempB[2].x = b[0].x; // Establece la posición x del tercer bloque temporal
        tempB[2].y = b[0].y - Block.SIZE; // Establece la posición y del tercer bloque temporal
        tempB[3].x = b[0].x; // Establece la posición x del cuarto bloque temporal
        tempB[3].y = b[0].y + Block.SIZE; // Establece la posición y del cuarto bloque temporal
        
        updateXY(2); // Actualiza las posiciones de los bloques a la dirección 2
    }
    public void getDirection3(){ // Método para la tercera dirección de rotación
        // 
        // o o o
        //   o
        tempB[0].x = b[0].x;// Establece la posición x del primer bloque temporal
        tempB[0].y = b[0].y;// Establece la posición y del primer bloque temporal
        tempB[1].x = b[0].x ;// Establece la posición x del segundo bloque temporal
        tempB[1].y = b[0].y + Block.SIZE; // Establece la posición y del segundo bloque temporal
        tempB[2].x = b[0].x + Block.SIZE; // Establece la posición x del tercer bloque temporal
        tempB[2].y = b[0].y; // Establece la posición y del tercer bloque temporal
        tempB[3].x = b[0].x - Block.SIZE; // Establece la posición x del cuarto bloque temporal
        tempB[3].y = b[0].y; // Establece la posición y del cuarto bloque temporal
        
        updateXY(3); // Actualiza las posiciones de los bloques a la dirección 3
        
    }
    public void getDirection4(){ // Método para la cuarta dirección de rotación
        //   o   
        // o o
        //   o
        tempB[0].x = b[0].x; // Establece la posición x del primer bloque temporal
        tempB[0].y = b[0].y; // Establece la posición y del primer bloque temporal
        tempB[1].x = b[0].x - Block.SIZE; // Establece la posición x del segundo bloque temporal
        tempB[1].y = b[0].y; // Establece la posición y del segundo bloque temporal
        tempB[2].x = b[0].x; // Establece la posición x del tercer bloque temporal
        tempB[2].y = b[0].y + Block.SIZE; // Establece la posición y del tercer bloque temporal
        tempB[3].x = b[0].x; // Establece la posición x del cuarto bloque temporal
        tempB[3].y = b[0].y - Block.SIZE; // Establece la posición y del cuarto bloque temporal
        
        updateXY(4); // Actualiza las posiciones de los bloques a la dirección 4
        
    }
}
