/*
 *  Daria Duminska
 *  Copyright (c) 2019 All Rights Reserved.
 *
 */
package music;

/**
 * Class RockMusicTrack represents MusicTracks
 * with rock defined as style.
 */

public class RockMusicTrack extends MusicTrack {
    /**
     * @param title  title of the song
     * @param length length of the thing
     */
    public RockMusicTrack(final String title, final int length) {
        super(title, length, "Rock");
    }
}
