package Strings;

/*
        * LEETCODE: 2109. Adding Spaces to a String
        * https://leetcode.com/problems/adding-spaces-to-a-string/
 */

public class AddingSpacesToString {
    public static String addSpaces(String s, int[] spaces) {
        // tc => O(n) & sc => O(n)
        char[] ch = new char[s.length() + spaces.length];
        int spaceCnt = 0;
        for (int i = 0, j = 0; i < ch.length; i++) {
            if (j < spaces.length && i == spaces[j] + spaceCnt) {
                ch[i] = ' ';
                j++;
                spaceCnt++;
            } else {
                ch[i] = s.charAt(i - spaceCnt);
            }
        }
        return new String(ch);
    }

    public static String addSpaces1(String s, int[] spaces) {
        // tc => O(n) & sc => O(n)
        StringBuilder sb = new StringBuilder();
        int n = spaces.length, prevIdx = 0;
        for (int i = 0; i < n; i++) {
            sb.append(s.substring(prevIdx, spaces[i])).append(' ');
            prevIdx = spaces[i];
        }
        return sb.append(s.substring(prevIdx)).toString();
    }

    // driver code
    public static void main(String[] args) {
        int[] spaces = { 8, 13, 15 };
        String s = "LeetcodeHelpsMeLearn";
        System.out.println(addSpaces(s, spaces));
        System.out.println(addSpaces1(s, spaces));
    }
}
