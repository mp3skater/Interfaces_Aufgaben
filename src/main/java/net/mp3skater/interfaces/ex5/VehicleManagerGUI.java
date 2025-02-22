package main.java.net.mp3skater.interfaces.ex5;

import javax.swing.*;
import java.awt.*;

public class VehicleManagerGUI extends JFrame {
    private MeineListe vehicleList = new MeineDefaultListe();
    private MeinIterator vehicleIterator = vehicleList.elemente();

    private JTextField nameField = new JTextField(20);
    private JTextField yearField = new JTextField(20);
    private JLabel infoLabel = new JLabel("Vehicle Manager");

    public VehicleManagerGUI() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Vehicle Manager");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 250);
        setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(new Color(230, 230, 250));

        setupInfoLabel();
        setupFormPanel();
        setupButtonPanel();

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void setupInfoLabel() {
        infoLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
        infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        infoLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(infoLabel, BorderLayout.NORTH);
    }

    private void setupFormPanel() {
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createTitledBorder("Vehicle Details"));
        formPanel.setBackground(new Color(245, 245, 255));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;

        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(new JLabel("Name:"), gbc);
        gbc.gridx = 1;
        formPanel.add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(new JLabel("Year of First Registration:"), gbc);
        gbc.gridx = 1;
        formPanel.add(yearField, gbc);

        add(formPanel, BorderLayout.CENTER);
    }

    private void setupButtonPanel() {
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        buttonPanel.setBackground(new Color(230, 230, 250));

        JButton addButton = new JButton("Add");
        JButton nextButton = new JButton("Next");
        JButton deleteButton = new JButton("Delete");

        buttonPanel.add(addButton);
        buttonPanel.add(nextButton);
        buttonPanel.add(deleteButton);
        add(buttonPanel, BorderLayout.SOUTH);

        addButton.addActionListener(e -> handleAdd());
        nextButton.addActionListener(e -> handleNext());
        deleteButton.addActionListener(e -> handleDelete());
    }

    private void handleAdd() {
        if (vehicleList.istLeer()) {
            vehicleIterator.einfuegenElement(new Auto("", 0));
            infoLabel.setText("Empty List: New Vehicle Added.");
        } else {
            String name = nameField.getText();
            int year;
            try {
                year = Integer.parseInt(yearField.getText());
            } catch (NumberFormatException ex) {
                infoLabel.setText("Invalid Year.");
                return;
            }
            vehicleIterator.setzenAktuellesElement(new Auto(name, year));
            vehicleIterator.einfuegenElement(new Auto("", 0));
            nameField.setText("");
            yearField.setText("");
            infoLabel.setText("New Vehicle Added.");
        }
    }

    private void handleNext() {
        if (vehicleList.istLeer()) {
            infoLabel.setText("List is empty.");
            return;
        }
        String name = nameField.getText();
        int year;
        try {
            year = Integer.parseInt(yearField.getText());
        } catch (NumberFormatException ex) {
            infoLabel.setText("Invalid Year.");
            return;
        }
        vehicleIterator.setzenAktuellesElement(new Auto(name, year));

        if (vehicleIterator.hatNaechstesElement()) {
            Auto next = (Auto) vehicleIterator.naechstesElement();
            nameField.setText(next.getName());
            yearField.setText(String.valueOf(next.getErstzulassung()));
            infoLabel.setText("Next Vehicle Loaded.");
        } else {
            vehicleIterator = vehicleList.elemente();
            Auto first = (Auto) vehicleIterator.naechstesElement();
            nameField.setText(first.getName());
            yearField.setText(String.valueOf(first.getErstzulassung()));
            infoLabel.setText("End Reached: Back to First Vehicle.");
        }
    }

    private void handleDelete() {
        if (vehicleList.istLeer()) {
            infoLabel.setText("List is empty.");
            return;
        }
        if (vehicleIterator.loeschenAktuellesElement()) {
            nameField.setText("");
            yearField.setText("");
            if (vehicleList.istLeer()) {
                infoLabel.setText("Vehicle Deleted: List is now empty.");
            } else {
                Auto next = (Auto) vehicleIterator.naechstesElement();
                nameField.setText(next.getName());
                yearField.setText(String.valueOf(next.getErstzulassung()));
                infoLabel.setText("Vehicle Deleted and Next Vehicle Loaded.");
            }
        } else {
            infoLabel.setText("No Current Vehicle to Delete.");
        }
    }

    public static void main(String[] args) {
        new VehicleManagerGUI();
    }
}