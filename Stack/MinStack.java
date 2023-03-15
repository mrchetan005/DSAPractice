package Stack;

import java.util.Stack;

/*
        * LEETCODE : 155. Min Stack
        * https://leetcode.com/problems/min-stack/
 */

public class MinStack {

    // Using Linked List

    private Node head;

    private class Node {
        int val, min;
        Node next;

        private Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }

    // add first in Linked List
    public void push(int x) {
        if (head == null) {
            head = new Node(x, x, null);
        } else {
            head = new Node(x, Math.min(x, head.min), head);
        }
    }

    // remove first in Linked List
    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }

}

class MinStacks {

    // Using Two Stacks

    Stack<Integer> stack, minStack;

    public MinStacks() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
        stack.push(val);
    }

    public void pop() {
        if (stack.pop() == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

// driver code
class DriverCode {
    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(-2);
        obj.push(0);
        obj.push(-3);
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.top());
        System.out.println(obj.getMin());

        System.out.println("-----using  two stacks-----");

        MinStacks obj1 = new MinStacks();
        obj1.push(-2);
        obj1.push(0);
        obj1.push(-3);
        System.out.println(obj1.getMin());
        obj1.pop();
        System.out.println(obj1.top());
        System.out.println(obj1.getMin());
    }
}
