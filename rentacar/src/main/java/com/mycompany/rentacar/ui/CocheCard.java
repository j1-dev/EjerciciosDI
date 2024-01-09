/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.rentacar.ui;

import com.mycompany.rentacar.model.Coche;
import com.mycompany.rentacar.model.SelectionListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author Juan
 */
public class CocheCard extends javax.swing.JPanel {

    /**
     * Creates new form CocheCard
     */
    public CocheCard() {
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
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(300, 250));
        setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));

        imagenLabel = new JLabel();
        imagenLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(imagenLabel, BorderLayout.CENTER);

        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BorderLayout());
        infoPanel.setBackground(Color.WHITE);
        add(infoPanel, BorderLayout.SOUTH);

        modeloLabel = createLabel();
        matriculaLabel = createLabel();
        precioDiaLabel = createLabel();
        precioSemanaLabel = createLabel();
        precioPorKilometroLabel = createLabel();

        infoPanel.add(modeloLabel, BorderLayout.NORTH);
        infoPanel.add(matriculaLabel, BorderLayout.CENTER);
        infoPanel.add(precioDiaLabel, BorderLayout.WEST);
        infoPanel.add(precioSemanaLabel, BorderLayout.EAST);
        infoPanel.add(precioPorKilometroLabel, BorderLayout.SOUTH);
    }
    
    private JLabel createLabel() {
        JLabel label = new JLabel();
        label.setFont(new Font("Arial", Font.PLAIN, 12));
        label.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        return label;
    }
    
    public void setCocheInfo(Coche coche) {
        this.coche = coche;
        
        modeloLabel.setText("Modelo: " + coche.getModeloCoche());
        matriculaLabel.setText("Matrícula: " + coche.getMatricula());
        precioDiaLabel.setText("Precio por día: $" + coche.getPrecioDia());
        precioSemanaLabel.setText("Precio por semana: $" + coche.getPrecioSemana());
        precioPorKilometroLabel.setText("Precio por kilómetro: $" + coche.getPrecioPorKilometro());

        displayCarImage(coche.getImgPath());
    }
    
    public void setSelectionListener(SelectionListener listener) {
        this.selectionListener = listener;
    }
    
    private void selectCard() {
        isSelected = true;
        setBorder(BorderFactory.createLineBorder(Color.decode("#F9AB55"), 2));
        if (selectionListener != null) {
            selectionListener.onCardSelected(coche);
        }
        // Deselect other cards
        Container parent = getParent();
        if (parent != null) {
            for (Component component : parent.getComponents()) {
                if (component instanceof CocheCard && component != this) {
                    ((CocheCard) component).deselectCard();
                }
            }
        }
    }

    public void deselectCard() {
        isSelected = false;
        setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
    }
    
    private void displayCarImage(String imagePath) {
        ImageIcon icon = new ImageIcon(imagePath);
        Image image = icon.getImage().getScaledInstance(200, 150, Image.SCALE_SMOOTH);
        imagenLabel.setIcon(new ImageIcon(image));
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
    private SelectionListener selectionListener;
    private Coche coche;
    private boolean isSelected;
    
    private JLabel modeloLabel;
    private JLabel matriculaLabel;
    private JLabel precioDiaLabel;
    private JLabel precioSemanaLabel;
    private JLabel precioPorKilometroLabel;
    private JLabel imagenLabel;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
