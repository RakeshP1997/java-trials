package medium;

import java.util.ArrayList;
import java.util.List;

/**Problem Statement
 * https://leetcode.com/problems/permutations-ii/
 * Given a collection of numbers, nums, that might contain duplicates,
 * return all possible unique permutations in any order.
 *
 */
public class PermutationsII {
    private static class Solution {
        private List<Integer> uniqueValues = new ArrayList<>();
        public List<List<Integer>> permuteUnique(int[] nums) {
            uniqueValues.add(nums[0]);
            return permute(nums);
        }
        private List<List<Integer>> permute(int[] nums) {
            return new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        int[] ip = new int[]{1,2,3};
        //int[] ip = new int[]{1,1,2};
//        List<List<Integer>> output = new Solution().permuteUnique(ip);
        System.out.println(String.format("invoking next workflow since Glue job: %s, jobRunID: %s " +
                        "has failed after max retries at step: %s.",
                "abc",
                "abc",
                null));
        System.out.print("Output: ");
//        System.out.println(output);
    }
}
