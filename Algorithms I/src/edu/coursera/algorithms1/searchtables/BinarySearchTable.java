package edu.coursera.algorithms1.searchtables;

public class BinarySearchTable<Key extends Comparable<Key>, Value> implements SearchTable<Key, Value> {
  private Key[] keys;
  private Value[] vals;
  private int N;

  // See Algorithm 1.1 for standard array-resizing code.
  @SuppressWarnings("unchecked")
  public BinarySearchTable(int capacity) {
    keys = (Key[]) new Comparable[capacity];
    vals = (Value[]) new Object[capacity];
  }

  // For testing.
  protected BinarySearchTable(Key[] keys, Value[] vals) {
    this.keys = keys;
    this.vals = vals;
    N = keys.length + 1;
  }
  
  // Search for key. Update value if found; grow table if new.
  public void put(Key key, Value val) {
    // Where should this key go in the table?
    int rank = rank(key);
    
    // Update the value if same key already exist at this rank.
    if (rank < N && keys[rank].compareTo(key) == 0) {
      vals[rank] = val;
      return;
    }
    
    // Grow the table by one to fit the new key.
    for (int j = N; j > rank; j--) {
      keys[j] = keys[j-1];
      vals[j] = vals[j-1];
    }
    
    // Insert the new key into the table.
    keys[rank] = key;
    vals[rank] = val;
    
    // Update N to reflect the new size of the table.
    N++;
  }
  
  public Value get(Key key) {
    // If this table is empty then there is no key.
    if (isEmpty()) {
      return null;
    }
    
    // Search for this key and get the index of where it should be in the table.
    int rank = rank(key);
    
    // Return the key if it exists where it should be.
    if (rank < N && keys[rank].compareTo(key) == 0) {
      return vals[rank];
    } else {
      return null;
    }
  }
  
  public void delete(Key key) {
    if (isEmpty()) {
      return;
    }
    
    // Find the key should be in the table.
    int rank = rank(key);
    
    // Key is not in the table.
    if (rank == N || keys[rank].compareTo(key) != 0) {
      return;
    }
        
    // Remove the element by collapsing the table by one.
    for (int j = rank; j < N-1; j++) {
      keys[j] = keys[j+1];
      vals[j] = vals[j+1];
    }
    
    // Erase the last element since we collapsed the table by one.
    keys[N] = null;
    vals[N] = null;
    
    // Update N to reflect the new size of the table.
    N--;
    
    
    // Resize the table if only 1/4 full.
    if (N > 0 && N == keys.length/4) {
      resize(keys.length/2);
    }
  }
  
  @SuppressWarnings("unchecked")
  private void resize(int size) {
    assert size >= N;
    Key[] resizedKeys = (Key[]) new Comparable[size];
    Value[] resizedValues = (Value[]) new Object[size];
    for (int i = 0; i < N; i++) {
      resizedKeys[i] = keys[i];
      resizedValues[i] = vals[i];
    }
    keys = resizedKeys;
    vals = resizedValues;
  }

  @Override
  public boolean contains(Key key) {
    // TODO Auto-generated method stub
    return false;
  }

  public boolean isEmpty() {
    return N == 0;
  }
  
  public int size() {
    return N;
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

  /**
   * If the key is in the table, rank() returns its index in the table,
   * which is the same as the number of keys in the table that are smaller than the key.
   * 
   * If key is not in the table, rank() also returns the number of keys in the table that are
   * smaller than key.
   */
  public int rank(Key key) {
    int lo = 0; 
    int hi = N - 1;

    while (lo <= hi) {
      // Find the middle of the array within the current interval.
      int mid = lo + (hi - lo) / 2;
      
      // Is the key >, <, or = to the middle key?
      // compareTo returns:
      //     * -1 for less than
      //     *  0 for equal to
      //     *  1 for greater than
      int cmp = key.compareTo(keys[mid]);
      
      // The key is less than middle, then it is somewhere in the lower half of the range.
      // Set hi to one less than the middle as an upper bound to the next search.
      if (cmp < 0) {
        hi = mid - 1;
      }
      // The key is greater than the middle, it is somewhere in the upper half of the range.
      // Set lo to one more than the middle as an upper bound to the next search.
      else if (cmp > 0) {
        lo = mid + 1;
      }
      // The key is equal to the middle. Return the index of the key which is mid.
      else {
        return mid;
      }
    }
    return lo;
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
