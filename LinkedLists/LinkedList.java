package LinkedLists;

class LinkedList {
    ListNode head;
    ListNode tail;

    public LinkedList() {

    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public void addLast(int val) {
        ListNode node = new ListNode(val);
        if (head == null) {
            head = node;
            tail = node;
            return;
        }
        tail.next = node;
        tail = node;
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.print("null");
        System.out.println();
    }

    public void addCirclular(int value) {
        ListNode node = new ListNode(value);
        if (this.head == null) {
            this.head = node;
            this.tail = node;
            return;
        }
        this.tail.next = node;
        node.next = this.head;
        this.tail = node;
    }

    public void displayCircular() {
        ListNode node = this.head;
        if (this.head != null) {
            do {
                System.out.print(node.val + " -> ");
                node = node.next;
            } while (node != this.head);
            System.out.print("Cycle");
        } else {
            System.out.println("null");
        }
        System.out.println();
    }

}
