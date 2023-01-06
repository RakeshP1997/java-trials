package medium;

import java.util.Arrays;

public class MaximumIceCreamBars {
    static class Solution {
        public int maxIceCream(int[] costs, int coins) {
            Arrays.sort(costs);
            int i = 0;
            while (i < costs.length && coins >= costs[i]) {
                coins-=costs[i++];
            }
            return i;
        }
    }

    public static void main(String[] args) {
        int[] costs = new int[]{1, 3, 2, 4, 1};
        int coins = 7;
        long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        long startTime = System.nanoTime();
        int op = new Solution().maxIceCream(costs, coins);
        long endTime = System.nanoTime();
        long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println("Output: " + op);
        System.out.println("\nTime Taken:" + (endTime - startTime)/1000000.0);
        System.out.println("Memory Used:" + (afterUsedMem-beforeUsedMem));
    }
}
