package easy;

/** Problem statement: 112. Path SUm
 * https://leetcode.com/problems/path-sum/
 *
 * Given the root of a binary tree and an integer targetSum,
 * return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.
 *
 * A leaf is a node with no children.
 */
public class PathSum {

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
        public boolean hasPathSum(TreeNode root, int targetSum) {
            if (root == null)
                return false;
            return sum(root, 0, targetSum);
        }
        private boolean sum(TreeNode root, int currentSum, int targetSum) {
            if (root == null)
                 return false;
            if (root.left == null && root.right == null && targetSum == currentSum + root.val)
                return true;

            return sum(root.left, currentSum + root.val, targetSum) || sum(root.right, currentSum + root.val, targetSum);
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
        boolean op = new Solution().hasPathSum(root, 12);
        long endTime = System.nanoTime();
        long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println();
        System.out.print("Output: ");
        System.out.println(op);
        System.out.println("\nTime Taken:" + (endTime - startTime)/1000000.0);
        System.out.println("Memory Used:" + (afterUsedMem-beforeUsedMem));
    }
}
