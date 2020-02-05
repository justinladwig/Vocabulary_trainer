package com.willis_chico.vocabulary_trainer;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 12.01.2020
 * @author
 */

public class StartFenster extends JFrame {
    // Anfang Attribute
    private JLabel jLabel1 = new JLabel();
    private ImageIcon jLabel1Icon = new ImageIcon(getClass().getResource("images/blaulaulau.png"));
    private JButton bStart = new JButton();
    // Ende Attribute

    public StartFenster() {
        // Frame-Initialisierung
        super();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        int frameWidth = 501;
        int frameHeight = 650;
        setSize(frameWidth, frameHeight);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (d.width - getSize().width) / 2;
        int y = (d.height - getSize().height) / 2;
        setLocation(x, y);
        setTitle("Start");
        setResizable(false);
        Container cp = getContentPane();
        cp.setLayout(null);
        // Anfang Komponenten

        jLabel1.setBounds(0, 0, 501, 486);
        jLabel1.setText("text");
        jLabel1.setIcon(jLabel1Icon);
        cp.add(jLabel1);
        bStart.setBounds(213, 507, 75, 75);
        bStart.setText("Start");
        bStart.setMargin(new Insets(2, 2, 2, 2));
        bStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                bStart_ActionPerformed(evt);
            }
        });
        bStart.setIcon(bStartIcon);
        bStart.setFont(new Font("Dialog", Font.BOLD, 24));
        bStart.setHorizontalTextPosition(SwingConstants.CENTER);
        cp.add(bStart);
        // Ende Komponenten

        setVisible(true);
    } // end of public StartFenster

    // Anfang Methoden

    public static void main(String[] args) {
        new StartFenster();
    } // end of main

    public void bStart_ActionPerformed(ActionEvent evt) {
        // TODO hier Quelltext einfügen

    } // end of bStart_ActionPerformed

    // Ende Methoden
} // end of class StartFenster