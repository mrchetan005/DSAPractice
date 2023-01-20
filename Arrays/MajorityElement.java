package Arrays;

import java.util.*;

/*
    * LEETCODE: 169. Majority Element
    * Problem Statement: Given an array nums of size n, return the majority element. If there's no majority element present, print -1.

    The majority element is the element that appears more than ⌊n / 2⌋ times.
    Example 1:
        Input: nums = [3,2,3]
        Output: 3
    Example 2:
        Input: nums = [2,2,1,1,1,2,2]
        Output: 2
    Constraints:
        n == nums.length
        1 <= n <= 5 * 104
        -109 <= nums[i] <= 109
    Follow-up: Could you solve the problem in linear time and in O(1) space?
 */

/*
   * LEETCODE: 229. Majority Element II
   * Problem Statement: Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
   Example 1:
       Input: nums = [3,2,3]
       Output: [3]
   Example 2:
       Input: nums = [1]
       Output: [1]
   Example 3:
       Input: nums = [1,2]
       Output: [1,2]
   Constraints:
       1 <= nums.length <= 5 * 10^4
       -10^9 <= nums[i] <= 10^9
   Follow up: Could you solve the problem in linear time and in O(1) space?
 */

/*
       * Majority Elemment
       * Here if the majority element exists we can check it through Moore's Voting Algorithm
       * if(cnt==0) then we'll update our candidate = a[i]
       * then we'll check the a[i]==ans if true then we'll increment the count else we'll decrement the count
       * if there exist a majority element, the remaining element after traversing the array will be still inside our candidate
       * because all other will be cancelled out if the count of majority element is greater than n/2
       * so we can check it by taking another loop and count the candidate we'have got at last is the majority or not...
       * we'll return it if it is majority, if that candidate is not majority then no other candidate can be majority so we'll return -1
 */

/*
       * Majority Element II
       * we can use the same Moore's Voting Algorithm with some modifications
       * At max 2 elements can be majority for votes greater than (n/3)
       * so we'll take two candidates a and b and two counters for them
       * if element==a we'll increment cnt1 else if element==b we'll increment cnt2
       * else if cnt1==0 we'll update a = element and cnt1 to 1 
       * else if cnt2==0 we'll update b = element and cnt2 to 1
       * else we'll decrement both cnt1 and cnt2 by 1
       * at traversing the array we'll get two elements inside a and b
       * we've to check those two numbers are majority i.e. greater than n/3 
       * for that we'll take loop and count both the elements
       * if elements are majority we'll add to ans arraylist
       * return the ans arraylist
 */

public class MajorityElement {
    public static int findMajority(int[] nums) {
        int n = nums.length;
        int candidate = nums[0], cnt = 0;
        for (int i = 0; i < n; i++) {
            if (cnt == 0) {
                candidate = nums[i];
            }
            cnt += (candidate == nums[i]) ? 1 : -1;
        }
        int cnt2 = 0;
        for (int i = 0; i < n; i++) {
            if (candidate == nums[i]) {
                cnt2++;
            }
        }
        return (cnt2 > (n / 2)) ? candidate : -1;
    }

    public static List<Integer> majorityElement(int[] nums) {
        int a = -1, b = -1, cnt1 = 0, cnt2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == a) {
                cnt1++;
            } else if (nums[i] == b) {
                cnt2++;
            } else if (cnt1 == 0) {
                a = nums[i];
                cnt1 = 1;
            } else if (cnt2 == 0) {
                b = nums[i];
                cnt2 = 1;
            } else {
                cnt1--;
                cnt2--;
            }
        }
        cnt1 = 0;
        cnt2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == a) {
                cnt1++;
            } else if (nums[i] == b) {
                cnt2++;
            }
        }
        List<Integer> ans = new ArrayList<>();
        if (cnt1 > (nums.length / 3)) {
            ans.add(a);
        }
        if (cnt2 > (nums.length / 3)) {
            ans.add(b);
        }
        return ans;
    }

    // driver code
    public static void main(String[] args) {
        int[] arr = { 2, 2, 1, 1, 1, 2, 2 };
        System.out.println(findMajority(arr));

        int[] arr2 = { 2, 2, 2, 1, 3, 3, 3 };
        List<Integer> al = majorityElement(arr2);
        System.out.println(al);

    }
}
