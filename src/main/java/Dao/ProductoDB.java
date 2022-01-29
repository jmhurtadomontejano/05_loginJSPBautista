/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Dto.Producto;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Base_Datos.Conexion;
import java.sql.PreparedStatement;

/**
 *
 * @author DAW-A
 */
public class ProductoDB {

    private Conexion c;
    private Connection con;

    public ProductoDB() {
        //Creamos un objeto Conexion.
        this.c = new Conexion();
        //Obtenemos la conexión a la base de datos.
        this.con = this.c.getConnection();
    }

    public Producto getProducto(int id) {
        Producto p = null;
        try {
            //Creamos la cadena que representará nuestra sentencia SQL
            String sql = "SELECT CATEGORIA, DENOMINACION, PRECIO FROM CATALOGO WHERE CODART = ?";
            //Preparamos la sentencia por que debemos aún añadirle un dato
            PreparedStatement ps = con.prepareStatement(sql);
            //Le damos valor al ? en la sentencia SQL
            ps.setInt(1, id);
            //Ejecutamos la sentencia
            ResultSet rs = ps.executeQuery();
            //Verificamos si encontramos un dato.
            if (rs.next()) {
                p = new Producto(id, rs.getString("CATEGORIA"), rs.getString("DENOMINACION"), rs.getDouble("PRECIO"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return p;
    }

    public void create(Producto p) {
        try {
            //Creamos la sentencia sql a ejecutar.
            String sql = "INSERT INTO CATALOGO (CATEGORIA, DENOMINACION, PRECIO) VALUES(?,?,?)";
            //Preparamos la sentencia para agregarle valor a las incognitas.
            PreparedStatement ps = con.prepareStatement(sql);
            //Le damos valor a cada incognita.
            ps.setString(1, p.getCategoria());
            ps.setString(2, p.getNombre());
            ps.setDouble(3, p.getPrecio());
            //Ejecutamos la sentencia.
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.getMessage();
        }
    }

    public void update(Producto p) {
        try {
            //Creamos la sentencia sql a ejecutar.
            String sql = "UPDATE CATALOGO SET CATEGORIA =?, DENOMINACION=?, PRECIO =? WHERE CODART =?";
            //Preparamos la sentencia para agregarle valor a las incognitas.
            PreparedStatement ps = con.prepareStatement(sql);
            //Le damos valor a cada incognita.
            ps.setString(1, p.getCategoria());
            ps.setString(2, p.getNombre());
            ps.setDouble(3, p.getPrecio());
            ps.setInt(4, p.getId());
            //Ejecutamos la sentencia.
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.getMessage();
        }
    }

    public ArrayList<Producto> getProductos() {
        ArrayList<Producto> p = new ArrayList();
        try {
            //Creamos la cadena que llevará la sentencia.
            String sql = "SELECT CODART, CATEGORIA, DENOMINACION, PRECIO FROM CATALOGO";
            //Creamos el objeto que llevará la sentencia al motor de base de datos.            
            Statement st = con.createStatement();
            //Creamos el objeto que guardará el resultado de ejecutar esa sentencia.
            ResultSet rs = st.executeQuery(sql);
            //Recorremos ese resultado
            while (rs.next()) {
                Producto pro = new Producto(rs.getInt("CODART"), rs.getString("CATEGORIA"),
                        rs.getString("DENOMINACION"), rs.getDouble("PRECIO"));
                p.add(pro);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return p;
    }

    public boolean delete(int id) {
        try {
            //Creamos la cadena que llevará la sentencia sql.
            String sql = "DELETE FROM CATALOGO WHERE CODART =?";
            //Creamos el objeto que preparará la sentencia para darle un valor.
            PreparedStatement ps = con.prepareStatement(sql);
            //Le damos un valor a la incógnita.
            ps.setInt(1, id);
            //Ejecutamos la sentencia.
            ps.executeUpdate();
            //retornamos un true si se elimino.
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            //Devolvemos un false si no se pudo eliminar.
            return false;
        }
    }
}
