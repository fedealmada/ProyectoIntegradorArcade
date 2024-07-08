package register;

import dao.UsuarioDAOImpl;
import entities.Usuario;
import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import main.Main;

public final class Register extends javax.swing.JFrame {
      UsuarioDAOImpl usuario = new UsuarioDAOImpl();
      private boolean showPassword;
      ImageIcon show = new ImageIcon(getClass().getResource("/button/show.png"));
      ImageIcon hide = new ImageIcon(getClass().getResource("/button/hide.png"));
      
      
      public Register() {
            initComponents();
            this.setResizable(false);
            this.setLocationRelativeTo(null);
            lblShowPassword.setIcon(hide);
            this.setDefaultCloseOperation(Register.EXIT_ON_CLOSE);
            limpiar();
      }
      
      public void limpiar() {
            txtNombre.setBackground(Color.WHITE);
            txtPassword.setBackground(Color.WHITE);
            txtConfirmar.setBackground(Color.WHITE);
            cmbPregunta.setBackground(Color.WHITE);
            txtRespuesta.setBackground(Color.WHITE);

            txtNombre.setText(null);
            txtPassword.setText(null);
            txtConfirmar.setText(null);
            cmbPregunta.setSelectedIndex(0);
            txtRespuesta.setText(null);

            txtInfo.setText(null);
            showPassword = false;

            txtNombre.requestFocus();
      }

