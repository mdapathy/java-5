/*
 *  Daria Duminska
 *  Copyright (c) 2019 All Rights Reserved.
 *
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class represents an array of Sentences.
 */
class Text {
    /**
     * Inner class of text, used to send the answer
     * of findMostOftenWordOccurrences method.
     */
    public class Answer {

        /**
         * Amount of occurrences of the most common word.
         */
        private int amount;

        /**
         * List of the most common words.
         */
        private List<Word> words;

        Answer(final int amount, final List<Word> words) {
            this.amount = amount;
            this.words = words;

        }

        public int getAmount() {
            return amount;
        }

        public List<Word> getWords() {
            return words;
        }

        public void setAmount(final int amount) {
            this.amount = amount;
        }

        public void setWords(final List<Word> words) {
            this.words = words;
        }
    }

    /**
     * Array of sentences.
     */
    private Sentence[] text;

    Text(final Sentence[] text) {
        setText(text);

    }


    public void setText(final Sentence[] text) {
        this.text = text;
    }

    public Sentence[] getText() {
        return this.text;
    }


    /**
     * Method to find the most common words.
     * @return Answer object with amount (int) and list of strings
     */
    public Answer findMostOftenWordOccurrences() {

        Map<Word, List<Integer>> wordTextOccurrences = new HashMap<>();

        Answer answer = new Answer(0, new ArrayList<>());

        for (int i = 0; i < this.text.length; i++) {

            Sentence sentenceToParse = text[i];

            for (int j = 0; j < sentenceToParse.getSentence().length; j++) {

                PartOfSentence wordOrPunctuation =
                        sentenceToParse.getSentence()[j];


                /*
                    For each word in sentence either put a new entry in map
                    or just add the number of sentence where it is to the array of ints.
                 */
                if (wordOrPunctuation instanceof Word) {

                   ((Word) wordOrPunctuation).toLowerCase();

                    if (!wordTextOccurrences.containsKey(wordOrPunctuation)) {
                        wordTextOccurrences.put((Word) wordOrPunctuation,
                                new ArrayList<>());


                    }

                    if (!wordTextOccurrences.get(wordOrPunctuation)
                            .contains(i)) {
                        wordTextOccurrences.get(wordOrPunctuation).add(i);

                    }
                }
            }
        }

        //parse the resulting map

        wordTextOccurrences.forEach((key, value) -> {
            if (value.toArray().length > answer.amount) {

                answer.amount = value.toArray().length;
                answer.words.clear();
                answer.words.add(key);


            } else if (value.toArray().length == answer.amount) {
                answer.words.add(key);


            }
        });

        return answer;

    }



}
