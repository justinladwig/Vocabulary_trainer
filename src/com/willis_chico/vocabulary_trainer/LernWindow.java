package com.willis_chico.vocabulary_trainer;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 22.01.2020
 * @author 
 */

public class LernWindow extends JFrame {
  // Anfang Attribute
  private JLabel jLabel1 = new JLabel();
  private JTextArea jTextArea1 = new JTextArea("");
    private JScrollPane jTextArea1ScrollPane = new JScrollPane(jTextArea1);
  private JLabel lPractice1 = new JLabel();
  private JButton bNext = new JButton();
  private JLabel lGerman = new JLabel();
  private JLabel lEnglish = new JLabel();
  private JLabel lGermanEnglish1 = new JLabel();

  private HG s;
  // Ende Attribute
  
  public LernWindow(HG s) {
    // Frame-Initialisierung
    super();
    this.s = s;
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 700; 
    int frameHeight = 540;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("Lern");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    addWindowListener(new WindowAdapter()
    {
      @Override
      public void windowClosing(WindowEvent e)
      {
        e.getWindow().dispose();
        s.startStartWindow();
      }
    });

    // Anfang Komponenten
    addWindowListener(new WindowAdapter()
    {
      @Override
      public void windowClosing(WindowEvent e) {
        e.getWindow().dispose();
      }
    });
    jLabel1.setBounds(20, 80, 300, 400);
    jLabel1.setText("");
    jLabel1.setFont(new Font("Dialog", Font.BOLD, 20));
    jLabel1.setHorizontalTextPosition(SwingConstants.CENTER);
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setVerticalAlignment(SwingConstants.TOP);
    jLabel1.setBackground(Color.WHITE);
    jLabel1.setOpaque(true);
    cp.add(jLabel1);
    jTextArea1ScrollPane.setBounds(364, 80, 300, 400);
    jTextArea1.setWrapStyleWord(false);
    jTextArea1.setToolTipText("Translation");
    lPractice1.setBounds(0, 0, 140, 40);
    lPractice1.setText("Practice:");
    lPractice1.setFont(new Font("@Microsoft JhengHei UI", Font.BOLD, 28));
    cp.add(lPractice1);
    bNext.setBounds(530, 15, 140, 40);
    bNext.setText("Next");
    bNext.setMargin(new Insets(2, 2, 2, 2));
    bNext.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        bNext_ActionPerformed(evt);
      }
    });
    bNext.setBackground(new Color(0xF9F7A4));
    bNext.setForeground(Color.BLACK);
    cp.add(bNext);
    cp.setBackground(new Color(0xBCE7FE));
    lGerman.setBounds(20, 61, 110, 20);
    lGerman.setText("German");
    lGerman.setBackground(Color.WHITE);
    lGerman.setOpaque(true);
    lGerman.setHorizontalAlignment(SwingConstants.CENTER);
    cp.add(lGerman);
    lEnglish.setBounds(365, 61, 110, 20);
    lEnglish.setText("English");
    lEnglish.setBackground(Color.WHITE);
    lEnglish.setOpaque(true);
    lEnglish.setHorizontalAlignment(SwingConstants.CENTER);
    cp.add(lEnglish);
    lGermanEnglish1.setBounds(290, 0, 110, 20);
    lGermanEnglish1.setText("German => English");
    cp.add(lGermanEnglish1);
    // Ende Komponenten
    cp.add(jTextArea1ScrollPane);

    setVisible(true);
  } // end of public Lern
  
  // Anfang Methoden

  public void bNext_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    
  } // end of bNext_ActionPerformed

  // Ende Methoden
} // end of class Lern

