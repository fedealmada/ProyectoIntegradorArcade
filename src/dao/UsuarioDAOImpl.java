package dao;

import connectors.Conexion;
import entities.Usuario;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import interfaces.IUsuarioDAO;
import main.Main;

public class UsuarioDAOImpl implements IUsuarioDAO {

      private boolean debug;

      public UsuarioDAOImpl() {
            debug = true;
      }

      public Usuario cargarStatsUsuario(String nombre) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
            Connection unaConexion = Conexion.obtenerConexion();
            String unaConsulta = "SELECT * FROM users WHERE name = '" + nombre + "'";
            if (debug) {
                  System.out.println("[DEBUG-USUARIO] " + unaConsulta);
            }
            Statement unaSentencia = unaConexion.createStatement();

            ResultSet unResultado = unaSentencia.executeQuery(unaConsulta);

            Usuario usuario = new Usuario();

            if (unResultado.next()) {
                  usuario.setNombre(unResultado.getString("name"));
                  usuario.setAnswer(unResultado.getString("answer"));
                  usuario.setCoins(unResultado.getInt("coins"));
                  usuario.setScorePacman(unResultado.getInt("scorePacman"));
                  usuario.setScoreTateti(unResultado.getInt("scoreTateti"));
                  usuario.setScoreTetris(unResultado.getInt("scoreTetris"));
                  usuario.setScoreBreakout(unResultado.getInt("scoreAtari"));
                  usuario.setRegisterDate(unResultado.getString("registrationDate"));
                  usuario.setQuestionIndex(unResultado.getInt("question"));
                  if (unResultado.getInt("logged") == 1) {
                        usuario.setLogged(true);
                  } else {
                        usuario.setLogged(false);
                  }

                  usuario.setPassword(unResultado.getString("password"));
                  usuario.setLastLoginDate(unResultado.getString("lastLoginDate"));
            }

