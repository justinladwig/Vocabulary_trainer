package com.willis_chico.vocabulary_trainer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 04.02.2020
 * @author
 */

public class SearchWindow extends JFrame {
    // Anfang Attribute
    private JLabel label1 = new JLabel();
    private JLabel label2 = new JLabel();
    private JTextField jTextField1 = new JTextField();
    private JLabel jLabel3 = new JLabel();
    private JComboBox<String> jComboBox1 = new JComboBox<String>();
    private DefaultComboBoxModel<String> jComboBox1Model = new DefaultComboBoxModel<String>();
    private JButton button = new JButton();
    private boolean closed = false;
    // Ende Attribute

    public SearchWindow() {
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
        setTitle("SearchWindow");
        setResizable(false);
        Container cp = getContentPane();
        cp.setLayout(null);
        // Anfang Komponenten

        label1.setBounds(80, 100, 150, 20);
        label1.setText("Deutsch");
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        cp.add(label1);
        label2.setBounds(375, 100, 150, 20);
        label2.setText("English");
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        cp.add(label2);
        jTextField1.setBounds(80, 190, 150, 20);
        cp.add(jTextField1);
        jLabel3.setBounds(375, 190, 150, 20);
        cp.add(jLabel3);
        jComboBox1.setModel(jComboBox1Model);
        jComboBox1.setBounds(200, 25, 200, 20);
        jComboBox1Model.addElement("Deutsch nach Englisch");
        jComboBox1Model.addElement("Englisch nach Deutsch");

        button.setBounds(253, 250, 100, 50);
        button.setText("Übersetzen");
        button.setMargin(new Insets(2, 2, 2, 2));
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                button_ActionPerformed(evt);
            }
        });
        cp.add(button);


        cp.add(jComboBox1);
        // Ende Komponenten

        setVisible(true);


        while(!closed){
            if (jComboBox1Model.getSelectedItem().equals("Deutsch nach Englisch")){
                label1.setText("Englisch");
                label2.setText("Deutsch");
            }
            else{
                label1.setText("Deutsch");
                label2.setText("Englisch");
            }
        }
    } // end of public SearchWindow

    // Anfang Methoden

    public static void main(String[] args) {
        new SearchWindow();
    } // end of main

    public void button_ActionPerformed(ActionEvent evt) {
        // TODO hier Quelltext einfügen

    } // end of button_ActionPerformed

    // Ende Methoden
} // end of class SearchWindow