/*
 *  Daria Duminska
 *  Copyright (c) 2019 All Rights Reserved.
 *
 */
package music;

/**
 * Class MusicTrack represent general music track with no style predefined.
 */
public class MusicTrack {

    /**
     * Title of the track.
     */
    private String title;
    /**
     * Track's style.
     */
    private String style;
    /**
     * Track's length in seconds.
     */
    private int length;

    /**
     * Default constructor with all required params.
     *
     * @param title  string
     * @param length int
     * @param style  string
     */
    public MusicTrack(final String title,
                      final int length, final String style) {
        if (isValid(title, length, style)) {
            this.title = title;
            this.style = style;
            this.length = length;
        } else {
            throw new IllegalArgumentException("Invalid parameters for the music track.");
        }
    }

    /**
     * Constructor for the case if we are not aware of the style.
     *
     * @param title  string
     * @param length int
     */
    public MusicTrack(final String title, final int length) {
        if (isValid(title, length, "unknown")) {
            this.title = title;
            this.style = "unknown";
            this.length = length;
        } else {
            throw new IllegalArgumentException("Invalid parameters for the music track.");
        }
    }

    /**
     * Checks if passed parameters are possible characteristics of a track.
     *
     * @param title  string with at least one character
     * @param length int more than 1
     * @param style  string with at least one character
     * @return true if all requirements are met
     */
    private boolean isValid(final String title, final int length,
                            final String style) {
        return title.length() > 0 && length > 0 && style.length() > 0;
    }

    /**
     * Getter fot the title.
     *
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Getter fot the length.
     *
     * @return length
     */
    public int getLength() {
        return length;
    }

    /**
     * Getter fot the style.
     *
     * @return style
     */
    public String getStyle() {
        return style;
    }

    /**
     * Checks if objects are equal.
     *
     * @param obj object to compare
     * @return true if title, length and style are equal
     */
    @Override
    public boolean equals(final Object obj) {
        if (obj instanceof MusicTrack) {
            MusicTrack m = (MusicTrack) obj;
            return m.getTitle().equals(this.getTitle())
                    && (m.getLength() == this.getLength()
                    && m.getStyle().equals(this.getStyle()));

        }

        return false;
    }

    /**
     * Hashcode for musicTrack.
     *
     * @return int consisting of three different hashes
     */
    @Override
    public int hashCode() {
        return title.hashCode() + style.hashCode()
                + ((Integer) length).hashCode();
    }

    /**
     * @return title of the track
     */
    @Override
    public String toString() {
        return title + " "  + length + " " + style;
    }
}
