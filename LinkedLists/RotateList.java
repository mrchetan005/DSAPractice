package LinkedLists;

import LinkedLists.LinkedList.ListNode;

/*
        * LEETCODE: Rotate List
        * https://leetcode.com/problems/rotate-list/
 */

public class RotateList {
    public static ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        // find size and connect last node to head
        // So it'll become the cycle then rotate it required times - 1
        // make next node head then next node to null
        int size = 1;
        ListNode dummy = head;
        while (dummy.next != null) {
            dummy = dummy.next;
            size++;
        }
        // make list cycle by connecting last node to head
        dummy.next = head;
        // total rotations we needed size - k
        // but need not to rotate by more than size times
        // because if we want to rotate size times list will not be affected
        // so taken k % size to reduce time complexity
        k = size - (k % size);
        ListNode dummyHead = head;
        for (int i = 0; i < k - 1; i++) {
            dummyHead = dummyHead.next;
        }
        head = dummyHead.next;
        dummyHead.next = null;
        return head;
    }

    public static ListNode rotateRightWay2(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }

        int size = 1;
        ListNode dummy = head;
        while (dummy.next != null) {
            dummy = dummy.next;
            size++;
        }
        // first find size of the list
        k = k % size;
        ListNode slow = head, fast = head;
        // reach at (size - (k % size) - 1)th position
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while (slow != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        if (slow.next == null) {
            return head;
        }
        // Store the next position as newHead and make next null
        ListNode newHead = slow.next;
        slow.next = null;
        ListNode temp = newHead;
        // traverse till end of newHead
        while (temp.next != null) {
            temp = temp.next;
        }
        // and make its next = head
        temp.next = head;
        // and return newHead
        return newHead;
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
        int k = 2;
        list.head = rotateRight(list.head, k);
        list.display();
        list.head = rotateRightWay2(list.head, k);
        list.display();
    }
}
