package LinkedLists;

import LinkedLists.LinkedList.ListNode;

/*
        * LEETCODE: 206. Reverse Linked List
        * https://leetcode.com/problems/reverse-linked-list/
 */

public class ReverseLinkedList {
    public static ListNode reverseList(ListNode head) {
        ListNode rev = null;
        while (head != null) {
            ListNode temp = rev;
            rev = head;
            head = head.next;
            rev.next = temp;
        }
        return rev;
    }

    private static ListNode reverseListRec(ListNode head, ListNode dummyHead) {
        if (head == null) {
            return dummyHead;
        }
        ListNode next = head.next;
        head.next = dummyHead;
        return reverseListRec(next, head);

    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);
        list.display();
        list.head = reverseList(list.head);
        list.display();
        list.head = reverseListRec(list.head, null);
        list.display();

    }
}
