package Strings;

/*
        * LEETCODE: 2405. Optimal partition of String
        * https://leetcode.com/problems/optimal-partition-of-string/
 */

public class OptimalPartitionOfString {
    public static int partitionString(String s) {
        // sliding window approach
        // tc => 2 * O(n) & sc => O(1)

        boolean[] ch = new boolean[123];
        int n = s.length(), l = 0, r = 0, count = 1;

        while (r < n) {
            if (!ch[s.charAt(r)]) {
                ch[s.charAt(r++)] = true;
            } else {
                count++;
                while (l < n && ch[s.charAt(l)]) {
                    ch[s.charAt(l++)] = false;
                }
            }
        }

        return count;
    }

    public static int partitionStringWay2(String s) {
        // tc => O(n) & sc => O(1)
        int[] unique = new int[123];
        int count = 1;

        for (char c : s.toCharArray()) {
            if (unique[c] == count)
                count++;
            unique[c] = count;
        }
        return count;
    }

    // driver code
    public static void main(String[] args) {
        System.out.println(partitionString("abacaba"));
        System.out.println(partitionStringWay2("abacaba"));

        System.out.println(partitionString("ssssss"));
        System.out.println(partitionStringWay2("ssssss"));
    }
}
