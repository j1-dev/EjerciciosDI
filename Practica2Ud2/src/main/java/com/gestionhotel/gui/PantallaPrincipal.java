/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.gestionhotel.gui;

import javax.swing.JOptionPane;
import javax.swing.SpinnerDateModel;

/**
 *
 * @author j1
 */
public class PantallaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form PantallaPrincipal
     */
    public PantallaPrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        pHabana = new javax.swing.JPanel();
        spHabana = new javax.swing.JScrollPane();
        tbHabana = new javax.swing.JTable();
        pVaradero = new javax.swing.JPanel();
        spVaradero = new javax.swing.JScrollPane();
        tbVaradero = new javax.swing.JTable();
        pCamaguei = new javax.swing.JPanel();
        spCamaguei = new javax.swing.JScrollPane();
        tbCamaguei = new javax.swing.JTable();
        btNuevo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbHabana.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        spHabana.setViewportView(tbHabana);

        javax.swing.GroupLayout pHabanaLayout = new javax.swing.GroupLayout(pHabana);
        pHabana.setLayout(pHabanaLayout);
        pHabanaLayout.setHorizontalGroup(
            pHabanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pHabanaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spHabana, javax.swing.GroupLayout.DEFAULT_SIZE, 835, Short.MAX_VALUE)
                .addContainerGap())
        );
        pHabanaLayout.setVerticalGroup(
            pHabanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pHabanaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spHabana, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Habana", pHabana);

        tbVaradero.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        spVaradero.setViewportView(tbVaradero);

        javax.swing.GroupLayout pVaraderoLayout = new javax.swing.GroupLayout(pVaradero);
        pVaradero.setLayout(pVaraderoLayout);
        pVaraderoLayout.setHorizontalGroup(
            pVaraderoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pVaraderoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spVaradero, javax.swing.GroupLayout.DEFAULT_SIZE, 835, Short.MAX_VALUE)
                .addContainerGap())
        );
        pVaraderoLayout.setVerticalGroup(
            pVaraderoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pVaraderoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spVaradero, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Varadero", pVaradero);

        tbCamaguei.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        spCamaguei.setViewportView(tbCamaguei);

        javax.swing.GroupLayout pCamagueiLayout = new javax.swing.GroupLayout(pCamaguei);
        pCamaguei.setLayout(pCamagueiLayout);
        pCamagueiLayout.setHorizontalGroup(
            pCamagueiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pCamagueiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spCamaguei, javax.swing.GroupLayout.DEFAULT_SIZE, 835, Short.MAX_VALUE)
                .addContainerGap())
        );
        pCamagueiLayout.setVerticalGroup(
            pCamagueiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pCamagueiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spCamaguei, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Camagüei", pCamaguei);

        btNuevo.setText("Nuevo");
        btNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNuevoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(btNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNuevoActionPerformed
        String sala = jTabbedPane1.getTitleAt(jTabbedPane1.getSelectedIndex());
        int resultado = JOptionPane.showConfirmDialog(this,"Crear evento en la sala " + sala + "?", "Crear evento", JOptionPane.YES_NO_OPTION);
        if(resultado==JOptionPane.YES_OPTION){
            PantallaPersona pp = new PantallaPersona(this, true);
            pp.setVisible(true);
        } 
    }//GEN-LAST:event_btNuevoActionPerformed

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
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btNuevo;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel pCamaguei;
    private javax.swing.JPanel pHabana;
    private javax.swing.JPanel pVaradero;
    private javax.swing.JScrollPane spCamaguei;
    private javax.swing.JScrollPane spHabana;
    private javax.swing.JScrollPane spVaradero;
    private javax.swing.JTable tbCamaguei;
    private javax.swing.JTable tbHabana;
    private javax.swing.JTable tbVaradero;
    // End of variables declaration//GEN-END:variables
}
