package edu.dsullivan.algorithms.searching.testing;

import edu.dsullivan.algorithms.searching.binarysearch.BinarySearchSymbolTable;

import edu.dsullivan.algorithms.searching.symboltable.SymbolTable;
import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;

public class SymbolTableVisualizer {
  public static void load(
      SymbolTable<String, Integer> searchTable, int minimumLength, String filename) {
    In in = new In(filename);
    while (!in.isEmpty()) {
      String word = in.readString();
      if (word.length() < minimumLength) {
        continue;
      }
      if (searchTable.contains(word)) {
        int frequency = searchTable.get(word);
        frequency++;
        searchTable.put(word, frequency);
      } else {
        searchTable.put(word, 1);
      }
    }
  }

  public static void highestFrequency(SymbolTable<String, Integer> searchTable) {
    // Find the key with the highest frequency count.
    String max = "";
    searchTable.put(max, 0);
    if (searchTable.size() == 0) {
      return;
    }
    for (String word : searchTable.keys()) {
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
    String filename = args[1];
    SymbolTable<String, Integer> searchTable =
        new BinarySearchSymbolTable<String, Integer>(10);
    SymbolTableVisualizer.load(searchTable, minimumLength, filename);
    SymbolTableVisualizer.highestFrequency(searchTable);
  }
}
