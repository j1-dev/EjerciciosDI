/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.rentacar.ui;

import com.mycompany.rentacar.model.Coche;
import com.mycompany.rentacar.model.Reserva;
import com.mycompany.rentacar.model.ReservasListener;
import com.mycompany.rentacar.model.SelectionListener;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
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
        
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!isSelected) {
                    selectCard();
                } else {
                    deselectCard();
                }
            }
        });
    }
    
    private void setupComponents() {
        nameLabel = new JLabel("Usuario:");
        carLabel = new JLabel("Coche:");
        paymentModeLabel = new JLabel("Modo de Pago:");

        nameTextLabel = new JLabel();
        carTextLabel = new JLabel();
        paymentModeTextLabel = new JLabel();

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
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
                        .addComponent(nameTextLabel, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                        .addComponent(carTextLabel, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                        .addComponent(paymentModeTextLabel, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
                    .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(nameTextLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(carLabel)
                    .addComponent(carTextLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(paymentModeLabel)
                    .addComponent(paymentModeTextLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, 0) // Set preferred height
        );

        // Set font for labels
        nameLabel.setFont(new Font("Arial", Font.BOLD, 12));
        carLabel.setFont(new Font("Arial", Font.BOLD, 12));
        paymentModeLabel.setFont(new Font("Arial", Font.BOLD, 12));
    }
    
    private void selectCard() {
        if (selectedListaItem != null && selectedListaItem != this) {
            selectedListaItem.deselectCard(); // Deselect the previously selected item
        }
        isSelected = true;
        setBorder(BorderFactory.createLineBorder(Color.decode("#F9AB55"), 2));
        selectedListaItem = this;

        // Trigger the onCardSelected method of the listener if available
        if (selectionListener != null) {
            selectionListener.onCardSelected(reserva);
        }
    }

    public void deselectCard() {
        isSelected = false;
        
        if (selectionListener != null) {
            selectionListener.onCardUnselected();
        }
        
        setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
        // Clear the selected item reference if this item is deselected
        if (selectedListaItem == this) {
            selectedListaItem = null;
        }
    }
    
    public void setReservaInfo(Reserva reserva) {
        this.reserva = reserva;
        nameTextLabel.setText(reserva.getUsuario().getNombre());
        carTextLabel.setText(reserva.getCoche().getModeloCoche());
        paymentModeTextLabel.setText(reserva.getModoCobro());
    }

    public void setSelectionListener(ReservasListener listener) {
        this.selectionListener = listener;
    }
    
    public boolean isSelected(){
        return isSelected;
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

    private ReservasListener selectionListener;
    private Reserva reserva;
    private boolean isSelected;
    private static ListaItem selectedListaItem;
    
    private JLabel nameLabel;
    private JLabel carLabel;
    private JLabel paymentModeLabel;

    private JLabel nameTextLabel;
    private JLabel carTextLabel;
    private JLabel paymentModeTextLabel;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
