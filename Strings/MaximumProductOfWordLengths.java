package Strings;

/*
        * LEETCODE: 318. Maximum Product of Word Lengths
        * https://leetcode.com/problems/maximum-product-of-word-lengths/
 */

public class MaximumProductOfWordLengths {
    public static int maxProduct(String[] words) {

        int n = words.length;
        int[] mask = new int[n];

        for (int i = 0; i < n; i++) {
            for (Character c : words[i].toCharArray()) {
                // setting the bit with respect to the character
                mask[i] |= (1 << (c - 'a'));
            }
        }

        int maxProduct = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // if not any character is present in both the words
                // then & operator with those words will make it zero
                if ((mask[i] & mask[j]) == 0) {
                    maxProduct = Math.max(maxProduct, words[i].length() * words[j].length());
                }
            }
        }

        return maxProduct;
    }

    // driver code
    public static void main(String[] args) {
        String[] words = { "abcw", "baz", "foo", "bar", "xtfn", "abcdef" };
        System.out.println(maxProduct(words));
    }
}
