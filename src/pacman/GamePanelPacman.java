package pacman;

import sound.SoundPlayer;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.Timer;
import main.Main;

public final class GamePanelPacman extends javax.swing.JPanel implements KeyListener, ActionListener {

      public static Map map;
      protected static Pacman pacman;
      public static Timer timer;
      protected static ArrayList<Ghost> ghosts;
      protected JLabel lblEat;
      protected JLabel lblBlockStats;
      public static int points;
      public static int score;
      public static boolean gameOver = false;
      public static boolean gameStarted = false;
      public static boolean changingMap = false;
      public static int level;

      public GamePanelPacman() {
            map = new Map(); // Inicializamos mapa

            pacman = new Pacman(480, 600, 40, 40, map); //Inicializamos Pacman
            pacman.setColor(Color.YELLOW);

            this.addKeyListener(this);
            this.setFocusable(true);

            lblBlockStats = new JLabel("Label de estadisticas de bloque");
            Dimension size2 = new Dimension(400, 60);
            lblBlockStats.setBounds(0, 0, size2.width, size2.height);
            lblBlockStats.setForeground(Color.LIGHT_GRAY);
            this.setLayout(null);
            this.add(lblBlockStats);
            lblBlockStats.setVisible(false);

            this.inicializarLabels();

            GamePanelPacman.timer = new Timer(17, (ActionListener) this);

            iniciarPartida();
            GamePanelPacman.timer.stop();

      }

      public int getScore() {
            return score;
      }

      public void setScore(int score) {
            GamePanelPacman.score = score;
      }

      public static void detenerTimer() {
            GamePanelPacman.timer.stop();
      }

      public static void iniciarTimer() {
            GamePanelPacman.timer.start();
      }

      @SuppressWarnings("empty-statement")
      public static void reiniciarMapa() {
            Color color;

            GamePanelPacman.level++;

            switch (GamePanelPacman.level) {
                  case 1 ->
                        color = Color.BLUE;
                  case 2 ->
                        color = Color.RED;
                  case 3 ->
                        color = Color.YELLOW;
                  default ->
                        color = Color.GREEN;
            };
            int lives = pacman.getLives();

            map.initMapObjects(Map.map, color);

            pacman = new Pacman(480, 600, 40, 40, map);
            pacman.setNombre("Pacman");
            pacman.setColor(Color.YELLOW);
            pacman.spawn();
            pacman.setLives(lives);

            ghosts = new ArrayList();
            Ghost rojo = new Ghost(Color.RED, "Rojo", pacman, map);
            Ghost celeste = new Ghost(Color.CYAN, "Celeste", pacman, map);
            Ghost naranja = new Ghost(Color.ORANGE, "Naranja", pacman, map);
            Ghost rosa = new Ghost(Color.PINK, "Rosa", pacman, map);
            ghosts.add(rojo);
            ghosts.add(celeste);
            ghosts.add(naranja);
            ghosts.add(rosa);

            Dimension size3 = new Dimension(90, 45);
            for (Ghost ghost : ghosts) {
                  ghost.lblGhostStats = new JLabel("Label de estadisticas de Ghost", JLabel.CENTER);
                  ghost.lblGhostStats.setBounds(0, 0, size3.width, size3.height);
                  ghost.lblGhostStats.setForeground(Color.LIGHT_GRAY);
                  ghost.lblGhostStats.setVisible(false);
            }

            Ghost.vulnerableTime = 0;

            GamePanelPacman.points = 100;

            if (gameStarted) {
                  iniciarTimer();
            }

      }

