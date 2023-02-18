package LinkedLists;

import java.util.*;

import LinkedLists.LinkedList.ListNode;

/*
    * LEETCODE: 1019. Next Greater Node In Linked List
    * https://leetcode.com/problems/next-greater-node-in-linked-list/
 */

public class NextGreaterNodeInLinkedList {
    public static int[] nextLargerNodesWithStack(ListNode head) {
        // tc => O(n) & sc=> O(n)
        if (head == null) {
            return new int[] {};
        }
        ListNode temp = head;
        int n = size(head);
        Stack<Integer> stack = new Stack<>();
        int[] nextGreater = new int[n];
        temp = reverse(head);
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= temp.val) {
                stack.pop();
            }
            nextGreater[i] = stack.isEmpty() ? 0 : stack.peek();
            stack.push(temp.val);
            temp = temp.next;
        }
        return nextGreater;
    }

    public static int[] nextLargerNodesWithoutStack(ListNode head) {
        // tc => O(n) & sc => O(1)
        if (head == null) {
            return new int[] {};
        }
        int n = size(head);
        int[] nextGreater = new int[n];
        // start with reversing the list i.e. from end
        ListNode cur = reverse(head);
        // take pre pointer to store the values from behind in rev order
        ListNode pre = null;
        for (int i = n - 1; cur != null && i >= 0; i--) {
            ListNode nex = cur.next;
            // pre.val is less or equal then keep removing that node from pre
            while (pre != null && pre.val <= cur.val) {
                pre = pre.next;
            }
            nextGreater[i] = pre == null ? 0 : pre.val;
            // keep storing the list in reverse order in pre
            cur.next = pre;
            pre = cur;
            cur = nex;
        }
        return nextGreater;
    }

    private static int size(ListNode head) {
        ListNode temp = head;
        int size = 0;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        return size;
    }

    private static ListNode reverse(ListNode head) {
        ListNode rev = head;
        while (head != null) {
            ListNode temp = rev;
            rev = head;
            head = head.next;
            rev.next = temp;
        }
        return rev;
    }

    // driver code
    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        l1.addLast(2);
        l1.addLast(7);
        l1.addLast(4);
        l1.addLast(3);
        l1.addLast(5);
        int ans1[] = nextLargerNodesWithStack(l1.head);
        System.out.println(Arrays.toString(ans1));

        LinkedList l2 = new LinkedList();
        l2.addLast(2);
        l2.addLast(7);
        l2.addLast(4);
        l2.addLast(3);
        l2.addLast(5);
        int ans2[] = nextLargerNodesWithoutStack(l2.head);
        System.out.println(Arrays.toString(ans2));
    }
}
