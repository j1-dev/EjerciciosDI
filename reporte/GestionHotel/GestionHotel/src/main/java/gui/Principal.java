/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import dto.Reserva;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author diego
 */
public class Principal extends javax.swing.JFrame {
    
    private static ArrayList<Reserva> listaEventos = new ArrayList<>();

    /**
     * Creates new form Principal
     */
    public Principal() {
        this.setExtendedState(this.MAXIMIZED_BOTH); 
        this.setVisible(true);
        initComponents();
        inicializarTabla();
    }
    
    private void inicializarTabla(){
        JTableHeader header = tablaReservas.getTableHeader();
        header.setPreferredSize(new java.awt.Dimension(0, 50));
        header.setFont(new Font("Helvetica Neue", Font.BOLD,16));
        ((DefaultTableCellRenderer) header.getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
        
        // Crear un TableRowSorter y configurarlo para ordenar la columna de fechas
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(tablaReservas.getModel());
        tablaReservas.setRowSorter(sorter);

        // Configurar un comparador personalizado para ordenar las fechas
        Comparator<Date> dateComparator = (date1, date2) -> date1.compareTo(date2);
        sorter.setComparator(2, dateComparator);
        
    }
    
    public static boolean existeReserva(Reserva nuevoEvento) {
        if (!listaEventos.isEmpty()) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

            for (Reserva evento : listaEventos) {
                String fechaEvento1 = dateFormat.format(evento.getFechaEvento());
                String fechaEvento2 = dateFormat.format(nuevoEvento.getFechaEvento());

                //Mismo día mismo tipo evento
                if (evento.getTipoEvento().equals(nuevoEvento.getTipoEvento()) &&
                    fechaEvento1.equals(fechaEvento2)) {
                    //Mismo día misma sala // ya sabemos que no es el mismo tipo evento
                    if(evento.getSala().equals(nuevoEvento.getSala()) && 
                            fechaEvento1.equals(fechaEvento2)){
                        return true; // Ya existe una reserva del mismo tipo en la misma fecha
                    }
                }
            }
        }
        return false;
    }
    
