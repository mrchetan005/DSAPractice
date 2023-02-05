package LinkedLists;

import LinkedLists.LinkedList.ListNode;

/*
        * LEETCODE: 2. Add Two Numbers
        * https://leetcode.com/problems/add-two-numbers/
         
        * LEETCODE: 445. Add Two Numbers II
        * https://leetcode.com/problems/add-two-numbers-ii/

*/

public class addTwoNumbers {
    private static ListNode reverse(ListNode head) {
        ListNode rev = null;

        while (head != null) {
            ListNode temp = rev;
            rev = head;
            head = head.next;
            rev.next = temp;
        }

        return rev;
    }

    public static ListNode add(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode tail = head;
        int sum = 0;

        while (l1 != null || l2 != null) {
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            tail.next = new ListNode(sum % 10);
            tail = tail.next;
            sum /= 10;
        }

        if (sum == 1) {
            tail.next = new ListNode(1);
        }

        return head.next;
    }

    public static ListNode addTwoNumbersInList(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode revl1 = reverse(l1);
        ListNode revl2 = reverse(l2);

        ListNode add = add(revl1, revl2);

        return reverse(add);
    }

    // driver code
    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        LinkedList l2 = new LinkedList();
        l1.addLast(9);
        l1.addLast(2);
        l1.addLast(7);
        l2.addLast(9);
        l2.addLast(4);
        l2.addLast(3);
        l1.display();
        l2.display();
        l1.head = addTwoNumbersInList(l1.head, l2.head);
        l1.display();
    }
}
