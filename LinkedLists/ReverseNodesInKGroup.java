package LinkedLists;

import LinkedLists.LinkedList.ListNode;

/*
        * LEETCODE: 25. Reverse Nodes In K-Group
        * https://leetcode.com/problems/reverse-nodes-in-k-group/

        * Input:  1->2->3->4->5->6->7->8->null  k=3
        * Output: 3->2->1->6->5->4->7->8->null
 */

public class ReverseNodesInKGroup {
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }
        ListNode dmmy = new ListNode(0);
        dmmy.next = head;
        ListNode cur = dmmy, nex = dmmy, pre = dmmy;
        int cntOfNodes = 0;
        // count thr length of the list
        while (cur.next != null) {
            cur = cur.next;
            cntOfNodes++;
        }

        // reverse the list in n/k groups
        while (cntOfNodes >= k) {
            cur = pre.next;
            nex = cur.next;
            // change k-1 node's next in reverse order
            for (int i = 1; i < k; i++) {
                cur.next = nex.next;
                nex.next = pre.next;
                pre.next = nex;
                nex = cur.next;
            }
            pre = cur;
            // reduce the group of k
            cntOfNodes -= k;
        }
        return dmmy.next;
    }

    // driver code
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        for (int i = 1; i <= 8; i++) {
            ll.addLast(i);
        }
        ll.display();
        ll.head = reverseKGroup(ll.head, 3);
        ll.display();
    }
}
