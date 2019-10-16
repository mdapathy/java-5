/*
 *  Daria Duminska
 *  Copyright (c) 2019 All Rights Reserved.
 *
 */
package music;

/**
 * Class BluesMusicTrack represents MusicTracks
 * with blues defined as style.
 */

public class BluesMusicTrack extends MusicTrack {
    /**
     * @param title  title of the song
     * @param length length of the thing
     */
    public BluesMusicTrack(final String title, final int length) {
        super(title, length, "Blues");
    }
}
