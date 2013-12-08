package edu.dsullivan.algorithms.binarysearch;

import edu.princeton.cs.algs4.Queue;

public class BinarySearchSymbolTable<Key extends Comparable<Key>, Value>
    implements SymbolTable<Key, Value> {
  private Key[] keys;
  private Value[] vals;
  private int N;

  @SuppressWarnings("unchecked")
  public BinarySearchSymbolTable(int capacity) {
    keys = (Key[]) new Comparable[capacity];
    vals = (Value[]) new Object[capacity];
  }
  
  /**
   * Search for key. Update value if found; grow table if new.
   */
  public void put(Key key, Value val) {
    // Where should this key go in the table?
    int rank = rank(key);
    
    // Update the value if same key already exist at this rank.
    if (rank < N && keys[rank].compareTo(key) == 0) {
      vals[rank] = val;
      return;
    }
    
    // Make sure the table is large enough to fit the new key.
    if (N == keys.length) {
      resize(2*keys.length);
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

  /**
   * Retrieve the value associated with key, return null if not found.
   */
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
  
  /**
   * Remove key and value from the table.
   */
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

    // Update N to reflect the new size of the table.
    N--;
    
    // Erase the last element since we collapsed the table by one.
    keys[N] = null;
    vals[N] = null;

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

  /**
   * Does this key exist in the table?
   */
  public boolean contains(Key key) {
    // Find the key should be in the table.
    int rank = rank(key);
    
    // Key is not in the table.
    if (rank < N && keys[rank].compareTo(key) == 0) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Is this table empty?
   */
  public boolean isEmpty() {
    return N == 0;
  }
  
  /**
   * Number of key value pairs.
   */
  public int size() {
    return N;
  }
  
  public Key min() {
    return keys[0];
  }

  public Key max() {
    // Since N is the size of the table, N-1 is its largest index.
    return keys[N-1];
  }

  /**
   * Largest key less than or equal to key.
   */
  public Key floor(Key key) {
    // Find where this key should be in the table.
    int rank = rank(key);
    
    // Return the key if it has been found.
    if (rank < N && keys[rank].compareTo(key) == 0) {
      return keys[rank];
    }
    
    // If the rank is 0, then there is no floor.
    if (rank == 0) {
      return null;
    }
    
    // Return the item that would be one less than the rank.
    else {
      return keys[rank-1];
    }
    
  }

  /**
   * Find the smallest key greater than or equal to key.
   */
  public Key ceiling(Key key) {
    // Find where this key should be in the table.
    int rank = rank(key);
    
    // Return if the key has been found.
    if (rank < N && keys[rank].compareTo(key) == 0) {
      return keys[rank];
    }
    
    // If the rank is Max then there is no ceiling.
    if (rank > N) {
      return null;
    }
    
    // Return the key at the location of the rank of this key.
    else {
      return keys[rank];
    }
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
    int hi = N-1;

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

  /**
   * Get the key of rank k.
   */
  public Key select(int k) {
    // k is out of bounds.
    if (k < 0 || k > N) {
      return null;
    }
    return keys[k];
  }

  /**
   * Delete the smallest key in the table.
   */
  public void deleteMin() {
    delete(min());
  }

  /**
   * Delete the largest key in the table.
   */
  public void deleteMax() {
    delete(max());    
  }

  /**
   * Number of keys between the given key interval.
   */
  public int size(Key lo, Key hi) {
    // If lo is higher than hi then size doesn't make sense.
    if (lo.compareTo(hi) > 0) {
      return 0;
    }
    
    // If the key is contained in the table then the size is one more than the difference in rank
    // because rank starts at index 0.
    if (contains(hi)) {
      return rank(hi) - rank(lo) + 1;
    } else {
      return rank(hi) - rank(lo);
    }
  }

  /**
   * Get keys in the range in sorted order.
   */
  public Iterable<Key> keys(Key lo, Key hi) {
    // Use a queue to iterate through keys.
    // TODO(dsullivan): See if we can use lazy initialization here.
    Queue<Key> queue = new Queue<Key>(); 
    
    // Input checking.
    if (lo == null && hi == null) {
      return queue;
    }
    if (lo == null) {
      throw new NullPointerException("lo is null in keys()");
    }   
    if (hi == null) {
      throw new NullPointerException("hi is null in keys()");
    }
    if (lo.compareTo(hi) > 0) {
      return queue;
    }
    
    // Enqueue all keys in the interval.
    for (int i = rank(lo); i < rank(hi); i++) { 
      queue.enqueue(keys[i]);
    }
    
    // Enqueue the hi key if it is actually found in the table. If not found then passed hi value
    // is outside of the table but the number of elements is lo -> highest rank.
    if (contains(hi)) {
      queue.enqueue(keys[rank(hi)]);
    }
    
    return queue; 
  }
 
  /**
   * Get the keys in the whole table in sorted order.
   */
  public Iterable<Key> keys() {
    return keys(min(), max());
  }
  
  // For testing.
  protected Key[] getKeys() {
    return keys;
  }
  
  protected Value[] getValues() {
    return vals;
  }
}