            return usuario;
      }

      public String getRespuesta(String nombre) throws ClassNotFoundException, InstantiationException, InstantiationException, IllegalAccessException, SQLException {
            Connection unaConexion = Conexion.obtenerConexion();
            String unaConsulta = "SELECT answer FROM users WHERE name = '" + nombre + "'";
            if (debug) {
                  System.out.println("[DEBUG-USUARIO] " + unaConsulta);
            }
            Statement unaSentencia = unaConexion.createStatement();

            ResultSet unResultado = unaSentencia.executeQuery(unaConsulta);

            String respuesta = null;

            if (unResultado.next()) {
                  respuesta = unResultado.getString("answer");
            }

            return respuesta;
      }

      public String getTextoPregunta(String nombre) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {

            Connection unaConexion = Conexion.obtenerConexion();

            String unaConsulta = "SELECT name, question FROM users WHERE name = '" + nombre + "'";
            if (debug) {
                  System.out.println("[DEBUG-USUARIO] " + unaConsulta);
            }

            Statement unaSentencia = unaConexion.createStatement();

            ResultSet unResultado = unaSentencia.executeQuery(unaConsulta);

            int questionIndex = 0;

            if (unResultado.next()) {
                  questionIndex = unResultado.getInt("question");
            }

            String textoPregunta = switch (questionIndex) {
                  case 1 ->
                        "¿Cuál es tu pelicula favorita?";
                  case 2 ->
                        "¿Cuál es tu galletita favorita?";
                  case 3 ->
                        "¿Cómo se llama tu mascota?";

                  default ->
                        null;
            };

            unaConexion.close();
            return textoPregunta;

      }

      public int existeUsuario(String nombre) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {

            Connection unaConexion = Conexion.obtenerConexion();

            String unaConsulta = "SELECT name FROM users WHERE name = '" + nombre + "'";
            if (debug) {
                  System.out.println("[DEBUG-USUARIO] " + unaConsulta);
            }
            Statement unaSentencia = unaConexion.createStatement();

            ResultSet unResultado = unaSentencia.executeQuery(unaConsulta);

            if (unResultado.next()) {
                  unaConexion.close();
                  return 1;
            } else {
                  unaConexion.close();
                  return 0;

            }
      }

      @Override
      public ArrayList<Usuario> consultarTodos() {
            Connection unaConexion = null;
            ArrayList<Usuario> lista = new ArrayList<>();
            try {
                  unaConexion = Conexion.obtenerConexion();
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
                  Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                  Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }

            String unaConsulta = "SELECT * FROM users";
            if (debug) {
                  System.out.println("[DEBUG-USUARIO] " + unaConsulta);
            }

            Statement unaSentencia = null;
            try {
                  unaSentencia = unaConexion.createStatement();
            } catch (SQLException ex) {
                  Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }

            ResultSet unResultado = null;
            try {
                  unResultado = unaSentencia.executeQuery(unaConsulta);
            } catch (SQLException ex) {
                  Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                  while (unResultado.next()) {
                        System.out.println("Nombre: " + unResultado.getString("name"));
                        System.out.println("Password cifrada: " + unResultado.getInt("password"));
                        System.out.println("--------------------------------");
                  }
            } catch (SQLException ex) {
                  Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                  unaConexion.close();
            } catch (SQLException ex) {
                  Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            return lista;

      }

      @Override
      public void consultarUno(String nombre) {
            Connection unaConexion = null;
            try {
                  unaConexion = Conexion.obtenerConexion();
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
                  Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }

            String unaConsulta = "SELECT * FROM users WHERE name = '" + nombre + "'";

            Statement unaSentencia = null;
            try {
                  unaSentencia = unaConexion.createStatement();
            } catch (SQLException ex) {
                  Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }

            ResultSet unResultado = null;
            try {
                  unResultado = unaSentencia.executeQuery(unaConsulta);
            } catch (SQLException ex) {
                  Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                  if (unResultado.next()) {
                        System.out.println("Nombre: " + unResultado.getString("nombre"));
                        System.out.println("Password cifrada: " + unResultado.getInt("password"));
                        System.out.println("--------------------------------");
                  }
            } catch (SQLException ex) {
                  Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                  unaConexion.close();
            } catch (SQLException ex) {
                  Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }

      }

      @Override
      public void insertar(Usuario u) {
            Connection unaConexion = null;
            try {
                  unaConexion = Conexion.obtenerConexion();
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
                  Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }

            String unaInsercion = "INSERT INTO users (name, password, question, answer, registrationDate, lastLoginDate) VALUES (?, ?, ?, ?, now(), now())";

            PreparedStatement unaSentencia = null;
            try {
                  unaSentencia = unaConexion.prepareStatement(unaInsercion);
            } catch (SQLException ex) {
                  Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                  unaSentencia.setString(1, u.getNombre());
            } catch (SQLException ex) {
                  Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                  unaSentencia.setString(2, u.getPassword());
            } catch (SQLException ex) {
                  Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                  unaSentencia.setInt(3, u.getQuestionIndex());
            } catch (SQLException ex) {
                  Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                  unaSentencia.setString(4, u.getAnswer());
            } catch (SQLException ex) {
                  Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                  unaSentencia.execute();
            } catch (SQLException ex) {
                  Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println("Insercion correcta");

            try {
                  unaConexion.close();
            } catch (SQLException ex) {
                  Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
      }

      public void actualizarPassword(String password, String nombre) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
            Connection unaConexion = null;

            unaConexion = Conexion.obtenerConexion();

            String unaActualizacion = "UPDATE users SET password  = '" + password + "' WHERE name = " + "'" + nombre + "'";

            PreparedStatement unaSentencia = unaConexion.prepareStatement(unaActualizacion);

            unaSentencia.execute();

      }

      public void actualizarCampo(String campo, int dato) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
            Connection unaConexion = null;

            unaConexion = Conexion.obtenerConexion();

            String unaActualizacion = "UPDATE users SET " + campo + " = '" + dato + "' WHERE name = " + "'" + Main.userLogged.getNombre() + "'";
            System.out.println("[DEBUG-USUARIO] " + unaActualizacion);

            PreparedStatement unaSentencia = unaConexion.prepareStatement(unaActualizacion);

            unaSentencia.execute();

      }

      @Override
      public void actualizar(String nombreAnterior, String nombreNuevo) {
            Connection unaConexion = null;
            try {
                  unaConexion = Conexion.obtenerConexion();
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
                  Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }

            String unaActualizacion = "UPDATE users SET name = ? WHERE name = ?";

            PreparedStatement unaSentencia = null;
            try {
                  unaSentencia = unaConexion.prepareStatement(unaActualizacion);
            } catch (SQLException ex) {
                  Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                  unaSentencia.setString(1, nombreNuevo);
            } catch (SQLException ex) {
                  Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                  unaSentencia.setString(2, nombreAnterior);
            } catch (SQLException ex) {
                  Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                  unaSentencia.execute();
            } catch (SQLException ex) {
                  Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println("Actualizacion correcta");

            try {
                  unaConexion.close();
            } catch (SQLException ex) {
                  Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }

      }

      @Override
      public void eliminar(String nombre) {
            Connection unaConexion = null;
            try {
                  unaConexion = Conexion.obtenerConexion();
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
                  Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }

            String unaEliminacion = "DELETE FROM users WHERE name = ?";

            PreparedStatement unaSentencia = null;
            try {
                  unaSentencia = unaConexion.prepareStatement(unaEliminacion);
            } catch (SQLException ex) {
                  Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                  unaSentencia.setString(1, nombre);
            } catch (SQLException ex) {
                  Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                  unaSentencia.execute();
            } catch (SQLException ex) {
                  Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println("Eliminacion correcta");

            try {
                  unaConexion.close();
            } catch (SQLException ex) {
                  Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }

      }

      @Override
      public ArrayList<Usuario> cargarLista() {
            ArrayList<Usuario> lista = new ArrayList<Usuario>();

            Connection unaConexion = null;
            try {
                  unaConexion = Conexion.obtenerConexion();
            } catch (ClassNotFoundException ex) {
                  Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                  Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                  Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                  Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }

            String unaConsulta = "SELECT * FROM users";

            Statement unaSentencia = null;
            try {
                  unaSentencia = unaConexion.createStatement();
            } catch (SQLException ex) {
                  Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }

            ResultSet unResultado = null;
            try {
                  unResultado = unaSentencia.executeQuery(unaConsulta);
            } catch (SQLException ex) {
                  Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                  while (unResultado.next()) {
                        Usuario a = new Usuario();
                        lista.add(a);
                  }
            } catch (SQLException ex) {
                  Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                  unaConexion.close();
            } catch (SQLException ex) {
                  Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }

            return lista;
      }

      public ArrayList<Usuario> consultarLeaderboard(String tipo) {
            Connection unaConexion = null;
            ArrayList<Usuario> lista = new ArrayList<>();
            try {
                  unaConexion = Conexion.obtenerConexion();
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
                  Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }

            String unaConsulta = "SELECT * FROM users WHERE " + tipo + "  >= 0 ORDER BY " + tipo + " DESC";
            if (debug) {
                  System.out.println("[DEBUG-USUARIO] " + unaConsulta);
            }

            Statement unaSentencia = null;

            try {
                  unaSentencia = unaConexion.createStatement();
            } catch (SQLException ex) {
                  Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }

            ResultSet unResultado = null;
            try {
                  unResultado = unaSentencia.executeQuery(unaConsulta);
            } catch (SQLException ex) {
                  Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                  while (unResultado.next()) {
                        Usuario usuario = new Usuario();
                        usuario.setNombre(unResultado.getString("name"));
                        usuario.setScorePacman(unResultado.getInt("scorePacman"));
                        usuario.setScoreTetris(unResultado.getInt("scoreTetris"));
                        usuario.setScoreTateti(unResultado.getInt("scoreTateti"));
                        usuario.setScoreBreakout(unResultado.getInt("scoreAtari"));
                        usuario.setLastLoginDate(unResultado.getString("lastLoginDate"));
                        usuario.setRegisterDate(unResultado.getString("registrationDate"));
                        int value = unResultado.getInt("logged");
                        if (value == 1) {
                              usuario.setLogged(true);
                        } else {
                              usuario.setLogged(false);
                        }

                        lista.add(usuario);
                  }
            } catch (SQLException ex) {
                  Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                  unaConexion.close();
            } catch (SQLException ex) {
                  Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            return lista;

      }

      public int registrarse(String nombre, String password, String confirmarPassword, int preguntaIndex, String respuesta) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
            // Chequeamos si el nombre ingresado tiene más de 4 caracteres.
            if (nombre.length() < 3) {
                  return 2;
            }

            // Chequeamos si la contraseña ingresada tiene más de 4 caracteres.
            if (password.length() < 4) {
                  return 3;
            }

            // Chequeamos si la contraseña confirmada coincide con la contraseña.
            if (!password.equals(confirmarPassword)) {
                  return 4;
            }

            // Chequeamos si la pregunta seleccionada no es la opción por defecto (Seleccione una pregunta).
            if (preguntaIndex == 0) {
                  return 6;
            }

            // Chequeamos que la respuesta no sea una cadena vacía.
            if (respuesta.length() < 1) {
                  return 5;
            }

            // Inicializamos una conexión para la base de datos.
            Connection unaConexion = Conexion.obtenerConexion();
            String unaConsulta = "SELECT * FROM users WHERE name = '" + nombre + "';";
            if (debug) {
                  System.out.println("[DEBUG-USUARIO] " + unaConsulta);
            }
            Statement unaSentencia = unaConexion.createStatement();
            ResultSet unResultado = unaSentencia.executeQuery(unaConsulta);

            if (unResultado.next()) {
                  unaConexion.close();
                  unaSentencia.close();
                  unResultado.close();
                  return 0;
            } else {
                  // Hasheamos la contraseña y la pregunta de seguridad para almacenarlas en la base de datos.
                  String passwordHash = cifrar(password);
                  String respuestaHash = cifrar(respuesta);

                  Usuario u = new Usuario();
                  u.setNombre(nombre);
                  u.setPassword(passwordHash);
                  u.setQuestionIndex(preguntaIndex);
                  u.setAnswer(respuestaHash);

                  insertar(u);
                  unaConexion.close();
                  unaSentencia.close();
                  unResultado.close();
                  return 1;
            }
      }

      public int ingresar(String nombre, String password) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchAlgorithmException {
            Connection unaConexion = Conexion.obtenerConexion();

            String unaConsulta = "SELECT name, password FROM users WHERE name = '" + nombre + "';";
            if (debug) {
                  System.out.println("[DEBUG-USUARIO] " + unaConsulta);
            }

            Statement unaSentencia = unaConexion.createStatement();
            ResultSet unResultado = unaSentencia.executeQuery(unaConsulta);

            String passwordHash = cifrar(password);
            if (unResultado.next()) {
                  String passwordDatabase = unResultado.getString("password");
                  if (passwordHash.equals(passwordDatabase)) {
                        // Actualizo la última conexión del usuario
                        String unaUpdate = "UPDATE users SET lastLoginDate = now(), logged = 1 WHERE name = ?";
                        if (debug) {
                              System.out.println("[DEBUG-USUARIO] " + unaUpdate);
                        }

                        PreparedStatement sentencia = unaConexion.prepareStatement(unaUpdate);
                        sentencia.setString(1, nombre);
                        sentencia.execute();

                        unaConexion.close();
                        unaSentencia.close();
                        return 1;
                  } else {
                        unaConexion.close();
                        unaSentencia.close();
                        return 0;
                  }
            } else {
                  unaConexion.close();
                  unaSentencia.close();
                  return 2;
            }
      }

      public void cerrarSesion(String nombre) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
            try (Connection unaConexion = Conexion.obtenerConexion()) {
                  String unaUpdate = "UPDATE users SET logged = 0 WHERE name = ?";
                  if (debug) {
                        System.out.println("[DEBUG-USUARIO] " + unaUpdate);
                  }

                  try (PreparedStatement sentencia = unaConexion.prepareStatement(unaUpdate)) {
                        sentencia.setString(1, nombre);

                        sentencia.execute();
                  }
            }
      }

      public String cifrar(final String data) {
            try {
                  final byte[] hash = MessageDigest.getInstance("SHA-256").digest(data.getBytes(StandardCharsets.UTF_8));
                  final StringBuilder hashStr = new StringBuilder(hash.length);

                  for (byte hashByte : hash) {
                        hashStr.append(Integer.toHexString(255 & hashByte));
                  }

                  return hashStr.toString();
            } catch (NoSuchAlgorithmException e) {
                  return null;
            }
      }
}


/*    
Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex); es 
una instrucción típica en Java utilizada para registrar un mensaje de error en un 
archivo de registro o en la consola utilizando el sistema de registro incorporado 
de Java, conocido como el framework de registro Java Logging API (también conocido 
como java.util.logging).


Logger.getLogger(UsuarioDAOImpl.class.getName()): Esta parte obtiene una instancia 
del objeto Logger asociado a la clase UsuarioDAOImpl. El Logger es responsable de 
gestionar y registrar mensajes de registro.

.log(Level.SEVERE, null, ex): Aquí se llama al método log del objeto Logger para 
registrar un mensaje. Level.SEVERE indica que se está registrando un mensaje de 
nivel "severo" o de error. Este nivel se utiliza para mensajes de error críticos.

null: El segundo argumento es el identificador del recurso asociado con el mensaje 
de registro. En este caso, se pasa null para indicar que no hay recurso específico 
relacionado con el mensaje.

ex: El tercer argumento es el objeto Throwable (por lo general, una excepción) que 
se registra junto con el mensaje. Esto permite registrar información detallada sobre 
una excepción que ocurrió.

En resumen, esta línea de código se utiliza para registrar un mensaje de error 
(nivel "SEVERE") junto con detalles de una excepción (ex) en el registro de la 
aplicación, que puede ser útil para el diagnóstico y la depuración de problemas. 
El registro es una práctica común en el desarrollo de aplicaciones para ayudar a 
los desarrolladores a rastrear y solucionar problemas.

 */
