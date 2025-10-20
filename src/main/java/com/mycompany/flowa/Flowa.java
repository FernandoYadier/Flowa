package com.mycompany.flowa;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Flowa extends JFrame {
    private final JTable tabla;
    private final DefaultTableModel modelo;

    public Flowa() {
        setTitle("Lista de Gastos");
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Categoría");
        modelo.addColumn("Nombre");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Monto");
        modelo.addColumn("Fecha");
        modelo.addColumn("Nota");

        tabla = new JTable(modelo);
        add(new JScrollPane(tabla));

        cargarDatos();
    }

    private void cargarDatos() {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3307/flowa_bd", "root", "root");
             Statement stmt = conn.createStatement()) {

            String query = """
                SELECT g.id, c.nombre AS categoria, g.nombre, g.cantidad,
                       g.monto, g.fecha, g.nota
                FROM gasto g
                JOIN categoria c ON g.categoria_id = c.id
            """;

            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                modelo.addRow(new Object[]{
                    rs.getInt("id"),
                    rs.getString("categoria"),
                    rs.getString("nombre"),
                    rs.getBigDecimal("cantidad"),
                    rs.getBigDecimal("monto"),
                    rs.getDate("fecha"),
                    rs.getString("nota")
                });
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                "Error al cargar datos: " + e.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Flowa().setVisible(true));
    }
}
