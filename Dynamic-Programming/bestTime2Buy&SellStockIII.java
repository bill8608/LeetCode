/*
123. Best Time to Buy and Sell Stock III   QuestionEditorial Solution  My Submissions
Total Accepted: 71115
Total Submissions: 255397
Difficulty: Hard
Contributors: Admin
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

Hide Tags Array Dynamic Programming
Hide Similar Problems (E) Best Time to Buy and Sell Stock (M) Best Time to Buy and Sell Stock II (H) Best Time to Buy and Sell Stock IV
*/
// Thought
/*
We scan a second buy price from 0 to length - 1. Using this as the fixed, then find a buy-sell before it and another sell after that.
In this case, we will tranverse all the cases.
For the first buy-sell, we can set a minBuyPrice, maxTotalProfit, and firstBuySellProfit[]. Use maxTotalProfit to keep the maxProfit and pass it to firstBuySellProfit[] to store.

For the second buy-sell, since the buy price is "fixed", we can keep maxPriceSoFar to record max sell price. Then use maxTotalProfit to record the max total profit.

*/
public class Solution {
    public int maxProfit(int[] prices) {
        int maxTotalProfit = 0;
        int[] firstBuySellProfits = new int[prices.length];
        int minPriceSoFar = Integer.MAX_VALUE;
        
        for (int i = 0; i < prices.length; ++i) {
            minPriceSoFar = Math.min(minPriceSoFar, prices[i]);
            maxTotalProfit = Math.max(maxTotalProfit, prices[i] - minPriceSoFar);
            firstBuySellProfits[i] = maxTotalProfit;
        }
        
        int maxPriceSoFar = Integer.MIN_VALUE;
        for (int i = prices.length - 1; i > 0; --i) {
            maxPriceSoFar = Math.max(maxPriceSoFar, prices[i]);
            maxTotalProfit = Math.max(maxTotalProfit, maxPriceSoFar - prices[i] + firstBuySellProfits[i - 1]);
        }
        return maxTotalProfit;
    }
}