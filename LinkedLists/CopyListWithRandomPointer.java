package LinkedLists;

import LinkedLists.RandomList.Node;

/*
        * LEETCODE: 138. Copy List With Random Pointer
        * https://leetcode.com/problems/copy-list-with-random-pointer/
 */
class RandomList {
    Node head;

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}

public class CopyListWithRandomPointer {
    public static Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        // First round: make copy of each node,
        // and link them together side-by-side in a single list.
        Node iter = head, next;
        while (iter != null) {
            Node clone = new Node(iter.val);
            next = iter.next;
            iter.next = clone;
            clone.next = next;
            iter = next;
        }
        iter = head;

        // Second round: assign random pointers for the copy nodes.
        while (iter != null) {
            if (iter.random != null) {
                iter.next.random = iter.random.next;
            }
            iter = iter.next.next;
        }

        // Third round: restore the original list, and extract the copy list.
        Node original = head, clone = head.next, cloneAns = original.next;
        while (clone.next != null) {
            Node nextOriginal = original.next.next;
            Node nextClone = clone.next.next;

            // extract the copy
            original.next = nextOriginal;
            clone.next = nextClone;
            clone = nextClone;

            // restore the original list
            original = nextOriginal;
        }
        original.next = original.next.next;
        return cloneAns;
    }
}
