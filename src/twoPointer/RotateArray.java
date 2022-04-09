package twoPointer;

public class RotateArray {
    static class Solution {
        public void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        public void reverse(int[] nums, int start, int end) {
            while (start < end) {
                swap(nums, start++, end--);
            }
        }

        public void rotate(int[] nums, int k) {
            int actualSwaps = (k % nums.length);
            reverse(nums, 0, nums.length - actualSwaps - 1);
            reverse(nums, nums.length - actualSwaps, nums.length - 1);
            reverse(nums, 0 , nums.length - 1);
        }
    }
    public static void repeatSolution(int[] ip, int k) {
        new Solution().rotate(ip, k);
        System.out.println("Final op: ");
        for (int a :
                ip) {
            System.out.print(a + " ");
        }
        System.out.println();
    }
    public static void main (String[] args) {
        int [] ip = {1,2,3,4,5,6,7};// -7,-3,2,3,11
        int  k = 9;
        new Solution().rotate(ip, k);
        System.out.println();
        for (int a :
                ip) {
            System.out.print(a + " ");
        }
        System.out.println();
//        for (int i = 0 ; i < k; i++)
//            repeatSolution(ip, i);
    }
}
