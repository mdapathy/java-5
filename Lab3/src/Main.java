import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        final String input = "a f,A A g! what ;"
              +  " Why no, a g why why. Who No-   ho.   ";
        final  String[] sentences = input.trim().split("[.!?]");

        if (!valid(input, sentences)) {
            System.out.println("We are not capable of proceeding your data!");
            return;

        }

        var answer = new Object() {
            private int amount = 0;
            private List<String> words = new ArrayList<String>();
        };


        Map<String, List<Integer>> wordsInfo
                                = new HashMap<String, List<Integer>>();

        for (int i = 0; i < sentences.length; i++) {

            String n = Arrays.stream(sentences[i].trim().toLowerCase()
                        .split("\\s+|[,;:-]"))
                            .distinct().collect(Collectors.joining(" "));

            // we got a sentence with no duplicate words


            for (String r : n.split("\\s+")) {
                // iterate words and set the amount of occurrences

                if (!wordsInfo.containsKey(r)) {
                   wordsInfo.put(r, new ArrayList<Integer>());
               }
                wordsInfo.get(r).add(i);

            }


        }
        //We're about to identify which words occur the most

        wordsInfo.forEach((key, value) -> {
            System.out.println("Word: " + key
                    + "  Sentences № : " + value.toString());
            if (value.toArray().length > answer.amount) {

                answer.amount = value.toArray().length;
                answer.words.clear();
                answer.words.add(key);

            } else if (value.toArray().length == answer.amount) {
                answer.words.add(key);

            }

        });

        System.out.println("\n" + "Maximum amount "
                + "of sentences: " + answer.amount);
        System.out.println("Words:  ");
        answer.words.forEach(System.out::println);

    }

    private static boolean valid(final String inp, final String[] sent) {

        return !inp.isEmpty() && inp.contains(".") && sent.length >= 1;
    }
}
