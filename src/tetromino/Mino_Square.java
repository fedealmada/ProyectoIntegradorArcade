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
public class Mino_Square extends Mino{

    public Mino_Square() { // Constructor 
        create(Color.yellow); // Crea el tetromino cuadrado con el color amarillo
    }
    
    public void setXY(int x, int y){ // Método para establecer la posición del tetromino
        // o o
        // o o
        //
        b[0].x = x; // Establece la posición x del primer bloque
        b[0].y = y; // Establece la posición y del primer bloque
        b[1].x = b[0].x;// Establece la posición x del segundo bloque (misma x que el primero)
        b[1].y = b[0].y + Block.SIZE; // Establece la posición y del segundo bloque (una posición abajo del primero)
        b[2].x = b[0].x + Block.SIZE; // Establece la posición x del tercer bloque (una posición a la derecha del primero)
        b[2].y = b[0].y; // Establece la posición y del tercer bloque (misma y que el primero)
        b[3].x = b[0].x + Block.SIZE; // Establece la posición x del cuarto bloque (misma x que el tercero)
        b[3].y = b[0].y + Block.SIZE; // Establece la posición y del cuarto bloque (misma y que el segundo)
    
        
    }
    // Métodos vacíos para las direcciones, ya que un tetromino cuadrado no necesita rotación
    public void getDirection1(){}
    public void getDirection2(){}
    public void getDirection3(){}
    public void getDirection4(){}
}
