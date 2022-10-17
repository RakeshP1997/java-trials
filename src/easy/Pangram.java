package easy;

import java.util.HashMap;
import java.util.Map;

public class Pangram {
    static class Solution {
        //Option-1
//        public boolean checkIfPangram(String sentence) {
//            for (int i = 'a'; i < 'a' + 26; i++) {
//                if (sentence.indexOf(i) == -1) {
//                    return false;
//                }
//            }
//            return true;
//        }
        //Option-2
        public boolean checkIfPangram(String sentence) {
        Map<Character,Boolean> a = new HashMap<>();
        for (char c: sentence.toCharArray()) {
            a.putIfAbsent(c,true);
        }
            return a.size() == 26;
        }
    }

    public static void main(String[] args) {
//        String ip = "leetcode";
        String ip = "thequickbrownfoxjumpsoverthelazydog";
        long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        long startTime = System.nanoTime();
        boolean op = new Solution().checkIfPangram(ip);
        long endTime = System.nanoTime();
        long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println("Output: " + op);
        System.out.println("\nTime Taken:" + (endTime - startTime)/1000000.0);
        System.out.println("Memory Used:" + (afterUsedMem-beforeUsedMem));
    }
}
