package pacman;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;

public final class Ghost extends Character {

      private static ArrayList<Ghost> ghosts = new ArrayList(); // Lista estática que va a almacenar todas las instancias de Ghosts.
      private Color originalColor; // Va a almacenar el color del Ghost para colocarselo luego de salir del modo Scared (asustado).
      private boolean randomMove = false;
      private static Timer timer = new Timer();
      public static int vulnerableTime;
      public JLabel lblGhostStats;
      public Rectangle[] parts;
      public GhostState state;

      enum GhostState {
            SCARED,
            DEAD,
            EXPLORING,
            CHASING
      }

      private TimerTask timerTask = new TimerTask() { // Esta tarea lo que hace es chequear cada 1 segundo si el Ghost deja de ser Vulnerable (SCARED).
            @Override
            public void run() {
                  if (vulnerableTime < 1) { // Si el contador de vulnerabilidad es menor a 1 entonces los Ghosts Scared vuelven a su estado normal.
                        GamePanelPacman.timer.setDelay(85);

                        for (int fila = 0; fila < map.filas; fila++) {
                              for (int columna = 0; columna < map.columnas; columna++) {
                                    if (!map.matrizObjetos.isNull(fila, columna) && map.matrizObjetos.isBlock(fila, columna)) {
                                          Block bloque = (Block) map.matrizObjetos.obtenerObjeto(fila, columna);
                                          Color bloqueColor;
                                          switch (GamePanelPacman.level) {
                                                case 1 ->
                                                      bloqueColor = Color.BLUE;
                                                case 2 ->
                                                      bloqueColor = Color.RED;
                                                case 3 ->
                                                      bloqueColor = Color.YELLOW;
                                                default ->
                                                      bloqueColor = Color.GREEN;
                                          }

                                          bloque.setColor(bloqueColor);
                                    }
                              }
                        }

                        for (Ghost ghost : ghosts) {
                              if (ghost.state == GhostState.SCARED) {
                                    ghost.state = GhostState.EXPLORING;
                                    ghost.setColor(ghost.getOriginalColor());
                                    GamePanelPacman.points = 0;
                              }
                        }
                  } else { // Si el contador de vulnerabilidad es mayor o igual a 1 se decrementa el contador.
                        GamePanelPacman.timer.setDelay(65);
                        for (int fila = 0; fila < map.filas; fila++) {
                              for (int columna = 0; columna < map.columnas; columna++) {
                                    if (!map.matrizObjetos.isNull(fila, columna) && map.matrizObjetos.isBlock(fila, columna)) {
                                          Block bloque = (Block) map.matrizObjetos.obtenerObjeto(fila, columna);

                                          Color bloqueColor;
                                          switch (GamePanelPacman.level) {
                                                case 1 ->
                                                      bloqueColor = Color.BLUE;
                                                case 2 ->
                                                      bloqueColor = Color.RED;
                                                case 3 ->
                                                      bloqueColor = Color.YELLOW;
                                                default ->
                                                      bloqueColor = Color.GREEN;
                                          }
                                          bloque.setColor(bloqueColor.darker().darker().darker());
                                    }
                              }
                        }

                        switch (vulnerableTime) {
                              case 1, 3, 5, 7, 9 -> { // Cuando los Ghosts Scared están por cambiar de estado.
                                    for (Ghost ghost : ghosts) {
                                          if (ghost.state == GhostState.SCARED) {
                                                ghost.setColor(Color.WHITE);
                                          }
                                    }
                              }
                              default -> { // Cuando los Ghosts están en Scared.
                                    for (Ghost ghost : ghosts) {
                                          if (ghost.state == GhostState.SCARED) {
                                                ghost.setColor(Color.BLUE);
                                          }
                                    }
                              }

                        }
                        vulnerableTime--;
                  }
            }
      };

      public Ghost() {
      }

