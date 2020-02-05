package com.willis_chico.vocabulary_trainer;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class DeleteWindow extends JFrame {
  // Anfang Attribute
  private JComboBox<String> jComboBox1 = new JComboBox<String>();
  private DefaultComboBoxModel<String> jComboBox1Model = new DefaultComboBoxModel<String>();
  private JButton bDelete = new JButton();
  private JTextField jTextField = new JTextField();

  private MainFunctions mainFunctions;
  // Ende Attribute
  
  public DeleteWindow(MainFunctions mainFunctions) {
    // Frame-Initialisierung
    super();
    this.mainFunctions = mainFunctions;
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 700; 
    int frameHeight = 540;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("DeleteWindow");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        e.getWindow().dispose();
        mainFunctions.startStartWindow();
      }
    });
    // Anfang Komponenten
    
    jComboBox1.setModel(jComboBox1Model);
    jComboBox1.setBounds(275, 92, 150, 20);
    jComboBox1.setCursor(new Cursor(Cursor.HAND_CURSOR));
    jComboBox1Model.addElement("German");
    jComboBox1Model.addElement("English");
    cp.add(jComboBox1);
    bDelete.setBounds(300, 309, 100, 75);
    bDelete.setText("delete");
    bDelete.setMargin(new Insets(2, 2, 2, 2));
    bDelete.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bDelete_ActionPerformed(evt);
      }
    });
    bDelete.setBackground(Color.RED);
    bDelete.setFont(new Font("Dialog", Font.BOLD, 20));
    bDelete.setForeground(Color.WHITE);
    cp.add(bDelete);
    jTextField.setBounds(275, 201, 150, 20);
    cp.add(jTextField);
    // Ende Komponenten
    
    setVisible(true);
  } // end of public DeleteWindow
  
  // Anfang Methoden
  
  public void bDelete_ActionPerformed(ActionEvent evt) {
    if (jTextField.getText().trim().equals("")) {
      JOptionPane.showMessageDialog(null, "Failed to delete vocable!\n" + "Are all fields filled?", "Failed!", JOptionPane.ERROR_MESSAGE);
    }
    else {
      if (jComboBox1.getSelectedItem().toString().equals("Englisch")) {
        if (mainFunctions.search(jTextField.getText().trim(), true) == null) {
          JOptionPane.showMessageDialog(null, "This vocable does not exist!", "Error", JOptionPane.INFORMATION_MESSAGE);
        } else {
          if (JOptionPane.showConfirmDialog(null, "Do you really want to delete the vocable?", "Delete vocable", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE) == 0) {
            JOptionPane.showMessageDialog(null, "Vocable successful deleted!", "Deleted!", JOptionPane.INFORMATION_MESSAGE);
            mainFunctions.delete(jTextField.getText().trim(), true);
          }
        }
      }
      else{
        if(mainFunctions.search(jTextField.getText(),false)==null){
          JOptionPane.showMessageDialog(null, "This vocable does not exist!", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
          if (JOptionPane.showConfirmDialog(null, "Do you really want to delete the vocable?", "Delete vocable", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE) == 0) {
            JOptionPane.showMessageDialog(null, "Vocable successful deleted!", "Deleted!", JOptionPane.INFORMATION_MESSAGE);
            mainFunctions.delete(jTextField.getText().trim(),false);
          }
        }
      }
    }

   } // end of bDelete_ActionPerformed

  // Ende Methoden
} // end of class DeleteWindow
