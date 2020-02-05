package com.willis_chico.vocabulary_trainer;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AddWindow extends JFrame {
    // Anfang Attribute
    private JLabel lGermanword = new JLabel();
    private JLabel lEnglishword = new JLabel();
    private JTextField jTextField1 = new JTextField();
    private JTextField jTextField2 = new JTextField();
    private JButton bAdd = new JButton();
    private JComboBox<String> jComboBox1 = new JComboBox<String>();
    private DefaultComboBoxModel<String> jComboBox1Model = new DefaultComboBoxModel<String>();
    private JLabel lDifficulty = new JLabel();

    private MainFunctions mainFunctions;
    // Ende Attribute

    public AddWindow(MainFunctions mainFunctions) {
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
        setTitle("AddWindow");
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

        lGermanword.setBounds(100, 60, 150, 28);
        lGermanword.setText("German word");
        lGermanword.setHorizontalAlignment(SwingConstants.CENTER);
        lGermanword.setFont(new Font("Dialog", Font.BOLD, 20));
        cp.add(lGermanword);
        lEnglishword.setBounds(450, 60, 150, 28);
        lEnglishword.setText("English word");
        lEnglishword.setHorizontalAlignment(SwingConstants.CENTER);
        lEnglishword.setFont(new Font("Dialog", Font.BOLD, 20));
        cp.add(lEnglishword);
        jTextField1.setBounds(100, 190, 150, 20);
        cp.add(jTextField1);
        jTextField2.setBounds(450, 190, 150, 20);
        cp.add(jTextField2);
        bAdd.setBounds(313, 350, 75, 50);
        bAdd.setText("add");
        bAdd.setMargin(new Insets(2, 2, 2, 2));
        bAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                bAdd_ActionPerformed(evt);
            }
        });
        bAdd.setFont(new Font("Dialog", Font.BOLD, 20));
        cp.add(bAdd);
        jComboBox1.setModel(jComboBox1Model);
        jComboBox1.setBounds(305, 275, 90, 25);
        jComboBox1.setFont(new Font("Dialog", Font.BOLD, 15));
        jComboBox1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jComboBox1Model.addElement("easy");
        jComboBox1Model.addElement("normal");
        jComboBox1Model.addElement("hard");
        jComboBox1.setSelectedIndex(1);
        cp.add(jComboBox1);
        lDifficulty.setBounds(305, 238, 90, 22);
        lDifficulty.setText("difficulty:");
        lDifficulty.setHorizontalAlignment(SwingConstants.LEFT);
        lDifficulty.setFont(new Font("Dialog", Font.BOLD, 15));
        cp.add(lDifficulty);
        // Ende Komponenten

        setVisible(true);
    } // end of public AddWindow

    // Anfang Methoden

    public void bAdd_ActionPerformed(ActionEvent evt) {
        String inputVocable = jTextField1.getText().trim();
        String inputTranslatedVocable = jTextField2.getText().trim();
        Difficulty selectedDifficulty;
        switch (jComboBox1.getSelectedIndex()) {
            case 0:
                selectedDifficulty = Difficulty.EASY;
                System.out.println("easy");
                break;
            case 1:
                selectedDifficulty = Difficulty.NORMAL;
                System.out.println("normal");
                break;
            case 2:
                selectedDifficulty = Difficulty.HARD;
                System.out.println("hard");
                break;
            default:
                selectedDifficulty = Difficulty.NORMAL;
                System.out.println("default");
        }
        if (!inputVocable.equals("") && !inputTranslatedVocable.equals("")) {
            mainFunctions.addVocable(inputVocable, inputTranslatedVocable, selectedDifficulty, 0, 0);
            JOptionPane.showMessageDialog(null, "Successfully added vocable!", "Success!", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Failed to add vocable!\n" + "Are all fields filled?", "Failed!", JOptionPane.ERROR_MESSAGE);
        }
    } // end of bAdd_ActionPerformed

    // Ende Methoden
} // end of class AddWindow

