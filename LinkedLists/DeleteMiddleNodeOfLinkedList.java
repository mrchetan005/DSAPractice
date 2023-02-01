package LinkedLists;

import LinkedLists.LinkedList.ListNode;

/*
        * LEETCODE: Delete The Middle Node Of A Linked List
        * https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/
 */

public class DeleteMiddleNodeOfLinkedList {
    public static ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = null, fast = head;
        while (fast != null && fast.next != null) {
            slow = (slow == null) ? head : slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
        return head;
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
        list.head = deleteMiddle(list.head);
        list.display();
    }
}
