package easy;

import java.util.HashMap;
import java.util.Map;

/** Problem statement: 383. Ransom Note
 * https://leetcode.com/problems/ransom-note/
 *
 * Given two strings ransomNote and magazine,
 * return true if ransomNote can be constructed from magazine and false otherwise.
 *
 * Each letter in magazine can only be used once in ransomNote.
 */
public class RansomNote {

    static class Solution {
        /*//Approach 1
        public boolean canConstruct(String ransomNote, String magazine) {
            int[] alphabets = new int[26];
            for (char c :
                    magazine.toCharArray()) {
                alphabets[c - 97]++;
            }
            for (char c :
                    ransomNote.toCharArray()) {
                alphabets[c - 97]--;
                if (alphabets[c - 97] == -1) {
                    return false;
                }
            }
            return true;
        }*/

        public boolean canConstruct(String ransomNote, String magazine) {
            Map<Character, Integer> store = new HashMap<>(26, 1);
            for (char c :
                    magazine.toCharArray()) {
                store.put(c, store.getOrDefault(c, 0) + 1);
            }
            for (char c :
                    ransomNote.toCharArray()) {
                int t = store.getOrDefault(c, 0);
                if (t == 0) {
                    return  false;
                }
                store.put(c, --t);
            }
            return true;
        }
    }

    public static void main(String[] args) {
        String ransomNote = "a", magazine = "b";
//        String ransomNote = "aa", magazine = "ab";
//        String ransomNote = "aa", magazine = "aab";
        long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        long startTime = System.nanoTime();
        boolean op = new Solution().canConstruct(ransomNote, magazine);
        long endTime = System.nanoTime();
        long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println();
        System.out.print("Output: ");
        System.out.println(op);
        System.out.println("\nTime Taken:" + (endTime - startTime)/1000000.0);
        System.out.println("Memory Used:" + (afterUsedMem-beforeUsedMem));
    }
}
