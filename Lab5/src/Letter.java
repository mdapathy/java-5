/*
 *  Daria Duminska
 *  Copyright (c) 2019 All Rights Reserved.
 *
 */

/**
 * Class represents a letter which is char.
 */
class Letter {

    private char letter;

    Letter(final char ch) {
        this.setCharacter(ch);
    }

    public char getCharacter() {
        return letter;
    }

    public void setCharacter(final char letter) {

        if (isValid(letter)) {
            this.letter = letter;
        } else {
            throw new Error("Your character is not a letter!");
        }
    }

    /**
     * Makes your char a lower case one.
     */
    public Letter setToLowerCase() {
        setCharacter(Character.toLowerCase(letter));
        return this;
    }

    /**
     * Checks if char is a letter.
     * @param x char to be a letter
     * @return true if is a letter
     */
    public static boolean isValid(final char x) {
        return (Character.isLetter(x));
    }

}

