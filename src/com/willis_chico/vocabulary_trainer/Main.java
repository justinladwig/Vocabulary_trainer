package com.willis_chico.vocabulary_trainer;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Collection collection = new Collection();
        collection.importVocabulary();
        collection.printVocabulary();
        collection.exportVocabulary();
    }
}
