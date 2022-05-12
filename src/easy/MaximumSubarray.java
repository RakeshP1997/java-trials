package easy;

/**Problem Statement
 * 53. Maximum Subarray
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum
 * and return its sum.
 *
 * A subarray is a contiguous part of an array.
 */
public class MaximumSubarray {
    static class Solution {
        public int maxSubArray(int[] nums) {
            int result = nums[0];
            int lastSum = nums[0];
            int maxSum = 0;
            for (int i =1; i < nums.length; i++) {
                maxSum = Math.max(lastSum + nums[i], nums[i]);
                result = Math.max(maxSum, result);
                lastSum = maxSum;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        int[] ip = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int output = new Solution().maxSubArray(ip);
        System.out.println("Output: " + output);
    }
}
