
package com.mycompany.puntoventa;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class VistaPV extends JFrame {

    private JTextField txtNombre;
    private JTextField txtPrecio;
    private JTextField txtCantidad;
    private JLabel lblTotal;
    private JTable tabla;
    private DefaultTableModel modelo;
    private ControllerPV controlador = new ControllerPV();

    private final Color COLOR_FONDO = new Color(245, 247, 250);
    private final Color COLOR_PANEL = Color.WHITE;
    private final Color COLOR_PRIMARIO = new Color(52, 152, 219);
    private final Color COLOR_SECUNDARIO = new Color(231, 76, 60);
    private final Color COLOR_EXITO = new Color(46, 204, 113);
    private final Color COLOR_TEXTO = new Color(44, 62, 80);
    private final Color COLOR_BORDE = new Color(220, 220, 220);

    public VistaPV() {
        setTitle("Punto de Venta");
        setSize(850, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel contentPane = new JPanel(new BorderLayout(15, 15));
        contentPane.setBackground(COLOR_FONDO);
        contentPane.setBorder(new EmptyBorder(15, 15, 15, 15));
        setContentPane(contentPane);

        // título
        JLabel titulo = new JLabel("Punto de Venta");
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 28));
        titulo.setForeground(COLOR_TEXTO);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        add(titulo, BorderLayout.NORTH);

        // parte delcentro
        JPanel panelCentro = new JPanel(new BorderLayout(15, 15));
        panelCentro.setOpaque(false);
        panelCentro.add(crearPanelFormulario(), BorderLayout.NORTH);
        panelCentro.add(crearPanelTabla(), BorderLayout.CENTER);
        add(panelCentro, BorderLayout.CENTER);

        // abajo
        add(crearPanelInferior(), BorderLayout.SOUTH);
    }

    private JPanel crearPanelFormulario() {
        JPanel panelForm = new JPanel(new GridBagLayout());
        panelForm.setBackground(COLOR_PANEL);
        panelForm.setBorder(new CompoundBorder(
                new LineBorder(COLOR_BORDE, 1, true),
                new EmptyBorder(15, 15, 15, 15)));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel lblNombre = new JLabel("Nombre Producto:");
        JLabel lblPrecio = new JLabel("Precio:");
        JLabel lblCantidad = new JLabel("Cantidad:");

        Font fontLabel = new Font("Segoe UI", Font.BOLD, 14);

        lblNombre.setFont(fontLabel);
        lblPrecio.setFont(fontLabel);
        lblCantidad.setFont(fontLabel);

        lblNombre.setForeground(COLOR_TEXTO);
        lblPrecio.setForeground(COLOR_TEXTO);
        lblCantidad.setForeground(COLOR_TEXTO);

        txtNombre = crearCampoTexto();
        txtPrecio = crearCampoTexto();
        txtCantidad = crearCampoTexto();

        JButton btnAgregar = crearBoton("Agregar Producto", COLOR_PRIMARIO);
        JButton btnEliminar = crearBoton("Eliminar Producto", COLOR_SECUNDARIO);

        gbc.gridx = 0; gbc.gridy = 0;
        panelForm.add(lblNombre, gbc);

        gbc.gridx = 1; gbc.weightx = 1;
        panelForm.add(txtNombre, gbc);

        gbc.gridx = 0; gbc.gridy = 1; gbc.weightx = 0;
        panelForm.add(lblPrecio, gbc);

        gbc.gridx = 1; gbc.weightx = 1;
        panelForm.add(txtPrecio, gbc);

        gbc.gridx = 0; gbc.gridy = 2; gbc.weightx = 0;
        panelForm.add(lblCantidad, gbc);

        gbc.gridx = 1; gbc.weightx = 1;
        panelForm.add(txtCantidad, gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        panelForm.add(btnAgregar, gbc);

        gbc.gridx = 1;
        panelForm.add(btnEliminar, gbc);

        
         
        btnAgregar.addActionListener(e -> agregarProducto());
        btnEliminar.addActionListener(e -> eliminarProducto());

        return panelForm;
    }

    private JPanel crearPanelTabla() {
        JPanel panelTabla = new JPanel(new BorderLayout());
        panelTabla.setBackground(COLOR_PANEL);
        panelTabla.setBorder(new CompoundBorder(
                new LineBorder(COLOR_BORDE, 1, true),
                new EmptyBorder(10, 10, 10, 10)));

        modelo = new DefaultTableModel();
        modelo.addColumn("Nombre");
        modelo.addColumn("Precio");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Subtotal");

        tabla = new JTable(modelo);

        tabla.setRowHeight(28);
        tabla.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        JTableHeader header = tabla.getTableHeader();
        header.setFont(new Font("Segoe UI", Font.BOLD, 14));
        header.setBackground(COLOR_PRIMARIO);
        header.setForeground(Color.WHITE);

        JScrollPane scrollPane = new JScrollPane(tabla);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());

        panelTabla.add(scrollPane, BorderLayout.CENTER);

        return panelTabla;
    }

    private JPanel crearPanelInferior() {
        JPanel panelBottom = new JPanel(new BorderLayout());
        panelBottom.setBackground(COLOR_PANEL);
        panelBottom.setBorder(new CompoundBorder(
                new LineBorder(COLOR_BORDE, 1, true),
                new EmptyBorder(12, 15, 12, 15)));

        lblTotal = new JLabel("Total: $0.00");
        lblTotal.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lblTotal.setForeground(COLOR_EXITO);

        JButton btnFinalizar = crearBoton("Finalizar Venta", new Color(155, 89, 182));
        btnFinalizar.addActionListener(e -> finalizarVenta());

        panelBottom.add(lblTotal, BorderLayout.WEST);
        panelBottom.add(btnFinalizar, BorderLayout.EAST);

        return panelBottom;
    }

    private JTextField crearCampoTexto() {
        JTextField campo = new JTextField();
        campo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        campo.setPreferredSize(new Dimension(200, 35));
        campo.setBorder(new CompoundBorder(
                new LineBorder(COLOR_BORDE, 1, true),
                new EmptyBorder(5, 10, 5, 10)));
        return campo;
    }

    private JButton crearBoton(String texto, Color color) {
        JButton boton = new JButton(texto);
        boton.setForeground(Color.WHITE);
        boton.setBackground(color);
        boton.setFocusPainted(false);
        return boton;
    }


    private void agregarProducto() {
    try {
        String nombre = txtNombre.getText().trim();
        double precio = Double.parseDouble(txtPrecio.getText().trim());
        int cantidad = Integer.parseInt(txtCantidad.getText().trim());

        ModelProduct p = new ModelProduct(nombre, precio, cantidad);

        String error = controlador.agregarProducto(p, modelo);

        if (error != null) {
            JOptionPane.showMessageDialog(this, error);
            return;
        }

        lblTotal.setText(String.format("Total: $%.2f", controlador.getTotal()));
        limpiarCampos();

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Datos inválidos");
    }
}

    private void eliminarProducto() {
    int fila = tabla.getSelectedRow();

    String error = controlador.eliminarProducto(fila, modelo);

    if (error != null) {
        JOptionPane.showMessageDialog(this, error);
        return;
    }

    lblTotal.setText(String.format("Total: $%.2f", controlador.getTotal()));
}

    private void finalizarVenta() {
        JOptionPane.showMessageDialog(this,
                "Total de la venta: $" + controlador.getTotal());

        controlador.limpiarVenta(modelo);
        lblTotal.setText("Total: $0.00");
    }

    private void limpiarCampos() {
        txtNombre.setText("");
        txtPrecio.setText("");
        txtCantidad.setText("");
    }
}
