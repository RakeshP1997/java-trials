import java.util.List;

/**Problem Statement:
 * https://leetcode.com/problems/count-sorted-vowel-strings/
 * Given an integer n, return the number of strings of length n that consist only of vowels (a, e, i, o, u) and are lexicographically sorted.
 *
 * A string s is lexicographically sorted if for all valid i, s[i] is the same as or comes before s[i+1] in the alphabet.
 *
 * */
public class CountSortedVowelStrings {
    static class Solution {
        private List<Character> chars = List.of('a','e','i','o','u');
        private String chr = "aeiou";
        private int cnt(int n, char c) {
            if (n == 1) {
                return 5 - chars.indexOf(c);
            }
            int acc = 0;
            char[] temp = chr.substring(chars.indexOf(c)).toCharArray();
            for (char ch : temp) {
                acc += cnt(n-1, ch);
            }
            return acc;
        }

        public int countVowelStrings(int n) {
            return cnt(n,'a');
        }
    }

    static class FasterSolutionFormulaBased {
        public int countVowelStrings(int n) {
            return (n + 4) * (n + 3) * (n + 2) * (n + 1) / 24;
        }
    }

    public static void main(String[] args) {
        long beforeUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long startTime = System.nanoTime();
        int ip = 3;
        int output = new Solution().countVowelStrings(ip);
        System.out.println("Output: " + output);
        long endTime = System.nanoTime();
        long afterUsedMem = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println("\nTime Taken:" + (endTime - startTime)/1000000.0);
        System.out.println("Memory Used:" + (afterUsedMem-beforeUsedMem));
    }
}
