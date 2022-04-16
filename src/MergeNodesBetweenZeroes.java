import java.util.Arrays;

/**Problem statement
 * https://leetcode.com/problems/merge-nodes-in-between-zeros/
 * You are given the head of a linked list, which contains a series of integers separated by 0's.
 * The beginning and end of the linked list will have Node.val == 0.
 *
 * For every two consecutive 0's, merge all the nodes lying in between them into a single node whose value is the sum
 * of all the merged nodes. The modified list should not contain any 0's.
 *
 * Return the head of the modified linked list.
 */
public class MergeNodesBetweenZeroes {
    static public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    static class Solution {
        public ListNode mergeNodes(ListNode head) {
            ListNode temp = head.next, tempPointer = head;
            while (temp.next != null) {
                tempPointer.val += temp.val;
                if (temp.val == 0) {
                    tempPointer.next = temp;
                    tempPointer = tempPointer.next;
                }
                temp = temp.next;
            }
            tempPointer.next = null;
            return head;
        }
    }

    public static void printNodes(ListNode output) {
        while (output != null) {
            System.out.print( output.val + " ");
            output = output.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        long beforeUsedMem = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        long startTime = System.nanoTime();
        ListNode head = null;
        ListNode temp = head;
        int[] ip = new int[]{0,3, 1, 0, 4, 5, 2, 0};
//        int[] ip = new int[] {0,1,0,3,0,2,2,0};
        for (int i : ip) {
            ListNode temp1 = new ListNode(i);
            if (head == null) {
                head = temp = temp1;
            }
            temp.next = temp1;
            temp = temp1;
        }
        ListNode output = new Solution().mergeNodes(head);
        System.out.println("Output: ");
        printNodes(output);
        long endTime = System.nanoTime();
        long afterUsedMem = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println("\nTime Taken:" + (endTime - startTime)/1000000.0);
        System.out.println("Memory Used:" + (afterUsedMem-beforeUsedMem));
    }
}
