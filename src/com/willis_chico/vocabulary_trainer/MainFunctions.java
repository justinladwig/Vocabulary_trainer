package com.willis_chico.vocabulary_trainer;

public class MainFunctions {
    private Vocabulary vocabulary;

    public MainFunctions() {
        vocabulary = new Vocabulary();
        vocabulary.importVocabulary();
        startStartWindow();
    }

    public void startLearnWindow() {
        new LearnWindow(this);
    }

    public void startStartWindow() {
        new StartWindow(this);
    }

    public void startSearchWindow() {
        new SearchWindow(this);
    }

    public void startAddWindow() {
        new AddWindow(this);
    }

    public void exit() {
        vocabulary.exportVocabulary();
        System.out.println("LUL");
    }

    public void addVocable(String word, String translation, Difficulty difficulty, int numberWrong, int numberRight) {
        vocabulary.addVocable(new Vocable(word, translation, difficulty, numberWrong, numberRight));
    }

    public Vocable search(String word, boolean translation) {
        if (translation) {
            return vocabulary.searchVocableTranslation(word);
        } else {
            return vocabulary.searchVocable(word);
        }
    }

    public void sort(String s) {
        switch (s) {
            case "random":
                vocabulary.sortVocabularyRandom();
                break;
            case "alphabetical":
                vocabulary.sortVocabularyAlphabetic();
                break;
            case "difficulty":
                vocabulary.sortVocabularyDifficulty();
                break;
            case "most wrong":
                vocabulary.sortVocabularyNumberWrong();
                break;
        }
    }
}
