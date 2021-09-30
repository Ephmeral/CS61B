public class LinkedListDeque<T> {
    private class ListNode {
        private T val;
        private ListNode prev;
        private ListNode next;
        public ListNode(T item, ListNode n, ListNode pre) {
            val = item;
            next = n;
            prev = pre;
        }
    }

    private ListNode head;
    private ListNode tail;
    private int size;

    public LinkedListDeque() {
        head = new ListNode((T)null, null, null);
        tail = head;
        size = 0;
    }

    public LinkedListDeque(T x) {
        head = new ListNode((T)null, null, null);
        head.next = new ListNode(x, null, head);
        tail = head.next;
        size = 1;
    }
    public void addFirst(T item) {
        head.next = new ListNode(item, head.next, head);
        size++;
    }

    public void addLast(T item) {
        tail.next = new ListNode(item, null, tail);
        tail = tail.next;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        ListNode p = head.next;
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println();
    }

    public T removeFirst() {
        if (size == 0) {
            return (T)null;
        }
        ListNode p;
        T tmp = head.next.val;
        p = head.next;
        if (size == 1) {
            head.next = null;
            tail = head;
        } else {
            head.next = p.next;
            p.next.prev = head;
            p.next = null;
            p.prev = null;
        }
        size--;
        return tmp;
    }

    public T removeLast() {
        T tmp;
        if (size == 0) {
            return (T)null;
        } else if (size == 1) {
            return removeFirst();
        } else {
            ListNode p = tail.prev;
            tmp = tail.val;
            p.next = null;
            tail.next = null;
            tail.prev = null;
            tail = p;
            size--;
        }
        return tmp;
    }

    public T get(int index) {
        ListNode p = head;
        if (index < 0 || index > size) {
            return null;
        }
        while (index >= 0) {
            p = p.next;
            index--;
        }
        return p.val;
    }

    public T getRecursive(int index) {
        ListNode p = head;
        if (index < 0 || index > size) {
            return null;
        }
        while (index >= 0) {
            p = p.next;
            index--;
        }
        return p.val;
    }
}
