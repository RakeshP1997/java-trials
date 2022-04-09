package twoPointer;

public class TwoSum {
    static class Solution {
        public void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
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
    }
    public static void main (String[] args) {
        int [] ip = {-1,0};// -7,-3,2,3,11
        int target = -1;
        long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println(beforeUsedMem);
        long startTime = System.nanoTime();
        System.out.println(startTime);
        int[] op = new Solution().twoSum(ip, target);
        long endTime = System.nanoTime();
        long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println(endTime);
        System.out.println(afterUsedMem);
        for (int a :
                op) {
            System.out.print(a + " ");
        }
        System.out.println("\nTime Taken:" + (endTime - startTime)/1000000.0);
        System.out.println("Memory Used:" + (afterUsedMem-beforeUsedMem));
    }
}
