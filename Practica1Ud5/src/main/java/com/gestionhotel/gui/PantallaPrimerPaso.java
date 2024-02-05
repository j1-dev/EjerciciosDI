/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.gestionhotel.gui;

import com.gestionhotel.dto.Evento;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.ButtonModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import com.gestionhotel.dto.Persona;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractButton;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author j1
 */
public class PantallaPrimerPaso extends javax.swing.JDialog {
    
    private PantallaPersona pantallaPersona;
    private PantallaSegundoPaso pantallaSegundoPaso;
    private PantallaPrincipal pantallaPrincipal;
    private Persona persona;
    private String sala;

    /**
     * Creates new form PantallaPrimerPaso
     */
    public PantallaPrimerPaso(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("Hotel Marshall | Datos de la Reserva (1/2)");
        pantallaPrincipal = (PantallaPrincipal)parent;
        pnCongreso.setVisible(false);
        sFecha.setModel(new SpinnerDateModel(new Date(), null, null, Calendar.MONTH));
        sFecha.setEditor(new JSpinner.DateEditor(sFecha,"dd/MM/yy"));
        sNumDias.setModel(new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rgTipo = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        rbBanquete = new javax.swing.JRadioButton();
        rbJornada = new javax.swing.JRadioButton();
        etError = new javax.swing.JLabel();
        rbCongreso = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        sFecha = new javax.swing.JSpinner();
        pnCongreso = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        checkHabitaciones = new javax.swing.JCheckBox();
        sNumDias = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        tfNumPersonas = new javax.swing.JTextField();
        btAtras = new javax.swing.JButton();
        btSiguiente = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(413, 440));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Tipo de evento");
        jLabel1.setToolTipText("Elige el tipo de evento");

        rgTipo.add(rbBanquete);
        rbBanquete.setText("Banquete");
        rbBanquete.setToolTipText("Banquete de empresa multitudinario");
        rbBanquete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbBanqueteActionPerformed(evt);
            }
        });

        rgTipo.add(rbJornada);
        rbJornada.setText("Jornada");
        rbJornada.setToolTipText("Jornadas formativas o eventos puntuales");
        rbJornada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbJornadaActionPerformed(evt);
            }
        });

        etError.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        etError.setForeground(new java.awt.Color(255, 51, 51));

        rgTipo.add(rbCongreso);
        rbCongreso.setText("Congreso");
        rbCongreso.setToolTipText("Congresos de múltiples días con opción de habitaciones");
        rbCongreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbCongresoActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Fecha");

        sFecha.setToolTipText("Fecha inicial del evento");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Numero de días");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Requiere habitaciones?");

        checkHabitaciones.setToolTipText("Requerirá habitaciones el evento?");

        sNumDias.setToolTipText("Numero de días que dura el congreso");

        javax.swing.GroupLayout pnCongresoLayout = new javax.swing.GroupLayout(pnCongreso);
        pnCongreso.setLayout(pnCongresoLayout);
        pnCongresoLayout.setHorizontalGroup(
            pnCongresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCongresoLayout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sNumDias, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnCongresoLayout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(checkHabitaciones)
                .addContainerGap())
        );
        pnCongresoLayout.setVerticalGroup(
            pnCongresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCongresoLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(pnCongresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(sNumDias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnCongresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(checkHabitaciones))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Número de personas");

        tfNumPersonas.setToolTipText("Número de personas que atenderán al evento");
        tfNumPersonas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNumPersonasActionPerformed(evt);
            }
        });

        btAtras.setText("Atrás");
        btAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAtrasActionPerformed(evt);
            }
        });

        btSiguiente.setText("Siguiente");
        btSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSiguienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(etError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 264, Short.MAX_VALUE)
                                .addComponent(tfNumPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(rbBanquete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rbJornada)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rbCongreso))
                            .addComponent(pnCongreso, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(sFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(22, 22, 22))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbBanquete)
                    .addComponent(rbJornada)
                    .addComponent(rbCongreso))
                .addGap(18, 18, 18)
                .addComponent(pnCongreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(sFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfNumPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                .addComponent(etError)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfNumPersonasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNumPersonasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNumPersonasActionPerformed

    private void rbJornadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbJornadaActionPerformed
        pnCongreso.setVisible(false);
    }//GEN-LAST:event_rbJornadaActionPerformed

    private void rbBanqueteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbBanqueteActionPerformed
        pnCongreso.setVisible(false);
    }//GEN-LAST:event_rbBanqueteActionPerformed

    private void rbCongresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbCongresoActionPerformed
        pnCongreso.setVisible(true);
    }//GEN-LAST:event_rbCongresoActionPerformed

    private void btAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtrasActionPerformed
        dispose();
        pantallaPersona.setVisible(true);
    }//GEN-LAST:event_btAtrasActionPerformed

    private void btSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSiguienteActionPerformed
        if(pantallaSegundoPaso==null){
            pantallaSegundoPaso = new PantallaSegundoPaso(pantallaPrincipal, true, checkHabitaciones.isSelected());
        }
        pantallaSegundoPaso.setPantallaPrimerPaso(this);
        
        SimpleDateFormat sdfParse = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
        SimpleDateFormat sdfFormat = new SimpleDateFormat("dd/MM");
        Enumeration<AbstractButton> buttons = rgTipo.getElements();
        String tipoEvento = "";
        while (buttons.hasMoreElements()) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                tipoEvento = button.getText();
                break;
            }
        }
        
        Date fechaInicio = null;
        try {
            fechaInicio = sdfParse.parse(sFecha.getValue().toString());
        } catch (ParseException ex) {
            Logger.getLogger(PantallaPrimerPaso.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Date fechaFin = null;
        int numDias = -1;
        
        if(tipoEvento.equals("Congreso")) {
            String tfNumDiasText = sNumDias.getValue().toString();
            if (isNumeric(tfNumDiasText)) {
                numDias = Integer.parseInt(tfNumDiasText);
                System.out.println(numDias);
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(fechaInicio);
                calendar.add(Calendar.DAY_OF_YEAR, numDias);
                fechaFin = calendar.getTime();
                System.out.println(sdfFormat.format(fechaFin));
            } else {
                JOptionPane.showMessageDialog(null, "El campo 'numero de días' debe ser un número", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } else{
            numDias = 1;
            try {
            fechaFin = sdfParse.parse(sFecha.getValue().toString());
            } catch (ParseException ex) {
                Logger.getLogger(PantallaPrimerPaso.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        
        String tfNumPersonasText = tfNumPersonas.getText();
        int numPersonas = -1;
        if(isNumeric(tfNumPersonasText)){
            numPersonas = Integer.parseInt(tfNumPersonasText);
            if(tipoEvento.equals("Congreso")){
                if(numPersonas > 100){
                    JOptionPane.showMessageDialog(null, "En un congreso no puede haber más de 100 personas", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } else {
                if(numPersonas > 50){
                    JOptionPane.showMessageDialog(null, "En este tipo de eventos no puede haber más de 50 personas", "Error", JOptionPane.ERROR_MESSAGE);                    
                    return;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "El campo 'numero de personas' debe ser un número", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        boolean requiereHabitaciones = checkHabitaciones.isSelected();
        
        Evento e;
        ArrayList<Evento> evTodos = pantallaPrincipal.getAllEventos();
        if(!(tipoEvento.isEmpty() || fechaInicio == null || fechaFin == null )){
            e = new Evento(persona, sala, tipoEvento, fechaInicio, fechaFin, numPersonas, numDias, requiereHabitaciones);
            
            // comprobación de fechas
            if(!e.getTipoEvento().equals("Congreso")){
                Date fecha = e.getFechaInicio();
                for(Evento ev : evTodos){
                    if(areDatesOnSameDay(fecha, ev.getFechaInicio())){
                        if(tipoEvento.equals(ev.getTipoEvento())){
                            JOptionPane.showMessageDialog(null, "Ya hay un evento de este tipo el " + sdfFormat.format(fecha), "Error", JOptionPane.ERROR_MESSAGE);                            
                            return;    
                        } 
                        if (sala.equals(ev.getSala())){
                            JOptionPane.showMessageDialog(null, "La sala " + sala + " ya está reservada para el " + sdfFormat.format(fecha), "Error", JOptionPane.ERROR_MESSAGE);                            
                            return;
                        }
                    } else if(ev.getTipoEvento().equals("Congreso")){
                        if(isDateBetween(fecha, ev.getFechaInicio(), ev.getFechaFin())){
                            JOptionPane.showMessageDialog(null, "La sala " + sala + " ya está reservada entre el " + sdfFormat.format(ev.getFechaInicio()) + " y el " + sdfFormat.format(ev.getFechaFin()), "Error", JOptionPane.ERROR_MESSAGE);                            
                            return;
                        }
                    }
                }
            } else {
                for(Evento ev : evTodos){
                    if(ev.getTipoEvento().equals("Congreso")){
                        if(areDateRangesColliding(fechaInicio, fechaFin, ev.getFechaInicio(), ev.getFechaFin())){
                            if(ev.getTipoEvento().equals("Congreso")) {
                                JOptionPane.showMessageDialog(null, "Ya hay un Congreso desde el " + sdfFormat.format(ev.getFechaInicio()) + " hasta el " + sdfFormat.format(ev.getFechaFin()), "Error", JOptionPane.ERROR_MESSAGE);                            
                                return; 
                            }
                            if(sala.equals(ev.getSala())){
                                JOptionPane.showMessageDialog(null, "La sala " + sala + " ya está reservada para el " + sdfFormat.format(fechaInicio), "Error", JOptionPane.ERROR_MESSAGE);
                                return;
                            }
                        }  
                    } else {
                        if(isDateBetween(ev.getFechaInicio(), fechaInicio, fechaFin)){
                            JOptionPane.showMessageDialog(null, "Ya hay un evento el " + sdfFormat.format(fechaInicio), "Error", JOptionPane.ERROR_MESSAGE);
                            etError.setText("Ya hay un evento el " + sdfFormat.format(fechaInicio));
                            return;  
                        }
                    }
                }
            }
            pantallaSegundoPaso.setEvento(e);
            pantallaSegundoPaso.setRequiereHabitaciones(requiereHabitaciones);
            etError.setText("");
            setVisible(false);
            pantallaSegundoPaso.setVisible(true);
        } else if (numDias != -1){
            JOptionPane.showMessageDialog(null, "Todos los campos deben estar rellenos", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        
    }//GEN-LAST:event_btSiguienteActionPerformed

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
            java.util.logging.Logger.getLogger(PantallaPrimerPaso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaPrimerPaso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaPrimerPaso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaPrimerPaso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PantallaPrimerPaso dialog = new PantallaPrimerPaso(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    
    public static boolean areDatesOnSameDay(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);

        return cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
               cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH) &&
               cal1.get(Calendar.DAY_OF_MONTH) == cal2.get(Calendar.DAY_OF_MONTH);
    }
    
    public static boolean isDateBetween(Date dateToCheck, Date startDate, Date endDate) {
        return dateToCheck.after(startDate) && dateToCheck.before(endDate);
    }
    
    public static boolean areDateRangesColliding(Date start1, Date end1, Date start2, Date end2) {
        return start1.before(end2) && end1.after(start2);
    }
    
    private boolean isNumeric(String str) {
        return str.matches("\\d+");
    }

    public PantallaPersona getPantallaPersona() {
        return pantallaPersona;
    }

    public void setPantallaPersona(PantallaPersona pantallaPersona) {
        this.pantallaPersona = pantallaPersona;
    }

    public PantallaPrincipal getPantallaPrincipal() {
        return pantallaPrincipal;
    }

    public void setPantallaPrincipal(PantallaPrincipal pantallaPrincipal) {
        this.pantallaPrincipal = pantallaPrincipal;
    }
    
    public void setPersona(Persona persona){
        this.persona = persona;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAtras;
    private javax.swing.JButton btSiguiente;
    private javax.swing.JCheckBox checkHabitaciones;
    private javax.swing.JLabel etError;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel pnCongreso;
    private javax.swing.JRadioButton rbBanquete;
    private javax.swing.JRadioButton rbCongreso;
    private javax.swing.JRadioButton rbJornada;
    private javax.swing.ButtonGroup rgTipo;
    private javax.swing.JSpinner sFecha;
    private javax.swing.JSpinner sNumDias;
    private javax.swing.JTextField tfNumPersonas;
    // End of variables declaration//GEN-END:variables
}