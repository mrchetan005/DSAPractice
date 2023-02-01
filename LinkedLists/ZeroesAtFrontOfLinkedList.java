package LinkedLists;

import LinkedLists.LinkedList.ListNode;

/*
    * GFG: Move all zeros to the front of the linked list
    * https://practice.geeksforgeeks.org/problems/move-all-zeros-to-the-front-of-the-linked-list/1
 */

public class ZeroesAtFrontOfLinkedList {
    static public ListNode moveZeroes(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode temp = head.next, prev = head;
        while (temp != null) {
            if (temp.val != 0) {
                // disconnect node from its curr position
                // connect prev.next position to curr.next position
                ListNode curr = temp;
                temp = temp.next;
                prev.next = temp;

                // connect curr node to head and make it head
                curr.next = head;
                head = curr;
            } else {
                // keep moving prev along with temp
                prev = temp;
                temp = temp.next;
            }
        }
        return head;
    }

    // driver code
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(0);
        list.addLast(4);
        list.addLast(5);
        list.addLast(0);
        list.display();
        list.head = moveZeroes(list.head);
        list.display();

    }
}
