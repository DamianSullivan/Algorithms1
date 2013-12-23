package edu.dsullivan.algorithms.searching.binarytree;

import edu.dsullivan.algorithms.searching.symboltable.SymbolTable;

/**
 * @author dsullivan
 * 
 * @param <Key>
 * @param <Value>
 */
public class BinaryTreeSymbolTable<Key extends Comparable<Key>, Value>
    implements SymbolTable<Key, Value> {
  private Node root;

  private class Node {
    private Key key;
    private Value value;
    private Node left;
    private Node right;
    private int N;

    Node(Key key, Value value, int N) {
      this.key = key;
      this.value = value;
      this.N = N;
    }
  }

  @Override
  public void put(Key key, Value value) {
    root = put(root, key, value);
  }

  private Node put(Node node, Key key, Value value) {
    // Check to see if this key already exists.
    if (node == null) {
      return new Node(key, value, 1);
    }

    int cmp = key.compareTo(node.key);

    if (cmp < 0) {
      node.left = put(node.left, key, value);
    } else if (cmp > 0) {
      node.right = put(node.right, key, value);
    } else {
      node.value = value;
    }
    
    node.N = size(node.left) + size(node.right) + 1;
    
    return node;
  }

  @Override
  public Value get(Key key) {
    return get(root, key);
  }

  private Value get(Node node, Key key) {
    // Check to see if this key already exists.
    if (node == null) {
      return null;
    }
    
    int cmp = key.compareTo(node.key);
    
    if (cmp < 0) {
      return get(node.left, key);
    } else if (cmp > 0) {
      return get(node.right, key);
    } else {
      return node.value;
    }
  }

  @Override
  public void delete(Key key) {
    root = delete(root, key);
  }

  private Node delete(Node node, Key key) {
    if (node == null) {
      return null;
    }
    
    int cmp = key.compareTo(node.key);
    
    if (cmp < 0 ) {
      
    }
    return null;
  }

  @Override
  public boolean contains(Key key) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean isEmpty() {
    return (root == null);
  }

  @Override
  public int size() {
    return size(root);
  }
  
  private int size(Node node) {
    if (node == null) {
      return 0;
    } else {
      return node.N;
    }
  }

  @Override
  public Key min() {
    return min(root).key;
  }
  
  private Node min(Node node) {
    if (node.left == null) {
      return node;
    } else {
      return min(node.left);
    }
  }

  @Override
  public Key max() {
    return max(root).key;
  }
  
  private Node max(Node node) {
    if (node.right == null) {
      return node;
    } else {
      return max(node.right);
    }
  }

  @Override
  public Key floor(Key key) {
    Node node = floor(root, key);
    
    if (node == null) {
      return null;
    }
    
    return node.key;
  }
  
  private Node floor(Node node, Key key) {
    if (node == null) {
      return null;
    }

    int cmp = key.compareTo(node.key);

    if (cmp == 0) {
      return node;
    }

    if (cmp < 0) {
      return floor(node.left, key);
    }

    Node t = floor(node.right, key);
    if (t != null) {
      return t;
    } else {
      return node;
    }
  }

  public Key ceiling(Key key) {
    Node node = ceiling(root, key);
    
    if (node == null) {
      return null;
    }
    
    return node.key;
  }
  
  private Node ceiling(Node node, Key key) {
    if (node == null) {
      return null;
    }
    
    int cmp = key.compareTo(node.key);
    
    if (cmp == 0) {
      return node;
    }
    
    if (cmp > 0) {
      return ceiling(node.right, key);
    }
    
    Node t = ceiling(node.left, key);
    
    if (t != null) {
      return t;
    } else {
      return node;
    }
  }

  @Override
  public int rank(Key key) {
    return rank(root, key);
  }

  private int rank(Node node, Key key) {
    if (node == null) {
      return 0;
    }
    
    int cmp = key.compareTo(node.key);
    
    if (cmp < 0) {
      return rank(node.left, key);
    } else if (cmp > 0) {
      return 1 + size(node.left) + rank(node.right, key);
    } else {
      return size(node.left);
    }
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
