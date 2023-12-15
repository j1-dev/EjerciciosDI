/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.rentacar.ui;

import com.mycompany.rentacar.model.Reserva;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author j1
 */
public class ListaItem extends javax.swing.JPanel {

    /**
     * Creates new form ListaItem
     */
    public ListaItem() {
        initComponents();
        setupComponents();
    }
    
    private void setupComponents() {
        nameLabel = new JLabel("Usuario:");
        carLabel = new JLabel("Coche:");
        paymentModeLabel = new JLabel("Modo de Pago:");

        nameTextField = new JTextField();
        carTextField = new JTextField();
        paymentModeTextField = new JTextField();

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(nameLabel)
                        .addComponent(carLabel)
                        .addComponent(paymentModeLabel))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(nameTextField, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                        .addComponent(carTextField, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                        .addComponent(paymentModeTextField, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
                    .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(nameLabel)
                        .addComponent(nameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(carLabel)
                        .addComponent(carTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(paymentModeLabel)
                        .addComponent(paymentModeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        // Set font for labels
        nameLabel.setFont(new Font("Arial", Font.BOLD, 12));
        carLabel.setFont(new Font("Arial", Font.BOLD, 12));
        paymentModeLabel.setFont(new Font("Arial", Font.BOLD, 12));
    }
    
    public void setReservaInfo(Reserva reserva) {
        nameTextField.setText(reserva.getUsuario().getNombre());
        carTextField.setText(reserva.getCoche().getModeloCoche());
        paymentModeTextField.setText(reserva.getModoCobro());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private JLabel nameLabel;
    private JLabel carLabel;
    private JLabel paymentModeLabel;

    private JTextField nameTextField;
    private JTextField carTextField;
    private JTextField paymentModeTextField;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
