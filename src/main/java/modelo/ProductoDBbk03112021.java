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
public class ProductoDBbk03112021 {
    private ArrayList<Producto> catalogo;
    private ArrayList<String> cabecera;
    
    public ProductoDBbk03112021(String f) {
        catalogo = new ArrayList();
        cabecera= new ArrayList();
        Producto producto;
        String linea;
        String[] array;
        
        try {
            InputStreamReader isr = new InputStreamReader(new FileInputStream(f),"UTF-8");
            BufferedReader br = new BufferedReader(isr);
            linea = br.readLine();
            array = linea.split(",");
            for(String cad: array){
                cabecera.add(cad);
            }
            linea = br.readLine();
            while (linea != null){
                array = linea.split(",");
                producto =  new Producto(Integer.parseInt(array[0]),array[1],array[2],Double.parseDouble(array[3]));
                catalogo.add(producto);
                linea = br.readLine();
            }
            br.close();
            isr.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UsuarioDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(UsuarioDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UsuarioDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ProductoDBbk03112021() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<Producto> getCatalogo() {
        return catalogo;
    }

    public ArrayList<String> getCabecera() {
        return cabecera;
    }
    
}