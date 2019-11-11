package music;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MusicAlbumTest {

    static private MusicAlbum musicAlbum;

    static private MusicTrack track1;
    static private MusicTrack track2;
    static private MusicTrack track3;


    @BeforeAll
    static void setup() {
        track1 = new RockMusicTrack("Yesterday", 126);
        track2 = new BluesMusicTrack("Jane Doe", 215);
        track3 = new ClassicalMusicTrack("Undefined", 103);

        musicAlbum = new MusicAlbum("Test");

        musicAlbum.add(track1, track2, track3);

    }


    @Test
    void testCreatingServer() {
        MusicAlbum musicAlbum =  new MusicAlbum("Title");
        assertEquals("Title", musicAlbum.getTitle());
        assertNull(musicAlbum.get(0));
    }

    @Test
    void creatingServerWithEmptyTitleShouldThrowMusicException() {
        MusicException thrown =
                assertThrows(MusicException.class,
                        () -> new MusicAlbum(""));

        assertTrue(thrown.getMessage().contains("Invalid parameters for the music album"));

    }


    @Test
    void addShouldAddTracksInTheProperOrder() {
        MusicTrack tmp1 = new MusicTrack("Name", 400);
        MusicTrack tmp2 = new MusicTrack("Name2", 412);

       MusicAlbum musicAlbumEmpty = new MusicAlbum("Empty");


        musicAlbumEmpty.add(tmp1, tmp2);

        Assertions.assertEquals(musicAlbumEmpty.get(0), tmp1);
        Assertions.assertEquals(musicAlbumEmpty.get(1), tmp2);
    }


    @Test
    void getTotalLengthShouldReturnSumOfAllTracksLengths() {
        Assertions.assertEquals(musicAlbum.getTotalLength(),
                track1.getLength() + track2.getLength()
                        + track3.getLength());

    }

    @Test
    void getTotalLengthStringShouldReturnStringInFormatHoursMinutesSeconds() {
        Assertions.assertEquals(musicAlbum.getTotalLengthString(),
                "0:7:24");
    }

    @Test
    void sortAlbumShouldSortRecordsByStyle() {
        MusicAlbum musicAlbum2 = new MusicAlbum("album");
        musicAlbum2.add(track1, track2, track3);
        musicAlbum2.sortAlbum();

        Assertions.assertEquals(musicAlbum2.get(0), track2);
        Assertions.assertEquals(musicAlbum2.get(1), track3);
        Assertions.assertEquals(musicAlbum2.get(2), track1);
    }


    @Test
    void findTrackShouldReturnAnEmptyArrayIfRequirementsNotMet() {
        List<String> tracks = musicAlbum.findTrack(-5, 5);
        Assertions.assertEquals(tracks.size(), 0);

    }


    @Test
    void findTrackShouldReturnTrackEqualBounds() {
        List<String> tracks = musicAlbum.findTrack(126, 126);
        Assertions.assertEquals(tracks.size(), 1);
        Assertions.assertEquals(tracks.get(0), "Yesterday");
    }

    @Test
    void findTrackShouldReturnMultipleTracks() {
        List<String> tracks = musicAlbum.findTrack(0, 400);
        Assertions.assertEquals(tracks.size(), 3);

    }


}
