public class ArrayDeque<Item> implements Deque<Item> {
    private Item[] items;
    private int head;
    private int tail;
    private int size;
    private int cap;

    public ArrayDeque() {
        items = (Item[]) new Object[8];
        size = 0;
        head = 0;
        tail = 0;
        cap = 8;
    }

    public void resize(int n) {
        Item[] old = (Item[]) new Object[cap];
        int cnt = 0;
        System.arraycopy(old, 0, items, 0, cap);
        items = (Item[]) new Object[n];
        if (head >= tail) {
            System.arraycopy(old, 0, items, 0, tail);
            System.arraycopy(old, head, items, n - (cap - head), cap - head);
            head = n - (cap - head);
        } else {
            System.arraycopy(old, head, items, 0, tail - head);
            tail = tail - head;
            head = 0;
        }
        cap = n;
    }

    @Override
    public void addFirst(Item item) {
        if (size == cap) {
            resize(cap * 2);
        }
        head = (head - 1 + cap) % cap;
        items[head] = item;
        size++;
    }


    @Override
    public void addLast(Item item) {
        if (size == cap) {
            resize(cap * 2);
        }
        items[tail] = item;
        tail = (tail + 1) % cap;
        size++;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        int p = head;
        while (p != tail) {
            System.out.print(items[p] + " ");
            p = (p + 1) % cap;
        }
        System.out.println();
    }

    @Override
    public Item removeFirst() {
        if (size == 0) {
            return null;
        }
        Item tmp = items[head];
        head = (head + 1) % cap;
        size--;
        while (cap > 16 && 4 * size < cap) {
            resize(cap / 2);
        }
        return tmp;
    }

    @Override
    public Item removeLast() {
        if (size == 0) {
            return null;
        }
        size--;
        Item tmp = items[(tail - 1 + cap) % cap];
        tail = (tail - 1 + cap) % cap;
        while (cap > 16 && 4 * size < cap) {
            resize(cap / 2);
        }
        return tmp;
    }

    @Override
    public Item get(int index) {
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

    @Override
    public Item getRecursive(int index) {
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
