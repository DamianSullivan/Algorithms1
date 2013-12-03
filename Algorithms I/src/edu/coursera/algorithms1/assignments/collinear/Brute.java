package edu.coursera.algorithms1.assignments.collinear;

import edu.princeton.cs.introcs.In;

public class Brute {
  public static void main(String[] args) {
    String filename = args[0];
    In in = new In(filename);
    int N = in.readInt();
    for (int i = 0; i < N; i++) {
      int x = in.readInt();
      int y = in.readInt();
      Point p = new Point(x, y);
      p.draw();
    }
  }
}