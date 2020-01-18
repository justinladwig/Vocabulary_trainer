package com.willis_chico.vocabulary_trainer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileEditor {
    private File file;
    private Scanner scanner;
    private List<String[]> values;
    private final String separator = ",";
    private PrintWriter writer;

    public FileEditor(String path) {
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
            strings = line.split(separator);
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
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String[] value : values) {
            for (int i = 0; i < value.length; i++) {
                if (i < value.length - 1)
                    writer.print(value[i] + separator);
                else
                    writer.println(value[i]);
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
