package hard;

/** Problem statement: 4. Median of Two Sorted Arrays
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 *
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 *
 * The overall run time complexity should be O(log (m+n)).
 */
public class MedianOfTwoSortedArrays {
    static class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int sum = nums1.length + nums2.length, i = nums1.length - 1, j = nums2.length - 1;
            int[] arr = new int[sum];
            while (i > -1 && j > -1) {
                if (nums1[i] > nums2[j]) {
                    arr[--sum] = nums1[i--];
                } else {
                    arr[--sum] = nums2[j--];
                }
            }
            while (i > -1) {
                arr[--sum] = nums1[i--];
            }
            while (j > -1) {
                arr[--sum] = nums2[j--];
            }
            int median = (nums1.length + nums2.length - 1)/2;
            if ((nums1.length + nums2.length)%2 == 0) {
                return ((double)(arr[median] + arr[median + 1]))/2.00000D;
            }
            return (double)arr[median];
        }
    }

    public static void main(String[] args) {
        int[] num1 = new int[]{1,3};
        int[] num2 = new int[]{2};
//        int[] num1 = new int[]{1, 2};
//        int[] num2 = new int[]{3, 4};
        long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        long startTime = System.nanoTime();
        double op = new Solution().findMedianSortedArrays(num1, num2);
        long endTime = System.nanoTime();
        long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println("Output: " + op);
        System.out.println("\nTime Taken:" + (endTime - startTime)/1000000.0);
        System.out.println("Memory Used:" + (afterUsedMem-beforeUsedMem));
    }
}
