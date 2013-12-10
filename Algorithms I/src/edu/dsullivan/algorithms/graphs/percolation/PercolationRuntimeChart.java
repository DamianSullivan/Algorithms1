package edu.dsullivan.algorithms.graphs.percolation;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import edu.princeton.cs.introcs.StdRandom;
import edu.princeton.cs.introcs.Stopwatch;

public class PercolationRuntimeChart {
  private static final int MAX_SIZE_N = 1;
  private static XYSeries runningTimeSeries =
      new XYSeries("Running Time Series");

  public static void main(String[] args) {
    RunPercolation runPercolation = new RunPercolation();
    new Thread(runPercolation).start();

    final XYSeriesCollection dataset =
        new XYSeriesCollection(runningTimeSeries);

    final JFreeChart chart = ChartFactory.createXYLineChart(
        "Running time",     // chart title
        "Number of inputs", // x axis label
        "Running time",     // y axis label
        dataset,            // data
        PlotOrientation.VERTICAL, true, // include legend
        true, // tooltips
        false // urls
    );

    JFrame frame = new JFrame("GraphTest");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    ChartPanel label = new ChartPanel(chart);
    frame.getContentPane().add(label);
    frame.pack();
    frame.setVisible(true);
  }

  static class RunPercolation implements Runnable {
    @Override
    public void run() {
      for (int N = 1; N <= MAX_SIZE_N; N++) {
        Percolation percolation = new Percolation(N);
        Stopwatch stopWatch = new Stopwatch();

        while (!percolation.percolates()) {
          int randomRow = StdRandom.uniform(N) + 1;
          int randomCol = StdRandom.uniform(N) + 1;
          if (percolation.isOpen(randomRow, randomCol)) continue;
          System.out.println(String.format(
              "Experiment: %d i: %d j: %d", N + 1, randomRow, randomCol));
          percolation.open(randomRow, randomCol);
        }
        runningTimeSeries.add(N, stopWatch.elapsedTime(), true);
        try {
          Thread.sleep(20);
        } catch (InterruptedException ex) {
          System.out.println(ex);
        }
      }
    }
  }

}