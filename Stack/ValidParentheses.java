package Stack;

import java.util.Stack;

/*
    * LEETCODE: 20. Valid Parentheses
    * https://leetcode.com/problems/valid-parentheses/
 */

public class ValidParentheses {
    public static boolean isValid(String str) {
        char lastCh = str.charAt(str.length() - 1);

        if (lastCh == '(' || lastCh == '{' || lastCh == '[')
            return false;

        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray()) {
            if (ch == '(') {
                stack.push(')');
            } else if (ch == '{') {
                stack.push('}');
            } else if (ch == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != ch) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    // driver code
    public static void main(String[] args) {
        String parenthString = "([]{){{}}}";
        System.out.println(isValid(parenthString));
    }
}
