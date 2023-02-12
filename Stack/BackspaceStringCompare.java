package Stack;

import java.util.Stack;

/*
    * LEETCODE: 844. Backspace String Compare
    * https://leetcode.com/problems/backspace-string-compare/
 */

public class BackspaceStringCompare {
    public static boolean backspaceCompare(String s, String t) {
        // tc => O(n) & sc => O(1)
        if (s.equals(t)) {
            return true;
        }
        int i = s.length() - 1, j = t.length() - 1, skip1 = 0, skip2 = 0;
        while (i >= 0 || j >= 0) {

            while (i >= 0 && (s.charAt(i) == '#' || skip1 > 0)) {
                if (s.charAt(i) == '#') {
                    skip1++;
                } else {
                    skip1--;
                }
                i--;
            }

            while (j >= 0 && (t.charAt(j) == '#' || skip2 > 0)) {
                if (t.charAt(j) == '#') {
                    skip2++;
                } else {
                    skip2--;
                }
                j--;
            }

            if (i < 0 && j < 0) {
                return true;
            }
            if (i < 0 || j < 0) {
                return false;
            }
            if (s.charAt(i) != t.charAt(j)) {
                return false;
            }
            i--;
            j--;
        }
        return true;
    }

    public static boolean backspaceCompareUsingStack(String s, String t) {
        // tc => O(n) & sc => O(n)
        if (s.equals(t)) {
            return true;
        }

        Stack<Character> sk1 = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c != '#') {
                sk1.push(c);
            } else if (!sk1.isEmpty()) {
                sk1.pop();
            }
        }

        Stack<Character> sk2 = new Stack<>();
        for (char c : t.toCharArray()) {
            if (c != '#') {
                sk2.push(c);
            } else if (!sk2.isEmpty()) {
                sk2.pop();
            }
        }

        return sk1.equals(sk2);
    }

    // driver code
    public static void main(String[] args) {
        String s1 = "ab#c";
        String s2 = "ad#c";
        System.out.println(backspaceCompare(s1, s2));
        System.out.println(backspaceCompareUsingStack(s1, s2));
    }
}
