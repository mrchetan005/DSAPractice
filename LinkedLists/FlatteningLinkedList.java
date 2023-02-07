package LinkedLists;

/*
        * Flattening a Linked List 
        * Given a Linked List of size N, where every node represents a sub-linked-list and contains two pointers:
        * (i) a next pointer to the next node,
        * (ii) a bottom pointer to a linked list where this node is head.
        Each of the sub-linked-list is in sorted order.
        Flatten the Link List such that all the nodes appear in a single level while maintaining the sorted order. 

        * Note: The flattened list will be printed using the bottom pointer instead of the next pointer.
        For more clarity have a look at the printList() function in the driver code.
        Example 1:
            Input:
                5 -> 10 -> 19 -> 28
                |     |     |     | 
                7     20    22   35
                |           |     | 
                8          50    40
                |                 | 
                30               45
            Output:  5-> 7-> 8- > 10 -> 19-> 20-> 22-> 28-> 30-> 35-> 40-> 45-> 50.
            Explanation:
                The resultant linked lists has every 
                node in a single level.
                (Note: | represents the bottom pointer.)
        Example 2:
            Input:
                5 -> 10 -> 19 -> 28
                |          |                
                7          22   
                |          |                 
                8          50 
                |                           
                30              
            Output: 5->7->8->10->19->22->28->30->50
            Explanation:
                The resultant linked lists has every
                node in a single level.
                (Note: | represents the bottom pointer.)
        Your Task:
            You do not need to read input or print anything. Complete the function flatten() that takes the head of the linked list as input parameter and returns the head of flattened link list.
        * Expected Time Complexity: O(N*N*M)
        * Expected Auxiliary Space: O(1)
        * Constraints:
            0 <= N <= 50
            1 <= Mi <= 20
            1 <= Element of linked list <= 103
 */

public class FlatteningLinkedList {

    class Node {
        int data;
        Node next;
        Node bottom;

        Node(int d) {
            data = d;
            next = null;
            bottom = null;
        }
    }

    /*
     * Function which returns the root of
     * the flattened linked list.
     */
    class GfG {

        Node flatten(Node root) {

            // base case
            if (root == null || root.next == null) {
                return root;
            }

            // recursive call for list on right
            root.next = flatten(root.next);

            // now merge curr and next
            root = mergeTwoLists(root, root.next);

            // return the root which will changed while
            // returning from recursive call to the left
            return root;

        }

        Node mergeTwoLists(Node a, Node b) {

            Node temp = new Node(0);
            Node res = temp;

            while (a != null && b != null) {
                if (a.data < b.data) {
                    temp.bottom = a;
                    a = a.bottom;
                    temp = temp.bottom;
                } else {
                    temp.bottom = b;
                    b = b.bottom;
                    temp = temp.bottom;
                }
            }

            temp.bottom = (a != null) ? a : b;

            return res.bottom;
        }
    }
}
