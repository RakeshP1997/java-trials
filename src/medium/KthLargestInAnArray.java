package medium;

import java.util.PriorityQueue;
import java.util.Queue;

/**Problem statement: 215. Kth Largest Element in an Array
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 *
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 *
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 */
public class KthLargestInAnArray {
    static class Solution {
        public int findKthLargest(int[] nums, int k) {
            Queue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
            for(int i = 0; i< nums.length; i++) {
                pq.add(nums[i]);
            }
            while (--k > 0) {
                pq.poll();
            }
            return pq.poll();
        }
    }

    public static void main(String[] args) {
        int nums[] = {3,2,1,5,6,4}, k = 2;
//        int nums[] = {3,2,3,1,2,4,5,5,6}, k = 4;
        long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        long startTime = System.nanoTime();
        int op = new Solution().findKthLargest(nums, k);
        long endTime = System.nanoTime();
        long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println("Output: " + op);
        System.out.println("\nTime Taken:" + (endTime - startTime)/1000000.0);
        System.out.println("Memory Used:" + (afterUsedMem-beforeUsedMem));
    }
}
