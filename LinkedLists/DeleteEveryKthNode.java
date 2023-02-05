package LinkedLists;

import LinkedLists.LinkedList.ListNode;

/*
 * 
 */

public class DeleteEveryKthNode {
    static void printList(ListNode head) {
        if (head == null)
            return;
        ListNode temp = head;
        do {
            System.out.print(temp.val + "->");
            temp = temp.next;
        } while (temp != head);
        System.out.println(head.val);
    }

    static ListNode deleteK(ListNode head_ref, int k) {
        ListNode head = head_ref;

        // If list is empty, simply return.
        if (head == null)
            return null;

        // take two pointers - current and previous
        ListNode curr = head, prev = null;
        while (true) {

            // Check if Node is the only Node
            // If yes, we reached the goal, therefore return.
            if (curr.next == head && curr == head)
                break;

            // Print intermediate list.
            printList(head);

            // If more than one Node present in the list,
            // Make previous pointer point to current
            // Iterate current pointer k times,
            // i.e. current Node is to be deleted.
            for (int i = 0; i < k; i++) {
                prev = curr;
                curr = curr.next;
            }

            // If Node to be deleted is head
            if (curr == head) {
                prev = head;
                while (prev.next != head) {
                    prev = prev.next;
                }
                head = curr.next;
                prev.next = head;
                head_ref = head;
            }

            // If Node to be deleted is last Node.
            else if (curr.next == head) {
                prev.next = head;
            } else {
                prev.next = curr.next;
            }
        }
        return head;
    }
}
