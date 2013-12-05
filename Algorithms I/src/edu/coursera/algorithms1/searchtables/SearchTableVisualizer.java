package edu.coursera.algorithms1.searchtables;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;

public class SearchTableVisualizer {
  public static void load(SearchTable<String, Integer>  searchTable, int minimumLength, String filename) {
    In in = new In(filename);
    while (!in.isEmpty()) {
      String word = in.readString();
      //StdOut.println(String.format("Word: %s", word));
      if (word.length() < minimumLength) {
        //StdOut.println(String.format("Word length is less than minimum: %s", minimumLength));
        continue;
      }
      if (searchTable.contains(word)) {
        int frequency = searchTable.get(word);
        frequency++;
        //StdOut.println(String.format("Have seen %s %s times.", word, frequency));
        searchTable.put(word, frequency);
      } else {
        //StdOut.println(String.format("First occurrence of word: %s", word));
        searchTable.put(word, 1);
      }
    }
  }
  
  public static void highestFrequency(SearchTable<String, Integer> searchTable) {
    // Find the key with the highest frequency count.
    String max = "";
    searchTable.put(max, 0);
    if (searchTable.size() == 0) {
      //StdOut.println("Search table was not populated.");
      return;
    }
    //StdOut.printf("Size of search table: %s%n", searchTable.size());
    for (String word : searchTable.keys()) {
      ////StdOut.printf("word: %s (%s) max: %s (%s)%n", word, searchTable.get(word), max, searchTable.get(max));
      if (searchTable.get(word) > searchTable.get(max)) {
        max = word;
      }
    }
    StdOut.println(max + " " + searchTable.get(max));    
  }
  
  public static void main(String[] args) {
    if (args.length == 0) {
      throw new IllegalArgumentException("Need minimum length of keys to consider.");
    }
    
    int minimumLength = Integer.parseInt(args[0]);
    //StdOut.println(String.format("Minimum length: %s", minimumLength));
    
    String filename = args[1];
    //StdOut.println(String.format("Filename is: %s", filename));
    
    //StdOut.println("Setting up new search table.");
    SearchTable<String, Integer> searchTable = new SequentialSearchTable<String, Integer>();

    //StdOut.println("Loading...");
    SearchTableVisualizer.load(searchTable, minimumLength, filename);
    
    //StdOut.println("Looking for highest frequency word...");
    SearchTableVisualizer.highestFrequency(searchTable);
  }
}
