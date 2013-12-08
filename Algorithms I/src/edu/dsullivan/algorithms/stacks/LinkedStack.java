package edu.dsullivan.algorithms.stacks;
import java.util.NoSuchElementException;

/*
 * A linked list implementation of a stack.
 * Stacks are Last In First Out (FIFO).
 */
public class LinkedStack<Item> {

  private Node head;

  private class Node {
    Item item;
    Node next;
  }

  public boolean isEmpty() {
    return head == null;
  }

  public void push(Item item) {
    if (item == null) {
      throw new NullPointerException();
    }

    Node oldHead = head;

    head = new Node();
    head.item = item;
    head.next = oldHead;
  }

  public Item pop() {
    // Make sure the list isn't empty
    if (isEmpty()) {
      throw new NoSuchElementException();
    }
    Item item = head.item;
    head = head.next;
    return item;
  }
}
