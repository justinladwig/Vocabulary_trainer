package com.willis_chico.vocabulary_trainer;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StartWindow extends JFrame {
    // Anfang Attribute
    private JButton bLern = new JButton();
    private JButton bSearch = new JButton();
    private JButton bAddvocable1 = new JButton();
    private JButton bDeletevocable = new JButton();
    private JButton bSaveClose1 = new JButton();
    private JLabel lSortby1 = new JLabel();
    private JComboBox<String> jComboBox1 = new JComboBox<String>();
    private DefaultComboBoxModel<String> jComboBox1Model = new DefaultComboBoxModel<String>();

    private MainFunctions mainFunctions;
    private Vocabulary vocabulary;
    // Ende Attribute

    public StartWindow(MainFunctions mainFunctions, Vocabulary vocabulary) {
        // Frame-Initialisierung
        super();
        this.vocabulary = vocabulary;
        this.mainFunctions = mainFunctions;
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        int frameWidth = 700;
        int frameHeight = 540;
        setSize(frameWidth, frameHeight);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (d.width - getSize().width) / 2;
        int y = (d.height - getSize().height) / 2;
        setLocation(x, y);
        setTitle("Vocabulary Trainer");
        setResizable(false);
        Container cp = getContentPane();
        cp.setLayout(null);
        addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e) {
                e.getWindow().dispose();
                mainFunctions.exit();
            }
        });
        // Anfang Komponenten

        bLern.setBounds(200, 50, 300, 75);
        bLern.setText("Learn");
        bLern.setMargin(new Insets(2, 2, 2, 2));
        bLern.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                bLearn_ActionPerformed(evt);
            }
        });
        bLern.setFont(new Font("Dialog", Font.BOLD, 25));
        cp.add(bLern);
        bSearch.setBounds(275, 260, 150, 35);
        bSearch.setText("Search");
        bSearch.setMargin(new Insets(2, 2, 2, 2));
        bSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                bSearch_ActionPerformed(evt);
            }
        });
        cp.add(bSearch);
        bAddvocable1.setBounds(275, 300, 150, 35);
        bAddvocable1.setText("Add vocable");
        bAddvocable1.setMargin(new Insets(2, 2, 2, 2));
        bAddvocable1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                bAddVocable1_ActionPerformed(evt);
            }
        });
        cp.add(bAddvocable1);
        bDeletevocable.setBounds(275, 340, 150, 35);
        bDeletevocable.setText("Delete vocable");
        bDeletevocable.setMargin(new Insets(2, 2, 2, 2));
        bDeletevocable.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                bDeleteVocable_ActionPerformed(evt);
            }
        });
        cp.add(bDeletevocable);
        bSaveClose1.setBounds(275, 400, 150, 35);
        bSaveClose1.setText("Save/Close");
        bSaveClose1.setMargin(new Insets(2, 2, 2, 2));
        bSaveClose1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                bSaveClose1_ActionPerformed(evt);
            }
        });
        bSaveClose1.setFont(new Font("Dialog", Font.BOLD, 13));
        cp.add(bSaveClose1);
        lSortby1.setBounds(275, 150, 150, 35);
        lSortby1.setText("Sort by");
        lSortby1.setHorizontalAlignment(SwingConstants.CENTER);
        lSortby1.setHorizontalTextPosition(SwingConstants.CENTER);
        lSortby1.setFont(new Font("Dialog", Font.BOLD, 12));
        cp.add(lSortby1);
        jComboBox1.setModel(jComboBox1Model);
        jComboBox1.setBounds(275, 190, 150, 35);
        jComboBox1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jComboBox1Model.addElement("random");
        jComboBox1Model.addElement("alphabetical");
        jComboBox1Model.addElement("difficulty");
        jComboBox1Model.addElement("most wrong");
        cp.add(jComboBox1);
        // Ende Komponenten

        setVisible(true);
    } // end of public StartWindow

    // Anfang Methoden

    public void bLearn_ActionPerformed(ActionEvent evt) {
        if (vocabulary.getVocabulary().isEmpty()) {
            if (JOptionPane.showConfirmDialog(null, "You have not added any vocabulary yet.\n" + "Do you want to add?", "No vocabulary added.", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE) == 0) {
                mainFunctions.startAddWindow();
                dispose();
            }
        } else {
            mainFunctions.sort(jComboBox1.getSelectedItem().toString());
            mainFunctions.startLearnWindow();
            dispose();
        }
    } // end of bLearn_ActionPerformed

    public void bSearch_ActionPerformed(ActionEvent evt) {
        mainFunctions.startSearchWindow();
        dispose();

    } // end of bSearch_ActionPerformed

    public void bAddVocable1_ActionPerformed(ActionEvent evt) {
        mainFunctions.startAddWindow();
        dispose();

    } // end of bAddVocable1_ActionPerformed

    public void bDeleteVocable_ActionPerformed(ActionEvent evt) {
        mainFunctions.startDeleteWindow();
        dispose();

    } // end of bDeleteVocable_ActionPerformed

    public void bSaveClose1_ActionPerformed(ActionEvent evt) {
        dispose();
        mainFunctions.exit();
    } // end of bSaveClose1_ActionPerformed

    // Ende Methoden
} // end of class StartWindow