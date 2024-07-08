package login;

import dao.UsuarioDAOImpl;
import entities.Usuario;
import java.awt.Color;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import main.Main;
import menu.Menu;
import store.Store;

public final class Login extends javax.swing.JFrame {

      UsuarioDAOImpl usuarioDAO = new UsuarioDAOImpl();
      private boolean showPassword;
      ImageIcon show = new ImageIcon(getClass().getResource("/button/show.png"));
      ImageIcon hide = new ImageIcon(getClass().getResource("/button/hide.png"));

      public Login() {
            initComponents();
            this.setResizable(false);
            limpiar();
      }

      public void limpiar() {
            txtNombre.setBackground(Color.WHITE);
            txtPassword.setBackground(Color.WHITE);

            txtNombre.setText(null);
            txtPassword.setText(null);

            txtInfo.setText(null);
            showPassword = false;

            txtNombre.requestFocus();
      }

      @SuppressWarnings("unchecked")
      // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
      private void initComponents() {

            background = new background.Background(280, 0, 1002, 702, 400, "/background/background.png");
            pnlLogin = new javax.swing.JPanel();
            jLabel1 = new javax.swing.JLabel();
            jLabel2 = new javax.swing.JLabel();
            jLabel3 = new javax.swing.JLabel();
            txtNombre = new javax.swing.JTextField();
            jLabel4 = new javax.swing.JLabel();
            txtPassword = new javax.swing.JPasswordField();
            lblCrearCuenta = new javax.swing.JLabel();
            btnIngresar = new javax.swing.JButton();
            lblShowPassword = new javax.swing.JLabel();
            lblRecuperar = new javax.swing.JLabel();
            txtInfo = new javax.swing.JLabel();
            btnClose = new javax.swing.JButton();

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            setUndecorated(true);

            pnlLogin.setBackground(new java.awt.Color(16, 16, 21, 135));
            pnlLogin.setForeground(new java.awt.Color(102, 102, 102));
            pnlLogin.setLayout(null);

            jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
            jLabel1.setForeground(new java.awt.Color(255, 255, 255));
            jLabel1.setText("Nombre de usuario");
            pnlLogin.add(jLabel1);
            jLabel1.setBounds(70, 170, 140, 16);

            jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
            jLabel2.setForeground(new java.awt.Color(255, 255, 255));
            jLabel2.setText("Contraseña");
            pnlLogin.add(jLabel2);
            jLabel2.setBounds(70, 270, 150, 16);

            jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
            jLabel3.setForeground(new java.awt.Color(204, 51, 255));
            jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel3.setText("ARCADE GAMES");
            jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            pnlLogin.add(jLabel3);
            jLabel3.setBounds(50, 30, 300, 80);

            txtNombre.setBorder(null);
            txtNombre.setCaretColor(new java.awt.Color(0, 0, 0));
            txtNombre.setDisabledTextColor(new java.awt.Color(255, 255, 255));
            pnlLogin.add(txtNombre);
            txtNombre.setBounds(70, 190, 240, 40);

            jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
            jLabel4.setForeground(new java.awt.Color(204, 204, 255));
            jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel4.setText("Log In");
            pnlLogin.add(jLabel4);
            jLabel4.setBounds(170, 110, 60, 40);

            txtPassword.setBorder(null);
            txtPassword.setCaretColor(new java.awt.Color(0, 0, 0));
            txtPassword.setDisabledTextColor(new java.awt.Color(0, 0, 0));
            pnlLogin.add(txtPassword);
            txtPassword.setBounds(70, 290, 220, 40);

            lblCrearCuenta.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
            lblCrearCuenta.setForeground(new java.awt.Color(204, 204, 255));
            lblCrearCuenta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lblCrearCuenta.setText("Crear una cuenta");
            lblCrearCuenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            lblCrearCuenta.setFocusCycleRoot(true);
            lblCrearCuenta.setFocusTraversalPolicy(null);
            lblCrearCuenta.setInheritsPopupMenu(false);
            lblCrearCuenta.setRequestFocusEnabled(false);
            lblCrearCuenta.setVerifyInputWhenFocusTarget(false);
            lblCrearCuenta.addMouseListener(new java.awt.event.MouseAdapter() {
                  public void mouseClicked(java.awt.event.MouseEvent evt) {
                        lblCrearCuentaMouseClicked(evt);
                  }
            });
            pnlLogin.add(lblCrearCuenta);
            lblCrearCuenta.setBounds(120, 540, 140, 30);

            btnIngresar.setBackground(new java.awt.Color(153, 102, 255));
            btnIngresar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
            btnIngresar.setForeground(new java.awt.Color(255, 255, 255));
            btnIngresar.setText("Ingresar");
            btnIngresar.setBorder(null);
            btnIngresar.setBorderPainted(false);
            btnIngresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
            btnIngresar.addKeyListener(new java.awt.event.KeyAdapter() {
                  public void keyPressed(java.awt.event.KeyEvent evt) {
                        btnIngresarKeyPressed(evt);
                  }
            });
            pnlLogin.add(btnIngresar);
            btnIngresar.setBounds(110, 390, 160, 50);

            lblShowPassword.setBackground(new java.awt.Color(255, 255, 255));
            lblShowPassword.setForeground(new java.awt.Color(255, 255, 255));
            lblShowPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/button/hide.png"))); // NOI18N
            lblShowPassword.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            lblShowPassword.setIconTextGap(0);
            lblShowPassword.setOpaque(true);
            lblShowPassword.setRequestFocusEnabled(false);
            lblShowPassword.addMouseListener(new java.awt.event.MouseAdapter() {
                  public void mouseClicked(java.awt.event.MouseEvent evt) {
                        lblShowPasswordMouseClicked(evt);
                  }
            });
            pnlLogin.add(lblShowPassword);
            lblShowPassword.setBounds(290, 290, 20, 40);

            lblRecuperar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
            lblRecuperar.setForeground(new java.awt.Color(204, 204, 255));
            lblRecuperar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lblRecuperar.setText("Recuperar contraseña");
            lblRecuperar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            lblRecuperar.addMouseListener(new java.awt.event.MouseAdapter() {
                  public void mouseClicked(java.awt.event.MouseEvent evt) {
                        lblRecuperarMouseClicked(evt);
                  }
            });
            pnlLogin.add(lblRecuperar);
            lblRecuperar.setBounds(120, 480, 140, 40);

            txtInfo.setBackground(new java.awt.Color(255, 255, 255, 255));
            txtInfo.setForeground(new java.awt.Color(255, 102, 102));
            txtInfo.setAutoscrolls(true);
            txtInfo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            txtInfo.setInheritsPopupMenu(false);
            txtInfo.setNextFocusableComponent(pnlLogin);
            pnlLogin.add(txtInfo);
            txtInfo.setBounds(70, 350, 240, 20);

            background.add(pnlLogin);
            pnlLogin.setBounds(280, 0, 400, 702);

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

      private void btnIngresarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIngresarMouseEntered
            btnIngresar.setBackground(new Color(153, 51, 255).brighter());
            background.repaint();
      }//GEN-LAST:event_btnIngresarMouseEntered

