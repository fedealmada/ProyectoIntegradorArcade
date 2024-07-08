package pacman;

import sound.SoundPlayer;
import dao.UsuarioDAOImpl;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import main.Main;
import menu.Menu;
import static pacman.GamePanelPacman.gameOver;
import store.Store;

public final class Pacman extends Character {

      private int startAngle, arcAngle;
      private int movement;
      public Rectangle[] parts;
      private int lives;
      SoundPlayer sound = new SoundPlayer();

      public Pacman(int x, int y, int speed, int size, Map map) {
            this.x = 380;
            this.y = 580;
            this.speed = 20;
            this.size = 20;
            this.map = map;
            startAngle = 45;
            arcAngle = 270;

            parts = new Rectangle[]{
                  new Rectangle(this.x, this.y, 20, 20),
                  new Rectangle(this.x, this.y + 20, 20, 20),
                  new Rectangle(this.x + 20, this.y, 20, 20),
                  new Rectangle(this.x + 20, this.y + 20, 20, 20),};
      }

      public int getLives() {
            return lives;
      }

      public void setLives(int lives) {
            this.lives = lives;
      }

      public void loseLife() {
            this.lives--;
      }

      @Override
      public void spawn() {
            spawned = true;
            this.x = 380;
            this.y = 580;
            parts = new Rectangle[]{
                  new Rectangle(this.x, this.y, 20, 20),
                  new Rectangle(this.x, this.y + 20, 20, 20),
                  new Rectangle(this.x + 20, this.y, 20, 20),
                  new Rectangle(this.x + 20, this.y + 20, 20, 20),};

            this.size = 20;
            this.speed = 20;
            moveRight(x);

      }

      @Override
      public void draw(Graphics g) {
            // Hitbox
//            for(Rectangle part : parts) {
//                  g.setColor(Color.RED);
//                  g.fillArc(part.x, part.y, part.width, part.height, 0, 360);
//                  g.fillRect(part.x, part.y, part.width, part.height);
//            }

            g.setColor(color);

//           g.fillArc(x, y, size, size, 0, 360);
            switch (direction) {
                  case LEFT -> {
                        if (dx == -speed) {
                              startAngle = -135;
                              arcAngle = 270;
                              animation(g);
                        }
                  }
                  case RIGHT -> {
                        if (dx == speed) {
                              startAngle = 45;
                              arcAngle = 270;
                        }
                  }
                  case DOWN -> {
                        if (dy == speed) {
                              startAngle = -45;
                              arcAngle = 270;
                        }
                  }
                  case UP -> {
                        if (dy == -speed) {
                              startAngle = 135;
                              arcAngle = 270;
                        }
                  }
            }
            animation(g);

            g.setColor(Color.BLACK);
            g.fillOval(parts[0].x + 12, parts[0].y + 4, 8, 8);
      }

      public void animation(Graphics g) {
            switch (movement) {
                  case 0 -> {
                        g.fillArc(parts[0].x, parts[0].y, 40, 40, startAngle + 25, arcAngle - 45);
                        movement = 1;
                  }
                  case 1 -> {
                        g.fillArc(parts[0].x, parts[0].y, 40, 40, 0, 360);
                        movement = 2;
                  }
                  case 2 -> {
                        g.fillArc(parts[0].x, parts[0].y, 40, 40, startAngle + 10, arcAngle - 30);
                        movement = 3;
                  }
                  case 3 -> {
                        g.fillArc(parts[0].x, parts[0].y, 40, 40, startAngle, 360);
                        movement = 4;
                  }
                  case 4 -> {
                        g.fillArc(parts[0].x, parts[0].y, 40, 40, startAngle, arcAngle);
                        movement = 0;
                  }
            }
      }

      @Override
      public void die() {
            this.spawned = false;
            this.size = 0;
            this.speed = 0;
      }

