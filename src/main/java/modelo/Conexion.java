package modelo;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author DAW-A
 */
public class Conexion {

    //declaro variables en mayusculas porque son constantes
    public static Connection conexion;

    final static String DRIVER = "com.mysql.cj.jdbc.Driver";
    final static String URLDB = "jdbc:mysql://localhost:3306/productosdb";
    final static String USUARIO = "admin";
    final static String CLAVE = "1234";

    /**
     * Obtendrá una conexión a la base de datos.
     *
     * @return
     */
    public static Connection getConexion() {
        try {
            if (conexion == null) {
                Class.forName(DRIVER);
                conexion = DriverManager.getConnection(URLDB, USUARIO, CLAVE);
                System.out.println("Conexion establecida");
            } else {
                System.out.println("Ya conectado a la base de datos.");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {

        } finally {
            return conexion;
        }
    }//fin getConexion
}
