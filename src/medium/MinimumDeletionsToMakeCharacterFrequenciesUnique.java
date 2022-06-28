package medium;

import java.util.HashSet;

/** Problem statement: 1647. Minimum Deletions to Make Character Frequencies Unique
 * https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/
 *
 * A string s is called good if there are no two different characters in s that have the same frequency.
 *
 * Given a string s, return the minimum number of characters you need to delete to make s good.
 *
 * The frequency of a character in a string is the number of times it appears in the string.
 * For example, in the string "aab", the frequency of 'a' is 2, while the frequency of 'b' is 1.
 */
 public class MinimumDeletionsToMakeCharacterFrequenciesUnique {
    static class Solution {
        public int minDeletions(String s) {
            int[] freq = new int[26];
            int count = 0;
            for(int i = 0; i<s.length(); i++){
                freq[s.charAt(i)-'a'] ++;
            }

            HashSet<Integer> hs = new HashSet<>();
            for(int i = 0; i<freq.length; i++){
                while(freq[i]!=0 && hs.contains(freq[i])){
                    freq[i]--;
                    count++;
                }
                hs.add(freq[i]);
            }
            return count;
        }
    }

    public static void main(String[] args) {
        String s = "aab";
        s = "aaabbbcc";
        s = "ceabaacb";
        long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        long startTime = System.nanoTime();
        int op = new Solution().minDeletions(s);
        long endTime = System.nanoTime();
        long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println("Output: " + op);
        System.out.println("\nTime Taken:" + (endTime - startTime)/1000000.0);
        System.out.println("Memory Used:" + (afterUsedMem-beforeUsedMem));
    }
}
