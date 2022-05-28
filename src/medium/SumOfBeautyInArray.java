package medium;

import easy.NumberOfStepsToReduceANumberToZero;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SumOfBeautyInArray {

    static class Solution {
        public int sumOfBeauties(int[] nums) {
            int[] maxStates = new int[nums.length];
            maxStates[0] = nums[0];
            for (int i = 1; i < nums.length - 1; i++) {
                    maxStates[i] = Math.max(maxStates[i-1], nums[i-1]);
            }
            int min = nums[nums.length - 1];
            System.out.println(Arrays.stream(maxStates).boxed().collect(Collectors.toList()));
            int sum = 0;
            for (int i = nums.length - 2; i > 0; i--) {
                min = Math.min(min, nums[i+1]);
                if (maxStates[i] < nums[i] && nums[i] < min) {
                    sum += 2;
                } else if (nums[i-1] < nums[i] && nums[i] < nums[i + 1]) {
                    sum+=1;
                }
            }
            return sum;
        }
    }

    public static void main (String[] args) {
//        int[] ip = new int[]{2, 4, 6, 4};
        int[] ip = new int[]{1,2,3};
        long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        long startTime = System.nanoTime();
        int op = new Solution().sumOfBeauties(ip);
        long endTime = System.nanoTime();
        long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println("Output: " + op);
        System.out.println("\nTime Taken:" + (endTime - startTime)/1000000.0);
        System.out.println("Memory Used:" + (afterUsedMem-beforeUsedMem));
    }
}
