package Arrays;

/*
    * LEETCODE: Best Time To Buy and Sell Stock
    * Problem Statement: You are given an array prices where prices[i] is the price of a given stock on the ith day.

    You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

    Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

    Example 1:

    Input: prices = [7,1,5,3,6,4]
    Output: 5
    Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
    Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
    Example 2:

    Input: prices = [7,6,4,3,1]
    Output: 0
    Explanation: In this case, no transactions are done and the max profit = 0.
    
    Constraints:
        1 <= prices.length <= 105
        0 <= prices[i] <= 104
 */

/*
    * keep tracking minimum along with maximum with difference of value and minimum 
    * take minimim equal to array's first value and maximum equal to 0
    *  traverse the array and keep updating min with value and max with value-min
 */

public class BuyAndSellStock {
    public static int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int currPrice : prices) {
            minPrice = Math.min(minPrice, currPrice);
            maxProfit = Math.max(maxProfit, currPrice - minPrice);
        }
        return maxProfit;
    }

    // driver code
    public static void main(String[] args) {
        int[] prices = { 7, 1, 5, 3, 6, 4 };
        System.out.println(maxProfit(prices)); // 5
        int[] prices1 = { 7, 6, 4, 3, 1 };
        System.out.println(maxProfit(prices1)); // 0
    }
}