      // Método que cambia la dirección del Pacman según la tecla presionada.
      public void KeyPressed(KeyEvent e) {
            int f0 = parts[0].y / Map.BLOCKSIZE;
            int c0 = parts[0].x / Map.BLOCKSIZE;
            int f1 = parts[1].y / Map.BLOCKSIZE;
            int c1 = parts[1].x / Map.BLOCKSIZE;
            int f2 = parts[2].y / Map.BLOCKSIZE;
            int c2 = parts[2].x / Map.BLOCKSIZE;
            int f3 = parts[3].y / Map.BLOCKSIZE;
            int c3 = parts[3].x / Map.BLOCKSIZE;

            int key = e.getKeyCode();
            switch (key) {

                  case KeyEvent.VK_ENTER -> {
                        if (gameOver) {
                              GamePanelPacman.iniciarPartida();
                        }

                        if (!GamePanelPacman.gameStarted && !GamePanelPacman.changingMap) {
                              GamePanelPacman.gameStarted = true;
                              GamePanelPacman.iniciarPartida();
                        }
                  }

                  case KeyEvent.VK_A, KeyEvent.VK_LEFT -> {
                        direction = Directions.LEFT;
                        if (!map.matrizObjetos.isBlock(f0, c0 - 1) && !map.matrizObjetos.isBlock(f1, c1 - 1) && !map.matrizObjetos.isBlock(f2, c2 - 1) && !map.matrizObjetos.isBlock(f3, c3 - 1)) {
                              if (direction != Directions.LEFT) {
                                    moveLeft(x);
                              }
                        }
                  }

                  case KeyEvent.VK_D, KeyEvent.VK_RIGHT -> {
                        direction = Directions.RIGHT;
                        if (!map.matrizObjetos.isBlock(f0, c0 + 1) && !map.matrizObjetos.isBlock(f1, c1 + 1) && !map.matrizObjetos.isBlock(f2, c2 + 1) && !map.matrizObjetos.isBlock(f3, c3 + 1)) {
                              if (direction != Directions.RIGHT) {
                                    moveRight(x);
                              }
                        }
                  }
                  case KeyEvent.VK_W, KeyEvent.VK_UP -> {
                        direction = Directions.UP;
                        if (!map.matrizObjetos.isBlock(f0 - 1, c0) && !map.matrizObjetos.isBlock(f1 - 1, c1) && !map.matrizObjetos.isBlock(f2 - 1, c2) && !map.matrizObjetos.isBlock(f3 - 1, c3)) {
                              if (direction != Directions.UP) {
                                    moveUp(y);
                              }
                        }
                  }
                  case KeyEvent.VK_S, KeyEvent.VK_DOWN -> {
                        direction = Directions.DOWN;
                        if (!map.matrizObjetos.isBlock(f0 + 1, c0) && !map.matrizObjetos.isBlock(f1 + 1, c1) && !map.matrizObjetos.isBlock(f2 + 1, c2) && !map.matrizObjetos.isBlock(f3 + 1, c3)) {
                              if (direction != Directions.DOWN) {
                                    moveDown(y);
                              }
                        }
                  }

                  case KeyEvent.VK_ESCAPE, KeyEvent.VK_K -> {
                        if (!GamePanelPacman.gameOver) { // Cuando presionamos Escape y el juego no está terminado
                              int resp = JOptionPane.showConfirmDialog(null, "¿Desea salir de la partida? Las estadisticas no se van a guardar.",
                                 "Salir", JOptionPane.YES_NO_OPTION,
                                 JOptionPane.INFORMATION_MESSAGE, null);

                              if (resp == JOptionPane.YES_OPTION) {
                                    Main.vtnMenu.setVisible(true);
                                    Main.gamePacman.stop();

                              }
                        } else {// Cuando presionamos Escape y el juego está terminado
                              UsuarioDAOImpl usuario = new UsuarioDAOImpl();
                              
                              try {
                                    // Actualizamos Score en la database
                                    usuario.actualizarCampo("scorePacman", Main.userLogged.getScorePacman());
                              } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
                                    Logger.getLogger(Pacman.class.getName()).log(Level.SEVERE, null, ex);
                              }
                              
                              // Actualizamos los Creditos.
                              Main.userLogged.setCoins(Main.userLogged.getCoins() + (GamePanelPacman.score / 1000));

                              
                              try {
                                    usuario.actualizarCampo("coins", Main.userLogged.getCoins());
                              } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
                                    Logger.getLogger(Pacman.class.getName()).log(Level.SEVERE, null, ex);
                              }

                              // Actualizamos los labels donde se muestran los créditos.
                              Menu.lblCreditos.setText("Creditos: " + Main.userLogged.getCoins());
                              Store.lblCreditos.setText("Creditos: " + Main.userLogged.getCoins());

                              Main.vtnMenu.setVisible(true);
                              Main.gamePacman.stop();
                        }
                  }
            }
      }

      public Rectangle getBounds() {
            return new Rectangle(parts[0].x, parts[0].y, size + size, size + size);
      }

      public void recreateHitbox() {
            parts = new Rectangle[]{
                  new Rectangle(this.x, this.y, 20, 20),
                  new Rectangle(this.x, this.y + 20, 20, 20),
                  new Rectangle(this.x + 20, this.y, 20, 20),
                  new Rectangle(this.x + 20, this.y + 20, 20, 20),};
      }

      @Override
      public void move(Pacman pacman, Map map) {

            int f0 = parts[0].y / Map.BLOCKSIZE;
            int c0 = parts[0].x / Map.BLOCKSIZE;
            int f1 = parts[1].y / Map.BLOCKSIZE;
            int c1 = parts[1].x / Map.BLOCKSIZE;
            int f2 = parts[2].y / Map.BLOCKSIZE;
            int c2 = parts[2].x / Map.BLOCKSIZE;
            int f3 = parts[3].y / Map.BLOCKSIZE;
            int c3 = parts[3].x / Map.BLOCKSIZE;

            // Chequeos de colisiones y movimiento para cada bloque de Pacman.
            if (direction == Directions.LEFT) {
                  if (!map.matrizObjetos.isBlock(f0, c0 - 1) && !map.matrizObjetos.isBlock(f1, c1 - 1) && !map.matrizObjetos.isBlock(f2, c2 - 1) && !map.matrizObjetos.isBlock(f3, c3 - 1)) {
                        moveLeft(x);
                  }
            }

            if (direction == Directions.RIGHT) {
                  if (!map.matrizObjetos.isBlock(f0, c0 + 1) && !map.matrizObjetos.isBlock(f1, c1 + 1) && !map.matrizObjetos.isBlock(f2, c2 + 1) && !map.matrizObjetos.isBlock(f3, c3 + 1)) {
                        moveRight(x);
                  }
            }

            if (direction == Directions.UP) {
                  if (!map.matrizObjetos.isBlock(f0 - 1, c0) && !map.matrizObjetos.isBlock(f1 - 1, c1) && !map.matrizObjetos.isBlock(f2 - 1, c2) && !map.matrizObjetos.isBlock(f3 - 1, c3)) {
                        moveUp(y);
                  }
            }

            if (direction == Directions.DOWN) {
                  if (!map.matrizObjetos.isBlock(f0 + 1, c0) && !map.matrizObjetos.isBlock(f1 + 1, c1) && !map.matrizObjetos.isBlock(f2 + 1, c2) && !map.matrizObjetos.isBlock(f3 + 1, c3)) {
                        moveDown(y);
                  }
            }

            // Teleport
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

            // Chequeo de colisiones para cada bloque del Pacman
            if (!checkCollision(parts[0].x + dx, parts[0].y) && !checkCollision(parts[1].x + dx, parts[1].y) && !checkCollision(parts[2].x + dx, parts[2].y) && !checkCollision(parts[3].x + dx, parts[3].y)) {
                  parts[0].x += dx;
                  parts[1].x += dx;
                  parts[2].x += dx;
                  parts[3].x += dx;
            }
            if (!checkCollision(parts[0].x, parts[0].y + dy) && !checkCollision(parts[1].x, parts[1].y + dy) && !checkCollision(parts[2].x, parts[2].y + dy) && !checkCollision(parts[3].x, parts[3].y + dy)) {
                  parts[0].y += dy;
                  parts[1].y += dy;
                  parts[2].y += dy;
                  parts[3].y += dy;
            }

            eat();
      }

      public void eat() {
            for (int i = 0; i < map.filas; i++) {
                  for (int j = 0; j < map.columnas; j++) {

                        if (!map.matrizObjetos.isNull(i, j)) {
                              if (new Rectangle(j * 20, i * 20, 20, 20).getBounds().intersects(parts[0].x, parts[0].y, size, size)) {
                                    if (map.matrizObjetos.isDot(i, j)) {

                                          if(Ghost.vulnerableTime > 0)
                                                sound.playSound("src\\pacman\\sfx\\dot2.mp3");
                                          else 
                                                sound.playSound("src\\pacman\\sfx\\punto.mp3");
                                          
                                          GamePanelPacman.score += 10;
                                          Dot dot = (Dot) map.matrizObjetos.obtenerObjeto(i, j);
                                          dot.setColor(Color.RED);
                                          map.matrizObjetos.setearObjeto(null, i, j);

                                          if (!map.matrizObjetos.hayDots()) {
                                                ActionListener reiniciarPartida = (ActionEvent e1) -> {
                                                      GamePanelPacman.gameStarted = true;
                                                      GamePanelPacman.changingMap = false;
                                                      GamePanelPacman.reiniciarMapa();

                                                };

                                                GamePanelPacman.detenerTimer();

                                                for (int fila = 0; fila < map.filas; fila++) {
                                                      for (int columna = 0; columna < map.columnas; columna++) {
                                                            if (!map.matrizObjetos.isNull(fila, columna) && map.matrizObjetos.isBlock(fila, columna)) {
                                                                  Block bloque = (Block) map.matrizObjetos.obtenerObjeto(fila, columna);
                                                                  bloque.setColor(Color.WHITE);
                                                            }
                                                      }
                                                }

                                                GamePanelPacman.gameStarted = false;
                                                GamePanelPacman.changingMap = true;

                                                Timer reiniciarPartidaTimer = new Timer(3000, reiniciarPartida);
                                                reiniciarPartidaTimer.setRepeats(false);
                                                reiniciarPartidaTimer.start();

                                          }

                                    }
                                    if (map.matrizObjetos.isPower(i, j)) {
                                          GamePanelPacman.score += 30;
                                          GamePanelPacman.points = 100;
                                          Ghost.vulnerableAll();
                                          map.matrizObjetos.setearObjeto(null, i, j);

                                          sound.stopSound();
                                          sound.playSound("src\\pacman\\sfx\\power_1.mp3");

                                    }
                              }

                        }
                  }
            }
      }

      @Override
      public String toString() {
            return "Pacman{" + "x=" + x + ", y=" + y + ", dx=" + dx + ", dy=" + dy + ", speed=" + speed + ", size=" + size + '}';
      }
}
