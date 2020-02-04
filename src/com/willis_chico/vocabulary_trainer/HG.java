package com.willis_chico.vocabulary_trainer;

public class HG {
    private Collection collection;
    private StartWindow startWindow;
    private LernWindow lernWindow;

    public HG() {
        collection= new Collection();
        collection.importVocabulary();
        startStartWindow();
    }

    public void startLernWindow(){
        lernWindow = new LernWindow(this);
    }
    public void startStartWindow(){
        startWindow = new StartWindow(this);
    }
    public void exit(){
        collection.exportVocabulary();
        System.out.println("LUL");
    }
    public Vocable search(String word, boolean translation){
        if(translation){
            return collection.searchVocableTranslation(word);
        }
        else {
            return collection.searchVocable(word);
        }
    }
    public void sort(String s){
        switch (s){
            case "random":
                collection.sortVocabularyRandom();
                break;
            case "alphabetical":
                collection.sortVocabularyAlphabetic();
                break;
            case "difficulty":
                collection.sortVocabularyDifficulty();
                break;
            case "most wrong":
                collection.sortVocabularyNumberWrong();
                break;
        }
    }
}