      public static void iniciarPartida() {
            gameOver = false;

            map.initMapObjects(Map.map, Color.BLUE); // Creamos los objetos del mapa
            pacman = new Pacman(480, 600, 40, 40, map);
            pacman.setColor(Color.YELLOW);
            pacman.setNombre("Pacman");
            pacman.setLives(3);
            pacman.spawn();

            ghosts = new ArrayList();
            Ghost rojo = new Ghost(Color.RED, "Rojo", pacman, map);
            Ghost celeste = new Ghost(Color.CYAN, "Celeste", pacman, map);
            Ghost naranja = new Ghost(Color.ORANGE, "Naranja", pacman, map);
            Ghost rosa = new Ghost(Color.PINK, "Rosa", pacman, map);

            ghosts.add(rojo);
            ghosts.add(celeste);
            ghosts.add(naranja);
            ghosts.add(rosa);

            Dimension size3 = new Dimension(90, 45);
            for (Ghost ghost : ghosts) {
                  ghost.lblGhostStats = new JLabel("Label de estadisticas de Ghost", JLabel.CENTER);
                  ghost.lblGhostStats.setBounds(0, 0, size3.width, size3.height);
                  ghost.lblGhostStats.setForeground(Color.LIGHT_GRAY);
                  ghost.lblGhostStats.setVisible(false);
            }

            Ghost.vulnerableTime = 0;
            GamePanelPacman.points = 100;
            GamePanelPacman.score = 0;
            GamePanelPacman.level = 1;

            GamePanelPacman.points = 100;

            if (gameStarted) {
                  iniciarTimer();
            }

      }

      public void inicializarLabels() {
            lblEat = new JLabel("Label de puntaje");
            Dimension size = new Dimension(40, 40);
            lblEat.setBounds(0, 0, size.width, size.height);
            lblEat.setForeground(Color.GREEN);
            this.setLayout(null);
            this.add(lblEat);
            lblEat.setVisible(false);
      }

      @Override
      public void paintComponent(Graphics g) {
            draw(g);
      }

      public void draw(Graphics g) {

            map.draw(g);

            pacman.draw(g);

            for (int i = 0; i < ghosts.size(); i++) {
                  ghosts.get(i).draw(g);
            }

            if (!gameStarted) {
                  g.setColor(Color.YELLOW);
                  g.setFont(new Font("serif", Font.BOLD, 75));
                  g.drawString("Get ready", 250, 350);

                  if (!changingMap) {
                        g.setFont(new Font("serif", Font.BOLD, 15));
                        g.drawString("Presione ENTER para empezar", 300, 450);
                        g.drawString("o ESCAPE para ir al menu", 320, 470);
                  } else {
                        g.setFont(new Font("serif", Font.BOLD, 15));
                        g.drawString("Empezando nuevo mapa", 300, 450);
                  }

            }

            if (gameOver) {
                  g.setColor(Color.RED);
                  g.setFont(new Font("serif", Font.BOLD, 100));
                  g.drawString("GAME OVER", 80, 260);

                  g.setColor(new Color(229, 190, 1));

                  g.setFont(new Font("serif", Font.BOLD, 30));
                  g.drawString("Score: " + score, 340, 320);

                  g.setFont(new Font("serif", Font.BOLD, 30));
                  g.drawString("Creditos conseguidos: " + (score / 1000), 270, 380);

                  g.setFont(new Font("serif", Font.BOLD, 15));
                  g.drawString("Presione ENTER para jugar de nuevo", 270, 450);
                  g.drawString("o ESCAPE para ir al menu", 300, 470);
            }

      }

