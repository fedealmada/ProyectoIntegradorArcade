package dao;

import connectors.Conexion;
import entities.Item;
import interfaces.IItemDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ItemDAOImpl implements IItemDAO {
      private boolean debug;
      
      public ItemDAOImpl() {
            debug = true;
      }
      
      @Override
      public ArrayList<Item> consultarTodos() {
            return null;
      }

      @Override
      public void consultarUno(String nombre) {
      }

      @Override
      public void insertar(Item item) {
      }

      @Override
      public void eliminar(String nombre) {
      }

      @Override
      public void actualizar(String nombreAnterior, String nombreNuevo) {
      }

      @Override
      public ArrayList<Item> cargarLista() {
            return null;
      }
      
      public ArrayList<Item> consultarTablaItem(String campo) {
            Connection unaConexion = null;
            ArrayList<Item> lista = new ArrayList<>();
            try {
                  unaConexion = Conexion.obtenerConexion();
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
                  Logger.getLogger(ItemDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }

            String unaConsulta = "SELECT * FROM items WHERE type = '" + campo + "' ORDER BY price DESC";
            System.out.println("[DEBUG-ITEM] " + unaConsulta);
            Statement unaSentencia = null;

            try {
                  unaSentencia = unaConexion.createStatement();
            } catch (SQLException ex) {
                  Logger.getLogger(ItemDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }

            ResultSet unResultado = null;
            try {
                  unResultado = unaSentencia.executeQuery(unaConsulta);
            } catch (SQLException ex) {
                  Logger.getLogger(ItemDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                  while (unResultado.next()) {
                        Item item = new Item();
                        item.setCategoria(unResultado.getString("type"));
                        item.setNombre(unResultado.getString("name"));
                        item.setId(unResultado.getInt("id"));
                        item.setPrecio(unResultado.getInt("price"));
                        lista.add(item);
                  }
            } catch (SQLException ex) {
                  Logger.getLogger(ItemDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                  unaConexion.close();
            } catch (SQLException ex) {
                  Logger.getLogger(ItemDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            return lista;

      }

}
