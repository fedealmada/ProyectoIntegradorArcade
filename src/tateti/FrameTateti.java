package tateti;

import dao.UsuarioDAOImpl;
import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;
import main.Main;
import sound.SoundPlayer;

public class FrameTateti extends javax.swing.JFrame {

      UsuarioDAOImpl usuario = new UsuarioDAOImpl();
      //Atributos
      String siguientejuego = "O";
      String turno = "X";
      JLabel lbs[] = new JLabel[9];
      private boolean gameOver;

      int[][] matriz = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9},
            {1, 4, 7},
            {2, 5, 8},
            {3, 6, 9},
            {1, 5, 9},
            {3, 5, 7}
      };

      private int scoreX = 0; // Atributo para la puntuación
      private int scoreO = 0; // Atributo para la puntuación
      JLabel lblScore; // Etiqueta para mostrar la puntuación

      public FrameTateti() {
            initComponents();
            //Inicializar lblScore
            lblScore = new JLabel("Puntuación: 0");
            lblScore.setFont(new java.awt.Font("Dialog", 0, 14));
            lblScore.setOpaque(true);

            // Añadir lblScore al layout
            JPanel jPanel1 = new JPanel();
            jPanel1.add(lblScore);
//        this.add(jPanel1, java.awt.BorderLayout.SOUTH);

            this.setResizable(false);
            this.setLocationRelativeTo(null); // Para posicionar una ventana en el centro de la pantalla 

            lbs[0] = btn00;
            lbs[1] = btn01;
            lbs[2] = btn02;
            lbs[3] = btn10;
            lbs[4] = btn11;
            lbs[5] = btn12;
            lbs[6] = btn20;
            lbs[7] = btn21;
            lbs[8] = btn22;

      }

      @SuppressWarnings("unchecked")
      // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
      private void initComponents() {

            jPanel1 = new javax.swing.JPanel();
            jPanel2 = new javax.swing.JPanel();
            btn00 = new javax.swing.JLabel();
            btn02 = new javax.swing.JLabel();
            btn22 = new javax.swing.JLabel();
            btn12 = new javax.swing.JLabel();
            btn01 = new javax.swing.JLabel();
            btn11 = new javax.swing.JLabel();
            btn10 = new javax.swing.JLabel();
            btn20 = new javax.swing.JLabel();
            btn21 = new javax.swing.JLabel();
            btnReiniciar = new javax.swing.JButton();
            lblInfoTurno = new javax.swing.JLabel();
            lblContadorJ2 = new javax.swing.JLabel();
            lblGuion = new javax.swing.JLabel();
            lblContadorJ1 = new javax.swing.JLabel();
            lblNameJ2 = new javax.swing.JLabel();
            lblNameJ1 = new javax.swing.JLabel();
            lblFotoJ1 = new javax.swing.JLabel();
            lblFotoJ3 = new javax.swing.JLabel();
            btnExit = new javax.swing.JButton();

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            setTitle("Ta - Te - Ti ");
            setUndecorated(true);
            getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            jPanel1.setBackground(new java.awt.Color(0, 0, 204));
            jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            jPanel2.setBackground(new java.awt.Color(0, 0, 0));
            jPanel2.setName(""); // NOI18N
            jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            btn00.setBackground(new java.awt.Color(102, 153, 255));
            btn00.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 48)); // NOI18N
            btn00.setForeground(new java.awt.Color(0, 0, 0));
            btn00.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            btn00.setOpaque(true);
            btn00.addMouseListener(new java.awt.event.MouseAdapter() {
                  public void mousePressed(java.awt.event.MouseEvent evt) {
                        btn00MousePressed(evt);
                  }
            });
            jPanel2.add(btn00, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 70));

            btn02.setBackground(new java.awt.Color(102, 153, 255));
            btn02.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 48)); // NOI18N
            btn02.setForeground(new java.awt.Color(0, 0, 0));
            btn02.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            btn02.setOpaque(true);
            btn02.addMouseListener(new java.awt.event.MouseAdapter() {
                  public void mousePressed(java.awt.event.MouseEvent evt) {
                        btn02MousePressed(evt);
                  }
            });
            jPanel2.add(btn02, new org.netbeans.lib.awtextra.AbsoluteConstraints(176, 0, 70, 70));

            btn22.setBackground(new java.awt.Color(102, 153, 255));
            btn22.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 48)); // NOI18N
            btn22.setForeground(new java.awt.Color(0, 0, 0));
            btn22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            btn22.setOpaque(true);
            btn22.addMouseListener(new java.awt.event.MouseAdapter() {
                  public void mousePressed(java.awt.event.MouseEvent evt) {
                        btn22MousePressed(evt);
                  }
            });
            jPanel2.add(btn22, new org.netbeans.lib.awtextra.AbsoluteConstraints(176, 176, 70, 70));

            btn12.setBackground(new java.awt.Color(102, 153, 255));
            btn12.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 48)); // NOI18N
            btn12.setForeground(new java.awt.Color(0, 0, 0));
            btn12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            btn12.setOpaque(true);
            btn12.addMouseListener(new java.awt.event.MouseAdapter() {
                  public void mousePressed(java.awt.event.MouseEvent evt) {
                        btn12MousePressed(evt);
                  }
            });
            jPanel2.add(btn12, new org.netbeans.lib.awtextra.AbsoluteConstraints(176, 88, 70, 70));

            btn01.setBackground(new java.awt.Color(102, 153, 255));
            btn01.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 48)); // NOI18N
            btn01.setForeground(new java.awt.Color(0, 0, 0));
            btn01.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            btn01.setOpaque(true);
            btn01.addMouseListener(new java.awt.event.MouseAdapter() {
                  public void mousePressed(java.awt.event.MouseEvent evt) {
                        btn01MousePressed(evt);
                  }
            });
            jPanel2.add(btn01, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 0, 70, 70));

            btn11.setBackground(new java.awt.Color(102, 153, 255));
            btn11.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 48)); // NOI18N
            btn11.setForeground(new java.awt.Color(0, 0, 0));
            btn11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            btn11.setOpaque(true);
            btn11.addMouseListener(new java.awt.event.MouseAdapter() {
                  public void mousePressed(java.awt.event.MouseEvent evt) {
                        btn11MousePressed(evt);
                  }
            });
            jPanel2.add(btn11, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 88, 70, 70));

            btn10.setBackground(new java.awt.Color(102, 153, 255));
            btn10.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 48)); // NOI18N
            btn10.setForeground(new java.awt.Color(0, 0, 0));
            btn10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            btn10.setOpaque(true);
            btn10.addMouseListener(new java.awt.event.MouseAdapter() {
                  public void mousePressed(java.awt.event.MouseEvent evt) {
                        btn10MousePressed(evt);
                  }
            });
            jPanel2.add(btn10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 88, 70, 70));

            btn20.setBackground(new java.awt.Color(102, 153, 255));
            btn20.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 48)); // NOI18N
            btn20.setForeground(new java.awt.Color(0, 0, 0));
            btn20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            btn20.setOpaque(true);
            btn20.addMouseListener(new java.awt.event.MouseAdapter() {
                  public void mousePressed(java.awt.event.MouseEvent evt) {
                        btn20MousePressed(evt);
                  }
            });
            jPanel2.add(btn20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 176, 70, 70));

            btn21.setBackground(new java.awt.Color(102, 153, 255));
            btn21.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 48)); // NOI18N
            btn21.setForeground(new java.awt.Color(0, 0, 0));
            btn21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            btn21.setOpaque(true);
            btn21.addMouseListener(new java.awt.event.MouseAdapter() {
                  public void mousePressed(java.awt.event.MouseEvent evt) {
                        btn21MousePressed(evt);
                  }
            });
            jPanel2.add(btn21, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 176, 70, 70));

            jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, -1, -1));

            btnReiniciar.setText("Reiniciar");
            btnReiniciar.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnReiniciarActionPerformed(evt);
                  }
            });
            jPanel1.add(btnReiniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 84, -1));

            lblInfoTurno.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
            lblInfoTurno.setForeground(new java.awt.Color(255, 255, 204));
            lblInfoTurno.setText("Turno de Robert");
            jPanel1.add(lblInfoTurno, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 400, 190, 32));

            lblContadorJ2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
            lblContadorJ2.setForeground(new java.awt.Color(204, 0, 0));
            lblContadorJ2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lblContadorJ2.setText("0");
            jPanel1.add(lblContadorJ2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, 60, 40));

            lblGuion.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
            lblGuion.setForeground(new java.awt.Color(102, 153, 255));
            lblGuion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lblGuion.setText("VS");
            jPanel1.add(lblGuion, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 60, 40));

            lblContadorJ1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
            lblContadorJ1.setForeground(new java.awt.Color(0, 153, 153));
            lblContadorJ1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lblContadorJ1.setText("0");
            jPanel1.add(lblContadorJ1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 60, 40));

            lblNameJ2.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
            lblNameJ2.setForeground(new java.awt.Color(255, 255, 204));
            lblNameJ2.setText("Merlina");
            jPanel1.add(lblNameJ2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, 70, -1));

            lblNameJ1.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
            lblNameJ1.setForeground(new java.awt.Color(255, 255, 204));
            lblNameJ1.setText("Robert");
            jPanel1.add(lblNameJ1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 50, -1));

            lblFotoJ1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tateti/profile/image (2).png"))); // NOI18N
            lblFotoJ1.setText("jLabel1");
            lblFotoJ1.setAutoscrolls(true);
            lblFotoJ1.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
            jPanel1.add(lblFotoJ1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 100, 100));
            lblFotoJ1.getAccessibleContext().setAccessibleDescription("");

            lblFotoJ3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tateti/profile/image.png"))); // NOI18N
            jPanel1.add(lblFotoJ3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 100, 100));

            btnExit.setText("X");
            btnExit.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnExitActionPerformed(evt);
                  }
            });
            jPanel1.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 400, 60, -1));

            getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 440));

            pack();
      }// </editor-fold>//GEN-END:initComponents

    private void btn00MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn00MousePressed
          presionar(1);
    }//GEN-LAST:event_btn00MousePressed

    private void btn02MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn02MousePressed
          presionar(3);
    }//GEN-LAST:event_btn02MousePressed

    private void btn22MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn22MousePressed
          presionar(9);
    }//GEN-LAST:event_btn22MousePressed

    private void btn12MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn12MousePressed
          presionar(6);
    }//GEN-LAST:event_btn12MousePressed

    private void btn01MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn01MousePressed
          presionar(2);
    }//GEN-LAST:event_btn01MousePressed

    private void btn11MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn11MousePressed
          presionar(5);
    }//GEN-LAST:event_btn11MousePressed

    private void btn10MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn10MousePressed
          presionar(4);
    }//GEN-LAST:event_btn10MousePressed

    private void btn20MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn20MousePressed
          presionar(7);
    }//GEN-LAST:event_btn20MousePressed

    private void btn21MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn21MousePressed
          presionar(8);
    }//GEN-LAST:event_btn21MousePressed

    private void btnReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReiniciarActionPerformed
          reiniciarPartida();
    }//GEN-LAST:event_btnReiniciarActionPerformed

      private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
            Main.gameTateti.stop();
            Main.vtnMenu.setVisible(true);
      }//GEN-LAST:event_btnExitActionPerformed

      public void presionar(int casilla) {
            if (!gameOver) {
                  if (lbs[casilla - 1].getText().equals("")) {
                        lbs[casilla - 1].setText(turno);
                        if (turno.equals("O")) {
                              lbs[casilla - 1].setForeground(Color.RED);
                        } else {
                              lbs[casilla - 1].setForeground(Color.BLUE);
                        }
                        cambiarTurno();
                        chequearGanador();
                  }
            }
      }

      public void cambiarTurno() {
            if (turno.equals("X")) {
                  turno = "O";
                  lblInfoTurno.setText("Turno de " + lblNameJ2.getText());

            } else {
                  turno = "X";
                  lblInfoTurno.setText("Turno de " + lblNameJ1.getText());
            }

      }

      // Método para actualizar la puntuación
      public void actualizarPuntuacion() {
            lblContadorJ1.setText(Integer.toString(scoreX));
            lblContadorJ2.setText(Integer.toString(scoreO));
      }

      public void reiniciarPuntuacion() {
            scoreX = 0;
            scoreO = 0;
            actualizarPuntuacion();

      }

      public void reiniciarPartida() {
            gameOver = false;

            for (int i = 0; i < lbs.length; i++) {
                  lbs[i].setText("");
                  lbs[i].setBackground(new Color(102, 153, 255));

            }

            turno = siguientejuego;
            if (siguientejuego.equals("O")) {
                  lblInfoTurno.setText("turno de " + lblNameJ2.getText());
                  siguientejuego = "X";
            } else {
                  lblInfoTurno.setText("turno de " + lblNameJ1.getText());
                  siguientejuego = "O";
            }

      }

      public void chequearGanador() {
            if (!gameOver) {
                  for (int i = 0; i < matriz.length; i++) {
                        if (lbs[matriz[i][0] - 1].getText().equals("X")
                           && lbs[matriz[i][1] - 1].getText().equals("X")
                           && lbs[matriz[i][2] - 1].getText().equals("X")) {

                              lbs[matriz[i][0] - 1].setBackground(new Color(255, 255, 204));
                              lbs[matriz[i][1] - 1].setBackground(new Color(255, 255, 204));
                              lbs[matriz[i][2] - 1].setBackground(new Color(255, 255, 204));

                              lblInfoTurno.setText("Ha ganado Robert");

                              sound.SoundPlayer sound = new SoundPlayer();
                              try {
                                    sound.playSound("src\\tateti\\sfx\\yes2.mp3");
                              } catch (Exception ex) {
                                    System.out.println("Archivo de sonido no encontrado.");
                              }
                              Main.userLogged.setScoreTateti(Main.userLogged.getScoreTateti() + 1);
                              try {
                                    usuario.actualizarCampo("scoreTateti", Main.userLogged.getScoreTateti());
                              } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
                                    Logger.getLogger(FrameTateti.class.getName()).log(Level.SEVERE, null, ex);
                              }

                              // Incrementa score
                              scoreX++;
                              actualizarPuntuacion();

                              this.gameOver = true;

                        }

                        if (lbs[matriz[i][0] - 1].getText().equals("O")
                           && lbs[matriz[i][1] - 1].getText().equals("O")
                           && lbs[matriz[i][2] - 1].getText().equals("O")) {

                              lbs[matriz[i][0] - 1].setBackground(new Color(255, 255, 204));
                              lbs[matriz[i][1] - 1].setBackground(new Color(255, 255, 204));
                              lbs[matriz[i][2] - 1].setBackground(new Color(255, 255, 204));

                              lblInfoTurno.setText("Ha ganado Merlina");
                              try {
                                    sound.SoundPlayer sound = new SoundPlayer();
                                    sound.playSound("src\\tateti\\sfx\\yes.mp3");
                              } catch (Exception ex) {
                                    System.out.println("Archivo de sonido no encontrado.");
                              }
                              // Actualizamos creditos
                              Main.userLogged.setCoins(Main.userLogged.getCoins() + 1);
                              try {
                                    usuario.actualizarCampo("coins", Main.userLogged.getCoins());
                              } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
                                    Logger.getLogger(FrameTateti.class.getName()).log(Level.SEVERE, null, ex);
                              }

                              // Actualizamos score de tateti
                              Main.userLogged.setScoreTateti(Main.userLogged.getScoreTateti() + 1);
                              try {
                                    usuario.actualizarCampo("scoreTateti", Main.userLogged.getScoreTateti());
                              } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
                                    Logger.getLogger(FrameTateti.class.getName()).log(Level.SEVERE, null, ex);
                              }
                              scoreO++;
                              actualizarPuntuacion();

                              this.gameOver = true;

                        }
                  }
            }
      }

      public static void main(String args[]) {
            /* Set the Nimbus look and feel */
            //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
            /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
             */
            try {
                  for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                        if ("Nimbus".equals(info.getName())) {
                              javax.swing.UIManager.setLookAndFeel(info.getClassName());
                              break;
                        }
                  }
            } catch (ClassNotFoundException ex) {
                  java.util.logging.Logger.getLogger(FrameTateti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                  java.util.logging.Logger.getLogger(FrameTateti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                  java.util.logging.Logger.getLogger(FrameTateti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                  java.util.logging.Logger.getLogger(FrameTateti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            //</editor-fold>
            //</editor-fold>
            //</editor-fold>
            //</editor-fold>

            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                  public void run() {
                        new FrameTateti().setVisible(true);
                  }
            });
      }

      // Variables declaration - do not modify//GEN-BEGIN:variables
      private javax.swing.JLabel btn00;
      private javax.swing.JLabel btn01;
      private javax.swing.JLabel btn02;
      private javax.swing.JLabel btn10;
      private javax.swing.JLabel btn11;
      private javax.swing.JLabel btn12;
      private javax.swing.JLabel btn20;
      private javax.swing.JLabel btn21;
      private javax.swing.JLabel btn22;
      private javax.swing.JButton btnExit;
      private javax.swing.JButton btnReiniciar;
      private javax.swing.JPanel jPanel1;
      private javax.swing.JPanel jPanel2;
      private javax.swing.JLabel lblContadorJ1;
      private javax.swing.JLabel lblContadorJ2;
      private javax.swing.JLabel lblFotoJ1;
      private javax.swing.JLabel lblFotoJ3;
      private javax.swing.JLabel lblGuion;
      private javax.swing.JLabel lblInfoTurno;
      private javax.swing.JLabel lblNameJ1;
      private javax.swing.JLabel lblNameJ2;
      // End of variables declaration//GEN-END:variables
}
