/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tetris;

import tetromino.Block;
import tetromino.Mino;
import tetromino.Mino_L1;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.Random;
import sound.SoundPlayer;
import tetromino.Mino_Bar;
import tetromino.Mino_L2;
import tetromino.Mino_Square;
import tetromino.Mino_T;
import tetromino.Mino_Z1;
import tetromino.Mino_Z2;

/**
 *
 * @author Alumno
 */
public class PlayManager {
      // Dimensiones del área de juego

      final int WIDTH = 360;
      final int HEIGHT = 600;
      public static int left_x;
      public static int right_x;
      public static int top_y;
      public static int bottom_y;

      // Tetromino
      Mino currentMino;
      final int MINO_START_X;
      final int MINO_START_Y;
      Mino nextMino;
      final int NEXTMINO_X;
      final int NEXTMINO_Y;
      public static ArrayList<Block> staticBlocks = new ArrayList<>();

      //otros
      public static int dropInterval = 50;// Intervalo de caída en frames
      boolean gameOver;

      //efectos
      boolean effectCounterOn;
      int effectCounter;
      ArrayList<Integer> effectY = new ArrayList<>();

      //Puntuacion
      int level = 1;
      int lines;
      int score;

      // Lista de partículas
      ArrayList<Particle> particles = new ArrayList<>();

      public PlayManager() {
            // Calculamos las coordenadas del área de juego
            left_x = (GamePanelTetris.WIDTH / 2) - (WIDTH / 2);//1280/2 -360/2 = 460
            right_x = left_x + WIDTH;
            top_y = 50;
            bottom_y = top_y + HEIGHT;

            // Coordenadas iniciales del tetromino
            MINO_START_X = left_x + (WIDTH / 2) - Block.SIZE;
            MINO_START_Y = top_y + Block.SIZE;

            // Coordenadas del próximo tetromino
            NEXTMINO_X = right_x + 175;
            NEXTMINO_Y = top_y + 500;

            // Seleccionamos el tetromino actual y el siguiente
            currentMino = pickMino();
            currentMino.setXY(MINO_START_X, MINO_START_Y);
            nextMino = pickMino();
            nextMino.setXY(NEXTMINO_X, NEXTMINO_Y);

      }

      private Mino pickMino() { // Método para seleccionar un tetromino aleatorio

            Mino mino = null;
            int i = new Random().nextInt(7);// Selecciona un número aleatorio entre 0 y 6
            switch (i) {
                  case 0:
                        mino = new Mino_L1();
                        break;
                  case 1:
                        mino = new Mino_L2();
                        break;
                  case 2:
                        mino = new Mino_Square();
                        break;
                  case 3:
                        mino = new Mino_Bar();
                        break;
                  case 4:
                        mino = new Mino_T();
                        break;
                  case 5:
                        mino = new Mino_Z1();
                        break;
                  case 6:
                        mino = new Mino_Z2();
                        break;

            }
            return mino;
      }

      public void addParticles(int x, int y, Color color) {
            for (int i = 0; i < 10; i++) {
                  int vx = (int) (Math.random() * 10 - 5);
                  int vy = (int) (Math.random() * 10 - 5);
                  particles.add(new Particle(x, y, vx, vy, color, 100));
            }
      }

      public void updateParticles() {
            for (int i = particles.size() - 1; i >= 0; i--) {
                  Particle p = particles.get(i);
                  p.update();
                  if (p.lifespan <= 0) {
                        particles.remove(i);
                  }
            }
      }

      public void drawParticles(Graphics2D g2) {
            for (Particle p : particles) {
                  p.draw(g2);
            }
      }

      public void update() {// Método para actualizar el estado del juego
            // Verificamos si el tetromino está activo

            if (currentMino.active == false) {
                  // Si el tetromino no está activo, lo añadimos a los bloques estáticos
                  staticBlocks.add(currentMino.b[0]);
                  staticBlocks.add(currentMino.b[1]);
                  staticBlocks.add(currentMino.b[2]);
                  staticBlocks.add(currentMino.b[3]);
                  try {
                        sound.SoundPlayer sound = new SoundPlayer();
                        sound.playSound("src\\tetris\\sfx\\pop.mp3");
                  } catch (Exception ex) {
                        System.out.println("Archivo de sonido no encontrado.");
                  }
                  // Verificamos si el juego ha terminado
                  if (currentMino.b[0].x == MINO_START_X && currentMino.b[0].y == MINO_START_Y) {
                        gameOver = true;
                  }

                  currentMino.deactivating = false;

                  // Reemplazamos el tetromino actual por el siguiente
                  currentMino = nextMino;
                  currentMino.setXY(MINO_START_X, MINO_START_Y);
                  nextMino = pickMino();
                  nextMino.setXY(NEXTMINO_X, NEXTMINO_Y);

                  checkDelete();

            } else {
                  currentMino.update();// Si el tetromino está activo, actualizamos su estado
            }
            updateParticles();

      }

