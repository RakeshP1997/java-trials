package easy;

/**Problem statement: 1342. Number of Steps to Reduce a Number to Zero
 * https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/
 *
 * Given an integer num, return the number of steps to reduce it to zero.
 *
 * In one step, if the current number is even, you have to divide it by 2, otherwise, you have to subtract 1 from it.
 */
public class NumberOfStepsToReduceANumberToZero {
    static class Solution {
        public int numberOfSteps(int num) {
            int cnt = 0;
            while(num != 0) {
                num = num%2 == 0 ? num/2 : num-1;
                cnt++;
            }
            return cnt;
        }
    }

    public static void main (String[] args) {
        long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        long startTime = System.nanoTime();
        int op = new Solution().numberOfSteps(14);
        long endTime = System.nanoTime();
        long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println("Output: " + op);
        System.out.println("\nTime Taken:" + (endTime - startTime)/1000000.0);
        System.out.println("Memory Used:" + (afterUsedMem-beforeUsedMem));
    }
}
