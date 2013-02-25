public class Percolation {
  private WeightedQuickUnionUF uf;
  private boolean[][] grid;

  // mnemonics
  private int topVirtualSite;
  private int bottomVirtualSite;

  // create N-by-N grid, with all sites blocked
  public Percolation(int N) {
    checkGridSize(N);
    // Initialize union-find with extra virtual nodes for top and bottom.
    this.uf = new WeightedQuickUnionUF((N*N)+2);
    this.grid = new boolean[N][N];
    topVirtualSite = 0;
    bottomVirtualSite = (N*N)+1;
    for (int i = 0; i < N; i++) {
      // Connect the virtual sites to the top and bottom rows.
      uf.union(topVirtualSite, siteId(1, i+1));
      uf.union(bottomVirtualSite, siteId(grid.length, i+1));
      for (int j = 0; j < N; j++) {
        grid[i][j] = false;
      }
    }
  }
  
  private void checkGridSize(int N) {
    if (N <= 0) {
      throw new IndexOutOfBoundsException(String.format(
          "Grid size %s is out of bounds", N));
    }
  }
  
  // open site (row i, column j) if it is not already
  public void open(int i, int j) {
    // When opening a site, use the weighted union find class
    // to record connectivity.
    if (isOpen(i, j)) return;
    connectNeighbors(i, j);
    grid[i-1][j-1] = true;
  }

  private void connectNeighbors(int i, int j) {
    connectSite(i, j, i-1, j);   // left
    connectSite(i, j, i+1, j);   // right
    connectSite(i, j, i,   j-1); // above
    connectSite(i, j, i,   j+1); // below
  }

  private void connectSite(int fromRow, int fromCol,
      int toRow, int toCol) {
    if (outOfBounds(toRow, toCol)) return;
    if (!isOpen(toRow, toCol)) return;
    uf.union(siteId(fromRow, fromCol), siteId(toRow, toCol));
  }

  // is site (row i, column j) open?
  public boolean isOpen(int i, int j) {
    checkIndicies(i, j);
    return grid[i-1][j-1];
  }

  // is site (row i, column j) full?
  public boolean isFull(int i, int j) {
    // A full site is an open site that can be connected to an open site in
    // the top row via a chain of neighboring (left, right, up, down) open
    // sites.
    checkIndicies(i, j);
    return isOpen(i, j) && uf.connected(topVirtualSite, siteId(i, j));
  }

  // does the system percolate?
  public boolean percolates() {
    return uf.connected(topVirtualSite, bottomVirtualSite);
  }

  private void checkIndicies(int i, int j) {
    if (outOfBounds(i, j)) {
      throw new IndexOutOfBoundsException(String.format(
          "index i: %d j: %d grid size: %d out of bounds", i, j, grid.length));
    }
  }

  private boolean outOfBounds(int i, int j) {
    return ((i <= 0 || i > grid.length) || (j <= 0 || j > grid.length));
  }

  private int siteId(int i, int j) {
    // siteId translates the NxN grid coordinates to unique ids for use with the
    // union-find algorithm. i starts at 1 so i - 1 is the row coordinate of the
    // 0-based grid. Multiplying by grid.length "fast forwards" to the next
    // first element of the next row. Adding j forwards to the site, making a
    // unique id.
    // Examples:
    // N=5, (1,1) = ((1-1)*5)+1 = (0*5) + 1 = 1
    // N=5, (5,5) = ((5-1)*5)+5 = (4*5) + 5 = 20+5 = 25
    return ((i-1)*grid.length)+j;
  }
}