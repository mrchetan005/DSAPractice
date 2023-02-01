package LinkedLists;

import LinkedLists.LinkedList.ListNode;

public class RemoveDuplicatesFromSortedList {

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode node = head;
        while (node != null && node.next != null) {
            if (node.val == node.next.val) {
                ListNode next = node.next;
                node.next = node.next.next;
                next.next = null;
            } else {
                node = node.next;
            }
        }
        return head;
    }

    // driver code
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(4);
        list.addLast(4);
        list.addLast(5);
        list.addLast(5);
        list.display();
        list.head = deleteDuplicates(list.head);
        list.display();
    }
}
