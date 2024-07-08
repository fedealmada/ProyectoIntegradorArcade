package store;

import dao.ItemDAOImpl;
import dao.UsuarioDAOImpl;
import entities.Item;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import main.Main;
import menu.Menu;

public final class Store extends javax.swing.JFrame {

      UsuarioDAOImpl usuarioDAO = new UsuarioDAOImpl();
      ItemDAOImpl itemDAO = new ItemDAOImpl();

      ArrayList<Item> listaItems;
      TableModel modeloDatos;

      public Store() {
            initComponents();
            this.setResizable(false);

            // Agrupamos los radioButtons.
            buttonGroup1.add(rbtnBebidas);
            buttonGroup1.add(rbtnComidas);
            buttonGroup1.add(rbtnElectronicos);
            buttonGroup1.add(rbtnServicios);

            getContentPane().setBackground(new Color(30, 30, 30));
            tableDark1.fixTable(jScrollPane1);

            // Inicializamos la lista de Items.
            listaItems = new ArrayList<>();

            // Cargamos la lista de Items utilizando el método consultarTablaItem del itemDAO.
            // Por defecto mostramos el contenido de la categoría bebidas.
            listaItems = itemDAO.consultarTablaItem("comidas");

            final String[] columnas = {"Item", "Precio (Creditos)"};

            //Inicializamos el modelo o handler de la tabla.
            modeloDatos = new DefaultTableModel(columnas, listaItems.size());

            // Recorremos la lista de Items y asignamos los valores al modelo.
            for (int i = 0; i < listaItems.size(); i++) {
                  Item item = listaItems.get(i);
                  modeloDatos.setValueAt(item.getNombre(), i, 0);
                  modeloDatos.setValueAt(item.getPrecio(), i, 1);
            }

            lblCreditos.setText("Creditos: " + Integer.toString(Main.userLogged.getCoins()));

            // Seteamos el modelo a la tabla.
            tableDark1.setModel(modeloDatos);
            background.repaint();
      }

      // Método que carga la tabla en función de la categoria que recibe por parametro.
      public void loadTable(String categoria) {
            listaItems.clear();
            listaItems = itemDAO.consultarTablaItem(categoria);
            final String[] columnas = {"Nombre", "Precio (Creditos)"};

            modeloDatos = new DefaultTableModel(columnas, listaItems.size());

            for (int i = 0; i < listaItems.size(); i++) {
                  Item item = listaItems.get(i);
                  modeloDatos.setValueAt(item.getNombre(), i, 0);
                  modeloDatos.setValueAt(item.getPrecio(), i, 1);
            }

            tableDark1.setModel(modeloDatos);

            background.repaint();
      }

