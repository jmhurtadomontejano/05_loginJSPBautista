package Dao;

import Base_Datos.Conexion;
import Dto.Venta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VentaDB {
    private Conexion c;
    private Connection con;

    public VentaDB() {
        //Creamos un objeto Conexion.
        this.c = new Conexion();
        //Obtenemos la conexión a la base de datos.
        this.con = this.c.getConnection();
    }
    
    public void registrarVenta(Venta v){
        try {
            //Creamos la sentencia SQL
            String sql = "INSERT INTO VENTA (IDUSUARIO, IDPRODUCTO, PRECIO) VALUES (?,?,?)";
            //Preparamos la sentencia para ser ejecutada.
            PreparedStatement st = con.prepareStatement(sql);
            //Le asignamos los valores en este caso usuario y contraseña a la sentencia.
            st.setInt(1, v.getIdUsuario());
            st.setInt(2, v.getIdProducto());
            st.setDouble(3, v.getPrecio());
            
            //Ejecutamos la sentencia.
            st.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
