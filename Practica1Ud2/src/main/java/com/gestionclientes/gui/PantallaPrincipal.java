/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.gestionclientes.gui;

import com.gestionclientes.dto.Cliente;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

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
        inicializarTabla();
    }
    
    private void inicializarTabla(){
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.setColumnIdentifiers(new String[]{"Nombre", "Apellidos", "Género", "DNI", "Correo electrónico", "Deportes preferidos", "Talla de ropa", "Talla de pie", "Edad", "Acepta los términos"});
        tbClientes.setModel(dtm);
    }
    
    public void anadirCliente(Cliente cliente){
        DefaultTableModel dtm = (DefaultTableModel)tbClientes.getModel();
        dtm.addRow(cliente.toArrayString());
    }
    
    public void borrarCliente(int index){
        DefaultTableModel dtm = (DefaultTableModel)tbClientes.getModel();
        dtm.removeRow(index);  
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbClientes = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        opAlta = new javax.swing.JMenuItem();
        opBaja = new javax.swing.JMenuItem();


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbClientes.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbClientes);

        jMenu1.setText("Cliente");

        opAlta.setText("Dar de alta...");
        opAlta.setVerifyInputWhenFocusTarget(false);
        opAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opNuevoActionPerformed(evt);
            }
        });
        jMenu1.add(opAlta);
        opAlta.getAccessibleContext().setAccessibleName("Dar de alta");
        opAlta.getAccessibleContext().setAccessibleDescription("");
        
        opBaja.setText("Dar de baja...");
        opBaja.setVerifyInputWhenFocusTarget(false);
        opBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opBajaActionPerformed(evt);
            }
        });
        jMenu1.add(opBaja);
        opBaja.getAccessibleContext().setAccessibleName("Dar de baja");
        opBaja.getAccessibleContext().setAccessibleDescription("");

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 767, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    private void opNuevoActionPerformed(java.awt.event.ActionEvent evt) {                                        
        PantallaPrimerPaso alta = new PantallaPrimerPaso(this,true);
        alta.setVisible(true);
    }  
    
    private void opBajaActionPerformed(java.awt.event.ActionEvent evt) {                                        
        PantallaBaja baja = new PantallaBaja(this,true);
        baja.setTbClientes(tbClientes);
        baja.setVisible(true);
    } 
    
    public javax.swing.JTable getTbClientes(){
        return tbClientes;
    }
    
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
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    // Set System L&F
                    UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
                } 
                catch (UnsupportedLookAndFeelException | 
                       ClassNotFoundException | 
                       InstantiationException | 
                       IllegalAccessException e) {
                    // handle exception
                }

                PantallaPrincipal pantallaPrincipal = new PantallaPrincipal();
                pantallaPrincipal.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem opAlta;
    private javax.swing.JMenuItem opBaja;
    private javax.swing.JTable tbClientes;
    // End of variables declaration                   
}