      public Ghost(Color color, String nombre, Pacman pacman, Map map) {
            // Inicializamos un Timer estático antes de agregar a la lista el primer Ghost. Va a servir para realizar la tarea creada anteriormente.
            if (ghosts.isEmpty()) {
                  timer.schedule(timerTask, 150, 150);
            }

            ghosts.add(this); // Agregamos la instancia a la lista estática de Ghosts.
            this.x = 380; // Asignamos posición inicial en x.
            this.y = 340; // Asignamos posición inicial en y.
            this.map = map;
            this.nombre = nombre;
            this.color = color;
            this.originalColor = color;
            this.speed = 20;
            this.size = 20;

            spawn();
      }

      @Override
      public void spawn() {
            this.state = GhostState.EXPLORING;
            this.spawned = true;

            this.x = 380;
            this.y = 340;
            recreateHitbox();

            this.size = 20;
            this.speed = 20;

            setColor(this.originalColor);
            moveLeft(x);
      }

      public void recreateHitbox() {
            parts = new Rectangle[]{
                  new Rectangle(this.x, this.y, 20, 20),
                  new Rectangle(this.x, this.y + 20, 20, 20),
                  new Rectangle(this.x + 20, this.y, 20, 20),
                  new Rectangle(this.x + 20, this.y + 20, 20, 20),};
      }

      public GhostState getState() {
            return state;
      }

      public void setState(GhostState state) {
            this.state = state;
      }

      @Override
      public void die() {
            this.state = GhostState.DEAD;
            this.size = 0;
            this.speed = 0;
            this.spawned = false;
            parts = new Rectangle[]{
                  new Rectangle(this.x, this.y, size, size),
                  new Rectangle(this.x, this.y + 20, size, size),
                  new Rectangle(this.x + 20, this.y, size, size),
                  new Rectangle(this.x + 20, this.y + 20, size, size),};

            ActionListener taskSpawn = (ActionEvent e1) -> spawn();

            javax.swing.Timer respawnTimer = new javax.swing.Timer(4000, taskSpawn);
            respawnTimer.setRepeats(false);
            respawnTimer.start();
      }

      // Método estático que spawnea a todos los Ghosts. (Usado cuando el Pacman se intersecta con algún Ghost).
      public static void spawnAll() {
            if (!ghosts.isEmpty()) {
                  for (int i = 0; i < ghosts.size(); i++) {
                        ghosts.get(i).spawn();
                  }
            }
      }

      public Rectangle getBounds() {
            return new Rectangle(parts[0].x, parts[0].y, size * 2, size * 2);
      }

      // Método estático que vuelve vulnerable a todos los Ghosts. (Usado cuando el Pacman se intersecta con algún DotSmall / Punto Grande).
      public static void vulnerableAll() {
            vulnerableTime = 50;
            for (Ghost ghost : ghosts) {
                  ghost.state = GhostState.SCARED;
            }
      }

      @Override
      public void draw(Graphics g) {
//            for(Rectangle part : parts) {
//                  g.setColor(Color.RED);
//                  g.fillRect(part.x, part.y, part.width, part.height);
//            }

            if (spawned) {
                  g.setColor(color);
                  g.fillRoundRect(parts[0].x, parts[0].y, 40, 40, 20, 45);
            }
            // Ojos
            g.setColor(Color.WHITE);
            g.fillOval(parts[0].x + 6, parts[0].y + 6, 10, 14);
            g.fillOval(parts[0].x + 18, parts[0].y + 6, 10, 14);

            // Movimiento de pupilas
            switch (direction) {
                  case DOWN -> {
                        g.setColor(Color.BLUE);
                        g.fillOval(parts[0].x + 6, parts[0].y + 12, 6, 6);
                        g.fillOval(parts[0].x + 18, parts[0].y + 12, 6, 6);
                  }
                  case UP -> {
                        g.setColor(Color.BLUE);
                        g.fillOval(parts[0].x + 6, parts[0].y + 12 - 4, 6, 6);
                        g.fillOval(parts[0].x + 18, parts[0].y + 12 - 4, 6, 6);
                  }
                  case LEFT -> {
                        g.setColor(Color.BLUE);
                        g.fillOval(parts[0].x + 6, parts[0].y + 12, 6, 6);
                        g.fillOval(parts[0].x + 18, parts[0].y + 12, 6, 6);
                  }
                  default -> {
                        g.setColor(Color.BLUE);
                        g.fillOval(parts[0].x + 6 + 4, parts[0].y + 12, 6, 6);
                        g.fillOval(parts[0].x + 18 + 4, parts[0].y + 12, 6, 6);
                  }
            }
      }

