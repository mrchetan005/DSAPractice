package LinkedLists;

import LinkedLists.LinkedList.ListNode;

/*
 * LEETCODE: 234. Palindrome Linked List
 * https://leetcode.com/problems/palindrome-linked-list/
 */

public class PalindromeLinkedList {

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;

        // Finding out the middle of the list and reverse first n / 2 elements
        // of the list by setting next to previous for each node.
        // If fast == null then the list contains of even
        // number of nodes otherwise of odd one.
        // Slow pointer always points at node with index n / 2 + 1.
        ListNode slow = head, fast = head, rev = null;
        while (fast != null && fast.next != null) {
            ListNode temp = rev;
            rev = slow;
            slow = slow.next;
            fast = fast.next.next;
            rev.next = temp;
        }

        // If the list contains of odd number of elements,
        // then move slow (head of the right part of the list) to one position.
        if (fast != null) {
            slow = slow.next;
        }

        // Compare these 2 lists element by element.
        while (slow != null) {
            if (rev.val != slow.val) {
                return false;
            }
            rev = rev.next;
            slow = slow.next;
        }

        return true;
    }

    // driver code
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(3);
        list.addLast(2);
        list.addLast(1);
        System.out.println(isPalindrome(list.head));
    }
}
