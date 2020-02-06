package com.gittending_software_solutions.vocabulary_trainer;

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

    public void setNumberWrong(int numberWrong) {
        this.numberWrong = numberWrong;
    }

    public void setNumberRight(int numberRight) {
        this.numberRight = numberRight;
    }
}
