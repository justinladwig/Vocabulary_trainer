package com.willis_chico.vocabulary_trainer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileEditor {
    private final String path = "res/vocable.csv";
    private File file;
    private Scanner scanner;
    private List<String[]> values;
    private final String seperator = ",";
    private PrintWriter writer;

    public FileEditor() {
        file = new File(path);
        values = new ArrayList<>();
    }

    // Liest die vocable.csv Datei und speichert die Werte
    public void scan() {
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line;
        String[] strings;
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            strings = line.split(seperator);
            for (int i = 0; i < strings.length; i++) {
                strings[i] = strings[i].replace("\"", "");
                strings[i] = strings[i].trim();
            }
            values.add(strings);
        }
        scanner.close();
    }

    // Schreibt die Werte in die vocable.csv Datei
    public void write() {
        try {
            writer = new PrintWriter(new FileWriter(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < values.size(); i++) {
            for (int j = 0; j < values.get(i).length; j++) {
                if (j < values.get(i).length - 1)
                    writer.print(values.get(i)[j] + seperator);
                else
                    writer.println(values.get(i)[j]);
            }
        }
        writer.close();
    }

    // get- und set-Methode
    public List<String[]> getValues() {
        return values;
    }

    public void setValues(List<String[]> values) {
        this.values = values;
    }
}
