package easy;

/** Problem statement: 242. Valid Anagram
 * https://leetcode.com/problems/valid-anagram/
 *
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 */
public class ValidAnagram {
    static class Solution {
        /*//Approach 1
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length())
                return false;
            for (char c :
                    s.toCharArray()) {
                t = t.replaceFirst(String.valueOf(c), "");
            }
            if (t.isEmpty()) {
                return true;
            }
            return false;
        }*/
        public boolean isAnagram(String s, String t) {
            int[] alphabets = new int[26];
            for (char c :
                    s.toCharArray()) {
                alphabets[c - 97]++;
            }
            for (char c :
                    t.toCharArray()) {
                alphabets[c - 97]--;
                if (alphabets[c - 97] == -1) {
                    return false;
                }
            }
            for (int a :
                    alphabets) {
                if (a != 0) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
//        String s = "anagram", t = "nagaram";
        String s = "rat", t = "car";
        long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        long startTime = System.nanoTime();
        boolean op = new Solution().isAnagram(s, t);
        long endTime = System.nanoTime();
        long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println();
        System.out.print("Output: ");
        System.out.println(op);
        System.out.println("\nTime Taken:" + (endTime - startTime)/1000000.0);
        System.out.println("Memory Used:" + (afterUsedMem-beforeUsedMem));
    }
}
