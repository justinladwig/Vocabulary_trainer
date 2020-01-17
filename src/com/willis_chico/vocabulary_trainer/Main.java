package com.willis_chico.vocabulary_trainer;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello Raas");
        FileEditor editor = new FileEditor();
        List<String[]> values = editor.getValues();
        for (int i = 0; i < values.size(); i++) {
            System.out.println(values.get(i).toString());
        }
    }
}
