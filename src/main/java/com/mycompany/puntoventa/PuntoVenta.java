package com.mycompany.puntoventa;

/**
 *
 * @author abrah
 */
import javax.swing.SwingUtilities;

public class PuntoVenta {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new VistaPV().setVisible(true);
        });
    }
}
