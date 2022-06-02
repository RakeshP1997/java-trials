package easy;

public class RunningSumOf1DArray {
    static class Solution {
        public int[] runningSum(int[] nums) {
            for (int i = 1; i < nums.length; i++) {
                nums[i] = nums[i] + nums[i - 1];
            }
            return nums;
        }
    }

    public static void main(String[] args) {
//        int[] ip = {1,2,3,4};
//        int[] ip = {1,1,1,1,1};
        int[] ip = {3,1,2,10,1};
        long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        long startTime = System.nanoTime();
        int[] op = new Solution().runningSum(ip);
        long endTime = System.nanoTime();
        long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println();
        System.out.print("Output: ");
        for (int a :
                op) {
            System.out.print(a + " ");
        }
        System.out.println("\nTime Taken:" + (endTime - startTime)/1000000.0);
        System.out.println("Memory Used:" + (afterUsedMem-beforeUsedMem));
    }
}