      private void btnIngresarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIngresarMouseExited
            btnIngresar.setBackground(new Color(153, 51, 255));
            background.repaint();
      }//GEN-LAST:event_btnIngresarMouseExited

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
                  lblShowPassword.setIcon(hide); // Ponemos el icono de oculto.
                  showPassword = false; // Desactivamos el flag.
            } else {
                  txtPassword.setEchoChar((char) 0); // Mostramos la contraseña.
                  lblShowPassword.setIcon(show); // Ponemos el icono de visible.
                  showPassword = true; // Activamos el flag.
            }
      }//GEN-LAST:event_lblShowPasswordMouseClicked

      private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
           try {
                  // Llamamos al método Ingresar() que chequea el contenido de txtNombre y el txtPassword en la base de datos y devuelve un entero.
                  switch (usuarioDAO.ingresar(txtNombre.getText(), txtPassword.getText())) {
                        case 1 -> {  // Si se retorna 1 significa que el usuarioDAO se encuentra registrado, por lo tanto se accede a la vtnMenu.
                              this.setVisible(false);
                              Main.vtnMenu.setVisible(true);

                              Main.userLogged = usuarioDAO.cargarStatsUsuario(txtNombre.getText());

                              Menu.lblNombre.setText("Nombre: " + Main.userLogged.getNombre());
                              Menu.lblCreditos.setText(("Creditos: " + Integer.toString(Main.userLogged.getCoins())));
                              Store.lblCreditos.setText(("Creditos: " + Integer.toString(Main.userLogged.getCoins())));
                              limpiar();

                              JOptionPane.showMessageDialog(null, "Bienvenido/a, " + Main.userLogged.getNombre() + " te has logueado correctamente.");
                        }
                        case 2 -> {// Si se retorna 2 sigfinica que el nombre de usuarioDAO no se encuentra registrado en la base de datos.
                              txtInfo.setText("El usuario no está registrado");
                              txtNombre.setBackground(new Color(255, 228, 228));
                              txtPassword.setBackground(Color.WHITE);
                        }

                        case 0 -> {// Si se retorna 0 sigfinica que el nombre del usuarioDAO está en la base de datos pero la contraseña es incorrecta.
                              txtInfo.setText("La contraseña es incorrecta");
                              txtNombre.setBackground(Color.WHITE);
                              txtPassword.setBackground(new Color(255, 228, 228));
                        }
                  }
                  background.repaint();

            } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchAlgorithmException ex) {
                  Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
      }//GEN-LAST:event_btnIngresarActionPerformed

      private void btnCloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseEntered
            btnClose.setBackground(new Color(255, 85, 85, 200));
            background.repaint();
      }//GEN-LAST:event_btnCloseMouseEntered

      private void btnCloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseExited
            btnClose.setBackground(new Color(255, 85, 85, 0));
            background.repaint();
      }//GEN-LAST:event_btnCloseMouseExited

      private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
            int resp = JOptionPane.showConfirmDialog(null, "¿Realmente desea salir de la aplicación?",
               "Salir", JOptionPane.YES_NO_OPTION,
               JOptionPane.INFORMATION_MESSAGE, null);

            if (resp == 0) {
                  try {
                        usuarioDAO.cerrarSesion(Main.userLogged.getNombre());
                  } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
                        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                  }
                  System.exit(0);
            }
      }//GEN-LAST:event_btnCloseActionPerformed

      private void btnIngresarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnIngresarKeyPressed
            try {
                  // Llamamos al método Ingresar() que chequea el contenido de txtNombre y el txtPassword en la base de datos y devuelve un entero.
                  switch (usuarioDAO.ingresar(txtNombre.getText(), txtPassword.getText())) {

                        case 1 -> {  // Si se retorna 1 significa que el usuarioDAO se encuentra registrado, por lo tanto se accede a la vtnMenu.
                              this.setVisible(false);
                              Main.vtnMenu.setVisible(true);
                              Main.userLogged.setNombre(txtNombre.getText());
                              Menu.lblNombre.setText("Nombre: " + Main.userLogged.getNombre());
                              Menu.lblCreditos.setText(("Creditos: " + Integer.toString(Main.userLogged.getCoins())));
                              Store.lblCreditos.setText(("Creditos: " + Integer.toString(Main.userLogged.getCoins())));
                              limpiar();
                        }
                        case 2 -> {// Si se retorna 2 sigfinica que el nombre de usuarioDAO no se encuentra registrado en la base de datos.
                              txtInfo.setText("El usuario no está registrado");
                              txtNombre.setBackground(new Color(255, 228, 228));
                              txtPassword.setBackground(Color.WHITE);
                        }

                        case 0 -> {// Si se retorna 0 sigfinica que el nombre del usuarioDAO está en la base de datos pero la contraseña es incorrecta.
                              txtInfo.setText("La contraseña es incorrecta");
                              txtNombre.setBackground(Color.WHITE);
                              txtPassword.setBackground(new Color(255, 228, 228));
                        }
                  }
                  background.repaint();

            } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchAlgorithmException ex) {
                  Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
      }//GEN-LAST:event_btnIngresarKeyPressed

      private void lblRecuperarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRecuperarMouseClicked
            Main.vtnRecover1.setVisible(true);
            Main.vtnRecover1.limpiar();

            this.setVisible(false);
      }//GEN-LAST:event_lblRecuperarMouseClicked

//      public static void main(String args[]) {
//            try {
//                  for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                        if ("Windows".equals(info.getName())) {
//                              javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                              break;
//                        }
//                  }
//            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
//                  java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//            }
//            java.awt.EventQueue.invokeLater(new Runnable() {
//                  public void run() {
//                        new Login().setVisible(true);
//                  }
//            });
//      }

      // Variables declaration - do not modify//GEN-BEGIN:variables
      private background.Background background;
      private javax.swing.JButton btnClose;
      private javax.swing.JButton btnIngresar;
      private javax.swing.JLabel jLabel1;
      private javax.swing.JLabel jLabel2;
      private javax.swing.JLabel jLabel3;
      private javax.swing.JLabel jLabel4;
      private javax.swing.JLabel lblCrearCuenta;
      private javax.swing.JLabel lblRecuperar;
      private javax.swing.JLabel lblShowPassword;
      private javax.swing.JPanel pnlLogin;
      private javax.swing.JLabel txtInfo;
      private javax.swing.JTextField txtNombre;
      private javax.swing.JPasswordField txtPassword;
      // End of variables declaration//GEN-END:variables
}
