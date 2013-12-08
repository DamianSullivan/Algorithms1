package edu.coursera.algorithms1.symboltables;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import edu.coursera.algorithms1.symboltables.BinarySearchSymbolTable;

/**
 * Tests the Binary Search implementation of Search Table.
 */
public class BinarySearchSymbolTableTest {
  private BinarySearchSymbolTable<Integer, String> binarySearchTable;
  
  @Before
  public void setup() {
    binarySearchTable = new BinarySearchSymbolTable<Integer, String>(4);
  }

  @Test
  public void testPutAndGet() {
    binarySearchTable.put(1, "one");
    binarySearchTable.put(2, "two");
    binarySearchTable.put(3, "three");
    assertEquals("one", binarySearchTable.get(1));
    assertEquals("two", binarySearchTable.get(2));
    assertEquals("three", binarySearchTable.get(3));
  }
    
  @Test
  public void testDelete() {
    binarySearchTable.put(1, "one");
    binarySearchTable.put(2, "two");
    binarySearchTable.put(3, "three");
    binarySearchTable.put(4, "four");
    binarySearchTable.delete(2);
    binarySearchTable.delete(3);
    binarySearchTable.delete(4);
    assertEquals("one", binarySearchTable.get(1));
    assertNull(binarySearchTable.get(2));
    assertNull(binarySearchTable.get(3));
    assertNull(binarySearchTable.get(4));
    Comparable<Integer>[] keys = binarySearchTable.getKeys();
    assertEquals(2, keys.length);
  }
  
  @Test
  public void testContains() {
    binarySearchTable.put(1, "one");
    binarySearchTable.put(2, "two");
    binarySearchTable.put(3, "three");
    assertTrue(binarySearchTable.contains(1));
    assertTrue(binarySearchTable.contains(2));
    assertTrue(binarySearchTable.contains(3));
    assertFalse(binarySearchTable.contains(4));
  }
  
  
  @Test
  public void testIsEmpty() {
    assertTrue(binarySearchTable.isEmpty());
    binarySearchTable.put(1, "one");
    assertFalse(binarySearchTable.isEmpty());
  }
 
  @Test
  public void testSize() {
    binarySearchTable.put(1, "one");
    binarySearchTable.put(2, "two");
    binarySearchTable.put(3, "three");
    assertEquals(3, binarySearchTable.size());
  }

  @Test
  public void testMin() {
    binarySearchTable.put(1, "one");
    binarySearchTable.put(2, "two");
    binarySearchTable.put(3, "three");
    assertEquals(new Integer(1), binarySearchTable.min());
  }

  @Test
  public void testMax() {
    binarySearchTable.put(1, "one");
    binarySearchTable.put(2, "two");
    binarySearchTable.put(3, "three");
    assertEquals(new Integer(3), binarySearchTable.max());
  }
  
  @Test
  public void testFloor() {
    binarySearchTable.put(1, "one");
    binarySearchTable.put(3, "three");
    binarySearchTable.put(5, "five");
    assertNull(binarySearchTable.floor(0));
    assertEquals(new Integer(1), binarySearchTable.floor(2));
    assertEquals(new Integer(3), binarySearchTable.floor(3));
  }


  @Test
  public void testCeiling() {
    binarySearchTable.put(1, "one");
    binarySearchTable.put(3, "three");
    binarySearchTable.put(5, "five");
    assertNull(binarySearchTable.ceiling(6));
    assertEquals(new Integer(3), binarySearchTable.ceiling(2));
    assertEquals(new Integer(5), binarySearchTable.ceiling(5));
  }
  
  @Test
  public void testRank() {
    binarySearchTable.put(1, "one");
    binarySearchTable.put(3, "three");
    binarySearchTable.put(5, "five");
    assertEquals(0, binarySearchTable.rank(1));
    assertEquals(1, binarySearchTable.rank(3));
    assertEquals(3, binarySearchTable.rank(6));
  }

  @Test
  public void testSelect() {
    binarySearchTable.put(1, "one");
    binarySearchTable.put(3, "three");
    binarySearchTable.put(5, "five");
    assertNull(binarySearchTable.select(-1));
    assertEquals(new Integer(1), binarySearchTable.select(0));
    assertEquals(new Integer(3), binarySearchTable.select(1));
    assertEquals(new Integer(5), binarySearchTable.select(2));
    assertNull(binarySearchTable.select(4));
  }

  @Test
  public void testDeleteMin() {
    binarySearchTable.put(1, "one");
    binarySearchTable.put(3, "three");
    binarySearchTable.put(5, "five");
    binarySearchTable.deleteMin();
    assertNull(binarySearchTable.get(1));
    assertEquals("three", binarySearchTable.get(3));
    assertEquals("five", binarySearchTable.get(5));
  }
  
  @Test
  public void testDeleteMax() {
    binarySearchTable.put(1, "one");
    binarySearchTable.put(3, "three");
    binarySearchTable.put(5, "five");
    binarySearchTable.deleteMax();
    assertNull(binarySearchTable.get(5));
    assertEquals("three", binarySearchTable.get(3));
    assertEquals("one", binarySearchTable.get(1));
  }
  
  @Test
  public void testSizeRange() {
    binarySearchTable.put(1, "one");
    binarySearchTable.put(3, "three");
    binarySearchTable.put(5, "five");
    assertEquals(0, binarySearchTable.size(5, 1));
    assertEquals(3, binarySearchTable.size(1, 5));
    assertEquals(3, binarySearchTable.size(0, 6));
  }
  
  @Test
  public void testKeys() {
    binarySearchTable.put(1, "one");
    binarySearchTable.put(3, "three");
    binarySearchTable.put(5, "five");
    Iterator<Integer> keys = binarySearchTable.keys().iterator();
    assertEquals(new Integer(1), keys.next());
    assertEquals(new Integer(3), keys.next());
    assertEquals(new Integer(5), keys.next());
  }
  
  @Test
  public void testKeysRange() {
    binarySearchTable.put(1, "one");
    binarySearchTable.put(3, "three");
    binarySearchTable.put(5, "five");
    Iterator<Integer> keys = binarySearchTable.keys(1, 3).iterator();
    assertEquals(new Integer(1), keys.next());
    assertEquals(new Integer(3), keys.next());
    assertFalse(keys.hasNext());
  }
}
