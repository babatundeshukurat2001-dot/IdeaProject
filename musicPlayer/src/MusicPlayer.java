
public class MusicPlayer {

    private boolean playing = false;
    private boolean paused = false;
    private boolean muted = false;
    private int volume = 10;

    public void play() {
        playing = true;
        paused = false;
    }

    public void pause() {
        playing = false;
        paused = true;
    }

    public void stop() {
        playing = false;
        paused = false;
    }

    public void increaseVolume() {
        if (volume < 100) {
            volume++;
        }
    }

    public void decreaseVolume() {
        if (volume > 0) {
            volume--;
        }
    }

    public void mute() {
        muted = true;
    }

    public void unmute() {
        muted = false;
    }

    public boolean isPlaying() {
        return playing;
    }

    public boolean isPaused() {
        return paused;
    }

    public boolean isMuted() {
        return muted;
    }

    public int getVolume() {
        return volume;
    }
}
