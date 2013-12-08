package edu.dsullivan.algorithms.sorting.collinearpoints;

import java.util.Comparator;

import edu.princeton.cs.introcs.StdDraw;

public class Point implements Comparable<Point> {
  private static final int GREATER_THAN = 1;
  private static final int LESS_THAN = -1;
  private static final int EQUAL_TO = 0;

  private static final int NO_SLOPE = 0;
  private static final int POSITIVE_INFINITY = Integer.MAX_VALUE;
  private static final int NEGATIVE_INFINITY = -Integer.MAX_VALUE;  
  
  private final int x;
  private final int y;
 
  public final Comparator<Point> SLOPE_ORDER = new Comparator<Point>() {
    @Override
    public int compare(Point o1, Point o2) {
      if (o1.y > o2.y) {
        return GREATER_THAN;
      } else if (o1.y < o2.y) {
        return LESS_THAN;
      } else {
        if (o1.x > o2.x) {
          return GREATER_THAN;
        } else  if (o1.x < o2.x) {
          return LESS_THAN;
        } else {
          return EQUAL_TO;
        }
      }
    }
  }; 
  
  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public void draw() {
    StdDraw.point(x, y);
  }

  public void drawTo(Point that) {
    StdDraw.line(this.x, this.y, that.x, that.y);
  }

  public double slopeTo(Point that) {
    if (this.y == that.y && this.x == that.x) {
      // These points are the same.
      return NEGATIVE_INFINITY;
    } else if (this.y == that.y) {
      // These points form a horizontal line.
      return NO_SLOPE;
    } else if (this.x == that.x) {
      // These points form a vertical line.
      return POSITIVE_INFINITY;
    } else {
      return ((that.y - this.y) / (that.x - this.x));
    }
  }
  
  public int compareTo(Point that) {
    if (this.y > that.y) {
      return GREATER_THAN;
    } else if (this.y < that.y) {
      return LESS_THAN;
    } else {
      if (this.x > that.x) {
        return GREATER_THAN;
      } else  if (this.x < that.x) {
        return LESS_THAN;
      } else {
        return EQUAL_TO;
      }
    }
  }

  public String toString() {
    return "(" + x + ", " + y + ")";
  }

  public static void main(String[] args) {
  }
}
