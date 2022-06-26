package medium;

public class NonDecreasingArray {
    static class Solution {
        public boolean checkPossibility(int[] nums) {

            int cnt = 0;

            for(int i = 0; i<nums.length-1 ; i++) // length - 1 is to prevent overflow or index out of bounds
            {
                if(nums[i]>nums[i+1]) // 1st step check if the current value is greater than the next or not
                {
                    cnt++;  //if the condition is met increase the count value
                    if(i>0 && nums[i-1]>nums[i+1])nums[i+1] = nums[i]; //Now check if the previous value is greater than the next value or not
                    else nums[i] = nums[i+1]; // if not then simply put the next value in present one
                }

            }
            return cnt<=1; // because it's stated that we are allowed to make only one change

        }
    }

    public static void main(String[] args) {
        int[] ip = {4,2,3};
//        int[] ip = {4,2,1};
        long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        long startTime = System.nanoTime();
        boolean op = new Solution().checkPossibility(ip);
        long endTime = System.nanoTime();
        long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println("Output: " + op);
        System.out.println("\nTime Taken:" + (endTime - startTime)/1000000.0);
        System.out.println("Memory Used:" + (afterUsedMem-beforeUsedMem));
    }
}
