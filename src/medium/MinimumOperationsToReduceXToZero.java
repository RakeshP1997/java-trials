package medium;

/** Problem statement: 1658. Minimum Operations to Reduce X to Zero
 * https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/
 *
 * You are given an integer array nums and an integer x.
 * In one operation,
 * you can either remove the leftmost or the rightmost element from the array nums and subtract its value from x.
 * Note that this modifies the array for future operations.
 *
 * Return the minimum number of operations to reduce x to exactly 0 if it is possible, otherwise, return -1.
 */
public class MinimumOperationsToReduceXToZero {
    static class Solution {
        private int[] prefixes, suffixes;
        private void prefixSum(int[] nums) {
            prefixes = new int[nums.length];
            int i = 1;
            prefixes[0] = nums[0];
            while (i < nums.length) {
                prefixes[i] = prefixes[i - 1] + nums[i];
                i++;
            }
        }

        private void suffixSum(int[] nums) {
            suffixes = new int[nums.length];
            int i = nums.length - 1;
            suffixes[i] = nums[i];
            while (--i > -1) {
                suffixes[i] = suffixes[i + 1] + nums[i];
            }
        }

        public int minOperations(int[] nums, int x) {
            prefixSum(nums);
            suffixSum(nums);
            int i = 0, j = nums.length - 1;
            int minOps = Integer.MAX_VALUE;
            while (i < nums.length && prefixes[i] <= x) {
                if (prefixes[i]==x) {
                    minOps = Math.min(minOps, i + 1);
                    break;
                }
                i++;
            }
            while (j > 0 && suffixes[j] <= x) {
                if (suffixes[j]==x) {
                    minOps = Math.min(minOps, nums.length - j);
                    break;
                }
                j--;
            }
            int ops = 0;
            int t1 = 0,t2 = nums.length - 1;
            for (int k = 0; k < nums.length && prefixes[k] < x; k++) {
                for (int l = nums.length - 1, temp = prefixes[k] + suffixes[l]; l > -1 && temp <= x; l--, temp = prefixes[k] + suffixes[l]) {
                    if (temp == x) {
                        minOps = Math.min(minOps, k + 1 + nums.length - l);
                    }
                }
            }
            if (minOps == Integer.MAX_VALUE)
                return -1;
            return minOps;
        }
    }

    public static void main(String[] args) {
//        int[] nums = {1,1,4,2,3}; int x = 5;
//        int[] nums = {5,6,7,8,9}; int x = 4;
//        int[] nums = {3,2,20,1,1,3}; int x = 10;
        int[] nums = {1,1}; int x = 3;
        long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        long startTime = System.nanoTime();
        int op = new Solution().minOperations(nums, x);
        long endTime = System.nanoTime();
        long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println("Output: " + op);
        System.out.println("\nTime Taken:" + (endTime - startTime)/1000000.0);
        System.out.println("Memory Used:" + (afterUsedMem-beforeUsedMem));
    }
}
