
public class Tv {

    private boolean isOn = false;
    private int volume = 10;
    private int channel = 1;
    private boolean isMuted = false;

    public void turnOn() {
        isOn = true;
    }

    public void turnOff() {
        isOn = false;
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

    public void changeChannel(int newChannel) {
        channel = newChannel;
    }

    public void mute() {
        isMuted = true;
    }

    public void unmute() {
        isMuted = false;
    }

    public boolean isOn() {
        return isOn;
    }

    public int getVolume() {
        return volume;
    }

    public int getChannel() {
        return channel;
    }

    public boolean isMuted() {
        return isMuted;
    }
}
