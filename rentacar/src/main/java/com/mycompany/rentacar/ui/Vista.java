/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.rentacar.ui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;

/**
 *
 * @author j1
 */
public class Vista extends javax.swing.JFrame {

    /**
     * Creates new form Vista
     */
    public Vista() {
        initComponents();
        initializePanels();
        initializeButtons();
        addButtonListeners();
        vistaActual = 0;
        switchToPanelByIndex(vistaActual);
        
        contenedorVistas.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                resizeInternalPanels();
                moveButtons();
            }
        });
    }
    
    private void resizeInternalPanels() {
        // Calculate the new size based on the resized contenedorVistas
        int width = contenedorVistas.getWidth();
        int height = contenedorVistas.getHeight();

        // Resize each individual panel inside contenedorVistas
        vistaPrincipal.setSize(width, height);
        vistaUsuario.setSize(width, height);
        vistaCoche.setSize(width, height);
        vistaSeguro.setSize(width, height);
        vistaCobro.setSize(width, height);
        vistaResumen.setSize(width, height);
        // Adjust the layout of each internal panel as needed
    }
    
    private void moveButtons() {
        int width = contenedorVistas.getWidth();
        int height = contenedorVistas.getHeight();

        // Adjust the positions of the buttons based on the new size
        int lateralPanelWidth = panelLateral.getWidth();

        // Example button position adjustments (modify as needed)
        botonNuevo.setLocation(10, height - 70);
        botonGuardar.setLocation(width - 110, height - 70);
        botonAtras.setLocation(10, height - 70);
        botonAdelante.setLocation(width - 110, height - 70);
        // Adjust other button positions as necessary
    }
    
    private void initializePanels() {
        initializeVistaPrincipal();
        initalizeVistaUsuario();
        initializeVistaCoche();
        initalizeVistaSeguro();
        initializeVistaCobro();
        initializeVistaResumen();
    }
    
    private void initializeVistaPrincipal() {
        vistaPrincipal = new JPanel();
        vistaPrincipal.setBackground(Color.RED); // Adding background color for visual distinction
        contenedorVistas.add(vistaPrincipal, 0); // Add vistaPrincipal at layer 1
        vistaPrincipal.setBounds(0, 0, 700, 500); // Set bounds as needed
    }
    
    private void initalizeVistaUsuario() {
        vistaUsuario = new JPanel();
        contenedorVistas.add(vistaUsuario, 1); // Add vistaUsuario at layer 2
        vistaUsuario.setBounds(0, 0, 700, 500); // Set bounds as needed

        vistaUsuario.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 1.0; // Allow components to fill vertically
        gbc.anchor = GridBagConstraints.WEST; // Align components to the left
        gbc.insets = new Insets(10, 10, 10, 10); // Add padding around components

        // Create and add labels and text fields
        addLabelAndTextField(vistaUsuario, gbc, "Nombre:", 0, 0);
        addLabelAndTextField(vistaUsuario, gbc, "Apellidos:", 0, 1);
        addLabelAndTextField(vistaUsuario, gbc, "Dirección:", 0, 2);
        addLabelAndTextField(vistaUsuario, gbc, "Edad:", 0, 3);
        addLabelAndTextField(vistaUsuario, gbc, "Tipo Carnet:", 0, 4);
        addLabelAndTextField(vistaUsuario, gbc, "Antigüedad Carnet:", 0, 5);
        
        int bottomMargin = 70; // Adjust this value to match the height of your buttons
        int topMargin = 20;
        vistaUsuario.setBorder(BorderFactory.createEmptyBorder(topMargin, 0, bottomMargin, 0));

        vistaUsuario.setVisible(false); // Initially hide vistaUsuario
    }
    
    private void initializeVistaCoche() {
        vistaCoche = new JPanel();
        contenedorVistas.add(vistaCoche, 2); // Add vistaCoche at layer 3
        vistaCoche.setBounds(0, 0, 700, 500); // Set bounds as needed

        vistaCoche.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 1.0; // Allow components to fill vertically
        gbc.fill = GridBagConstraints.BOTH; // Fill horizontally
        gbc.anchor = GridBagConstraints.WEST; // Align components to the left
        gbc.insets = new Insets(10, 10, 10, 10); // Add padding around components

        // Tipo de coche (using combo box)
        addLabelAndComboBox(vistaCoche, gbc, "Tipo de coche:", 0, 0, 
            new String[]{"Pequeño", "Mediano", "Monovolumen", "Furgoneta de carga", "Furgoneta de pasajeros"});

        // Coche concreto (using combo box or text field)
        addLabelAndTextField(vistaCoche, gbc, "Coche concreto:", 0, 1);

        // Precio por día (using spinner)
        addLabelAndSpinner(vistaCoche, gbc, "Precio por día:", 0, 2);

        // Precio por semana (using spinner)
        addLabelAndSpinner(vistaCoche, gbc, "Precio por semana:", 0, 3);

        // Kilómetros incluidos en el precio (using spinner)
        addLabelAndSpinner(vistaCoche, gbc, "Kilómetros incluidos:", 0, 4);

        // Precio por kilómetro adicional (using spinner)
        addLabelAndSpinner(vistaCoche, gbc, "Precio por kilómetro adicional:", 0, 5);

        // Estado del coche (using text area)
        addLabelAndTextField(vistaCoche, gbc, "Estado del coche:", 0, 6);

        int bottomMargin = 70; // Adjust this value to match the height of your buttons
        int topMargin = 20;
        vistaCoche.setBorder(BorderFactory.createEmptyBorder(topMargin, 0, bottomMargin, 0));

        vistaCoche.setVisible(false); // Initially hide vistaCoche
    }
    
    
    private void initalizeVistaSeguro() {
        vistaSeguro = new JPanel();
        vistaSeguro.setBackground(Color.YELLOW); // Adding background color for visual distinction
        contenedorVistas.add(vistaSeguro, 3); // Add vistaSeguro at layer 4
        vistaSeguro.setBounds(0, 0, 700, 500); // Set bounds as needed
        vistaSeguro.setVisible(false); // Initially hide vistaSeguro
    }
    
    private void initializeVistaCobro() {
        vistaCobro = new JPanel();
        vistaCobro.setBackground(Color.ORANGE); // Adding background color for visual distinction
        contenedorVistas.add(vistaCobro, 4); // Add vistaCobro at layer 5
        vistaCobro.setBounds(0, 0, 700, 500); // Set bounds as needed
        vistaCobro.setVisible(false); // Initially hide vistaCobro
    }
    
    private void initializeVistaResumen() {
        vistaResumen = new JPanel();
        vistaResumen.setBackground(Color.CYAN); // Adding background color for visual distinction
        contenedorVistas.add(vistaResumen, 5); // Add vistaResumen at layer 6
        vistaResumen.setBounds(0, 0, 700, 500); // Set bounds as needed
        vistaResumen.setVisible(false); // Initially hide vistaResumen
    }
    
    private void addLabelAndTextField(JPanel panel, GridBagConstraints gbc, String labelText, int gridx, int gridy) {
        JLabel label = new JLabel(labelText);
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.fill = GridBagConstraints.NONE; // Don't fill horizontally
        gbc.weightx = 0.0; // Reset weightx
        gbc.anchor = GridBagConstraints.WEST; // Align components to the left
        gbc.insets = new Insets(10, 10, 10, 10); // Add padding around components
        panel.add(label, gbc);

        JTextField textField = new JTextField(20); // Adjust column size if needed
        gbc.gridx = gridx + 1;
        gbc.weightx = 1.0; // Make the text field expand horizontally
        gbc.fill = GridBagConstraints.HORIZONTAL; // Fill horizontally
        gbc.anchor = GridBagConstraints.WEST; // Align components to the left
        panel.add(textField, gbc);
    }
    
    private void addLabelAndComboBox(JPanel panel, GridBagConstraints gbc, String labelText, int gridx, int gridy, String[] options) {
        JLabel label = new JLabel(labelText);
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.anchor = GridBagConstraints.WEST; // Align components to the left
        gbc.insets = new Insets(10, 10, 10, 10); // Add padding around components
        panel.add(label, gbc);

        JComboBox<String> comboBox = new JComboBox<>(options);
        gbc.gridx = gridx + 1;
        gbc.weightx = 1.0; // Make the combo box expand horizontally
        gbc.fill = GridBagConstraints.BOTH; // Fill horizontally
        gbc.anchor = GridBagConstraints.WEST; // Align components to the left
        panel.add(comboBox, gbc);
    }
    
    private void addLabelAndSpinner(JPanel panel, GridBagConstraints gbc, String labelText, int gridx, int gridy) {
        JLabel label = new JLabel(labelText);
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.anchor = GridBagConstraints.WEST; // Align components to the left
        gbc.insets = new Insets(10, 10, 10, 10); // Add padding around components
        panel.add(label, gbc);

        SpinnerModel spinnerModel = new SpinnerNumberModel(0, 0, 10000, 1); // Change min, max, and step values as needed
        JSpinner spinner = new JSpinner(spinnerModel);
        JSpinner.DefaultEditor spinnerEditor = (JSpinner.DefaultEditor) spinner.getEditor();
        spinnerEditor.getTextField().setEditable(false); // Make the spinner not editable
        gbc.gridx = gridx + 1;
        gbc.weightx = 1.0; // Make the spinner expand horizontally
        gbc.fill = GridBagConstraints.HORIZONTAL; // Fill horizontally
        gbc.anchor = GridBagConstraints.WEST; // Align components to the left
        panel.add(spinner, gbc);
    }
    
    private void initializeButtons() {
        // Create and initialize botonAtras and botonAdelante for navigation
        botonAtras = new JButton("Atras");
        botonAdelante = new JButton("Adelante");
        // Initially hide these buttons
        botonAtras.setVisible(false);
        botonAdelante.setVisible(false);

        // Create and initialize botonNuevo for starting a new booking
        botonNuevo = new JButton("Nuevo");
        // Initially hide this button
        botonNuevo.setVisible(false);
        panelLateral.add(botonNuevo);
        botonNuevo.setBounds(10,400,100,50);
        botonNuevo.setBackground(Color.BLACK);
        botonNuevo.setForeground(Color.WHITE);
        botonNuevo.setFocusable(false);
        botonNuevo.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        
        botonGuardar = new JButton("Guardar");
        contenedorVistas.add(botonGuardar);
        contenedorVistas.setLayer(botonGuardar, JLayeredPane.POPUP_LAYER);
        botonGuardar.setBounds(500, 400, 100, 50);
        botonGuardar.setBackground(Color.BLACK);
        botonGuardar.setForeground(Color.WHITE);
        botonGuardar.setFocusable(false);
        botonGuardar.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        
        
        // Add botonAtras and botonAdelante to the bottom of contenedorVistas
        contenedorVistas.add(botonAtras);
        contenedorVistas.setLayer(botonAtras, JLayeredPane.POPUP_LAYER);
        botonAtras.setBounds(375, 400, 100, 50);
        botonAtras.setBackground(Color.BLACK);
        botonAtras.setForeground(Color.WHITE);
        botonAtras.setFocusable(false);
        botonAtras.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));

        contenedorVistas.add(botonAdelante);
        contenedorVistas.setLayer(botonAdelante, JLayeredPane.POPUP_LAYER);
        botonAdelante.setBounds(500, 400, 100, 50);
        botonAdelante.setBackground(Color.BLACK);
        botonAdelante.setForeground(Color.WHITE);
        botonAdelante.setFocusable(false);
        botonAdelante.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));

        botonAtras.setText("Atras");
        botonAdelante.setText("Adelante");
        botonNuevo.setText("Nuevo");
        botonGuardar.setText("Guardar");
        
        botonAtras.setVisible(false);
        botonAdelante.setVisible(false);
        botonNuevo.setVisible(true);
        botonGuardar.setVisible(false);
        
        // Add botonNuevo to the bottom of panelLateral
        panelLateral.add(botonNuevo);
        panelLateral.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
    
    private void addButtonListeners() {
        botonNuevo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                vistaActual = 1;
                switchToPanelByIndex(vistaActual); // Switch to vistaUsuario (index 1)
            }
        });

        botonAdelante.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                goForward(); // Switch to vistaCoche (index 3)
            }
        });
        
        botonAtras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                goBackward(); // Switch to vistaCoche (index 3)
            }
        });

        botonGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //guardar()
            }
        });
    }
    
    // New method to handle moving forward
    private void goForward() {        
        if (vistaActual < 5) { // Update the number of panels if needed
            switchToPanelByIndex(++vistaActual);
        }
    }

    // New method to handle moving backward
    private void goBackward() {
        if (vistaActual > 0) {
            switchToPanelByIndex(--vistaActual);
        }
    }
    
    private void switchToPanelByIndex(int index) {
        // Hide all panels first
        vistaPrincipal.setVisible(false);
        vistaUsuario.setVisible(false);
        vistaCoche.setVisible(false);
        vistaSeguro.setVisible(false);
        vistaCobro.setVisible(false);
        vistaResumen.setVisible(false);

        // Show the panel based on the index
        switch (index) {
            case 0:
                vistaPrincipal.setVisible(true);
                break;
            case 1:
                vistaUsuario.setVisible(true);
                break;
            case 2:
                vistaCoche.setVisible(true);
                break;
            case 3:
                vistaSeguro.setVisible(true);
                break;
            case 4:
                vistaCobro.setVisible(true);
                break;
            case 5:
                vistaResumen.setVisible(true);
                break;
            // Add more cases if needed for additional panels
            default:
                break;
        }
        
        if (vistaActual == 0) {
            botonAtras.setVisible(false);
            botonAdelante.setVisible(false);
            botonNuevo.setVisible(true);
        } else if (vistaActual == 1) {
            botonAtras.setVisible(true);
            botonAdelante.setVisible(true);
            botonNuevo.setVisible(false);
        } else if (vistaActual == 5) { 
            botonAdelante.setVisible(false);
            botonGuardar.setVisible(true);
        } else {
            botonAdelante.setVisible(true);
            botonAtras.setVisible(true);
            botonGuardar.setVisible(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelLateral = new javax.swing.JPanel();
        contenedorVistas = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout panelLateralLayout = new javax.swing.GroupLayout(panelLateral);
        panelLateral.setLayout(panelLateralLayout);
        panelLateralLayout.setHorizontalGroup(
            panelLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 140, Short.MAX_VALUE)
        );
        panelLateralLayout.setVerticalGroup(
            panelLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout contenedorVistasLayout = new javax.swing.GroupLayout(contenedorVistas);
        contenedorVistas.setLayout(contenedorVistasLayout);
        contenedorVistasLayout.setHorizontalGroup(
            contenedorVistasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 633, Short.MAX_VALUE)
        );
        contenedorVistasLayout.setVerticalGroup(
            contenedorVistasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelLateral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contenedorVistas))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelLateral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(contenedorVistas)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vista().setVisible(true);
            }
        });
    }
    
    private int vistaActual;
    
    private javax.swing.JPanel vistaPrincipal;
    private javax.swing.JPanel vistaUsuario;
    private javax.swing.JPanel vistaCoche;
    private javax.swing.JPanel vistaSeguro;
    private javax.swing.JPanel vistaCobro;
    private javax.swing.JPanel vistaResumen;
    
    private javax.swing.JButton botonAtras;
    private javax.swing.JButton botonAdelante;
    private javax.swing.JButton botonNuevo;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonModificar;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane contenedorVistas;
    private javax.swing.JPanel panelLateral;
    // End of variables declaration//GEN-END:variables
}
