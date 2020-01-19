package com.willis_chico.vocabulary_trainer;

public class Main {

    public static void main(String[] args) {
        Collection collection = new Collection();
        collection.importVocabulary();
        collection.printVocabulary();
        System.out.println();
        collection.addVocable(new Vocable("Mischa", "Buch", Difficulty.NORMAL, 1, 0));
        collection.printVocabulary();
        System.out.println();
        collection.deleteVocable("Mischa");
        collection.printVocabulary();
        System.out.println();
        collection.exportVocabulary();
    }
}
