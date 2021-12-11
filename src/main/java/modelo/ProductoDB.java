/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Spliterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DAW-A
 */
public class ProductoDB {
    private Connection con;
    private ArrayList<Producto> catalogo;
    private ArrayList<String> cabecera;
    Producto producto;
    
    public ProductoDB() {
        
    }
    public ProductoDB(String f) {
        
    }

    public ArrayList<String> getCabecera() {
        cabecera = new ArrayList();
        con = Conexion.getConexion();
        DatabaseMetaData dbmd;
            try {
                dbmd = con.getMetaData();
                ResultSet rsColum = dbmd.getColumns(null, "PRODUSCTOSDB", "CATALOGO", null);
                while(rsColum.next()){
                    String etiqueta = rsColum.getString("COLUMN_NAME");
                    cabecera.add(etiqueta);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ProductoDB.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                return cabecera;
            }
    }
    
    public ArrayList<Producto> getCatalogo() {
        con = null;
            try {
                catalogo = new ArrayList();
                con = Conexion.getConexion();
                String sql = "SELECT CODART, CATEGORIA, DENOMINACION, PRECIO FROM PRODUCTOSDB.CATALOGO";
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    producto = new Producto(rs.getInt("CODART"), rs.getString("CATEGORIA"),
                    rs.getString("DENOMINACION"), rs.getFloat("PRECIO"));
                    catalogo.add(producto);
                }

            } catch (SQLException ex) {
                Logger.getLogger(ProductoDB.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                return catalogo;
            }
    }
}