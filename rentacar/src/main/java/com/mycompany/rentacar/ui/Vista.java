/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.rentacar.ui;

import com.mycompany.rentacar.model.Coche;
import com.mycompany.rentacar.model.Persona;
import com.mycompany.rentacar.model.Reserva;
import com.mycompany.rentacar.model.ReservasListener;
import com.mycompany.rentacar.model.SelectionListener;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
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
 * @TODO    Fix modificar function
 * @TODO    Fix fillFieldsFromReserva function to fill all of the fields properly
 */
public class Vista extends javax.swing.JFrame {

    /**
     * Creates new form Vista
     */
    public Vista() {
        BACKGROUND = Color.decode("#909CC2");
        TEXT = Color.decode("#F7F5FB");
        PRIMARY = Color.decode("#F58A07");
        SECONDARY = Color.decode("#F9AB55");
        ACCENT = Color.decode("#084887");
        
        usuario = new Persona();
        coche = new Coche();
        reservas = new ArrayList<Reserva>();
        selectedCard = new CocheCard();
        selectedItem = new ListaItem();
        initComponents();
        initializePanels();
        initializeButtons();
        addButtonListeners();
        vistaActual = 0;
        isModifying = false;
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
        botonNuevo.setLocation(20, height - 70);
        botonGuardar.setLocation(width - 110, height - 70);
        botonAtras.setLocation(20, height - 70);
        botonAdelante.setLocation(width - 110, height - 70);

        // Adjust positions for the new buttons
        int nuevoButtonY = height - 350; // Adjust the Y position for the "Nuevo" button
        int buttonSpacing = 70; // Spacing between buttons

        // "Eliminar" button position adjustments
        JButton eliminarButton = (JButton) panelLateral.getComponent(0); // Assuming "Eliminar" is the first component
        eliminarButton.setLocation(20, nuevoButtonY);

        // "Modificar" button position adjustments
        JButton modificarButton = (JButton) panelLateral.getComponent(1); // Assuming "Modificar" is the second component
        modificarButton.setLocation(20, nuevoButtonY + buttonSpacing);
        
        boolean isSelected = selectedItem.isSelected(); // Assuming this method exists
        panelLateral.getComponent(0).setEnabled(isSelected); // Assuming "Eliminar" is the first component
        panelLateral.getComponent(1).setEnabled(isSelected); // Assuming "Modificar" is the second component
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
        vistaPrincipal.setBackground(BACKGROUND);

        // Use GridBagLayout for better component positioning
        vistaPrincipal.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Title Label - centered horizontally
        JLabel titleLabel = new JLabel("Reservas");
        titleLabel.setForeground(TEXT);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.PAGE_START;
        vistaPrincipal.add(titleLabel, gbc);

        // ScrollPane with cardsContainer - same width as vistaPrincipal, fixed height
        cardsContainer = new JPanel();
        cardsContainer.setLayout(new GridLayout(4, 1)); // 2 columns for the grid layout, adjust as needed
        cardsContainer.setBackground(BACKGROUND);

        JScrollPane scrollPane = new JScrollPane(cardsContainer);
        scrollPane.setPreferredSize(new Dimension(100, 400)); // Fixed height, adjust width as needed

        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0; // Allow the scrollPane to expand horizontally
        gbc.weighty = 1.0; // Allow the scrollPane to expand vertically
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 10, 10, 10); // Add padding around the scrollPane

        vistaPrincipal.add(scrollPane, gbc);

