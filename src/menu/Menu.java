package menu;

import breakout.GameBreakout;
import breakout.GamePanelBreakout;
import dao.UsuarioDAOImpl;
import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import main.Main;
import pacman.GamePacman;
import pacman.GamePanelPacman;
import tetris.GameTetris;

public final class Menu extends javax.swing.JFrame {

      private final UsuarioDAOImpl usuario = new UsuarioDAOImpl();

      public Menu() {
            initComponents();
            this.setResizable(false);
      }

      @SuppressWarnings("unchecked")
      // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
      private void initComponents() {

            background = new background.Background(50, 50, 1002, 602, 902, "/background/background.png");
            btnClose = new javax.swing.JButton();
            jPanel1 = new javax.swing.JPanel();
            jLabel3 = new javax.swing.JLabel();
            lblTituloBreakout = new javax.swing.JLabel();
            lblTateti = new javax.swing.JLabel();
            lblPacman = new javax.swing.JLabel();
            lblTetris = new javax.swing.JLabel();
            lblTienda = new javax.swing.JLabel();
            lblLeaderboard = new javax.swing.JLabel();
            lblBreakout = new javax.swing.JLabel();
            btnCerrarSesion = new javax.swing.JButton();
            lblTituloPacman = new javax.swing.JLabel();
            lblTituloTetris = new javax.swing.JLabel();
            lblTituloTateti = new javax.swing.JLabel();
            lblTituloTienda = new javax.swing.JLabel();
            lblTituloLeaderboard = new javax.swing.JLabel();
            lblNombre = new javax.swing.JLabel();
            lblCreditos = new javax.swing.JLabel();

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            setUndecorated(true);

            btnClose.setBackground(new java.awt.Color(	255, 85, 85, 0));
            btnClose.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
            btnClose.setForeground(new java.awt.Color(255, 255, 255));
            btnClose.setText("X");
            btnClose.setBorder(null);
            btnClose.setFocusable(false);
            btnClose.addMouseListener(new java.awt.event.MouseAdapter() {
                  public void mouseEntered(java.awt.event.MouseEvent evt) {
                        btnCloseMouseEntered(evt);
                  }
                  public void mouseExited(java.awt.event.MouseEvent evt) {
                        btnCloseMouseExited(evt);
                  }
            });
            btnClose.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnCloseActionPerformed(evt);
                  }
            });
            background.add(btnClose);
            btnClose.setBounds(970, 0, 30, 23);

            jPanel1.setBackground(new java.awt.Color(16, 16, 21, 95));
            jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            jLabel3.setBackground(new java.awt.Color(0, 0, 0));
            jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
            jLabel3.setForeground(new java.awt.Color(204, 51, 255));
            jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel3.setText("MENU PRINCIPAL");
            jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 300, 80));

            lblTituloBreakout.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
            lblTituloBreakout.setForeground(new java.awt.Color(204, 204, 255));
            lblTituloBreakout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lblTituloBreakout.setText("Breakout");
            jPanel1.add(lblTituloBreakout, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, 140, 40));

            lblTateti.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu/images/tateti.png"))); // NOI18N
            lblTateti.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            lblTateti.addMouseListener(new java.awt.event.MouseAdapter() {
                  public void mouseClicked(java.awt.event.MouseEvent evt) {
                        lblTatetiMouseClicked(evt);
                  }
                  public void mouseEntered(java.awt.event.MouseEvent evt) {
                        lblTatetiMouseEntered(evt);
                  }
                  public void mouseExited(java.awt.event.MouseEvent evt) {
                        lblTatetiMouseExited(evt);
                  }
            });
            jPanel1.add(lblTateti, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 140, 210, 150));

            lblPacman.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu/images/pacman.png"))); // NOI18N
            lblPacman.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            lblPacman.addMouseListener(new java.awt.event.MouseAdapter() {
                  public void mouseClicked(java.awt.event.MouseEvent evt) {
                        lblPacmanMouseClicked(evt);
                  }
                  public void mouseEntered(java.awt.event.MouseEvent evt) {
                        lblPacmanMouseEntered(evt);
                  }
                  public void mouseExited(java.awt.event.MouseEvent evt) {
                        lblPacmanMouseExited(evt);
                  }
            });
            jPanel1.add(lblPacman, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 210, 150));

            lblTetris.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu/images/tetris.png"))); // NOI18N
            lblTetris.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            lblTetris.addMouseListener(new java.awt.event.MouseAdapter() {
                  public void mouseClicked(java.awt.event.MouseEvent evt) {
                        lblTetrisMouseClicked(evt);
                  }
                  public void mouseEntered(java.awt.event.MouseEvent evt) {
                        lblTetrisMouseEntered(evt);
                  }
                  public void mouseExited(java.awt.event.MouseEvent evt) {
                        lblTetrisMouseExited(evt);
                  }
            });
            jPanel1.add(lblTetris, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 140, 210, 150));

            lblTienda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu/images/store.png"))); // NOI18N
            lblTienda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            lblTienda.addMouseListener(new java.awt.event.MouseAdapter() {
                  public void mouseClicked(java.awt.event.MouseEvent evt) {
                        lblTiendaMouseClicked(evt);
                  }
                  public void mouseEntered(java.awt.event.MouseEvent evt) {
                        lblTiendaMouseEntered(evt);
                  }
                  public void mouseExited(java.awt.event.MouseEvent evt) {
                        lblTiendaMouseExited(evt);
                  }
            });
            jPanel1.add(lblTienda, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 350, 210, 150));

            lblLeaderboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu/images/leaderboard.png"))); // NOI18N
            lblLeaderboard.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            lblLeaderboard.addMouseListener(new java.awt.event.MouseAdapter() {
                  public void mouseClicked(java.awt.event.MouseEvent evt) {
                        lblLeaderboardMouseClicked(evt);
                  }
                  public void mouseEntered(java.awt.event.MouseEvent evt) {
                        lblLeaderboardMouseEntered(evt);
                  }
                  public void mouseExited(java.awt.event.MouseEvent evt) {
                        lblLeaderboardMouseExited(evt);
                  }
            });
            jPanel1.add(lblLeaderboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 350, 210, 150));

            lblBreakout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu/images/breakout.png"))); // NOI18N
            lblBreakout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            lblBreakout.addMouseListener(new java.awt.event.MouseAdapter() {
                  public void mouseClicked(java.awt.event.MouseEvent evt) {
                        lblBreakoutMouseClicked(evt);
                  }
                  public void mouseEntered(java.awt.event.MouseEvent evt) {
                        lblBreakoutMouseEntered(evt);
                  }
                  public void mouseExited(java.awt.event.MouseEvent evt) {
                        lblBreakoutMouseExited(evt);
                  }
            });
            jPanel1.add(lblBreakout, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, 210, 150));

            btnCerrarSesion.setBackground(new java.awt.Color(153, 102, 255));
            btnCerrarSesion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
            btnCerrarSesion.setForeground(new java.awt.Color(255, 255, 255));
            btnCerrarSesion.setText("Cerrar sesión");
            btnCerrarSesion.setBorder(null);
            btnCerrarSesion.setBorderPainted(false);
            btnCerrarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            btnCerrarSesion.setFocusable(false);
            btnCerrarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
                  public void mouseEntered(java.awt.event.MouseEvent evt) {
                        btnCerrarSesionMouseEntered(evt);
                  }
                  public void mouseExited(java.awt.event.MouseEvent evt) {
                        btnCerrarSesionMouseExited(evt);
                  }
            });
            btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnCerrarSesionActionPerformed(evt);
                  }
            });
            jPanel1.add(btnCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 540, 140, 50));

            lblTituloPacman.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
            lblTituloPacman.setForeground(new java.awt.Color(204, 204, 255));
            lblTituloPacman.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lblTituloPacman.setText("Pacman");
            jPanel1.add(lblTituloPacman, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 140, 40));

            lblTituloTetris.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
            lblTituloTetris.setForeground(new java.awt.Color(204, 204, 255));
            lblTituloTetris.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lblTituloTetris.setText("Tetris");
            jPanel1.add(lblTituloTetris, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 100, 140, 40));

            lblTituloTateti.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
            lblTituloTateti.setForeground(new java.awt.Color(204, 204, 255));
            lblTituloTateti.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lblTituloTateti.setText("Tateti");
            jPanel1.add(lblTituloTateti, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 100, 140, 40));

            lblTituloTienda.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
            lblTituloTienda.setForeground(new java.awt.Color(204, 204, 255));
            lblTituloTienda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lblTituloTienda.setText("Tienda");
            jPanel1.add(lblTituloTienda, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 310, 140, 40));

            lblTituloLeaderboard.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
            lblTituloLeaderboard.setForeground(new java.awt.Color(204, 204, 255));
            lblTituloLeaderboard.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lblTituloLeaderboard.setText("Leaderboard");
            jPanel1.add(lblTituloLeaderboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 310, 140, 40));

            lblNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
            lblNombre.setForeground(new java.awt.Color(153, 255, 153));
            lblNombre.setText("Cuenta: ");
            jPanel1.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 570, -1, -1));

            lblCreditos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
            lblCreditos.setForeground(new java.awt.Color(153, 255, 153));
            lblCreditos.setText("Creditos: 0");
            jPanel1.add(lblCreditos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 570, -1, -1));

            background.add(jPanel1);
            jPanel1.setBounds(50, 50, 902, 602);

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                  layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, 1002, javax.swing.GroupLayout.PREFERRED_SIZE)
            );
            layout.setVerticalGroup(
                  layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, 702, javax.swing.GroupLayout.PREFERRED_SIZE)
            );

            pack();
            setLocationRelativeTo(null);
      }// </editor-fold>//GEN-END:initComponents

      private void btnCloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseEntered
            btnClose.setBackground(new Color(255, 85, 85, 200));
            background.repaint();
      }//GEN-LAST:event_btnCloseMouseEntered

      private void btnCloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseExited
            btnClose.setBackground(new Color(255, 85, 85, 0));
            background.repaint();
      }//GEN-LAST:event_btnCloseMouseExited

      private void btnCerrarSesionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarSesionMouseEntered
            btnCerrarSesion.setBackground(new Color(153, 51, 255).brighter());
            background.repaint();
      }//GEN-LAST:event_btnCerrarSesionMouseEntered

      private void btnCerrarSesionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarSesionMouseExited
            btnCerrarSesion.setBackground(new Color(153, 51, 255));
            background.repaint();
      }//GEN-LAST:event_btnCerrarSesionMouseExited

      private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
            Main.vtnLogin.setVisible(true);
            this.setVisible(false);
            try {
                  usuario.cerrarSesion(Main.userLogged.getNombre());
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
                  Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
      }//GEN-LAST:event_btnCerrarSesionActionPerformed

      private void lblLeaderboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLeaderboardMouseClicked
            Main.vtnLeaderboard.loadTable("scorePacman");
            Main.vtnLeaderboard.setVisible(true);
            this.setVisible(false);
      }//GEN-LAST:event_lblLeaderboardMouseClicked

      private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
            int resp = JOptionPane.showConfirmDialog(null, "¿Realmente desea salir de la aplicación?",
               "Salir", JOptionPane.YES_NO_OPTION,
               JOptionPane.INFORMATION_MESSAGE, null);

            if (resp == 0) {
                  try {
                        usuario.cerrarSesion(Main.userLogged.getNombre());
                  } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
                        Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                  }
                  System.exit(0);
            }
      }//GEN-LAST:event_btnCloseActionPerformed

    private void lblBreakoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBreakoutMouseClicked
          this.setVisible(false);

          Main.gameAtari = new GameBreakout();
          Main.gameAtari.play();
    }//GEN-LAST:event_lblBreakoutMouseClicked

    private void lblTetrisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTetrisMouseClicked
          if(Main.menuTheme != null) Main.menuTheme.close();
          
          this.setVisible(false);

          Main.gameTetris = new GameTetris();
          Main.gameTetris.play();
    }//GEN-LAST:event_lblTetrisMouseClicked

      private void lblPacmanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPacmanMouseClicked
            this.setVisible(false);
            if(Main.menuTheme != null)
                  Main.menuTheme.close();
            Main.gamePacman.play();
            GamePanelPacman.detenerTimer();
            GamePanelPacman.gameOver = false;
            GamePanelPacman.gameStarted = false;

      }//GEN-LAST:event_lblPacmanMouseClicked

      private void lblTiendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTiendaMouseClicked
            Main.vtnStore.setVisible(true);
            this.setVisible(false);
            
            
      }//GEN-LAST:event_lblTiendaMouseClicked

      private void lblPacmanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPacmanMouseEntered
            ImageIcon icon = new ImageIcon(getClass().getResource("/menu/images/pacmanSelected.png"));
            lblPacman.setIcon(icon);
      }//GEN-LAST:event_lblPacmanMouseEntered

      private void lblPacmanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPacmanMouseExited
            ImageIcon icon = new ImageIcon(getClass().getResource("/menu/images/pacman.png"));
            lblPacman.setIcon(icon);
      }//GEN-LAST:event_lblPacmanMouseExited

      private void lblTetrisMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTetrisMouseEntered
            ImageIcon icon = new ImageIcon(getClass().getResource("/menu/images/tetrisSelected.png"));
            lblTetris.setIcon(icon);
      }//GEN-LAST:event_lblTetrisMouseEntered

      private void lblTetrisMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTetrisMouseExited
            ImageIcon icon = new ImageIcon(getClass().getResource("/menu/images/tetris.png"));
            lblTetris.setIcon(icon);
      }//GEN-LAST:event_lblTetrisMouseExited

      private void lblTatetiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTatetiMouseEntered
            ImageIcon icon = new ImageIcon(getClass().getResource("/menu/images/tatetiSelected.png"));
            lblTateti.setIcon(icon);
      }//GEN-LAST:event_lblTatetiMouseEntered

      private void lblTatetiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTatetiMouseExited
            ImageIcon icon = new ImageIcon(getClass().getResource("/menu/images/tateti.png"));
            lblTateti.setIcon(icon);
      }//GEN-LAST:event_lblTatetiMouseExited

      private void lblBreakoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBreakoutMouseEntered
            ImageIcon icon = new ImageIcon(getClass().getResource("/menu/images/breakoutSelected.png"));
            lblBreakout.setIcon(icon);
      }//GEN-LAST:event_lblBreakoutMouseEntered

      private void lblBreakoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBreakoutMouseExited
            ImageIcon icon = new ImageIcon(getClass().getResource("/menu/images/breakout.png"));
            lblBreakout.setIcon(icon);
      }//GEN-LAST:event_lblBreakoutMouseExited

      private void lblLeaderboardMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLeaderboardMouseEntered
            ImageIcon icon = new ImageIcon(getClass().getResource("/menu/images/leaderboardSelected.png"));
            lblLeaderboard.setIcon(icon);
      }//GEN-LAST:event_lblLeaderboardMouseEntered

      private void lblLeaderboardMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLeaderboardMouseExited
            ImageIcon icon = new ImageIcon(getClass().getResource("/menu/images/leaderboard.png"));
            lblLeaderboard.setIcon(icon);
      }//GEN-LAST:event_lblLeaderboardMouseExited

      private void lblTiendaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTiendaMouseEntered
            ImageIcon icon = new ImageIcon(getClass().getResource("/menu/images/storeSelected.png"));
            lblTienda.setIcon(icon);
      }//GEN-LAST:event_lblTiendaMouseEntered

      private void lblTiendaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTiendaMouseExited
            ImageIcon icon = new ImageIcon(getClass().getResource("/menu/images/store.png"));
            lblTienda.setIcon(icon);
      }//GEN-LAST:event_lblTiendaMouseExited

      private void lblTatetiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTatetiMouseClicked
            Main.gameTateti.play();
            this.setVisible(false);
            
      }//GEN-LAST:event_lblTatetiMouseClicked

      public static void main(String args[]) {
            try {
                  for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                        if ("Windows".equals(info.getName())) {
                              javax.swing.UIManager.setLookAndFeel(info.getClassName());
                              break;
                        }
                  }
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
                  java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            java.awt.EventQueue.invokeLater(new Runnable() {
                  public void run() {
                        new Menu().setVisible(true);
                  }
            });
      }

      // Variables declaration - do not modify//GEN-BEGIN:variables
      private background.Background background;
      private javax.swing.JButton btnCerrarSesion;
      private javax.swing.JButton btnClose;
      private javax.swing.JLabel jLabel3;
      private javax.swing.JPanel jPanel1;
      private javax.swing.JLabel lblBreakout;
      public static javax.swing.JLabel lblCreditos;
      private javax.swing.JLabel lblLeaderboard;
      public static javax.swing.JLabel lblNombre;
      private javax.swing.JLabel lblPacman;
      private javax.swing.JLabel lblTateti;
      private javax.swing.JLabel lblTetris;
      private javax.swing.JLabel lblTienda;
      private javax.swing.JLabel lblTituloBreakout;
      private javax.swing.JLabel lblTituloLeaderboard;
      private javax.swing.JLabel lblTituloPacman;
      private javax.swing.JLabel lblTituloTateti;
      private javax.swing.JLabel lblTituloTetris;
      private javax.swing.JLabel lblTituloTienda;
      // End of variables declaration//GEN-END:variables
}
