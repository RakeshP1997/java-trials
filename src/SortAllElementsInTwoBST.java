import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.List;

/**Problem statement
 * https://leetcode.com/problems/trim-a-binary-search-tree/
 * Given the root of a binary search tree and the lowest and highest boundaries as low and high, trim the tree so that
 * all its elements lies in [low, high]. Trimming the tree should not change the relative structure of the elements that
 * will remain in the tree (i.e., any node's descendant should remain a descendant).
 * It can be proven that there is a unique answer.
 *
 * Return the root of the trimmed binary search tree. Note that the root may change depending on the given bounds.
 */
public class SortAllElementsInTwoBST {
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
        public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
            List<Integer> op = new ArrayList<>();
            List<Integer> i1 = new ArrayList<>();
            List<Integer> i2 = new ArrayList<>();
            inorder(root1, i1);
            inorder(root2, i2);
            int i1ittr = 0, i2ittr = 0;
            while (true) {
                if (i1ittr == i1.size()) {
                    op.addAll(i2.subList(i2ittr, i2.size()));
                    break;
                }
                if (i2ittr == i2.size()) {
                    op.addAll(i1.subList(i1ittr, i1.size()));
                    break;
                }
                if (i1.get(i1ittr) < i2.get(i2ittr)) {
                    op.add(i1.get(i1ittr++));
                } else {
                    op.add(i2.get(i2ittr++));
                }
            }
            return op;
        }

        private void inorder(TreeNode r, List<Integer> i) {
            if (r == null)
                return;
            inorder(r.left, i);
            i.add(r.val);
            inorder(r.right, i);
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
        TreeNode n2 = new TreeNode(3);
        TreeNode root1 = new TreeNode(1, n1, n2);
        TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(4);
        TreeNode root2 = new TreeNode(2,n3,n4);

        List<Integer> output = new Solution().getAllElements(root1, root2);
        System.out.println("Output: " + output);
        long endTime = System.nanoTime();
        long afterUsedMem = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println("\nTime Taken:" + (endTime - startTime)/1000000.0);
        System.out.println("Memory Used:" + (afterUsedMem-beforeUsedMem));
    }
}
