
import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

public class RuntimeChart {
  private static final int MAX_SIZE_N = 1000;

  @SuppressWarnings("deprecation")
  static TimeSeries ts = new TimeSeries("data", Millisecond.class);

  public static void main(String[] args) throws InterruptedException {
    RunPercolation runPercolation = new RunPercolation();
    new Thread(runPercolation).start();

    TimeSeriesCollection dataset = new TimeSeriesCollection(ts);
    JFreeChart chart = ChartFactory.createTimeSeriesChart("GraphTest", "Time",
        "Value", dataset, true, true, false);
    final XYPlot plot = chart.getXYPlot();
    ValueAxis axis = plot.getDomainAxis();
    axis.setAutoRange(true);
    axis.setFixedAutoRange(60000.0);

    JFrame frame = new JFrame("GraphTest");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    ChartPanel label = new ChartPanel(chart);
    frame.getContentPane().add(label);
    // Suppose I add combo boxes and buttons here later

    frame.pack();
    frame.setVisible(true);
  }

  static class RunPercolation implements Runnable {
    public void run() {
      for (int N = 0; N < MAX_SIZE_N; N++) {
        N++;
        Percolation percolation = new Percolation(N);
        Stopwatch stopWatch = new Stopwatch();

        while (!percolation.percolates()) {
          int randomRow = StdRandom.uniform(N) + 1;
          int randomCol = StdRandom.uniform(N) + 1;
          if (percolation.isOpen(randomRow, randomCol)) continue;
          percolation.open(randomRow, randomCol);
        }

        ts.addOrUpdate(new Millisecond(), stopWatch.elapsedTime());
        try {
          Thread.sleep(20);
        } catch (InterruptedException ex) {
          System.out.println(ex);
        }
      }
    }
  }

}