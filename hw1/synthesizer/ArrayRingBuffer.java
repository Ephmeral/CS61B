package synthesizer;
import java.util.Iterator;

public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T> {
    /* Index for the next dequeue or peek. */
    private int first;            // index for the next dequeue or peek
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        //  Create new array with capacity elements.
        //       first, last, and fillCount should all be set to 0.
        //       this.capacity should be set appropriately. Note that the local variable
        //       here shadows the field we inherit from AbstractBoundedQueue, so
        //       you'll need to use this.capacity to set the capacity.
        rb = (T[]) new Object[capacity];
        first = 0;
        last = 0;
        fillCount = 0;
        this.capacity = capacity;
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    public void enqueue(T x) {
        //  Enqueue the item. Don't forget to increase fillCount and update last.
        if (isFull()) {
            throw new RuntimeException("Ring buffer underflow");
        }
        rb[last] = x;
        last++;
        fillCount++;
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    public T dequeue() {
        //  Dequeue the first item. Don't forget to decrease fillCount and update last
        if (isEmpty()) {
            throw new RuntimeException("Ring buffer underflow");
        }
        T tmp = rb[first];
        System.arraycopy(rb, 1, rb,  0, rb.length - 1);
        fillCount--;
        last--;
        return tmp;
    }

    /**
     * Return oldest item, but don't remove it.
     */
    public T peek() {
        //  Return the first item. None of your instance variables should change.
        if (isEmpty()) {
            throw new RuntimeException("Ring buffer underflow");
        }
        return rb[first];
    }

    //  When you get to part 5, implement the needed code to support iteration.
    public Iterator<T> iterator() {
        return new ArrayRingBufferIterator();
    }

    private class ArrayRingBufferIterator implements Iterator<T> {
        private int wizPos;

        public ArrayRingBufferIterator() {
            wizPos = 0;
        }

        public boolean hasNext() {
            return wizPos < fillCount;
        }

        public T next() {
            T returnItem = rb[wizPos];
            wizPos += 1;
            return returnItem;
        }
    }
    public static void main(String[] args) {
        ArrayRingBuffer<Integer> aset = new ArrayRingBuffer<>(5);
        aset.enqueue(5);
        aset.enqueue(23);
        aset.enqueue(42);

        //iteration
        for (int i : aset) {
            System.out.println(i);
        }
    }
}
