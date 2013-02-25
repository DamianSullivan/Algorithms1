import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PercolationTest {
  @Test
  public void testVerticalPercolation() {
    Percolation percolation = new Percolation(10);

    for (int row = 1; row <= 10; row++) {
      // open the first column in all the rows
      percolation.open(row, 1);
    }
    assertTrue(percolation.percolates());
  }

  @Test
  public void testVerticalPercolationBackwash() {
    Percolation percolation = new Percolation(10);

    // open the first column in all the rows
    for (int row = 1; row <= 10; row++) {
      percolation.open(row, 1);
    }
    
    // open "backwash" sites
    percolation.open(10, 10);
    
    assertTrue(percolation.percolates());
    assertFalse(percolation.isFull(10, 10));
  }

  @Test(expected=IndexOutOfBoundsException.class)
  public void testIndicesOutOfBounds_rowTooSmall() {
    Percolation percolation = new Percolation(10);
    percolation.open(0, 6);
  }

  @Test(expected=IndexOutOfBoundsException.class)
  public void testIndicesOutOfBounds_rowTooBig() {
    Percolation percolation = new Percolation(10);
    percolation.open(11, 6);
  }

  @Test(expected=IndexOutOfBoundsException.class)
  public void testIndicesOutOfBounds_colTooSmall() {
    Percolation percolation = new Percolation(10);
    percolation.open(6, 0);
  }

  @Test(expected=IndexOutOfBoundsException.class)
  public void testIndicesOutOfBounds_colTooBig() {
    Percolation percolation = new Percolation(10);
    percolation.open(6, 11);
  }

  @Test(expected=IndexOutOfBoundsException.class)
  public void testZeroGridSize() {
    new Percolation(0);
  }

  @Test
  public void testPercolationBeforeOpen() {
    Percolation percolation = new Percolation(1);
    assertFalse(percolation.percolates());
  }

  @Test
  public void testEdgeCases_1x1() {
    Percolation percolation = new Percolation(1);
    percolation.open(1, 1);
    assertTrue(percolation.isOpen(1, 1));
    assertTrue(percolation.percolates());
  }

  @Test
  public void testEdgeCases_2x2() {
    Percolation percolation = new Percolation(2);
    percolation.open(2, 2);
    assertTrue(percolation.isOpen(2, 2));
    assertFalse(percolation.percolates());
  }
}