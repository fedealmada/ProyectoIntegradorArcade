package recover;

import register.*;
import dao.UsuarioDAOImpl;
import entities.Usuario;
import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import main.Main;

public final class Recover_2 extends javax.swing.JFrame {

      UsuarioDAOImpl usuarioDAO = new UsuarioDAOImpl();
      private String nombreUsuarioRecuperar;

      public Recover_2() {
            initComponents();
            this.setResizable(false);
            String textoPregunta = null;
            lblPregunta.setText(textoPregunta);
            this.setLocationRelativeTo(null);
            this.setDefaultCloseOperation(Recover_2.EXIT_ON_CLOSE);
            limpiar();
      }

      public void setRecovery(String usuarioRecuperar) {
            this.nombreUsuarioRecuperar = usuarioRecuperar;
            String textoPregunta = null;
            try {
                  textoPregunta = usuarioDAO.getTextoPregunta(usuarioRecuperar);
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
                  Logger.getLogger(Recover_2.class.getName()).log(Level.SEVERE, null, ex);
            }
            lblPregunta.setText(textoPregunta);
            System.out.println(textoPregunta);

      }

      public void limpiar() {
            txtRespuesta.setBackground(Color.WHITE);
            txtRespuesta.setText(null);

            txtInfo.setText(null);

            txtRespuesta.requestFocus();
      }

