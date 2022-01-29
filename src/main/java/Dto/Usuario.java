package Dto;

public class Usuario {

    private String usuario;
    private String password;

    public Usuario() {
    }

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

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setClave(String clave) {
        this.password = clave;
    }
}
