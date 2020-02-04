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

}
