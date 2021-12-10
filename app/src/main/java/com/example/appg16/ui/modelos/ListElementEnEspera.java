package com.example.appg16.ui.modelos;

public class ListElementEnEspera {
    public int imagen;
    public String nombre;
    public String precio;
    public String agregar;

    public ListElementEnEspera(int imagen, String nombre, String precio, String agregar) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.precio = precio;
        this.agregar = agregar;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {this.imagen = imagen; }

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

    public String getAgregar() {
        return agregar;
    }

    public void setAgregar(String agregar) {
        this.agregar = agregar;
    }
}
