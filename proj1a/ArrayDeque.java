public class ArrayDeque<T> {
    private T[] items;
    private int head;
    private int tail;
    private int size;
    private int cap;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        head = 0;
        tail = -1;
        cap = 8;
    }

    private void resize(int n) {
        T[] old = (T[]) new Object[cap];
        int cnt = 0;
        for (int i = 0; i < cap; i++) {
            old[i] = items[i];
        }
        items = (T[]) new Object[n];
        System.arraycopy(old, 0, items, 0, tail);
        System.arraycopy(old, head, items, n - (cap - head), cap - head);
        head = n - (cap - head);
        cap = n;
    }

    public void addFirst(T item) {
        if (size == cap) {
            resize(cap * 2);
        }
        head = (head - 1 + cap) % cap;
        items[head] = item;
        size++;
    }

    public void addLast(T item) {
        if (size == cap) {
            resize(cap * 2);
        }
        items[++tail] = item;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        int p = head;
        while (p != tail) {
            System.out.print(items[p] + " ");
            p = (p + 1) % cap;
        }
        System.out.println();
    }

    public T removeFirst() {
        if (size == 0) {
            return (T)null;
        }
        T tmp = items[head];
        head = (head + 1) % cap;
        size--;
        while (cap > 16 && 4 * size < cap) {
            resize(cap / 2);
        }
        return tmp;
    }

    public T removeLast() {
        if (size == 0) {
            return (T)null;
        }
        size--;
        while (cap > 16 && 4 * size < cap) {
            resize(cap / 2);
        }
        return items[tail--];
    }

    public T get(int index) {
        if (index < 0 || index > size) {
            return null;
        }
        int p = head;
        while (index > 0) {
            p = (p + 1) % cap;
            index--;
        }
        return items[p];
    }

    private T getRecursive(int index) {
        if (index < 0 || index > size) {
            return null;
        }
        int p = head;
        while (index > 0) {
            p = (p + 1) % cap;
            index--;
        }
        return items[p];
    }
}
