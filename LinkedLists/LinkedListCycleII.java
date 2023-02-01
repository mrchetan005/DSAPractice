package LinkedLists;

import LinkedLists.LinkedList.ListNode;

/*
        * LEETCODE: Linked List Cycle II
        * https://leetcode.com/problems/linked-list-cycle-ii/
 */

public class LinkedListCycleII {
    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode dummySlow = head;
                while (dummySlow != slow) {
                    slow = slow.next;
                    dummySlow = dummySlow.next;
                }
                return slow;
            }
        }
        return null;
    }

    // driver code
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addCirclular(5);
        // list.addCirclular(6);
        // list.addCirclular(7);
        // list.displayCircular();
        // list.display();
        list.head = detectCycle(list.head);
        list.displayCircular();
        System.out.println((list.head != null) ? "Cyclic" : "Linear");
    }
}
