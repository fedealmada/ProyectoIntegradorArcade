package leaderboard;

import dao.UsuarioDAOImpl;
import entities.Usuario;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.plaf.ListUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import login.Login;
import main.Main;

public final class Leaderboard extends javax.swing.JFrame {

      UsuarioDAOImpl usuario = new UsuarioDAOImpl();
      private String nombreLogged;
      ArrayList<Usuario> listaUsuarios;
      TableModel modeloDatos;

      public Leaderboard() {
            initComponents();
            this.setResizable(false);
            getContentPane().setBackground(new Color(30, 30, 30));
            tableDark1.fixTable(jScrollPane1);

            listaUsuarios = new ArrayList<>();
            listaUsuarios = usuario.consultarLeaderboard("scorePacman");
            final String[] columnas = {"Posición", "Nombre", "Score", "Última conexión"};
            modeloDatos = new DefaultTableModel(columnas, listaUsuarios.size());
            for (int i = 0; i < listaUsuarios.size(); i++) {
                  Usuario u = listaUsuarios.get(i);
                  modeloDatos.setValueAt(i + 1, i, 0);
                  modeloDatos.setValueAt(u.getNombre(), i, 1);
                  modeloDatos.setValueAt(u.getScorePacman(), i, 2);
                  if (u.isLogged()) {
                        modeloDatos.setValueAt("Conectado", i, 3);
                  } else {
                        modeloDatos.setValueAt(u.getLastLoginDate(), i, 3);
                  }

            }

            tableDark1.setModel(modeloDatos);
      }

      public void loadTable(String tipo) {
            listaUsuarios.clear();
            listaUsuarios = usuario.consultarLeaderboard(tipo);
            final String[] columnas = {"Posición", "Nombre", "Score", "Última conexión"};

            modeloDatos = new DefaultTableModel(columnas, listaUsuarios.size());

            for (int i = 0; i < listaUsuarios.size(); i++) {
                  Usuario u = listaUsuarios.get(i);
                  modeloDatos.setValueAt(i + 1, i, 0);
                  modeloDatos.setValueAt(u.getNombre(), i, 1);

                  if (tipo.equals("scorePacman")) {
                        modeloDatos.setValueAt(u.getScorePacman(), i, 2);
                  } else if (tipo.equals("scoreTateti")) {
                        modeloDatos.setValueAt(u.getScoreTateti(), i, 2);
                  } else if(tipo.equals("scoreAtari")) {
                      modeloDatos.setValueAt(u.getScoreBreakout(), i, 2);
                  } else {
                        modeloDatos.setValueAt(u.getScoreTetris(), i, 2);
                  }

                  if (u.isLogged()) {
                        modeloDatos.setValueAt("Conectado", i, 3);
                  } else {
                        modeloDatos.setValueAt(u.getLastLoginDate(), i, 3);
                  }
            }

            tableDark1.setModel(modeloDatos);

            background.repaint();
      }

