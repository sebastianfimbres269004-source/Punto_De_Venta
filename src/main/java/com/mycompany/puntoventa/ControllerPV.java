
package com.mycompany.puntoventa;

import javax.swing.table.DefaultTableModel;

public class ControllerPV {

    private double total = 0;

    public double getTotal() {
        return total;
    }

    public String agregarProducto(ModelProduct p, DefaultTableModel modelo) {

        if (p.getNombre().isEmpty()) {
            return "El nombre es obligatorio";
        }

        if (p.getPrecio() <= 0 || p.getPrecio() > 10000) {
            return "Precio inválido (0.01 - 10,000)";
        }

        if (p.getCantidad() <= 0 || p.getCantidad() > 100) {
            return "Cantidad inválida (1 - 100)";
        }

        if (modelo.getRowCount() >= 20) {
            return "Máximo 20 productos por venta";
        }

        double subtotal = p.getSubtotal();

        modelo.addRow(new Object[]{
            p.getNombre(),
            String.format("$%.2f", p.getPrecio()),
            p.getCantidad(),
            String.format("$%.2f", subtotal)
        });
        total += subtotal;
        return null;
    }

    public String eliminarProducto(int fila, DefaultTableModel modelo) {

        if (fila < 0) {
            return "Seleccione un producto";
        }

        String subtotalTexto = modelo.getValueAt(fila, 3).toString().replace("$", "");
        double subtotal = Double.parseDouble(subtotalTexto);

        modelo.removeRow(fila);
        total -= subtotal;

        return null;
    }

    public void limpiarVenta(DefaultTableModel modelo) {
        modelo.setRowCount(0);
        total = 0;
    }
}