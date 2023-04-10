package Arrays;

/*
        * Count Inversions
        * Problem Statement: Calculate inversion count of array of integers. Inversion count of an array is quantisation of how much unsorted an array is. A sorted array has inversion count 0, while an unsorted array has maximum inversion count. Formally speaking inversion count = number of pairs i, j such that i < j and a[i] > a[j].
        Examples - 
        Sample Input: 1 1 3 2 2
        Sample Output: 2
        Sample Input: 5 4 3 2 1
        Sample Output: 10
 */

/*
       * brute force will be directly apply two loops and count when condition is satisfied which will take time complexity O(n^2) so have to improve it... 
       * we simply apply merge sort which is divide and conquer algorithm
       * create a temp array of same length as given array
       * create void function and pass given array, temp array, start (0) and end (array.length-1)
       * inside function find mid of the array and recursively call the merge function with start to mid and mid+1 to end and finally merge those arrays with other function
       * create another void function
       * create three pointers i=start, j=mid+1 and k=left to keep track of elements to be in sorted manner inside temp array
       * now check for condition a[i] <= a[j] and this will not be affected the inversion so we'll go the else part and count the inversion count
       * to count inversion count as we know the array left to mid is sorted and right to mid is sorted so whenever we get condition a[i] > a[j] it is sure that all the elements till mid are greater as they're always being sorted by merge sort algorithm so we can simply say that the count will be added is (mid-i+1)
       * for example we have 4 5 6  and     3 8
       * we can check directly for 4,5 and 6 there is one element smaller, hence cnt is 3
       * here, i=0, mid=2, j=3, a[i] > a[j] is satisfied cnt is 2-0+1=3, hence this is working perfectly fine
       * and we'll keep adding remaining elements and at last update the given array with temp array
       * and we'll return the count
 */

public class InversionCount {

    private static long cnt;

    public static long getInversions(long arr[], int n) {
        // brute force method
        // long cnt = 0;
        // for(int i=0; i<n; i++) {
        // for(int j=i+1; j<n; j++) {
        // if(arr[i] > arr[j]) {
        // cnt++;
        // }
        // }
        // }
        // return cnt;

        // efficient method: merge sort
        long[] temp = new long[n];
        merge(arr, temp, 0, n - 1);
        return cnt;
    }

    public static void merge(long[] arr, long[] temp, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            merge(arr, temp, start, mid);
            merge(arr, temp, mid + 1, end);
            mergeSort(arr, temp, start, mid, end);
        }
    }

    public static void mergeSort(long[] arr, long[] temp, int start, int mid, int end) {
        int i = start, j = mid + 1, k = start;
        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                cnt += mid - i + 1;
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= end) {
            temp[k++] = arr[j++];
        }
        for (i = start; i <= end; i++) {
            arr[i] = temp[i];
        }
    }

    // driver code
    public static void main(String[] args) {
        long[] arr = { 5, 3, 1, 2, 4 };
        System.out.println(getInversions(arr, arr.length));
    }
}
