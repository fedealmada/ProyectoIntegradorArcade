package tetromino;

import java.awt.Color;
import java.awt.Graphics2D;
import tetris.KeyHandler;
import tetris.PlayManager;

public class Mino { // la clase Mino representa un tetromino, compuesto de cuatro bloques

      public Block b[] = new Block[4];// Array para almacenar los cuatro bloques que componen el tetromino
      public Block tempB[] = new Block[4];// Array temporal para manejar la rotacion de los bloques
      int autoDropCounter = 0;// contador para el auto-drop del tetromino
      // direccion actual del tetromino 
      public int direction = 1;//hay 4 direcciones: 1,2,3,4
      boolean leftCollision, rightCollision, bottomCollision; // banderas para manejar las colisiones
      // banderas para indicar si el tetromino esta activo o se esta desactivando
      public boolean active = true;
      public boolean deactivating;
      int deactivateCounter = 0;// Contador para manejar la desactivacion

      //Metodo para crear un tetromino de un color específico
      public void create(Color c) {
            // Inicializa los bloques del tetromino con el color proporcionado  
            b[0] = new Block(c);
            b[1] = new Block(c);
            b[2] = new Block(c);
            b[3] = new Block(c);
            tempB[0] = new Block(c);
            tempB[1] = new Block(c);
            tempB[2] = new Block(c);
            tempB[3] = new Block(c);
      }

      public void setXY(int x, int y) {
      }// metodo para establecer las coordenadas iniciales del tetromino

      public void updateXY(int direction) {// metodo para actualizar las coordenadas del tetromino segun la direccion

            checkRotationCollision();// verificamos colisiones antes de actualizar la direccion

            // si no hay colisiones, actualizamos la direccion y las coordenadas de los bloques
            if (leftCollision == false && rightCollision == false && bottomCollision == false) {
                  this.direction = direction; // Actualiza la direccion del tetromino
                  // Actualiza las coordenadas de los bloques
                  b[0].x = tempB[0].x;
                  b[0].y = tempB[0].y;
                  b[1].x = tempB[1].x;
                  b[1].y = tempB[1].y;
                  b[2].x = tempB[2].x;
                  b[2].y = tempB[2].y;
                  b[3].x = tempB[3].x;
                  b[3].y = tempB[3].y;
            }
      }

      // metodos para manejar las diferentes direcciones del tetromino
      public void getDirection1() {
      }

      public void getDirection2() {
      }

      public void getDirection3() {
      }

      public void getDirection4() {
      }

      // metodo para verificar colisiones durante el movimiento
      public void checkMovementCollision() {
            // reiniciamos las banderas de colision
            leftCollision = false;
            rightCollision = false;
            bottomCollision = false;

            // verificamos colisiones con bloques estaticos
            checkStaticBlockCollision();

            // Verificamos colision con la pared izquierda
            for (int i = 0; i < b.length; i++) {
                  if (b[i].x == PlayManager.left_x) {
                        leftCollision = true;
                  }

            }
            // Verificamos colision con la pared derecha
            for (int i = 0; i < b.length; i++) {
                  if (b[i].x + Block.SIZE == PlayManager.right_x) {
                        rightCollision = true;
                  }

            }
            // Verificamos colision con el piso
            for (int i = 0; i < b.length; i++) {
                  if (b[i].y + Block.SIZE == PlayManager.bottom_y) {
                        bottomCollision = true;
                  }

            }
      }

      // Metodo para verificar colisiones durante la rotacion
      public void checkRotationCollision() {
            // Reiniciamos las banderas de colision
            leftCollision = false;
            rightCollision = false;
            bottomCollision = false;

            // Verificamos colisiones con bloques estaticos
            checkStaticBlockCollision();

            // Verificamos colision con la pared izquierda
            for (int i = 0; i < b.length; i++) {
                  if (b[i].x == PlayManager.left_x) {
                        leftCollision = true;
                  }

            }
            // Verificamos colision con la pared derecha
            for (int i = 0; i < b.length; i++) {
                  if (b[i].x + Block.SIZE == PlayManager.right_x) {
                        rightCollision = true;
                  }

            }
            // Verificamos colision con el piso
            for (int i = 0; i < b.length; i++) {
                  if (b[i].y + Block.SIZE == PlayManager.bottom_y) {
                        bottomCollision = true;
                  }

            }
      }

