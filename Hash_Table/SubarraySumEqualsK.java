package Hash_Table;

import java.util.*;

/*
        * LEETCODE: Subarray Sum Equals K
        * https://leetcode.com/problems/subarray-sum-equals-k
 */

/*
       * loop two times and declare sum inside first loop as 0 
       * start traversing another loop from i and increment sum each time and check if sum equals to k, and count with counter and return count
       * In this case time comolexity is O(n^2) because we're accessing each value n-1 times and space complexity is O(1) as we're not creating any object
       * 
       * We can improve time complexity by using hashmap and prefix sum
       * take an array to store the prefix sum and fill the array with sum of previous value and current value of array to prefix array
       * take a counter & hashmap and start traversing array
       * if (preSum[i] - k) is present in map then increase counter by value present for key (preSum[i] - k)
       * if (preSum[i] == targetSum) then increment the count by 1
       * then put key (preSum[i] - k) to the map or increment its value by 1
       * 
 */

public class SubarraySumEqualsK {
    public static int subarraySumBruteForce(int[] nums, int k) {
        int cnt = 0, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] preSum = new int[n];
        preSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }
        int cnt = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(preSum[i] - k)) {
                cnt += map.get(preSum[i] - k);
            }
            if (preSum[i] == k) {
                cnt++;
            }
            map.put(preSum[i], map.getOrDefault(preSum[i], 0) + 1);
        }
        return cnt;
    }

    /*
     * For Example:
     *
     * arr = 1 1 1 1 1
     * targetSum = 2
     * preSum[] = 1 2 3 4 5
     * 
     * for i=0
     * (map.containsKey(preSum[i] - k)) => => map.containsKey(1-2) => false
     * (preSum[i] == k) => (1 == 2) => false
     * map => key = preSum[0] = 1 & val = frequency of key = 1 => (1,1)
     * 
     * for i=1
     * (map.containsKey(2-2)) => false
     * (2 == 2) => true => cnt = 1
     * map => (2,1)
     * 
     * for i=2
     * (map.containsKey(3-2)) => true => cnt = 1 + 1 = 2
     * (3 == 2) => false
     * map => (3,1)
     * 
     * for i=3
     * (map.containsKey(4-2)) => true => cnt = 2 + 1 = 3
     * (4 == 2) => false
     * map => (4,1)
     * 
     * for i=4
     * (map.containsKey(5-2)) => true => cnt = 3 + 1 = 4
     * (5 == 2) => false
     * map => (5,1)
     * 
     * cnt = 4
     */

    // driver code
    public static void main(String[] args) {
        int[] arr = { 1, 3, -2, 1, 4, 6, -5, 7, -9, 8, 1 };
        int[] arr2 = { 1, 1, 1, 1, 1 };
        int k = 2;
        System.out.println(subarraySumBruteForce(arr, k));
        System.out.println(subarraySum(arr2, k));
    }
}
