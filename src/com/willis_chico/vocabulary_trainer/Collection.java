package com.willis_chico.vocabulary_trainer;

import java.util.ArrayList;
import java.util.List;

public class Collection {
    List<vocabel> vocabulary;
    FileEditor editor;

    public Collection() {
        vocabulary = new ArrayList<>();
        editor = new FileEditor("res/vocable.csv");
    }

    public void importVocabulary(){
        List<String[]> values;
        editor.scan();
        values = editor.getValues();
    }
    public void exportVocabulary(){
        List<String[]> values;


        //editor.setValues(values);
        editor.write();
    }
}
