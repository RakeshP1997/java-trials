package medium;

public class MaximumProductOfWordLengths {

    static class Solution {
        public int maxProduct(String[] words) {
            int[] bitmasks = new int[words.length];
            int max = 0;
            for (int i = 0; i < words.length; i++) {
                for (char c :
                        words[i].toCharArray()) {
                    bitmasks[i] |= (1 << c - 'a');
                }
            }
            for (int i = 0; i < words.length; i++) {
                for (int j = i + 1; j < words.length; j++) {
                    if ((bitmasks[i] & bitmasks[j]) == 0) {
                        max = Math.max(words[i].length() * words[j].length(), max);
                    }
                }
            }
            return max;
        }
    }

    public static void main(String[] args) {
//        String[] ip = {"abcw","baz","foo","bar","xtfn","abcdef"};
//        String[] ip = {"a","ab","abc","d","cd","bcd","abcd"};
        String[] ip = {"a","aa","aaa","aaaa"};
        long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        long startTime = System.nanoTime();
        int op = new Solution().maxProduct(ip);
        long endTime = System.nanoTime();
        long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println("Output: ");
        System.out.println(op);
        System.out.println("\nTime Taken:" + (endTime - startTime)/1000000.0);
        System.out.println("Memory Used:" + (afterUsedMem-beforeUsedMem));
    }
}
