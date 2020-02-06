package com.gittending_software_solutions.vocabulary_trainer;

public class MainFunctions {
    private Vocabulary vocabulary;

    public MainFunctions() {
        vocabulary = new Vocabulary();
        vocabulary.importVocabulary();
        startStartWindow();
    }

    public void startLearnWindow() {
        new LearnWindow(this, vocabulary);
    }

    public void startStartWindow() {
        new StartWindow(this, vocabulary);
    }

    public void startSearchWindow() {
        new SearchWindow(this);
    }

    public void startAddWindow() {
        new AddWindow(this);
    }

    public void startDeleteWindow() {
        new DeleteWindow(this);
    }

    // Methodenaufruf um Vokabel in Datei zu speichern
    public void exit() {
        vocabulary.exportVocabulary();
    }

    public void addVocable(String word, String translation, Difficulty difficulty, int numberWrong, int numberRight) {
        vocabulary.addVocable(new Vocable(word, translation, difficulty, numberWrong, numberRight));
    }

    //Nach Vokabel suchen: false für Deutsch und true für Englisch
    public Vocable search(String word, boolean translation) {
        if (translation) {
            return vocabulary.searchVocableTranslation(word);
        } else {
            return vocabulary.searchVocable(word);
        }
    }
    public void delete(String word, boolean translation) {
        if (translation) {
            vocabulary.deleteVocableTranslation(word);
        } else {
            vocabulary.deleteVocable(word);
        }
    }

    // Liste nach Art sortieren
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
