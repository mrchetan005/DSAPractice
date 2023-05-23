package Arrays;

import java.util.*;

/*
        * LEETCODE: 347 Top K Frequent Elements
        * https://leetcode.com/problems/top-k-frequent-elements/
 */

public class TopKFrequentElements {
    // This method is efficient for small data or big range
    public static int[] topKFrequentUsingMapAndPQ(int[] nums, int k) {
        // tc => O(nlog(n)) and sc => O(n)
        // find frequency using hashmap
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int val : nums) {
            hm.put(val, hm.getOrDefault(val, 0) + 1);
        }

        // add elments in sorted order of frequencies
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> hm.get(b) - hm.get(a));
        pq.addAll(hm.keySet());

        // take out first k elements from queue
        for (int i = 0; i < k; i++) {
            nums[i] = pq.remove();
        }
        return Arrays.copyOfRange(nums, 0, k);
    }

    // This method is efficient for big data or small range
    public static int[] topKFrequent(int[] nums, int k) {
        // Bucket Sort
        // tc => O(max_num - min_num) & sc => O(max_num - min_num)
        //
        if (k == nums.length)
            return nums;
        int max_num = Integer.MIN_VALUE, min_num = Integer.MAX_VALUE;
        // find max_num and min_num
        for (int num : nums) {
            if (num > max_num) {
                max_num = num;
            }
            if (num < min_num) {
                min_num = num;
            }
        }
        // find frequency of num in nums
        int[] freq_arr = new int[max_num - min_num + 1];
        for (int num : nums) {
            freq_arr[num - min_num]++;
        }
        // add all num having same frequency in same bucket
        ArrayList<Integer>[] bucket = new ArrayList[nums.length + 1];
        int max_freq = Integer.MIN_VALUE;
        for (int i = 0; i < freq_arr.length; i++) {
            if (freq_arr[i] > 0) {
                if (bucket[freq_arr[i]] == null) {
                    bucket[freq_arr[i]] = new ArrayList<>();
                }
                bucket[freq_arr[i]].add(i + min_num);
                if (freq_arr[i] > max_freq) {
                    max_freq = freq_arr[i];
                }
            }
        }
        // add k num in result array
        int res[] = new int[k];
        for (int i = max_freq; i >= 0; i--) {
            if (bucket[i] == null) {
                continue;
            }
            for (int num : bucket[i]) {
                if (k == 0) {
                    break;
                }
                res[--k] = num;
            }
            if (k == 0) {
                break;
            }
        }
        return res;
    }

    // driver code
    public static void main(String[] args) {
        int[] arr = { -12212, -12212, -12212, 12211, 12211, 19991 };
        System.out.println(Arrays.toString(topKFrequent(arr, 2)));
        System.out.println(Arrays.toString(topKFrequentUsingMapAndPQ(arr, 2)));
    }
}