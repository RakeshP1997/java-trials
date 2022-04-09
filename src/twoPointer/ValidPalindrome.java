package twoPointer;

public class ValidPalindrome {
    static class Solution {
        public boolean validPalindrome(String s) {
            int i=0,j=s.length() - 1;
            char[] chars = s.toCharArray();
            if (s.length() == 1)
                return true;
            while (i <= j) {
                if (chars[i] == chars[j]) {
                    i++;
                    j--;
                } else {
                    break;
                }
            }
            System.out.println(String.format("i: %d, j: %d",i,j));
            if (i >= j)
                return true;
            StringBuilder sb = new StringBuilder(s);
            StringBuilder sb1 = new StringBuilder(s);
            StringBuilder temp1 = new StringBuilder(sb.deleteCharAt(i));
            StringBuilder temp2 = new StringBuilder(sb1.deleteCharAt(j));
            if (temp1.toString().equalsIgnoreCase(temp1.reverse().toString()) || temp2.toString().equalsIgnoreCase(temp2.reverse().toString()))
                return true;
            return false;
        }
    }

    public static void main(String[] args) {
        String input = "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga";
//        String input = "ebcbbececabbacecbbcbe";
//        String input = "aea";
        boolean isValid = new Solution().validPalindrome(input);
        System.out.println("Is Palindrome Valid:" + isValid);
    }
}
