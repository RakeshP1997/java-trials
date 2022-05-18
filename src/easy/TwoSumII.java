package easy;

import java.util.HashMap;
import java.util.Map;

public class TwoSumII {
    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> store = new HashMap<>(nums.length, 1);
            for (int i = 0; i< nums.length; i++) {
                store.put(nums[i], i);
            }
            for (int i =0; i< nums.length; i++) {
                int presentVal = store.getOrDefault(target - nums[i], Integer.MIN_VALUE);
                if (presentVal != Integer.MIN_VALUE && i != presentVal)
                    return new int[]{i, presentVal};
            }
            return new int[]{-1,-1};
        }
    }

    public static void main (String[] args) {
        int [] ip = {3,3};// -7,-3,2,3,11
        int target = 6;
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