      @SuppressWarnings("unchecked")
      // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
      private void initComponents() {

            buttonGroup1 = new javax.swing.ButtonGroup();
            background = new background.Background(50, 50, 1002, 602, 902, "/background/background.png");
            btnClose = new javax.swing.JButton();
            jPanel1 = new javax.swing.JPanel();
            lblTitulo = new javax.swing.JLabel();
            btnComprar = new javax.swing.JButton();
            jScrollPane1 = new javax.swing.JScrollPane();
            tableDark1 = new utilities.TableDark();
            rbtnServicios = new javax.swing.JRadioButton();
            rbtnComidas = new javax.swing.JRadioButton();
            rbtnBebidas = new javax.swing.JRadioButton();
            rbtnElectronicos = new javax.swing.JRadioButton();
            lblCategorias = new javax.swing.JLabel();
            btnRegresar = new javax.swing.JButton();
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

            jPanel1.setBackground(new java.awt.Color(16, 16, 21, 135));
            jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            lblTitulo.setBackground(new java.awt.Color(0, 0, 0));
            lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
            lblTitulo.setForeground(new java.awt.Color(204, 51, 255));
            lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lblTitulo.setText("TIENDA");
            lblTitulo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            jPanel1.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 300, 80));

            btnComprar.setBackground(new java.awt.Color(153, 102, 255));
            btnComprar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
            btnComprar.setForeground(new java.awt.Color(255, 255, 255));
            btnComprar.setText("Comprar");
            btnComprar.setBorder(null);
            btnComprar.setBorderPainted(false);
            btnComprar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            btnComprar.setFocusable(false);
            btnComprar.addMouseListener(new java.awt.event.MouseAdapter() {
                  public void mouseEntered(java.awt.event.MouseEvent evt) {
                        btnComprarMouseEntered(evt);
                  }
                  public void mouseExited(java.awt.event.MouseEvent evt) {
                        btnComprarMouseExited(evt);
                  }
            });
            btnComprar.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnComprarActionPerformed(evt);
                  }
            });
            jPanel1.add(btnComprar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 540, 140, 50));

            tableDark1.setModel(new javax.swing.table.DefaultTableModel(
                  new Object [][] {

                  },
                  new String [] {

                  }
            ));
            tableDark1.setAutoscrolls(false);
            tableDark1.setFocusable(false);
            tableDark1.setGridColor(new java.awt.Color(30, 30, 30));
            jScrollPane1.setViewportView(tableDark1);

            jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 620, 400));

            rbtnServicios.setForeground(new java.awt.Color(204, 204, 204));
            rbtnServicios.setText("Servicios");
            rbtnServicios.setContentAreaFilled(false);
            rbtnServicios.setFocusPainted(false);
            rbtnServicios.setFocusable(false);
            rbtnServicios.addMouseListener(new java.awt.event.MouseAdapter() {
                  public void mouseEntered(java.awt.event.MouseEvent evt) {
                        rbtnServiciosMouseEntered(evt);
                  }
                  public void mouseExited(java.awt.event.MouseEvent evt) {
                        rbtnServiciosMouseExited(evt);
                  }
            });
            rbtnServicios.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        rbtnServiciosActionPerformed(evt);
                  }
            });
            jPanel1.add(rbtnServicios, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, -1, -1));

            rbtnComidas.setForeground(new java.awt.Color(204, 204, 204));
            rbtnComidas.setSelected(true);
            rbtnComidas.setText("Comidas");
            rbtnComidas.setContentAreaFilled(false);
            rbtnComidas.setFocusable(false);
            rbtnComidas.addMouseListener(new java.awt.event.MouseAdapter() {
                  public void mouseEntered(java.awt.event.MouseEvent evt) {
                        rbtnComidasMouseEntered(evt);
                  }
                  public void mouseExited(java.awt.event.MouseEvent evt) {
                        rbtnComidasMouseExited(evt);
                  }
            });
            rbtnComidas.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        rbtnComidasActionPerformed(evt);
                  }
            });
            jPanel1.add(rbtnComidas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

            rbtnBebidas.setForeground(new java.awt.Color(204, 204, 204));
            rbtnBebidas.setText("Bebidas");
            rbtnBebidas.setContentAreaFilled(false);
            rbtnBebidas.setFocusPainted(false);
            rbtnBebidas.setFocusable(false);
            rbtnBebidas.addMouseListener(new java.awt.event.MouseAdapter() {
                  public void mouseEntered(java.awt.event.MouseEvent evt) {
                        rbtnBebidasMouseEntered(evt);
                  }
                  public void mouseExited(java.awt.event.MouseEvent evt) {
                        rbtnBebidasMouseExited(evt);
                  }
            });
            rbtnBebidas.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        rbtnBebidasActionPerformed(evt);
                  }
            });
            jPanel1.add(rbtnBebidas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, -1));

            rbtnElectronicos.setForeground(new java.awt.Color(204, 204, 204));
            rbtnElectronicos.setText("Electrónicos");
            rbtnElectronicos.setContentAreaFilled(false);
            rbtnElectronicos.setFocusPainted(false);
            rbtnElectronicos.setFocusable(false);
            rbtnElectronicos.addMouseListener(new java.awt.event.MouseAdapter() {
                  public void mouseEntered(java.awt.event.MouseEvent evt) {
                        rbtnElectronicosMouseEntered(evt);
                  }
                  public void mouseExited(java.awt.event.MouseEvent evt) {
                        rbtnElectronicosMouseExited(evt);
                  }
            });
            rbtnElectronicos.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        rbtnElectronicosActionPerformed(evt);
                  }
            });
            jPanel1.add(rbtnElectronicos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, -1));

            lblCategorias.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
            lblCategorias.setForeground(new java.awt.Color(204, 204, 204));
            lblCategorias.setText("Seleccione categoría");
            jPanel1.add(lblCategorias, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

            btnRegresar.setBackground(new java.awt.Color(153, 102, 255));
            btnRegresar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
            btnRegresar.setForeground(new java.awt.Color(255, 255, 255));
            btnRegresar.setText("Atrás");
            btnRegresar.setBorder(null);
            btnRegresar.setBorderPainted(false);
            btnRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            btnRegresar.setFocusable(false);
            btnRegresar.addMouseListener(new java.awt.event.MouseAdapter() {
                  public void mouseEntered(java.awt.event.MouseEvent evt) {
                        btnRegresarMouseEntered(evt);
                  }
                  public void mouseExited(java.awt.event.MouseEvent evt) {
                        btnRegresarMouseExited(evt);
                  }
            });
            btnRegresar.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnRegresarActionPerformed(evt);
                  }
            });
            jPanel1.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 540, 140, 50));

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

      private void btnComprarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnComprarMouseEntered
            btnComprar.setBackground(new Color(153, 51, 255).brighter());
            background.repaint();
      }//GEN-LAST:event_btnComprarMouseEntered

      private void btnComprarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnComprarMouseExited
            btnComprar.setBackground(new Color(153, 51, 255));
            background.repaint();
      }//GEN-LAST:event_btnComprarMouseExited

      private void btnComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprarActionPerformed
            int resp;

            int row = tableDark1.getSelectedRow();

            if (row != -1) {
                  if (rbtnComidas.isSelected() || rbtnBebidas.isSelected() || rbtnElectronicos.isSelected() || rbtnServicios.isSelected()) {

                        String item = (String) modeloDatos.getValueAt(row, 0);
                        int precio = (int) modeloDatos.getValueAt(row, 1);

                        resp = JOptionPane.showConfirmDialog(null, "¿Desea comprar el item " + item + " por el precio de " + precio + " creditos?",
                           "Comprar", JOptionPane.YES_NO_OPTION,
                           JOptionPane.INFORMATION_MESSAGE, null);

                        if (resp == JOptionPane.YES_OPTION) {

                              int valor = (int) modeloDatos.getValueAt(row, 1);
                              int creditos = Main.userLogged.getCoins();

                              if (creditos > valor) { // SI le alcanza para comprarse un item

                                    JOptionPane.showMessageDialog(null, "Compraste el item" + item + " por el valor de " + precio + " creditos.");

                                    // Seteamos el nuevo valor de los Creditos
                                    Main.userLogged.setCoins(Main.userLogged.getCoins() - valor);
                                    try {
                                          // Actualizamos el campo de Creditos en la base de datos
                                          usuarioDAO.actualizarCampo("coins", Main.userLogged.getCoins());
                                    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
                                          Logger.getLogger(Store.class.getName()).log(Level.SEVERE, null, ex);
                                    }

                                    // Actualizamos los labels
                                    Menu.lblCreditos.setText("Creditos: " + Main.userLogged.getCoins());
                                    Store.lblCreditos.setText("Creditos: " + Main.userLogged.getCoins());

                              } else {
                                    int resta = (int) modeloDatos.getValueAt(row, 1) - Main.userLogged.getCoins();
                                    JOptionPane.showMessageDialog(null, "No tienes suficientes creditos.\nTe faltan: " + resta + " creditos.");
                              }
                        } else {
                              JOptionPane.showMessageDialog(null, "Cancelaste la compra");
                        }
                  }

            }

      }//GEN-LAST:event_btnComprarActionPerformed

      private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
            int resp = JOptionPane.showConfirmDialog(null, "¿Realmente desea salir de la aplicación?",
               "Salir", JOptionPane.YES_NO_OPTION,
               JOptionPane.INFORMATION_MESSAGE, null);

            if (resp == 0) {
                  try {
                        usuarioDAO.cerrarSesion(Main.userLogged.getNombre());
                  } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
                        Logger.getLogger(Store.class.getName()).log(Level.SEVERE, null, ex);
                  }
                  System.exit(0);
            }
      }//GEN-LAST:event_btnCloseActionPerformed

      private void rbtnServiciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnServiciosActionPerformed
            loadTable("servicios");
      }//GEN-LAST:event_rbtnServiciosActionPerformed

      private void rbtnBebidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnBebidasActionPerformed
            loadTable("bebidas");
      }//GEN-LAST:event_rbtnBebidasActionPerformed

      private void rbtnElectronicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnElectronicosActionPerformed
            loadTable("electronicos");
      }//GEN-LAST:event_rbtnElectronicosActionPerformed

      private void btnRegresarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegresarMouseEntered
            btnRegresar.setBackground(new Color(153, 51, 255).brighter());
            background.repaint();
      }//GEN-LAST:event_btnRegresarMouseEntered

      private void btnRegresarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegresarMouseExited
            btnRegresar.setBackground(new Color(153, 51, 255));
            background.repaint();
      }//GEN-LAST:event_btnRegresarMouseExited

      private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
            Main.vtnMenu.setVisible(true);
            this.setVisible(false);
      }//GEN-LAST:event_btnRegresarActionPerformed

      private void rbtnComidasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbtnComidasMouseEntered
            background.repaint();
      }//GEN-LAST:event_rbtnComidasMouseEntered

      private void rbtnComidasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbtnComidasMouseExited
            background.repaint();
      }//GEN-LAST:event_rbtnComidasMouseExited

      private void rbtnBebidasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbtnBebidasMouseEntered
            background.repaint();
      }//GEN-LAST:event_rbtnBebidasMouseEntered

      private void rbtnBebidasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbtnBebidasMouseExited
            background.repaint();
      }//GEN-LAST:event_rbtnBebidasMouseExited

      private void rbtnServiciosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbtnServiciosMouseEntered
            background.repaint();
      }//GEN-LAST:event_rbtnServiciosMouseEntered

      private void rbtnServiciosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbtnServiciosMouseExited
            background.repaint();
      }//GEN-LAST:event_rbtnServiciosMouseExited

      private void rbtnElectronicosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbtnElectronicosMouseEntered
            background.repaint();
      }//GEN-LAST:event_rbtnElectronicosMouseEntered

      private void rbtnElectronicosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbtnElectronicosMouseExited
            background.repaint();
      }//GEN-LAST:event_rbtnElectronicosMouseExited

      private void rbtnComidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnComidasActionPerformed
            loadTable("comidas");
      }//GEN-LAST:event_rbtnComidasActionPerformed

      public static void main(String args[]) {
            try {
                  for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                        if ("Metal".equals(info.getName())) {
                              javax.swing.UIManager.setLookAndFeel(info.getClassName());
                              break;
                        }
                  }
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
                  java.util.logging.Logger.getLogger(Store.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            java.awt.EventQueue.invokeLater(new Runnable() {
                  public void run() {
                        new Store().setVisible(true);
                  }
            });
      }

      // Variables declaration - do not modify//GEN-BEGIN:variables
      private background.Background background;
      private javax.swing.JButton btnClose;
      private javax.swing.JButton btnComprar;
      private javax.swing.JButton btnRegresar;
      private javax.swing.ButtonGroup buttonGroup1;
      private javax.swing.JPanel jPanel1;
      private javax.swing.JScrollPane jScrollPane1;
      private javax.swing.JLabel lblCategorias;
      public static javax.swing.JLabel lblCreditos;
      private javax.swing.JLabel lblTitulo;
      private javax.swing.JRadioButton rbtnBebidas;
      private javax.swing.JRadioButton rbtnComidas;
      private javax.swing.JRadioButton rbtnElectronicos;
      private javax.swing.JRadioButton rbtnServicios;
      private utilities.TableDark tableDark1;
      // End of variables declaration//GEN-END:variables
}
