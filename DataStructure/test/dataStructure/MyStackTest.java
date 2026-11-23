
package dataStructure;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.*;

public class MyStackTest {

    @Test
    public void testThatStackShouldBeEmpty_WhenANewStackIsCreated() {
        MyStack myStack = new MyStack();

        assertTrue(myStack.isEmpty());
    }

    @Test
    public void testThatStackShouldNotBeEmpty_WhenAnElementIsAdded() {
        MyStack myStack = new MyStack();

        myStack.push("sugar");

        assertFalse(myStack.isEmpty());
    }

    @Test
    public void testThatStack_ShouldMakeAddedElementAvailableAtTheTop() {
        MyStack myStack = new MyStack();

        myStack.push("sugar");

        assertEquals("sugar", myStack.peek());
    }

    @Test
    public void testThatStack_ShouldRemove_AndReturnTopElement_WhenPopped() {
        MyStack myStack = new MyStack();

        myStack.push("sugar");

        String result = myStack.pop();

        assertEquals("sugar", result);
        assertTrue(myStack.isEmpty());
    }

    @Test
    public void testThatStack_ShouldKeepTopElement_WhenItIsViewed() {
        MyStack myStack = new MyStack();

        myStack.push("sugar");

        assertEquals("sugar", myStack.peek());
        assertFalse(myStack.isEmpty());
    }

    @Test
    public void testThatStack_ShouldBeFull_WhenMaximumCapacityIsReached() {
        MyStack myStack = new MyStack(3);

        myStack.push("sugar");
        myStack.push("salt");
        myStack.push("honey");

        assertTrue(myStack.isFull());
    }

    @Test
    public void testThatStack_ShouldNotBeFull_WhenCapacityIsNotReached() {
        MyStack myStack = new MyStack(3);

        myStack.push("sugar");

        assertFalse(myStack.isFull());
    }

    @Test
    public void testThatStack_ShouldRemoveElements_InReverseOrderOfAddition() {
        MyStack myStack = new MyStack();

        myStack.push("sugar");
        myStack.push("honey");

        assertEquals("honey", myStack.pop());
        assertEquals("sugar", myStack.pop());
    }

    @Test
    public void testThatStack_ShouldReturnMostRecentlyAddedElementWhenViewed() {
        MyStack myStack = new MyStack();

        myStack.push("sugar");
        myStack.push("honey");

        assertEquals("honey", myStack.peek());
    }

    @Test
    public void testThatStack_ShouldReturnNumberOfElementsCurrentlyInStack() {
        MyStack myStack = new MyStack();

        myStack.push("sugar");
        myStack.push("honey");

        assertEquals(2, myStack.size());
    }
}
