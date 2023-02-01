package LinkedLists;

import LinkedLists.LinkedList.ListNode;

/*
        * LEETCODE: 143. Reorder List
        * https://leetcode.com/problems/reorder-list/
*/

public class ReorderList {

    private static ListNode getMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static ListNode reverseList(ListNode head) {
        ListNode rev = null;
        while (head != null) {
            ListNode temp = rev;
            rev = head;
            head = head.next;
            rev.next = temp;
        }
        return rev;
    }

    public static void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        ListNode mid = getMiddle(head);
        ListNode f = head, s = reverseList(mid);
        while (f != null && s != null) {
            ListNode temp = f.next;
            f.next = s;
            f = temp;
            temp = s.next;
            s.next = f;
            s = temp;
        }
        if (f != null) {
            f.next = null;
        }
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
        reorderList(list.head);
        list.display();
    }
}
