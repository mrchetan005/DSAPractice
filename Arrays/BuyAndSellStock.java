package Arrays;

/*
    * LEETCODE: 121. Best Time To Buy and Sell Stock
    * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
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
