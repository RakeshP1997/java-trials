package medium;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {

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
    static class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> op = new ArrayList<>();
            return op;
        }
    }

    public static void main(String[] args) {

    }
}
