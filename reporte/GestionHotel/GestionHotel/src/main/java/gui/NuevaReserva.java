/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package gui;

import com.toedter.calendar.JTextFieldDateEditor;
import dto.Persona;
import dto.Reserva;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

/**
 *
 * @author diego
 */
public class NuevaReserva extends javax.swing.JDialog {
    
    private int maxNumPersonas;
    private boolean panelVisible = false; // Inicialmente, el panel está oculto

    //Atributos para crear la reserva al final
    private String nombreSala;
    private Persona persona;
    private Date fechaEvento;
    private String tipoEvento;
    private Integer numPersonas;
    private String tipoCocina;
    
    //Solo congresos
    private Integer numJornadas;
    private Integer numHabitaciones;
    private String tipoHabitaciones;
    
    private JRadioButton botonSeleccionado;
    
    public NuevaReserva(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * Creates new form NuevaReserva
     */
    public NuevaReserva(java.awt.Frame parent, boolean modal, String nombreSala) {
        super(parent, modal);
        initComponents();
        
        this.lbTituloHotel.setText(lbTituloHotel.getText() + nombreSala);
        
        //No permitir escritura manual en fecha
        JTextFieldDateEditor editor = (JTextFieldDateEditor) this.dateChooser.getDateEditor();
        editor.setEnabled(false);
        
        rbBanquete.setSelected(true);
        
        addListeners();
        
        panelCongreso.setVisible(false);
        jPanel1.setVisible(false);
        
        this.nombreSala = nombreSala;
        
        this.dateChooser.setMinSelectableDate(new Date());
        
        botonSeleccionado = rbBanquete;
    }
    
    
    
    private void addListeners()
    {
        rbBanquete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lbNumPersonas.setText("Número de Personas (Máx 100)");
                maxNumPersonas = 100;
                panelCongreso.setVisible(false);
                botonSeleccionado = rbBanquete;
            }
        });

        rbCongreso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lbNumPersonas.setText("Número de Personas (Máx 50)");
                maxNumPersonas = 50;
                panelCongreso.setVisible(true);
                botonSeleccionado = rbCongreso;
            }
        });
        
        rbJornada.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lbNumPersonas.setText("Número de Personas (Máx 50)");
                maxNumPersonas = 50;
                panelCongreso.setVisible(false);
                botonSeleccionado = rbJornada;
            }
        });
        
        cbHabitaciones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelVisible = !panelVisible;
                jPanel1.setVisible(panelVisible);
            }
        });
        
    }
    
    private boolean comprobarDatosVacios() {
        if (!tfNombre.getText().isEmpty()) {
            if (!tfApellidos.getText().isEmpty()) {
                if (!tfTelefono.getText().isEmpty() && comprobarTelefono(tfTelefono.getText())) {
                    if (!tfDireccion.getText().isEmpty()) {
                        return true;
                    } else {
                        JOptionPane.showMessageDialog(this, "Debe introducir la dirección", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "El número de teléfono no es válido", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Debe introducir los apellidos", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe introducir el nombre", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    
    private boolean comprobarTelefono(String telefono) {
        try{
            Integer.parseInt(telefono);
            return true;
        } catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    
    private boolean comprobarFecha() {
        Date fechaSeleccionada = this.dateChooser.getDate();
        Date fechaActual = new Date(); // Obtiene la fecha actual

        if (fechaSeleccionada == null) {
            // No se ha seleccionado una fecha
            JOptionPane.showMessageDialog(this, "Por favor, seleccione una fecha.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (fechaSeleccionada.before(fechaActual)) {
            // La fecha seleccionada es anterior a la fecha actual
            JOptionPane.showMessageDialog(this, "La fecha seleccionada debe ser igual o posterior al día de hoy.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        // La fecha es válida
        this.fechaEvento = fechaSeleccionada;
        return true;
    }


    
    private boolean comprobarNumeroPersonas() {
        String numPersonasTexto = tfNumPersonas.getText();
        
        //Numero máximo de personas según el tipo de evento
        if(rbCongreso.isSelected()){
            tipoEvento = "Congreso";
            maxNumPersonas = 50;
        } else if(rbBanquete.isSelected()){
            tipoEvento = "Banquete";
            maxNumPersonas = 100;
        } else{
            tipoEvento = "Jornada";
            maxNumPersonas = 50;
        }
        
        if (!tfNumPersonas.getText().isEmpty()) {
            try {
                int numPersonas = Integer.parseInt(numPersonasTexto);

                if (numPersonas > 0 && numPersonas <= maxNumPersonas) {
                    this.numPersonas = numPersonas;
                    return true;
                } else {
                    JOptionPane.showMessageDialog(this, "El número de personas debe ser mayor que 0 y menor o igual a " + maxNumPersonas, "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "El número de personas no es válido", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe introducir el número de personas", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        
        return false;
    }

    
    
    
    private boolean comprobarDatosCongreso(){
        if (cbHabitaciones.isSelected()) {
            if(!tfNumHabitaciones.getText().isEmpty() && comprobarHabitaciones(tfNumHabitaciones.getText())){
                return true;
            } else{
                JOptionPane.showMessageDialog(this, "El número de habitaciones debe ser un número positivo", "ERROR", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } else{
            return true;
        }
    }

    private boolean comprobarHabitaciones(String habitaciones) {
        try {
            int numHabitaciones = Integer.parseInt(habitaciones);
            if(numHabitaciones > 0){
                this.numHabitaciones = numHabitaciones;
                            return true;
            }
        } catch (NumberFormatException e) {
        }
        return false; // El valor no es un número válido.

    }
    
    private void actualizarResumen(){
        if(comprobarDatosVacios()){
            lbResNombre.setText("Nombre: " + tfNombre.getText() + " " + tfApellidos.getText());
            lbResContacto.setText("Contacto: " + tfTelefono.getText());
            if(comprobarFecha()){
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String fechaFormateada = sdf.format(fechaEvento);
                lbResFecha.setText("Fecha del evento: " + fechaFormateada);                 
            }
            lbResTipoEvento.setText("Tipo de evento: " + botonSeleccionado.getText());
            if(comprobarNumeroPersonas()){
                lbResAsistentes.setText("Asistentes: " + tfNumPersonas.getText());                
            }
            lbResCocina.setText("Cocina: " + cbTipoCocina.getSelectedItem().toString());
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

        grTipoEvento = new javax.swing.ButtonGroup();
        panelPrincipal = new javax.swing.JPanel();
        lbTituloHotel = new javax.swing.JLabel();
        panelInformacion = new javax.swing.JPanel();
        lbNombre = new javax.swing.JLabel();
        tfDireccion = new javax.swing.JTextField();
        lbDireccion = new javax.swing.JLabel();
        tfApellidos = new javax.swing.JTextField();
        tfTelefono = new javax.swing.JTextField();
        lbApellidos = new javax.swing.JLabel();
        tfNombre = new javax.swing.JTextField();
        lbTelefono = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lbFecha = new javax.swing.JLabel();
        lbTipoEvento = new javax.swing.JLabel();
        rbBanquete = new javax.swing.JRadioButton();
        rbJornada = new javax.swing.JRadioButton();
        rbCongreso = new javax.swing.JRadioButton();
        lbNumPersonas = new javax.swing.JLabel();
        tfNumPersonas = new javax.swing.JTextField();
        lbTipoCocina = new javax.swing.JLabel();
        cbTipoCocina = new javax.swing.JComboBox<>();
        cbCitaChef = new javax.swing.JCheckBox();
        dateChooser = new com.toedter.calendar.JDateChooser();
        panelCongreso = new javax.swing.JPanel();
        sNumJornadas = new javax.swing.JSpinner();
        cbHabitaciones = new javax.swing.JCheckBox();
        lbNumJornadas = new javax.swing.JLabel();
        lbCongreso = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        cbTipoHabitacion = new javax.swing.JComboBox<>();
        lbNumHabitaciones = new javax.swing.JLabel();
        tfNumHabitaciones = new javax.swing.JTextField();
        lbTipoHabitaciones = new javax.swing.JLabel();
        panelResumen = new javax.swing.JPanel();
        lbResumenReserva = new javax.swing.JLabel();
        lbResNombre = new javax.swing.JLabel();
        lbResContacto = new javax.swing.JLabel();
        lbResFecha = new javax.swing.JLabel();
        lbResTipoEvento = new javax.swing.JLabel();
        lbResAsistentes = new javax.swing.JLabel();
        lbResCocina = new javax.swing.JLabel();
        btActualizar = new javax.swing.JButton();
        btAceptar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        panelPrincipal.setPreferredSize(new java.awt.Dimension(1749, 1146));

        lbTituloHotel.setBackground(new java.awt.Color(0, 0, 0));
        lbTituloHotel.setFont(new java.awt.Font("Krungthep", 0, 36)); // NOI18N
        lbTituloHotel.setForeground(new java.awt.Color(255, 255, 255));
        lbTituloHotel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTituloHotel.setText("NUEVA RESERVA EN LA SALA ");
        lbTituloHotel.setOpaque(true);

        panelInformacion.setBackground(new java.awt.Color(204, 204, 204));

        lbNombre.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        lbNombre.setText("Nombre");

        tfDireccion.setToolTipText("Completa este campo");
        tfDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfDireccionActionPerformed(evt);
            }
        });

        lbDireccion.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        lbDireccion.setText("Direccion");

        tfApellidos.setToolTipText("Ejemplo: Sánchez Gutiérrez");
        tfApellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfApellidosActionPerformed(evt);
            }
        });

        tfTelefono.setToolTipText("Introduzca su número de teléfono");
        tfTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTelefonoActionPerformed(evt);
            }
        });

        lbApellidos.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        lbApellidos.setText("Apellidos");

        tfNombre.setToolTipText("Ejemplo: Juan");
        tfNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNombreActionPerformed(evt);
            }
        });

        lbTelefono.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        lbTelefono.setText("Teléfono");

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setOpaque(true);

        lbFecha.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        lbFecha.setText("Fecha de Evento");

        lbTipoEvento.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        lbTipoEvento.setText("Tipo Evento");

        grTipoEvento.add(rbBanquete);
        rbBanquete.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        rbBanquete.setText("Banquete");

        grTipoEvento.add(rbJornada);
        rbJornada.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        rbJornada.setText("Jornada");
        rbJornada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbJornadaActionPerformed(evt);
            }
        });

        grTipoEvento.add(rbCongreso);
        rbCongreso.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        rbCongreso.setText("Congreso");
        rbCongreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbCongresoActionPerformed(evt);
            }
        });

        lbNumPersonas.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        lbNumPersonas.setText("Número de Personas");

        tfNumPersonas.setToolTipText("Introduzca el número de personas que asistirán al evento");
        tfNumPersonas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNumPersonasActionPerformed(evt);
            }
        });

        lbTipoCocina.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        lbTipoCocina.setText("Tipo de Cocina");

        cbTipoCocina.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        cbTipoCocina.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Buffet", "Buffet (Vegetariano)", "Carta" }));
        cbTipoCocina.setToolTipText("Seleccione el tipo de cocina que requerirá");

        cbCitaChef.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        cbCitaChef.setText("Pedir cita con el chef");
        cbCitaChef.setToolTipText("¿Desea tener una cita con el chef para hablar sobre el menú?");
        cbCitaChef.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCitaChefActionPerformed(evt);
            }
        });

        dateChooser.setToolTipText("Seleccione en el panel gráfico la fecha en la que se realizará el evento");
        dateChooser.setDateFormatString("dd/MM/yyyy");

        panelCongreso.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        panelCongreso.setOpaque(false);

        sNumJornadas.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        sNumJornadas.setToolTipText("Seleccione el número de jornadas que durará el evento");

        cbHabitaciones.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        cbHabitaciones.setText("Habitaciones para asistentes");
        cbHabitaciones.setToolTipText("¿Solicitará habitaciones para los asistentes?");
        cbHabitaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbHabitacionesActionPerformed(evt);
            }
        });

        lbNumJornadas.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        lbNumJornadas.setText("Número de Jornadas");

        lbCongreso.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        lbCongreso.setText("DATOS CONGRESO");

        jPanel1.setOpaque(false);

        cbTipoHabitacion.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        cbTipoHabitacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Individual", "Doble (Dos camas)", "Doble (Cama matrimonio)" }));
        cbTipoHabitacion.setToolTipText("¿Qué tipo de habitaciones necesita?");

        lbNumHabitaciones.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        lbNumHabitaciones.setText("Número de habitaciones");

        tfNumHabitaciones.setToolTipText("Introduzca el número de habitaciones que necesitará");
        tfNumHabitaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNumHabitacionesActionPerformed(evt);
            }
        });

        lbTipoHabitaciones.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        lbTipoHabitaciones.setText("Tipo de habitaciones");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(271, 271, 271)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbTipoHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbTipoHabitaciones)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfNumHabitaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbNumHabitaciones))
                        .addGap(261, 261, 261)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNumHabitaciones)
                    .addComponent(lbTipoHabitaciones))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNumHabitaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbTipoHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout panelCongresoLayout = new javax.swing.GroupLayout(panelCongreso);
        panelCongreso.setLayout(panelCongresoLayout);
        panelCongresoLayout.setHorizontalGroup(
            panelCongresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCongresoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCongresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCongresoLayout.createSequentialGroup()
                        .addGroup(panelCongresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sNumJornadas, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbNumJornadas))
                        .addGap(325, 325, 325))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCongresoLayout.createSequentialGroup()
                        .addComponent(cbHabitaciones)
                        .addContainerGap())))
            .addGroup(panelCongresoLayout.createSequentialGroup()
                .addGroup(panelCongresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCongresoLayout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(lbCongreso))
                    .addGroup(panelCongresoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17))
        );
        panelCongresoLayout.setVerticalGroup(
            panelCongresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCongresoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCongresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCongresoLayout.createSequentialGroup()
                        .addComponent(lbCongreso)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbNumJornadas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sNumJornadas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelCongresoLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(cbHabitaciones)))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelInformacionLayout = new javax.swing.GroupLayout(panelInformacion);
        panelInformacion.setLayout(panelInformacionLayout);
        panelInformacionLayout.setHorizontalGroup(
            panelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInformacionLayout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addGroup(panelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbCitaChef, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                    .addComponent(lbTipoCocina)
                    .addComponent(cbTipoCocina, 0, 207, Short.MAX_VALUE)
                    .addComponent(lbFecha)
                    .addComponent(dateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(panelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInformacionLayout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addGroup(panelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelInformacionLayout.createSequentialGroup()
                                .addComponent(lbTipoEvento)
                                .addGap(128, 128, 128)
                                .addComponent(lbNumPersonas))
                            .addGroup(panelInformacionLayout.createSequentialGroup()
                                .addGroup(panelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rbBanquete)
                                    .addComponent(rbJornada)
                                    .addComponent(rbCongreso))
                                .addGap(129, 129, 129)
                                .addComponent(tfNumPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInformacionLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelCongreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))))
            .addGroup(panelInformacionLayout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addGroup(panelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInformacionLayout.createSequentialGroup()
                        .addComponent(lbTelefono)
                        .addGap(251, 251, 251)
                        .addComponent(lbDireccion))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 840, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNombre)
                    .addComponent(tfTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(93, 124, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInformacionLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tfDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lbApellidos)
                        .addComponent(tfApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(153, 153, 153))
        );
        panelInformacionLayout.setVerticalGroup(
            panelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInformacionLayout.createSequentialGroup()
                .addGroup(panelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInformacionLayout.createSequentialGroup()
                        .addGap(413, 413, 413)
                        .addComponent(tfNumPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addGroup(panelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelInformacionLayout.createSequentialGroup()
                                .addComponent(lbTipoCocina)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbTipoCocina, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(82, 82, 82)
                                .addComponent(cbCitaChef))
                            .addComponent(panelCongreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelInformacionLayout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(panelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbNombre)
                            .addComponent(lbApellidos))
                        .addGap(18, 18, 18)
                        .addGroup(panelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelInformacionLayout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(lbDireccion))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInformacionLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbTelefono)))
                        .addGap(18, 18, 18)
                        .addGroup(panelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addGroup(panelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbFecha)
                            .addComponent(lbTipoEvento)
                            .addComponent(lbNumPersonas))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelInformacionLayout.createSequentialGroup()
                                .addComponent(rbBanquete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rbJornada)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rbCongreso)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelInformacionLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {rbBanquete, rbCongreso, rbJornada});

        lbResumenReserva.setFont(new java.awt.Font("Helvetica Neue", 0, 36)); // NOI18N
        lbResumenReserva.setText("Resumen de la reserva");

        lbResNombre.setFont(new java.awt.Font("Helvetica Neue", 0, 20)); // NOI18N
        lbResNombre.setText("Nombre: ");

        lbResContacto.setFont(new java.awt.Font("Helvetica Neue", 0, 20)); // NOI18N
        lbResContacto.setText("Contacto: ");

        lbResFecha.setFont(new java.awt.Font("Helvetica Neue", 0, 20)); // NOI18N
        lbResFecha.setText("Fecha del evento:");

        lbResTipoEvento.setFont(new java.awt.Font("Helvetica Neue", 0, 20)); // NOI18N
        lbResTipoEvento.setText("Tipo de evento: ");

        lbResAsistentes.setFont(new java.awt.Font("Helvetica Neue", 0, 20)); // NOI18N
        lbResAsistentes.setText("Asistentes: ");

        lbResCocina.setFont(new java.awt.Font("Helvetica Neue", 0, 20)); // NOI18N
        lbResCocina.setText("Cocina:");

        btActualizar.setIcon(new javax.swing.ImageIcon("/Users/diego/Documents/Interfaces/NetBeansProjects/GestionHotel/src/Other Resources/recargar (3).png")); // NOI18N
        btActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelResumenLayout = new javax.swing.GroupLayout(panelResumen);
        panelResumen.setLayout(panelResumenLayout);
        panelResumenLayout.setHorizontalGroup(
            panelResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelResumenLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(panelResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbResCocina)
                    .addComponent(lbResAsistentes)
                    .addComponent(lbResTipoEvento)
                    .addComponent(lbResFecha)
                    .addComponent(lbResContacto)
                    .addComponent(lbResNombre))
                .addContainerGap(318, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelResumenLayout.createSequentialGroup()
                .addContainerGap(92, Short.MAX_VALUE)
                .addGroup(panelResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelResumenLayout.createSequentialGroup()
                        .addComponent(lbResumenReserva)
                        .addGap(91, 91, 91))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelResumenLayout.createSequentialGroup()
                        .addComponent(btActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))))
        );
        panelResumenLayout.setVerticalGroup(
            panelResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelResumenLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(btActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbResumenReserva)
                .addGap(68, 68, 68)
                .addComponent(lbResNombre)
                .addGap(36, 36, 36)
                .addComponent(lbResContacto)
                .addGap(36, 36, 36)
                .addComponent(lbResFecha)
                .addGap(36, 36, 36)
                .addComponent(lbResTipoEvento)
                .addGap(36, 36, 36)
                .addComponent(lbResAsistentes)
                .addGap(36, 36, 36)
                .addComponent(lbResCocina)
                .addGap(223, 223, 223))
        );

        panelResumenLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lbResAsistentes, lbResCocina, lbResContacto, lbResFecha, lbResNombre, lbResTipoEvento});

        btAceptar.setBackground(new java.awt.Color(153, 255, 153));
        btAceptar.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        btAceptar.setText("Aceptar");
        btAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAceptarActionPerformed(evt);
            }
        });

        btCancelar.setBackground(new java.awt.Color(255, 102, 102));
        btCancelar.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(panelInformacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(panelResumen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(55, 55, 55))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(206, 206, 206)
                .addComponent(btAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84))
            .addComponent(lbTituloHotel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addComponent(lbTituloHotel, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelResumen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelInformacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 1030, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tfApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfApellidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfApellidosActionPerformed

    private void tfTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfTelefonoActionPerformed

    private void tfNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNombreActionPerformed

    private void rbJornadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbJornadaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbJornadaActionPerformed

    private void rbCongresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbCongresoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbCongresoActionPerformed

    private void tfNumPersonasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNumPersonasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNumPersonasActionPerformed

    private void tfDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfDireccionActionPerformed

    private void cbCitaChefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCitaChefActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCitaChefActionPerformed

    private void cbHabitacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbHabitacionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbHabitacionesActionPerformed

    private void tfNumHabitacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNumHabitacionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNumHabitacionesActionPerformed

    private void btAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAceptarActionPerformed
        if(comprobarDatosVacios()){
            if(comprobarFecha()){
                if(comprobarNumeroPersonas()){
                    //Creamos a la persona que hace la reserva
                    Persona persona = new Persona(tfNombre.getText() + " " + tfApellidos.getText(), Integer.parseInt(tfTelefono.getText()), tfDireccion.getText());
                    
                    //Asignamos todas las variables
                    this.tipoEvento = botonSeleccionado.getText();
                    this.tipoCocina = cbTipoCocina.getSelectedItem().toString();
                    
                    Reserva nuevaReserva = null;
                   
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    String fechaFormateada = sdf.format(fechaEvento);
                    
                    Principal pantallaPrincipal = (Principal) this.getParent();
                    //Comprobar que no exista una reserva del mismo tipo el mismo dia
                    
                    numJornadas = (int) sNumJornadas.getValue();

                    if(panelCongreso.isVisible()){

                        this.tipoHabitaciones = cbTipoHabitacion.getSelectedItem().toString();

                        if(comprobarDatosCongreso()){
                            nuevaReserva = new Reserva(nombreSala, persona, fechaEvento, tipoEvento, numPersonas, tipoCocina, numJornadas, numHabitaciones, tipoHabitaciones);
                        }
                    } else{
                        nuevaReserva = new Reserva(nombreSala, persona, fechaEvento, tipoEvento, numPersonas, tipoCocina);
                    }
                    if(!pantallaPrincipal.existeReserva(nuevaReserva)){
                        pantallaPrincipal.anadirReserva(nuevaReserva);
                        this.dispose();
                    } else{
                        JOptionPane.showMessageDialog(this, "No pueden realizarse dos eventos iguales el mismo dia o en la misma sala", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                    
                }
            }
        }
    }//GEN-LAST:event_btAceptarActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btActualizarActionPerformed
        actualizarResumen();
    }//GEN-LAST:event_btActualizarActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAceptar;
    private javax.swing.JButton btActualizar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JCheckBox cbCitaChef;
    private javax.swing.JCheckBox cbHabitaciones;
    private javax.swing.JComboBox<String> cbTipoCocina;
    private javax.swing.JComboBox<String> cbTipoHabitacion;
    private com.toedter.calendar.JDateChooser dateChooser;
    private javax.swing.ButtonGroup grTipoEvento;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbApellidos;
    private javax.swing.JLabel lbCongreso;
    private javax.swing.JLabel lbDireccion;
    private javax.swing.JLabel lbFecha;
    private javax.swing.JLabel lbNombre;
    private javax.swing.JLabel lbNumHabitaciones;
    private javax.swing.JLabel lbNumJornadas;
    private javax.swing.JLabel lbNumPersonas;
    private javax.swing.JLabel lbResAsistentes;
    private javax.swing.JLabel lbResCocina;
    private javax.swing.JLabel lbResContacto;
    private javax.swing.JLabel lbResFecha;
    private javax.swing.JLabel lbResNombre;
    private javax.swing.JLabel lbResTipoEvento;
    private javax.swing.JLabel lbResumenReserva;
    private javax.swing.JLabel lbTelefono;
    private javax.swing.JLabel lbTipoCocina;
    private javax.swing.JLabel lbTipoEvento;
    private javax.swing.JLabel lbTipoHabitaciones;
    private javax.swing.JLabel lbTituloHotel;
    private javax.swing.JPanel panelCongreso;
    private javax.swing.JPanel panelInformacion;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelResumen;
    private javax.swing.JRadioButton rbBanquete;
    private javax.swing.JRadioButton rbCongreso;
    private javax.swing.JRadioButton rbJornada;
    private javax.swing.JSpinner sNumJornadas;
    private javax.swing.JTextField tfApellidos;
    private javax.swing.JTextField tfDireccion;
    private javax.swing.JTextField tfNombre;
    private javax.swing.JTextField tfNumHabitaciones;
    private javax.swing.JTextField tfNumPersonas;
    private javax.swing.JTextField tfTelefono;
    // End of variables declaration//GEN-END:variables
}
