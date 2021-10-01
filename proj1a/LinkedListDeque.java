public class LinkedListDeque<T> {
    private class ListNode {
        private T val;
        private ListNode prev;
        private ListNode next;
        public ListNode(T item, ListNode n) {
            val = item;
            next = n;
            prev = null;
        }
    }

    private ListNode head;
    private ListNode tail;
    private int size;

    public LinkedListDeque() {
        head = new ListNode(null, null);
        tail = head;
        size = 0;
    }

    public void addFirst(T item) {
        ListNode r = head.next;
        if (r != null) {
            head.next = new ListNode(item, r);
            r.prev = head.next;
            head.next.prev = head;
        } else {
            head.next = new ListNode(item, r);
            head.next.prev = head;
        }

        if (size == 0) {
            tail = head.next;
        }
        size++;
    }

    public void addLast(T item) {
        if (tail == null) {
            tail = head;
        }
        ListNode oldLast = tail;
        tail = new ListNode(item, null);
        oldLast.next = tail;
        tail.prev = oldLast;
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

    private void printReverse() {
        ListNode p = tail;
        while (p != head) {
            System.out.print(p.val + " ");
            p = p.prev;
        }
        System.out.println();
    }

    public T removeFirst() {
        if (size == 0 || head.next == null) {
            return null;
        }
        ListNode oldHead = head;
        head = head.next;
        oldHead.next = null;
        oldHead.prev = null;
        T tmp = head.val;
        size--;
        return tmp;
    }

    public T removeLast() {
        T tmp;
        if (size == 0) {
            return null;
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
    /* main 函数用来测试
    public static void main(String[] args) {
        LinkedListDeque<Integer> ll = new LinkedListDeque<Integer>();
         // addLast 测试
        ll.addLast(0);
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.printDeque();
        ll.printReverse();
        System.out.println("size = " + ll.size()); // 4

        ll.removeLast();
        System.out.println("last = 0 my is " + ll.removeLast());
        ll.printDeque();        // 0 1
        System.out.println("size = " + ll.size()); // 2

        ll.addLast(0);
        System.out.println("first is 0, my is " + ll.removeFirst()); // ==> 0
        ll.addLast(2);
        ll.size();
        System.out.println("last is 2, my is " + ll.removeLast());  // ==> 2
        ll.addFirst(5);
        System.out.println("first is 5, my is " + ll.removeFirst());  // ==> 5
        ll.addFirst(7);
        ll.addLast(8);
        ll.addLast(9);
        ll.addLast(10);
        System.out.println("first is 7, my is " + ll.removeFirst());    // ==> 7
    }
    */
}