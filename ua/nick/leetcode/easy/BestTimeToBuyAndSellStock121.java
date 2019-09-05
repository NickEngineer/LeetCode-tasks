package ua.nick.leetcode.easy;

/*
    *121. Best Time to Buy and Sell Stock
    Easy

    Say you have an array for which the ith element is the price of
    a given stock on day i.

    If you were only permitted to complete at most one transaction
    (i.e., buy one and sell one share of the stock), design an algorithm
    to find the maximum profit.

    Note that you cannot sell a stock before you buy one.

    Example 1:

    Input: [7,1,5,3,6,4]
    Output: 5
    Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6),
    profit = 6-1 = 5.
                 Not 7-1 = 6, as selling price needs to be larger
                 than buying price.

    Example 2:

    Input: [7,6,4,3,1]
    Output: 0
    Explanation: In this case, no transaction is done, i.e. max profit = 0.
* */

public class BestTimeToBuyAndSellStock121 {

    public static void main(String[] args) {
        int[] prices = {2,1,2,1,0,1,2};

        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;

        if (prices.length > 1) {
            int buyPrice = prices[0];
            int sellPrice = prices[prices.length - 1];
            int tempPrice = Integer.MIN_VALUE;

            for (int i = 0, j = prices.length - 1; i < j; ++i, --j) {
                if (buyPrice > prices[i]) {
                    buyPrice = prices[i];
                } else {
                    if (tempPrice < prices[i] - buyPrice) {
                        tempPrice = prices[i] - buyPrice;
                    }
                }

                if (sellPrice < prices[j]) {
                    sellPrice = prices[j];
                } else {
                    if(tempPrice < sellPrice-prices[j]){
                        tempPrice = sellPrice-prices[j];
                    }
                }
            }

            if (prices.length % 2 == 1) {
                int middle = prices.length / 2;
                if (prices[middle] < buyPrice) {
                    buyPrice = prices[middle];
                } else if (prices[middle] > sellPrice) {
                    sellPrice = prices[middle];
                }
            }

            if (sellPrice > buyPrice) {
                maxProfit = sellPrice - buyPrice;
            }

            if (maxProfit < tempPrice) {
                maxProfit = tempPrice;
            }
        }

        return maxProfit;
    }
}
