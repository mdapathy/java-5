/*
 *  Daria Duminska
 *  Copyright (c) 2019 All Rights Reserved.
 *
 */
package music;

/**
 * Class ClassicalMusicTrack represents MusicTracks
 * with classical defined as style.
 */
public class ClassicalMusicTrack extends MusicTrack {
    /**
     * @param title  title of the song
     * @param length length of the thing
     */
    public ClassicalMusicTrack(final String title, final int length) {
        super(title, length, "Classical");
    }
}
