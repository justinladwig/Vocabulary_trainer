package com.willis_chico.vocabulary_trainer;

import java.io.*;
import java.util.Scanner;

public class FileEditor {
    private File file;
    private Scanner scanner;
    private List<String[]> values;
    private final String separator = ",";
    private PrintWriter writer;

    public FileEditor(String path) {
        file = new File(path);
        values = new List<>();
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
            values.append(strings);
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
        values.toFirst();
        while (values.hasAccess()) {
            for (int j = 0; j < values.getContent().length; j++) {
                if (j < values.getContent().length - 1)
                    writer.print(values.getContent()[j] + separator);
                else
                    writer.println(values.getContent()[j]);
            }
            values.next();
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
