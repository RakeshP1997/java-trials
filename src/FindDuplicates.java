import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicates {
    public static class Solution {
        public int[] duplicates(int[] nums) {
            List<Integer> output = new ArrayList<>();
            Map<Integer, Integer> store = new HashMap<>();
            for (Integer i :
                    nums) {
                store.put(i, store.getOrDefault(i, 0) + 1);
            }
            for (Map.Entry e :
                    store.entrySet()) {
                if (e.getValue().equals(2)) {
                    output.add((Integer) e.getKey());
                }
            }
            return output.stream()
                    .mapToInt(Integer::intValue)
                    .toArray();
        }
    }

    public static void main(String[] args) {
        int[] input = {10,12,10,11,13,17,16,15,11};
        int [] output = new Solution().duplicates(input);
        for (int op :
                output) {
            System.out.println(op);
        }
    }
}
