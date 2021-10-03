public class LinkedListDeque<Item> implements Deque<Item> {
    private class ListNode {
        private Item val;
        private ListNode prev;
        private ListNode next;
        public ListNode(Item item, ListNode n) {
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

    @Override
    public void addFirst(Item item) {
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

    @Override
    public void addLast(Item item) {
        if (tail == null) {
            tail = head;
        }
        ListNode oldLast = tail;
        tail = new ListNode(item, null);
        oldLast.next = tail;
        tail.prev = oldLast;
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
        ListNode p = head.next;
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println();
    }

    @Override
    public Item removeFirst() {
        if (size == 0 || head.next == null) {
            return null;
        }
        ListNode oldHead = head;
        head = head.next;
        oldHead.next = null;
        oldHead.prev = null;
        Item tmp = head.val;
        size--;
        return tmp;
    }

    @Override
    public Item removeLast() {
        Item tmp;
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

    @Override
    public Item get(int index) {
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

    @Override
    public Item getRecursive(int index) {
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
