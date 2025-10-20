package com.mycompany.flowa.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMySQL {

    // Configuración de conexión
    private static final String URL = "jdbc:mysql://localhost:3307/flowa_bd?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
    private static final String USER = "root";      // cambia si usas otro usuario
    private static final String PASS = "root";          // agrega tu contraseña si tiene

    public static Connection getConnection() {
        Connection conn = null;
        try {
            // Carga del driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Intento de conexión
            conn = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("✅ Conexión exitosa a la base de datos!");
        } catch (ClassNotFoundException e) {
            System.err.println("❌ Error: No se encontró el driver MySQL.");
        } catch (SQLException e) {
            System.err.println("❌ Error al conectar a MySQL: " + e.getMessage());
        }
        return conn;
    }

    // Método de prueba
    public static void main(String[] args) {
        getConnection();
    }
}