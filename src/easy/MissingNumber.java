package easy;

/**Problem stateent: 268. Missing Number
 * https://leetcode.com/problems/missing-number/
 *
 * Given an array nums containing n distinct numbers in the range [0, n],
 * return the only number in the range that is missing from the array.
 */
public class MissingNumber {
    static class Solution {
        //Initial approach
//        public int missingNumber(int[] nums) {
//            int sum1 = 0, sum2 = 0;
//            for (int i = 0; i < nums.length; i++) {
//                sum1+=nums[i];
//                sum2+=i;
//            }
//            sum2+=nums.length;
//            return sum2 - sum1;
//        }

        // Approach optimized
        public int missingNumber(int[] nums) {
            int sum1 = 0;
            int sum2 = (nums.length * (nums.length + 1))/2;
            for (int i = 0; i < nums.length; i++) {
                sum1+=nums[i];
            }
            return sum2 - sum1;
        }
    }

    public static void main(String[] args) {
        int[] ip = new int[]{3,0,1};
//        int[] ip = new int[]{0,1};
//        int[] ip = new int[]{9,6,4,2,3,5,7,0,1};
        long beforeUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long startTime = System.nanoTime();
        int op = new Solution().missingNumber(ip);
        long afterUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long endTime = System.nanoTime();
        System.out.println("Output: " + op);
        System.out.println("\nTime Taken:" + (endTime - startTime)/1000000.0);
        System.out.println("Memory Used:" + (afterUsedMem-beforeUsedMem));

    }
}