      @SuppressWarnings("unchecked")
      // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
      private void initComponents() {

            background = new background.Background(280, 0, 1002, 702, 400, "/background/background.png");
            pnlLogin = new javax.swing.JPanel();
            lblPregunta = new javax.swing.JLabel();
            lblTituloJuego = new javax.swing.JLabel();
            lblTitulo = new javax.swing.JLabel();
            lblCrearCuenta = new javax.swing.JLabel();
            btnRecuperar = new javax.swing.JButton();
            txtRespuesta = new javax.swing.JTextField();
            txtInfo = new javax.swing.JLabel();
            lblTengoCuenta = new javax.swing.JLabel();
            btnClose = new javax.swing.JButton();

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            setUndecorated(true);

            pnlLogin.setBackground(new java.awt.Color(16, 16, 21, 135));
            pnlLogin.setForeground(new java.awt.Color(255, 255, 255));
            pnlLogin.setLayout(null);

            lblPregunta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
            lblPregunta.setForeground(new java.awt.Color(255, 255, 255));
            lblPregunta.setText("Pregunta");
            pnlLogin.add(lblPregunta);
            lblPregunta.setBounds(70, 170, 290, 16);

            lblTituloJuego.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
            lblTituloJuego.setForeground(new java.awt.Color(204, 51, 255));
            lblTituloJuego.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lblTituloJuego.setText("ARCADE GAMES");
            lblTituloJuego.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            pnlLogin.add(lblTituloJuego);
            lblTituloJuego.setBounds(50, 30, 300, 80);

            lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
            lblTitulo.setForeground(new java.awt.Color(204, 204, 255));
            lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lblTitulo.setText("Recuperar 2/3");
            pnlLogin.add(lblTitulo);
            lblTitulo.setBounds(100, 110, 180, 40);

            lblCrearCuenta.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
            lblCrearCuenta.setForeground(new java.awt.Color(204, 204, 204));
            lblCrearCuenta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lblCrearCuenta.setText("Crear cuenta");
            lblCrearCuenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            lblCrearCuenta.addMouseListener(new java.awt.event.MouseAdapter() {
                  public void mouseClicked(java.awt.event.MouseEvent evt) {
                        lblCrearCuentaMouseClicked(evt);
                  }
            });
            pnlLogin.add(lblCrearCuenta);
            lblCrearCuenta.setBounds(110, 560, 140, 40);

            btnRecuperar.setBackground(new java.awt.Color(153, 51, 255));
            btnRecuperar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
            btnRecuperar.setForeground(new java.awt.Color(255, 255, 255));
            btnRecuperar.setText("Recuperar");
            btnRecuperar.setBorder(null);
            btnRecuperar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            btnRecuperar.addMouseListener(new java.awt.event.MouseAdapter() {
                  public void mouseEntered(java.awt.event.MouseEvent evt) {
                        btnRecuperarMouseEntered(evt);
                  }
                  public void mouseExited(java.awt.event.MouseEvent evt) {
                        btnRecuperarMouseExited(evt);
                  }
            });
            btnRecuperar.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnRecuperarActionPerformed(evt);
                  }
            });
            btnRecuperar.addKeyListener(new java.awt.event.KeyAdapter() {
                  public void keyPressed(java.awt.event.KeyEvent evt) {
                        btnRecuperarKeyPressed(evt);
                  }
            });
            pnlLogin.add(btnRecuperar);
            btnRecuperar.setBounds(100, 470, 170, 50);

            txtRespuesta.setBorder(null);
            txtRespuesta.setCaretColor(new java.awt.Color(0, 0, 0));
            txtRespuesta.setDisabledTextColor(new java.awt.Color(255, 255, 255));
            pnlLogin.add(txtRespuesta);
            txtRespuesta.setBounds(70, 190, 240, 40);

            txtInfo.setForeground(new java.awt.Color(255, 102, 102));
            pnlLogin.add(txtInfo);
            txtInfo.setBounds(70, 250, 290, 30);

            lblTengoCuenta.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
            lblTengoCuenta.setForeground(new java.awt.Color(204, 204, 204));
            lblTengoCuenta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lblTengoCuenta.setText("Ya tengo una cuenta");
            lblTengoCuenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            lblTengoCuenta.addMouseListener(new java.awt.event.MouseAdapter() {
                  public void mouseClicked(java.awt.event.MouseEvent evt) {
                        lblTengoCuentaMouseClicked(evt);
                  }
            });
            pnlLogin.add(lblTengoCuenta);
            lblTengoCuenta.setBounds(110, 600, 140, 40);

            background.add(pnlLogin);
            pnlLogin.setBounds(280, 0, 400, 702);

            btnClose.setBackground(new java.awt.Color(	255, 85, 85, 0));
            btnClose.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
            btnClose.setForeground(new java.awt.Color(255, 255, 255));
            btnClose.setText("X");
            btnClose.setBorder(null);
            btnClose.setFocusable(false);
            btnClose.addMouseListener(new java.awt.event.MouseAdapter() {
                  public void mouseClicked(java.awt.event.MouseEvent evt) {
                        btnCloseMouseClicked(evt);
                  }
                  public void mouseEntered(java.awt.event.MouseEvent evt) {
                        btnCloseMouseEntered(evt);
                  }
                  public void mouseExited(java.awt.event.MouseEvent evt) {
                        btnCloseMouseExited(evt);
                  }
            });
            background.add(btnClose);
            btnClose.setBounds(970, 0, 30, 23);

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                  layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, 1002, Short.MAX_VALUE)
            );
            layout.setVerticalGroup(
                  layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, 702, Short.MAX_VALUE)
            );

            pack();
            setLocationRelativeTo(null);
      }// </editor-fold>//GEN-END:initComponents

      private void btnRecuperarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRecuperarMouseEntered
            btnRecuperar.setBackground(new Color(153, 51, 255).brighter());
      }//GEN-LAST:event_btnRecuperarMouseEntered

      private void btnRecuperarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRecuperarMouseExited
            btnRecuperar.setBackground(new Color(153, 51, 255));
      }//GEN-LAST:event_btnRecuperarMouseExited

      private void lblCrearCuentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCrearCuentaMouseClicked
            Main.vtnRegister.setVisible(true);
            this.setVisible(false);
            limpiar();
      }//GEN-LAST:event_lblCrearCuentaMouseClicked

      private void btnRecuperarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecuperarActionPerformed

            String respuestaCifrada = usuarioDAO.cifrar(txtRespuesta.getText());

            try {
                  if (usuarioDAO.getRespuesta(nombreUsuarioRecuperar).equals(respuestaCifrada)) {
                        Main.vtnRecover3.setVisible(true);
                        Main.vtnRecover3.limpiar();
                        Main.vtnRecover3.setRecovery(nombreUsuarioRecuperar);

                        this.setVisible(false);
//                        limpiar();
                  } else {
                        txtInfo.setText("La respuesta no es correcta.");
                  }
                  background.repaint();
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
                  Logger.getLogger(Recover_2.class.getName()).log(Level.SEVERE, null, ex);
            }
      }//GEN-LAST:event_btnRecuperarActionPerformed

      private void btnCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseClicked

            int resp = JOptionPane.showConfirmDialog(null, "¿Realmente desea salir de la aplicación?",
               "Salir", JOptionPane.YES_NO_OPTION,
               JOptionPane.INFORMATION_MESSAGE, null);

            if (resp == 0) {
                  System.exit(0);
            }

      }//GEN-LAST:event_btnCloseMouseClicked

      private void btnCloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseEntered
            btnClose.setBackground(new Color(255, 85, 85, 200));
            background.repaint();
      }//GEN-LAST:event_btnCloseMouseEntered

      private void btnCloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseExited
            btnClose.setBackground(new Color(255, 85, 85, 0));
            background.repaint();
      }//GEN-LAST:event_btnCloseMouseExited

      private void btnRecuperarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnRecuperarKeyPressed

            String respuestaCifrada = usuarioDAO.cifrar(txtRespuesta.getText());

            try {
                  if (usuarioDAO.getRespuesta(nombreUsuarioRecuperar).equals(respuestaCifrada)) {
                        Main.vtnRecover3.setVisible(true);
                        Main.vtnRecover3.limpiar();
                        Main.vtnRecover3.setRecovery(nombreUsuarioRecuperar);

                        this.setVisible(false);
                        this.limpiar();
                  } else {
                        txtInfo.setText("La respuesta no es correcta.");
                  }
                  background.repaint();
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
                  Logger.getLogger(Recover_2.class.getName()).log(Level.SEVERE, null, ex);
            }
      }//GEN-LAST:event_btnRecuperarKeyPressed

      private void lblTengoCuentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTengoCuentaMouseClicked
            Main.vtnLogin.setVisible(true);
            this.setVisible(false);
            limpiar();
      }//GEN-LAST:event_lblTengoCuentaMouseClicked

//      public static void main(String args[]) {
//            try {
//                  for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                        if ("Windows".equals(info.getName())) {
//                              javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                              break;
//                        }
//                  }
//            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
//                  java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//            }
//            java.awt.EventQueue.invokeLater(new Runnable() {
//                  public void run() {
//                        new Register().setVisible(true);
//                  }
//            });
//      }

      // Variables declaration - do not modify//GEN-BEGIN:variables
      private background.Background background;
      private javax.swing.JButton btnClose;
      private javax.swing.JButton btnRecuperar;
      private javax.swing.JLabel lblCrearCuenta;
      private javax.swing.JLabel lblPregunta;
      private javax.swing.JLabel lblTengoCuenta;
      private javax.swing.JLabel lblTitulo;
      private javax.swing.JLabel lblTituloJuego;
      private javax.swing.JPanel pnlLogin;
      private javax.swing.JLabel txtInfo;
      private javax.swing.JTextField txtRespuesta;
      // End of variables declaration//GEN-END:variables
}
