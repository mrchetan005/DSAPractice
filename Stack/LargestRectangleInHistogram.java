package Stack;

import java.util.Stack;

/*
    * 84. Largest Rectangle in Histogram
    * https://leetcode.com/problems/largest-rectangle-in-histogram
 */

public class LargestRectangleInHistogram {
    public static int largestRectangleArea(int[] heights) {
        // tc => O(n) & sc => O(n)
        int n = heights.length;
        int[] minLeftIndex = new int[n];
        int[] minRightIndex = new int[n];
        minLeftIndex[0] = -1;
        for (int i = 1; i < n; i++) {
            int t = i - 1;
            while (t >= 0 && heights[t] >= heights[i])
                t = minLeftIndex[t];
            minLeftIndex[i] = t;
        }
        minRightIndex[n - 1] = n;
        for (int i = n - 2; i >= 0; i--) {
            int t = i + 1;
            while (t < n && heights[t] >= heights[i])
                t = minRightIndex[t];
            minRightIndex[i] = t;
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            int sum = heights[i] * (minRightIndex[i] - minLeftIndex[i] - 1);
            result = Math.max(sum, result);
        }
        return result;
    }

    public static int largestRectangleAreaUsingStack(int[] heights) {
        // tc => O(n) & sc => O(n)
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int[] nextSmall = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            nextSmall[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        Stack<Integer> st2 = new Stack<>();
        int[] prevSmall = new int[n];
        for (int i = 0; i < n; i++) {
            while (!st2.isEmpty() && heights[st2.peek()] >= heights[i]) {
                st2.pop();
            }
            prevSmall[i] = st2.isEmpty() ? -1 : st2.peek();
            st2.push(i);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, (nextSmall[i] - prevSmall[i] - 1) * heights[i]);
        }
        return res;
    }

    // driver code
    public static void main(String[] args) {
        int[] heights = { 2, 1, 5, 6, 2, 3 };
        System.out.println(largestRectangleArea(heights));
        System.out.println(largestRectangleAreaUsingStack(heights));
    }
}
