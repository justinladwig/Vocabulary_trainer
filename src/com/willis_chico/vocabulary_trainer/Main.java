package com.willis_chico.vocabulary_trainer;

public class Main {

    public static void main(String[] args) {
        Collection collection = new Collection();
        collection.importVocabulary();
        collection.addVocable(new Vocable("Mischa", "Buch", Difficulty.NORMAL, 1, 0));
        collection.printVocabulary();
        System.out.println();
        collection.sortVocabularyRandom();
        collection.printVocabulary();
        System.out.println();
        collection.exportVocabulary();
    }
}
