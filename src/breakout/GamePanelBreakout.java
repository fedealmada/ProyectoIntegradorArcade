package breakout;

import dao.UsuarioDAOImpl;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;
import main.Main;
import menu.Menu;
import store.Store;

public class GamePanelBreakout extends javax.swing.JPanel implements KeyListener, ActionListener {

      UsuarioDAOImpl usuario = new UsuarioDAOImpl();

      private boolean play = false;
      private int score = 0;// Puntaje del jugador
      private int totalBricks = 21;

      private Timer timer;// Timer para controlar la velocidad del juego
      private int delay = 8;// Retraso en milisegundos para el Timer

      private int playerX = 310;// posición inicial de la barra

      private int ballPosX = 120; // posición inicial de la pelota en X
      private int ballPosY = 350; // Posición inicial de la pelota en Y
      private int ballXDir = -1; // Dirección de movimiento de la pelota en X
      private int ballYDir = -2; // Dirección de movimiento de la pelota en Y

      private MapGenerator map;

      public GamePanelBreakout() {
            initComponents();

            map = new MapGenerator(3, 7);// Crear un nuevo mapa con 3 filas y 7 columnas de ladrillos
            addKeyListener(this);// Agregar el KeyListener para las entradas del teclado
            setFocusable(true); // Hacer que el panel sea enfocable
            setFocusTraversalKeysEnabled(false); // Deshabilitar el enfoque de teclas de tabulación
            timer = new Timer(delay, this);// Inicializar el Timer
            timer.start();// Iniciar el Timer
      }

      @SuppressWarnings("unchecked")
      // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
      private void initComponents() {

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
            this.setLayout(layout);
            layout.setHorizontalGroup(
                  layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGap(0, 400, Short.MAX_VALUE)
            );
            layout.setVerticalGroup(
                  layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGap(0, 300, Short.MAX_VALUE)
            );
      }// </editor-fold>//GEN-END:initComponents

      public void paint(Graphics g) {
            // Fondo
            g.setColor(Color.black);
            g.fillRect(1, 1, 692, 592);// Dibujar el fondo del juego

            // Dibujar mapa
            map.draw((Graphics2D) g); // Dibujar los ladrillos

            // Bordes
            g.setColor(Color.yellow);
            g.fillRect(0, 0, 3, 592);// Borde izquierdo
            g.fillRect(0, 0, 692, 3); // Borde superior
            g.fillRect(691, 0, 3, 592); // Borde derecho

            // Puntuación
            g.setColor(Color.white);
            g.setFont(new Font("serif", Font.BOLD, 25));
            g.drawString("" + score, 590, 30); // Dibujar el puntaje

            // Barra
            g.setColor(Color.blue);
            g.fillRect(playerX, 550, 100, 8);

            // Pelota
            g.setColor(Color.yellow);
            g.fillOval(ballPosX, ballPosY, 20, 20);// Dibujar la pelota

            // Game Over
            if (ballPosY > 570) {
                  play = false; // Detener el juego
                  ballXDir = 0; // Detener el movimiento de la pelota
                  ballYDir = 0;
                  g.setColor(Color.red);
                  g.setFont(new Font("serif", Font.BOLD, 30));
                  g.drawString("Game Over, Score: " + score, 190, 300);

                  if (score > Main.userLogged.getScoreBreakout()) {
                        Main.userLogged.setScoreBreakout(score);
                        try {
                              usuario.actualizarCampo("scoreAtari", score);
                        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
                              Logger.getLogger(GamePanelBreakout.class.getName()).log(Level.SEVERE, null, ex);
                        }
                  }

                  // le mandas el score al sql
                  g.setFont(new Font("serif", Font.BOLD, 20));
                  g.drawString("Press Enter to Restart", 230, 350);
            }
            //Victory
            if (totalBricks <= 0) {
                  play = false; // Detener el juego
                  ballXDir = 0; // Detener el movimiento de la pelota
                  ballYDir = 0;
                  g.setColor(Color.green);
                  g.setFont(new Font("serif", Font.BOLD, 30));
                  g.drawString("You Won! Score: " + score, 190, 300); // Mostrar mensaje de victoria

                  g.setFont(new Font("serif", Font.BOLD, 20));
                  g.drawString("Press Enter to Restart", 230, 350); // Mostrar mensaje para reiniciar el juego

                  if (score > Main.userLogged.getScoreBreakout()) {
                        Main.userLogged.setScoreBreakout(score);
                        try {
                              usuario.actualizarCampo("scoreAtari", score);
                        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
                              Logger.getLogger(GamePanelBreakout.class.getName()).log(Level.SEVERE, null, ex);
                        }
                  }
            }

            g.dispose(); // Liberar recursos del gráfico
      }

      @Override
      public void keyTyped(KeyEvent e) {
      }

