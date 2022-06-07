package medium;

/** Problem statement: 98. Validate Binary Search Tree
 * https://leetcode.com/problems/validate-binary-search-tree/
 *
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 *
 * A valid BST is defined as follows:
 *
 * 1. The left subtree of a node contains only nodes with keys less than the node's key.
 * 2. The right subtree of a node contains only nodes with keys greater than the node's key.
 * 3. Both the left and right subtrees must also be binary search trees.
 */
public class ValidateBST {
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
        public boolean isValidBST(TreeNode root) {
            if(root == null || (root.left == null && root.right == null))
                return true;
            return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        private boolean isValidBST(TreeNode root, int min, int max) {
            if(root == null)
                return true;

            if(root.val < min || root.val > max) {
                return false;
            }

            if(root.val == Integer.MIN_VALUE && root.left != null) {
                return false;
            }
            if(root.val == Integer.MAX_VALUE && root.right != null) {
                return false;
            }

            boolean leftValid = isValidBST(root.left, min, root.val-1);
            boolean rightValid = isValidBST(root.right, root.val+1, max);
            return leftValid && rightValid;
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
        boolean op = new Solution().isValidBST(root);
        long endTime = System.nanoTime();
        long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println();
        System.out.print("Output: ");
        System.out.println(op);
        System.out.println("\nTime Taken:" + (endTime - startTime)/1000000.0);
        System.out.println("Memory Used:" + (afterUsedMem-beforeUsedMem));
    }
}
