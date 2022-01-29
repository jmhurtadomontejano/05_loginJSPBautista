/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Dto.Usuario;
import java.sql.Connection;
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
public class UsuarioDB {

    private Conexion c;
    private Connection con;

    public UsuarioDB() {
        //Creamos un objeto Conexion.
        this.c = new Conexion();
        //Obtenemos la conexión a la base de datos.
        this.con = this.c.getConnection();
    }

    public Usuario getUsuario(String user) {
        Usuario usuario = null;
        try {
            //Creamos la sentencia SQL para ejecutarla en la BD
            String sql = "SELECT NOMBRE, PASSWORD FROM USUARIOS WHERE NOMBRE = ?";
            //Preparamos la sentencia en el motor de la base de datos.
            PreparedStatement st = con.prepareStatement(sql);
            //Aquí le damos un valor al interrogante del sql, dandole como valor el usuario que buscaremos.
            st.setString(1, user);
            //Ejecutamos la sentencia y obtenemos los resultados.
            ResultSet rs = st.executeQuery();
            //Procesamos los resultados (Si estos existen).
            if (rs.next()) {
                usuario = new Usuario(rs.getString("NOMBRE"), rs.getString("PASSWORD"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return usuario;
        }
    }

    public void registrar(Usuario u) {
        try {
            //Creamos la sentencia SQL
            String sql = "INSERT INTO USUARIOS (NOMBRE, PASSWORD) VALUES (?,?)";
            //Preparamos la sentencia para ser ejecutada.
            PreparedStatement st = con.prepareStatement(sql);
            //Le asignamos los valores en este caso usuario y contraseña a la sentencia.
            st.setString(1, u.getUsuario());
            st.setString(2, u.getClave());
            //Ejecutamos la sentencia.
            st.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public int getIdUsuario(String nombre){
        int id = 0;
        try {
            //Creamos la sentencia SQL para ejecutarla en la BD
            String sql = "SELECT ID FROM USUARIOS WHERE NOMBRE = ?";
            //Preparamos la sentencia en el motor de la base de datos.
            PreparedStatement st = con.prepareStatement(sql);
            //Aquí le damos un valor al interrogante del sql, dandole como valor el usuario que buscaremos.
            st.setString(1, nombre);
            //Ejecutamos la sentencia y obtenemos los resultados.
            ResultSet rs = st.executeQuery();
            //Procesamos los resultados (Si estos existen).
            if (rs.next()) {
                id = rs.getInt("id");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return id;
    }

}
