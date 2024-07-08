package interfaces;

import entities.Usuario;
import java.util.ArrayList;

public interface IUsuarioDAO {

      ArrayList<Usuario> consultarTodos();

      void consultarUno(String nombre);

      void insertar(Usuario usuario);

      void eliminar(String nombre);

      void actualizar(String nombreAnterior, String nombreNuevo);

      ArrayList<Usuario> cargarLista();
}
