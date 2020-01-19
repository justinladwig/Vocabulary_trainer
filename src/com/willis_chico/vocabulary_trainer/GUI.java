package com.willis_chico.vocabulary_trainer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    private JPanel panel1;
    private JButton button1;

    public GUI() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(null, "Hallo Lars");
            }
        });
    }

    public static void main(String[] args) {
        for (;true;) {
            JFrame frame = new JFrame("Vocable Trainer");
            frame.setContentPane(new GUI().panel1);
            frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        }
   }
}