      @SuppressWarnings("unchecked")
      // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
      private void initComponents() {

            background = new background.Background(50, 50, 1002, 602, 902, "/background/background.png");
            btnClose = new javax.swing.JButton();
            jPanel1 = new javax.swing.JPanel();
            jLabel3 = new javax.swing.JLabel();
            btnIngresar = new javax.swing.JButton();
            lblTetris = new javax.swing.JLabel();
            jScrollPane1 = new javax.swing.JScrollPane();
            tableDark1 = new utilities.TableDark();
            lblTateti = new javax.swing.JLabel();
            lblPacman = new javax.swing.JLabel();
            lblBreakout = new javax.swing.JLabel();

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

            jPanel1.setBackground(new java.awt.Color(16, 16, 21, 135));
            jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            jLabel3.setBackground(new java.awt.Color(0, 0, 0));
            jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
            jLabel3.setForeground(new java.awt.Color(204, 51, 255));
            jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel3.setText("LEADERBOARD");
            jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 300, 80));

            btnIngresar.setBackground(new java.awt.Color(153, 102, 255));
            btnIngresar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
            btnIngresar.setForeground(new java.awt.Color(255, 255, 255));
            btnIngresar.setText("Atrás");
            btnIngresar.setBorder(null);
            btnIngresar.setBorderPainted(false);
            btnIngresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            btnIngresar.setFocusable(false);
            btnIngresar.addMouseListener(new java.awt.event.MouseAdapter() {
                  public void mouseEntered(java.awt.event.MouseEvent evt) {
                        btnIngresarMouseEntered(evt);
                  }
                  public void mouseExited(java.awt.event.MouseEvent evt) {
                        btnIngresarMouseExited(evt);
                  }
            });
            btnIngresar.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnIngresarActionPerformed(evt);
                  }
            });
            jPanel1.add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 540, 140, 50));

            lblTetris.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
            lblTetris.setForeground(new java.awt.Color(102, 102, 255));
            lblTetris.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lblTetris.setText("Tetris");
            lblTetris.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            lblTetris.addMouseListener(new java.awt.event.MouseAdapter() {
                  public void mouseClicked(java.awt.event.MouseEvent evt) {
                        lblTetrisMouseClicked(evt);
                  }
            });
            jPanel1.add(lblTetris, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 80, 140, 40));

            tableDark1.setModel(new javax.swing.table.DefaultTableModel(
                  new Object [][] {

                  },
                  new String [] {
                        "Posición", "Nombre", "Score", "Última conexión"
                  }
            ) {
                  boolean[] canEdit = new boolean [] {
                        false, false, false, false
                  };

                  public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return canEdit [columnIndex];
                  }
            });
            tableDark1.setAutoscrolls(false);
            tableDark1.setFocusable(false);
            tableDark1.setGridColor(new java.awt.Color(30, 30, 30));
            jScrollPane1.setViewportView(tableDark1);
            if (tableDark1.getColumnModel().getColumnCount() > 0) {
                  tableDark1.getColumnModel().getColumn(0).setResizable(false);
                  tableDark1.getColumnModel().getColumn(1).setResizable(false);
                  tableDark1.getColumnModel().getColumn(2).setResizable(false);
                  tableDark1.getColumnModel().getColumn(3).setResizable(false);
            }

            jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 860, 380));

            lblTateti.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
            lblTateti.setForeground(new java.awt.Color(102, 102, 255));
            lblTateti.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lblTateti.setText("Tateti");
            lblTateti.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            lblTateti.addMouseListener(new java.awt.event.MouseAdapter() {
                  public void mouseClicked(java.awt.event.MouseEvent evt) {
                        lblTatetiMouseClicked(evt);
                  }
            });
            jPanel1.add(lblTateti, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, 140, 40));

            lblPacman.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
            lblPacman.setForeground(new java.awt.Color(204, 204, 255));
            lblPacman.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lblPacman.setText("Pacman");
            lblPacman.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            lblPacman.addMouseListener(new java.awt.event.MouseAdapter() {
                  public void mouseClicked(java.awt.event.MouseEvent evt) {
                        lblPacmanMouseClicked(evt);
                  }
            });
            jPanel1.add(lblPacman, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 140, 40));

            lblBreakout.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
            lblBreakout.setForeground(new java.awt.Color(102, 102, 255));
            lblBreakout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lblBreakout.setText("Breakout");
            lblBreakout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            lblBreakout.addMouseListener(new java.awt.event.MouseAdapter() {
                  public void mouseClicked(java.awt.event.MouseEvent evt) {
                        lblBreakoutMouseClicked(evt);
                  }
            });
            jPanel1.add(lblBreakout, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 80, 140, 40));

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

      private void btnIngresarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIngresarMouseEntered
            btnIngresar.setBackground(new Color(153, 51, 255).brighter());
            background.repaint();
      }//GEN-LAST:event_btnIngresarMouseEntered

      private void btnIngresarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIngresarMouseExited
            btnIngresar.setBackground(new Color(153, 51, 255));
            background.repaint();
      }//GEN-LAST:event_btnIngresarMouseExited

      private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
            Main.vtnMenu.setVisible(true);
            this.setVisible(false);
      }//GEN-LAST:event_btnIngresarActionPerformed

      private void lblTatetiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTatetiMouseClicked
            lblTateti.setForeground(new Color(204, 204, 255));
            lblTetris.setForeground(new Color(102, 102, 255));
            lblPacman.setForeground(new Color(102, 102, 255));
            lblBreakout.setForeground(new Color(102, 102, 255));
            loadTable("scoreTateti");
      }//GEN-LAST:event_lblTatetiMouseClicked

      private void lblPacmanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPacmanMouseClicked
            lblTateti.setForeground(new Color(102, 102, 255));
            lblTetris.setForeground(new Color(102, 102, 255));
            lblPacman.setForeground(new Color(204, 204, 255));
            lblBreakout.setForeground(new Color(102, 102, 255));
            loadTable("scorePacman");
      }//GEN-LAST:event_lblPacmanMouseClicked

      private void lblTetrisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTetrisMouseClicked
            lblTateti.setForeground(new Color(102, 102, 255));
            lblTetris.setForeground(new Color(204, 204, 255));
            lblPacman.setForeground(new Color(102, 102, 255));
            lblBreakout.setForeground(new Color(102, 102, 255));
            loadTable("scoreTetris");
      }//GEN-LAST:event_lblTetrisMouseClicked

      private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
            int resp = JOptionPane.showConfirmDialog(null, "¿Realmente desea salir de la aplicación?",
               "Salir", JOptionPane.YES_NO_OPTION,
               JOptionPane.INFORMATION_MESSAGE, null);

            if (resp == 0) {
                  try {
                        usuario.cerrarSesion(Main.userLogged.getNombre());
                  } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
                        Logger.getLogger(Leaderboard.class.getName()).log(Level.SEVERE, null, ex);
                  }
                  System.exit(0);
            }
      }//GEN-LAST:event_btnCloseActionPerformed

    private void lblBreakoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBreakoutMouseClicked
            lblTateti.setForeground(new Color(102, 102, 255));
            lblTetris.setForeground(new Color(102, 102, 255));
            lblBreakout.setForeground(new Color(204, 204, 255));
            lblPacman.setForeground(new Color(102, 102, 255));
            loadTable("scoreAtari");
    }//GEN-LAST:event_lblBreakoutMouseClicked

      public static void main(String args[]) {
            try {
                  for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                        if ("Metal".equals(info.getName())) {
                              javax.swing.UIManager.setLookAndFeel(info.getClassName());
                              break;
                        }
                  }
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
                  java.util.logging.Logger.getLogger(Leaderboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            java.awt.EventQueue.invokeLater(new Runnable() {
                  public void run() {
                        new Leaderboard().setVisible(true);
                  }
            });
      }

      // Variables declaration - do not modify//GEN-BEGIN:variables
      private background.Background background;
      private javax.swing.JButton btnClose;
      private javax.swing.JButton btnIngresar;
      private javax.swing.JLabel jLabel3;
      private javax.swing.JPanel jPanel1;
      private javax.swing.JScrollPane jScrollPane1;
      private javax.swing.JLabel lblBreakout;
      private javax.swing.JLabel lblPacman;
      private javax.swing.JLabel lblTateti;
      private javax.swing.JLabel lblTetris;
      private utilities.TableDark tableDark1;
      // End of variables declaration//GEN-END:variables
}
