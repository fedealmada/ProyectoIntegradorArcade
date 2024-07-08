package interfaces;

import entities.Item;
import java.util.ArrayList;

public interface IItemDAO {

      ArrayList<Item> consultarTodos();

      void consultarUno(String nombre);

      void insertar(Item item);

      void eliminar(String nombre);

      void actualizar(String nombreAnterior, String nombreNuevo);

      ArrayList<Item> cargarLista();
}
