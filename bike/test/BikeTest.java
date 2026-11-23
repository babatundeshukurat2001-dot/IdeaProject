import org.testng.annotations.Test;

import static org.testng.AssertJUnit.*;

public class BikeTest {

    @Test
    public void testThatIHaveABike_ItIsOff_ITurnItOn_ItIsOn(){
        Bike bike = new Bike();
        assertFalse(bike.isPower());

        bike.isOn();
        assertTrue(bike.isPower());

    }
    @Test
    public void testThatIHaveABike_ItsOff_ITurnItOn_ItIsOn_ITurnItOff_ItIsOff() {
        Bike bike = new Bike();

        assertFalse(bike.isPower());

        bike.isOn();
        assertTrue(bike.isPower());

        bike.isOff();
        assertFalse(bike.isPower());

    }
    @Test
    public void testThatIHaveABike_ItIsOff_ITurnItOn_ItIsOn_IAccelerate_ItsAccelerate(){
        Bike bike = new Bike();

        assertFalse(bike.isPower());

        bike.isOn();
        assertTrue(bike.isPower());

        bike.accelerate();
        assertEquals(1 , bike.checkSpeed());
    }

    @Test
    public void testThatIHaveABike_ItIsOff_ITurnItOn_ItIsOn_ItIsInGearOne_ItsAccelerateInIncrementOne(){
        Bike bike= new Bike();

        assertFalse(bike.isPower());

        bike.isOn();
        assertTrue(bike.isPower());

        bike.bikeSpeed(15);
        assertEquals(15 , bike.checkSpeed());

        bike.accelerate();
        assertEquals(16 , bike.checkSpeed());
    }

    @Test
    public void testThatIHaveABike_ItIsOff_ITurnItOn_ItIsOn_ItIsInGearTwo_ItsAccelerateInIncrementOne(){
        Bike bike = new Bike();

        assertFalse(bike.isPower());

        bike.isOn();
        assertTrue(bike.isPower());

        bike.bikeSpeed(24);
        assertEquals(24 , bike.checkSpeed());

        bike.accelerate();
        assertEquals(26 , bike.checkSpeed());
    }

    @Test
    public void testThatIHaveABike_ItIsOff_ITurnItOn_ItIsOn_ItIsInGearThree_ItsAccelerateInIncrementOne(){
        Bike bike = new Bike();

        assertFalse(bike.isPower());

        bike.isOn();
        assertTrue(bike.isPower());

        bike.bikeSpeed(35);
        assertEquals(35 , bike.checkSpeed());

        bike.accelerate();
        assertEquals(38 , bike.checkSpeed());
    }

    @Test
    public void testThatIHaveABike_ItIsOff_ITurnItOn_ItIsOn_ItIsInGearFour_ItsAccelerateInIncrementOne(){
        Bike bike = new Bike();

        assertFalse(bike.isPower());

        bike.isOn();
        assertTrue(bike.isPower());

        bike.bikeSpeed(44);
        assertEquals(44 , bike.checkSpeed());

        bike.accelerate();
        assertEquals(48 , bike.checkSpeed());
    }

    @Test
    public void testThatIHaveABike_ItIsOff_ITurnItOn_ItIsOn_ItIsInGearOne_ItsDecelerateInDecrementOne(){
        Bike bike = new Bike();

        assertFalse(bike.isPower());

        bike.isOn();
        assertTrue(bike.isPower());

        bike.bikeSpeed(15);
        assertEquals(15 , bike.checkSpeed());

        bike.decelerate();
        assertEquals(14 , bike.checkSpeed());
    }
    @Test
    public void testThatIHaveABike_ItIsOff_ITurnItOn_ItIsOn_ItIsInGearTwo_ItsDecelerateInDecrementTwo(){
        Bike bike= new Bike();

        assertFalse(bike.isPower());

        bike.isOn();
        assertTrue(bike.isPower());

        bike.bikeSpeed(24);
        assertEquals(24 , bike.checkSpeed());

        bike.decelerate();
        assertEquals(22 , bike.checkSpeed());
    }
    @Test
    public void testThatIHaveABike_ItIsOff_ITurnItOn_ItIsOn_ItIsInGearThree_ItsDecelerateInDecrementThree(){
        Bike bike = new Bike();

        assertFalse(bike.isPower());

        bike.isOn();
        assertTrue(bike.isPower());

        bike.bikeSpeed(35);
        assertEquals(35 , bike.checkSpeed());

        bike.decelerate();
        assertEquals(32 , bike.checkSpeed());
    }
    @Test
    public void testThatIHaveABike_ItIsOff_ITurnItOn_ItIsOn_ItIsInGearFour_ItsDecelerateInDecrementFour(){
        Bike bike = new Bike();

        assertFalse(bike.isPower());

        bike.isOn();
        assertTrue(bike.isPower());

        bike.bikeSpeed(44);
        assertEquals(44 , bike.checkSpeed());

        bike.decelerate();
        assertEquals(40 , bike.checkSpeed());
    }

}
