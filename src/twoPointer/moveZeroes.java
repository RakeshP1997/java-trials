package twoPointer;

public class moveZeroes {
    static class Solution {
        public void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        public void moveZeroes(int[] nums) {
            int i = 1,j = 0;
            while (j < nums.length && nums[j] != 0) {
                j++;
                i++;
            }
            while(i < nums.length) {
                if (nums[i] != 0) {
                    swap(nums, i , j);
                    while (j < nums.length && nums[j] != 0) {
                        j++;
                    }
                }
                i++;
            }
        }
    }
    public static void main (String[] args) {
        int [] ip = {0,9,0,0,0,0,1,0,3,12};// -7,-3,2,3,11
        new Solution().moveZeroes(ip);
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
