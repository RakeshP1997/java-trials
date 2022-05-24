package easy;

/**Problem Statement: Best Time to Buy and Sell Stock
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 *
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 *
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */
public class BestTimeToBuyAndSellStocks {
    static class Solution {
//        public int maxProfit(int[] prices) {
//            if (prices.length < 2) return 0;
//            return BTST(prices);
//        }
//        private int BTST(int[] prices) {
//            int max = prices[0], min = prices[0], sum = 0;
//            for (int i = 1; i < prices.length; i++) {
//                if (prices[i] < min) {
//                    sum = max - min;
//                    max = min = prices[i];
//                } else if (prices[i] > max) {
//                    max = prices[i];
//                }
//            }
//            return sum;
//        }

        int min = Integer.MAX_VALUE;
        public int maxProfit(int[] prices) {
            if (prices.length < 2) return 0;
            return BTST(prices);
        }

        private int BTST(int[] prices) {
            int sum = 0;
            for (int i = 0; i < prices.length; i++) {
                if(prices[i] < min) {
                    min = prices[i];
                    for (int j = i + 1; j < prices.length; j++) {
                        System.out.println(String.format("Prices[i]=%d, Prices[j]=%d, sum=%d",prices[i],prices[j],sum));
                        if (prices[j] - prices[i] > sum) {
                            sum = prices[j] - prices[i];
                        }
                    }
                }
            }
            return sum;
        }
    }
    public static void main (String[] args) {
//        int[] prices = {1,2,3,0,0,0};
        int[] prices = {7,1,5,3,6,4};
//        int[] prices = {7,6,4,3,1};
//        int[] prices = {2,4,1};
        long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        long startTime = System.nanoTime();
        int op = new Solution().maxProfit(prices);
        long endTime = System.nanoTime();
        long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println("Output: " + op);
        System.out.println("\nTime Taken:" + (endTime - startTime)/1000000.0);
        System.out.println("Memory Used:" + (afterUsedMem-beforeUsedMem));
    }
}
