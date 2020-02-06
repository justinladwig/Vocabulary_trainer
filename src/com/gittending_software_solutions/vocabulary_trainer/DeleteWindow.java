package com.gittending_software_solutions.vocabulary_trainer;

import com.gittending_software_solutions.vocabulary_trainer.MainFunctions;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DeleteWindow extends JFrame {
  // Anfang Attribute
  private JButton bDelete = new JButton();
  private ImageIcon bDeleteIcon = new ImageIcon("res/trashcan.png");
  private JTextField jTextField = new JTextField();
  private JComboBox<String> jComboBox1 = new JComboBox<String>();
  private DefaultComboBoxModel<String> jComboBox1Model = new DefaultComboBoxModel<String>();
  private JLabel lDeletevocable = new JLabel();
  private JLabel lEntervocable = new JLabel();

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

    bDelete.setBounds(300, 263, 100, 50);
    bDelete.setText("Delete");
    bDelete.setMargin(new Insets(2, 2, 2, 2));
    bDelete.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        bDelete_ActionPerformed(evt);
      }
    });
    bDelete.setBackground(Color.RED);
    bDelete.setForeground(Color.WHITE);
    bDelete.setBorder(BorderFactory.createEtchedBorder(0, Color.WHITE, new Color(0xC0C0C0)));
    bDelete.setIcon(bDeleteIcon);
    cp.add(bDelete);
    jTextField.setBounds(323, 187, 150, 20);
    cp.add(jTextField);
    jComboBox1.setModel(jComboBox1Model);
    jComboBox1.setBounds(275, 110, 150, 20);
    jComboBox1Model.addElement("German");
    jComboBox1Model.addElement("English");
    cp.add(jComboBox1);
    lDeletevocable.setBounds(279, 34, 142, 28);
    lDeletevocable.setText("Delete vocable");
    lDeletevocable.setFont(new Font("Dialog", Font.BOLD, 20));
    lDeletevocable.setHorizontalAlignment(SwingConstants.CENTER);
    cp.add(lDeletevocable);
    lEntervocable.setBounds(215, 187, 100, 20);
    lEntervocable.setText("Enter vocable:");
    cp.add(lEntervocable);
    // Ende Komponenten

    setVisible(true);
  } // end of public DeleteWindow
  
  // Anfang Methoden

  public void bDelete_ActionPerformed(ActionEvent evt) {
    if (jTextField.getText().trim().equals("")) {
      JOptionPane.showMessageDialog(null, "Failed to delete vocable!\n" + "Are all fields filled?", "Failed!", JOptionPane.ERROR_MESSAGE);
    } else {
      if (jComboBox1.getSelectedItem().toString().equals("English")) {
        if (mainFunctions.search(jTextField.getText().trim(), true) == null) {
          JOptionPane.showMessageDialog(null, "This vocable does not exist!", "Error", JOptionPane.INFORMATION_MESSAGE);
        } else {
          if (JOptionPane.showConfirmDialog(null, "Do you really want to delete the vocable?", "Delete vocable", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE) == 0) {
            mainFunctions.delete(jTextField.getText().trim(), true);
            JOptionPane.showMessageDialog(null, "Vocable successful deleted!", "Deleted!", JOptionPane.INFORMATION_MESSAGE);
            jTextField.setText("");
          }
        }
      } else {
        if (mainFunctions.search(jTextField.getText(), false) == null) {
          JOptionPane.showMessageDialog(null, "This vocable does not exist!", "Error", JOptionPane.INFORMATION_MESSAGE);
        } else {
          if (JOptionPane.showConfirmDialog(null, "Do you really want to delete the vocable?", "Delete vocable", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE) == 0) {
            mainFunctions.delete(jTextField.getText().trim(), false);
            JOptionPane.showMessageDialog(null, "Vocable successful deleted!", "Deleted!", JOptionPane.INFORMATION_MESSAGE);
            jTextField.setText("");
          }
        }
      }
    }
  } // end of bDelete_ActionPerformed

  // Ende Methoden
} // end of class DeleteWindow

