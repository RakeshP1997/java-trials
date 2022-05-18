package easy;

/**Problem Statement
 * https://leetcode.com/problems/merge-sorted-array/
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n,
 * representing the number of elements in nums1 and nums2 respectively.
 *
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 *
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
 * To accommodate this, nums1 has a length of m + n,
 * where the first m elements denote the elements that should be merged,
 * and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 */
public class MergeSortedArrays {

    static class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            if (m == 0) {
                for (int i = 0; i < n; i++) {
                    nums1[i] = nums2[i];
                }
                return;
            } else if (n == 0) {
                return;
            }
            int i = m + n - 1;
            m--;
            n--;
            while (m > -1  && n > -1) {
                if (nums1[m] >= nums2[n]) {
                    nums1[i--] = nums1[m--];
                } else {
                    nums1[i--] = nums2[n--];
                }
            }
            while (n > -1) {
                nums1[i--] = nums2[n--];
            }
        }
    }
    public static void main (String[] args) {
        int [] num1 = {1,2,3,0,0,0};// -7,-3,2,3,11
        int [] num2 = {2,5,6};// -7,-3,2,3,11
        int target = 6;
        long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println(beforeUsedMem);
        long startTime = System.nanoTime();
        System.out.println(startTime);
        new Solution().merge(num1, num1.length - num2.length, num2, num2.length);
        long endTime = System.nanoTime();
        long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println(endTime);
        System.out.println(afterUsedMem);
        for (int a :
                num1) {
            System.out.print(a + " ");
        }
        System.out.println("\nTime Taken:" + (endTime - startTime)/1000000.0);
        System.out.println("Memory Used:" + (afterUsedMem-beforeUsedMem));
    }
}
