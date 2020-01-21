package com.willis_chico.vocabulary_trainer;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StartWindow extends JFrame {
    // Anfang Attribute
    private JButton bLernen = new JButton();
    private JButton bSuchen = new JButton();
    private JButton bVokabelhinzufuegen = new JButton();
    private JButton bSortieren = new JButton();
    private JButton bVokabelloeschen = new JButton();
    // Ende Attribute

    public StartWindow() {
        // Frame-Initialisierung
        super();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        int frameWidth = 700;
        int frameHeight = 400;
        setSize(frameWidth, frameHeight);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (d.width - getSize().width) / 2;
        int y = (d.height - getSize().height) / 2;
        setLocation(x, y);
        setTitle("Vokabeltrainer");
        setResizable(false);
        Container cp = getContentPane();
        cp.setLayout(null);
        // Anfang Komponenten

        bLernen.setBounds(200, 50, 300, 75);
        bLernen.setText("Lernen");
        bLernen.setMargin(new Insets(2, 2, 2, 2));
        bLernen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                bLernen_ActionPerformed(evt);
            }
        });
        bLernen.setFont(new Font("Dialog", Font.BOLD, 25));
        cp.add(bLernen);
        bSuchen.setBounds(275, 150, 150, 35);
        bSuchen.setText("Suchen");
        bSuchen.setMargin(new Insets(2, 2, 2, 2));
        bSuchen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                bSuchen_ActionPerformed(evt);
            }
        });
        cp.add(bSuchen);
        bVokabelhinzufuegen.setBounds(275, 230, 150, 35);
        bVokabelhinzufuegen.setText("Vokabel hinzufügen");
        bVokabelhinzufuegen.setMargin(new Insets(2, 2, 2, 2));
        bVokabelhinzufuegen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                bVokabelhinzufuegen_ActionPerformed(evt);
            }
        });
        cp.add(bVokabelhinzufuegen);
        bSortieren.setBounds(275, 190, 150, 35);
        bSortieren.setText("Sortieren");
        bSortieren.setMargin(new Insets(2, 2, 2, 2));
        bSortieren.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                bSortieren_ActionPerformed(evt);
            }
        });
        cp.add(bSortieren);
        bVokabelloeschen.setBounds(275, 270, 150, 35);
        bVokabelloeschen.setText("Vokabel löschen");
        bVokabelloeschen.setMargin(new Insets(2, 2, 2, 2));
        bVokabelloeschen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                bVokabelloeschen_ActionPerformed(evt);
            }
        });
        cp.add(bVokabelloeschen);
        // Ende Komponenten

        setVisible(true);
    } // end of public StartWindow

    // Anfang Methoden

    public static void main(String[] args) {
        new StartWindow();
    } // end of main

    public void bLernen_ActionPerformed(ActionEvent evt) {
        // TODO hier Quelltext einfügen

    } // end of bLernen_ActionPerformed

    public void bSuchen_ActionPerformed(ActionEvent evt) {
        // TODO hier Quelltext einfügen

    } // end of bSuchen_ActionPerformed

    public void bVokabelhinzufuegen_ActionPerformed(ActionEvent evt) {
        // TODO hier Quelltext einfügen

    } // end of bVokabelhinzufuegen_ActionPerformed

    public void bSortieren_ActionPerformed(ActionEvent evt) {
        // TODO hier Quelltext einfügen

    } // end of bSortieren_ActionPerformed

    public void bVokabelloeschen_ActionPerformed(ActionEvent evt) {
        // TODO hier Quelltext einfügen

    } // end of bVokabelloeschen_ActionPerformed

    // Ende Methoden
} // end of class StartWindow