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

  public Deque() {
    // construct an empty deque
  }

  public boolean isEmpty() {
    // is the deque empty?
    return true;
  }

  public int size() {
    // return the number of items on the deque
    return 0;
  }

  public void addFirst(Item item) {
    // insert the item at the front
  }

  public void addLast(Item item) {
    // insert the item at the end
  }

  public Item removeFirst() {
    // delete and return the item at the front
  }

  public Item removeLast() {
    // delete and return the item at the end    
  }

  public Iterator<Item> iterator() {
    // return an iterator over items in order from front to end
  }
}