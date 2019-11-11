package music;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class MusicTrackTest {


    @Test
    void testCreatingTrackWithThreeParameters() {
        final MusicTrack track = new MusicTrack("Title", 545, "Rock");

        assertEquals("Title", track.getTitle());
        assertEquals(545, track.getLength());
        assertEquals("Rock", track.getStyle());

    }

    @Test
    void testCreatingTrackWithTwoParameters() {
        final MusicTrack track = new MusicTrack("Title", 545);

        assertEquals("Title", track.getTitle());
        assertEquals(545, track.getLength());
        assertEquals("unknown", track.getStyle());
    }


    @Test
    void testCreatingInheritedClasses() {

        final MusicTrack track1 = new RockMusicTrack("R", 367);
        final MusicTrack track2 = new BluesMusicTrack("Bl", 345);
        final MusicTrack track3 = new ClassicalMusicTrack("Cl", 565);

        assertEquals("R", track1.getTitle());
        assertEquals("Bl", track2.getTitle());
        assertEquals("Cl", track3.getTitle());


        assertEquals(367, track1.getLength());
        assertEquals(345, track2.getLength());
        assertEquals(565, track3.getLength());

        assertEquals("Rock", track1.getStyle());
        assertEquals("Blues", track2.getStyle());
        assertEquals("Classical", track3.getStyle());


    }

    @Test
    void CreatingTrackWithZeroLengthShouldThrowException() {
        MusicException thrown =
                assertThrows(MusicException.class,
                        () -> new MusicTrack("Title", 0, "Style"),
                        "Expected new MusicTrack(\"Title\", 0), to throw, but it didn't");

        assertTrue(thrown.getMessage().contains("Invalid parameters"));

    }

    @Test
    void CreatingTrackWithNegativeLengthShouldThrowException() {

        MusicException thrown =
                assertThrows(MusicException.class,
                        () -> new MusicTrack("Title", -5, "Style"),
                        "Expected new MusicTrack(\"Title\", -5), to throw, but it didn't");

        assertTrue(thrown.getMessage().contains("Invalid parameters"));

    }

    @Test
    void equalsShouldReturnTrueIfObjectsAreIdentical() {
        MusicTrack track1 = new MusicTrack("Title", 367);
        MusicTrack track2 = new MusicTrack("Title", 367);
        assertEquals(track1, track2);

    }

    @Test
    void hashCodeOfObjectShouldReturnTheSameValueEachTime() {
        MusicTrack track1 = new MusicTrack("Title", 367);
        assertEquals(track1.hashCode(), track1.hashCode());
    }


    @Test
    void hashCodeOfIdenticalObjectsShouldReturnIdenticalValues() {
        MusicTrack track1 = new MusicTrack("Title", 367, "Style1");
        MusicTrack track2 = new MusicTrack("Title", 367, "Style1");

        assertEquals(track1.hashCode(), track2.hashCode());
    }


    @Test
    void toStringShouldReturnStringOfAllValues() {
        MusicTrack track1 = new MusicTrack("Title", 367, "Style1");
        MusicTrack track2 = new RockMusicTrack("Title", 367);
        MusicTrack track3 = new BluesMusicTrack("Title", 367);
        MusicTrack track4 = new ClassicalMusicTrack("Title", 367);

        assertEquals(track1.toString(), "Title 367 Style1");
        assertEquals(track2.toString(), "Title 367 Rock");
        assertEquals(track3.toString(), "Title 367 Blues");
        assertEquals(track4.toString(), "Title 367 Classical");


    }


}