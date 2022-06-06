package easy;

import medium.BinaryTreeLevelOrderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/** Problem statement: 101. Symmetric Tree
 * https://leetcode.com/problems/symmetric-tree/
 *
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 */
public class SymmetricTree {

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
        public boolean isSymmetric(TreeNode root) {
            if (root == null)
                return true;
            return symmetrical(root.left, root.right);
        }
        private boolean symmetrical(TreeNode r1, TreeNode r2) {
            if (r1 == null && r2 == null)
                return true;
            if (r1 == null || r2 == null)
                return false;
            return (r1.val == r2.val)&&symmetrical(r1.left,r2.right)&&symmetrical(r1.right,r2.left);
        }
    }

    public static void main(String[] args) {
        TreeNode n = new TreeNode(15);
        TreeNode n1 = new TreeNode(7);
        TreeNode n2 = new TreeNode(20, n, n1);
        TreeNode n3 = new TreeNode(9);
        TreeNode root = new TreeNode(3, n3, n2);
        long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        long startTime = System.nanoTime();
        boolean op = new Solution().isSymmetric(root);
        long endTime = System.nanoTime();
        long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println();
        System.out.print("Output: ");
        System.out.println(op);
        System.out.println("\nTime Taken:" + (endTime - startTime)/1000000.0);
        System.out.println("Memory Used:" + (afterUsedMem-beforeUsedMem));
    }
}
