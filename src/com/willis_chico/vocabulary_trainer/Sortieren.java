package com.willis_chico.vocabulary_trainer;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 21.01.2020
 * @author 
 */

public class Sortieren extends JFrame {
  // Anfang Attribute
  private JComboBox<String> jComboBox1 = new JComboBox<String>();
    private DefaultComboBoxModel<String> jComboBox1Model = new DefaultComboBoxModel<String>();
  private JButton bSort = new JButton();
  // Ende Attribute
  
  public Sortieren() { 
    // Frame-Initialisierung
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 400; 
    int frameHeight = 300;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("Sortieren");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    jComboBox1.setModel(jComboBox1Model);
    jComboBox1.setBounds(100, 50, 200, 30);
    jComboBox1Model.addElement("random");
    jComboBox1Model.addElement("alphabetical");
    jComboBox1Model.addElement("difficulty");
    cp.add(jComboBox1);
    bSort.setBounds(125, 150, 150, 40);
    bSort.setText("sort");
    bSort.setMargin(new Insets(2, 2, 2, 2));
    bSort.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bSort_ActionPerformed(evt);
      }
    });
    bSort.setFont(new Font("Dialog", Font.BOLD, 20));
    cp.add(bSort);
    // Ende Komponenten
    
    setVisible(true);
  } // end of public Sortieren
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    new Sortieren();
  } // end of main
  
  public void bSort_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einf�gen
    
  } // end of bSort_ActionPerformed

  // Ende Methoden
} // end of class Sortieren

