/*
 *  Daria Duminska
 *  Copyright (c) 2019 All Rights Reserved.
 *
 */

public class Main {

    public static void main(String[] args) {

        Text t = initText();

        Text.Answer answer = t.findMostOftenWordOccurrences();

        System.out.println("Amount: " + answer.getAmount());
        System.out.println("Words : " + answer.getWords().toString());

    }

    private static Text initText() {

        PunctuationMark fs = new PunctuationMark('.');
        PunctuationMark tab = new PunctuationMark(' ');
        PunctuationMark ep = new PunctuationMark('!');
        PunctuationMark cm = new PunctuationMark(',');

        Word ba = new Word("ba");
        Word bc = new Word("because");
        Word ab = new Word("ab");
        Word gazelleCapital = new Word("Gazelle");
        Word gazelle = new Word("gazelle");


        return new Text(new Sentence[]{new Sentence(
                            new PartOfSentence[]{ba, tab, gazelle, ep}),

                new Sentence(new PartOfSentence[]{ab, cm, gazelle, ep}),
                new Sentence(new PartOfSentence[]
                                {gazelleCapital, tab, bc, tab, fs}),
                new Sentence(new PartOfSentence[]{ba, tab, ba, fs})});

    }

}

