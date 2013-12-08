package edu.dsullivan.algorithms.queues;
import java.util.Iterator;
import java.util.NoSuchElementException;

/*
 *  Dequeue. A double-ended queue or deque (pronounced "deck") is a
 *  generalization of a stack and a queue that supports inserting and removing
 *  items from either the front or the back of the data structure.
 *  Create a generic data type Deque that implements the following API:
 *
 *  Throw a java.lang.NullPointerException if the client attempts to add a
 *  null item; throw a java.util.NoSuchElementException if the client attempts
 *  to remove an item from an empty deque; throw a
 *  java.lang.UnsupportedOperationException if the client calls the remove()
 *  method in the iterator; throw a java.util.NoSuchElementException if the
 *  client calls the next() method in the iterator and there are no more items
 *  to return.
 *
 *  Your deque implementation should support each deque operation in constant
 *  worst-case time and use space proportional to the number of items
 *  currently in the deque. Additionally, your iterator implementation should
 *  support the operations next() and hasNext() (plus construction) in
 *  constant worst-case time and use a constant amount of extra space per
 *  iterator.
 *
 * Performance Requirements:
 * Non-iterator operations   Constant worst-case time
 * Iterator constructor      Constant worst-case time
 * Other iterator operations Constant worst-case time
 * Non-iterator memory use   Linear in current # of items
 * Memory per iterator       Constant
 */
public class Deque<Item> implements Iterable<Item> {

  private Node first;
  private Node last;
  private int size = 0;

  private class Node {
    private Item item;
    private Node next;
    private Node prev;
  }

  public Deque() {
    // construct an empty deque
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public int size() {
    // return the number of items on the deque
    return size;
  }

  public void addFirst(Item item) {
    // insert the item at the front

    // Check if the item is null.
    if (item == null) {
      throw new NullPointerException();
    }

    Node oldFirst = first;

    first = new Node();
    first.item = item;
    if (isEmpty()) {
      first.next = null;
      last = first;
    } else {
      first.next = oldFirst;
      oldFirst.prev = first;
    }
    size++;
  }

  public void addLast(Item item) {
    // insert the item at the end

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
      last.prev = null;
      first = last;
    } else {
      last.prev = oldLast;
      oldLast.next = last;
    }
    size++;
  }

  public Item removeFirst() {
    // delete and return the item at the front
    // Make sure the list isn't empty
    if (isEmpty()) {
      throw new NoSuchElementException();
    }

    // Save the payload from the first item of the linked list because the node
    // will be destroyed.
    Item item = first.item;

    // Save the next node in the list as the first node effectively destroying
    // the first node in the list.
    first = first.next;
    size--;

    // If this dequeue call emptied the list we need to set the last item to be
    // null.
    if (isEmpty()) {
      last = null;
    }

    // Return the item that was saved from the now-destroyed node.
    return item;
  }

  public Item removeLast() {
    // delete and return the item at the front
    // Make sure the list isn't empty
    if (isEmpty()) {
      throw new NoSuchElementException();
    }

    // Save the payload from the last item of the linked list because the node
    // will be destroyed.
    Item item = last.item;

    // Set the tail to the previous last node effectively destroying
    // the last node in the list.
    last = last.prev;
    size--;

    // If this removeLast call emptied the list we need to set the last item to be
    // null.
    if (isEmpty()) {
      first = null;
    }

    // Return the item that was saved from the now-destroyed node.
    return item;
  }

  public Iterator<Item> iterator() {
    // return an iterator over items in order from front to end
    return new DequeueIterator();
  }

  private class DequeueIterator implements Iterator<Item> {
    private Node current = first;

    @Override
    public boolean hasNext() {
      return current != null;
    }

    @Override
    public Item next() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }
      Item item = current.item;
      current = current.next;
      return item;
    }

    @Override
    public void remove() {
      throw new UnsupportedOperationException();
    }
  }
}