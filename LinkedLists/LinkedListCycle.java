package LinkedLists;

import LinkedLists.LinkedList.ListNode;

/*
        * LEETCODE: Linked List Cycle
        * https://leetcode.com/problems/linked-list-cycle/
 */

public class LinkedListCycle {
    public static boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

    // driver code
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addCirclular(4);
        list.addCirclular(5);
        list.addCirclular(6);
        list.displayCircular();
        System.out.println(hasCycle(list.head));
    }
}
