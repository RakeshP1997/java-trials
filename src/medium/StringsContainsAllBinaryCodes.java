package medium;

import java.util.HashSet;

/** Problem statement: 1461. Check If a String Contains All Binary Codes of Size K
 * https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/
 *
 * Given a binary string s and an integer k,
 * return true if every binary code of length k is a substring of s.
 * Otherwise, return false.
 */
public class StringsContainsAllBinaryCodes {
    static class Solution {
        /*//Approach 1
        public boolean hasAllCodes(String s, int k) {
            Map<String, Boolean> store = new HashMap<>(k, 1);
            for (int i = 0; i < s.length() - k + 1; i++) {
                store.put(s.substring(i, i + k), true);
            }
            System.out.println(store);
            if (store.size() == Math.pow(2,k)) {
                return true;
            }
            return false;
        }*/

        public boolean hasAllCodes(String s, int k) {
            double combo = Math.pow(2,k);
            HashSet<String> store = new HashSet<>();
            int start=0, end = k-1;
            while (end < s.length()) {
                String temp = s.substring(start,end+1);
                store.add(temp);
                if (store.size() == combo) {
                    return true;
                }
                start++;
                end++;
            }
            return false;
        }
    }

    public static void main(String[] args) {
//        String s = "00110110", k = "2";
//        String s = "0110", k = "1";
//        String s = "0110", k = "2";
        String s = "00110", k = "2";
        long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        long startTime = System.nanoTime();
        boolean op = new Solution().hasAllCodes(s, Integer.parseInt(k));
        long endTime = System.nanoTime();
        long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println();
        System.out.print("Output: ");
        System.out.println(op);
        System.out.println("\nTime Taken:" + (endTime - startTime)/1000000.0);
        System.out.println("Memory Used:" + (afterUsedMem-beforeUsedMem));
    }
}
