package edu.dsullivan.algorithms.graphs.percolation;
import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.StdRandom;
import edu.princeton.cs.introcs.StdStats;

public class PercolationStats {
  private int T;
  private double mean = 0.0;
  private double stddev = 0.0;
  private double variance = 0.0;

  // perform T independent computational experiments on an N-by-N grid
  public PercolationStats(int N, int T) {
    checkArguments(N, T);
    this.T = T;
    double[] percolationThreshholds = new double[T];
    for (int t = 0; t < T; t++) {
      int percolationThreshhold = 0;
      Percolation percolation = new Percolation(N);
      while (!percolation.percolates()) {
        int randomRow = StdRandom.uniform(N) + 1;
        int randomCol = StdRandom.uniform(N) + 1;
        if (percolation.isOpen(randomRow, randomCol)) continue;
        percolation.open(randomRow, randomCol);
        percolationThreshhold++;
      }
      percolationThreshholds[t] =
          ((double) percolationThreshhold / (double) (N*N));
    }
    mean = StdStats.mean(percolationThreshholds);
    stddev = StdStats.stddev(percolationThreshholds);
    variance = StdStats.var(percolationThreshholds);
  }

  // sample mean of percolation threshold
  public double mean() {
    return mean;
  }

  // sample standard deviation of percolation threshold
  public double stddev() {
    return stddev;
  }

  // returns upper bound of the 95% confidence interval
  public double confidenceHi() {
    return mean + ((1.96 * variance) / Math.sqrt(T));
  }

  // returns lower bound of the 95% confidence interval
  public double confidenceLo() {
    return mean + ((1.96 * variance) / Math.sqrt(T));
  }

  private void checkArguments(int gridSize, int numberOfExperiments) {
    if (gridSize <= 0 || numberOfExperiments <= 0) {
      throw new IllegalArgumentException(
          "Grid size or number of experiments cannot be <= 0");
    }
  }

  // test client, described below
  public static void main(String[] args) {
    int N = Integer.parseInt(args[0]);
    int T = Integer.parseInt(args[1]);
    PercolationStats percolationStats = new PercolationStats(N, T);
    StdOut.printf("mean                    = %s%n", percolationStats.mean());
    StdOut.printf("stddev                  = %s%n", percolationStats.stddev());
    StdOut.printf("95%% confidence interval = %s, %s%n",
            percolationStats.confidenceLo(), percolationStats.confidenceHi());
  }
}