      @SuppressWarnings("unchecked")
      // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
      private void initComponents() {

            background = new background.Background(280, 0, 1002, 702, 400, "/background/background.png");
            pnlLogin = new javax.swing.JPanel();
            lblNombre = new javax.swing.JLabel();
            lblPassword = new javax.swing.JLabel();
            lblTituloJuego = new javax.swing.JLabel();
            txtRespuesta = new javax.swing.JTextField();
            lblTitulo = new javax.swing.JLabel();
            txtPassword = new javax.swing.JPasswordField();
            lblTengoCuenta = new javax.swing.JLabel();
            btnRegistrarse = new javax.swing.JButton();
            txtConfirmar = new javax.swing.JPasswordField();
            lblRespuesta = new javax.swing.JLabel();
            lblConfirmar = new javax.swing.JLabel();
            lblPregunta = new javax.swing.JLabel();
            txtNombre = new javax.swing.JTextField();
            cmbPregunta = new javax.swing.JComboBox<>();
            lblShowPassword = new javax.swing.JLabel();
            txtInfo = new javax.swing.JLabel();
            btnClose = new javax.swing.JButton();

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            setUndecorated(true);

            pnlLogin.setBackground(new java.awt.Color(16, 16, 21, 135));
            pnlLogin.setForeground(new java.awt.Color(255, 255, 255));
            pnlLogin.setLayout(null);

            lblNombre.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
            lblNombre.setForeground(new java.awt.Color(255, 255, 255));
            lblNombre.setText("Nombre de usuario");
            pnlLogin.add(lblNombre);
            lblNombre.setBounds(70, 170, 120, 16);

            lblPassword.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
            lblPassword.setForeground(new java.awt.Color(255, 255, 255));
            lblPassword.setText("Contraseña");
            pnlLogin.add(lblPassword);
            lblPassword.setBounds(70, 250, 150, 16);

            lblTituloJuego.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
            lblTituloJuego.setForeground(new java.awt.Color(204, 51, 255));
            lblTituloJuego.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lblTituloJuego.setText("ARCADE GAMES");
            lblTituloJuego.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            pnlLogin.add(lblTituloJuego);
            lblTituloJuego.setBounds(50, 30, 300, 80);

            txtRespuesta.setBorder(null);
            txtRespuesta.setCaretColor(new java.awt.Color(0, 0, 0));
            txtRespuesta.setDisabledTextColor(new java.awt.Color(255, 255, 255));
            pnlLogin.add(txtRespuesta);
            txtRespuesta.setBounds(70, 510, 240, 40);

            lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
            lblTitulo.setForeground(new java.awt.Color(204, 204, 255));
            lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lblTitulo.setText("Registro");
            pnlLogin.add(lblTitulo);
            lblTitulo.setBounds(150, 110, 90, 40);

            txtPassword.setBorder(null);
            txtPassword.setCaretColor(new java.awt.Color(0, 0, 0));
            txtPassword.setDisabledTextColor(new java.awt.Color(0, 0, 0));
            pnlLogin.add(txtPassword);
            txtPassword.setBounds(70, 270, 220, 40);

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
            lblTengoCuenta.setBounds(120, 650, 140, 40);

            btnRegistrarse.setBackground(new java.awt.Color(153, 51, 255));
            btnRegistrarse.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
            btnRegistrarse.setForeground(new java.awt.Color(255, 255, 255));
            btnRegistrarse.setText("Registrarse");
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
            btnRegistrarse.setBounds(100, 600, 170, 50);

            txtConfirmar.setBorder(null);
            txtConfirmar.setCaretColor(new java.awt.Color(0, 0, 0));
            txtConfirmar.setDisabledTextColor(new java.awt.Color(0, 0, 0));
            pnlLogin.add(txtConfirmar);
            txtConfirmar.setBounds(70, 350, 240, 40);

            lblRespuesta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
            lblRespuesta.setForeground(new java.awt.Color(255, 255, 255));
            lblRespuesta.setText("Respuesta");
            pnlLogin.add(lblRespuesta);
            lblRespuesta.setBounds(70, 490, 150, 16);

            lblConfirmar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
            lblConfirmar.setForeground(new java.awt.Color(255, 255, 255));
            lblConfirmar.setText("Confirmar contraseña");
            pnlLogin.add(lblConfirmar);
            lblConfirmar.setBounds(70, 330, 150, 16);

            lblPregunta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
            lblPregunta.setForeground(new java.awt.Color(255, 255, 255));
            lblPregunta.setText("Pregunta de seguridad");
            pnlLogin.add(lblPregunta);
            lblPregunta.setBounds(70, 410, 150, 16);

            txtNombre.setBorder(null);
            txtNombre.setCaretColor(new java.awt.Color(0, 0, 0));
            txtNombre.setDisabledTextColor(new java.awt.Color(255, 255, 255));
            pnlLogin.add(txtNombre);
            txtNombre.setBounds(70, 190, 240, 40);

            cmbPregunta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Seleccione una opción", "¿Cuál es tu pelicula favorita?", "¿Cuál es tu galletita favorita?", "¿Cómo se llama tu mascota?" }));
            cmbPregunta.setBorder(null);
            cmbPregunta.setLightWeightPopupEnabled(false);
            pnlLogin.add(cmbPregunta);
            cmbPregunta.setBounds(70, 430, 240, 40);

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
            lblShowPassword.setBounds(290, 270, 20, 40);

            txtInfo.setForeground(new java.awt.Color(255, 102, 102));
            pnlLogin.add(txtInfo);
            txtInfo.setBounds(70, 560, 290, 30);

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
            btnRegistrarse.setBackground(new Color(153,51,255).brighter());
      }//GEN-LAST:event_btnRegistrarseMouseEntered

