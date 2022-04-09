
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreeSum {
    static class Solution {

        static class BinarySearch {
            public static int search(int[] nums, int start, int end, int target) {
                if (end >= start) {
                    int middle = start + (end - 1) / 2;
                    if (nums[middle] == target)
                        return middle;
                    if (target < nums[middle])
                        return search(nums, start, middle - 1, target);
                    return search(nums, middle + 1, end, target);
                }
                return -1;
            }
        }

        public List<List<Integer>> threeSum(int[] nums) {
            if (nums.length < 4)
                return new ArrayList<>();
            int[] t = new int[nums.length];
            AtomicInteger tempittr = new AtomicInteger();
            Arrays.stream(nums).sorted().forEach( e -> {
                t[tempittr.getAndIncrement()] = e;
            });
            if (t[0] > 0)
                return new ArrayList<>();
            for (int i = 0; i < nums.length ; i++) {
                BinarySearch.search(nums, 1, nums.length -1, 0);
            }
            return new ArrayList<>();
        }
    }
    public static void main (String[] args) {
        int[] ip = {-1,0,1,2,-1,-4};
        long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
//        System.out.println(beforeUsedMem);
        long startTime = System.nanoTime();
//        System.out.println(startTime);
        List<List<Integer>> op = new Solution().threeSum(ip);
        long endTime = System.nanoTime();
        long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
//        System.out.println(endTime);
//        System.out.println(afterUsedMem);
        System.out.println(op);
        System.out.println("\nTime Taken:" + (endTime - startTime)/1000000.0);
        System.out.println("Memory Used:" + (afterUsedMem-beforeUsedMem));
    }
}
