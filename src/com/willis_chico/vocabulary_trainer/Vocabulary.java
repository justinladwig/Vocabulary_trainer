package com.willis_chico.vocabulary_trainer;

import java.util.Random;

public class Vocabulary {
    private List<Vocable> vocabulary;
    private FileEditor editor;

    public Vocabulary() {
        vocabulary = new List<>();
        editor = new FileEditor("res/vocable.csv");
    }

    // Vokabeln aus Datei in Liste speichern
    public void importVocabulary() {
        editor.scan();
        List<String[]> values = editor.getValues();
        Difficulty difficulty;
        values.toFirst();
        // TODO: 19.01.2020 Auf fehlerhafte CSV überprüfen
        while (values.hasAccess()) {
            try {
                switch (Integer.parseInt(values.getContent()[2])) {
                    case 1:
                        difficulty = Difficulty.EASY;
                        break;
                    case 3:
                        difficulty = Difficulty.HARD;
                        break;
                    case 2:
                    default:
                        difficulty = Difficulty.NORMAL;
                }
                vocabulary.append(new Vocable(values.getContent()[0], values.getContent()[1], difficulty, Integer.parseInt(values.getContent()[3]), Integer.parseInt(values.getContent()[4])));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            values.next();
        }
    }

    // Vokabeln aus Liste in Datei speichern
    public void exportVocabulary() {
        List<String[]> values = new List<>();
        vocabulary.toFirst();
        while (vocabulary.hasAccess()) {
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

    public void printVocabulary() {
        vocabulary.toFirst();
        while (vocabulary.hasAccess()) {
            System.out.print(vocabulary.getContent().getWord() + " ");
            System.out.print(vocabulary.getContent().getTranslation() + " ");
            System.out.print(vocabulary.getContent().getDifficulty() + " ");
            System.out.print(vocabulary.getContent().getNumberWrong() + " ");
            System.out.print(vocabulary.getContent().getNumberRight() + " ");
            System.out.println();
            vocabulary.next();
        }
    }

    // Vokabel hinzufügen
    public void addVocable(Vocable vocable) {
        vocabulary.append(vocable);
    }

    //Vokabel löschen
    public void deleteVocable(String word) {
        vocabulary.toFirst();
        while (vocabulary.hasAccess()) {
            if (vocabulary.getContent().getWord().equals(word)) {
                vocabulary.remove();
            } else {
                vocabulary.next();
            }
        }
    }

    // TODO: 18.01.2020 diese beiden Methode überprüfen
    //Vokabel suchen
    public Vocable searchVocable(String word) {
        vocabulary.toFirst();
        while (vocabulary.hasAccess()) {
            if (vocabulary.getContent().getWord().equals(word)) {
                return vocabulary.getContent();
            }
            vocabulary.next();
        }
        return null;
    }

    public Vocable searchVocableTranslation(String word) {
        vocabulary.toFirst();
        while (vocabulary.hasAccess()) {
            if (vocabulary.getContent().getTranslation().equals(word)) {
                return vocabulary.getContent();
            }
            vocabulary.next();
        }
        return null;
    }

    // Prüft, ob diese vokabel existiert
    public boolean existVocable(String word) {
        vocabulary.toFirst();
        while (vocabulary.hasAccess()) {
            if (vocabulary.getContent().getWord().equals(word)) {
                return true;
            }
        }
        return false;
    }


    //Alphabetisch sortieren(a;A;...z;Z)
    public void sortVocabularyAlphabetic() {
        List<Vocable> temp = new List<>();
        vocabulary.toFirst();
        while (vocabulary.hasAccess()) {
            temp.append(vocabulary.getContent());
            vocabulary.remove();
        }
        temp.toFirst();
        while (temp.hasAccess()) {
            if (vocabulary.isEmpty()) {
                vocabulary.append(temp.getContent());
            } else {
                vocabulary.toLast();
                if (temp.getContent().getWord().compareToIgnoreCase(vocabulary.getContent().getWord()) > 0) {
                    vocabulary.append(temp.getContent());
                } else {
                    vocabulary.toFirst();
                    while (vocabulary.hasAccess()) {
                        if (temp.getContent().getWord().compareToIgnoreCase(vocabulary.getContent().getWord()) <= 0) {
                            vocabulary.insert(temp.getContent());
                            break;
                        }
                        vocabulary.next();
                    }
                }
            }
            temp.next();
        }
    }
    //nach Fehlern sortieren(5;....;0)
    public void sortVocabularyNumberWrong() {
        List<Vocable> temp = new List<>();
        vocabulary.toFirst();
        while (vocabulary.hasAccess()) {
            temp.append(vocabulary.getContent());
            vocabulary.remove();
        }
        temp.toFirst();
        while (temp.hasAccess()) {
            if (vocabulary.isEmpty()) {
                vocabulary.append(temp.getContent());
            } else {
                vocabulary.toLast();
                if (temp.getContent().getNumberWrong() < vocabulary.getContent().getNumberWrong()) {
                    vocabulary.append(temp.getContent());
                } else {
                    vocabulary.toFirst();
                    while (vocabulary.hasAccess()) {
                        if (temp.getContent().getNumberWrong() >= vocabulary.getContent().getNumberWrong()) {
                            vocabulary.insert(temp.getContent());
                            break;
                        }
                        vocabulary.next();
                    }
                }
            }
            temp.next();
        }
    }
    //nach schwierigkeit sortieren(HARD;...;EASY)
    public void sortVocabularyDifficulty() {
        List<Vocable> temp = new List<>();
        vocabulary.toFirst();
        while (vocabulary.hasAccess()) {
            temp.append(vocabulary.getContent());
            vocabulary.remove();
        }
        temp.toFirst();
        while (temp.hasAccess()) {
            if (vocabulary.isEmpty()) {
                vocabulary.append(temp.getContent());
            } else {
                vocabulary.toLast();
                if (temp.getContent().getDifficulty().getValue() < vocabulary.getContent().getDifficulty().getValue()) {
                    vocabulary.append(temp.getContent());
                } else {
                    vocabulary.toFirst();
                    while (vocabulary.hasAccess()) {
                        if (temp.getContent().getDifficulty().getValue() >= vocabulary.getContent().getDifficulty().getValue()) {
                            vocabulary.insert(temp.getContent());
                            break;
                        }
                        vocabulary.next();
                    }
                }
            }
            temp.next();
        }
    }
    //zufällig sortieren
    public void sortVocabularyRandom() {
        List<Vocable> temp = new List<>();
        int length = 0;
        vocabulary.toFirst();
        while (vocabulary.hasAccess()) {
            temp.append(vocabulary.getContent());
            vocabulary.remove();
            length++;
        }
        while (!temp.isEmpty()) {
        temp.toFirst();
            for (int i = 0; i < new Random().nextInt(length); i++) {
                temp.next();
            }
            if(temp.hasAccess()){
                vocabulary.append(temp.getContent());
                temp.remove();
                length--;
            }

        }
    }
}
