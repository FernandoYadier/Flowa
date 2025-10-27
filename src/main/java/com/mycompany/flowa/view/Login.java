package com.mycompany.flowa.view;

import com.formdev.flatlaf.FlatLightLaf;
import com.mycompany.flowa.Flowa;
import com.mycompany.flowa.database.ConexionMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();

        setSize(1020, 640);
        setLocationRelativeTo(null);

        panelFondo.addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentResized(java.awt.event.ComponentEvent evt) {
                int mitad = panelFondo.getWidth() / 2;
                int alto = panelFondo.getHeight();

                panelMitad.setSize(mitad, alto);
                panelMitad.setLocation(panelFondo.getWidth() - mitad, 0);
            }
        });
        
        jTextField2.setText("Usuario");
        jPasswordField2.setText("password");
        jTextField1.setText("Usuario");
        jPasswordField1.setText("password");
        
        configurarPlaceholders();
    }
    
    private void configurarPlaceholders() {
       
        jTextField2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (jTextField2.getText().equals("Usuario")) {
                    jTextField2.setText("");
                }
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (jTextField2.getText().isEmpty()) {
                    jTextField2.setText("Usuario");
                }
            }
        });
        
        jPasswordField2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (String.valueOf(jPasswordField2.getPassword()).equals("password")) {
                    jPasswordField2.setText("");
                }
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (String.valueOf(jPasswordField2.getPassword()).isEmpty()) {
                    jPasswordField2.setText("password");
                }
            }
        });
        
        jTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (jTextField1.getText().equals("Usuario")) {
                    jTextField1.setText("");
                }
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (jTextField1.getText().isEmpty()) {
                    jTextField1.setText("Usuario");
                }
            }
        });
        
        jPasswordField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (String.valueOf(jPasswordField1.getPassword()).equals("password")) {
                    jPasswordField1.setText("");
                }
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (String.valueOf(jPasswordField1.getPassword()).isEmpty()) {
                    jPasswordField1.setText("password");
                }
            }
        });
    }

    private boolean validarLogin(String username, String password) {
        String sql = "SELECT id, username FROM usuario WHERE username = ? AND password = ?";
        
        try (Connection conn = ConexionMySQL.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            
            pst.setString(1, username);
            pst.setString(2, password); 
            
            ResultSet rs = pst.executeQuery();
            
            return rs.next();
            
        } catch (SQLException e) {
            System.err.println("Error al validar login: " + e.getMessage());
            JOptionPane.showMessageDialog(this, 
                "Error de conexión con la base de datos\n" + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    private boolean registrarUsuario(String username, String password) {
  
        if (username.isEmpty() || username.equals("Usuario")) {
            JOptionPane.showMessageDialog(this, 
                "Por favor ingrese un nombre de usuario", 
                "Campo vacío", 
                JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        if (password.isEmpty() || password.equals("password")) {
            JOptionPane.showMessageDialog(this, 
                "Por favor ingrese una contraseña", 
                "Campo vacío", 
                JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        if (password.length() < 4) {
            JOptionPane.showMessageDialog(this, 
                "La contraseña debe tener al menos 4 caracteres", 
                "Contraseña débil", 
                JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        String sqlCheck = "SELECT username FROM usuario WHERE username = ?";
        String sqlInsert = "INSERT INTO usuario (username, password) VALUES (?, ?)";
        
        try (Connection conn = ConexionMySQL.getConnection()) {
            
            try (PreparedStatement pstCheck = conn.prepareStatement(sqlCheck)) {
                pstCheck.setString(1, username);
                ResultSet rs = pstCheck.executeQuery();
                
                if (rs.next()) {
                    JOptionPane.showMessageDialog(this, 
                        "El nombre de usuario ya está en uso", 
                        "Usuario existente", 
                        JOptionPane.WARNING_MESSAGE);
                    return false;
                }
            }
        
            try (PreparedStatement pstInsert = conn.prepareStatement(sqlInsert)) {
                pstInsert.setString(1, username);
                pstInsert.setString(2, password); 
                
                int resultado = pstInsert.executeUpdate();
                return resultado > 0;
            }
            
        } catch (SQLException e) {
            System.err.println("Error al registrar usuario: " + e.getMessage());
            JOptionPane.showMessageDialog(this, 
                "Error al registrar el usuario: " + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        panelFondo = new javax.swing.JPanel();
        panelMitad = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jPasswordField2 = new javax.swing.JPasswordField();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelFondo.setBackground(new java.awt.Color(255, 255, 255));
        panelFondo.setLayout(null);

        panelMitad.setBackground(new java.awt.Color(47, 134, 166));
        panelMitad.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Registro");
        panelMitad.add(jLabel1);
        jLabel1.setBounds(50, 50, 115, 20);

        jLabel6.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Únete a Flowa y empieza a");
        panelMitad.add(jLabel6);
        jLabel6.setBounds(50, 160, 360, 20);

        jLabel7.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("controlar tus gastos");
        panelMitad.add(jLabel7);
        jLabel7.setBounds(50, 180, 360, 30);

        jTextField1.setToolTipText("");
        jTextField1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        panelMitad.add(jTextField1);
        jTextField1.setBounds(50, 240, 410, 30);
        panelMitad.add(jPasswordField1);
        jPasswordField1.setBounds(50, 310, 410, 30);

        jButton1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton1.setText("Registrate");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panelMitad.add(jButton1);
        jButton1.setBounds(50, 380, 140, 30);

        panelFondo.add(panelMitad);
        panelMitad.setBounds(510, 0, 510, 640);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Inicio de sesión");
        panelFondo.add(jLabel3);
        jLabel3.setBounds(50, 50, 120, 20);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel5.setText("Bienvenido de nuevo");
        panelFondo.add(jLabel5);
        jLabel5.setBounds(50, 160, 360, 20);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel4.setText("a Flowa");
        panelFondo.add(jLabel4);
        jLabel4.setBounds(50, 180, 360, 30);

        jTextField2.setToolTipText("");
        jTextField2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        panelFondo.add(jTextField2);
        jTextField2.setBounds(50, 240, 410, 30);
        panelFondo.add(jPasswordField2);
        jPasswordField2.setBounds(50, 310, 410, 30);

        jButton2.setBackground(new java.awt.Color(47, 134, 166));
        jButton2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Iniciar sesión");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        panelFondo.add(jButton2);
        jButton2.setBounds(50, 380, 140, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         

        String username = jTextField1.getText().trim();
        String password = String.valueOf(jPasswordField1.getPassword());
        
        if (registrarUsuario(username, password)) {
            JOptionPane.showMessageDialog(this, 
                "¡Usuario registrado exitosamente!\nYa puedes iniciar sesión", 
                "Registro exitoso", 
                JOptionPane.INFORMATION_MESSAGE);
            
            // Limpiar campos
            jTextField1.setText("Usuario");
            jPasswordField1.setText("password");
        }
    }                                        

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
     
        String username = jTextField2.getText().trim();
        String password = String.valueOf(jPasswordField2.getPassword());
        
    
        if (username.isEmpty() || username.equals("Usuario")) {
            JOptionPane.showMessageDialog(this, 
                "Por favor ingrese su nombre de usuario", 
                "Campo vacío", 
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if (password.isEmpty() || password.equals("password")) {
            JOptionPane.showMessageDialog(this, 
                "Por favor ingrese su contraseña", 
                "Campo vacío", 
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if (validarLogin(username, password)) {
            JOptionPane.showMessageDialog(this, 
                "¡Bienvenido, " + username + "!", 
                "Inicio de sesión exitoso", 
                JOptionPane.INFORMATION_MESSAGE);
            
            try {
                Flowa ventanaFlowa = new Flowa();
                ventanaFlowa.setVisible(true);
                this.dispose();
            } catch (Exception e) {
                System.err.println("Error al abrir Flowa: " + e.getMessage());
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, 
                    "Error al abrir la ventana principal", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
            }
            
        } else {
            JOptionPane.showMessageDialog(this, 
                "Usuario o contraseña incorrectos", 
                "Error de autenticación", 
                JOptionPane.ERROR_MESSAGE);
            
            jPasswordField2.setText("password");
        }
    }                                        

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            System.err.println("Failed to initialize LaF");
        }

        java.awt.EventQueue.invokeLater(() -> new Login().setVisible(true));
    }
    
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JPanel panelFondo;
    private javax.swing.JPanel panelMitad;               
}