    public void anadirReserva(Reserva reserva){
        DefaultTableModel dtm = (DefaultTableModel) tablaReservas.getModel();
        dtm.addRow(reserva.toArrayStrings());
        listaEventos.add(reserva);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        lbTituloHotel = new javax.swing.JLabel();
        panelInteriorIzq = new javax.swing.JPanel();
        lbNuevaReserva = new javax.swing.JLabel();
        panelBotonesReserva = new javax.swing.JPanel();
        btVaradero = new javax.swing.JButton();
        btHabana = new javax.swing.JButton();
        btCamaguey = new javax.swing.JButton();
        btSalir = new javax.swing.JButton();
        panelInteriorDer = new javax.swing.JPanel();
        lbConsultaDisponibilidad = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaReservas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setName("Principal"); // NOI18N

        panelPrincipal.setBackground(new java.awt.Color(255, 255, 255));

        lbTituloHotel.setBackground(new java.awt.Color(0, 0, 0));
        lbTituloHotel.setFont(new java.awt.Font("Krungthep", 0, 36)); // NOI18N
        lbTituloHotel.setForeground(new java.awt.Color(255, 255, 255));
        lbTituloHotel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTituloHotel.setText("HOTEL BELLAVISTA");
        lbTituloHotel.setOpaque(true);

        panelInteriorIzq.setBackground(new java.awt.Color(255, 255, 255));

        lbNuevaReserva.setFont(new java.awt.Font("Trattatello", 0, 24)); // NOI18N
        lbNuevaReserva.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbNuevaReserva.setText("NUEVA RESERVA");

        panelBotonesReserva.setBackground(new java.awt.Color(255, 255, 255));

        btVaradero.setBackground(new java.awt.Color(0, 0, 0));
        btVaradero.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        btVaradero.setForeground(new java.awt.Color(255, 255, 255));
        btVaradero.setIcon(new javax.swing.ImageIcon("/Users/diego/Documents/Interfaces/NetBeansProjects/GestionHotel/src/Other Resources/sala2 (1).jpg")); // NOI18N
        btVaradero.setText("Varadero");
        btVaradero.setBorder(null);
        btVaradero.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btVaradero.setIconTextGap(40);
        btVaradero.setMargin(new java.awt.Insets(0, 14, 30, 14));
        btVaradero.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        btVaradero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVaraderoActionPerformed(evt);
            }
        });

        btHabana.setBackground(new java.awt.Color(0, 0, 0));
        btHabana.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        btHabana.setForeground(new java.awt.Color(255, 255, 255));
        btHabana.setIcon(new javax.swing.ImageIcon("/Users/diego/Documents/Interfaces/NetBeansProjects/GestionHotel/src/Other Resources/habana(1).jpeg")); // NOI18N
        btHabana.setText("Habana");
        btHabana.setBorder(null);
        btHabana.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btHabana.setIconTextGap(40);
        btHabana.setMargin(new java.awt.Insets(0, 14, 30, 14));
        btHabana.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        btHabana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btHabanaActionPerformed(evt);
            }
        });

        btCamaguey.setBackground(new java.awt.Color(0, 0, 0));
        btCamaguey.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        btCamaguey.setForeground(new java.awt.Color(255, 255, 255));
        btCamaguey.setIcon(new javax.swing.ImageIcon("/Users/diego/Documents/Interfaces/NetBeansProjects/GestionHotel/src/Other Resources/sala3 (1).jpg")); // NOI18N
        btCamaguey.setText("Camagüey");
        btCamaguey.setToolTipText("");
        btCamaguey.setBorder(null);
        btCamaguey.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btCamaguey.setIconTextGap(40);
        btCamaguey.setMargin(new java.awt.Insets(0, 14, 30, 14));
        btCamaguey.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        btCamaguey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCamagueyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBotonesReservaLayout = new javax.swing.GroupLayout(panelBotonesReserva);
        panelBotonesReserva.setLayout(panelBotonesReservaLayout);
        panelBotonesReservaLayout.setHorizontalGroup(
            panelBotonesReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesReservaLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(btHabana, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76)
                .addComponent(btVaradero, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addComponent(btCamaguey, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );
        panelBotonesReservaLayout.setVerticalGroup(
            panelBotonesReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesReservaLayout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(panelBotonesReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btCamaguey, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btHabana, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btVaradero, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(113, Short.MAX_VALUE))
        );

        btSalir.setBackground(new java.awt.Color(255, 102, 102));
        btSalir.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        btSalir.setText("Salir");
        btSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelInteriorIzqLayout = new javax.swing.GroupLayout(panelInteriorIzq);
        panelInteriorIzq.setLayout(panelInteriorIzqLayout);
        panelInteriorIzqLayout.setHorizontalGroup(
            panelInteriorIzqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInteriorIzqLayout.createSequentialGroup()
                .addGap(205, 205, 205)
                .addComponent(lbNuevaReserva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(199, 199, 199))
            .addGroup(panelInteriorIzqLayout.createSequentialGroup()
                .addGroup(panelInteriorIzqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInteriorIzqLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(panelBotonesReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelInteriorIzqLayout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(btSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        panelInteriorIzqLayout.setVerticalGroup(
            panelInteriorIzqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInteriorIzqLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lbNuevaReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(panelBotonesReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 140, Short.MAX_VALUE)
                .addComponent(btSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75))
        );

        panelInteriorDer.setBackground(new java.awt.Color(204, 204, 204));

        lbConsultaDisponibilidad.setFont(new java.awt.Font("Trattatello", 0, 24)); // NOI18N
        lbConsultaDisponibilidad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbConsultaDisponibilidad.setText("CONSULTA DISPONIBILIDAD");

        tablaReservas.setFont(new java.awt.Font("Helvetica Neue", 0, 12)); // NOI18N
        tablaReservas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Tipo", "Sala", "Nombre", "Fecha", "Duración"
            }
        ));
        tablaReservas.setGridColor(new java.awt.Color(255, 255, 255));
        tablaReservas.setOpaque(false);
        tablaReservas.setRowHeight(30);
        jScrollPane1.setViewportView(tablaReservas);

        javax.swing.GroupLayout panelInteriorDerLayout = new javax.swing.GroupLayout(panelInteriorDer);
        panelInteriorDer.setLayout(panelInteriorDerLayout);
        panelInteriorDerLayout.setHorizontalGroup(
            panelInteriorDerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInteriorDerLayout.createSequentialGroup()
                .addContainerGap(176, Short.MAX_VALUE)
                .addComponent(lbConsultaDisponibilidad)
                .addContainerGap(175, Short.MAX_VALUE))
            .addGroup(panelInteriorDerLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
                .addGap(47, 47, 47))
        );
        panelInteriorDerLayout.setVerticalGroup(
            panelInteriorDerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInteriorDerLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(lbConsultaDisponibilidad)
                .addGap(80, 80, 80)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 758, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addComponent(panelInteriorIzq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelInteriorDer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(lbTituloHotel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTituloHotel, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelInteriorIzq, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelInteriorDer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btHabanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btHabanaActionPerformed
        NuevaReserva nuevaReserva = new NuevaReserva(this, rootPaneCheckingEnabled, "HABANA");
        nuevaReserva.setVisible(true);
    }//GEN-LAST:event_btHabanaActionPerformed

    private void btVaraderoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVaraderoActionPerformed
        NuevaReserva nuevaReserva = new NuevaReserva(this, rootPaneCheckingEnabled, "VARADERO");
        nuevaReserva.setVisible(true);

    }//GEN-LAST:event_btVaraderoActionPerformed

    private void btCamagueyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCamagueyActionPerformed
        NuevaReserva nuevaReserva = new NuevaReserva(this, rootPaneCheckingEnabled, "CAMAGÜEY");
        nuevaReserva.setVisible(true);

    }//GEN-LAST:event_btCamagueyActionPerformed

    private void btSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btSalirActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCamaguey;
    private javax.swing.JButton btHabana;
    private javax.swing.JButton btSalir;
    private javax.swing.JButton btVaradero;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbConsultaDisponibilidad;
    private javax.swing.JLabel lbNuevaReserva;
    private javax.swing.JLabel lbTituloHotel;
    private javax.swing.JPanel panelBotonesReserva;
    private javax.swing.JPanel panelInteriorDer;
    private javax.swing.JPanel panelInteriorIzq;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JTable tablaReservas;
    // End of variables declaration//GEN-END:variables
}
