package setFunction;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MySetTest {
    @Test
    public void testMYSet_IsEmpty(){
        MySet myset = new MySet();
        assertTrue(myset.isEmpty());
    }

    @Test
    public void testMapping_IsClearTest(){
        MySet myset = new MySet();
        assertTrue(myset.isEmpty());
    }
    @Test
    public void testMySet_IsNotEmpty(){
        MySet myset = new MySet();
        assertFalse(myset.isNotEmpty());
    }
    @Test
    public void testMySet_IsNotClearTest(){
        MySet myset = new MySet();
        assertTrue(myset.isEmpty());
    }
    @Test
    public void testMySet_ContainsTest(){
        MySet myset = new MySet();
        myset.contains(25);
        assertFalse(myset.isNotEmpty());
    }
    @Test
    void testRemove() {
        MySet mySet = new MySet();
        mySet.add(25);
        mySet.add(30);

        assertTrue(mySet.remove(25));
        assertEquals(1, mySet.size());
        assertFalse(mySet.contains(25));
        assertFalse(mySet.remove(99));
    }

    @Test
    public void testRemoveAll(){
        MySet myset  = new MySet();
        myset.add(1);
        myset.add(2);
        myset.add(3);

        MySet other  = new MySet();
        other.add(2);
        other.add(3);

        myset.removeAll(other);
        assertEquals(1, myset.size());
        assertTrue(myset.contains(1));
        assertFalse(myset.contains(2));
        assertFalse(myset.contains(3));
    }
}