package edu.dsullivan.datastructures.queues;
import static org.junit.Assert.assertEquals;

import java.util.NoSuchElementException;

import org.junit.Test;

import edu.dsullivan.datastructures.queues.LinkedQueueOfStrings;

public class LinkedQueueOfStringsTest {
  @Test
  public void testLinkedQueueOfStrings() {
    LinkedQueueOfStrings queue = new LinkedQueueOfStrings();
    queue.enqueue("one");
    queue.enqueue("two");
    queue.enqueue("three");

    assertEquals("one", queue.dequeue());
    assertEquals("two", queue.dequeue());
    assertEquals("three", queue.dequeue());
  }

  @Test(expected = NullPointerException.class)
  public void testNullItem() throws Exception {
    new LinkedQueueOfStrings().enqueue(null);
  }
  
  @Test(expected = NoSuchElementException.class)
  public void testDequeueEmptyQueue() throws Exception {
    new LinkedQueueOfStrings().dequeue();
  }
}