package easy;

import medium.SearchA2DMatrix;

import java.util.LinkedHashMap;
import java.util.Map;

/** Problem statement: 387. First Unique Character in a String
 * https://leetcode.com/problems/first-unique-character-in-a-string/
 *
 * Given a string s, find the first non-repeating character in it and return its index.
 * If it does not exist, return -1.
 */
public class FirstUniqueCharInaString {
    static class Solution {
        /*//Approach 1
        public int firstUniqChar(String s) {
            Map<Character, Integer> op = new LinkedHashMap<>(s.length(),1);
            int i = 0;
            for (char c :
                    s.toCharArray()) {
                if (op.containsKey(c)) {
                    op.put(c,-1);
                } else {
                    op.put(c,i);
                }
                i++;
            }
            for (Map.Entry<Character, Integer> e :
                    op.entrySet()) {
                if (e.getValue() != -1) {
                    return e.getValue();
                }
            }
            return -1;
        }*/

        //Approach 2
        public int firstUniqChar(String s) {
            int[] arr = new int[26];
            for (char c :
                    s.toCharArray()) {
                arr[c - 'a']++;
            }
            for (int i = 0; i < s.length(); i++) {
                if (arr[s.charAt(i) - 'a'] == 1) {
                    return i;
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
//        String ip = "leetcode";
//        String ip = "loveleetcode";
        String ip = "aabb";
        long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        long startTime = System.nanoTime();
        int op = new Solution().firstUniqChar(ip);
        long endTime = System.nanoTime();
        long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println();
        System.out.print("Output: ");
        System.out.println(op);
        System.out.println("\nTime Taken:" + (endTime - startTime)/1000000.0);
        System.out.println("Memory Used:" + (afterUsedMem-beforeUsedMem));
    }
}
