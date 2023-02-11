package Binary_Search;

/*
        * Allocate Books
        * Problem Statement: Ayush is studying for ninjatest which will be held after 'N' days, And to score good marks he has to study 'M' chapters and the ith chapter requires TIME(il seconds to study. The day in Ayush's world has IOOAIOO seconds. There are some rules that are followed by Ayush while studying.

        1. He reads the chapter in a sequential order, i.e. he studies i+lth chapter only after he studies ith chapter.

        2. If he starts some chapter on a particular day he completes it that day itself.

        3. He wants to distribute his workload over 'N' days, so he wants to minimize the maximum amount of time he studies in a day.
        
        Your task is to find out the minimal value of the maximum amount of time for which Ayush studies in a day, in order to complete all the 'M' chapters in no more than 'N' days.

        if Ayush want to study 6 chapters in 3 days and the time that each chapter requires is as follows :
        Chapter 1 = 30
        Chapter 2 = 20
        Chapter 3 = 10
        Chapter 4 = 40
        Chapter 5 = 5
        Chapter 6 = 45
        
        Then he will study the chapters in the following order

        | day 1 : 1,2 | day 2 : 3,4 | day 3 : 5,6

        Here we can see that he study chapters in sequential order and the maximum time to study on a day is 50,
        which is the minimum possible in this case.
 */

public class AllocateBooks {
    public static long ayushGivesNinjatest(int days, int chapters, int[] time) {
        // Write your code here.
        long start = 0, totalTime = 0, ans = -1;
        for (int t : time) {
            totalTime += t;
        }
        long end = totalTime;
        while (start <= end) {
            long mid = (start + end) / 2;
            if (isPossible(days, time, mid)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    private static boolean isPossible(long days, int[] time, long mid) {
        int day = 1;
        long requireTime = 0;
        for (int x : time) {
            if (requireTime + x <= mid) {
                requireTime += x;
            } else {
                ++day;
                if (day > days || x > mid) {
                    return false;
                }
                requireTime = x;
            }
        }
        return true;
    }

    // driver code
    public static void main(String[] args) {
        int[] time = { 1, 2, 2, 3, 1 };
        int chapters = 3, days = time.length;
        System.out.println(ayushGivesNinjatest(chapters, days, time));
    }
}
