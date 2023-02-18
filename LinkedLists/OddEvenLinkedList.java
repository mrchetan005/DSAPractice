package LinkedLists;

import LinkedLists.LinkedList.ListNode;

/*
    * LEETCODE: 328. Odd Even Linked List
    * https://leetcode.com/problems/odd-even-linked-list/
 */

/*
        input_: 1 -> 2 -> 3 -> 4 -> 5 -> null
        output: 1 -> 3 -> 5 -> 2 -> 4 -> null
 */

public class OddEvenLinkedList {
    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head, nex = cur.next, evenStart = nex;
        while (nex != null && nex.next != null) {
            cur.next = nex.next;
            nex.next = nex.next.next;
            cur = cur.next;
            nex = nex.next;
        }
        cur.next = evenStart;
        return head;
    }

    // driver code
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        for (int i = 1; i <= 5; i++) {
            ll.addLast(i);
        }
        ll.display();
        ll.head = oddEvenList(ll.head);
        ll.display();
    }
}
