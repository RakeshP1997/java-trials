package twoPointer;

public class ReverseWordsInString {
    static class Solution {
        public void swap(char[] nums, int i, int j) {
            char temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        public String reverseString(char[] s) {
            int i =0, j = s.length -1;
            while (i<j) {
                swap(s, i++,j--);
            }
            return String.valueOf(s);
        }
        public String reverseWords(String s) {
            String[] arr = s.split(" ");
            String op = "";
            for (String word :
                    arr) {
                op += reverseString(word.toCharArray()) + " ";
            }
            return op.trim();
        }
    }
    public static void main (String[] args) {
        String ip= "Let's take LeetCode contest";
        long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println(beforeUsedMem);
        long startTime = System.nanoTime();
        System.out.println(startTime);
        System.out.println(new Solution().reverseWords(ip));
        long endTime = System.nanoTime();
        long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println(endTime);
        System.out.println(afterUsedMem);
        System.out.println("\nTime Taken:" + (endTime - startTime)/1000000.0);
        System.out.println("Memory Used:" + (afterUsedMem-beforeUsedMem));
    }
}
