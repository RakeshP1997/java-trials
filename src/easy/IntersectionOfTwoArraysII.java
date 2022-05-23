package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArraysII {
    static class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            Map<Integer, Integer> store = new HashMap<>(nums1.length, 1);
            for (int n :
                    nums1) {
                store.put(n, store.getOrDefault(n, 0) + 1);
            }
            List<Integer> intersection = new ArrayList<>(nums2.length);
            for (int n :
                    nums2) {
                int temp = store.getOrDefault(n, -1);
                if (temp > 0) {
                    store.put(n, temp - 1);
                    intersection.add(n);
                }
            }
            return intersection.stream().mapToInt(Integer::intValue).toArray();
        }
    }

    public static void main (String[] args) {
        int [] num1 = {1,2,3,0,0,0};
        int [] num2 = {2,5,6};
        int target = 6;
        long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println(beforeUsedMem);
        long startTime = System.nanoTime();
        System.out.println(startTime);
        int[] op = new Solution().intersect(num1, num2);
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
