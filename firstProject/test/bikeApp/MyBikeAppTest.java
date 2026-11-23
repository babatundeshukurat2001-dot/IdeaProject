package bikeApp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyBikeAppTest {

    @Test
    public void testThatIHaveABike_ItIsOff_ITurnItOn_ItIsOn(){
        MyBikeApp myBikeApp = new MyBikeApp();
        assertFalse(myBikeApp.isPower());

        myBikeApp.isOn();
        assertTrue(myBikeApp.isPower());

    }
    @Test
    public void testThatIHaveABike_ItsOff_ITurnItOn_ItIsOn_ITurnItOff_ItIsOff() {
        MyBikeApp myBikeApp = new MyBikeApp();

        assertFalse(myBikeApp.isPower());

        myBikeApp.isOn();
        assertTrue(myBikeApp.isPower());

        myBikeApp.isOff();
        assertFalse(myBikeApp.isPower());

    }
    @Test
    public void testThatIHaveABike_ItIsOff_ITurnItOn_ItIsOn_IAccelerate_ItsAccelerate(){
        MyBikeApp myBikeApp = new MyBikeApp();

        assertFalse(myBikeApp.isPower());

        myBikeApp.isOn();
        assertTrue(myBikeApp.isPower());

        myBikeApp.accelerate();
        assertEquals(1 , myBikeApp.checkSpeed());
    }

    @Test
    public void testThatIHaveABike_ItIsOff_ITurnItOn_ItIsOn_ItIsInGearOne_ItsAccelerateInIncrementOne(){
        MyBikeApp myBikeApp = new MyBikeApp();

        assertFalse(myBikeApp.isPower());

        myBikeApp.isOn();
        assertTrue(myBikeApp.isPower());

        myBikeApp.bikeSpeed(15);
        assertEquals(15 , myBikeApp.checkSpeed());

        myBikeApp.accelerate();
        assertEquals(16 , myBikeApp.checkSpeed());
    }

    @Test
    public void testThatIHaveABike_ItIsOff_ITurnItOn_ItIsOn_ItIsInGearTwo_ItsAccelerateInIncrementOne(){
        MyBikeApp myBikeApp = new MyBikeApp();

        assertFalse(myBikeApp.isPower());

        myBikeApp.isOn();
        assertTrue(myBikeApp.isPower());

        myBikeApp.bikeSpeed(24);
        assertEquals(24 , myBikeApp.checkSpeed());

        myBikeApp.accelerate();
        assertEquals(26 , myBikeApp.checkSpeed());
    }

    @Test
    public void testThatIHaveABike_ItIsOff_ITurnItOn_ItIsOn_ItIsInGearThree_ItsAccelerateInIncrementOne(){
        MyBikeApp myBikeApp = new MyBikeApp();

        assertFalse(myBikeApp.isPower());

        myBikeApp.isOn();
        assertTrue(myBikeApp.isPower());

        myBikeApp.bikeSpeed(35);
        assertEquals(35 , myBikeApp.checkSpeed());

        myBikeApp.accelerate();
        assertEquals(38 , myBikeApp.checkSpeed());
    }

    @Test
    public void testThatIHaveABike_ItIsOff_ITurnItOn_ItIsOn_ItIsInGearFour_ItsAccelerateInIncrementOne(){
        MyBikeApp myBikeApp = new MyBikeApp();

        assertFalse(myBikeApp.isPower());

        myBikeApp.isOn();
        assertTrue(myBikeApp.isPower());

        myBikeApp.bikeSpeed(44);
        assertEquals(44 , myBikeApp.checkSpeed());

        myBikeApp.accelerate();
        assertEquals(48 , myBikeApp.checkSpeed());
    }

    @Test
    public void testThatIHaveABike_ItIsOff_ITurnItOn_ItIsOn_ItIsInGearOne_ItsDecelerateInDecrementOne(){
        MyBikeApp myBikeApp = new MyBikeApp();

        assertFalse(myBikeApp.isPower());

        myBikeApp.isOn();
        assertTrue(myBikeApp.isPower());

        myBikeApp.bikeSpeed(15);
        assertEquals(15 , myBikeApp.checkSpeed());

        myBikeApp.decelerate();
        assertEquals(14 , myBikeApp.checkSpeed());
    }
    @Test
    public void testThatIHaveABike_ItIsOff_ITurnItOn_ItIsOn_ItIsInGearTwo_ItsDecelerateInDecrementTwo(){
        MyBikeApp myBikeApp = new MyBikeApp();

        assertFalse(myBikeApp.isPower());

        myBikeApp.isOn();
        assertTrue(myBikeApp.isPower());

        myBikeApp.bikeSpeed(24);
        assertEquals(24 , myBikeApp.checkSpeed());

        myBikeApp.decelerate();
        assertEquals(22 , myBikeApp.checkSpeed());
    }
    @Test
    public void testThatIHaveABike_ItIsOff_ITurnItOn_ItIsOn_ItIsInGearThree_ItsDecelerateInDecrementThree(){
        MyBikeApp myBikeApp = new MyBikeApp();

        assertFalse(myBikeApp.isPower());

        myBikeApp.isOn();
        assertTrue(myBikeApp.isPower());

        myBikeApp.bikeSpeed(35);
        assertEquals(35 , myBikeApp.checkSpeed());

        myBikeApp.decelerate();
        assertEquals(32 , myBikeApp.checkSpeed());
    }
    @Test
    public void testThatIHaveABike_ItIsOff_ITurnItOn_ItIsOn_ItIsInGearFour_ItsDecelerateInDecrementFour(){
        MyBikeApp myBikeApp = new MyBikeApp();

        assertFalse(myBikeApp.isPower());

        myBikeApp.isOn();
        assertTrue(myBikeApp.isPower());

        myBikeApp.bikeSpeed(44);
        assertEquals(44 , myBikeApp.checkSpeed());

        myBikeApp.decelerate();
        assertEquals(40 , myBikeApp.checkSpeed());
    }



}














