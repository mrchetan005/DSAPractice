package LinkedLists;

import LinkedLists.LinkedList.ListNode;

/*
        * LEETCODE: Swapping Nodes In A Linked List
        * https://leetcode.com/problems/swapping-nodes-in-a-linked-list/
 */

public class SwappingNodesInLinkedList {
    public static ListNode swapNodes(ListNode head, int k) {
        ListNode n1 = null, n2 = null;
        // first go upto kth node, stop n1 at kth node
        // and start n2 moving, it'll reach at kth node from end
        for (ListNode p = head; p != null; p = p.next) {
            n2 = (n2 == null) ? null : n2.next;
            if (--k == 0) {
                n1 = p;
                n2 = head;
            }
        }
        // swap the values
        int temp = n1.val;
        n1.val = n2.val;
        n2.val = temp;

        return head;
    }

    // driver code
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.display();
        list.head = swapNodes(list.head, 2);
        list.display();
    }
}
