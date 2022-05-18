package easy;

import java.util.Arrays;

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
