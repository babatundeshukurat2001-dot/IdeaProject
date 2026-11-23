package stack;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MyStackTest {

    @Test
    public void testMyStack_IsEmptyTest(){
        MyStack mystack = new MyStack();
        assertTrue(mystack.isEmpty());
    }

    @Test
    public void testMyStack_Push_IsNotEmptyTest() {
        MyStack mystack = new MyStack();
        mystack.push("Ope");
        assertFalse(mystack.isEmpty());
    }
    @Test
    public void testMyStack_PushAndPopTest() {
        MyStack mystack = new MyStack();
        mystack.push("Ope");
        String result = mystack.pop();

        assertEquals("Ope", result);
    }
    @Test
    public void testMyStack_PeekTest() {
        MyStack mystack = new MyStack();
        mystack.push("Ope");

        assertEquals("Ope", mystack.peek());
    }
}
