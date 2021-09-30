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
        tail = 0;
        cap = 8;
    }

    private void resize(int n) {
        T[] newitems = (T[]) new Object[n];
        int cnt = 0;
        for (int i = head; i != tail; i = (i + cap) % cap) {
            newitems[cnt++] = items[i];
        }
        items = newitems;
        size = n;
        head = 0;
        tail = cnt;
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
        items[tail] = item;
        tail++;
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
        if (size < cap / 4 * 3) {
            resize(cap / 4 * 3);
        }
        return tmp;
    }

    public T removeLast() {
        if (size == 0) {
            return (T)null;
        }
        size--;
        if (size < cap / 4 * 3) {
            resize(cap / 4 * 3);
        }
        return items[--tail];
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
