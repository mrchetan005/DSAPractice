package Greedy_Algorithm;

import java.util.*;

/*
    * GFG: Minimum Platforms
    * https://practice.geeksforgeeks.org/problems/minimum-platforms-1587115620/1
 */

public class MinimumPlatforms {
    static int findPlatform(int arr[], int[] dep, int n) {
        // sc => O(nlog(n)) & sc => O(1)
        Arrays.sort(arr);
        Arrays.sort(dep);
        // now both arrival and departure are sorted, we can check
        // arrival and departure of train
        int i = 1, j = 0, platforms = 1, minPlatformsNeeded = 1;
        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
                // if platform is not empty we need one more platform
                platforms++;
                i++;
            } else {
                // we have empty platform so we'll not need extra platform
                platforms--;
                j++;
            }
            minPlatformsNeeded = Math.max(minPlatformsNeeded, platforms);
        }
        return minPlatformsNeeded;
    }

    static int findPlatforms(int at[], int dt[], int n) {
        // sc => O(n) & sc => O(1)
        int[] platforms = new int[2361];
        int requiredPlatforms = 1;
        for (int i = 0; i < n; i++) {
            // map arrival and departure time in the platforms array
            platforms[at[i]]++;
            // any train arriving at 200 and departuring at 200
            // we need min 2 platforms, to maintain this condition
            // we'll map departure one min after
            platforms[dt[i] + 1]--;
        }
        for (int i = 1; i < 2361; i++) {
            // calculating prefix sum for platforms ranging from arrival and departure
            platforms[i] += platforms[i - 1];
            requiredPlatforms = Math.max(requiredPlatforms, platforms[i]);
        }
        return requiredPlatforms;
    }

    // driver code
    public static void main(String[] args) {
        int[] arrival = { 900, 940, 950, 1100, 1500, 1800 };
        int[] departure = { 910, 1200, 1120, 1130, 1900, 2000 };
        System.out.println(findPlatform(arrival, departure, arrival.length));

        int[] at = { 100, 200, 300, 400, 500 };
        int[] dt = { 200, 300, 400, 500, 600 };
        System.out.println(findPlatforms(at, dt, at.length));
    }
}