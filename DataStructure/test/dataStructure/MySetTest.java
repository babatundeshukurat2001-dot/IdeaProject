
package dataStructure;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MySetTest {

    @Test
    public void testThatSetShouldBeEmpty_WhenNewSetIsCreated() {
        MySet set = new MySet();

        assertTrue(set.isEmpty());
    }

    @Test
    public void testThatSetShouldNotBeEmpty_WhenAnElementIsAdded() {
        MySet set = new MySet();

        set.add(100);

        assertFalse(set.isEmpty());
    }

    @Test
    public void testThatSetShould_HaveSizeOfTwo_WhenTwoNumbersAreAdded() {
        MySet set = new MySet();

        set.add(10);
        set.add(20);

        assertEquals(set.size(), 2);
    }

    @Test
    public void testThatSetShouldNot_IncreaseSize_WhenDuplicateNumberIsAdded() {
        MySet set = new MySet();

        set.add(10);
        set.add(10);

        assertEquals(set.size(), 1);
    }

    @Test
    public void testThatSetShould_ContainNumber_ThatHasBeenAdded() {
        MySet set = new MySet();

        set.add(10);
        set.add(20);

        assertTrue(set.contains(20));
    }

    @Test
    public void testThatSetShould_NotContainNumber_ThatHasNotBeenAdded() {
        MySet set = new MySet();

        set.add(10);

        assertFalse(set.contains(99));
    }

    @Test
    public void testThatSetShould_ReduceSize_WhenAnElementIsRemoved() {
        MySet set = new MySet();

        set.add(10);
        set.add(20);
        set.add(30);

        set.remove(20);

        assertEquals(set.size(), 2);
    }

    @Test
    public void testThatSetShould_ReturnThreeNumbers_WhenThreeUniqueNumbersAreAdded() {
        MySet set = new MySet();

        set.add(1);
        set.add(2);
        set.add(3);

        assertEquals(set.size(), 3);
    }

    @Test
    public void testThatSetShould_BeEmpty_WhenAllElementsAreRemoved() {
        MySet set = new MySet();

        set.add(10);
        set.add(20);

        set.remove(10);
        set.remove(20);

        assertTrue(set.isEmpty());
    }
}
