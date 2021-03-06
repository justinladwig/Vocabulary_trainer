package com.gittending_software_solutions.vocabulary_trainer;

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

    // Vokabeln in der Konsole ausgeben (nur zu Debug zwecken)
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

    // Vokabel in Deutsch suchen und löschen
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

    //  Vokabel in Englisch suchen un löschen
    public void deleteVocableTranslation(String word) {
        vocabulary.toFirst();
        while (vocabulary.hasAccess()) {
            if (vocabulary.getContent().getTranslation().equals(word)) {
                vocabulary.remove();
            } else {
                vocabulary.next();
            }
        }
    }

    // Vokabel in Englisch suchen
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

    // Vokabel in Deutsch suchen
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


    // Alphabetisch sortieren(a;A;...z;Z)
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

    // nach Fehlern sortieren(5;....;0)
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

    // nach schwierigkeit sortieren(HARD;...;EASY)
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

    // zufällig sortieren
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
            if (temp.hasAccess()) {
                vocabulary.append(temp.getContent());
                temp.remove();
                length--;
            }
        }
    }

    // Liste der Vokabeln geben
    public List<Vocable> getVocabulary() {
        return vocabulary;
    }

    // Anzahl der fehlerhaften eingaben um 1 erhöhen.
    public void addWrong() {
        vocabulary.getContent().setNumberWrong(vocabulary.getContent().getNumberWrong() + 1);
    }

    // Anzahl der richtigen Eingaben um 1 erhöhen
    public void addRight() {
        vocabulary.getContent().setNumberRight(vocabulary.getContent().getNumberRight() + 1);
    }
}
