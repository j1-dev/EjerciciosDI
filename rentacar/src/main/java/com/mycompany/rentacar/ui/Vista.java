/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.rentacar.ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

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
    }
    
    private void initializePanels() {
        // Initialize vistaPrincipal
        vistaPrincipal = new JPanel();
        vistaPrincipal.setBackground(Color.RED); // Adding background color for visual distinction
        contenedorVistas.add(vistaPrincipal, 0); // Add vistaPrincipal at layer 1
        vistaPrincipal.setBounds(0, 0, 700, 500); // Set bounds as needed

        // Initialize vistaUsuario
        vistaUsuario = new JPanel();
        vistaUsuario.setBackground(Color.BLUE); // Adding background color for visual distinction
        contenedorVistas.add(vistaUsuario, 1); // Add vistaUsuario at layer 2
        vistaUsuario.setBounds(0, 0, 700, 500); // Set bounds as needed
        vistaUsuario.setVisible(false); // Initially hide vistaUsuario

        // Initialize vistaCoche
        vistaCoche = new JPanel();
        vistaCoche.setBackground(Color.GREEN); // Adding background color for visual distinction
        contenedorVistas.add(vistaCoche, 2); // Add vistaCoche at layer 3
        vistaCoche.setBounds(0, 0, 700, 500); // Set bounds as needed
        vistaCoche.setVisible(false); // Initially hide vistaCoche

        // Initialize vistaSeguro
        vistaSeguro = new JPanel();
        vistaSeguro.setBackground(Color.YELLOW); // Adding background color for visual distinction
        contenedorVistas.add(vistaSeguro, 3); // Add vistaSeguro at layer 4
        vistaSeguro.setBounds(0, 0, 700, 500); // Set bounds as needed
        vistaSeguro.setVisible(false); // Initially hide vistaSeguro

        // Initialize vistaCobro
        vistaCobro = new JPanel();
        vistaCobro.setBackground(Color.ORANGE); // Adding background color for visual distinction
        contenedorVistas.add(vistaCobro, 4); // Add vistaCobro at layer 5
        vistaCobro.setBounds(0, 0, 700, 500); // Set bounds as needed
        vistaCobro.setVisible(false); // Initially hide vistaCobro

        // Initialize vistaResumen
        vistaResumen = new JPanel();
        vistaResumen.setBackground(Color.CYAN); // Adding background color for visual distinction
        contenedorVistas.add(vistaResumen, 5); // Add vistaResumen at layer 6
        vistaResumen.setBounds(0, 0, 700, 500); // Set bounds as needed
        vistaResumen.setVisible(false); // Initially hide vistaResumen
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
        botonNuevo.setBounds(10,400,80,50);

        // Add botonAtras and botonAdelante to the bottom of contenedorVistas
        contenedorVistas.add(botonAtras);
        contenedorVistas.setLayer(botonAtras, JLayeredPane.POPUP_LAYER);
        botonAtras.setBounds(400, 400, 100, 50);

        contenedorVistas.add(botonAdelante);
        contenedorVistas.setLayer(botonAdelante, JLayeredPane.POPUP_LAYER);
        botonAdelante.setBounds(500, 400, 100, 50);

        botonAtras.setText("Atras");
        botonAdelante.setText("Adelante");
        botonNuevo.setText("Nuevo");

        // Set the initial visibility based on the default vistaActual value
        if (vistaActual == 0) {
            botonAtras.setVisible(false);
            botonAdelante.setVisible(true);
        } else if (vistaActual == 5) {
            botonAtras.setVisible(true);
            botonAdelante.setVisible(false);
        } else {
            botonAtras.setVisible(true);
            botonAdelante.setVisible(true);
        }
        
        // Add botonNuevo to the bottom of panelLateral
        panelLateral.add(botonNuevo);
    }
    
    private void addButtonListeners() {
        // Add action listener to the New Booking button in panelLateral
        botonNuevo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Enable/disable the New Booking button based on vistaPrincipal visibility
                if (vistaPrincipal.isVisible()) {
                    // Start the booking process
                    switchToPanelByIndex(1); // Switch to vistaUsuario (index 2)
                }
            }
        });

        // Add action listeners to forward/back buttons in each panel
        // Add listeners for forward and back buttons in vistaUsuario
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


        // Similar action listeners for other panels' navigation buttons
    }
    
    // New method to handle moving forward
    private void goForward() {
        if (vistaActual < 5) { // Update the number of panels if needed
            switchToPanelByIndex(vistaActual + 1);
            vistaActual++;
            botonAtras.setVisible(true);
        }

        if (vistaActual == 5) { // Update the number of panels if needed
            botonAdelante.setVisible(false);
        }
    }

    // New method to handle moving backward
    private void goBackward() {
        if (vistaActual > 0) {
            switchToPanelByIndex(vistaActual - 1);
            vistaActual--;
            botonAdelante.setVisible(true);
        }

        if (vistaActual == 0) {
            botonAtras.setVisible(false);
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
            case 1:
                vistaPrincipal.setVisible(true);
                break;
            case 2:
                vistaUsuario.setVisible(true);
                break;
            case 3:
                vistaCoche.setVisible(true);
                break;
            case 4:
                vistaSeguro.setVisible(true);
                break;
            case 5:
                vistaCobro.setVisible(true);
                break;
            case 6:
                vistaResumen.setVisible(true);
                break;
            // Add more cases if needed for additional panels
            default:
                break;
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
        setPreferredSize(new java.awt.Dimension(800, 500));

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
                .addComponent(contenedorVistas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

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
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane contenedorVistas;
    private javax.swing.JPanel panelLateral;
    // End of variables declaration//GEN-END:variables
}
