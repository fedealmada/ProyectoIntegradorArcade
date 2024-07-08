package recover;

import dao.UsuarioDAOImpl;
import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import main.Main;

public final class Recover_1 extends javax.swing.JFrame {
      
      UsuarioDAOImpl usuario = new UsuarioDAOImpl();
      
      public Recover_1() {
            initComponents();
            this.setResizable(false);
            this.setLocationRelativeTo(null);
            this.setDefaultCloseOperation(Recover_1.EXIT_ON_CLOSE);
            limpiar();
      }
      
      public void limpiar() {
            txtNombre.setBackground(Color.WHITE);

            
            txtInfo.setText(null);
            
            txtNombre.requestFocus();
      }
      
      @SuppressWarnings("unchecked")
      // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
      private void initComponents() {

            background = new background.Background(280, 0, 1002, 702, 400, "/background/background.png");
            pnlLogin = new javax.swing.JPanel();
            lblNombre = new javax.swing.JLabel();
            lblTituloJuego = new javax.swing.JLabel();
            lblTitulo = new javax.swing.JLabel();
            lblCrearCuenta = new javax.swing.JLabel();
            btnBuscar = new javax.swing.JButton();
            txtNombre = new javax.swing.JTextField();
            txtInfo = new javax.swing.JLabel();
            lblTengoCuenta = new javax.swing.JLabel();
            jLabel1 = new javax.swing.JLabel();
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
            lblNombre.setBounds(70, 210, 120, 16);

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
            lblTitulo.setText("Recuperar 1/3");
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
            lblCrearCuenta.setBounds(120, 570, 140, 40);

            btnBuscar.setBackground(new java.awt.Color(153, 51, 255));
            btnBuscar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
            btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
            btnBuscar.setText("Buscar");
            btnBuscar.setBorder(null);
            btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            btnBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
                  public void mouseEntered(java.awt.event.MouseEvent evt) {
                        btnBuscarMouseEntered(evt);
                  }
                  public void mouseExited(java.awt.event.MouseEvent evt) {
                        btnBuscarMouseExited(evt);
                  }
            });
            btnBuscar.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnBuscarActionPerformed(evt);
                  }
            });
            btnBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
                  public void keyPressed(java.awt.event.KeyEvent evt) {
                        btnBuscarKeyPressed(evt);
                  }
            });
            pnlLogin.add(btnBuscar);
            btnBuscar.setBounds(100, 470, 170, 50);

            txtNombre.setBorder(null);
            txtNombre.setCaretColor(new java.awt.Color(0, 0, 0));
            txtNombre.setDisabledTextColor(new java.awt.Color(255, 255, 255));
            pnlLogin.add(txtNombre);
            txtNombre.setBounds(70, 240, 240, 40);

            txtInfo.setForeground(new java.awt.Color(255, 102, 102));
            pnlLogin.add(txtInfo);
            txtInfo.setBounds(70, 300, 290, 30);

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
            lblTengoCuenta.setBounds(120, 610, 140, 40);

            jLabel1.setForeground(new java.awt.Color(204, 204, 204));
            jLabel1.setText("Introduce un nombre de usuario para buscar.");
            pnlLogin.add(jLabel1);
            jLabel1.setBounds(70, 150, 270, 30);

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

      private void btnBuscarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseEntered
            btnBuscar.setBackground(new Color(153, 51, 255).brighter());
      }//GEN-LAST:event_btnBuscarMouseEntered

      private void btnBuscarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseExited
            btnBuscar.setBackground(new Color(153, 51, 255));
      }//GEN-LAST:event_btnBuscarMouseExited

      private void lblCrearCuentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCrearCuentaMouseClicked
            Main.vtnRegister.setVisible(true);
            this.setVisible(false);
            limpiar();
      }//GEN-LAST:event_lblCrearCuentaMouseClicked

      private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
            
            try {
                  if (usuario.existeUsuario(txtNombre.getText()) == 1) {
                        this.setVisible(false);
                        Main.vtnRecover1.limpiar();
                        
                        
                        Main.vtnRecover2.setVisible(true);
                        Main.vtnRecover2.limpiar();
                        Main.vtnRecover2.setRecovery(txtNombre.getText());
                        System.out.println(txtNombre.getText());
                        
                  } else {
                        txtInfo.setText("Este usuario no se ha encontrado.");
                  }
                  
                  background.repaint();
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
                  Logger.getLogger(Recover_1.class.getName()).log(Level.SEVERE, null, ex);
            }
      }//GEN-LAST:event_btnBuscarActionPerformed

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

      private void btnBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnBuscarKeyPressed
            
            try {
                  if (usuario.existeUsuario(txtNombre.getText()) == 1) {
                        this.setVisible(false);
                        Main.vtnRecover1.limpiar();
                        
                        Main.vtnRecover2.setVisible(true);
                        Main.vtnRecover2.limpiar();
                        Main.vtnRecover2.setRecovery(txtNombre.getText());
                        
                  } else {
                        txtInfo.setText("Este usuario no se ha encontrado.");
                  }
                  
                  background.repaint();
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
                  Logger.getLogger(Recover_1.class.getName()).log(Level.SEVERE, null, ex);
            }
      }//GEN-LAST:event_btnBuscarKeyPressed

      private void lblTengoCuentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTengoCuentaMouseClicked
            Main.vtnLogin.setVisible(true);
            this.setVisible(false);
            limpiar();
      }//GEN-LAST:event_lblTengoCuentaMouseClicked
     

      // Variables declaration - do not modify//GEN-BEGIN:variables
      private background.Background background;
      private javax.swing.JButton btnBuscar;
      private javax.swing.JButton btnClose;
      private javax.swing.JLabel jLabel1;
      private javax.swing.JLabel lblCrearCuenta;
      private javax.swing.JLabel lblNombre;
      private javax.swing.JLabel lblTengoCuenta;
      private javax.swing.JLabel lblTitulo;
      private javax.swing.JLabel lblTituloJuego;
      private javax.swing.JPanel pnlLogin;
      private javax.swing.JLabel txtInfo;
      public static javax.swing.JTextField txtNombre;
      // End of variables declaration//GEN-END:variables
}
