package LinkedLists;

import LinkedLists.LinkedList.ListNode;

/*
        * LEETCODE: 2487. Remove Nodes From Linked List
        * https://leetcode.com/problems/remove-nodes-from-linked-list/
 */

public class RemoveNodesFromLinkedList {
    public static ListNode removeNodes(ListNode head) {
        // reverse the list to keep track of max value from right side of the list
        ListNode tail = reverseList(head), curr = tail;
        int max = curr.val;
        while (curr.next != null) {
            if (curr.next.val < max) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
                max = curr.val;
            }
        }
        // return the reverse list of reverse ordered list
        return reverseList(tail);
    }

    private static ListNode reverseList(ListNode head) {
        ListNode tail = null;
        while (head != null) {
            ListNode temp = tail;
            tail = head;
            head = head.next;
            tail.next = temp;
        }
        return tail;
    }

    // driver code
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addLast(1);
        list.addLast(6);
        list.addLast(6);
        list.addLast(3);
        list.addLast(2);
        list.addLast(4);
        list.addLast(5);
        list.display();
        list.head = removeNodes(list.head);
        list.display();

    }
}
