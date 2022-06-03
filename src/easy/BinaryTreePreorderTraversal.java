package easy;

import java.util.ArrayList;
import java.util.List;

/** Problem statement: 144. Binary Tree Preorder Traversal
 * https://leetcode.com/problems/binary-tree-preorder-traversal/
 *
 * Given the root of a binary tree, return the preorder traversal of its nodes' values.
 */
public class BinaryTreePreorderTraversal {

     public class TreeNode {
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
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> op = new ArrayList<>();
            preorder(root, op);
            return op;
        }
        public void preorder(TreeNode root, List<Integer> op) {
            if (root == null)
                return;
            op.add(root.val);
            preorder(root.left, op);
            preorder(root.right, op);
        }
    }
}
