package linkedListFunction;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LinkedListTest {
    @Test
    public void testLinkedList_IsEmpty() {
        LinkedList list = new LinkedList();
        assertTrue(list.isEmpty());
    }

    @Test
    public void testLInkedList_IsClear(){
        LinkedList list = new LinkedList();
        assertTrue(list.isEmpty());
    }

    @Test
    public void testLinkedList_IsNotEmpty() {
        LinkedList list = new LinkedList();
        assertFalse(list.isNotEmpty());
    }
    @Test
    public void testLInkedList_IsNotClear(){
        LinkedList list = new LinkedList();
        assertFalse(list.isNotEmpty());
    }
    @Test
    public void testLinkedList_Contains(){
        LinkedList list = new LinkedList();
        list.contain(10);
        assertTrue(list.isEmpty());
    }
    @Test
    public void testLinkedList_Push_IsNotEmptyTest() {
        LinkedList list = new LinkedList();
        list.push(10, 20);
        assertTrue(list.isEmpty());
    }
    @Test
    public void testLinkedList_PopTest(){
        LinkedList list = new LinkedList();
        list.push(10, 20);
        list.pop();
        assertFalse(list. isNotEmpty());
    }
    @Test
    public void testLinkedList_PushAndPopTest(){
        LinkedList list = new LinkedList();
        list.push(10,20);
        list.pop();
    }





}
