import music.*;

public class Main {
    /**
     * Shows MusicAlbum class'methods.
     *
     * @param args command line args
     */
    public static void main(final String[] args) {

        final int upperBound = 303;
        final int lowerBound = 300;

        MusicAlbum musicAlbum = new MusicAlbum("Test album");
        musicAlbum.add(new RockMusicTrack("Yesterday", 126),
                new BluesMusicTrack("Jane Done", 215),
                new MusicTrack("Undefined", 103),
                new ClassicalMusicTrack("Beethoven's", 303),
                new RockMusicTrack("Rock Record ", 243));

        System.out.println(musicAlbum.getTotalLength());
        System.out.println(musicAlbum.getTotalLengthString());

        musicAlbum.printInfo();
        musicAlbum.sortAlbum();
        musicAlbum.printInfo();

        System.out.println(musicAlbum.findTrack(lowerBound, upperBound));
    }
}
