/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.rentacar.ui;

import com.mycompany.rentacar.model.Coche;
import com.mycompany.rentacar.model.Persona;
import com.mycompany.rentacar.model.Reserva;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;

/**
 *
 * @author  j1
 * @TODO    Add validations
 * @TODO    Expand Pago section to get all of the card info and also the email for contact
 * @TODO    Use a panel to display dynamically the available cards depending on if turismos/furgoneta pasajeros/furgoneta cargas and pequeño/mediano/grande is selected
 * @TODO    Include license plate for each car
 * @TODO    Add styling
 * @TODO    Add modificar/eliminar buttons to the card
 */
public class Vista extends javax.swing.JFrame {

    /**
     * Creates new form Vista
     */
    public Vista() {
        usuario = new Persona();
        coche = new Coche();
        reservas = new ArrayList<Reserva>();
        initComponents();
        initializePanels();
        initializeButtons();
        addButtonListeners();
        vistaActual = 0;
        switchToPanelByIndex(vistaActual);
        
        contenedorVistas.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                resizeInternalPanels();
                moveButtons();
            }
        });
    }
    
    private void resizeInternalPanels() {
        // Calculate the new size based on the resized contenedorVistas
        int width = contenedorVistas.getWidth();
        int height = contenedorVistas.getHeight();

        // Resize each individual panel inside contenedorVistas
        vistaPrincipal.setSize(width, height);
        vistaUsuario.setSize(width, height);
        vistaCoche.setSize(width, height);
        vistaSeguro.setSize(width, height);
        vistaCobro.setSize(width, height);
        vistaResumen.setSize(width, height);
        // Adjust the layout of each internal panel as needed
    }
    
    private void moveButtons() {
        int width = contenedorVistas.getWidth();
        int height = contenedorVistas.getHeight();

        // Adjust the positions of the buttons based on the new size
        int lateralPanelWidth = panelLateral.getWidth();

        // Example button position adjustments (modify as needed)
        botonNuevo.setLocation(10, height - 70);
        botonGuardar.setLocation(width - 110, height - 70);
        botonAtras.setLocation(10, height - 70);
        botonAdelante.setLocation(width - 110, height - 70);
        // Adjust other button positions as necessary
    }
    
    private void initializePanels() {
        initializeVistaPrincipal();
        initalizeVistaUsuario();
        initializeVistaCoche();
        initalizeVistaSeguro();
        initializeVistaCobro();
        initializeVistaResumen();
    }
    
    private void initializeVistaPrincipal() {
        vistaPrincipal = new JPanel();
        contenedorVistas.add(vistaPrincipal, 0); // Add vistaPrincipal at layer 1
        vistaPrincipal.setBounds(0, 0, 700, 500); // Set bounds as needed

        reservas = new ArrayList<>(); // Initialize the list of reservations
        cardsContainer = new JPanel();
        cardsContainer.setLayout(new GridLayout(0, 1)); // 2 columns for the grid layout, adjust as needed

        JScrollPane scrollPane = new JScrollPane(cardsContainer);
        scrollPane.setPreferredSize(new Dimension(700, 400)); // Adjust dimensions as needed

        vistaPrincipal.add(scrollPane);

        JLabel titleLabel = new JLabel("Reservas");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 26));
        vistaPrincipal.add(titleLabel);

        // Create cards initially
        createReservationCards();
    }
    
    private void initalizeVistaUsuario() {
        vistaUsuario = new JPanel();
        contenedorVistas.add(vistaUsuario, 1); // Add vistaUsuario at layer 2
        vistaUsuario.setBounds(0, 0, 700, 500); // Set bounds as needed
        
        JLabel titleLabel = new JLabel("Datos del Usuario");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 26));
        vistaUsuario.add(titleLabel);

        vistaUsuario.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 1.0; // Allow components to fill vertically
        gbc.anchor = GridBagConstraints.WEST; // Align components to the left
        gbc.insets = new Insets(10, 10, 10, 10); // Add padding around components

        // Create and add labels and text fields
        nombreTextField = addLabelAndTextField(vistaUsuario, gbc, "Nombre:", 0, 1);
        apellidosTextField = addLabelAndTextField(vistaUsuario, gbc, "Apellidos:", 0, 2);
        dniTextField = addLabelAndTextField(vistaUsuario,gbc, "DNI: ",0,3);
        direccionTextField = addLabelAndTextField(vistaUsuario, gbc, "Dirección:", 0, 4);
        edadTextField = addLabelAndTextField(vistaUsuario, gbc, "Edad:", 0, 5);
        tipoCarnetTextField = addLabelAndTextField(vistaUsuario, gbc, "Tipo Carnet:", 0, 6);
        antiguedadCarnetTextField = addLabelAndTextField(vistaUsuario, gbc, "Antigüedad Carnet:", 0, 7);

        int bottomMargin = 70; // Adjust this value to match the height of your buttons
        int topMargin = 20;
        vistaUsuario.setBorder(BorderFactory.createEmptyBorder(topMargin, 0, bottomMargin, 0));

        vistaUsuario.setVisible(false); // Initially hide vistaUsuario
    }
    
    private void initializeVistaCoche() {
        vistaCoche = new JPanel();
        contenedorVistas.add(vistaCoche, 2); // Add vistaCoche at layer 3
        vistaCoche.setBounds(0, 0, 700, 500); // Set bounds as needed
        
        JLabel titleLabel = new JLabel("Datos del Coche");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 26));
        vistaCoche.add(titleLabel);

        // Define options for different types of cars
        String[] turismosOptions = {"Volkswagen", "Seat", "Skoda"};
        String[] furgonetasOptions = {"Volkswagen (Caddy)", "Volkswagen (Transporter)", "Volkswagen (Crafter)",
                "Fiat (Fiorino)", "Fiat (Scudo)", "Fiat (Ducato)"};

        vistaCoche.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 1.0; // Allow components to fill vertically
        gbc.anchor = GridBagConstraints.WEST; // Align components to the left
        gbc.insets = new Insets(10, 10, 10, 10); // Add padding around components

        // Tipo de coche (using combo box)
        tipoCocheComboBox = addLabelAndComboBox(vistaCoche, gbc, "Tipo de coche:", 0, 1, new String[]{"Turismo", "Furgoneta"});
        modeloCocheComboBox = addLabelAndComboBox(vistaCoche, gbc, "Coche concreto:", 0, 2, turismosOptions);

        // Add an item listener to the tipoCocheComboBox
        tipoCocheComboBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String selectedType = (String) tipoCocheComboBox.getSelectedItem();
                    if ("Turismo".equals(selectedType)) {
                        modeloCocheComboBox.removeAllItems();
                        for (String option : turismosOptions) {
                            modeloCocheComboBox.addItem(option);
                        }
                    } else if ("Furgoneta".equals(selectedType)) {
                        modeloCocheComboBox.removeAllItems();
                        for (String option : furgonetasOptions) {
                            modeloCocheComboBox.addItem(option);
                        }
                    }
                }
            }
        });

        // Other fields for car details
        precioDiaSpinner = addLabelAndSpinner(vistaCoche, gbc, "Precio por día:", 0, 3);
        precioSemanaSpinner = addLabelAndSpinner(vistaCoche, gbc, "Precio por semana:", 0, 4);
        kilometrosPrecioSpinner = addLabelAndSpinner(vistaCoche, gbc, "Kilómetros incluidos:", 0, 5);
        precioKilometroSpinner = addLabelAndSpinner(vistaCoche, gbc, "Precio por kilómetro adicional:", 0, 6);
        desperfectosTextField = addLabelAndTextField(vistaCoche, gbc, "Estado del coche:", 0, 7);

        int bottomMargin = 70; // Adjust this value to match the height of your buttons
        int topMargin = 20;
        vistaCoche.setBorder(BorderFactory.createEmptyBorder(topMargin, 0, bottomMargin, 0));

        vistaCoche.setVisible(false); // Initially hide vistaCoche
    }
    
    
    private void initalizeVistaSeguro() {
        vistaSeguro = new JPanel();
        contenedorVistas.add(vistaSeguro, 3); // Add vistaSeguro at layer 4
        vistaSeguro.setBounds(0, 0, 700, 500); // Set bounds as needed

        JLabel titleLabel = new JLabel("Datos del Seguro");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 26));
        vistaSeguro.add(titleLabel);

        vistaSeguro.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 1; // Adjusted to start from the next row for the main content
        gbc.anchor = GridBagConstraints.WEST; // Align components to the left
        gbc.insets = new Insets(10, 10, 10, 10); // Add padding around components

        seguroGroup = new ButtonGroup();

        addLabelAndRadioButton(vistaSeguro, gbc, "Tipo de seguro:", 0, 1, "Todo riesgo", seguroGroup);
        addLabelAndRadioButton(vistaSeguro, gbc, "", 0, 2, "Con franquicia", seguroGroup);
        
        int bottomMargin = 70; // Adjust this value to match the height of your buttons
        int topMargin = 20;
        vistaSeguro.setBorder(BorderFactory.createEmptyBorder(topMargin, 0, bottomMargin, 0));

        vistaSeguro.setVisible(false); // Initially hide vistaSeguro
    }
    
    private void initializeVistaCobro() {
        vistaCobro = new JPanel();
        contenedorVistas.add(vistaCobro, 4); // Add vistaCobro at layer 5
        vistaCobro.setBounds(0, 0, 700, 500); // Set bounds as needed
        
        JLabel titleLabel = new JLabel("Datos del Cobro");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 26));
        vistaCobro.add(titleLabel);

        vistaCobro.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 1; // Adjusted to start from the next row for the main content        
        gbc.anchor = GridBagConstraints.WEST; // Align components to the left
        gbc.insets = new Insets(10, 10, 10, 10); // Add padding around components

        modoCobroGroup = new ButtonGroup();

        addLabelAndRadioButton(vistaCobro, gbc, "Modo de cobro:", 0, 1, "Tarjeta", modoCobroGroup);
        addLabelAndRadioButton(vistaCobro, gbc, "", 0, 2, "Paypal", modoCobroGroup);
        addLabelAndRadioButton(vistaCobro, gbc, "", 0, 3, "Otro", modoCobroGroup);
        addLabelAndTextField(vistaCobro, gbc, "Datos de tarjeta/Paypal/otro:", 0, 4);
        
        int bottomMargin = 70; // Adjust this value to match the height of your buttons
        int topMargin = 20;
        vistaCobro.setBorder(BorderFactory.createEmptyBorder(topMargin, 0, bottomMargin, 0));

        vistaCobro.setVisible(false); // Initially hide vistaCobro
    }
    
    private void initializeVistaResumen() {
        vistaResumen = new JPanel();
        contenedorVistas.add(vistaResumen, 5); // Add vistaResumen at layer 6
        vistaResumen.setBounds(0, 0, 700, 500); // Set bounds as needed
        
        JLabel titleLabel = new JLabel("Resumen");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 26));
        vistaResumen.add(titleLabel);

        vistaResumen.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.WEST; // Align components to the left
        gbc.insets = new Insets(10, 10, 10, 10); // Add padding around components

        addLabelAndInfo(vistaResumen, gbc, "Usuario:", 0, 1, usuario.getNombre());
        addLabelAndInfo(vistaResumen, gbc, "Coche:", 0, 2, coche.getModeloCoche());
        addLabelAndInfo(vistaResumen, gbc, "Modo de Cobro:", 0, 3, modoCobro);
        addLabelAndInfo(vistaResumen, gbc, "Datos de Cobro:", 0, 4, datosCobro);
        addLabelAndInfo(vistaResumen, gbc, "Tipo de Seguro:", 0, 5, tipoSeguro);
        
        int bottomMargin = 70; // Adjust this value to match the height of your buttons
        int topMargin = 20;
        vistaResumen.setBorder(BorderFactory.createEmptyBorder(topMargin, 0, bottomMargin, 0));
        
        vistaResumen.setVisible(false); // Initially hide vistaResumen
    }
    
    private JTextField addLabelAndTextField(JPanel panel, GridBagConstraints gbc, String labelText, int gridx, int gridy) {
        JLabel label = new JLabel(labelText);
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.anchor = GridBagConstraints.WEST; // Align components to the left
        gbc.insets = new Insets(10, 10, 10, 10); // Add padding around components
        panel.add(label, gbc);

        JTextField textField = new JTextField(20); // Adjust column size if needed
        gbc.gridx = gridx + 1;
        gbc.weightx = 1.0; // Make the text field expand horizontally
        gbc.fill = GridBagConstraints.HORIZONTAL; // Fill horizontally
        gbc.anchor = GridBagConstraints.WEST; // Align components to the left
        panel.add(textField, gbc);

        return textField; // Return the created text field
    }
    
    private JComboBox<String> addLabelAndComboBox(JPanel panel, GridBagConstraints gbc, String labelText, int gridx, int gridy, String[] options) {
        JLabel label = new JLabel(labelText);
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.anchor = GridBagConstraints.WEST; // Align components to the left
        gbc.insets = new Insets(10, 10, 10, 10); // Add padding around components
        panel.add(label, gbc);

        JComboBox<String> comboBox = new JComboBox<>(options);
        gbc.gridx = gridx + 1;
        gbc.weightx = 1.0; // Make the combo box expand horizontally
        gbc.fill = GridBagConstraints.BOTH; // Fill horizontally
        gbc.anchor = GridBagConstraints.WEST; // Align components to the left
        panel.add(comboBox, gbc);

        return comboBox;
    }

    private JSpinner addLabelAndSpinner(JPanel panel, GridBagConstraints gbc, String labelText, int gridx, int gridy) {
        JLabel label = new JLabel(labelText);
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.anchor = GridBagConstraints.WEST; // Align components to the left
        gbc.insets = new Insets(10, 10, 10, 10); // Add padding around components
        panel.add(label, gbc);

        SpinnerModel spinnerModel = new SpinnerNumberModel(0, 0, 10000, 1); // Change min, max, and step values as needed
        JSpinner spinner = new JSpinner(spinnerModel);
        JSpinner.DefaultEditor spinnerEditor = (JSpinner.DefaultEditor) spinner.getEditor();
        spinnerEditor.getTextField().setEditable(false); // Make the spinner not editable
        gbc.gridx = gridx + 1;
        gbc.weightx = 1.0; // Make the spinner expand horizontally
        gbc.fill = GridBagConstraints.HORIZONTAL; // Fill horizontally
        gbc.anchor = GridBagConstraints.WEST; // Align components to the left
        panel.add(spinner, gbc);

        return spinner;
    }

    private JRadioButton addLabelAndRadioButton(JPanel panel, GridBagConstraints gbc, String labelText, int gridx, int gridy, String radioText, ButtonGroup group) {
        JLabel label = new JLabel(labelText);
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.anchor = GridBagConstraints.WEST; // Align components to the left
        gbc.insets = new Insets(10, 10, 10, 10); // Add padding around components
        panel.add(label, gbc);

        JRadioButton radioButton = new JRadioButton(radioText);
        gbc.gridx = gridx + 1;
        gbc.weightx = 1.0; // Make the radio button expand horizontally
        gbc.fill = GridBagConstraints.HORIZONTAL; // Fill horizontally
        gbc.anchor = GridBagConstraints.WEST; // Align components to the left
        panel.add(radioButton, gbc);

        group.add(radioButton); // Add the radio button to the button group

        return radioButton;
    }

    private JLabel addLabelAndInfo(JPanel panel, GridBagConstraints gbc, String labelText, int gridx, int gridy, String info) {
        JLabel label = new JLabel(labelText);
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.anchor = GridBagConstraints.WEST; // Align components to the left
        gbc.insets = new Insets(10, 10, 10, 10); // Add padding around components
        panel.add(label, gbc);

        JLabel labelInfo = new JLabel(info);
        gbc.gridx = gridx + 1;
        gbc.weightx = 1.0; // Make the text area expand horizontally
        gbc.fill = GridBagConstraints.BOTH; // Fill horizontally
        gbc.anchor = GridBagConstraints.WEST; // Align components to the left
        panel.add(labelInfo, gbc);

        return labelInfo;
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
        botonNuevo.setBounds(10,400,100,50);
        botonNuevo.setBackground(Color.BLACK);
        botonNuevo.setForeground(Color.WHITE);
        botonNuevo.setFocusable(false);
        botonNuevo.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        
        botonGuardar = new JButton("Guardar");
        contenedorVistas.add(botonGuardar);
        contenedorVistas.setLayer(botonGuardar, JLayeredPane.POPUP_LAYER);
        botonGuardar.setBounds(500, 400, 100, 50);
        botonGuardar.setBackground(Color.BLACK);
        botonGuardar.setForeground(Color.WHITE);
        botonGuardar.setFocusable(false);
        botonGuardar.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        
        
        // Add botonAtras and botonAdelante to the bottom of contenedorVistas
        contenedorVistas.add(botonAtras);
        contenedorVistas.setLayer(botonAtras, JLayeredPane.POPUP_LAYER);
        botonAtras.setBounds(375, 400, 100, 50);
        botonAtras.setBackground(Color.BLACK);
        botonAtras.setForeground(Color.WHITE);
        botonAtras.setFocusable(false);
        botonAtras.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));

        contenedorVistas.add(botonAdelante);
        contenedorVistas.setLayer(botonAdelante, JLayeredPane.POPUP_LAYER);
        botonAdelante.setBounds(500, 400, 100, 50);
        botonAdelante.setBackground(Color.BLACK);
        botonAdelante.setForeground(Color.WHITE);
        botonAdelante.setFocusable(false);
        botonAdelante.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));

        botonAtras.setText("Atras");
        botonAdelante.setText("Adelante");
        botonNuevo.setText("Nuevo");
        botonGuardar.setText("Guardar");
        
        botonAtras.setVisible(false);
        botonAdelante.setVisible(false);
        botonNuevo.setVisible(true);
        botonGuardar.setVisible(false);
        
        // Add botonNuevo to the bottom of panelLateral
        panelLateral.add(botonNuevo);
        panelLateral.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
    
    // Method to create cards
    private void createReservationCards() {
        cardsContainer.removeAll(); // Clear existing cards

        for (Reserva reserva : reservas) {
            System.out.println(reserva.toString());
            ListaItem card = new ListaItem();
            card.setReservaInfo(reserva); // Set Reserva information to the card
            cardsContainer.add(card);
        }

        // Repaint the container to reflect changes
        cardsContainer.revalidate();
        cardsContainer.repaint();
    }
    
    private void addButtonListeners() {
        botonNuevo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                vistaActual = 1;
                switchToPanelByIndex(vistaActual); // Switch to vistaUsuario (index 1)
            }
        });

        botonAdelante.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switch (vistaActual) {
                    case 1: // VistaUsuario
                        saveUsuarioData();
                        break;
                    case 2: // VistaCoche
                        saveCocheData();
                        break;
                    case 3: // VistaSeguro
                        saveSeguroData();
                        break;
                    case 4: // VistaCobro
                        saveCobroData();
                        initializeVistaResumen();
                        break;
                    // Add cases for other vistas as needed
                }
                goForward();
            }
        });
        
        botonAtras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                goBackward(); // Switch to vistaCoche (index 3)
            }
        });

        botonGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guardar();
                vistaActual = 0;
                switchToPanelByIndex(vistaActual);
            }
        });
    }
    
    private void saveUsuarioData() {
        usuario.setNombre(nombreTextField.getText());
        usuario.setApellidos(apellidosTextField.getText());
        usuario.setDireccion(direccionTextField.getText());
        usuario.setEdad(Integer.parseInt(edadTextField.getText()));
        usuario.setTipoCarnet(tipoCarnetTextField.getText());
        usuario.setAntiguedadCarnet(Integer.parseInt(antiguedadCarnetTextField.getText()));
    }

    private void saveCocheData() {
        coche.setTipoCoche((String) tipoCocheComboBox.getSelectedItem());
        coche.setModeloCoche((String) modeloCocheComboBox.getSelectedItem());
        coche.setPrecioDia((int) precioDiaSpinner.getValue());
        coche.setPrecioSemana((int) precioSemanaSpinner.getValue());
        coche.setKilometrosEnPrecio((int) kilometrosPrecioSpinner.getValue());
        coche.setPrecioPorKilometro((int) precioKilometroSpinner.getValue());
        coche.setDesperfectos(desperfectosTextField.getText());
    }

    private void saveSeguroData() {
        tipoSeguro = "Todo Riesgo"; // Default

        ButtonModel selectedButtonModel = seguroGroup.getSelection();
        if (selectedButtonModel != null) {
            JRadioButton radioButton1 = new JRadioButton("Todo riesgo");
            JRadioButton radioButton2 = new JRadioButton("Con franquicia");

            if (selectedButtonModel.equals(radioButton2.getModel())) {
                tipoSeguro = "Con Franquicia";
            }
        }
    }

    private void saveCobroData() {
        modoCobro = ""; // Variable to store the payment method
        datosCobro = ""; // Variable to store payment details, like card or PayPal info

        ButtonModel selectedButtonModel = modoCobroGroup.getSelection();
        if (selectedButtonModel != null) {
            Enumeration<AbstractButton> buttons = modoCobroGroup.getElements();

            while (buttons.hasMoreElements()) {
                AbstractButton button = buttons.nextElement();
                if (button.getModel() == selectedButtonModel) {
                    modoCobro = button.getText(); // Get the text of the selected button
                    break;
                }
            }
        }

        // Fetch details from the text field
        Component[] components = vistaCobro.getComponents();
        for (Component component : components) {
            if (component instanceof JTextField) {
                JTextField textField = (JTextField) component;
                datosCobro = textField.getText(); // Get text entered in the text field
                break; // Assuming there's only one text field in this panel
            }
        }
    }
    
    private void guardar() {
        Persona newUsuario = new Persona(usuario);
        Coche newCoche = new Coche(coche);
        Reserva nuevaReserva = new Reserva(newUsuario, newCoche, modoCobro, datosCobro, tipoSeguro);
        reservas.add(nuevaReserva);
        System.out.println(reservas.toString());
        createReservationCards();
        resetFields();
    }
    
    private void resetFields() {
        // TextFields
        nombreTextField.setText("");
        apellidosTextField.setText("");
        direccionTextField.setText("");
        edadTextField.setText("");
        tipoCarnetTextField.setText("");
        antiguedadCarnetTextField.setText("");
        desperfectosTextField.setText("");

        // JComboBoxes
        tipoCocheComboBox.setSelectedIndex(0); // Reset to the default selection or a specific index

        // JSpinners
        precioDiaSpinner.setValue(0); // Reset to the default value
        precioSemanaSpinner.setValue(0);
        kilometrosPrecioSpinner.setValue(0);
        precioKilometroSpinner.setValue(0);

        // ButtonGroups (for JRadioButtons)
        seguroGroup.clearSelection(); // Clear the selected radio button in this group
        modoCobroGroup.clearSelection();
    }

    
    // New method to handle moving forward
    private void goForward() {        
        if (vistaActual < 5) { // Update the number of panels if needed
            switchToPanelByIndex(++vistaActual);
        }
    }

    // New method to handle moving backward
    private void goBackward() {
        if (vistaActual > 0) {
            switchToPanelByIndex(--vistaActual);
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
            case 0:
                vistaPrincipal.setVisible(true);
                break;
            case 1:
                vistaUsuario.setVisible(true);
                break;
            case 2:
                vistaCoche.setVisible(true);
                break;
            case 3:
                vistaSeguro.setVisible(true);
                break;
            case 4:
                vistaCobro.setVisible(true);
                break;
            case 5:
                vistaResumen.setVisible(true);
                break;
            // Add more cases if needed for additional panels
            default:
                break;
        }
        
        if (vistaActual == 0) {
            botonAtras.setVisible(false);
            botonAdelante.setVisible(false);
            botonNuevo.setVisible(true);
            botonGuardar.setVisible(false);
        } else if (vistaActual == 1) {
            botonAtras.setVisible(true);
            botonAdelante.setVisible(true);
            botonNuevo.setVisible(false);
        } else if (vistaActual == 5) { 
            botonAdelante.setVisible(false);
            botonGuardar.setVisible(true);
        } else {
            botonAdelante.setVisible(true);
            botonAtras.setVisible(true);
            botonGuardar.setVisible(false);
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
                .addComponent(contenedorVistas))
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
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vista().setVisible(true);
            }
        });
    }
    
    private int vistaActual;
    
    private JPanel cardsContainer;
    
    private javax.swing.JPanel vistaPrincipal;
    private javax.swing.JPanel vistaUsuario;
    private javax.swing.JPanel vistaCoche;
    private javax.swing.JPanel vistaSeguro;
    private javax.swing.JPanel vistaCobro;
    private javax.swing.JPanel vistaResumen;
    
    private javax.swing.JButton botonAtras;
    private javax.swing.JButton botonAdelante;
    private javax.swing.JButton botonNuevo;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonModificar;
    
    private JTextField nombreTextField;
    private JTextField apellidosTextField;
    private JTextField dniTextField;
    private JTextField direccionTextField;
    private JTextField edadTextField;
    private JTextField tipoCarnetTextField;
    private JTextField antiguedadCarnetTextField;
    
    private JComboBox<String> tipoCocheComboBox;
    private JComboBox<String> modeloCocheComboBox;
    private JSpinner precioDiaSpinner;
    private JSpinner precioSemanaSpinner;
    private JSpinner kilometrosPrecioSpinner;
    private JSpinner precioKilometroSpinner;
    private JTextField desperfectosTextField;
    
    private ButtonGroup seguroGroup; 
    private ButtonGroup modoCobroGroup;
    
    private Persona usuario;
    private Coche coche;
    private String modoCobro;
    private String datosCobro;
    private String tipoSeguro;
    
    private ArrayList<Reserva> reservas;
    private ArrayList<ListaItem> reservasCards;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane contenedorVistas;
    private javax.swing.JPanel panelLateral;
    // End of variables declaration//GEN-END:variables
}
