package mapFunction;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MappingTest{
    @Test
    public void testMapping_IsEmptyTest(){
        Mapping mapping = new Mapping();
        assertTrue(mapping.isEmpty());
    }
    @Test
    public void testMapping_IsClearTest(){
        Mapping mapping = new Mapping();
        assertTrue(mapping.isEmpty());
    }
    @Test
    public void testMapping_IsNotEmptyTest(){
        Mapping mapping = new Mapping();
        assertFalse(mapping.isNotEmpty);
    }
    @Test
    public void testMapping_ContainsTest(){
        Mapping mapping = new Mapping();
        mapping.contains(25);
        assertFalse(mapping.isNotEmpty);
    }
    @Test
    public void testMapping_IsNotEmptyAndContainsTest(){
        Mapping mapping = new Mapping();
        mapping.contains(0);
        assertFalse(mapping.isNotEmpty);
    }
    @Test
    public void testMapping_ContainsAnd_ReplaceTest() {
        Mapping mapping = new Mapping();
        mapping.put(25, 5);
        assertTrue(mapping.contains(25));
        int oldValue = mapping.replace(25, 10);
        assertEquals(5, oldValue);
        assertTrue(mapping.contains(25));
    }
    @Test
    public void testMapping_Contains_And_RemoveTest(){
        Mapping mapping = new Mapping();
        mapping.put(25, 5);
        assertTrue(mapping.contains(25));
        Object remove = mapping.remove;
        assertEquals(null, remove);
        assertTrue(mapping.contains(25));
    }

}
