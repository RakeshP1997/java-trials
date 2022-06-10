package medium;


import java.util.HashMap;
import java.util.Map;

/** Problem statement: 3. Longest Substring Without Repeating Characters
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * Given a string s, find the length of the longest substring without repeating characters.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            int l = 0;
            int maxLen = -1;
            char[] arr = s.toCharArray();
            Map<Character, Integer> keys = new HashMap<>();
            int i = 0, j = 0;
            while (i < arr.length) {
                if (!keys.containsKey(arr[i])) {
                    keys.put(arr[i], 1);
                    l++;
                    i++;
                } else {
                    maxLen = Math.max(maxLen, l);
                    keys.remove(arr[j]);
                    j++;
                    l--;

                }
            }
            return Math.max(maxLen, l);
        }
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        s = "bbbbb";
        s = "pwwkew";
        long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        long startTime = System.nanoTime();
        int op = new Solution().lengthOfLongestSubstring(s);
        long endTime = System.nanoTime();
        long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println("Output: " + op);
        System.out.println("\nTime Taken:" + (endTime - startTime)/1000000.0);
        System.out.println("Memory Used:" + (afterUsedMem-beforeUsedMem));
    }
}
