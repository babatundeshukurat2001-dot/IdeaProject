import org.testng.annotations.Test;

import static org.testng.AssertJUnit.*;

public class TvTest {

    @Test
    public void testThatTvShouldBeOffAtStart_ITurnItOn_ItOn() {
        Tv tv = new Tv();
        assertFalse(tv.isOn());
    }

    @Test
    public void testThatTvShouldTurnOn() {
        Tv tv = new Tv();

        tv.turnOn();

        assertTrue(tv.isOn());
    }

    @Test
    public void testThatTvIsTurnOn_ITunItOff_ItShouldTurnOff() {
        Tv tv = new Tv();

        tv.turnOn();
        tv.turnOff();

        assertFalse(tv.isOn());
    }

    @Test
    public void testThatTVIsOn_VolumeShouldIncrease() {
        Tv tv = new Tv();

        tv.increaseVolume();

        assertEquals(11, tv.getVolume());
    }

    @Test
    public void testThatTvIsOn_VolumeShouldDecrease() {
        Tv tv = new Tv();

        tv.decreaseVolume();

        assertEquals(9, tv.getVolume());
    }

    @Test
    public void testThatTheTvIsOn_IIncreaseTheTo100_VolumeShouldNotExceed100() {
        Tv tv = new Tv();

        for (int count = 0; count < 100; count++) {
            tv.increaseVolume();
        }

        assertEquals(100, tv.getVolume());
    }

    @Test
    public void testThatTvIsOn_IChangeTheChannel_TheChannelShouldChange() {
        Tv tv = new Tv();

        tv.changeChannel(5);

        assertEquals(5, tv.getChannel());
    }

    @Test
    public void testThatTvIsOn_IMutedIT_TvShouldBeMuted() {
        Tv tv = new Tv();

        tv.mute();

        assertTrue(tv.isMuted());
    }

    @Test
    public void testThatTvIsOn_IUnmutedIt_TvShouldBeUnmute() {
        Tv tv = new Tv();

        tv.mute();
        tv.unmute();

        assertFalse(tv.isMuted());
    }
}
