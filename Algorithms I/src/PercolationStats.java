public class PercolationStats {
  private double mean = 0.0;
  private double stddev = 0.0;
  private double confidenceHi = 0.0;
  private double confidenceLo = 0.0;
  
  // perform T independent computational experiments on an N-by-N grid
  public PercolationStats(int N, int T) {
    checkArguments(N, T);
    for (int i = 0; i < T; i++) {
      runPercolationExperiment(N);
    }
  }
  
  private void checkArguments(int N, int T) {
    if (N <= 0 || T <= 0) {
      throw new IllegalArgumentException(
          "Grid size or number of experiments cannot be <= 0");
    }
  }
   
  private void runPercolationExperiment(int N) {
    Percolation percolation = new Percolation(N);
    while (!percolation.percolates()) {
      int randomRow = StdRandom.uniform(N);
      int randomCol = StdRandom.uniform(N);
      percolation.open(randomRow, randomCol);
    }
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
    return confidenceHi;
  }
  
  // returns lower bound of the 95% confidence interval
  public double confidenceLo() {
    return confidenceLo;
  }

  // test client, described below
  public static void main(String[] args) {
    int N = Integer.parseInt(args[0]);
    int T = Integer.parseInt(args[1]);

    PercolationStats percolationStats = new PercolationStats(N, T);
    System.out.println(
        String.format("mean                    = %s", percolationStats.mean()));
    System.out.println(
        String.format("stddev                  = %s", percolationStats.stddev()));
    System.out.println(
        String.format("95%% confidence interval = %s, %s",
            percolationStats.confidenceLo(), percolationStats.confidenceHi()));
  }
}