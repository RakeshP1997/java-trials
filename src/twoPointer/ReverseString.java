package twoPointer;

public class ReverseString {
    static class Solution {
        public void swap(char[] nums, int i, int j) {
            char temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        public void reverseString(char[] s) {
            int i =0, j = s.length -1;
            while (i<j) {
                swap(s, i++,j--);
            }
        }
    }
    public static void main (String[] args) {
        String ip= "Hannah";
        char[] ch = ip.toCharArray();
        long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println(beforeUsedMem);
        long startTime = System.nanoTime();
        System.out.println(startTime);
        new Solution().reverseString(ch);
        long endTime = System.nanoTime();
        long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println(endTime);
        System.out.println(afterUsedMem);
        for (char a :
                ch) {
            System.out.print(a + " ");
        }
        System.out.println("\nTime Taken:" + (endTime - startTime)/1000000.0);
        System.out.println("Memory Used:" + (afterUsedMem-beforeUsedMem));
    }
}
