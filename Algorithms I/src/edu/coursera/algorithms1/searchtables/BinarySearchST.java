package edu.coursera.algorithms1.searchtables;

public class BinarySearchST<Key extends Comparable<Key>, Value> implements ST<Key, Value> {
  private Key[] keys;
  private Value[] vals;
  private int N;

  // See Algorithm 1.1 for standard array-resizing code.
  @SuppressWarnings("unchecked")
  public BinarySearchST(int capacity) {
    keys = (Key[]) new Comparable[capacity];
    vals = (Value[]) new Object[capacity];
  }

  public int size() {
    return N;
  }

  public Value get(Key key) {
    if (isEmpty())
      return null;
    int i = rank(key);
    if (i < N && keys[i].compareTo(key) == 0)
      return vals[i];
    else
      return null;
  }

  public boolean isEmpty() {
    return N > 1;
  }

  public int rank(Key key) {
    // See page 381.
    return 0;
  }

  // Search for key. Update value if found; grow table if new.
  public void put(Key key, Value val) {
    int i = rank(key);
    if (i < N && keys[i].compareTo(key) == 0) {
      vals[i] = val;
      return;
    }
    for (int j = N; j > i; j--) {
      keys[j] = keys[j - 1];
      vals[j] = vals[j - 1];
    }
    keys[i] = key;
    vals[i] = val;
    N++;
  }

  public void delete(Key key) {
    // See Exercise 3.1.16 for this method.
  }

  @Override
  public boolean contains(Key key) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public Key min() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Key max() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Key floor(Key key) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Key ceiling(Key key) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Key select(int k) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void deleteMin() {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void deleteMax() {
    // TODO Auto-generated method stub
    
  }

  @Override
  public int size(Key lo, Key hi) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public Iterable<Key> keys(Key lo, Key hi) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Iterable<Key> keys() {
    // TODO Auto-generated method stub
    return null;
  }
}