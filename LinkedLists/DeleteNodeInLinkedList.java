package LinkedLists;

import LinkedLists.LinkedList.ListNode;

/*
        * LEETCODE: 237. Delete Node In aA Linked List
        * https://leetcode.com/problems/delete-node-in-a-linked-list/
 */

public class DeleteNodeInLinkedList {
    public static void deleteNode(ListNode node) {
        /*
         * changing the value of current node to next node then updating curr node next
         * pointer with next node next pointer and next node next pointer point to null
         */
        ListNode nextNode = node.next;
        node.val = nextNode.val;
        node.next = nextNode.next;
        nextNode.next = null;
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
        list.addLast(7);
        list.display();
        deleteNode(list.head.next.next);
        list.display();
    }
}
