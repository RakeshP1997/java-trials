package medium;

import easy.TwoSumII;

/** Problem statement: 167. Two Sum II - Input Array Is Sorted
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 *
 * Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order,
 * find two numbers such that they add up to a specific target number.
 * Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
 *
 * Return the indices of the two numbers, index1 and index2,
 * added by one as an integer array [index1, index2] of length 2.
 *
 * The tests are generated such that there is exactly one solution. You may not use the same element twice.
 *
 * Your solution must use only constant extra space.
 */
public class TwoSumIIInputArrayIsSorted {
    static class Solution {
        //Approach 1: Two pointer
        public int[] twoSum(int[] nums, int t) {
            int i=0,j=nums.length-1;
            while (i < j) {
                if (nums[i] + nums[j] == t) {
                    return new int[]{i + 1, j + 1};
                } else if (nums[i] + nums[j] > t) {
                    j--;
                } else {
                    i++;
                }
            }
            return new int[]{i+1, j+1};
        }
        /*//Approach 2: Using Binary Search
        public int[] twoSum(int[] nums, int t) {
            int  i = 0;
            while (i < nums.length - 1) {
                int op = search(nums, i + 1, t - nums[i]);
                if (op != -1)
                    return new int[]{i + 1, op + 1};
                i++;
            }
            return new int[] {i + 1, i + 1};
        }
        public int search(int[] nums,int start, int target) {
            int end = nums.length - 1;
            while (start <= end) {
                int middle = start + (end - start)/2;
                if (nums[middle] == target)
                    return middle;
                if (target < nums[middle]) {
                    end = middle - 1;
                }
                else {
                    start = middle + 1;
                }
            }
            return -1;
        }*/
    }

    public static void main(String[] args) {
        int[] ip = {2,7,11,15}; int t = 9;
//        int[] ip = {2,3,4}; int t = 6;
//        int[] ip = {-1,0}; int t = -1;
        long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        long startTime = System.nanoTime();
        int[] op = new Solution().twoSum(ip, t);
        long endTime = System.nanoTime();
        long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        for (int a :
                op) {
            System.out.print(a + " ");
        }
        System.out.println("\nTime Taken:" + (endTime - startTime)/1000000.0);
        System.out.println("Memory Used:" + (afterUsedMem-beforeUsedMem));
    }
}
