package easy;

import java.util.ArrayList;
import java.util.List;

/** Problem statement: 94. Binary Tree Inorder Traversal
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 *
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 *
 */
public class BinaryTreeInorderTraversal {
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
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> op = new ArrayList<>();
            inorder(root, op);
            return op;
        }

        private void inorder(TreeNode root, List<Integer> op) {
            if (root == null)
                return;
            inorder(root.left, op);
            op.add(root.val);
            inorder(root.right, op);
        }
    }
}
