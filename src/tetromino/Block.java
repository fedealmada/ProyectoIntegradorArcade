package tetromino;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Block extends Rectangle {

      public int x, y;// declaramos variables de instancia para las coordenadas x e y del bloque
      public static final int SIZE = 30;// declaramos una constante para el tamaño del bloque (30x30)
      public Color c;// Declaramos una variable para el color del bloque

      public Block(Color c) {
            this.x = x;
            this.y = y;
            this.c = c;
      }

      public void draw(Graphics2D g2) {// metodo para dibujar el bloque en la pantalla
            int margine = 2; // definimos un margen para el bloque
            g2.setColor(c);// establecemos el color del grafico en el color del bloque
            // dibujamos un rectangulo relleno con el color del bloque, ajustando por el margen
            g2.fillRect(x + margine, y + margine, SIZE - (margine * 2), SIZE - (margine * 2));

            // Dibujar gradiente
            GradientPaint gradient = new GradientPaint(x, y, c.brighter(), x + SIZE, y + SIZE, c.darker());
            g2.setPaint(gradient);
            g2.fillRect(x, y, SIZE, SIZE);

            // Efecto de brillo
            g2.setColor(new Color(255, 255, 255, 50)); // Blanco translÃºcido
            g2.fillRect(x, y, SIZE / 2, SIZE / 2);

            // Dibujar borde
            g2.setColor(Color.BLACK); // Color del borde
            g2.drawRect(x, y, SIZE, SIZE); // Dibujar el borde del bloque  

      }
}
