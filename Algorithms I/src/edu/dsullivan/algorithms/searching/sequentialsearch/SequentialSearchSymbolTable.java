package edu.dsullivan.algorithms.searching.sequentialsearch;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.dsullivan.algorithms.searching.binarysearch.SymbolTable;

public class SequentialSearchSymbolTable<Key, Value> implements SymbolTable<Key, Value> {
  private Node first;
  private int size;

  private class Node {
    Key key;
    Value value;
    Node next;

    public Node(Key key, Value value, Node next) {
      this.key = key;
      this.value = value;
      this.next = next;
    }
  }

  // Search for the key, return the associated value.
  public Value get(Key key) {
    for (Node x = first; x != null; x = x.next) {
      if (key.equals(x.key)) {
        return x.value;
      }
    }
    return null;
  }

  // Search for key. Update value if found. Grow table if new.
  public void put(Key key, Value value) {
    for (Node x = first; x != null; x = x.next) {
      if (key.equals(x.key)) {
        x.value = value;
        return;
      }
    }
    first = new Node(key, value, first);
    size++;
  }

  @Override
  public void delete(Key key) {
    // TODO Auto-generated method stub

  }

  @Override
  public boolean contains(Key key) {
    return (get(key) != null);
  }

  @Override
  public boolean isEmpty() {
    return (size > 0);
  }

  @Override
  public int size() {
    return size;
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
  public int rank(Key key) {
    // TODO Auto-generated method stub
    return 0;
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
    return null;

  }

  @Override
  public Iterable<Key> keys() {
    // return iterator();
    return new KeysIterable();
  }

  private class KeysIterable implements Iterable<Key> {
    @Override
    public Iterator<Key> iterator() {
      return new KeysIterator();
    }    
  }
  
  private class KeysIterator implements Iterator<Key> {
    private Node current = first;

    @Override
    public boolean hasNext() {
      return current != null;
    }

    @Override
    public Key next() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }
      Key key = current.key;
      current = current.next;
      return key;
    }

    @Override
    public void remove() {
      throw new UnsupportedOperationException();
    }

  }
}
