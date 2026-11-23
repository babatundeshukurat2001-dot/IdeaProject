

public class MusicPlayerTest {

    @Test
    public void musicShouldStartPlaying() {
        MusicPlayer player = new MusicPlayer();

        player.play();

        assertTrue(player.isPlaying());
    }

    @Test
    public void musicShouldPause() {
        MusicPlayer player = new MusicPlayer();

        player.play();
        player.pause();

        assertTrue(player.isPaused());
    }

    @Test
    public void musicShouldStop() {
        MusicPlayer player = new MusicPlayer();

        player.play();
        player.stop();

        assertFalse(player.isPlaying());
    }

    @Test
    public void volumeShouldIncrease() {
        MusicPlayer player = new MusicPlayer();

        player.increaseVolume();

        assertEquals(11, player.getVolume());
    }

    @Test
    public void volumeShouldDecrease() {
        MusicPlayer player = new MusicPlayer();

        player.decreaseVolume();

        assertEquals(9, player.getVolume());
    }

    @Test
    public void musicShouldBeMuted() {
        MusicPlayer player = new MusicPlayer();

        player.mute();

        assertTrue(player.isMuted());
    }

    @Test
    public void musicShouldBeUnmuted() {
        MusicPlayer player = new MusicPlayer();

        player.mute();
        player.unmute();

        assertFalse(player.isMuted());
    }
}
