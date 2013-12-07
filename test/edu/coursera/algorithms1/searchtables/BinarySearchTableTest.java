package edu.coursera.algorithms1.searchtables;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * Tests the Binary Search implementation of Search Table.
 */
public class BinarySearchTableTest {

  @Test
  public void testPut() {
    Integer[] keys = new Integer[3];
    String[] vals = new String[3];
    BinarySearchTable<Integer, String> binarySearchTable =
        new BinarySearchTable<Integer, String>(keys, vals);
    
    binarySearchTable.put(1, "one");
    binarySearchTable.put(2, "two");
    binarySearchTable.put(3, "three");
    
    Integer[] expectedKeys = {1, 2, 3};
    String[] expectedVals = {"one", "two", "three"};
    assertArrayEquals(expectedKeys, keys);
    assertArrayEquals(expectedVals, vals);
  }
  
  @Test
  public void testGet() {
    Integer[] keys = {1, 2, 3};
    String[] vals = {"one", "two", "three"};
    BinarySearchTable<Integer, String> binarySearchTable =
        new BinarySearchTable<Integer, String>(keys, vals);
    assertEquals("one", binarySearchTable.get(1));
    assertEquals("two", binarySearchTable.get(2));
    assertEquals("three", binarySearchTable.get(3));
  }
  
  @Test
  public void testDeleteResizesKeyArray() {
    Integer[] keys = {1, 2, 3, 4};
    String[] vals = {"one", "two", "three", "four"};
    BinarySearchTable<Integer, String> binarySearchTable =
        new BinarySearchTable<Integer, String>(keys, vals);
    
    binarySearchTable.delete(2);
    //binarySearchTable.delete(3);
    //binarySearchTable.delete(4);

    //assertEquals("one", binarySearchTable.get(1));
    assertNull(binarySearchTable.get(2));
    //assertNull(binarySearchTable.get(3));
    //assertNull(binarySearchTable.get(4));
    //assertEquals(1, keys.length);
    //assertEquals(1, vals.length);
  }
  
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

}
