import java.util.Arrays;

/**Problem statement
 * https://leetcode.com/problems/search-in-a-binary-search-tree/
 * You are given the root of a binary search tree (BST) and an integer val.
 * Find the node in the BST that the node's value equals val and return the subtree rooted with that node.
 * If such a node does not exist, return null.
 */
public class SearchInBinaryTree {
    static public class TreeNode {
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
        public TreeNode searchBST(TreeNode root, int val) {
            TreeNode head = root;
            TreeNode temp = null;
            if (root == null) {
                return temp;
            }
            if (root != null && root.val == val) {
                return root;
            }
            temp = searchBST(root.left, val);
            if (temp == null)
                temp = searchBST(root.right, val);
            return temp;
        }
    }

    public static void main(String[] args) {
        long beforeUsedMem = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        long startTime = System.nanoTime();
        TreeNode leftLeft = new TreeNode(1);
        TreeNode leftRight = new TreeNode(3);
        TreeNode left = new TreeNode(2, leftLeft, leftRight);
        TreeNode right = new TreeNode(7);
        TreeNode root = new TreeNode(4,left,right);

        TreeNode output = new Solution().searchBST(root, 2);
        System.out.println("Output: " + output != null ? output.val : null);
        long endTime = System.nanoTime();
        long afterUsedMem = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println("\nTime Taken:" + (endTime - startTime)/1000000.0);
        System.out.println("Memory Used:" + (afterUsedMem-beforeUsedMem));
    }
}
