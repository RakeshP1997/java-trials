package twoPointer;

public class SquaresOfSortedArray {
    static class Solution {
        public int[] sortedSquares(int[] nums) {
            int[] ss = new int[nums.length];
            int i=0,j= nums.length-1, ssInd = nums.length-1;
            while (i<=j) {
                int sq1 = nums[i] * nums[i];
                int sq2 = nums[j] * nums[j];
                if (sq1 > sq2) {
                    ss[ssInd--] = sq1;
                    i++;
                } else {
                    ss[ssInd--] = sq2;
                    j--;
                }
            }
            return ss;
        }
    }
    public static void main (String[] args) {
        int [] ip = {-7,-4,-3,-1,0,2,3,3,10,11};// -7,-3,2,3,11
        for (int a :
                new Solution().sortedSquares(ip)) {
            System.out.print(a + " ");
        }
    }
}