      @Override
      public void actionPerformed(ActionEvent e) {

            pacman.move(pacman, map);

            for (int i = 0; i < ghosts.size(); i++) {

                  if (pacman.getBounds().intersects(ghosts.get(i).getBounds())) {
                        if (pacman.isSpawned()) {
                              if (ghosts.get(i).getState() != Ghost.GhostState.SCARED) { // Cuando el Pacman intenta comer a un Ghost y este no se encuentra Vulnerable.
                                    if (ghosts.get(i).isSpawned()) {
                                          ActionListener taskSpawn = (ActionEvent e1) -> {
                                                timer.start();
                                                pacman.spawn();
                                                Ghost.spawnAll();
                                          };

                                          // Cuando el Pacman queda sin vidas
                                          if (pacman.getLives() == 1) {
                                                pacman.loseLife();

                                                // Actualizamos los tonos de los personajes a Blanco y Gris
                                                pacman.setColor(new Color(210, 210, 210));

                                                for (Ghost ghost : ghosts) {
                                                      ghost.setColor(new Color(60, 60, 60));
                                                }

                                                // Actualizamos el tono del mapa a Gris
                                                for (int fila = 0; fila < map.filas; fila++) {
                                                      for (int columna = 0; columna < map.columnas; columna++) {
                                                            if (!map.matrizObjetos.isNull(fila, columna) && map.matrizObjetos.isBlock(fila, columna)) {
                                                                  Block bloque = (Block) map.matrizObjetos.obtenerObjeto(fila, columna);

                                                                  Color bloqueColor = new Color(40, 40, 40);
                                                                  bloque.setColor(bloqueColor);
                                                            }
                                                      }
                                                }

                                                // Colocamos el sonido de Game Over
                                                SoundPlayer sound = new SoundPlayer();
                                                try {
                                                      sound.playSound("src\\pacman\\sfx\\gameover.mp3");
                                                } catch (Exception ex) {
                                                      System.out.println("Archivo de sonido no encontrado.");
                                                }
                                                // Si el score conseguido es mayor al máximo score almacenado
                                                if (score > Main.userLogged.getScorePacman()) {
                                                      Main.userLogged.setScorePacman(score);
                                                }

                                                // Seteamos en true el estado del gameOver.
                                                gameOver = true;

                                          } else { // Cuando el Pacman aún tiene vidas
                                                pacman.loseLife();
                                                try {
                                                      SoundPlayer sound = new SoundPlayer();
                                                      sound.playSound("src\\pacman\\sfx\\die.mp3");
                                                } catch (Exception ex) {
                                                      System.out.println("Archivo de sonido no encontrado.");
                                                }
                                                Ghost.vulnerableTime = 0;

                                                Timer respawnTimer = new Timer(3000, taskSpawn);
                                                respawnTimer.setRepeats(false);
                                                respawnTimer.start();

                                          }

                                          timer.stop();
                                          break;
                                    }

                              } else {  // Cuando el Pacman se come a un Ghost.
                                    ActionListener taskUnfreeze = (ActionEvent e1) -> {
                                          timer.start();
                                          lblEat.setVisible(false);
                                    };
                                    if (ghosts.get(i).isSpawned()) { // Si el Ghost se encuentra spawneado.
                                          ghosts.get(i).die();
                                          System.out.println("Te has comida a " + ghosts.get(i).getNombre());
                                          try {
                                                SoundPlayer sound = new SoundPlayer();
                                                sound.playSound("src\\pacman\\sfx\\eat.mp3");
                                          } catch (Exception ex) {
                                                System.out.println("Archivo de sonido no encontrado.");
                                          }

                                          points *= 2;
                                          GamePanelPacman.score += points;

                                          lblEat.setText(Integer.toString(points));
                                          lblEat.setLocation(pacman.parts[0].x, pacman.parts[0].y + 40);
                                          lblEat.setVisible(true);

                                          // Timer para ocultar después de 0.3 segundos el contador de puntaje al comer a un Ghost.
                                          Timer unfreezeTimer = new Timer(300, taskUnfreeze);
                                          unfreezeTimer.setRepeats(false);
                                          unfreezeTimer.start();

                                          timer.stop();

                                    }
                              }
                        }
                  }

                  ghosts.get(i).move(pacman, map); // Movimiento siguiendo al Pacman o escapando de él en caso de estar vulnerable.          
            }

            repaint();

      }
      // </editor-fold>

      @SuppressWarnings("unchecked")
      // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
      private void initComponents() {

            setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
      }// </editor-fold>//GEN-END:initComponents

      @Override
      public void keyTyped(KeyEvent e) {
      }

      @Override
      public void keyPressed(KeyEvent e) {
            pacman.KeyPressed(e);
      }

      @Override
      public void keyReleased(KeyEvent e) {
      }

      // Variables declaration - do not modify//GEN-BEGIN:variables
      // End of variables declaration//GEN-END:variables
}
