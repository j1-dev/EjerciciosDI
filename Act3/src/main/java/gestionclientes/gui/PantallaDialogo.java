/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package gestionclientes.gui;

import gestionclientes.dto.Cliente;
import java.util.Date;

/**
 *
 * @author j1
 */
public class PantallaDialogo extends javax.swing.JDialog {

    private PantallaPrincipal pantallaPrincipal;
    /**
     * Creates new form PantallaDialogo
     */
    public PantallaDialogo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        btAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAltaActionPerformed(evt);
            }
        });
        pantallaPrincipal = (PantallaPrincipal) parent;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        etNombre = new javax.swing.JLabel();
        etApellidos = new javax.swing.JLabel();
        etFecha = new javax.swing.JLabel();
        etProvincia = new javax.swing.JLabel();
        tfNombre = new javax.swing.JTextField();
        tfApellidos = new javax.swing.JTextField();
        spFecha = new javax.swing.JSpinner();
        cbProvincia = new javax.swing.JComboBox<>();
        btAlta = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cbConsent = new javax.swing.JCheckBox();
        etError = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        slNivel = new javax.swing.JSlider();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        etNombre.setText("Nombre");

        etApellidos.setText("Apellidos");

        etFecha.setText("Fecha de alta");

        etProvincia.setText("Provincia");

        tfNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNombreActionPerformed(evt);
            }
        });

        spFecha.setModel(new javax.swing.SpinnerDateModel());

        cbProvincia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Almería", "Granada", "Jaén", "Málaga", "Córdoba", "Sevilla", "Cádiz", "Huelva" }));

        btAlta.setText("Alta");

        jLabel1.setText("Acepto la política de privacidad");

        cbConsent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbConsentActionPerformed(evt);
            }
        });

        etError.setForeground(new java.awt.Color(255, 51, 51));

        jLabel2.setText("Nivel de inglés (1-5)");

        slNivel.setMaximum(5);
        slNivel.setMinimum(1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(etNombre)
                                    .addComponent(etApellidos)
                                    .addComponent(etFecha)
                                    .addComponent(etProvincia))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(spFecha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                                    .addComponent(tfApellidos, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(tfNombre, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cbProvincia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(etError)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(89, 89, 89)
                        .addComponent(slNivel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbConsent)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(etNombre)
                            .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(etApellidos)
                            .addComponent(tfApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(etFecha)
                            .addComponent(spFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(etProvincia)
                            .addComponent(cbProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(slNivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jLabel2)))
                        .addGap(26, 26, 26)
                        .addComponent(jLabel1))
                    .addComponent(cbConsent))
                .addGap(30, 30, 30)
                .addComponent(etError)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(btAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNombreActionPerformed
    }//GEN-LAST:event_tfNombreActionPerformed

    private void cbConsentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbConsentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbConsentActionPerformed

    private void btAltaActionPerformed(java.awt.event.ActionEvent evt){
        boolean consent = cbConsent.isSelected();
        if(consent){     
            String nombre = tfNombre.getText();
            String apellidos = tfApellidos.getText();
            Date fechaAlta = (Date) spFecha.getValue();
            String provincia = (String) cbProvincia.getSelectedItem();
            int nivelIngles = slNivel.getValue();
            
            if(!nombre.isEmpty() && !apellidos.isEmpty() && fechaAlta != null && !provincia.isEmpty()){
                Cliente cliente = new Cliente(nombre, apellidos, fechaAlta, provincia, nivelIngles); 
                pantallaPrincipal.anadirCliente(cliente);
                setVisible(false);
            } else {
                etError.setText("Debe rellenar todos los campos");
            }
        } else {
            etError.setText("Debe aceptar las condiciones");
        }
        
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlta;
    private javax.swing.JCheckBox cbConsent;
    private javax.swing.JComboBox<String> cbProvincia;
    private javax.swing.JLabel etApellidos;
    private javax.swing.JLabel etError;
    private javax.swing.JLabel etFecha;
    private javax.swing.JLabel etNombre;
    private javax.swing.JLabel etProvincia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSlider slNivel;
    private javax.swing.JSpinner spFecha;
    private javax.swing.JTextField tfApellidos;
    private javax.swing.JTextField tfNombre;
    // End of variables declaration//GEN-END:variables
}
