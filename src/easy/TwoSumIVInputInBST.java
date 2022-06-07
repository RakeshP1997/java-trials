package easy;

import medium.ValidateBST;

import java.util.HashMap;
import java.util.Map;

/** Problem statement: 653. Two Sum IV - Input is a BST
 * https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
 *
 * Given the root of a Binary Search Tree and a target number k,
 * return true if there exist two elements in the BST such that their sum is equal to the given target.
 */
public class TwoSumIVInputInBST {
     static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }
    static class Solution {
        Map<Integer, Boolean> op = new HashMap<>();
        public boolean findTarget(TreeNode n, int k) {
            if (n == null) return false;
            if (op.containsKey(k - n.val)) {
                return true;
            } else {
                op.put(n.val, true);
            }
            return findTarget(n.left, k) || findTarget(n.right, k);
        }
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(7);
        TreeNode n = new TreeNode(3);
        TreeNode n2 = new TreeNode(6, n, n1);
        TreeNode n3 = new TreeNode(4);
        TreeNode root = new TreeNode(5, n3, n2);
        long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        long startTime = System.nanoTime();
        boolean op = new Solution().findTarget(root, 9);
        long endTime = System.nanoTime();
        long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println();
        System.out.print("Output: ");
        System.out.println(op);
        System.out.println("\nTime Taken:" + (endTime - startTime)/1000000.0);
        System.out.println("Memory Used:" + (afterUsedMem-beforeUsedMem));
    }
}
