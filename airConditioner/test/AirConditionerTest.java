import org.testng.annotations.Test;

import static org.testng.AssertJUnit.*;

public class AirConditionerTest {

    @Test
    public void testThatIHaveAnAirConditioner_ItsOff_ITurnItOn_ItIsOn() {
        AirConditioner airConditioner = new AirConditioner();

        assertFalse(airConditioner.checkPowerStatus());

        airConditioner.turnOn();
        assertTrue(airConditioner.checkPowerStatus());

    }
    @Test
    public void testThatIHaveAnAirConditioner_ItsOff_ITurnItOn_ItIsOn_ITurnItOff_ItISOff() {
        AirConditioner airConditioner = new AirConditioner();

        assertFalse(airConditioner.checkPowerStatus());

        airConditioner.turnOn();
        assertTrue(airConditioner.checkPowerStatus());

        airConditioner.turnOff();
        assertFalse(airConditioner.checkPowerStatus());

    }
    @Test
    public void testThatIHaveAnAirConditioner_ItsOff_ITurnItOn_ItIsOn_IIncreaseTemperature_ItIncreases() {
        AirConditioner airConditioner = new AirConditioner();

        assertFalse(airConditioner.checkPowerStatus());

        airConditioner.turnOn();
        assertTrue(airConditioner.checkPowerStatus());

        airConditioner.increaseTemperature(6);
        assertEquals(22 , airConditioner.checkTemperature());

    }
    @Test
    public void testThatIHaveAnAirConditioner_ItsOff_ITurnItOn_ItIsOn_IIncreaseTemperature_ItIncreases_IDecreaseTemperature_ItDecreases() {
        AirConditioner airConditioner = new AirConditioner();

        assertFalse(airConditioner.checkPowerStatus());

        airConditioner.turnOn();
        assertTrue(airConditioner.checkPowerStatus());

        airConditioner.increaseTemperature(12);
        assertEquals(28 , airConditioner.checkTemperature());

        airConditioner.decreaseTemperature(4);
        assertEquals(24 , airConditioner.checkTemperature());

    }
    @Test
    public void testThatIHaveAnAirConditioner_ItsOff_ITurnItOn_ItIsOn_IIncreaseTemperatureBeyond30_ItStill30() {
        AirConditioner airConditioner = new AirConditioner();

        assertFalse(airConditioner.checkPowerStatus());

        airConditioner.turnOn();
        assertTrue(airConditioner.checkPowerStatus());

        airConditioner.increaseTemperature(39);
        assertEquals(30 , airConditioner.checkTemperature());

    }

    @Test
    public void testThatIHaveAnAirConditioner_ItsOff_ITurnItOn_ItIsOn_IIncreaseTemperature_ItIncreases_IDecreaseTemperatureBelow16_ItStill16() {
        AirConditioner airConditioner = new AirConditioner();

        assertFalse(airConditioner.checkPowerStatus());

        airConditioner.turnOn();
        assertTrue(airConditioner.checkPowerStatus());

        airConditioner.increaseTemperature(12);
        assertEquals(28 , airConditioner.checkTemperature());

        airConditioner.decreaseTemperature(29);
        assertEquals(16 , airConditioner.checkTemperature());

    }

}
