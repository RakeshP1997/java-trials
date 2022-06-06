package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

     public static class TreeNode {
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
            if (root == null)
                return new ArrayList<>();
            List<List<Integer>> op = new ArrayList<>();
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            while (!q.isEmpty()) {
                List<Integer> level = new ArrayList<>();
                int size = q.size();
                for (int i = 0; i< size; i++){
                    TreeNode ele = q.poll();
                    level.add(ele.val);
                    if (ele.left != null)
                        q.add(ele.left);
                    if (ele.right != null)
                        q.add(ele.right);
                }
                op.add(level);
            }
            return op;
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
        List<List<Integer>> op = new Solution().levelOrder(root);
        long endTime = System.nanoTime();
        long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println();
        System.out.print("Output: ");
        System.out.println(op);
        System.out.println("\nTime Taken:" + (endTime - startTime)/1000000.0);
        System.out.println("Memory Used:" + (afterUsedMem-beforeUsedMem));
    }
}
