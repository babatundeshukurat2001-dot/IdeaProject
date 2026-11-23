
package dataStructure;

import org.testng.annotations.Test;

import static org.testng.Assert.assertThrows;
import static org.testng.AssertJUnit.*;

public class MyQueueTest {

    @Test
    public void testThatQueueShouldBeEmpty_WhenNewQueueIsCreated() {
        MyQueue myQueue = new MyQueue();

        assertTrue(myQueue.isEmpty());
    }

    @Test
    public void testThatQueueShouldNotBeEmpty_WhenElementIsAdded() {
        MyQueue myQueue = new MyQueue();

        myQueue.enqueue("John");

        assertFalse(myQueue.isEmpty());
    }

    @Test
    public void testThatQueueShouldIncrease_SizeWhenElementIsAdded() {
        MyQueue myQueue = new MyQueue();

        myQueue.enqueue("John");

        assertEquals(1, myQueue.size());
    }

    @Test
    public void testThatQueueShouldRemove_AndReturnTheFirstElement_WhenDequeued() {
        MyQueue myQueue = new MyQueue();
        myQueue.enqueue("John");
        myQueue.enqueue("Mary");

        assertEquals("John", myQueue.dequeue());
    }

    @Test
    public void testThatQueueShouldReturnFirstElement_WithoutRemovingIt_WhenPeeked() {
        MyQueue myQueue = new MyQueue();

        myQueue.enqueue("John");

        assertEquals("John", myQueue.peek());
        assertEquals(1, myQueue.size());
    }

    @Test
    public void testThatQueueShouldReturnNumberOfElementsInQueue() {
        MyQueue myQueue = new MyQueue();
        myQueue.enqueue("John");
        myQueue.enqueue("Mary");
        myQueue.enqueue("Peter");

        assertEquals(3, myQueue.size());
    }

    @Test
    public void testThatQueueShouldThrowException_WhenRemovingFromEmptyQueue() {
        MyQueue myQueue = new MyQueue();

        assertThrows(RuntimeException.class, () -> myQueue.dequeue());
    }

    @Test
    public void testThatQueueShouldThrowException_WhenViewingFirstElementOfEmptyQueue() {
        MyQueue myQueue = new MyQueue();

        assertThrows(RuntimeException.class, () -> myQueue.peek());
    }
}
