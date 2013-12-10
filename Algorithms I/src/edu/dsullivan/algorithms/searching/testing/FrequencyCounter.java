package edu.dsullivan.algorithms.searching.testing;

import edu.dsullivan.algorithms.searching.binarysearch.BinarySearchSymbolTable;
import edu.dsullivan.algorithms.searching.symboltable.SymbolTable;
import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;

public class FrequencyCounter {
  public static void load(SymbolTable<String, Integer> searchTable,
      int minimumLength, String filename) {
    In in = new In(filename);
    while (!in.isEmpty()) {
      String word = in.readString();
      // StdOut.println(String.format("Word: %s", word));
      if (word.length() < minimumLength) {
        // StdOut.println(String.format("Word length is less than minimum: %s",
        // minimumLength));
        continue;
      }
      if (searchTable.contains(word)) {
        int frequency = searchTable.get(word);
        frequency++;
        // StdOut.println(String.format("Have seen %s %s times.", word,
        // frequency));
        searchTable.put(word, frequency);
      } else {
        // StdOut.println(String.format("First occurrence of word: %s", word));
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

    SymbolTable<String, Integer> searchTable = new BinarySearchSymbolTable<String, Integer>(10);

    FrequencyCounter.load(searchTable, minimumLength, filename);

    FrequencyCounter.highestFrequency(searchTable);
  }
}
