package Arrays;

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
       * Here if the majority element exists we can check it through Moore's Voting Algorithm
       * if(cnt==0) then we'll update our candidate = a[i]
       * then we'll check the a[i]==ans if true then we'll increment the count else we'll decrement the count
       * if there exist a majority element, the remaining element after traversing the array will be still inside our candidate
       * because all other will be cancelled out if the count of majority element is greater than n/2
       * so we can check it by taking another loop and count the candidate we'have got at last is the majority or not...
       * we'll return it if it is majority, if that candidate is not majority then no other candidate can be majority so we'll return -1
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

    // driver code
    public static void main(String[] args) {
        int[] arr = { 2, 2, 1, 1, 1, 2, 2 };
        System.out.println(findMajority(arr));
    }
}
