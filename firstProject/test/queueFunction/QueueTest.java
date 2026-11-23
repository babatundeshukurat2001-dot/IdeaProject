package queueFunction;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class QueueTest {

    private Queue queue;

    @BeforeEach
    void setUp() {
        queue = new Queue();
    }

    @Test
    void testNewQueueIsEmpty() {
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());
    }

    @Test
    void testEnqueueDequeue() {
        queue.enqueue(5);
        assertFalse(queue.isEmpty());
        assertEquals(1, queue.size());
        assertEquals(5, queue.dequeue());
        assertTrue(queue.isEmpty());
    }

    @Test
    void testFirst_In_First_Out_Order() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());
        assertEquals(3, queue.dequeue());
        assertTrue(queue.isEmpty());
    }

    @Test
    void testPeek() {
        queue.enqueue(10);
        queue.enqueue(20);

        assertEquals(10, queue.peek());
        assertEquals(2, queue.size());
        assertEquals(10, queue.dequeue());
        assertEquals(20, queue.peek());
    }

    @Test
    void testDequeueEmptyThrowsException() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            queue.dequeue();
        });
        assertEquals("Queue is empty", exception.getMessage());
    }

    @Test
    void testPeekEmptyThrowsException() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            queue.peek();
        });
        assertEquals("Queue is empty", exception.getMessage());
    }

    @Test
    void testSize() {
        assertEquals(0, queue.size());
        queue.enqueue(100);
        assertEquals(1, queue.size());
        queue.enqueue(200);
        assertEquals(2, queue.size());
        queue.dequeue();
        assertEquals(1, queue.size());
    }
}