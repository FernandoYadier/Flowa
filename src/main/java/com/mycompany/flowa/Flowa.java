package com.mycompany.flowa;

import com.formdev.flatlaf.FlatLightLaf;
// u otra variante como FlatDarkLaf, FlatIntelliJLaf, etc.
import javax.swing.SwingUtilities;

public class Flowa {
    public static void main(String[] args) {
        // Establecer el tema LAF
        try {
            FlatLightLaf.setup();
            // O:
            // UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            System.err.println("No se pudo inicializar FlatLaf: " + ex.getMessage());
        }

        // Luego crear la interfaz gráfica
        SwingUtilities.invokeLater(() -> {
            // Aquí inicializas tu ventana principal, etc.
            // new MainView().setVisible(true);
        });
    }
}
