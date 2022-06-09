package easy;

/** Problem statement: 1332. Remove Palindromic Subsequences
 * https://leetcode.com/problems/remove-palindromic-subsequences/
 *
 * You are given a string s consisting only of letters 'a' and 'b'.
 * In a single step you can remove one palindromic subsequence from s.
 *
 * Return the minimum number of steps to make the given string empty.
 *
 * A string is a subsequence of a given string if it is generated by deleting some characters of a given string
 * without changing its order. Note that a subsequence does not necessarily need to be contiguous.
 *
 * A string is called palindrome if is one that reads the same backward as well as forward.
 */
public class RemovePalindromicSubsequence {
    static class Solution {
        /*private boolean isPalindrome(String s) {
            StringBuilder sb = new StringBuilder(s);
            return s.equals(sb.reverse().toString());
        }*/
        private boolean isPalindrome(String s) {
            int p = 0, q = s.length() - 1;
            while (p <= q) {
                if (s.charAt(p++) != s.charAt(q--))
                    return false;
            }
            return true;
        }
        public int removePalindromeSub(String s) {
            return isPalindrome(s) ? 1 : 2;
        }
    }
    public static void main(String[] args) {
        String s;
        s = "abba";
        s = "ababa";
//        s = "baabb";
        long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        long startTime = System.nanoTime();
        int op = new Solution().removePalindromeSub(s);
        long endTime = System.nanoTime();
        long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println();
        System.out.print("Output: ");
        System.out.println(op);
        System.out.println("\nTime Taken:" + (endTime - startTime)/1000000.0);
        System.out.println("Memory Used:" + (afterUsedMem-beforeUsedMem));
    }
}