      // Metodo para verificar colisiones con bloques estaticos
      public void checkStaticBlockCollision() {
            for (int i = 0; i < PlayManager.staticBlocks.size(); i++) {
                  int targetX = PlayManager.staticBlocks.get(i).x;
                  int targetY = PlayManager.staticBlocks.get(i).y;

                  // Verificamos colision hacia abajo
                  for (int ii = 0; ii < b.length; ii++) {
                        if (b[ii].y + Block.SIZE == targetY && b[ii].x == targetX) {
                              bottomCollision = true;
                        }
                  }

                  // Verificamos colision hacia la izquierda
                  for (int ii = 0; ii < b.length; ii++) {
                        if (b[ii].x - Block.SIZE == targetX && b[ii].y == targetY) {
                              leftCollision = true;
                        }
                  }

                  // Verificamos colision hacia la derecha
                  for (int ii = 0; ii < b.length; ii++) {
                        if (b[ii].x + Block.SIZE == targetX && b[ii].y == targetY) {
                              rightCollision = true;
                        }
                  }
            }

      }

      // Metodo para actualizar el estado del tetromino
      public void update() {
            // Si el tetromino se esta desactivando, llamamos al metodo de desactivacion
            if (deactivating) {
                  deactivating();
            }

            // Movimiento del tetromino
            if (KeyHandler.upPressed) {
                  switch (direction) {
                        case 1:
                              getDirection2();
                              break;
                        case 2:
                              getDirection3();
                              break;
                        case 3:
                              getDirection4();
                              break;
                        case 4:
                              getDirection1();
                              break;

                  }

                  KeyHandler.upPressed = false;
            }
            // Verificamos colisiones antes de actualizar la posicion
            checkMovementCollision();

            // Movimiento hacia abajo
            if (KeyHandler.downPressed) {
                  if (bottomCollision == false) {
                        b[0].y += Block.SIZE;
                        b[1].y += Block.SIZE;
                        b[2].y += Block.SIZE;
                        b[3].y += Block.SIZE;

                        // Reiniciamos el contador de auto-drop cuando se mueve hacia abajo
                        autoDropCounter = 0;
                  }

                  KeyHandler.downPressed = false;
            }
            // Movimiento hacia la izquierda
            if (KeyHandler.leftPressed) {
                  if (leftCollision == false) {
                        b[0].x -= Block.SIZE;
                        b[1].x -= Block.SIZE;
                        b[2].x -= Block.SIZE;
                        b[3].x -= Block.SIZE;
                  }

                  KeyHandler.leftPressed = false;

            }
            // Movimiento hacia la derecha
            if (KeyHandler.rightPressed) {
                  if (rightCollision == false) {
                        b[0].x += Block.SIZE;
                        b[1].x += Block.SIZE;
                        b[2].x += Block.SIZE;
                        b[3].x += Block.SIZE;
                  }

                  KeyHandler.rightPressed = false;

            }
            // Si hay colision con el fondo, el tetromino deja de estar activo
            if (bottomCollision) {
                  active = false;
            } else {
                  autoDropCounter++;// El contador aumenta en cada frame
                  if (autoDropCounter == PlayManager.dropInterval) {
                        // El tetromino desciende automaticamente
                        b[0].y += Block.SIZE;
                        b[1].y += Block.SIZE;
                        b[2].y += Block.SIZE;
                        b[3].y += Block.SIZE;
                        autoDropCounter = 0;
                  }

            }
      }

      // Metodo para manejar la desactivacion del tetromino
      public void deactivating() {

            deactivateCounter++;

            // Esperamos 45 frames antes de desactivar el tetromino
            if (deactivateCounter == 45) {
                  deactivateCounter = 0;
                  checkMovementCollision();// Verificamos colisiones nuevamente

                  // Si aún hay colision con el fondo despues de 45 frames, desactivamos el tetromino
                  if (bottomCollision) {
                        active = false;
                  }
            }
      }

      // Metodo para dibujar el tetromino
      public void draw(Graphics2D g2) {
            int margin = 2;
            g2.setColor(b[0].c);
            // Dibujamos cada bloque del tetromino con un margen
            g2.fillRect(b[0].x + margin, b[0].y + margin, Block.SIZE - (margin * 2), Block.SIZE - (margin * 2));
            g2.fillRect(b[1].x + margin, b[1].y + margin, Block.SIZE - (margin * 2), Block.SIZE - (margin * 2));
            g2.fillRect(b[2].x + margin, b[2].y + margin, Block.SIZE - (margin * 2), Block.SIZE - (margin * 2));
            g2.fillRect(b[3].x + margin, b[3].y + margin, Block.SIZE - (margin * 2), Block.SIZE - (margin * 2));
      }
}
