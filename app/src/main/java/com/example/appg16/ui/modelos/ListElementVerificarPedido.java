package com.example.appg16.ui.modelos;

public class ListElementVerificarPedido {

    private int imagen;
    private String nombre;
    private String precio;
    private String cantidad;
    private int eliminar;

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    private String total;

    public ListElementVerificarPedido(int imagen, String nombre, String precio, String cantidad, int eliminar) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.eliminar = eliminar;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public int getEliminar() {
        return eliminar;
    }

    public void setEliminar(int eliminar) {
        this.eliminar = eliminar;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
