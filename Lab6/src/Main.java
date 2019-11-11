import music.MusicAlbum;

public class Main {
    /**
     * Shows MusicAlbum class'methods.
     * @param args command line args
     */
    public static void main(final String[] args) {
        MusicAlbum musicAlbum =  new MusicAlbum("Test album");
        musicAlbum.createAlbum();

        System.out.println(musicAlbum.getTotalLength());
        System.out.println(musicAlbum.getTotalLengthString());

        musicAlbum.printInfo();
        musicAlbum.sortAlbum();
        musicAlbum.printInfo();

        final int upperBound = 303;
        final int lowerBound = 300;

        System.out.println(musicAlbum.findTrack(lowerBound, upperBound));
    }
}
