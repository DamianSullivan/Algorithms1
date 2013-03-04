import java.util.NoSuchElementException;

/*
 * A linked list implementation of a queue. Queues are Last In First Out (LIFO).
 */
public class LinkedStackOfStrings {

  String[] q;
  int N = 0;

  public LinkedStackOfStrings() {
    q = new String[1];
  }

  public boolean isEmpty() {
    return N == 0;
  }

  public void push(String item) {
    // Check if the item is null.
    if (item == null) {
      throw new NullPointerException();
    }

    // Check to make sure the item will fit in the array, if not then resize.
    // Return the item that was save from the now-destroyed node.
    if (N == q.length) {
      StdOut.printf("Array stack too small at %s, resizing to %s%n",
          q.length, 2 * q.length);
      resize (2 * q.length);
    }

    // Place the new item in the array using N to keep track of the current
    // point in the array we are appending to. N++ means to use the value, then
    // increment N.
    StdOut.printf("PUSH: %s, stack cursor is %s, will increment to %s%n",
        item, N, N + 1);
    q[N++] = item;
  }

  public String pop() {
    // Make sure the list isn't empty
    if (isEmpty()) {
      throw new NoSuchElementException();
    }

    // When the array is 1/4 full, cut it in half
    if (N > 0 && N == q.length / 4) {
      StdOut.printf("Array stack too big at %s, resizing to %s%n",
          q.length, q.length / 2);
      resize(q.length / 2);
    }

    StdOut.printf(
        "POP: %s, stack cursor is %s, will decrement to %s%n",
        q[N - 1], N, N - 1);
    
    
    // Save the item for returning and decrement the cursor
    String item = q[--N];
    
    // To prevent loitering we must save the item and clear the object from the
    // array. This also is used in resizing to not copy items that are null.
    q[N] = null;
    
    return item;
  }

  public void resize(int capacity) {
    // Create a new bigger array to copy the smaller array to.
    String[] copy = new String[capacity];

    // Copy the elements from the existing full array to the larger one just
    // created.
    for (int i = 0; i < q.length; i++) {
      // If we encounter a null then we are done copying the array.
      if (q[i] == null) {
        break;
      }
      copy[i] = q[i];
    }

    // Overwrite the array that was too small with the new larger array.
    q = copy;
  }
}