      public Color getOriginalColor() {
            return originalColor;
      }

      public void setOriginalColor(Color originalColor) {
            this.originalColor = originalColor;
      }

      @Override
      public void move(Pacman pacman, Map map) {

            if (parts[0].x == 40 && parts[0].y == 360) {
                  x = 740;
                  y = 360;
                  recreateHitbox();
                  moveLeft(x);
            } else if (parts[0].x == 740 && parts[0].y == 360) {
                  x = 40;
                  y = 360;
                  recreateHitbox();
                  moveRight(x);
            }

            if (!checkCollision(parts[0].x + dx, parts[0].y) && !checkCollision(parts[1].x + dx, parts[1].y) && !checkCollision(parts[2].x + dx, parts[2].y) && !checkCollision(parts[3].x + dx, parts[3].y)) {
                  parts[0].x += dx;
                  parts[1].x += dx;
                  parts[2].x += dx;
                  parts[3].x += dx;
                  randomMove = true;
            } else {
                  if (randomMove) {
                        randomMove = false;
                        Random r = new Random();
                        int value = r.nextInt(4);
                        switch (value) {
                              case 0 -> {
                                    if (direction == Directions.UP) {
                                          moveLeft(x);
                                    } else {
                                          moveRight(x);
                                    }
                              }
                              case 1 -> {
                                    if (direction == Directions.DOWN) {
                                          moveRight(x);
                                    } else {
                                          moveLeft(x);
                                    }
                              }
                              case 2 -> {
                                    if (direction == Directions.RIGHT) {
                                          moveUp(y);
                                    } else {
                                          moveDown(y);
                                    }
                              }
                              case 3 -> {
                                    if (direction == Directions.LEFT) {
                                          moveDown(y);
                                    } else {
                                          moveUp(y);
                                    }
                              }
                        }
                  }
            }
            if (!checkCollision(parts[0].x, parts[0].y + dy) && !checkCollision(parts[1].x, parts[1].y + dy) && !checkCollision(parts[2].x, parts[2].y + dy) && !checkCollision(parts[3].x, parts[3].y + dy)) {
                  parts[0].y += dy;
                  parts[1].y += dy;
                  parts[2].y += dy;
                  parts[3].y += dy;
                  randomMove = true;
            } else {
                  if (randomMove) {
                        randomMove = false;
                        Random r = new Random();
                        int value = r.nextInt(4);
                        switch (value) {
                              case 0 -> {
                                    if (direction == Directions.UP) {
                                          moveLeft(x);
                                    } else {
                                          moveRight(x);
                                    }
                              }
                              case 1 -> {
                                    if (direction == Directions.DOWN) {
                                          moveRight(x);
                                    } else {
                                          moveLeft(x);
                                    }
                              }
                              case 2 -> {
                                    if (direction == Directions.RIGHT) {
                                          moveUp(y);
                                    } else {
                                          moveDown(y);
                                    }
                              }
                              case 3 -> {
                                    if (direction == Directions.LEFT) {
                                          moveDown(y);
                                    } else {
                                          moveUp(y);
                                    }
                              }
                        }
                  }
            }

            Random r = new Random();
            int value = r.nextInt(15);
            switch (value) {
                  case 0 -> {
                        if (direction == Directions.UP) {
                              moveRight(x);
                        }
                  }
                  case 1 -> {
                        if (direction == Directions.DOWN) {
                              moveLeft(x);
                        }
                  }
                  case 2 -> {
                        if (direction == Directions.RIGHT) {
                              moveUp(y);
                        }
                  }
                  case 3 -> {
                        if (direction == Directions.LEFT) {
                              moveDown(y);
                        }
                  }
            }

      }

      @Override
      public boolean checkCollision(int x, int y) {
            int fila = y / 20;
            int columna = x / 20;

            if (fila >= 0 && fila < map.filas && columna < map.columnas) {
                  if (!map.matrizObjetos.isNull(fila, columna)) {
                        return map.matrizObjetos.isBlock(fila, columna);
                  }
            }
            return false;
      }
}
