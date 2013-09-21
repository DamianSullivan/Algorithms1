package edu.coursera.algorithms1.queues;

import edu.princeton.cs.introcs.StdOut;

import java.util.NoSuchElementException;

/*
 * An array implementation of a queue. Queues are First In First Out (FIFO).
 */
public class ArrayQueueOfStrings {

  String[] q;
  int N = 0;
  int head = 0;
  int tail = 0;

  public ArrayQueueOfStrings() {
    q = new String[1];
  }

  public boolean isEmpty() {
    return N == 0;
  }

  public void enqueue(String item) {
    // Check if the item is null.
    if (item == null) {
      throw new NullPointerException();
    }

    // Check to make sure the item will fit in the array, if not then resize.
    // Return the item that was save from the now-destroyed node.
    if (N == q.length) {
      StdOut.printf("Array queue too small %s, resizing to %s%n",
          N, 2 * q.length);
      resize(2 * q.length);
    }

    // Place the new item in the array using the tail variable as a cursor to
    // keep track of the current point in the array we are appending to.
    // tail++ means to use the value, then increment tail.
    q[tail++] = item;

    // Wrap around to reuse the empty slots at the beginning of the array.
    if (tail == q.length) {
      tail = 0;
    }

    // Update the size of the queue. This is to keep track of when to resize.
    N++;
  }

  public String dequeue() {
    // Make sure the list isn't empty
    if (isEmpty()) {
      throw new NoSuchElementException();
    }

    // Save the current item at the head of the array so we can destroy it.
    String item = q[head];

    // Destroy the head item to prevent loitering.
    q[head] = null;

    // Update the queue size now that the head item is gone.
    N--;

    // Advance the head cursor now that the first item is gone.
    head++;

    // If the head cursor is at the end, then wrap around to reuse the array
    // without having to resize it.
    if (head == q.length) {
      StdOut.printf("Head cursor %s reached the end of the array, "
          + "wrapping around. Head is now zero.%n", head);
      head = 0;
    }

    // Resize the array if it has become too small.
    if (N > 0 && N == q.length / 4) {
      StdOut.printf("Array stack too big at %s, resizing to %s%n",
          q.length, q.length / 2);
      resize(q.length / 2);
    }

    return item;
  }

  private void resize(int capacity) {
    // Create a new bigger array to copy the smaller array to.
    String[] copy = new String[capacity];

    // Copy the elements from the existing full array to the larger one just
    // created. Start copying from the old array at head and iterate until
    // queue size N leaving the rest of the resized array null between N and
    // q.length.
    for (int i = 0; i < N; i++) {
      copy[i] = q[(head + i) % q.length];
    }

    // Overwrite the array that was too small with the new larger array.
    q = copy;

    // Rest the head and tail cursors to match the resized array.
    head = 0;
    tail = N;
  }
}
