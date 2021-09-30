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
            return null;
        }
        ListNode p = head.next;
        T tmp = p.val;
        if (size == 1) {
            head.next = null;
            tail = head;
        } else {
            head.next = p.next;
            if (p.next != null) {
                p.next.prev = head;
            }
        }
        size--;
        return tmp;
    }

    public T removeLast() {
        T tmp = (T) null;
        if (size == 0) {
            return null;
        } else if (size == 1) {
            return removeFirst();
        } else {
            ListNode p = tail.prev;
            tmp = tail.val;
            p.next = null;
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
