package edu.dsullivan.datastructures.queues;
import java.util.NoSuchElementException;

/*
 * A linked list implementation of a queue. Queues are Last In First Out (LIFO).  
 */
public class LinkedQueueOfStrings {

  private Node first;
  private Node last;
  
  private class Node {
    String item;
    Node next;
  }

  public boolean isEmpty() {
    return first == null;
  }
  
  public void enqueue(String item) {
    // Check if the item is null.
    if (item == null) {
      throw new NullPointerException();
    }
    
    // Save the old last because a new link will be added to the end of it which
    // just means we will be setting the next item to the newly created node.
    Node oldLast = last;
    
    // Create a new node to hold the new item. This overwrites the class member
    // variable.
    last = new Node();
    
    // Set the payload of the node with the new item.
    last.item = item;
    
    // Set the next item to null because it is now the new end of the list.
    last.next = null;
    
    // Attach the new node to the end of the list by setting the old last's
    // next item to point to the newly created node. Unless this is the queue
    // is empty.
    if (isEmpty()) {
      first = last;
    } else {
      oldLast.next = last;
    }
  }
  
  public String dequeue() {
    // Make sure the list isn't empty
    if (isEmpty()) {
      throw new NoSuchElementException();
    }
    
    // Save the payload from the first item of the linked list because the node
    // will be destroyed.
    String item = first.item;
    
    // Save the next node in the list as the first node effectively destroying
    // the first node in the list.
    first = first.next;
    
    // If this dequeue call emptied the list we need to set the last item to be
    // null.
    if (isEmpty()) {
      last = null;
    }
    
    // Return the item that was save from the now-destroyed node.
    return item;
  }
}