        // Create cards initially
        createReservationCards();
    }

    
    private void initalizeVistaUsuario() {
        vistaUsuario = new JPanel();
        contenedorVistas.add(vistaUsuario, 1); // Add vistaUsuario at layer 2
        vistaUsuario.setBounds(0, 0, 700, 500); // Set bounds as needed
        vistaUsuario.setBackground(BACKGROUND);
        
        JLabel titleLabel = new JLabel("Datos del Usuario");
        titleLabel.setForeground(TEXT);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 26));

        vistaUsuario.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 1.0; // Allow components to fill vertically
        gbc.anchor = GridBagConstraints.WEST; // Align components to the left
        gbc.insets = new Insets(10, 10, 10, 10); // Add padding around components
        
        vistaUsuario.add(titleLabel, gbc);

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
        vistaCoche.setBackground(BACKGROUND);

        JLabel titleLabel = new JLabel("Datos del Coche");
        titleLabel.setForeground(TEXT);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 26));

        vistaCoche.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 0; // Reduce vertical space taken by tipoCocheComboBox
        gbc.anchor = GridBagConstraints.WEST; // Align components to the left
        gbc.insets = new Insets(10, 10, 10, 10); // Add padding around components
        
        vistaCoche.add(titleLabel, gbc);

        // Tipo de coche (using combo box)
        tipoCocheComboBox = addLabelAndComboBox(vistaCoche, gbc, "Tipo de coche:", 0, 1, new String[]{"Pequeño", "Mediano", "Monovolumen", "Furgoneta de carga", "Furgoneta de pasajeros pequeña", "Furgoneta de pasajeros mediana", "Furgoneta de pasajeros grande"});
        gbc.gridy++; // Increment the gridy

        // Create a new GridBagConstraints for the scroll pane
        GridBagConstraints scrollPaneConstraints = new GridBagConstraints();
        scrollPaneConstraints.gridx = 0;
        scrollPaneConstraints.gridy = gbc.gridy;
        scrollPaneConstraints.weightx = 1.0; // Allow scroll pane to fill horizontally
        scrollPaneConstraints.weighty = 1.0; // Allow scroll pane to fill vertically
        scrollPaneConstraints.fill = GridBagConstraints.BOTH; // Fill both horizontal and vertical
        scrollPaneConstraints.gridwidth = GridBagConstraints.REMAINDER; // Take the whole row

        // Replace modeloCocheComboBox with scrollable panel for displaying CocheCards
        JScrollPane scrollPane = new JScrollPane();
        vistaCoche.add(scrollPane, scrollPaneConstraints);

        // Create a panel inside the scroll pane to hold the CocheCards
        cardsPanel = new JPanel(new GridLayout(0, 2, 10, 10)); // 2 cards per row
        scrollPane.setViewportView(cardsPanel);

        // Add an item listener to the tipoCocheComboBox
        tipoCocheComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    populateCards(cardsPanel);
                }
            }
        });

        int bottomMargin = 70; // Adjust this value to match the height of your buttons
        int topMargin = 20;
        vistaCoche.setBorder(BorderFactory.createEmptyBorder(topMargin, 0, bottomMargin, 0));

        // Populate the cards panel initially
        populateCards(cardsPanel);

        vistaCoche.setVisible(false); // Initially hide vistaCoche
    }

    private void populateCards(JPanel cardsPanel) {
        String selectedType = (String) tipoCocheComboBox.getSelectedItem();
        cardsPanel.removeAll(); // Clear previous cards

        Coche[] options = null;

        switch (selectedType) {
            case "Pequeño":
                options = new Coche[]{
                    new Coche("Pequeño", "Volkswagen Up", "UP123", 30, 200, 300, 6, "up.jpg", "Tiene desgaste leve"),
                    new Coche("Pequeño", "Seat Mii", "MII456", 35, 220, 350, 7, "mii.jpg", "En buenas condiciones"),
                    new Coche("Pequeño", "Renault Twingo", "TWINGO789", 32, 210, 320, 6, "twingo.png", "Sin desperfectos"),
                };
                break;
            case "Mediano":
                options = new Coche[]{
                    new Coche("Mediano", "Volkswagen Golf", "GOLF123", 40, 250, 400, 8, "golf.jpg", "Algunos rasguños"),
                    new Coche("Mediano", "Seat León", "LEON456", 45, 270, 420, 9, "leon.jpg", "En condiciones óptimas"),
                    new Coche("Mediano", "Ford Focus", "FOCUS789", 42, 260, 420, 8, "focus.jpg", "Desgaste leve"),
                };
                break;
            case "Monovolumen":
                options = new Coche[]{
                    new Coche("Monovolumen", "Volkswagen Touran", "TOURAN123", 50, 300, 500, 10, "touran.jpg", "Sin desperfectos"),
                    new Coche("Monovolumen", "Seat Alhambra", "ALHAMBRA456", 55, 320, 550, 11, "alhambra.jpg", "Algunos arañazos"),
                    new Coche("Monovolumen", "Citroën C4 Picasso", "C4PICASSO789", 52, 310, 520, 10, "picasso.jpg", "En buenas condiciones"),
                };
                break;
            case "Furgoneta de carga":
                options = new Coche[]{
                    new Coche("Furgoneta de carga", "Volkswagen Caddy", "CADDY123", 60, 350, 600, 12, "caddy.jpg", "Desgaste leve"),
                    new Coche("Furgoneta de carga", "Seat Altea XL", "ALTEAXL456", 65, 380, 650, 13, "altea.jpg", "Algunos arañazos"),
                    new Coche("Furgoneta de carga", "Renault Kangoo", "KANGOO789", 62, 360, 610, 12, "kangoo.jpg", "Sin desperfectos"),
                };
                break;
            case "Furgoneta de pasajeros pequeña":
                options = new Coche[]{
                    new Coche("Furgoneta de pasajeros pequeña", "Volkswagen Caravelle", "CARAVELLE123", 70, 400, 700, 14, "caravelle.jpg", "Algunos rasguños"),
                    new Coche("Furgoneta de pasajeros pequeña", "Seat Ateca", "ATECA456", 75, 430, 750, 15, "ateca.jpg", "Sin desperfectos"),
                    new Coche("Furgoneta de pasajeros pequeña", "Ford Tourneo Connect", "TOURNEO789", 72, 410, 720, 14, "tourneo.jpg", "En buenas condiciones"),
                };
                break;
            case "Furgoneta de pasajeros mediana":
                options = new Coche[]{
                    new Coche("Furgoneta de pasajeros mediana", "Volkswagen Transporter Shuttle", "SHUTTLE123", 90, 500, 850, 18, "transporter.jpg", "En buenas condiciones"),
                    new Coche("Furgoneta de pasajeros mediana", "Seat Tarraco", "TARRACO456", 95, 530, 900, 19, "tarraco.jpg", "Algunos rasguños"),
                    new Coche("Furgoneta de pasajeros mediana", "Renault Trafic Passenger", "TRAFIC789", 92, 510, 870, 18, "trafic.jpg", "Desgaste leve"),
                };
                break;
            case "Furgoneta de pasajeros grande":
                options = new Coche[]{
                    new Coche("Furgoneta de pasajeros grande", "Volkswagen Crafter", "CRAFTER123", 80, 450, 750, 15, "crafter.jpg", "Con algunos daños"),
                    new Coche("Furgoneta de pasajeros grande", "Seat Alhambra Van", "ALHAMBRAVAN456", 85, 480, 800, 16, "alhambravan.jpg", "Desgaste leve"),
                    new Coche("Furgoneta de pasajeros grande", "Renault Master Combi", "MASTER789", 82, 460, 780, 15, "master.jpg", "En buenas condiciones"),
                };
                break;
            // Agregar casos para el resto de categorías...
        }

        if (options != null) {
            for (Coche coche : options) {
                CocheCard card = new CocheCard();
                card.setCocheInfo(coche);
                cardsPanel.add(card);
                if(isModifying && selectedReserva != null) {
                    if(coche.getMatricula().equals(selectedReserva.getCoche().getMatricula())) {
                        card.selectCard();
                        this.coche = coche;
                        botonAdelante.setEnabled(true);
                    }
                }
            }
        }
        
        for (Component component : cardsPanel.getComponents()) {
            if (component instanceof CocheCard) {
                CocheCard card = (CocheCard) component;
                card.clearSelectionListener();
                card.setSelectionListener(new SelectionListener() {
                    @Override
                    public void onCardSelected(Coche c) {
                        coche = c;
                        selectedCard = card;
                        botonAdelante.setEnabled(true);
                        System.out.println("a");
                    }
                    @Override
                    public void onCardUnselected() {
                        coche = null;
                        selectedCard = null;
                        botonAdelante.setEnabled(false);
                        System.out.println("b");   
                    }
                });
            }
        }
        
        cardsPanel.revalidate();
        cardsPanel.repaint();
    }
    
    
    private void initalizeVistaSeguro() {
        vistaSeguro = new JPanel();
        contenedorVistas.add(vistaSeguro, 3); // Add vistaSeguro at layer 4
        vistaSeguro.setBounds(0, 0, 700, 500); // Set bounds as needed
        vistaSeguro.setBackground(BACKGROUND);
        
        JLabel titleLabel = new JLabel("Datos del Seguro");
        titleLabel.setForeground(TEXT);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 26));

        vistaSeguro.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 1; // Adjusted to start from the next row for the main content
        gbc.anchor = GridBagConstraints.WEST; // Align components to the left
        gbc.insets = new Insets(10, 10, 10, 10); // Add padding around components
        
        vistaSeguro.add(titleLabel, gbc);

        seguroGroup = new ButtonGroup();

        addLabelAndRadioButton(vistaSeguro, gbc, "Tipo de seguro:", 0, 1, "Todo Riesgo", seguroGroup);
        addLabelAndRadioButton(vistaSeguro, gbc, "", 0, 2, "Con Franquicia", seguroGroup);
        
        int bottomMargin = 70; // Adjust this value to match the height of your buttons
        int topMargin = 20;
        vistaSeguro.setBorder(BorderFactory.createEmptyBorder(topMargin, 0, bottomMargin, 0));

        vistaSeguro.setVisible(false); // Initially hide vistaSeguro
    }
    
    private void initializeVistaCobro() {
        vistaCobro = new JPanel();
        contenedorVistas.add(vistaCobro, 4); // Add vistaCobro at layer 5
        vistaCobro.setBounds(0, 0, 700, 500); // Set bounds as needed
        vistaCobro.setBackground(BACKGROUND);

        JLabel titleLabel = new JLabel("Datos del Cobro");
        titleLabel.setForeground(TEXT);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 26));

        vistaCobro.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 1; // Adjusted to start from the next row for the main content        
        gbc.anchor = GridBagConstraints.WEST; // Align components to the left
        gbc.insets = new Insets(10, 10, 10, 10); // Add padding around components

        vistaCobro.add(titleLabel, gbc);

        modoCobroGroup = new ButtonGroup();

        addLabelAndRadioButton(vistaCobro, gbc, "Modo de cobro:", 0, 1, "Tarjeta", modoCobroGroup);
        addLabelAndRadioButton(vistaCobro, gbc, "", 0, 2, "Paypal", modoCobroGroup);
        addLabelAndRadioButton(vistaCobro, gbc, "", 0, 3, "Otro", modoCobroGroup);

        datosCobroTextField = addLabelAndTextField(vistaCobro, gbc, "Datos de tarjeta/Paypal/otro:", 0, 4);

        // Add fields for credit card details and email for contact
        numTarjeta = addLabelAndTextField(vistaCobro, gbc, "Número de tarjeta:", 0, 5);
        fechaVencimiento = addLabelAndTextField(vistaCobro, gbc, "Fecha de vencimiento (MM/YY):", 0, 6);
        codigoSeguridad = addLabelAndTextField(vistaCobro, gbc, "Código de seguridad:", 0, 7);
        emailContacto = addLabelAndTextField(vistaCobro, gbc, "Email de contacto:", 0, 8);

        int bottomMargin = 70; // Adjust this value to match the height of your buttons
        int topMargin = 20;
        vistaCobro.setBorder(BorderFactory.createEmptyBorder(topMargin, 0, bottomMargin, 0));

        vistaCobro.setVisible(false); // Initially hide vistaCobro
    }
    
    private void initializeVistaResumen() {
        vistaResumen = new JPanel();
        contenedorVistas.add(vistaResumen, 5); // Add vistaResumen at layer 6
        vistaResumen.setBounds(0, 0, 700, 500); // Set bounds as needed
        vistaResumen.setBackground(BACKGROUND);
        
        JLabel titleLabel = new JLabel("Resumen");
        titleLabel.setForeground(TEXT);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 26));

        vistaResumen.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.WEST; // Align components to the left
        gbc.insets = new Insets(10, 10, 10, 10); // Add padding around components
        
        vistaResumen.add(titleLabel, gbc);

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
        label.setForeground(TEXT);
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
        label.setForeground(TEXT);
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
        label.setForeground(TEXT);
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
        label.setForeground(TEXT);
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.anchor = GridBagConstraints.WEST; // Align components to the left
        gbc.insets = new Insets(10, 10, 10, 10); // Add padding around components
        panel.add(label, gbc);

        JRadioButton radioButton = new JRadioButton(radioText);
        radioButton.setBackground(BACKGROUND);
        radioButton.setForeground(TEXT);
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
        label.setForeground(TEXT);
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.anchor = GridBagConstraints.WEST; // Align components to the left
        gbc.insets = new Insets(10, 10, 10, 10); // Add padding around components
        panel.add(label, gbc);

        JLabel labelInfo = new JLabel(info);
        labelInfo.setForeground(TEXT);
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
        botonNuevo.setBounds(20,400,100,50);
        botonNuevo.setBackground(PRIMARY);
        botonNuevo.setForeground(TEXT);
        botonNuevo.setFocusable(false);
        botonNuevo.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        
        // Create and initialize eliminarButton for deleting a reservation
        botonEliminar = new JButton("Eliminar");
        panelLateral.add(botonEliminar); // Add eliminarButton to the lateral panel
        botonEliminar.setBounds(20, 300, 100, 50); // Adjust the bounds as needed
        botonEliminar.setBackground(PRIMARY);
        botonEliminar.setForeground(TEXT);
        botonEliminar.setFocusable(false);
        botonEliminar.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        // Create and initialize modificarButton for modifying a reservation
        botonModificar = new JButton("Modificar");
        panelLateral.add(botonModificar); // Add modificarButton to the lateral panel
        botonModificar.setBounds(20, 200, 100, 50); // Adjust the bounds as needed
        botonModificar.setBackground(PRIMARY);
        botonModificar.setForeground(TEXT);
        botonModificar.setFocusable(false);
        botonModificar.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        botonGuardar = new JButton("Guardar");
        contenedorVistas.add(botonGuardar);
        contenedorVistas.setLayer(botonGuardar, JLayeredPane.POPUP_LAYER);
        botonGuardar.setBounds(500, 400, 100, 50);
        botonGuardar.setBackground(PRIMARY);
        botonGuardar.setForeground(TEXT);
        botonGuardar.setFocusable(false);
        botonGuardar.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        
        
        // Add botonAtras and botonAdelante to the bottom of contenedorVistas
        contenedorVistas.add(botonAtras);
        contenedorVistas.setLayer(botonAtras, JLayeredPane.POPUP_LAYER);
        botonAtras.setBounds(375, 400, 100, 50);
        botonAtras.setBackground(PRIMARY);
        botonAtras.setForeground(TEXT);
        botonAtras.setFocusable(false);
        botonAtras.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));

        contenedorVistas.add(botonAdelante);
        contenedorVistas.setLayer(botonAdelante, JLayeredPane.POPUP_LAYER);
        botonAdelante.setBounds(500, 400, 100, 50);
        botonAdelante.setBackground(PRIMARY);
        botonAdelante.setForeground(TEXT);
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
        panelLateral.setBackground(ACCENT);
        panelLateral.setBorder(BorderFactory.createLineBorder(ACCENT));
        
        ImageIcon logoIcon = new ImageIcon("logo.png");

        // Scale the logo to your desired dimensions
        int logoWidth = 100; // Set the desired width
        int logoHeight = -1; // Maintain aspect ratio
        Image scaledLogoImage = logoIcon.getImage().getScaledInstance(logoWidth, logoHeight, Image.SCALE_SMOOTH);
        ImageIcon scaledLogoIcon = new ImageIcon(scaledLogoImage);

        JLabel logoLabel = new JLabel(scaledLogoIcon);

        // Add the logo to the lateral panel and position it at the top left
        logoLabel.setBounds(20, 20, scaledLogoIcon.getIconWidth(), scaledLogoIcon.getIconHeight());
        panelLateral.add(logoLabel);
    }
    
    // Method to create cards
    private void createReservationCards() {
        cardsContainer.removeAll(); // Clear existing cards

        for (Reserva reserva : reservas) {
            ListaItem card = new ListaItem();
            card.setReservaInfo(reserva); // Set Reserva information to the card
            card.setSelectionListener(new ReservasListener(){
                @Override
                public void onCardSelected(Reserva reserva){
                    handleSelectedItem(reserva, card);
                }
                
                @Override
                public void onCardUnselected() {
                    handleUnselectedItem();
                }
            });
            cardsContainer.add(card);
        }

        // Repaint the container to reflect changes
        cardsContainer.revalidate();
        cardsContainer.repaint();
    }
    
    private void handleSelectedItem(Reserva r, ListaItem l){
        selectedReserva = r;
        selectedItem = l;
        botonEliminar.setEnabled(true);
        botonModificar.setEnabled(true);
    }
    
    private void handleUnselectedItem(){
        selectedReserva = null;
        selectedItem = null;
        botonEliminar.setEnabled(false);
        botonModificar.setEnabled(false);
    }
    
    private void addButtonListeners() {
        botonNuevo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                isModifying = false;
                vistaActual = 1;
                switchToPanelByIndex(vistaActual); // Switch to vistaUsuario (index 1)
                handleUnselectedItem();
            }
        });

        botonAdelante.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switch (vistaActual) {
                    case 1: // VistaUsuario
                        populateCards(cardsPanel);
                        if(!isModifying){
                            botonAdelante.setEnabled(false);
                        }
                        if(saveUsuarioData()){
                            goForward();
                        } else {
                            botonAdelante.setEnabled(true);
                        }

                        break;
                    case 2: // VistaCoche
                        botonAdelante.setEnabled(true);
                        goForward();
                        break;
                    case 3: // VistaSeguro
                        if(saveSeguroData()){
                            goForward();
                        }
                        break;
                    case 4: // VistaCobro
                        if(saveCobroData()){
                            initializeVistaResumen();
                            goForward();                            
                        }
                        break;
                    // Add cases for other vistas as needed
                }
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
        
        botonModificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                modificar();
            }
        });
        
        botonEliminar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                eliminar();
            }
        });
    }
    
    private boolean saveUsuarioData() {
        String nombre = nombreTextField.getText();
        String apellidos = apellidosTextField.getText();
        String dni = dniTextField.getText();
        String direccion = direccionTextField.getText();
        String edad = edadTextField.getText();
        String tipoCarnet = tipoCarnetTextField.getText();
        String antiguedadCarnet = antiguedadCarnetTextField.getText();

        // Check if any field is empty
        if (nombre.isEmpty() || apellidos.isEmpty() || dni.isEmpty() || direccion.isEmpty() || edad.isEmpty() || tipoCarnet.isEmpty() || antiguedadCarnet.isEmpty()) {
            displayErrorDialog("Todos los campos son obligatorios.");
            return false;
        }

        // Validate DNI length
        if (dni.length() != 9) {
            displayErrorDialog("El DNI debe tener 9 caracteres.");
            return false;
        }

        // Validate edad and antiguedadCarnet are numbers
        try {
            int edadValue = Integer.parseInt(edad);
            int antiguedadCarnetValue = Integer.parseInt(antiguedadCarnet);

            // Set user data only if all validations pass
            usuario.setNombre(nombre);
            usuario.setApellidos(apellidos);
            usuario.setDni(dni);
            usuario.setDireccion(direccion);
            usuario.setEdad(edadValue);
            usuario.setTipoCarnet(tipoCarnet);
            usuario.setAntiguedadCarnet(antiguedadCarnetValue);

            return true; // All fields set correctly
        } catch (NumberFormatException e) {
            displayErrorDialog("Edad y Antigüedad del Carnet deben ser números.");
            return false;
        }
    }

    private void saveCocheData() {
//        coche.setTipoCoche((String) tipoCocheComboBox.getSelectedItem());
//        coche.setModeloCoche((String) modeloCocheComboBox.getSelectedItem());
//        coche.setPrecioDia((int) precioDiaSpinner.getValue());
//        coche.setPrecioSemana((int) precioSemanaSpinner.getValue());
//        coche.setKilometrosEnPrecio((int) kilometrosPrecioSpinner.getValue());
//        coche.setPrecioPorKilometro((int) precioKilometroSpinner.getValue());
//        coche.setDesperfectos(desperfectosTextField.getText());
    }

    private boolean saveSeguroData() {
        tipoSeguro = "Todo Riesgo"; // Default

        ButtonModel selectedButtonModel = seguroGroup.getSelection();
        if (selectedButtonModel != null) {
            // Check the selected button and set tipoSeguro accordingly
            JRadioButton radioButton1 = new JRadioButton("Todo Riesgo");
            JRadioButton radioButton2 = new JRadioButton("Con Franquicia");

            if (selectedButtonModel.equals(radioButton2.getModel())) {
                tipoSeguro = "Con Franquicia";
            }

            return true; // Seguro data saved correctly
        } else {
            // Show an error message if no option is selected
            displayErrorDialog("Por favor, selecciona un tipo de seguro.");
            return false; // Seguro data not saved correctly
        }
    }

    private boolean saveCobroData() {
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

        tarjeta = numTarjeta.getText();
        vencimiento = fechaVencimiento.getText();
        codigo = codigoSeguridad.getText();
        email = emailContacto.getText();

        boolean isValid = true;

        if (modoCobro.isEmpty() || tarjeta.isEmpty() || vencimiento.isEmpty() || codigo.isEmpty() || email.isEmpty()) {
            isValid = false;
            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            // Validate email format
            if (!isValidEmail(email)) {
                isValid = false;
                JOptionPane.showMessageDialog(null, "Por favor, introduzca una dirección de correo electrónico válida.", "Error", JOptionPane.ERROR_MESSAGE);
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

        return isValid; // Return whether the payment data is saved correctly
    }
    
    private boolean isValidEmail(String email) {
        return email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
    }
    
    private void displayErrorDialog(String errorMessage) {
        JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    private void guardar() {
        if(!isModifying){
            Persona newUsuario = new Persona(usuario);
            Coche newCoche = new Coche(coche);
            Reserva nuevaReserva = new Reserva(newUsuario, newCoche, modoCobro, datosCobro, tipoSeguro, tarjeta, vencimiento, codigo, email, selectedCard);
            reservas.add(nuevaReserva);
            createReservationCards();
            resetFields(); 
        } else {
            isModifying = false;
            Persona newUsuario = new Persona(usuario);
            selectedReserva.setUsuario(newUsuario);
            Coche newCoche = new Coche(coche);
            selectedReserva.setCoche(newCoche);
            selectedReserva.setModoCobro(modoCobro);
            selectedReserva.setDatosCobro(datosCobro);
            selectedReserva.setTipoSeguro(tipoSeguro);
            createReservationCards();
            resetFields(); 
        }
        
    }
    
    private void modificar() {
        isModifying = true;
        populateFieldsFromReserva(selectedReserva);
        vistaActual = 1;
        switchToPanelByIndex(vistaActual);
    }
    
    private void eliminar() {
        // Check if selectedReserva is present and ask for confirmation
        if (reservas.contains(selectedReserva)) {
            int dialogResult = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que quieres eliminar esta reserva?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

            // If user confirms deletion (clicks YES)
            if (dialogResult == JOptionPane.YES_OPTION) {
                // Remove the selectedReserva from the list
                reservas.remove(selectedReserva);

                // Remove the selected card from the UI
                cardsContainer.remove(selectedItem);
                cardsContainer.revalidate();
                cardsContainer.repaint();

                // Deselect the card
                if (selectedItem != null) {
                    selectedItem.deselectCard();
                }

                // Hide or disable eliminar button after deletion
                botonEliminar.setEnabled(false);
            }
        }
    }
    
    private void resetFields() {
        // TextFields
        nombreTextField.setText("");
        apellidosTextField.setText("");
        direccionTextField.setText("");
        dniTextField.setText("");
        edadTextField.setText("");
        tipoCarnetTextField.setText("");
        antiguedadCarnetTextField.setText("");
        datosCobroTextField.setText("");
        numTarjeta.setText("");
        fechaVencimiento.setText("");
        codigoSeguridad.setText("");
        emailContacto.setText("");

        // JComboBoxes
        tipoCocheComboBox.setSelectedIndex(0); 

        // ButtonGroups (for JRadioButtons)
        seguroGroup.clearSelection(); // Clear the selected radio button in this group
        modoCobroGroup.clearSelection();

        // Deselect the selected card
        if (selectedCard != null) {
            selectedCard.deselectCard();
            selectedCard = null;
        }
        
        botonAdelante.setEnabled(true);
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
            botonModificar.setVisible(true);
            botonEliminar.setVisible(true);
            botonGuardar.setVisible(false);
        } else if (vistaActual == 1) {
            botonAtras.setVisible(true);
            botonAdelante.setVisible(true);
            botonNuevo.setVisible(false);
            botonModificar.setVisible(false);
            botonEliminar.setVisible(false);
        } else if (vistaActual == 5) { 
            botonAdelante.setVisible(false);
            botonGuardar.setVisible(true);
        } else {
            botonAdelante.setVisible(true);
            botonAtras.setVisible(true);
            botonGuardar.setVisible(false);
        }
    }
    
    public void populateFieldsFromReserva(Reserva selectedReserva) {
        Persona usuario = selectedReserva.getUsuario();
        Coche coche = selectedReserva.getCoche();
        
        System.out.println(selectedReserva.toString());

        nombreTextField.setText(usuario.getNombre());
        apellidosTextField.setText(usuario.getApellidos());
        dniTextField.setText(usuario.getDni());
        direccionTextField.setText(usuario.getDireccion());
        edadTextField.setText(String.valueOf(usuario.getEdad()));
        tipoCarnetTextField.setText(usuario.getTipoCarnet());
        antiguedadCarnetTextField.setText(Integer.toString(usuario.getAntiguedadCarnet()));
        datosCobroTextField.setText(datosCobro);
        numTarjeta.setText(tarjeta);
        fechaVencimiento.setText(vencimiento);
        codigoSeguridad.setText(codigo);
        emailContacto.setText(email);
                
        Enumeration<AbstractButton> seguroButtons = seguroGroup.getElements();
        while (seguroButtons.hasMoreElements()) {
            AbstractButton button = seguroButtons.nextElement();
            if (button instanceof JRadioButton) {
                JRadioButton radioButton = (JRadioButton) button;
//                System.out.println(selectedReserva.getTipoSeguro());
//                System.out.println(radioButton.getActionCommand());
                if (radioButton.getActionCommand().equals(selectedReserva.getTipoSeguro())){
                    radioButton.setSelected(true);
                    break;
                }
            }
        }
        
        Enumeration<AbstractButton> modoCobroButtons = modoCobroGroup.getElements();
        while (modoCobroButtons.hasMoreElements()) {
            AbstractButton button = modoCobroButtons.nextElement();
            if (button instanceof JRadioButton) {
                JRadioButton radioButton = (JRadioButton) button;
//                System.out.println(selectedReserva.getTipoSeguro());
//                System.out.println(radioButton.getActionCommand());
                if (radioButton.getActionCommand().equals(selectedReserva.getModoCobro())){
                    radioButton.setSelected(true);
                    break;
                }
            }
        }
        
//        modoCobroGroup.setSelected(m, isModifying);

        tipoCocheComboBox.setSelectedItem(coche.getTipoCoche());
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
    
    private boolean isModifying;
    
    private JPanel cardsContainer;
    
    private javax.swing.JPanel vistaPrincipal;
    private javax.swing.JPanel vistaUsuario;
    private javax.swing.JPanel vistaCoche;
    private javax.swing.JPanel vistaSeguro;
    private javax.swing.JPanel vistaCobro;
    private javax.swing.JPanel vistaResumen;
    private javax.swing.JPanel cardsPanel;
    
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
    private JTextField datosCobroTextField;
    private JTextField numTarjeta;
    private JTextField fechaVencimiento;
    private JTextField codigoSeguridad;
    private JTextField emailContacto;
    
    private JComboBox<String> tipoCocheComboBox;
    
    private ButtonGroup seguroGroup; 
    private ButtonGroup modoCobroGroup;
    
    private Persona usuario;
    private Coche coche;
    private String modoCobro;
    private String datosCobro;
    private String tipoSeguro;
    private String tarjeta;
    private String vencimiento;
    private String codigo;
    private String email;
    
    private Reserva selectedReserva;
    
    private ArrayList<Reserva> reservas;
    private ArrayList<ListaItem> reservasCards;
    private CocheCard selectedCard;
    private ListaItem selectedItem;
    
    // Colores
    private Color BACKGROUND;
    private Color TEXT;
    private Color PRIMARY;
    private Color SECONDARY;
    private Color ACCENT;
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane contenedorVistas;
    private javax.swing.JPanel panelLateral;
    // End of variables declaration//GEN-END:variables
}
