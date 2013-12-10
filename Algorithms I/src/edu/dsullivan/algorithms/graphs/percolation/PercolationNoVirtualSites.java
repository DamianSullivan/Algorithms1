package edu.dsullivan.algorithms.graphs.percolation;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class PercolationNoVirtualSites {
  private WeightedQuickUnionUF uf;
  private boolean[][] grid;

  // create N-by-N grid, with all sites blocked
  public PercolationNoVirtualSites(int N) {
    // TODO(dsullivan): Why does this need +1?
    this.uf = new WeightedQuickUnionUF((N * N) + 1);
    this.grid = new boolean[N][N];

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        grid[i][j] = false;
      }
    }
  }

  // open site (row i, column j) if it is not already
  public void open(int i, int j) {
    // When opening a site, use the weighted union find class
    // to record connectivity.
    if (isOpen(i, j)) {
      return;
    }
    connectNeighbors(i, j);
    grid[i-1][j-1] = true;
  }

  private void connectNeighbors(int i, int j) {
    // connect left
    if (!outOfBounds(i - 1, j) && isOpen(i - 1, j)) {
      uf.union(siteId(i, j), siteId(i - 1, j));
    }
    // connect right
    if (!outOfBounds(i + 1, j) && isOpen(i + 1, j)) {
      uf.union(siteId(i, j), siteId(i + 1, j));
    }
    // connect above
    if (!outOfBounds(i, j - 1) && isOpen(i, j - 1)) {
      uf.union(siteId(i, j), siteId(i, j - 1));
    }
    // connect below
    if (!outOfBounds(i, j + 1) && isOpen(i, j + 1)) {
      uf.union(siteId(i, j), siteId(i, j + 1));
    }
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
    // Essentially isFull asks if the site is connected to the top.
    // This can be checked using WeightedQuickUnionUF.find();
    checkIndicies(i, j);
    return isOpen(i, j) && isConnectedToFirstRow(i, j);
  }

  private boolean isConnectedToFirstRow(int i, int j) {
    for (int topRowSite = 0; topRowSite < grid.length; topRowSite++) {
      if (uf.connected(siteId(i, j), siteId(1, topRowSite))) {
        return true;
      }
    }
    return false;
  }

  // does the system percolate?
  public boolean percolates() {
    // The system percolates if there is a full site in the bottom row.
    for (int bottomRowSite = 1; bottomRowSite <= grid.length; bottomRowSite++) {
      if (isFull(grid.length, bottomRowSite)) {
        return true;
      }
    }
    return false;
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
    return ((i - 1) * grid.length) + j;
  }
}