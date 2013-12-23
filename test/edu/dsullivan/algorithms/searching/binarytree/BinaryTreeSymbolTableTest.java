package edu.dsullivan.algorithms.searching.binarytree;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests the Binary Tree implementation of a Symbol Table.
 */
public class BinaryTreeSymbolTableTest {
  private BinaryTreeSymbolTable<Integer, String> binaryTreeSearchTable;
  
  @Before
  public void setup() {
    binaryTreeSearchTable = new BinaryTreeSymbolTable<Integer, String>();
  }

  @Test
  public void testPutAndGet() {
    binaryTreeSearchTable.put(1, "one");
    binaryTreeSearchTable.put(2, "two");
    binaryTreeSearchTable.put(3, "three");
    assertEquals("one", binaryTreeSearchTable.get(1));
    assertEquals("two", binaryTreeSearchTable.get(2));
    assertEquals("three", binaryTreeSearchTable.get(3));
  }

  @Test
  public void testDelete() {
    binaryTreeSearchTable.put(1, "one");
    binaryTreeSearchTable.put(2, "two");
    binaryTreeSearchTable.put(3, "three");
    binaryTreeSearchTable.put(4, "four");
    binaryTreeSearchTable.delete(2);
    binaryTreeSearchTable.delete(3);
    binaryTreeSearchTable.delete(4);
    assertEquals("one", binaryTreeSearchTable.get(1));
    assertNull(binaryTreeSearchTable.get(2));
    assertNull(binaryTreeSearchTable.get(3));
    assertNull(binaryTreeSearchTable.get(4));
  }

  /*
  @Test
  public void testContains() {
    binaryTreeSearchTable.put(1, "one");
    binaryTreeSearchTable.put(2, "two");
    binaryTreeSearchTable.put(3, "three");
    assertTrue(binaryTreeSearchTable.contains(1));
    assertTrue(binaryTreeSearchTable.contains(2));
    assertTrue(binaryTreeSearchTable.contains(3));
    assertFalse(binaryTreeSearchTable.contains(4));
  }
  */
  
  @Test
  public void testIsEmpty() {
    assertTrue(binaryTreeSearchTable.isEmpty());
    binaryTreeSearchTable.put(1, "one");
    assertFalse(binaryTreeSearchTable.isEmpty());
  }
 
  @Test
  public void testSize() {
    binaryTreeSearchTable.put(1, "one");
    binaryTreeSearchTable.put(2, "two");
    binaryTreeSearchTable.put(3, "three");
    assertEquals(3, binaryTreeSearchTable.size());
  }

  @Test
  public void testMin() {
    binaryTreeSearchTable.put(1, "one");
    binaryTreeSearchTable.put(2, "two");
    binaryTreeSearchTable.put(3, "three");
    assertEquals(new Integer(1), binaryTreeSearchTable.min());
  }

  @Test
  public void testMax() {
    binaryTreeSearchTable.put(1, "one");
    binaryTreeSearchTable.put(2, "two");
    binaryTreeSearchTable.put(3, "three");
    assertEquals(new Integer(3), binaryTreeSearchTable.max());
  }
  
  @Test
  public void testFloor() {
    binaryTreeSearchTable.put(1, "one");
    binaryTreeSearchTable.put(3, "three");
    binaryTreeSearchTable.put(5, "five");
    assertNull(binaryTreeSearchTable.floor(0));
    assertEquals(new Integer(1), binaryTreeSearchTable.floor(2));
    assertEquals(new Integer(3), binaryTreeSearchTable.floor(3));
  }


  @Test
  public void testCeiling() {
    binaryTreeSearchTable.put(1, "one");
    binaryTreeSearchTable.put(3, "three");
    binaryTreeSearchTable.put(5, "five");
    assertNull(binaryTreeSearchTable.ceiling(6));
    assertEquals(new Integer(3), binaryTreeSearchTable.ceiling(2));
    assertEquals(new Integer(5), binaryTreeSearchTable.ceiling(5));
  }
  
  @Test
  public void testRank() {
    binaryTreeSearchTable.put(1, "one");
    binaryTreeSearchTable.put(3, "three");
    binaryTreeSearchTable.put(5, "five");
    assertEquals(0, binaryTreeSearchTable.rank(1));
    assertEquals(1, binaryTreeSearchTable.rank(3));
    assertEquals(3, binaryTreeSearchTable.rank(6));
  }

  /*
  @Test
  public void testSelect() {
    binaryTreeSearchTable.put(1, "one");
    binaryTreeSearchTable.put(3, "three");
    binaryTreeSearchTable.put(5, "five");
    assertNull(binaryTreeSearchTable.select(-1));
    assertEquals(new Integer(1), binaryTreeSearchTable.select(0));
    assertEquals(new Integer(3), binaryTreeSearchTable.select(1));
    assertEquals(new Integer(5), binaryTreeSearchTable.select(2));
    assertNull(binaryTreeSearchTable.select(4));
  }

  @Test
  public void testDeleteMin() {
    binaryTreeSearchTable.put(1, "one");
    binaryTreeSearchTable.put(3, "three");
    binaryTreeSearchTable.put(5, "five");
    binaryTreeSearchTable.deleteMin();
    assertNull(binaryTreeSearchTable.get(1));
    assertEquals("three", binaryTreeSearchTable.get(3));
    assertEquals("five", binaryTreeSearchTable.get(5));
  }
  
  /*
  @Test
  public void testDeleteMax() {
    binaryTreeSearchTable.put(1, "one");
    binaryTreeSearchTable.put(3, "three");
    binaryTreeSearchTable.put(5, "five");
    binaryTreeSearchTable.deleteMax();
    assertNull(binaryTreeSearchTable.get(5));
    assertEquals("three", binaryTreeSearchTable.get(3));
    assertEquals("one", binaryTreeSearchTable.get(1));
  }
  
  @Test
  public void testSizeRange() {
    binaryTreeSearchTable.put(1, "one");
    binaryTreeSearchTable.put(3, "three");
    binaryTreeSearchTable.put(5, "five");
    assertEquals(0, binaryTreeSearchTable.size(5, 1));
    assertEquals(3, binaryTreeSearchTable.size(1, 5));
    assertEquals(3, binaryTreeSearchTable.size(0, 6));
  }
  
  @Test
  public void testKeys() {
    binaryTreeSearchTable.put(1, "one");
    binaryTreeSearchTable.put(3, "three");
    binaryTreeSearchTable.put(5, "five");
    Iterator<Integer> keys = binaryTreeSearchTable.keys().iterator();
    assertEquals(new Integer(1), keys.next());
    assertEquals(new Integer(3), keys.next());
    assertEquals(new Integer(5), keys.next());
  }
  
  @Test
  public void testKeysRange() {
    binaryTreeSearchTable.put(1, "one");
    binaryTreeSearchTable.put(3, "three");
    binaryTreeSearchTable.put(5, "five");
    Iterator<Integer> keys = binaryTreeSearchTable.keys(1, 3).iterator();
    assertEquals(new Integer(1), keys.next());
    assertEquals(new Integer(3), keys.next());
    assertFalse(keys.hasNext());
  }
  */
}
