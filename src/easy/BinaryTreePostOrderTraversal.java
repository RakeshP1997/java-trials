package easy;

import java.util.ArrayList;
import java.util.List;

/** Problem statement: 145. Binary Tree Postorder Traversal
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 *
 * Given the root of a binary tree, return the postorder traversal of its nodes' values.
 */
public class BinaryTreePostOrderTraversal {

    private class TreeNode {
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

    class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> op = new ArrayList<>();
            postorder(root, op);
            return op;
        }

        private void postorder(TreeNode root, List<Integer> op) {
            if (root == null)
                return;
            postorder(root.left,op);
            postorder(root.right, op);
            op.add(root.val);
        }
    }
}
