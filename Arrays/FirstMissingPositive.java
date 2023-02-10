package Arrays;

/*
        * LEETCODE: 41. First Missing Positive
        * https://leetcode.com/problems/first-missing-positive/
*/

/*
    * positive least possible number is 1 and max possible number is n+1 
    * so if we can able to put the elements on its position in the array then we can check it only in one traversal...
    * as array indexing start from 0 so the chair for the position in the array will be position-1, so if position is not on chair then swap both the chair and position until it comes at its position
    * here one condition must be checked for the position should not be less than 1 and should not be greater than n 
    * now simply traverse the array and check if the element in array is equal to i+1 or not if not then that's the smallest missing positive
    * if did't get smallest element in the array then smallest positive integer is n+1 
*/
public class FirstMissingPositive {
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int position = nums[i];
            if (position >= 1 && position <= n) {
                int chair = position - 1;
                if (nums[chair] != position) {
                    int t = nums[chair];
                    nums[chair] = nums[i];
                    nums[i] = t;
                    i--;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if ((i + 1) != nums[i]) {
                return (i + 1);
            }
        }
        return (n + 1);
    }

    // driver code
    public static void main(String[] args) {
        int[] arr = { 3, 4, -1, 1, 2, 9, 8, 12, 7, 6, 5 };
        System.out.println(firstMissingPositive(arr));
    }
}
