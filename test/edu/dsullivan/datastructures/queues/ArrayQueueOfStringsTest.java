package edu.dsullivan.datastructures.queues;
import static org.junit.Assert.assertEquals;

import java.util.NoSuchElementException;

import org.junit.Test;

import edu.dsullivan.datastructures.queues.ArrayQueueOfStrings;
//
public class ArrayQueueOfStringsTest {
  @Test
  public void testArrayQueueOfStrings() {
    ArrayQueueOfStrings queue = new ArrayQueueOfStrings();
    queue.enqueue("one");
    queue.enqueue("two");
    queue.enqueue("three");

    assertEquals("one", queue.dequeue());
    assertEquals("two", queue.dequeue());
    assertEquals("three", queue.dequeue());
  }

  @Test(expected = NullPointerException.class)
  public void testNullItem() throws Exception {
    new ArrayQueueOfStrings().enqueue(null);
  }

  @Test(expected = NoSuchElementException.class)
  public void testDequeueEmptyQueue() throws Exception {
    new ArrayQueueOfStrings().dequeue();
  }
}