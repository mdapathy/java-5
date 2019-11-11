/*
 *  Daria Duminska
 *  Copyright (c) 2019 All Rights Reserved.
 *
 */
package music;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Class representing an array of MusicTracks.
 */
public class MusicAlbum {

    /**
     * Title of the album.
     */
    private String title;

    /**
     * Maximum amount of objects in array.
     */
    private int maxAmountOfRecords = 14;

    /**
     * An array of music tracks.
     */
    private MusicTrack[] musicTracks;
    /**
     * Position in an array to write to.
     */
    private int counter;

    /**
     * Constructor.
     * @param title string
     */
    public MusicAlbum(final String title) {
        if (title.length() > 1) {
            this.title = title;
            this.musicTracks = new MusicTrack[maxAmountOfRecords];
            this.counter = 0;
        } else {
            throw new Error("Invalid parameters for the music album.");
        }

    }


    /**
     * Getter fot the title.
     * @return string title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Add a record or multiple records to an album.
     * @param musicTrack musictracks
     */
    public void add(final MusicTrack... musicTrack) {
        for (MusicTrack arg : musicTrack) {
            if (counter > maxAmountOfRecords) {
                break;
            }
            musicTracks[counter] = arg;
            counter++;
        }
    }

    /**
     * Get the length of album in seconds.
     * @return int
     */
    public int getTotalLength() {
        int result = 0;
        for (MusicTrack musicTrack : musicTracks) {
            if (musicTrack != null) {
                result += musicTrack.getLength();
            }
        }

        return result;
    }

    /**
     * Get the length of album.
     * @return string in format hours:minutes:seconds
     */
    public String getTotalLengthString() {
        final int hour = 3600;
        final int minute = 60;
        String delimiter = ":";
        String result = "";
        final int res = getTotalLength();

        result += (res / hour) + delimiter; //hours
        result += res % hour / minute + delimiter; //minutes
        result += res % hour % minute;

        return result;


    }

    /**
     * Sort an array based on the style.
     */
    public void sortAlbum() {
        MusicTrack[] buffer = new MusicTrack[counter];
        for (int i = 0; i < counter; i++) {
            if (musicTracks[i] != null) {
                buffer[i] = musicTracks[i];
            }
        }
        Arrays.sort(buffer, Comparator.comparing(MusicTrack::getStyle));
        musicTracks = buffer;

    }

    /**
     * Print the info about album.
     */
    public void printInfo() {

        System.out.println("----------Album----------");
        System.out.println(title);
        for (MusicTrack musicTrack : musicTracks) {
            if (musicTrack != null) {
                System.out.println("Name - " + musicTrack.getTitle()
                        + "\tLength - " + musicTrack.getLength()
                        + "\t Style - " + musicTrack.getStyle());
            }
        }
        System.out.println("----------------------");
    }


    /**
     * Fill the album with various predefined tracks.
     */
    public void createAlbum() {
        add(new RockMusicTrack("Yesterday", 126),
                new BluesMusicTrack("Jane Done", 215),
                new MusicTrack("Undefined", 103),
                new ClassicalMusicTrack("Beethoven's", 303),
                new RockMusicTrack("Rock Record ", 243));
    }

    /**
     * Find track(s) with length in between bounds.
     * @param lowerBound int
     * @param upperBound int
     * @return MusicTracks list
     */
    public List<String> findTrack(final int lowerBound, final int upperBound) {

         List<String> answer = new ArrayList<>();

        for (MusicTrack musicTrack : musicTracks) {
            if (musicTrack != null
                    && musicTrack.getLength() >= lowerBound
                    && musicTrack.getLength() <= upperBound) {
                answer.add(musicTrack.getTitle());
            }
        }

        return answer;

    }



}
