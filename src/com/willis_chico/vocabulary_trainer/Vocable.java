package com.willis_chico.vocabulary_trainer;

public class Vocable {
    private String word;
    private String translation;
    private Difficulty difficulty;
    private int numberWrong;
    private int numberRight;

    public Vocable(String word, String translation, Difficulty difficulty, int numberWrong, int numberRight) {
        this.word = word;
        this.translation = translation;
        this.difficulty = difficulty;
        this.numberWrong = numberWrong;
        this.numberRight = numberRight;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getTranslation() {
        return translation;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public int getNumberWrong() {
        return numberWrong;
    }

    public int getNumberRight() {
        return numberRight;
    }
}
