package medium;

public class SplitArrayIntoConsecutiveSubsequences {

    private static class Solution {
        private boolean isAscendingSubsequence(int[] nums, int itr, int cnt) {
            if (itr < nums.length - 1) {
                if (nums[itr] == nums[itr + 1] - 1) {
                    return isAscendingSubsequence(nums, itr + 1, cnt + 1);
                } else {
                    return isAscendingSubsequence(nums, itr + 1, cnt);
                }
            } else return cnt > 2;
        }

        public boolean isPossible(int[] nums) {
            if (nums.length < 3) {
                return false;
            }
            int itr = 0;
            boolean isSequence = false;
            while (itr < nums.length - 1) {
                isSequence = isAscendingSubsequence(nums, itr++, 0) || isSequence;
            }
            return isSequence;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,3};
        long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        long startTime = System.nanoTime();
        boolean op = new Solution().isPossible(nums);
        long endTime = System.nanoTime();
        long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println("Output: " + op);
        System.out.println("\nTime Taken:" + (endTime - startTime)/1000000.0);
        System.out.println("Memory Used:" + (afterUsedMem-beforeUsedMem));
    }
}
