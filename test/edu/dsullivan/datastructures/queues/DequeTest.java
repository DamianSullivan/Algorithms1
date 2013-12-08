package edu.dsullivan.datastructures.queues;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import org.junit.Test;

import edu.dsullivan.datastructures.queues.Deque;

public class DequeTest {
  @Test
  public void testAddRemoveLast() {
    Deque<String> deque = new Deque<String>();
    deque.addLast("1");
    assertEquals(deque.removeLast(), "1");
  }

  @Test
  public void testFirstFirstLast() {
    Deque<String> deque = new Deque<String>();
    deque.addFirst("1");
    deque.addFirst("2");
    deque.addLast("3");
  }

  @Test
  public void testAddLastThenAddFirst() {
    Deque<String> deque = new Deque<String>();
    deque.addLast("1");
    deque.addLast("2");;
    deque.addFirst("3");
  }

  @Test
  public void testIterator() {
    Deque<String> q = new Deque<String>();
    q.addFirst("1");
    q.addFirst("2");
    q.addFirst("3");

    int i = 0;
    for (String item : q) {
      assertFalse(item == null);
      i++;
    }
    assertEquals(3, i);
  }

  @Test
  public void testTwoIterators() {
    Deque<String> q = new Deque<String>();
    q.addFirst("1");
    q.addFirst("2");
    Iterator<String> iterator1 = q.iterator();
    Iterator<String> iterator2 = q.iterator();

    assertTrue(iterator1.hasNext());
    assertEquals("2", iterator1.next());
    assertTrue(iterator1.hasNext());
    assertEquals("1", iterator1.next());
    assertFalse(iterator1.hasNext());

    assertTrue(iterator2.hasNext());
    assertEquals("2", iterator2.next());
    assertTrue(iterator2.hasNext());
    assertEquals("1", iterator2.next());
    assertFalse(iterator2.hasNext());
  }
}