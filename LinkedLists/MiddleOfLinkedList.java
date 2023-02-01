package LinkedLists;

import LinkedLists.LinkedList.ListNode;

/*
        * LEETCODE: 876Middle of the Linked List
        * https://leetcode.com/problems/middle-of-the-linked-list/
 */

public class MiddleOfLinkedList {
    public static ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
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
        list.addLast(7);
        list.display();
        list.head = middleNode(list.head);
        list.display();
    }
}
