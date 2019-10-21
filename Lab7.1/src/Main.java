import lists.List;
import music.MusicTrack;
import music.RockMusicTrack;

import java.util.Arrays;

public class Main {

    /**
     * Main method to work with lists.List.
     *
     * @param args command line arguments
     */
    public static void main(final String[] args) {

        final int len1 = 111;
        final int len2 = 222;
        final int len3 = 333;
        final int len4 = 444;

        MusicTrack first = new MusicTrack("Track1", len1);
        MusicTrack second = new MusicTrack("Track2", len2);
        MusicTrack third = new MusicTrack("Track3", len3);
        MusicTrack fourth = new RockMusicTrack("Track4", len4);

        List<MusicTrack> list = new List<>(Arrays.asList(fourth, first,
                third, fourth, first, second));

        System.out.println(list.toString());

        list.sort((o, t1) -> Integer.compare(t1.getLength(),
                o.getLength()));

        System.out.println(list.toString());


    }
}
