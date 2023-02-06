package LinkedLists;

import java.util.*;

import LinkedLists.LinkedList.ListNode;

public class IntersectionOfTwoLinkedLists {
    public static ListNode getIntersectionNodeBruteForce(ListNode headA, ListNode headB) {
        // tc => O(n*m) & sc => O(1)
        ListNode tempB = headB;
        while (tempB != null) {
            ListNode tempA = headA;
            while (tempA != null) {
                if (tempA == tempB) {
                    return tempA;
                }
                tempA = tempA.next;
            }
            tempB = tempB.next;
        }
        return null;
    }

    public static ListNode getIntersectionNodeBetter(ListNode headA, ListNode headB) {
        // tc => O(m) & sc => O(n)
        ListNode tempA = headA, tempB = headB;
        HashSet<ListNode> set = new HashSet<>();
        while (tempA != null) {
            set.add(tempA);
            tempA = tempA.next;
        }
        while (tempB != null) {
            if (set.contains(tempB)) {
                return tempB;
            }
            tempB = tempB.next;
        }
        return null;
    }

    public static ListNode getIntersectionNodeOptimal1(ListNode headA, ListNode headB) {
        // tc => O(n+m) & sc => O(1)
        ListNode tempA = headA, tempB = headB;
        int sizeA = 0, sizeB = 0;
        while (tempA != null) {
            sizeA++;
            tempA = tempA.next;
        }
        while (tempB != null) {
            sizeB++;
            tempB = tempB.next;
        }

        tempA = headA;
        tempB = headB;
        int diff = sizeA - sizeB;
        if (diff > 0) {
            while (tempA != null && diff-- > 0) {
                tempA = tempA.next;
            }
        } else if (diff < 0) {
            diff = -diff;
            while (tempB != null && diff-- > 0) {
                tempB = tempB.next;
            }
        }

        while (tempA != null && tempB != null) {
            if (tempA == tempB) {
                return tempA;
            }
            tempA = tempA.next;
            tempB = tempB.next;
        }
        return null;
    }

    public static ListNode getIntersectionNodeOptimal2(ListNode headA, ListNode headB) {
        // tc => O(n+m) & sc => O(1)
        ListNode tempA = headA, tempB = headB;
        while (tempA != tempB) {
            tempA = tempA == null ? headB : tempA.next;
            tempB = tempB == null ? headA : tempB.next;
        }
        return tempA;
    }

    // driver code
    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        LinkedList l2 = new LinkedList();
        l1.addLast(4);
        l1.addLast(1);
        l1.addLast(8);
        l1.addLast(5);
        l1.addLast(4);
        // l2.addLast();

        l2.addLast(5);
        l2.addLast(6);
        l2.addLast(1);

        ListNode temp2 = l2.head;
        while (temp2.next != null) {
            temp2 = temp2.next;
        }
        ListNode temp1 = l1.head;
        temp1 = temp1.next.next;

        temp2.next = temp1;
        l1.display();
        l2.display();

        // l1.head = getIntersectionNodeBruteForce(l1.head, l2.head);
        // l1.display();
        // l1.head = getIntersectionNodeBetter(l1.head, l2.head);
        // l1.display();
        // l1.head = getIntersectionNodeOptimal1(l1.head, l2.head);
        // l1.display();
        l1.head = getIntersectionNodeOptimal2(l1.head, l2.head);
        l1.display();
    }
}
