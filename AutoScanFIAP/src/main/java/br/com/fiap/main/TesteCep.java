package br.com.fiap.main;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TesteCep {

    public static void main(String[] args) {

        JFrame regFrame = new JFrame("AS - Registro");
        regFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        regFrame.setSize(500, 300);
        regFrame.setResizable(false);

        regFrame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.CENTER;

        Font font = new Font("Arial", Font.PLAIN, 16);
        Font boldFont = new Font("Arial", Font.BOLD, 16); // Fonte em negrito

        JTextField marcaField = new JTextField(25);
        marcaField.setFont(font);
        JTextField modeloField = new JTextField(25);
        modeloField.setFont(font);
        JTextField placaField = new JTextField(25);
        placaField.setFont(font);

        JPanel regPanel = new JPanel();
        regPanel.setLayout(new BoxLayout(regPanel, BoxLayout.Y_AXIS));

        JLabel marcaLabel = new JLabel("Marca:");
        marcaLabel.setFont(font);
        marcaLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        marcaField.setAlignmentX(JTextField.CENTER_ALIGNMENT);
        marcaField.setMaximumSize(marcaField.getPreferredSize());

        JLabel modeloLabel = new JLabel("Modelo:");
        modeloLabel.setFont(font);
        modeloLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        modeloField.setAlignmentX(JTextField.CENTER_ALIGNMENT);
        modeloField.setMaximumSize(modeloField.getPreferredSize());

        JLabel placaLabel = new JLabel("Placa:");
        placaLabel.setFont(font);
        placaLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        placaField.setAlignmentX(JTextField.CENTER_ALIGNMENT);
        placaField.setMaximumSize(placaField.getPreferredSize());

        regPanel.add(marcaLabel);
        regPanel.add(marcaField);
        regPanel.add(Box.createVerticalStrut(15));

        regPanel.add(modeloLabel);
        regPanel.add(modeloField);
        regPanel.add(Box.createVerticalStrut(15));

        regPanel.add(placaLabel);
        regPanel.add(placaField);

        JButton butaoRegistro = new JButton("ENVIAR");
        butaoRegistro.setPreferredSize(new Dimension(250, 50));
        butaoRegistro.setFont(boldFont);
        butaoRegistro.setAlignmentX(JButton.CENTER_ALIGNMENT);

        regPanel.add(Box.createVerticalStrut(25)); 
        regPanel.add(butaoRegistro);

        regFrame.add(regPanel, gbc);
        regFrame.setLocationRelativeTo(null);
        regFrame.setVisible(true);
    }
}
