package recover;

import dao.UsuarioDAOImpl;
import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import main.Main;

public final class Recover_3 extends javax.swing.JFrame {

      UsuarioDAOImpl usuarioDAO = new UsuarioDAOImpl();
      private String nombreUsuarioRecuperar;
      private boolean showPassword;
      ImageIcon show = new ImageIcon(getClass().getResource("/button/show.png"));
      ImageIcon hide = new ImageIcon(getClass().getResource("/button/hide.png"));

      public Recover_3() {
            initComponents();
            this.setResizable(false);
            this.setLocationRelativeTo(null);
            lblShowPassword.setIcon(hide);
            this.setDefaultCloseOperation(Recover_3.EXIT_ON_CLOSE);
            limpiar();
      }

      public void setRecovery(String usuarioRecuperar) {
            this.nombreUsuarioRecuperar = usuarioRecuperar;
      }
      
      public void limpiar() {
            txtPassword.setBackground(Color.WHITE);
            txtConfirmar.setBackground(Color.WHITE);

            txtPassword.setText(null);
            txtConfirmar.setText(null);

            txtInfo.setText(null);
            showPassword = false;

      }

      @SuppressWarnings("unchecked")
      // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
      private void initComponents() {

            background = new background.Background(280, 0, 1002, 702, 400, "/background/background.png");
            pnlLogin = new javax.swing.JPanel();
            lblPassword = new javax.swing.JLabel();
            lblTituloJuego = new javax.swing.JLabel();
            lblTitulo = new javax.swing.JLabel();
            txtPassword = new javax.swing.JPasswordField();
            lblCrearCuenta = new javax.swing.JLabel();
            btnRegistrarse = new javax.swing.JButton();
            txtConfirmar = new javax.swing.JPasswordField();
            lblConfirmar = new javax.swing.JLabel();
            lblShowPassword = new javax.swing.JLabel();
            txtInfo = new javax.swing.JLabel();
            lblTengoCuenta = new javax.swing.JLabel();
            btnClose = new javax.swing.JButton();

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            setUndecorated(true);

            pnlLogin.setBackground(new java.awt.Color(16, 16, 21, 135));
            pnlLogin.setForeground(new java.awt.Color(255, 255, 255));
            pnlLogin.setLayout(null);

            lblPassword.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
            lblPassword.setForeground(new java.awt.Color(255, 255, 255));
            lblPassword.setText("Nueva contraseña");
            pnlLogin.add(lblPassword);
            lblPassword.setBounds(70, 170, 150, 16);

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
            lblTitulo.setText("Recuperar 3/3");
            pnlLogin.add(lblTitulo);
            lblTitulo.setBounds(100, 110, 190, 40);

            txtPassword.setBorder(null);
            txtPassword.setCaretColor(new java.awt.Color(0, 0, 0));
            txtPassword.setDisabledTextColor(new java.awt.Color(0, 0, 0));
            pnlLogin.add(txtPassword);
            txtPassword.setBounds(70, 190, 220, 40);

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
            lblCrearCuenta.setBounds(120, 560, 140, 40);

            btnRegistrarse.setBackground(new java.awt.Color(153, 51, 255));
            btnRegistrarse.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
            btnRegistrarse.setForeground(new java.awt.Color(255, 255, 255));
            btnRegistrarse.setText("Actualizar");
            btnRegistrarse.setBorder(null);
            btnRegistrarse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            btnRegistrarse.addMouseListener(new java.awt.event.MouseAdapter() {
                  public void mouseEntered(java.awt.event.MouseEvent evt) {
                        btnRegistrarseMouseEntered(evt);
                  }
                  public void mouseExited(java.awt.event.MouseEvent evt) {
                        btnRegistrarseMouseExited(evt);
                  }
            });
            btnRegistrarse.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnRegistrarseActionPerformed(evt);
                  }
            });
            btnRegistrarse.addKeyListener(new java.awt.event.KeyAdapter() {
                  public void keyPressed(java.awt.event.KeyEvent evt) {
                        btnRegistrarseKeyPressed(evt);
                  }
            });
            pnlLogin.add(btnRegistrarse);
            btnRegistrarse.setBounds(110, 420, 170, 50);

            txtConfirmar.setBorder(null);
            txtConfirmar.setCaretColor(new java.awt.Color(0, 0, 0));
            txtConfirmar.setDisabledTextColor(new java.awt.Color(0, 0, 0));
            pnlLogin.add(txtConfirmar);
            txtConfirmar.setBounds(70, 270, 240, 40);

            lblConfirmar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
            lblConfirmar.setForeground(new java.awt.Color(255, 255, 255));
            lblConfirmar.setText("Confirmar contraseña");
            pnlLogin.add(lblConfirmar);
            lblConfirmar.setBounds(70, 250, 150, 16);

            lblShowPassword.setBackground(new java.awt.Color(255, 255, 255));
            lblShowPassword.setForeground(new java.awt.Color(255, 255, 255));
            lblShowPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/button/hide.png"))); // NOI18N
            lblShowPassword.setOpaque(true);
            lblShowPassword.addMouseListener(new java.awt.event.MouseAdapter() {
                  public void mouseClicked(java.awt.event.MouseEvent evt) {
                        lblShowPasswordMouseClicked(evt);
                  }
            });
            pnlLogin.add(lblShowPassword);
            lblShowPassword.setBounds(290, 190, 20, 40);

            txtInfo.setForeground(new java.awt.Color(255, 102, 102));
            pnlLogin.add(txtInfo);
            txtInfo.setBounds(70, 330, 290, 30);

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
            lblTengoCuenta.setBounds(120, 600, 140, 40);

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

      private void btnRegistrarseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarseMouseEntered
            btnRegistrarse.setBackground(new Color(153, 51, 255).brighter());
      }//GEN-LAST:event_btnRegistrarseMouseEntered

      private void btnRegistrarseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarseMouseExited
            btnRegistrarse.setBackground(new Color(153, 51, 255));
      }//GEN-LAST:event_btnRegistrarseMouseExited

      private void lblCrearCuentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCrearCuentaMouseClicked
            Main.vtnRegister.setVisible(true);
            this.setVisible(false);

            showPassword = false;
            txtPassword.setEchoChar('•'); // Ocultamos la contraseña.
            lblShowPassword.setIcon(hide);
            limpiar();
      }//GEN-LAST:event_lblCrearCuentaMouseClicked

      private void lblShowPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblShowPasswordMouseClicked
            if (showPassword) { // Si la contraseña está visible
                  txtPassword.setEchoChar('•'); // Ocultamos la contraseña.
                  txtConfirmar.setEchoChar('•'); // Ocultamos la contraseña.
                  lblShowPassword.setIcon(hide); // Ponemos el icono de oculto.
                  showPassword = false; // Desactivamos el flag.
            } else {
                  txtPassword.setEchoChar((char) 0); // Mostramos la contraseña.
                  txtConfirmar.setEchoChar((char) 0); // Mostramos la contraseña.
                  lblShowPassword.setIcon(show); // Ponemos el icono de visible.
                  showPassword = true; // Activamos el flag.
            }
      }//GEN-LAST:event_lblShowPasswordMouseClicked

      private void btnRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarseActionPerformed

            if(txtPassword.getText().equals(txtConfirmar.getText())) {
                  String passwordCifrada = usuarioDAO.cifrar(txtPassword.getText());
                  System.out.println(txtPassword.getText());
                  try {
                        usuarioDAO.actualizarPassword(passwordCifrada, nombreUsuarioRecuperar);
                  } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
                        Logger.getLogger(Recover_3.class.getName()).log(Level.SEVERE, null, ex);
                  }
                  Main.vtnLogin.setVisible(true);
                  this.setVisible(false);
                  this.limpiar();
                  JOptionPane.showMessageDialog(null, "La contraseña ha sido recuperada exitosamente.\nAhora inicia sesión para logearte.");
            } else {
                  txtInfo.setText("Las contraseñas no coinciden.");
            }
            
            background.repaint();
            
      }//GEN-LAST:event_btnRegistrarseActionPerformed

      private void btnCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseClicked
            // Método con 6 parámetros
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

      private void btnRegistrarseKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnRegistrarseKeyPressed
   
      }//GEN-LAST:event_btnRegistrarseKeyPressed

      private void lblTengoCuentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTengoCuentaMouseClicked
            Main.vtnLogin.setVisible(true);
            this.setVisible(false);
            showPassword = false;
            txtPassword.setEchoChar('•'); // Ocultamos la contraseña usando el contenido de passwordHidden.
            txtConfirmar.setEchoChar('•'); // Ocultamos la contraseña usando el contenido de passwordConfirmHidden.
            lblShowPassword.setIcon(hide);
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
      private javax.swing.JButton btnRegistrarse;
      private javax.swing.JLabel lblConfirmar;
      private javax.swing.JLabel lblCrearCuenta;
      private javax.swing.JLabel lblPassword;
      private javax.swing.JLabel lblShowPassword;
      private javax.swing.JLabel lblTengoCuenta;
      private javax.swing.JLabel lblTitulo;
      private javax.swing.JLabel lblTituloJuego;
      private javax.swing.JPanel pnlLogin;
      private javax.swing.JPasswordField txtConfirmar;
      private javax.swing.JLabel txtInfo;
      private javax.swing.JPasswordField txtPassword;
      // End of variables declaration//GEN-END:variables
}
