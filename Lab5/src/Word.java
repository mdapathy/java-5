/*
 *  Daria Duminska
 *  Copyright (c) 2019 All Rights Reserved.
 *
 */

/**
 * Class Word represents a PartOfSentence and is an array of Letters.
 *
 * @version 1.0 30 Sept 2019
 * @author Daria Duminska
 */

class Word extends PartOfSentence {
    /**
     * Array of letters representing a word.
     */
    private Letter[] word;

    private final int hashParam1 = 7;
    private final int hashParam2 = 31;

    /**
     * Default constructor.
     * @param word array of letters
     */
    Word(final Letter[] word) {

        this.word = word;
    }

    /**
     * Constructor using string.
     * @param x string to ptr
     * @throws new Error if the string has non-letters.
     */
    Word(final String x) {

        if (!x.isEmpty()) {
            word = new Letter[x.length()];
            for (int i = 0; i < x.length(); i++) {

                if (!Letter.isValid(x.charAt(i))) {
                    throw new Error("Your string cannot"
                            + " be represented as a word.");
                }

                word[i] = new Letter(x.charAt(i));

            }

        } else {
            throw new Error("Your string cannot be represented as a word.");
        }

    }

    public void setWord(final Letter[] word) {
        this.word = word;
    }

    public Letter[] getWord() {
        return this.word;
    }

    public Word toLowerCase() {

        for (int i = 0; i < word.length; i++) {
            this.word[i].setToLowerCase();

        }

        return this;

    }

    @Override
    public String toString() {
        String sb = new String("");
        for (int i = 0; i < word.length; i++) {
            sb += new Character(word[i].getCharacter());
        }

        return sb;
    }

    /**
     * Overwritten functions for hash map.
     * @param o object to compare via -map
     * @return true if word turn into the same string
     */
    @Override
    public boolean equals(final Object o) {
       if (o.toString().equals(this.toString())) {
           return true;
       }
       return false;
    }

    @Override
    public int hashCode() {
        int hash = hashParam1;
        for (int i = 0; i < this.toString().length(); i++) {
            hash = hash * hashParam2  + this.toString().charAt(i);
        }
        return hash;
    }

}
