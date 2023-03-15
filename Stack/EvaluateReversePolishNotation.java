package Stack;

import java.util.Stack;

/*
        * LEETCODE: 150. Evaluate Reverse Polish Notation
        * https://leetcode.com/problems/evaluate-reverse-polish-notation/
 */

public class EvaluateReversePolishNotation {
    public static int evalRPN(String[] tokens) {
        int[] stack = new int[tokens.length];
        int i = -1;
        for (String t : tokens) {
            switch (t) {
                case "+":
                    stack[i - 1] += stack[i--];
                    break;
                case "-":
                    stack[i - 1] -= stack[i--];
                    break;
                case "*":
                    stack[i - 1] *= stack[i--];
                    break;
                case "/":
                    stack[i - 1] /= stack[i--];
                    break;
                default:
                    stack[++i] = Integer.parseInt(t);
            }
        }
        return stack[i];
    }

    public static int evalRPNwithStack(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        for (String t : tokens) {
            switch (t) {
                case "+":
                    num = stack.pop();
                    stack.push(stack.pop() + num);
                    break;
                case "-":
                    num = stack.pop();
                    stack.push(stack.pop() - num);
                    break;
                case "*":
                    num = stack.pop();
                    stack.push(stack.pop() * num);
                    break;
                case "/":
                    num = stack.pop();
                    stack.push(stack.pop() / num);
                    break;
                default:
                    stack.push(Integer.parseInt(t));
            }
        }
        return stack.pop();
    }

    // driver code
    public static void main(String[] args) {
        String[] tokens = { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" };
        System.out.println(evalRPN(tokens));
        System.out.println(evalRPNwithStack(tokens));
    }
}
