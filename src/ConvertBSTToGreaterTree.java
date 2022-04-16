import java.util.Arrays;

/**Problem statement
 * https://leetcode.com/problems/convert-bst-to-greater-tree/
 * Given the root of a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST
 * is changed to the original key plus the sum of all keys greater than the original key in BST.
 *
 * As a reminder, a binary search tree is a tree that satisfies these constraints:
 *  1. The left subtree of a node contains only nodes with keys less than the node's key.
 *  2. The right subtree of a node contains only nodes with keys greater than the node's key.
 *  3. Both the left and right subtrees must also be binary search trees.
 */
public class ConvertBSTToGreaterTree {
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
        private int accumulator = 0;
        public TreeNode convertBST(TreeNode root) {
            if (root == null) return null;
            if(root.right != null) convertBST(root.right);
            accumulator += root.val;
            root.val = accumulator;
            if (root.left != null) convertBST(root.left);
            return root;
        }
    }

    public static void printInOrder(TreeNode root) {
        if (root == null) {
            System.out.print("null ");
            return;
        }
        printInOrder(root.left);
        System.out.print(root.val + " ");
        printInOrder(root.right);
    }

    public static void printPreOrder(TreeNode root) {
        if (root == null) {
            System.out.print("null ");
            return;
        }
        System.out.print(root.val + " ");
        printInOrder(root.left);
        printInOrder(root.right);
    }

    public static void main(String[] args) {
        long beforeUsedMem = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        long startTime = System.nanoTime();
        TreeNode n1 = new TreeNode(0);
        TreeNode n8 = new TreeNode(3);
        TreeNode n2 = new TreeNode(2, null, n8);
        TreeNode n3 = new TreeNode(1, n1, n2);
        TreeNode n4 = new TreeNode(5);
        TreeNode n7 = new TreeNode(8);
        TreeNode n5 = new TreeNode(7,null, n7);
        TreeNode n6 = new TreeNode(6,n4,n5);
        TreeNode root = new TreeNode(4,n3,n6);

        TreeNode output = new Solution().convertBST(root);
        System.out.println("Output: ");
        System.out.print("InOrder: ");
        printInOrder(output);
        System.out.println();
        System.out.print("PreOrder: ");
        printPreOrder(output);
        long endTime = System.nanoTime();
        long afterUsedMem = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println("\nTime Taken:" + (endTime - startTime)/1000000.0);
        System.out.println("Memory Used:" + (afterUsedMem-beforeUsedMem));
    }
}
