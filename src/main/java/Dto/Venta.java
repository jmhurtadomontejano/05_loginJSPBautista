package Dto;

public class Venta {

    private int idVenta;
    private int idProducto;
    private int idUsuario;
    private double precio;

    public Venta() {
    }

    public Venta(int idVenta, int idProducto, int idUsuario, double precio) {
        this.idVenta = idVenta;
        this.idProducto = idProducto;
        this.idUsuario = idUsuario;
        this.precio = precio;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

}
