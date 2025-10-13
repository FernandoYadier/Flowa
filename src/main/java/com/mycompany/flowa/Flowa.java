package com.mycompany.flowa;

import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.*;
import java.awt.*;

public class Flowa extends JFrame {

    public Flowa() {
        // Configurar ventana
        setTitle("Ejemplo con FlatLaf");
        setSize(500, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel superior con título
        JLabel titulo = new JLabel("Interfaz con FlatLaf", SwingConstants.CENTER);
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 22));
        add(titulo, BorderLayout.NORTH);

        // Panel central con formulario
        JPanel panelCentro = new JPanel(new GridLayout(4, 2, 10, 10));
        panelCentro.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        panelCentro.add(new JLabel("Nombre:"));
        JTextField campoNombre = new JTextField();
        panelCentro.add(campoNombre);

        panelCentro.add(new JLabel("Correo:"));
        JTextField campoCorreo = new JTextField();
        panelCentro.add(campoCorreo);

        panelCentro.add(new JLabel("Género:"));
        JComboBox<String> comboGenero = new JComboBox<>(new String[]{"Masculino", "Femenino", "Otro"});
        panelCentro.add(comboGenero);

        panelCentro.add(new JLabel("País:"));
        JComboBox<String> comboPais = new JComboBox<>(new String[]{"México", "Argentina", "Chile", "España"});
        panelCentro.add(comboPais);

        add(panelCentro, BorderLayout.CENTER);

        // Panel inferior con botones
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton btnGuardar = new JButton("Guardar");
        JButton btnCancelar = new JButton("Cancelar");
        panelBotones.add(btnGuardar);
        panelBotones.add(btnCancelar);

        add(panelBotones, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        try {
            // Configurar el tema de FlatLaf
            FlatLightLaf.setup();
        } catch (Exception ex) {
            System.err.println("No se pudo inicializar FlatLaf.");
        }

        SwingUtilities.invokeLater(() -> {
            new Flowa().setVisible(true);
        });
    }
}
