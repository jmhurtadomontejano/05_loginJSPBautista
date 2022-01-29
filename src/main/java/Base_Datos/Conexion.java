package Base_Datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    //Objeto conexión que nos permitirá conectarnos a la base de datos.
    private static Connection conn;
    //Cadena que nos guarda el driver para conectarnos a la base de datos, en este caso MySql.
    private static final String driver = "com.mysql.jdbc.Driver";
    //Url de conexión a la base de datos -- productosdb es la base de datos que vamos a usar (Se puede cambiar).
    private final static String URLDB = "jdbc:mysql://localhost:3306/productosdb";
    //Usuario para acceder a la base de datos
    private final static String USUARIO = "root";
    //Contraseña para acceder a la base de datos
    private final static String CLAVE = "";

    public Conexion() {
        try {
            //Verificamos que no nos hallamos conectado, y realizamos la conexión
            if (conn == null) {
                //Obtenemos el driver a partir del string que definimos anteriormente.
                Class.forName(driver);
                /**
                 * Realizamos la conexión con los datos especificados
                 * anteriormente.
                 */
                conn = (Connection) DriverManager.getConnection(URLDB, USUARIO, CLAVE);
                //Si se logró conectar imprime el mensaje
                if (conn != null) {
                    System.out.println("Conexion establecida");
                }
            }

        } catch (ClassNotFoundException | SQLException e) {
            //Si por el contrario no existe la base de datos, el usuario o la contraseña son incorrectas imprimimos un error.
            System.out.println("Error de conexion " + e);

        }
    }

    /**
     * Método que nos devuelve la conexión.
     * @return Objeto Connection
     */
    public Connection getConnection() {
        return conn;
    }
}
