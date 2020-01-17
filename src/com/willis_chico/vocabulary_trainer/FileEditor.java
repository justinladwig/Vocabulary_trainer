package com.willis_chico.vocabulary_trainer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileEditor {
    private final String path = "res/vocable.csv";
    private File file;
    private Scanner scanner;
    private List<String[]> values;
    private final String splitBy = ",";

    public FileEditor() {
        file = new File(path);
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        values = new ArrayList<>();
    }

    public void scan() {
        String line;
        String[] strings;
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            strings = line.split(splitBy);
            for (int i = 0; i < strings.length; i++) {
                strings[i] = strings[i].replace("\"", "");
                strings[i] = strings[i].trim();
            }
            values.add(strings);
        }
    }

    public List<String[]> getValues() {
        return values;
    }
}
