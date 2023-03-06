package Stack;

import java.util.Stack;

/*
        * LEETCODE: 227. Basic Calculator II
        * https://leetcode.com/problems/basic-calculator-ii
 */

public class BasicCalculatorII {
    public static int calculate(String s) {
        // tc => O(n) & sc => O(n)
        Stack<Integer> stack = new Stack<>();
        char sign = '+'; // initially +ve
        char[] ch = s.toCharArray();
        int n = ch.length;

        for (int i = 0; i < n; i++) {
            // when character is digit
            if (ch[i] >= '0' && ch[i] <= '9') {
                // calculate the current number
                int curNum = 0;
                while (i < n && (ch[i] >= '0' && ch[i] <= '9')) {
                    curNum = curNum * 10 + (ch[i] - '0');
                    i++;
                }
                i--;
                // calculate and push result to stack
                switch (sign) {
                    case '+' -> stack.push(curNum);
                    case '-' -> stack.push(-curNum);
                    case '*' -> stack.push(stack.pop() * curNum);
                    case '/' -> stack.push(stack.pop() / curNum);
                }
            } else if (ch[i] != ' ') {
                // update the sign
                sign = ch[i];
            }
        }
        // find sum of all stack elements
        int sum = 0;
        for (Integer num : stack) {
            sum += num;
        }
        return sum;
    }

    // driver code
    public static void main(String[] args) {
        System.out.println(calculate(" 3+5 / 2 "));
    }
}
