package edu.coursera.algorithms1.searchtables;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

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
    
    //System.out.printf("KEYS: %s", binarySearchTable.getKeys().length);
    Comparable<Integer>[] keys = binarySearchTable.getKeys();
    assertEquals(2, keys.length);
  }
  
  /*
  @Test
  public void testContains() {
    fail("Not yet implemented");
  }
  
  @Test
  public void testIsEmpty() {
    fail("Not yet implemented");
  }
  
  @Test
  public void testSize() {
    fail("Not yet implemented");
  }
  
  @Test
  public void testMin() {
    fail("Not yet implemented");
  }
  
  @Test
  public void testMax() {
    fail("Not yet implemented");
  }
  
  @Test
  public void testFloor() {
    fail("Not yet implemented");
  }
  
  @Test
  public void testCeiling() {
    fail("Not yet implemented");
  }
  
  @Test
  public void testRank() {
    fail("Not yet implemented");
  }

  @Test
  public void testSelect() {
    fail("Not yet implemented");
  }

  @Test
  public void testDeleteMin() {
    fail("Not yet implemented");
  }

  @Test
  public void testDeleteMax() {
    fail("Not yet implemented");
  }
  
  @Test
  public void testSizeRange() {
    fail("Not yet implemented");
  }
  
  @Test
  public void testKeys() {
    fail("Not yet implemented");
  }
  
  @Test
  public void testKeysRange() {
    fail("Not yet implemented");
  }
  */
}