      @Override
      public void keyPressed(KeyEvent e) {
            // Mover la barra a la derecha
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                  if (playerX >= 600) {
                        playerX = 600;
                  } else {
                        moveRight();
                  }
            }
            // Mover la barra a la izquierda      
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                  if (playerX < 10) {
                        playerX = 10;
                  } else {
                        moveLeft();
                  }
            }
            if (e.getKeyCode() == KeyEvent.VK_K || e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                  Main.gameAtari.stop();
                  Main.vtnMenu.setVisible(true);

                  // Actualizamos sus Creditos.
                  Main.userLogged.setCoins(Main.userLogged.getCoins() + (this.score / 10));

                  usuario = new UsuarioDAOImpl();
                  try {
                        usuario.actualizarCampo("coins", Main.userLogged.getCoins());
                  } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
                        Logger.getLogger(GamePanelBreakout.class.getName()).log(Level.SEVERE, null, ex);
                  }

                  // Actualizamos los labels donde se muestran los cr�ditos.
                  Menu.lblCreditos.setText("Creditos: " + Main.userLogged.getCoins());
                  Store.lblCreditos.setText("Creditos: " + Main.userLogged.getCoins());

                  Main.vtnMenu.setVisible(true);
                  Main.gamePacman.stop();

            }

// Reiniciar el juego
            if (e.getKeyCode()
               == KeyEvent.VK_ENTER) {
                  if (!play) {
                        play = true;
                        ballPosX = 120;
                        ballPosY = 350;
                        ballXDir = -1;
                        ballYDir = -2;
                        playerX = 310;
                        score = 0;
                        totalBricks = 21;
                        map = new MapGenerator(3, 7);

                        repaint();
                  }
            }

      }

      public void moveRight() {
            play = true; // Iniciar el juego si no está en progreso
            playerX += 20;// Mover la barra a la derecha
      }

      public void moveLeft() {
            play = true; // Iniciar el juego si no está en progreso
            playerX -= 20; // Mover la barra a la izquierda
      }

      @Override
      public void keyReleased(KeyEvent e) {
      }

      @Override
      public void actionPerformed(ActionEvent e) {
            timer.start(); // Reiniciar el Timer

            if (play) {
                  // Detectar colisiones entre la pelota y la barra
                  if (new Rectangle(ballPosX, ballPosY, 20, 20).intersects(new Rectangle(playerX, 550, 100, 8))) {
                        // Calcula el punto de colisión en la barra
                        int collisionPoint = ballPosX - playerX;
                        // Cambia la dirección de la pelota basada en la sección de la barra
                        if (collisionPoint < 30) {
                              ballXDir = -2; // Rebota a la izquierda
                        } else if (collisionPoint > 70) {
                              ballXDir = 2; // Rebota a la derecha
                        } else {
                              ballXDir = 0; // Rebota hacia arriba
                        }
                        ballYDir = -ballYDir;
                  }
                  // Detectar colisiones entre la pelota y los ladrillos
                  A:
                  for (int i = 0; i < map.map.length; i++) {
                        for (int j = 0; j < map.map[0].length; j++) {
                              if (map.map[i][j] > 0) {
                                    int brickX = j * map.brickWidth + 80;
                                    int brickY = i * map.brickHeight + 50;
                                    int brickWidth = map.brickWidth;
                                    int brickHeight = map.brickHeight;

                                    Rectangle rect = new Rectangle(brickX, brickY, brickWidth, brickHeight);
                                    Rectangle ballRect = new Rectangle(ballPosX, ballPosY, 20, 20);
                                    Rectangle brickRect = rect;

                                    if (ballRect.intersects(brickRect)) {
                                          map.setBrickValue(0, i, j);// Romper el ladrillo
                                          totalBricks--;// Reducir el número de ladrillos restantes
                                          score += 5;// Aumentar el puntaje

                                          // Cambiar la dirección de la pelota basada en la colisión
                                          if (ballPosX + 19 <= brickRect.x || ballPosX + 1 >= brickRect.x + brickRect.width) {
                                                ballXDir = -ballXDir;
                                          } else {
                                                ballYDir = -ballYDir;
                                          }

                                          break A;// Salir del bucle anidado
                                    }
                              }
                        }
                  }
                  // Mover la pelota
                  ballPosX += ballXDir;
                  ballPosY += ballYDir;

                  // Detectar colisiones con los bordes
                  if (ballPosX < 0) {
                        ballXDir = -ballXDir;
                  }
                  if (ballPosY < 0) {
                        ballYDir = -ballYDir;
                  }
                  if (ballPosX > 670) {
                        ballXDir = -ballXDir;
                  }

                  repaint();// Redibujar el panel
            }
      }


      // Variables declaration - do not modify//GEN-BEGIN:variables
      // End of variables declaration//GEN-END:variables
}
