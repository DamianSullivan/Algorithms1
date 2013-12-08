package edu.dsullivan.datastructures.stacks;
import static org.junit.Assert.assertEquals;

import java.util.NoSuchElementException;

import org.junit.Test;

import edu.dsullivan.datastructures.stacks.ArrayStack;
import edu.dsullivan.datastructures.stacks.LinkedStackOfStrings;


public class LinkedStackTest {
  @Test
  public void testLinkedStack() {
    LinkedStackOfStrings stack = new LinkedStackOfStrings();
    stack.push("item1");
    stack.push("item2");
    stack.push("item3");


    assertEquals("item3", stack.pop());
    assertEquals("item2", stack.pop());
    assertEquals("item1", stack.pop());
  }

  @Test(expected = NullPointerException.class)
  public void testPushNullItem() throws Exception {
    new ArrayStack<String>().push(null);
  }

  @Test(expected = NoSuchElementException.class)
  public void testPopEmptyQueue() throws Exception {
    new ArrayStack<String>().pop();
  }
}