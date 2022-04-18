import java.util.Stack;

/**Problem statement
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 * Given the root of a binary search tree, and an integer k,
 * return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
 */
public class KthSmallestElementInBST {
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
        public int kthSmallest(TreeNode root, int k) {
            Stack<TreeNode> stack = new Stack<>();
            int result = -1;
            while (root != null) {
                stack.push(root);
                result = root.val;
                root = root.left;
            }
            while (!stack.isEmpty() && k > 0) {
                TreeNode removedNode = stack.pop();
                result = removedNode.val;
                k--;
                TreeNode right = removedNode.right;
                while (right != null) {
                    stack.push(right);
                    right = right.left;
                }
            }
            return result;
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
        printPreOrder(root.left);
        printPreOrder(root.right);
    }

    public static void main(String[] args) {
        long beforeUsedMem = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        long startTime = System.nanoTime();
        //left tree
        TreeNode n5 = new TreeNode(1);
        TreeNode n3 = new TreeNode(2, n5, null);
        TreeNode n4 = new TreeNode(4);
        TreeNode n1 = new TreeNode(3, n3, n4);

        //right tree
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(9);
        TreeNode n6 = new TreeNode(8, n7, n8);
        TreeNode n2 = new TreeNode(6, null, n6);

        TreeNode root = new TreeNode(5, n1, n2);

        int output = new Solution().kthSmallest(root, 9);
        System.out.println("Output: " + output);
        long endTime = System.nanoTime();
        long afterUsedMem = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println("\nTime Taken:" + (endTime - startTime)/1000000.0);
        System.out.println("Memory Used:" + (afterUsedMem-beforeUsedMem));
    }
}
