package easy;

import java.util.Stack;

/** Problem statement: 20. Valid Parentheses
 * https://leetcode.com/problems/valid-parentheses/
 *
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * 1. Open brackets must be closed by the same type of brackets.
 * 2. Open brackets must be closed in the correct order.
 */
 public class ValidParentheses {
    static class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            for (char c :
                    s.toCharArray()) {
                switch (c) {
                    case ')':
                        if (!stack.empty() && stack.peek().compareTo('(') == 0)
                            stack.pop();
                        else
                            stack.push(c);
                        break;
                    case ']':
                        if (!stack.empty() && stack.peek().compareTo('[') == 0)
                            stack.pop();
                        else
                            stack.push(c);
                        break;
                    case '}':
                        if (!stack.empty() && stack.peek().compareTo('{') == 0)
                            stack.pop();
                        else
                            stack.push(c);
                        break;
                    default:
                        stack.push(c);
                }
            }
            return stack.empty();
        }
    }

    public static void main(String[] args) {
        String s;
//        s = "()";
//        s = "()[]{}";
        s = "(]";
        long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        long startTime = System.nanoTime();
        boolean op = new Solution().isValid(s);
        long endTime = System.nanoTime();
        long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println("Output: " + op);
        System.out.println("\nTime Taken:" + (endTime - startTime)/1e6D);
        System.out.println("Memory Used:" + (afterUsedMem-beforeUsedMem));
    }
}
