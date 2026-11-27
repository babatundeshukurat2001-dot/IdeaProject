package dataStructure;

import org.testng.annotations.Test;
import java.util.Arrays;
import static org.testng.AssertJUnit.*;

public class LinkedListTest {

    @Test
    public void testToAdd_AddsElementToList() {
        LinkedList<String> list = new LinkedList<>();

        assertTrue(list.add("Apple"));
        assertTrue(list.add("Mango"));

        assertEquals(2, list.size());
        assertEquals("Apple", list.get(0));
    }

    @Test
    public void testToAddAll_AddsMultipleElementsToList() {
        LinkedList<String> list = new LinkedList<>();

        list.addAll(Arrays.asList("Apple", "Mango", "Orange"));

        assertEquals(3, list.size());
        assertEquals("Mango", list.get(1));
    }

    @Test
    public void testToClear_RemovesAllElementsFromList() {
        LinkedList<String> list = new LinkedList<>();

        list.addAll(Arrays.asList("Apple", "Mango"));

        list.clear();

        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }


    @Test
    public void testToContains_ReturnsTrueWhenElementExists() {
        LinkedList<String> list = new LinkedList<>();

        list.add("Apple");
        list.add("Mango");

        assertTrue(list.contains("Apple"));
        assertFalse(list.contains("Orange"));
    }

    @Test
    public void testToGet_ReturnsElementAtSpecifiedIndex() {
        LinkedList<String> list = new LinkedList<>();

        list.addAll(Arrays.asList("Apple", "Mango", "Orange"));

        assertEquals("Apple", list.get(0));
        assertEquals("Mango", list.get(1));
        assertEquals("Orange", list.get(2));
    }

    @Test
    public void testToPeek_ReturnsFirstElementWithoutRemovingIt() {
        LinkedList<String> list = new LinkedList<>();

        list.add("Apple");
        list.add("Mango");

        assertEquals("Apple", list.peek());
        assertEquals(2, list.size());
    }

    @Test
    public void testToPop_ReturnsAndRemovesFirstElement() {
        LinkedList<String> list = new LinkedList<>();

        list.add("Apple");
        list.add("Mango");

        assertEquals("Apple", list.pop());

        assertEquals(1, list.size());
        assertEquals("Mango", list.peek());
    }

    @Test
    public void testToRemove_RemovesExistingElementFromList() {
        LinkedList<String> list = new LinkedList<>();

        list.addAll(Arrays.asList("Apple", "Mango", "Orange"));

        assertTrue(list.remove("Mango"));

        assertFalse(list.contains("Mango"));
        assertEquals(2, list.size());

        assertFalse(list.remove("Banana"));
    }
}
