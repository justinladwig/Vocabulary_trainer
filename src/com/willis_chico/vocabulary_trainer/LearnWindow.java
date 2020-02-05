package com.willis_chico.vocabulary_trainer;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LearnWindow extends JFrame {
  // Anfang Attribute
  private JLabel jLabel1 = new JLabel();
  private JTextArea jTextArea1 = new JTextArea("");
  private JScrollPane jTextArea1ScrollPane = new JScrollPane(jTextArea1);
  private JLabel lPractice1 = new JLabel();
  private JButton bNext = new JButton();
  private JLabel lGerman = new JLabel();
  private JLabel lEnglish = new JLabel();
  private JLabel lGermanEnglish1 = new JLabel();

  private MainFunctions mainFunctions;
  private List<Vocable> vocableList;
  private Vocabulary vocabulary;
  // Ende Attribute

  public LearnWindow(MainFunctions mainFunctions, Vocabulary vocabulary) {
    // Frame-Initialisierung
    super();
    this.mainFunctions = mainFunctions;
    this.vocabulary = vocabulary;
    this.vocableList = vocabulary.getVocabulary();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 700;
    int frameHeight = 540;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("Learn");
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
    jTextArea1.setFont(new Font("Dialog", Font.BOLD, 20));
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
    lGermanEnglish1.setText("German → English");
    cp.add(lGermanEnglish1);
    // Ende Komponenten
    cp.add(jTextArea1ScrollPane);

    vocableList.toFirst();
    jLabel1.setText(vocableList.getContent().getWord());
    setVisible(true);
  } // end of public Learn

  // Anfang Methoden

  public void bNext_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    if (jTextArea1.getText().trim().equals(vocableList.getContent().getTranslation())) {
      vocabulary.addRight();
      JOptionPane.showMessageDialog(null, "Correct!", "Correct!", JOptionPane.INFORMATION_MESSAGE);
    } else if (jTextArea1.getText().trim().equals("")) {
      JOptionPane.showMessageDialog(null, "Are all fields filled?", "Failed!", JOptionPane.ERROR_MESSAGE);
      return;
    } else {
      vocabulary.addWrong();
      JOptionPane.showMessageDialog(null, String.format("Wrong answer!\n" + "the correct one is: %s", vocableList.getContent().getTranslation()), "Wrong answer!", JOptionPane.WARNING_MESSAGE);
    }
    vocableList.next();
    if (vocableList.getContent() != null) {
      jLabel1.setText(vocableList.getContent().getWord());
      jTextArea1.setText("");
    } else {
      JOptionPane.showMessageDialog(null, "You learned all vocabulary!", "Finish!", JOptionPane.INFORMATION_MESSAGE);
      dispose();
      mainFunctions.startStartWindow();
    }
  } // end of bNext_ActionPerformed

  // Ende Methoden
} // end of class Learn

