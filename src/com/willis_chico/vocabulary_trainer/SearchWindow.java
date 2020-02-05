package com.willis_chico.vocabulary_trainer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
    private JLabel label3 = new JLabel();
    private JLabel right = new JLabel();
    private JLabel wrong = new JLabel();
    private JLabel difficulty = new JLabel();
    private JLabel rightV = new JLabel();
    private JLabel wrongV = new JLabel();
    private JLabel difficultyV = new JLabel();
    private JTextField jTextField1 = new JTextField();
    private JComboBox<String> jComboBox1 = new JComboBox<String>();
    private DefaultComboBoxModel<String> jComboBox1Model = new DefaultComboBoxModel<String>();
    private JButton button = new JButton();

    private MainFunctions mainFunctions;
    // Ende Attribute

    public SearchWindow(MainFunctions mainFunctions) {
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
        setTitle("SearchWindow");
        setResizable(false);
        Container cp = getContentPane();
        cp.setLayout(null);
        addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                e.getWindow().dispose();
                mainFunctions.startStartWindow();
            }
        });
        // Anfang Komponenten

        label1.setBounds(100, 120, 150, 20);
        label1.setText("German");
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        cp.add(label1);
        label2.setBounds(450, 120, 150, 20);
        label2.setText("English");
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        cp.add(label2);
        jTextField1.setBounds(100, 210, 150, 20);
        cp.add(jTextField1);
        label3.setBounds(450, 210, 150, 20);
        label3.setBackground(Color.WHITE);
        label3.setOpaque(true);
        cp.add(label3);
        right.setBounds(450, 250, 50, 20);
        right.setText("right:");
        cp.add(right);
        rightV.setBounds(510, 250, 50, 20);
        cp.add(rightV);
        wrong.setBounds(450, 270, 60, 20);
        wrong.setText("wrong:");
        cp.add(wrong);
        wrongV.setBounds(510, 270, 60, 20);
        cp.add(wrongV);
        difficulty.setBounds(450, 290, 110, 20);
        difficulty.setText("difficulty :");
        cp.add(difficulty);
        difficultyV.setBounds(510, 290, 110, 20);
        cp.add(difficultyV);
        jComboBox1.setModel(jComboBox1Model);
        jComboBox1.setBounds(250, 45, 200, 20);
        jComboBox1Model.addElement("German to English");
        jComboBox1Model.addElement("English to German");
        jComboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (jComboBox1Model.getSelectedItem().equals("English to German")){
                    label1.setText("English");
                    label2.setText("German");
                }
                else{
                    label1.setText("German");
                    label2.setText("English");
                }
            }
        });
        button.setBounds(300, 320, 100, 50);
        button.setText("translate");
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
    } // end of public SearchWindow

    // Anfang Methoden

    public void button_ActionPerformed(ActionEvent evt) {
        label3.setText("ja nein ja nein");
        rightV.setText("10");
        wrongV.setText("10");
        difficultyV.setText("normal");

    } // end of button_ActionPerformed

    // Ende Methoden
} // end of class SearchWindow