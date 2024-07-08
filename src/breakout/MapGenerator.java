/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package breakout;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author Alumno
 */
public class MapGenerator {
    public int map[][];// Matriz de ladrillos
    public int brickWidth;// Ancho de cada ladrillo
    public int brickHeight; // Alto de cada ladrillo
    
    public MapGenerator(int row, int col) {
        map = new int[row][col];// Crear la matriz de ladrillos
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = 1; // Inicializar cada ladrillo con un valor de 1 (activo)
            }
        }

        brickWidth = 540 / col;// Calcular el ancho de cada ladrillo
        brickHeight = 150 / row;// Calcular el alto de cada ladrillo
    }
    
    public void draw(Graphics2D g) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] > 0) {
                    g.setColor(Color.white);
                    g.fillRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);

                    g.setStroke(new BasicStroke(3));
                    g.setColor(Color.black);
                    g.drawRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);
                }
            }
        }
    }
    
    public void setBrickValue(int value, int row, int col) {
        map[row][col] = value;// Cambiar el valor del ladrillo (0 = roto, 1 = activo)
    }

    
}
