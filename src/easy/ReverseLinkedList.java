package easy;

/** Problem statement: 206. Reverse Linked List
 * https://leetcode.com/problems/reverse-linked-list/
 *
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 */
public class ReverseLinkedList {
    static private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    static class Solution {
        public ListNode reverseList(ListNode head) {
            if (head == null) {
                return null;
            } else if(head.next == null) {
                return head;
            }
            ListNode prev = null;
            ListNode curr = head;
            while(curr != null) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
            return prev;
        }
    }

    public static void main(String[] args) {
        ListNode n6 = new ListNode(6);
        ListNode n5 = new ListNode(5, n6);
        ListNode n4 = new ListNode(4, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(6, n3);
        ListNode n1 = new ListNode(2, n2);
        ListNode m1 = new ListNode(1, n1);
        long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        long startTime = System.nanoTime();
        ListNode head = new Solution().reverseList(m1);
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
