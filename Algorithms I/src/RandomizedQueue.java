import java.util.Iterator;
import java.util.NoSuchElementException;

/*
 * Randomized queue. A randomized queue is similar to a stack or queue, except
 * that the item removed is chosen uniformly at random from items in the data
 * structure. Create a generic data type RandomizedQueue that implements the
 * following API:
 *
 *  Throw a java.lang.NullPointerException if the client attempts to add a null
 *  item; throw a java.util.NoSuchElementException if the client attempts to
 *  sample or dequeue an item from an empty randomized queue; throw a
 *  java.lang.UnsupportedOperationException if the client calls the remove()
 *  method in the iterator; throw a java.util.NoSuchElementException if the
 *  client calls the next() method in the iterator and there are no more items
 *  to return.
 *
 *  Your randomized queue implementation should support each randomized queue
 *  operation (besides creating an iterator) in constant amortized time and use
 *  space proportional to the number of items currently in the queue. That is,
 *  any sequence of M randomized queue operations (starting from an empty queue)
 *  should take at most cM steps in the worst case, for some constant c.
 *  Additionally, your iterator implementation should support construction in
 *  time linear in the number of items and it should support the operations
 *  next() and hasNext() in constant worst-case time; you may use a linear
 *  amount of extra memory per iterator. The order of two or more iterators to
 *  the same randomized queue should be mutually independent; each iterator
 *  must maintain its own random order.
 *
 *  Performance Requirements:
 *  Non-iterator operations     Constant amortized time
 *  Iterator constructor        linear in current # of items
 *  Other iterator operations   Constant worst-case time
 *  Non-iterator memory use     Linear in current # of items
 *  Memory per iterator         Constant
 */

public class RandomizedQueue<Item> implements Iterable<Item> {

  private Item[] q;
  private int N = 0;

  public RandomizedQueue() {
    q = (Item[]) new Object[1];
  }

  public boolean isEmpty() {
    return N == 0;
  }

  public int size() {
    return N;
  }

  public void enqueue(Item item) {
    // Check if the item is null.
    if (item == null) {
      throw new NullPointerException();
    }

    // Check to make sure the item will fit in the array, if not then resize.
    // Return the item that was save from the now-destroyed node.
    if (N == q.length) {
      resize(2 * q.length);
    }

    // Place the new item in the array using the tail variable as a cursor to
    // keep track of the current point in the array we are appending to.
    // tail++ means to use the value, then increment.
    q[N++] = item;
  }

  public Item dequeue() {
    // Make sure the list isn't empty
    if (isEmpty()) {
      throw new NoSuchElementException();
    }

    // Save a random item in the array and swap it for the head item.
    int randomIndex = StdRandom.uniform(N);
    Item randomItem = q[randomIndex];
    q[randomIndex] = q[N-1];

    // Destroy the last item to prevent loitering and decrement the size too.
    q[--N] = null;

    // Resize the array if it has become too small.
    if (N > 0 && N == q.length / 4) {
      resize(q.length / 2);
    }

    return randomItem;
  }

  private void resize(int capacity) {
    Item[] copy = (Item[]) new Object[capacity];
    for (int i = 0; i < N; i++) {
      copy[i] = q[i];
    }
    q = copy;
  }

  public Item sample() {
    if (isEmpty()) {
      throw new java.util.NoSuchElementException();
    }
    return q[StdRandom.uniform(N)];
  }

  public Iterator<Item> iterator() {
    return new RandomizedQueueIterator();
  }

  private class RandomizedQueueIterator implements Iterator<Item> {
    private int itemsToRead;
    private int[] randomIndex;

    public RandomizedQueueIterator() {
      itemsToRead = N;
      randomIndex = new int[itemsToRead];
      for (int i = 0; i < itemsToRead; i++) {
        randomIndex[i] = i;
      }
      StdRandom.shuffle(randomIndex);
    }

    @Override
    public boolean hasNext() {
      return itemsToRead > 0;
    }

    @Override
    public Item next() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }
      Item item = q[randomIndex[--itemsToRead]];
      return item;
    }

    @Override
    public void remove() {
      throw new UnsupportedOperationException();
    }
  }
}