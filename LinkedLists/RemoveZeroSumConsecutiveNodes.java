package LinkedLists;

import java.util.HashMap;

import LinkedLists.LinkedList.ListNode;

/*
    * LEETCODE: 1171. Remove Zero Sum Consecutive Nodes From Linked List
    * https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/
*/

/*
        input_: 1 3 2 -3 -2 5 5 -5 1
        output: 1 5 1
*/

public class RemoveZeroSumConsecutiveNodes {
    public static ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        HashMap<Integer, ListNode> seen = new HashMap<>();
        seen.put(0, dummy);
        int preSum = 0;
        for (ListNode i = dummy; i != null; i = i.next) {
            preSum += i.val;
            seen.put(preSum, i);
        }
        preSum = 0;
        for (ListNode i = dummy; i != null; i = i.next) {
            preSum += i.val;
            i.next = seen.get(preSum).next;
        }
        return dummy.next;
    }

    // driver code
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addLast(1);
        ll.addLast(3);
        ll.addLast(2);
        ll.addLast(-3);
        ll.addLast(-2);
        ll.addLast(5);
        ll.addLast(5);
        ll.addLast(-5);
        ll.addLast(1);

        ll.display();
        ll.head = removeZeroSumSublists(ll.head);
        ll.display();
    }
}
