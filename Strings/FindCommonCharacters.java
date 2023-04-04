package Strings;

import java.util.*;

/*
        * LEETCODE: 1002. Find Common Characters
        * https://leetcode.com/problems/find-common-characters/
 */

public class FindCommonCharacters {
    // count the characters and store it in 26 length array
    private static int[] cntChars(String word) {
        int cnt[] = new int[26];
        for (char c : word.toCharArray()) {
            cnt[c - 'a']++;
        }
        return cnt;
    }

    // set minimum cnt of character
    private static void setMin(int[] cntTillNow, int[] curr) {
        for (int i = 0; i < 26; i++) {
            cntTillNow[i] = Math.min(cntTillNow[i], curr[i]);
        }
    }

    public static List<String> commonChars(String[] words) {
        // tc => O(n*k) & sc => O(26) ~ O(1) . . . (k is String length)

        int[] cntTillNow = cntChars(words[0]);
        int n = words.length;

        // traverse the array and find cnt of characters
        // and keep setting minimum cnt only
        for (int i = 1; i < n; i++) {
            int[] currCnt = cntChars(words[i]);
            setMin(cntTillNow, currCnt);
        }

        // now tillNow array holds only ans list
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            while (cntTillNow[i]-- > 0) {
                res.add(Character.toString((char) (i + 'a')));
            }
        }
        return res;
    }

    // driver code
    public static void main(String[] args) {
        String[] words = { "bella", "label", "roller" };
        List<String> common = commonChars(words);
        System.out.println(common);
    }
}
