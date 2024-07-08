package pacman;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Character {
      protected String nombre;
      protected int x, y;
      protected int dx, dy;
      protected int speed;
      protected int size;
      protected boolean spawned = false;
      protected Map map;
      protected Color color;
      protected Directions direction;
      public static enum Directions { NONE, LEFT, RIGHT, UP, DOWN }

      public abstract void draw(Graphics g);
      public abstract void move(Pacman pacman, Map map);
      public abstract void spawn();
      public abstract void die();
      
      public void moveLeft(int x) {
             dx = -speed;
             dy = 0;
             direction = Directions.LEFT; 
      }
      
      public boolean checkCollision(int x, int y) {
            int fila = y / 20;
            int columna = x / 20;
            
            if(fila >= 0 && fila < map.filas &&  columna < map.columnas) {
                  if(!map.matrizObjetos.isNull(fila, columna)) {
                        return map.matrizObjetos.isBlock(fila, columna);
                  } 
            }
        return false;
    }

      public void moveRight(int x) {
            dx = speed;
            dy = 0;
            direction = Directions.RIGHT;
      }
      
      public void moveDown(int y) {
            dx = 0;
            dy = speed;
            direction = Directions.DOWN; 
      }
      
      public void moveUp(int y) {
            dx = 0;
            dy = -speed;
            direction = Directions.UP;   
      } 
      
      public String getNombre() {
            return nombre;
      }

      public void setNombre(String nombre) {
            this.nombre = nombre;
      }
      
      public int getX() {
            return x;
      }

      public void setX(int x) {
            this.x = x;
      }

      public int getY() {
            return y;
      }

      public void setY(int y) {
            this.y = y;
      }

      public int getDx() {
            return dx;
      }

      public void setDx(int dx) {
            this.dx = dx;
      }

      public int getDy() {
            return dy;
      }

      public void setDy(int dy) {
            this.dy = dy;
      }

      public int getSpeed() {
            return speed;
      }

      public void setSpeed(int speed) {
            this.speed = speed;
      }

      public int getSize() {
            return size;
      }

      public void setSize(int size) {
            this.size = size;
      }

      public Map getMap() {
            return map;
      }

      public void setMap(Map map) {
            this.map = map;
      }

      public Color getColor() {
            return color;
      }

      public void setColor(Color color) {
            this.color = color;
      }

      public Directions getDirection() {
            return direction;
      }

      public void setDirection(Directions direction) {
            this.direction = direction;
      }

      public boolean isSpawned() {
            return spawned;
      }

      public void setSpawned(boolean spawned) {
            this.spawned = spawned;
      }
      
      @Override
      public String toString() {
            return "Character{" + "nombre=" + nombre + ", x=" + x + ", y=" + y + ", dx=" + dx + ", dy=" + dy + ", speed=" + speed + ", size=" + size + ", map=" + map + ", color=" + color + ", direction=" + direction + '}';
      }  
}
