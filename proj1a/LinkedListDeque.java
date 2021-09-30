public class LinkedListDeque<T> {
    public class ListNode {
        public T val;
        public ListNode prev;
        public ListNode next;
        public ListNode (T item) {
            val = item;
            next = null;
            prev = null;
        }
    }

    private ListNode head;
    private ListNode tail;
    private int size;

    public LinkedListDeque() {
        head = new ListNode(null);
        tail = head;
        size = 0;
    }

    public void addFirst(T item){
        ListNode node = new ListNode(item);
        if (head.next == null) {
            head.next = node;
            node.prev = head;
            tail = node;
            node.next = null;
        } else {
            node.next = head.next;
            head.next = node;
            node.next.prev = node;
            node.prev = head;
        }

        size++;
    }

    public void addLast(T item) {
        ListNode node = new ListNode(item);
        tail.next = node;
        node.prev = tail;
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
        if (head.next == null) return head.val;
        ListNode p;
        T tmp = head.next.val;
        p = head.next;
        if (p.next == null) {
            head.next = null;
            tail = head;
        } else {
            head.next = p.next;
            p.next.prev = head;
        }
        size--;
        return tmp;
    }

    public T removeLast() {
        ListNode p = tail.prev;
        T tmp = tail.val;
        tail.next = null;
        tail.prev = null;
        tail = p;
        size--;
        return tmp;
    }

    public T get(int index) {
        ListNode p = head;
        if (index < 0 || index > size) {
            return null;
        }
        while (index > 0) {
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
        while (index > 0) {
            p = p.next;
            index--;
        }
        return p.val;
    }
}
