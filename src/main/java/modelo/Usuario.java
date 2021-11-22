package modelo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author bauti
 */
public class Usuario {

    private String usuario;
    private String password;
    private String email;
    private String nombre;


    public Usuario(String usuario, String clave) {
        this.usuario = usuario;
        this.password = clave;
    }



    public String getUsuario() {
        return usuario;
    }

    public String getClave() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setClave(String clave) {
        this.password = clave;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
