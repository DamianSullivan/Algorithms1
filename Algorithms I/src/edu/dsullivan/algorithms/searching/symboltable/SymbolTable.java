package edu.dsullivan.algorithms.searching.symboltable;

public interface SymbolTable<Key, Value> {
  void put(Key key, Value value);

  Value get(Key key);

  void delete(Key key);

  boolean contains(Key key);

  boolean isEmpty();

  int size();

  Key min();

  Key max();

  Key floor(Key key);

  Key ceiling(Key key);

  int rank(Key key);

  Key select(int k);

  void deleteMin();

  void deleteMax();

  int size(Key lo, Key hi);

  Iterable<Key> keys(Key lo, Key hi);

  Iterable<Key> keys();
}
