package edu.dsullivan.algorithms.stacks;
import java.util.NoSuchElementException;

/*
 * A linked list implementation of a stack.
 * Stacks are Last In First Out (FIFO).
 */
public class LinkedStackOfStrings {
  
  private Node head;

  private class Node {
    String item;
    Node next;
  }

  public boolean isEmpty() {
    return head == null;
  }

  public void push(String item) {
    if (item == null) {
      throw new NullPointerException();
    }
    
    Node oldHead = head;
    
    head = new Node();
    head.item = item;
    
    if (isEmpty()) {
      head.next = null;
    } else {
      head.next = oldHead;
    }
  }

  public String pop() {
    // Make sure the list isn't empty
    if (isEmpty()) {
      throw new NoSuchElementException();
    }
    String item = head.item;
    head = head.next;
    return item;
  }
}
