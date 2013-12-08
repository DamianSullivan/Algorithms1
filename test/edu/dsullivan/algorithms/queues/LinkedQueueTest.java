package edu.dsullivan.algorithms.queues;
import static org.junit.Assert.assertEquals;

import java.util.NoSuchElementException;

import org.junit.Test;

public class LinkedQueueTest {
  @Test
  public void testLinkedQueue() {
    LinkedQueue<String> queue = new LinkedQueue<String>();
    queue.enqueue("one");
    queue.enqueue("two");
    queue.enqueue("three");

    assertEquals("one", queue.dequeue());
    assertEquals("two", queue.dequeue());
    assertEquals("three", queue.dequeue());
  }

  @Test(expected = NullPointerException.class)
  public void testNullItem() throws Exception {
    new LinkedQueue<String>().enqueue(null);
  }
  
  @Test(expected = NoSuchElementException.class)
  public void testDequeueEmptyQueue() throws Exception {
    new LinkedQueue<String>().dequeue();
  }
}