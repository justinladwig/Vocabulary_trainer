package com.willis_chico.vocabulary_trainer;

public class Collection {
    private List<Vocabel> vocabulary;
    private FileEditor editor;

    public Collection() {
        vocabulary = new List<>();
        editor = new FileEditor("res/vocable.csv");
    }

    public void importVocabulary(){
        editor.scan();
        List<String[]> values = editor.getValues();
        Difficulty difficulty;
        values.toFirst();
        while(values.hasAccess()) {
            switch (Integer.parseInt(values.getContent()[2])){
                case 1:
                    difficulty = Difficulty.EASY;
                    break;
                case 3:
                    difficulty = Difficulty.HARD;
                    break;
                default:
                    difficulty = Difficulty.NORMAL;
            }
            vocabulary.append(new Vocabel(values.getContent()[0], values.getContent()[1],difficulty, Integer.parseInt(values.getContent()[3]), Integer.parseInt(values.getContent()[4])));
            values.next();
        }
    }
    public void exportVocabulary(){
        List<String[]> values = new List<>();
        vocabulary.toFirst();
        while(vocabulary.hasAccess()) {
            String[] voc = new String[5];
            voc[0] = vocabulary.getContent().getWord();
            voc[1] = vocabulary.getContent().getTranslation();
            voc[2] = String.valueOf(vocabulary.getContent().getDifficulty().getValue());
            voc[3] = String.valueOf(vocabulary.getContent().getNumberWrong());
            voc[4] = String.valueOf(vocabulary.getContent().getNumberRight());
            values.append(voc);
            vocabulary.next();
        }
        editor.setValues(values);
        editor.write();
    }
    public void printVocabulary(){
        vocabulary.toFirst();
        while(vocabulary.hasAccess()){
            System.out.print(vocabulary.getContent().getWord() + " ");
            System.out.print(vocabulary.getContent().getTranslation() + " ");
            System.out.print(vocabulary.getContent().getDifficulty() + " ");
            System.out.print(vocabulary.getContent().getNumberWrong() + " ");
            System.out.print(vocabulary.getContent().getNumberRight() + " ");
            System.out.println();
            vocabulary.next();
        }
    }
    public void addVocable(Vocabel vocabel){
        vocabulary.append(vocabel);
    }
    public void deleteVocable(String word){
        vocabulary.toFirst();
        while (vocabulary.hasAccess()){
            if(vocabulary.getContent().getWord().equals(word)){
                vocabulary.remove();
            }
            else {
                vocabulary.next();
            }
        }
    }
}