      public void checkDelete() { // Método para verificar y eliminar líneas completas
            int x = left_x;
            int y = top_y;
            int blockCount = 0;
            int lineCount = 0;

            while (x < right_x && y < bottom_y) {

                  for (int i = 0; i < staticBlocks.size(); i++) {
                        if (staticBlocks.get(i).x == x && staticBlocks.get(i).y == y) {

                              blockCount++;// Incrementamos el contador si hay un bloque estático en la posición
                        }
                  }

                  x += Block.SIZE;
                  if (x == right_x) {

                        // Si el contador de bloques alcanza 12, significa que la línea está llena
                        if (blockCount == 12) {
                              // Activamos el contador de efectos y añadimos la línea a eliminar
                              effectCounterOn = true;
                              effectY.add(y);

                              // Eliminamos todos los bloques en la línea actual
                              for (int i = staticBlocks.size() - 1; i > -1; i--) {

                                    if (staticBlocks.get(i).y == y) {
                                          staticBlocks.remove(i);
                                    }
                              }

                              lineCount++;
                              lines++;
                              // Incrementamos el nivel y ajustamos el intervalo de caída
                              if (lines % 10 == 0 && dropInterval > 1) {
                                    level++;
                                    if (dropInterval > 5) {
                                          dropInterval -= 5;
                                    } else {
                                          dropInterval -= 1;
                                    }
                              }

                              // Deslizamos hacia abajo los bloques que están por encima de la línea eliminada
                              for (int i = 0; i < staticBlocks.size(); i++) {
                                    if (staticBlocks.get(i).y < y) {
                                          staticBlocks.get(i).y += Block.SIZE;
                                    }
                              }
                              // Añadir partículas
                              addParticles(left_x, y, Color.RED);

                        }

                        blockCount = 0;
                        x = left_x;
                        y += Block.SIZE;
                  }
            }
            // Añadimos la puntuación por las líneas eliminadas
            if (lineCount > 0) {
                  int singleLineScore = 10 * level;
                  score += singleLineScore * lineCount;
            }

      }

      public void drawControls(Graphics2D g2) {
            int x = left_x - 350; // Posición en el lado izquierdo del área de juego
            int y = top_y; // Ajusta según sea necesario

            // Dibujar marco para las instrucciones
            g2.setColor(Color.white);
            g2.setStroke(new BasicStroke(2f));
            g2.drawRect(x, y, 250, 200);

            // Dibujar las instrucciones
            g2.setFont(new Font("Arial", Font.PLAIN, 20));
            g2.setColor(Color.white);
            g2.drawString("Controles:", x + 20, y + 30);
            g2.drawString("Mover izquierda: �?", x + 20, y + 60);
            g2.drawString("Mover derecha: →", x + 20, y + 90);
            g2.drawString("Rotar: ↑", x + 20, y + 120);
            g2.drawString("Caída rápida: ↓", x + 20, y + 150);
            g2.drawString("Pausa: space", x + 20, y + 180);
      }

      public void draw(Graphics2D g2) {
            // Dibujamos el marco del área de juego
            g2.setColor(Color.white);
            g2.setStroke(new BasicStroke(4f));
            g2.drawRect(left_x - 4, top_y - 4, WIDTH + 8, HEIGHT + 8);

            // Dibujar fondo del tablero
            g2.setColor(new Color(50, 50, 50));
            g2.fillRect(left_x, top_y, WIDTH, HEIGHT);

            // Dibujar líneas de la cuadrícula
            g2.setColor(Color.darkGray);
            for (int i = left_x; i <= right_x; i += Block.SIZE) {
                  g2.drawLine(i, top_y, i, bottom_y);
            }
            for (int j = top_y; j <= bottom_y; j += Block.SIZE) {
                  g2.drawLine(left_x, j, right_x, j);
            }

            // Dibujar marco del tablero
            g2.setColor(Color.white);
            g2.setStroke(new BasicStroke(4f));
            g2.drawRect(left_x - 4, top_y - 4, WIDTH + 8, HEIGHT + 8);

            // Dibujamos el marco del siguiente tetromino
            int x = right_x + 100;
            int y = bottom_y - 200;
            g2.drawRect(x, y, 200, 200);
            g2.setFont(new Font("Arial", Font.PLAIN, 30));
            g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            g2.drawString("NEXT", x + 60, y + 60);

            // Dibujamos el marco de la puntuación
            g2.drawRect(x, top_y, 250, 300);
            x += 40;
            y = top_y + 90;
            g2.drawString("LEVEL:" + level, x, y);
            y += 70;
            g2.drawString("LINES:" + lines, x, y);
            y += 70;
            g2.drawString("SCORE:" + score, x, y);

            // Dibujar instrucciones
            drawControls(g2);

            // Dibujamos el tetromino actual
            if (currentMino != null) {
                  currentMino.draw(g2);
            }

            // Dibujamos el siguiente tetromino
            nextMino.draw(g2);

            // Dibujamos los bloques estáticos
            for (int i = 0; i < staticBlocks.size(); i++) {
                  staticBlocks.get(i).draw(g2);
            }

            // Dibujamos los efectos de eliminación de línea
            if (effectCounterOn) {
                  effectCounter++;
                  g2.setColor(Color.red);

                  for (int i = 0; i < effectY.size(); i++) {
                        g2.fillRect(left_x, effectY.get(i), WIDTH, Block.SIZE);
                  }
                  if (effectCounter == 10) {
                        effectCounterOn = false;
                        effectCounter = 0;
                        effectY.clear();
                  }
            }

            // Dibujar partículas
            drawParticles(g2);

            // Dibujamos mensajes de pausa o game over
            g2.setColor(Color.red);
            g2.setFont(g2.getFont().deriveFont(50f));
            if (gameOver) {
                  x = left_x + 25;
                  y = top_y + 320;
                  g2.drawString("GAME OVER", x, y);
            } else if (KeyHandler.pausePressed) {
                  x = left_x + 70;
                  y = top_y + 320;
                  g2.drawString("PAUSED", x, y);
            }

      }

}
