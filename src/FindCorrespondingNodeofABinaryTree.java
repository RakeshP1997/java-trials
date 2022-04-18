import java.util.Stack;

/**Problem statement
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 * Given the root of a binary search tree, and an integer k,
 * return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
 */
public class FindCorrespondingNodeofABinaryTree {
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
        private boolean targetFound = false;
        public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
            if (cloned == null) return null;
            if (target.val == cloned.val) {
                targetFound = true;
                return cloned;
            }
            TreeNode temp;
            return (temp = getTargetCopy(original, cloned.left, target)) != null ? temp : getTargetCopy(original, cloned.right, target);
        }
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

        TreeNode output = new Solution().getTargetCopy(root, root, n1);
        System.out.println("Output: " + output.val);
        long endTime = System.nanoTime();
        long afterUsedMem = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println("\nTime Taken:" + (endTime - startTime)/1000000.0);
        System.out.println("Memory Used:" + (afterUsedMem-beforeUsedMem));
    }
}
