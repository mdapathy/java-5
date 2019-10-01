/**
 * Class represents punctuation marks + spaces.
 */
class PunctuationMark extends PartOfSentence {

    private char punctuationMark;

    PunctuationMark(final char ch) {
        this.setCharacter(ch);
    }

    public char getCharacter() {
        return punctuationMark;
    }

    @Override
    public String toString() {
        return String.valueOf(punctuationMark);
    }


    public void setCharacter(final char punctuationMark) {
        if (!Character.isLetter(punctuationMark)) {
            this.punctuationMark = punctuationMark;
        } else {
            throw new Error("Your punctuation mark is a letter!");
        }
    }

    /**
     * Checks if this object can be used to end a sentence.
     */
    public boolean isSentenceDelimiter() {
        String sentenceDelimiter = "!?.";
        return sentenceDelimiter.contains(
                String.valueOf(this.punctuationMark));
    }

}
