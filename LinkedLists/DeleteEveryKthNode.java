package LinkedLists;

import LinkedLists.LinkedList.ListNode;

/*
 * Problem Statement
    Given a linked list consisting of N nodes, your task is to delete every kth Node from the circular linked list until only one node is left. Also, print the intermediate lists
   Note:
    Sample Input and Output just show how a linked list will look depending on the questions. Do not copy-paste as it is in custom input
   Input
   User Task:
    Since this will be a functional problem, you don't have to take input. You just have to complete the function deleteK() that takes head node of circular linked list and the integer K as parameter.
    Constraints:
        1 <= K <= N <= 500
        1 <= Node. data<= 1000
   Output
    Print the intermediate nodes until one node is left as shown in example.
    Example
    Sample Input:-
    4 2
    1 2 3 4
    Sample Output:-
    1->2->3->4->1
    1->2->4->1
    2->4->2
    2->2
    
    Sample Input:-
    9 4
    1 2 3 4 5 6 7 8 9
    Sample Output:-
    1->2->3->4->5->6->7->8->9->1
    1->2->3->4->6->7->8->9->1
    1->2->3->4->6->7->8->1
    1->2->3->6->7->8->1
    2->3->6->7->8->2
    2->3->6->8->2
    2->3->8->2
    2->3->2
    2->2 
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
