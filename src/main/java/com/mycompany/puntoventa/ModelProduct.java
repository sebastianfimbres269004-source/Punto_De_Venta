
package com.mycompany.puntoventa;

public class ModelProduct {
    private String nombre;
    private double precio;
    private int cantidad;

    public ModelProduct(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return precio * cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }
}
