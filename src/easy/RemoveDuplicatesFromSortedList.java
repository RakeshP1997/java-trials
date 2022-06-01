package easy;

/** Problem statement: 83. Remove Duplicates from Sorted List
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 *
 * Given the head of a sorted linked list, delete all duplicates such that each element appears only once.
 * Return the linked list sorted as well.
 */
public class RemoveDuplicatesFromSortedList {
    static private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    static class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null) {
                return null;
            } else if(head.next == null) {
                return head;
            }
            ListNode temp = head;
            while (head != null && head.next != null) {
                if (head.val == head.next.val) {
                    head.next = head.next.next;
                } else {
                    head = head.next;
                }
            }
            return temp;
        }
    }

    public static void main(String[] args) {
        ListNode n6 = new ListNode(6);
        ListNode n5 = new ListNode(5, n6);
        ListNode n4 = new ListNode(4, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode ndup1 = new ListNode(3, n3);
        ListNode n1 = new ListNode(2, ndup1);
        ListNode m1 = new ListNode(1, n1);
        long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        long startTime = System.nanoTime();
        ListNode head = new Solution().deleteDuplicates(m1);
        long endTime = System.nanoTime();
        long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println();
        System.out.print("Output: ");
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println("\nTime Taken:" + (endTime - startTime)/1000000.0);
        System.out.println("Memory Used:" + (afterUsedMem-beforeUsedMem));
    }
}