      private void btnRegistrarseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarseMouseExited
            btnRegistrarse.setBackground(new Color(153,51,255));
      }//GEN-LAST:event_btnRegistrarseMouseExited

      private void lblTengoCuentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTengoCuentaMouseClicked
            Main.vtnLogin.setVisible(true);
            this.setVisible(false);
            showPassword = false;
            txtPassword.setEchoChar('•'); // Ocultamos la contraseña usando el contenido de passwordHidden.
            txtConfirmar.setEchoChar('•'); // Ocultamos la contraseña usando el contenido de passwordConfirmHidden.
            lblShowPassword.setIcon(hide);
            limpiar();         
      }//GEN-LAST:event_lblTengoCuentaMouseClicked

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
            try {
                  switch (usuario.registrarse(txtNombre.getText(), txtPassword.getText(), txtConfirmar.getText(), cmbPregunta.getSelectedIndex(), txtRespuesta.getText())) {
                        case 1 -> {  // Si se retorna 1 significa que el usuario se registró exitosamente y se abre la ventana para Loguearse.
                              this.setVisible(false);
                              Main.vtnLogin.setVisible(true);
                              String texto = txtNombre.getText() + " tu cuenta ha sido registrada en la base de datos\nAhora debes loguearte para iniciar sesión";
                              JOptionPane.showMessageDialog(null, texto);
                              txtNombre.setBackground(Color.WHITE);
                              txtPassword.setBackground(Color.WHITE);
                              txtConfirmar.setBackground(Color.WHITE);
                              txtRespuesta.setBackground(Color.WHITE);
                              cmbPregunta.setBackground(Color.WHITE);
                              limpiar();
                        }
                        case 0 -> { // Si se retorna 0 sigfinica que el nombre del usuario ya está en la base de datos.
                              txtNombre.setBackground(new Color(255, 228, 228));
                              txtPassword.setBackground(Color.WHITE);
                              txtConfirmar.setBackground(Color.WHITE);
                              txtRespuesta.setBackground(Color.WHITE);
                              cmbPregunta.setBackground(Color.WHITE);
                              txtInfo.setText("Este nombre ya está registrado");
                        }
                        case 2 -> {
                              txtNombre.setBackground(new Color(255, 228, 228));
                              txtPassword.setBackground(Color.WHITE);
                              txtConfirmar.setBackground(Color.WHITE);
                              txtRespuesta.setBackground(Color.WHITE);
                              cmbPregunta.setBackground(Color.WHITE);
                              txtInfo.setText("El nombre debe tener al menos 4 caracteres");
                        }
                        case 3 -> {
                              txtNombre.setBackground(Color.WHITE);
                              txtConfirmar.setBackground(Color.WHITE);
                              txtPassword.setBackground(new Color(255, 228, 228));
                              txtRespuesta.setBackground(Color.WHITE);
                              cmbPregunta.setBackground(Color.WHITE);
                              txtInfo.setText("La contraseña debe tener al menos 4 caracteres");
                        }
                        case 4 -> {
                              txtNombre.setBackground(Color.WHITE);
                              txtPassword.setBackground(new Color(255, 228, 228));
                              txtConfirmar.setBackground(new Color(255, 228, 228));
                              txtRespuesta.setBackground(Color.WHITE);
                              cmbPregunta.setBackground(Color.WHITE);
                              txtInfo.setText("La contraseñas no coinciden");
                        }
                        case 5 -> {
                              txtNombre.setBackground(Color.WHITE);
                              txtPassword.setBackground(Color.WHITE);
                              txtConfirmar.setBackground(Color.WHITE);
                              txtRespuesta.setBackground(new Color(255, 228, 228));
                              cmbPregunta.setBackground(Color.WHITE);
                              txtInfo.setText("La respuesta está vacía");
                        }
                        case 6 -> {
                              txtNombre.setBackground(Color.WHITE);
                              txtPassword.setBackground(Color.WHITE);
                              txtConfirmar.setBackground(Color.WHITE);
                              txtRespuesta.setBackground(Color.WHITE);
                              cmbPregunta.setBackground(new Color(255, 228, 228));
                              txtInfo.setText("Debes seleccionar una pregunta");
                        }
                  }
                  background.repaint();
            } catch (SQLException ex) {
                  Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                  Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                  Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                  Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            }
      }//GEN-LAST:event_btnRegistrarseActionPerformed

      private void btnCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseClicked
            // Método con 6 parámetros
            int resp =JOptionPane.showConfirmDialog(null, "¿Realmente desea salir de la aplicación?",
                  "Salir", JOptionPane.YES_NO_OPTION,
                  JOptionPane.INFORMATION_MESSAGE, null);

            if(resp == 0) System.exit(0);

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
            try {
                  switch (usuario.registrarse(txtNombre.getText(), txtPassword.getText(), txtConfirmar.getText(), cmbPregunta.getSelectedIndex(), txtRespuesta.getText())) {
                        case 1 -> {  // Si se retorna 1 significa que el usuario se registró exitosamente y se abre la ventana para Loguearse.
                              this.setVisible(false);
                              Main.vtnLogin.setVisible(true);
                              String texto = txtNombre.getText() + " tu cuenta ha sido registrada en la base de datos\nAhora debes loguearte para iniciar sesión";
                              JOptionPane.showMessageDialog(null, texto);
                              txtNombre.setBackground(Color.WHITE);
                              txtPassword.setBackground(Color.WHITE);
                              txtConfirmar.setBackground(Color.WHITE);
                              txtRespuesta.setBackground(Color.WHITE);
                              cmbPregunta.setBackground(Color.WHITE);
                              limpiar();
                        }
                        case 0 -> { // Si se retorna 0 sigfinica que el nombre del usuario ya está en la base de datos.
                              txtNombre.setBackground(new Color(255, 228, 228));
                              txtPassword.setBackground(Color.WHITE);
                              txtConfirmar.setBackground(Color.WHITE);
                              txtRespuesta.setBackground(Color.WHITE);
                              cmbPregunta.setBackground(Color.WHITE);
                              txtInfo.setText("Este nombre ya está registrado");
                        }
                        case 2 -> {
                              txtNombre.setBackground(new Color(255, 228, 228));
                              txtPassword.setBackground(Color.WHITE);
                              txtConfirmar.setBackground(Color.WHITE);
                              txtRespuesta.setBackground(Color.WHITE);
                              cmbPregunta.setBackground(Color.WHITE);
                              txtInfo.setText("El nombre debe tener al menos 4 caracteres");
                        }
                        case 3 -> {
                              txtNombre.setBackground(Color.WHITE);
                              txtConfirmar.setBackground(Color.WHITE);
                              txtPassword.setBackground(new Color(255, 228, 228));
                              txtRespuesta.setBackground(Color.WHITE);
                              cmbPregunta.setBackground(Color.WHITE);
                              txtInfo.setText("La contraseña debe tener al menos 4 caracteres");
                        }
                        case 4 -> {
                              txtNombre.setBackground(Color.WHITE);
                              txtPassword.setBackground(new Color(255, 228, 228));
                              txtConfirmar.setBackground(new Color(255, 228, 228));
                              txtRespuesta.setBackground(Color.WHITE);
                              cmbPregunta.setBackground(Color.WHITE);
                              txtInfo.setText("La contraseñas no coinciden");
                        }
                        case 5 -> {
                              txtNombre.setBackground(Color.WHITE);
                              txtPassword.setBackground(Color.WHITE);
                              txtConfirmar.setBackground(Color.WHITE);
                              txtRespuesta.setBackground(new Color(255, 228, 228));
                              cmbPregunta.setBackground(Color.WHITE);
                              txtInfo.setText("La respuesta está vacía");
                        }
                        case 6 -> {
                              txtNombre.setBackground(Color.WHITE);
                              txtPassword.setBackground(Color.WHITE);
                              txtConfirmar.setBackground(Color.WHITE);
                              txtRespuesta.setBackground(Color.WHITE);
                              cmbPregunta.setBackground(new Color(255, 228, 228));
                              txtInfo.setText("Debes seleccionar una pregunta");
                        }
                  }
                  background.repaint();
            } catch (SQLException ex) {
                  Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                  Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                  Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                  Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            }  
      }//GEN-LAST:event_btnRegistrarseKeyPressed

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
      private javax.swing.JComboBox<String> cmbPregunta;
      private javax.swing.JLabel lblConfirmar;
      private javax.swing.JLabel lblNombre;
      private javax.swing.JLabel lblPassword;
      private javax.swing.JLabel lblPregunta;
      private javax.swing.JLabel lblRespuesta;
      private javax.swing.JLabel lblShowPassword;
      private javax.swing.JLabel lblTengoCuenta;
      private javax.swing.JLabel lblTitulo;
      private javax.swing.JLabel lblTituloJuego;
      private javax.swing.JPanel pnlLogin;
      private javax.swing.JPasswordField txtConfirmar;
      private javax.swing.JLabel txtInfo;
      private javax.swing.JTextField txtNombre;
      private javax.swing.JPasswordField txtPassword;
      private javax.swing.JTextField txtRespuesta;
      // End of variables declaration//GEN-END:variables
}
