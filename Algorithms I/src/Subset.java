
public class Subset {
  /**
   * Subset client. Write a client program Subset.java that takes a command-line
   * integer k, reads in a sequence of N strings from standard input using
   * StdIn.readString(), and prints out exactly k of them, uniformly at random.
   * Each item from the sequence can be printed out at most once. You may assume
   * that k >= 0 and no greater than the number of string on standard input.
   * @param args
   */
  public static void main(String[] args) {
    RandomizedQueue<String> randomizedQueue = new RandomizedQueue<String>();

    while (!StdIn.isEmpty()) {
      String item = StdIn.readString();
      randomizedQueue.enqueue(item);
    }

    int k = Integer.parseInt(args[0]);
    for (int i = 0; i < k; i++) {
      StdOut.println(randomizedQueue.dequeue());
    }
  }
}
