package com.willis_chico.vocabulary_trainer;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 05.02.2020
 * @author
 */

public class AddWindow extends JFrame {
    // Anfang Attribute
    private JLabel lGermanword1 = new JLabel();
    private JLabel lEnglishword = new JLabel();
    private JTextField jTextField1 = new JTextField();
    private JTextField jTextField2 = new JTextField();
    private JButton bAdd = new JButton();
    // Ende Attribute

    public AddWindow() {
        // Frame-Initialisierung
        super();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        int frameWidth = 600;
        int frameHeight = 400;
        setSize(frameWidth, frameHeight);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (d.width - getSize().width) / 2;
        int y = (d.height - getSize().height) / 2;
        setLocation(x, y);
        setTitle("AddWindow");
        setResizable(false);
        Container cp = getContentPane();
        cp.setLayout(null);
        // Anfang Komponenten

        lGermanword1.setBounds(100, 60, 150, 28);
        lGermanword1.setText("German word");
        lGermanword1.setHorizontalAlignment(SwingConstants.CENTER);
        lGermanword1.setFont(new Font("Dialog", Font.BOLD, 20));
        cp.add(lGermanword1);
        lEnglishword.setBounds(350, 60, 150, 28);
        lEnglishword.setText("English word");
        lEnglishword.setHorizontalAlignment(SwingConstants.CENTER);
        lEnglishword.setFont(new Font("Dialog", Font.BOLD, 20));
        cp.add(lEnglishword);
        jTextField1.setBounds(100, 150, 150, 20);
        cp.add(jTextField1);
        jTextField2.setBounds(350, 150, 150, 20);
        cp.add(jTextField2);
        bAdd.setBounds(263, 225, 75, 50);
        bAdd.setText("add");
        bAdd.setMargin(new Insets(2, 2, 2, 2));
        bAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                bAdd_ActionPerformed(evt);
            }
        });
        bAdd.setFont(new Font("Dialog", Font.BOLD, 20));
        cp.add(bAdd);
        // Ende Komponenten

        setVisible(true);
    } // end of public AddWindow

    // Anfang Methoden

    public static void main(String[] args) {
        new AddWindow();
    } // end of main

    public void bAdd_ActionPerformed(ActionEvent evt) {
        // TODO hier Quelltext einfügen

    } // end of bAdd_ActionPerformed

    // Ende Methoden
} // end of class AddWindow