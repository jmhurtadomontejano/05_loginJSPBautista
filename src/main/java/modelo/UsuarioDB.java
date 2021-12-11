/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DAW-A
 */
public class UsuarioDB {
    private Connection con;
    private ArrayList<Usuario> listaUsuarios;
    Usuario usuario;

    public UsuarioDB() {
    }
    
    public UsuarioDB(String f) {
//        FileReader fr;
//        Usuario usuario;
//        String linea;
//        String[] array;
//        listaUsuarios = new ArrayList<>();
//        
//        try {
//            InputStreamReader isr = new InputStreamReader(new FileInputStream(f),"UTF-8");
//            BufferedReader br = new BufferedReader(isr);
//            linea = br.readLine();
//            while (linea != null){
//                array = linea.split(",");
//                usuario = new Usuario(array[0], array[1]);
//                listaUsuarios.add(usuario);
//                linea = br.readLine();
//            }
//            br.close();
//            isr.close();
//            
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(UsuarioDB.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (UnsupportedEncodingException ex) {
//            Logger.getLogger(UsuarioDB.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(UsuarioDB.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    public ArrayList<Usuario> getListaUsuarios() {
        con = null;
        try {
            listaUsuarios = new ArrayList();
            con = Conexion.getConexion();
            String sql = "SELECT NOMBRE, PASSWORD FROM PRODUCTOSDB.USUARIOS";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                usuario = new Usuario(rs.getString("NOMBRE"), rs.getString("PASSWORD"));
                listaUsuarios.add(usuario);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return listaUsuarios;
        }
    }

    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
    
}