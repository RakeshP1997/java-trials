import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**Problem statement
 * https://leetcode.com/problems/top-k-frequent-elements/
 * Given an integer array nums and an integer k,
 * return the k most frequent elements. You may return the answer in any order.
*/
public class TopKFrequentElements {
    static class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            Map<String, Integer> buffer = new HashMap<String, Integer>();
            for (int i = 0; i < nums.length; i++) {
                buffer.put(String.valueOf(nums[i]), buffer.getOrDefault(String.valueOf(nums[i]), 0) + 1);
            }
            ArrayList<Map.Entry<String, Integer>> sortedArray = new ArrayList<Map.Entry<String, Integer>>();
            for (Map.Entry b:
            buffer.entrySet()){
                sortedArray.add(b);
            }
            Collections.sort(sortedArray, (o1, o2) -> Integer.compare(o2.getValue(), o1.getValue()));
            Map<String, Integer> sortedValues = new LinkedHashMap();
            int[] result = new int[k];
            int ittr = 0;
            for (Map.Entry<String, Integer> b : sortedArray.subList(0,k)) {
                result[ittr++] = Integer.parseInt(b.getKey());
            }
            return result;
        }
    }

    public static void main(String[] args) {
        long beforeUsedMem = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        long startTime = System.nanoTime();
        int[] ip = {1,1,1,2,2,3};
        int k = 2;
        int[] op = new Solution().topKFrequent(ip, k);
        System.out.print("Output: ");
        Arrays.stream(op).forEach(num -> System.out.print(num + " "));
        long endTime = System.nanoTime();
        long afterUsedMem = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println("\nTime Taken:" + (endTime - startTime)/1000000.0);
        System.out.println("Memory Used:" + (afterUsedMem-beforeUsedMem));
    }
}
