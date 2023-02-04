package LinkedLists;

import LinkedLists.LinkedList.ListNode;

public class MergeTwoSortedLists {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // iterative solution tc => O(n) & sc => O(n)
        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
                tail = tail.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
                tail = tail.next;
            }
        }
        if (list1 != null) {
            tail.next = list1;
        } else {
            tail.next = list2;
        }
        return dummyHead.next;
    }

    public static ListNode mergeTwoListsInPlace(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }
        if (list1.val > list2.val) {
            ListNode temp = list1;
            list1 = list2;
            list2 = temp;
        }
        ListNode ans = list1;
        while (list1 != null && list2 != null) {
            ListNode temp = null;
            while (list1 != null && list1.val <= list2.val) {
                temp = list1;
                list1 = list1.next;
            }
            temp.next = list2;

            // swap
            ListNode t = list1;
            list1 = list2;
            list2 = t;
        }
        return ans;
    }

    public static ListNode mergeTwoListsRec(ListNode list1, ListNode list2) {

        // recursive solution tc => O(n) & stack sc => O(n)
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();

        list1.addLast(1);
        list1.addLast(3);
        list1.addLast(5);
        list2.addLast(2);
        list2.addLast(4);
        list2.addLast(6);
        list1.display();
        list2.display();
        // list1.head = mergeTwoLists(list1.head, list2.head);
        // list1.display();
        list1.head = mergeTwoListsInPlace(list1.head, list2.head);
        list1.display();
        // list1.head = mergeTwoListsRec(list1.head, list2.head);
        // list1.display();
    }
}
