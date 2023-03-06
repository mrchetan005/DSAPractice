package Stack;

import java.util.*;

/*
    * LEETCODE : 224. Basic Calculator
    * https://leetcode.com/problems/basic-calculator
 */

public class BasicCalculator {
    public static int calculate(String s) {
        // tc => O(n) & sc => O(n)
        Stack<Integer> stack = new Stack<>();
        int number = 0;
        int sign = 1;
        int result = 0;

        for (char c : s.toCharArray()) {
            switch (c) {
                case '+' -> {
                    // add number with prev sign in result
                    result += number * sign;
                    number = 0; // reset number
                    // update the + sign
                    sign = 1;
                }
                case '-' -> {
                    // add number with prev sign in result
                    result += number * sign;
                    number = 0; // reset number
                    // update the - sign
                    sign = -1;
                }
                case '(' -> {
                    stack.push(result); // put prev calculated result to stack
                    stack.push(sign); // put sign value to the stack
                    // reset values of result and sign
                    result = 0;
                    sign = 1;
                }
                case ')' -> {
                    result += number * sign;
                    number = 0;
                    // take out sign value from stack and multiply with result
                    result *= stack.pop();
                    // take out previous result and add to result
                    result += stack.pop();
                }
                default -> {
                    // process the number when character is digit
                    if (c >= '0' && c <= '9') {
                        number = 10 * number + (c - '0');
                    }
                }
            }
        }
        // calculate one more time for last number
        result += number * sign;
        return result;
    }

    // driver code
    public static void main(String[] args) {
        System.out.println(calculate("(1+ (4+5+2)-3)+( 6+8)"));
    }
}