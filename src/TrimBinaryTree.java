import java.util.Arrays;

/**Problem statement
 * https://leetcode.com/problems/trim-a-binary-search-tree/
 * Given the root of a binary search tree and the lowest and highest boundaries as low and high, trim the tree so that
 * all its elements lies in [low, high]. Trimming the tree should not change the relative structure of the elements that
 * will remain in the tree (i.e., any node's descendant should remain a descendant).
 * It can be proven that there is a unique answer.
 *
 * Return the root of the trimmed binary search tree. Note that the root may change depending on the given bounds.
 */
public class TrimBinaryTree {
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
        public TreeNode trimBST(TreeNode root, int low, int high) {
            if (root == null) return root;
            if (root.val < low) return trimBST(root.right, low, high);
            if (root.val > high) return trimBST(root.left, low, high);
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
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
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2, n1, null);
        TreeNode n3 = new TreeNode(0, null, n2);
        TreeNode n4 = new TreeNode(4);
        TreeNode root = new TreeNode(3,n3,n4);

        TreeNode output = new Solution().trimBST(root, 1, 3);
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
