/*
 *  Daria Duminska
 *  Copyright (c) 2019 All Rights Reserved.
 *
 */

/**
 * Class sentence represents an array of words/punctuation marks.
 */
class Sentence {

    /**
     * An array of  words/punctuation marks.
     */
    private PartOfSentence[] sentence;

    Sentence(final PartOfSentence[] sentence) {
        setSentence(sentence);
    }

    public void setSentence(final PartOfSentence[] sentence) {
        if (isValid(sentence)) {
            this.sentence = sentence;
        } else {
            throw new Error("Your array doesn't fit the features.");
        }
    }

    public PartOfSentence[] getSentence() {
        return this.sentence;
    }


    /**
     * Check if an array of PartOfSentence can be represented as a sentence.
     * It has to meet the requirements:
     *  - Consists of at least 2 objects (aka punctuation mark and a word)
     *  - The last object is a sentence delimiter
     *  - has at least a word in it
     *  - starts with a word
     *  - doesn't have a streak of words
     *  - doesn't have sentence delimiters in the middle
     *
     * @param sentence to check if it can be presented as sentence
     * @return true if it can be
     */
    public boolean isValid(final PartOfSentence[] sentence) {
        if (sentence.length > 1
                && sentence[sentence.length - 1] instanceof PunctuationMark
                && ((PunctuationMark) sentence[sentence.length - 1])
                .isSentenceDelimiter()
                && hasWords(sentence) && sentence[0] instanceof Word) {

            PartOfSentence prev = sentence[0];

            for (int i = 0; i < sentence.length - 2;) {

                PartOfSentence curr = sentence[++i];

                if (prev instanceof Word && curr instanceof Word
                        || prev instanceof PunctuationMark
                        && ((PunctuationMark) prev).isSentenceDelimiter()) {
                    return false;
                }

                prev = curr;

            }

            return true;

        }

        return false;
    }

    /**
     * Check if an array has at least one word in it.
     * @param sentence array of words/punctuation marks
     * @return true if it has words
     */
    private boolean hasWords(final PartOfSentence[] sentence) {
        for (int i = 0; i < sentence.length; i++) {

            if (sentence[i] instanceof Word) {
                return true;
            }

        }

        return false;
    }
}

