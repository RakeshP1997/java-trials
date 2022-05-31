package easy;

/** Problem statement: 203. Remove Linked List Elements
 * https://leetcode.com/problems/remove-linked-list-elements/
 *
 * Given the head of a linked list and an integer val,
 * remove all the nodes of the linked list that has Node.val == val, and return the new head.
 */
public class RemoveLinkedListElements {
    static public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    static class Solution {
        public ListNode removeElements(ListNode head, int val) {
            if (head == null) {
                return null;
            }
            ListNode newHead = new ListNode(-1);
            ListNode temp = newHead;
            while(head != null) {
                if (head.val != val) {
                    temp.next = head;
                    temp = temp.next;
                }
                head = head.next;
            }
            temp.next = null;
            return newHead.next;
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
        ListNode head = new Solution().removeElements(m1, 6);
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
