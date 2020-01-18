package com.willis_chico.vocabulary_trainer;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        FileEditor editor = new FileEditor("res/vocable.csv");
        editor.scan();
        List<String[]> values = editor.getValues();
        for (String[] value : values) {
            System.out.println(Arrays.toString(value));
        }
        String []vok = {"Justin", "Ladwig", "3", "2", "1"};
        values.add(vok);
        editor.setValues(values);
        editor.write();
    }
}
