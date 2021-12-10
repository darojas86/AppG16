package com.example.appg16.ui.modelos;

public class ListElementSeleccionarProducto {
    public int imagen_producto;
    public String nombre;
    public String precio;
    public int agregar;

    public ListElementSeleccionarProducto(int imagen_producto, String nombre, String precio, int agregar) {
        this.imagen_producto = imagen_producto;
        this.nombre = nombre;
        this.precio = precio;
        this.agregar = agregar;
    }
    public int getImagen_producto() {
        return imagen_producto;
    }

    public void setImagen_producto(int imagen_producto) {
        this.imagen_producto = imagen_producto;
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

    public int getAgregar() {
        return agregar;
    }

    public void setAgregar(int agregar) {
        this.agregar = agregar;
    }


}
