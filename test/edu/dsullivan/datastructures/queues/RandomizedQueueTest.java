package edu.dsullivan.datastructures.queues;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Test;

import edu.dsullivan.datastructures.queues.RandomizedQueue;

public class RandomizedQueueTest {
  @Test
  public void test8Items() throws Exception {
    RandomizedQueue<String> q = new RandomizedQueue<String>();
    q.enqueue("AA");
    q.enqueue("BB");
    q.enqueue("CC");
    q.enqueue("DD");

    q.enqueue("EE");
    q.enqueue("FF");
    q.enqueue("GG");
    q.enqueue("HH");

    q.dequeue();
    q.dequeue();
    q.dequeue();
    q.dequeue();

    q.dequeue();
    q.dequeue();
    q.dequeue();
    q.dequeue();
  }

  @Test
  public void testIterator() {
    RandomizedQueue<String> q = new RandomizedQueue<String>();
    q.enqueue("1");
    q.enqueue("2");
    q.enqueue("3");

    int i = 0;
    for (String item : q) {
      assertFalse(item == null);
      i++;
    }
    assertEquals(3, i);
  }

  @Test
  public void testTwoIterators() {
    RandomizedQueue<String> q = new RandomizedQueue<String>();
    q.enqueue("1");
    q.enqueue("2");
    Iterator<String> iterator1 = q.iterator();
    Iterator<String> iterator2 = q.iterator();

    assertTrue(iterator1.hasNext());
    iterator1.next();
    assertTrue(iterator1.hasNext());
    iterator1.next();
    assertFalse(iterator1.hasNext());

    assertTrue(iterator2.hasNext());
    iterator2.next();
    assertTrue(iterator2.hasNext());
    iterator2.next();
    assertFalse(iterator2.hasNext());
  }

  @Test(expected = NoSuchElementException.class)
  public void testNextThrowsExceptionEmptyQueue() {
    RandomizedQueue<String> q = new RandomizedQueue<String>();
    Iterator<String> iterator = q.iterator();
    iterator.next();
  }
  
  @Test(expected = NoSuchElementException.class)
  public void testNextThrowsException() {
    RandomizedQueue<String> q = new RandomizedQueue<String>();
    q.enqueue("1");
    Iterator<String> iterator = q.iterator();
    iterator.next();
    iterator.next();
  }
  
  @Test(expected = UnsupportedOperationException.class)
  public void testRemoveThrowsException() {
    RandomizedQueue<String> q = new RandomizedQueue<String>();
    q.enqueue("1");
    Iterator<String> iterator = q.iterator();
    iterator.remove();
  }
}
