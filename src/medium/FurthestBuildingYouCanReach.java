package medium;

import java.util.PriorityQueue;

/**Problem statement: 1642. Furthest Building You Can Reach
 * https://leetcode.com/problems/furthest-building-you-can-reach/
 *
 * You are given an integer array heights representing the heights of buildings, some bricks, and some ladders.
 *
 * You start your journey from building 0 and move to the next building by possibly using bricks or ladders.
 *
 * While moving from building i to building i+1 (0-indexed),
 *
 * If the current building's height is greater than or equal to the next building's height, you do not need a ladder or bricks.
 * If the current building's height is less than the next building's height, you can either use one ladder or (h[i+1] - h[i]) bricks.
 * Return the furthest building index (0-indexed) you can reach if you use the given ladders and bricks optimally.
 */
public class FurthestBuildingYouCanReach {
    static class Solution {
        public int furthestBuilding(int[] heights, int bricks, int ladders) {
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            int i = 0;
            for (; i < heights.length - 1; i++) {
                int diff = heights[i+1] - heights[i];
                if (diff > 0) {
                    minHeap.add(diff);
                    if (minHeap.size() > ladders) {
                        bricks-= minHeap.poll();
                    }
                    if(bricks<0) break;
                }
            }
            return i;
        }
    }

    public static void main(String[] args) {
        int heights[] = {4,12,2,7,3,18,20,3,19}, bricks = 10, ladders = 2;
//        int heights = {14,3,19,3}, bricks = 17, ladders = 0;
//        int heights[] = {4,2,7,6,9,14,12}, bricks = 5, ladders = 1;
        long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        long startTime = System.nanoTime();
        int op = new Solution().furthestBuilding(heights, bricks, ladders);
        long endTime = System.nanoTime();
        long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println("Output: " + op);
        System.out.println("\nTime Taken:" + (endTime - startTime)/1000000.0);
        System.out.println("Memory Used:" + (afterUsedMem-beforeUsedMem));
    }
}
