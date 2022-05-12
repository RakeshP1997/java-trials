package easy;

import java.util.LinkedHashMap;
import java.util.Map;

public class ContainsDuplicates {
    public static class Solution {
        public boolean containsDuplicate(int[] nums) {
            Map<Integer, Integer> store = new LinkedHashMap<>();
            for (Integer i :
                    nums) {
                if (store.get(i) != null) {
                    return true;
                }
                store.put(i, 1);
            }
            return false;
        }
    }

    public static void main(String[] args) {
        int[] input = {10,12,13,17,16,15,11};
        boolean output = new Solution().containsDuplicate(input);
        System.out.println("Output: " + output);
    }
}
