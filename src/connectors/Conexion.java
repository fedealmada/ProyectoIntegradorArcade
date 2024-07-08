package connectors;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

      public static Connection obtenerConexion() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
            String driver = "com.mysql.cj.jdbc.Driver";

            // Creamos el objeto de la clase Driver por API Reflection
            Class.forName(driver).newInstance();

            String user = "root";
            String password = "";
            String cadena = "jdbc:mysql://127.0.0.1:3306/arcade";

            //retorno el objeto de Conexion con la info del servidor
            return DriverManager.getConnection(cadena, user, password);
      }
}
