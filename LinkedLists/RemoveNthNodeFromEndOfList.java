package LinkedLists;

import LinkedLists.LinkedList.ListNode;

/*
        * LEETCODE: Remove Nth Node From End Of List
        * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */

public class RemoveNthNodeFromEndOfList {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyStart = new ListNode(0);
        ListNode slow = dummyStart, fast = dummyStart;
        dummyStart.next = head;
        // move fast pointer n + 1 steps
        for (int i = 0; i < n + 1; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummyStart.next;
    }

    // driver code
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);
        list.display();
        list.head = removeNthFromEnd(list.head, 1);
        list.display();
    }
}
