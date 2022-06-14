package medium;

/**Problem statement: 583. Delete Operation for Two Strings
 * https://leetcode.com/problems/delete-operation-for-two-strings/
 *
 * Given two strings word1 and word2, return the minimum number of steps required to make word1 and word2 the same.
 *
 * In one step, you can delete exactly one character in either string.
 */
 public class DeleteOperationForTwoStrings {
    static class Solution {
        public int minDistance(String word1, String word2) {
            int m = word1.length();
            int n = word2.length();

            int[] dp = new int[n+1];
            for(int i = 1 ; i < m+1 ;i++){
                int[] temp = new int[n+1];
                for(int j = 1 ; j < n+1 ; j++){
                    if(word1.charAt(i-1) == word2.charAt(j-1))
                        temp[j] = 1+dp[j-1];

                    else
                        temp[j] = Math.max(dp[j] , temp[j-1]);
                }
                dp = temp;
            }
            return m+n-(2*dp[n]);
        }
    }

    public static void main(String[] args) {
        String word1 = "sea", word2 = "eat";
//        String word1 = "leetcode", word2 = "etco";
        long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        long startTime = System.nanoTime();
        int op = new Solution().minDistance(word1, word2);
        long endTime = System.nanoTime();
        long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println("Output: " + op);
        System.out.println("\nTime Taken:" + (endTime - startTime)/1000000.0);
        System.out.println("Memory Used:" + (afterUsedMem-beforeUsedMem));
    }
}
