package edu.coursera.algorithms1.searchtables.testing;

import edu.princeton.cs.introcs.StdDraw;

public class VisualAccumulator {
  private double total;
  private int N;

  public VisualAccumulator(int trials, double max) {
    StdDraw.setXscale(0, trials);
    StdDraw.setYscale(0, max);
    StdDraw.setPenRadius(.005);
  }

  public void addDataValue(double val) {
    N++;
    total += val;
    StdDraw.setPenColor(StdDraw.DARK_GRAY);
    StdDraw.point(N, val);
    StdDraw.setPenColor(StdDraw.RED);
    StdDraw.point(N, total / N);
  }

  public double mean() {
    return N/total;

  }

  //public String toString() {  
  //}
  // Same as Accumulator.
}