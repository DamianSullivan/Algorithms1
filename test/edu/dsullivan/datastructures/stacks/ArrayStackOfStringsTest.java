package edu.dsullivan.datastructures.stacks;
import static org.junit.Assert.assertEquals;

import java.util.NoSuchElementException;

import org.junit.Test;

import edu.dsullivan.datastructures.stacks.ArrayStackOfStrings;

public class ArrayStackOfStringsTest {
  @Test
  public void testArrayStackOfStrings() {
    ArrayStackOfStrings stack = new ArrayStackOfStrings();
    stack.push("item1");
    stack.push("item2");
    stack.push("item3");


    assertEquals("item3", stack.pop());
    assertEquals("item2", stack.pop());
    assertEquals("item1", stack.pop());
  }

  @Test(expected = NullPointerException.class)
  public void testPushNullItem() throws Exception {
    new ArrayStackOfStrings().push(null);
  }

  @Test(expected = NoSuchElementException.class)
  public void testPopEmptyQueue() throws Exception {
    new ArrayStackOfStrings().pop();
  }
}