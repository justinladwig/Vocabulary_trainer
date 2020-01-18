package com.willis_chico.vocabulary_trainer;

public enum Difficulty {
    EASY(1),
    NORMAL(2),
    HARD(3);

        private final int value;
        Difficulty(final int newValue) {
            value = newValue;
        }
        public int getValue() { return value; }
    }

