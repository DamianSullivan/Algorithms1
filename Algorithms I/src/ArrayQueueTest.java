import static org.junit.Assert.assertEquals;

import java.util.NoSuchElementException;

import org.junit.Test;

public class ArrayQueueTest {
  @Test
  public void testArrayQueue() {
    ArrayQueue<String> queue = new ArrayQueue<String>();
    queue.enqueue("one");
    queue.enqueue("two");
    queue.enqueue("three");

    assertEquals("one", queue.dequeue());
    assertEquals("two", queue.dequeue());
    assertEquals("three", queue.dequeue());
  }

  @Test(expected = NullPointerException.class)
  public void testNullItem() throws Exception {
    new ArrayQueue<String>().enqueue(null);
  }

  @Test(expected = NoSuchElementException.class)
  public void testDequeueEmptyQueue() throws Exception {
    new ArrayQueue<String>().dequeue();
  }
}