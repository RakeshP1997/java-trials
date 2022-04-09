package twoPointer;

public class RemoveNthNodeFromEnd {
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    static class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode p1 = head;
            ListNode p2 = head;
            int i = 0;
            while(p2.next != null && i++ < n) {
                p2 = p2.next;
            }
            while (p1.next != null && p2.next != null) {
                p1 = p1.next;
                p2 = p2.next;
            }
            if (p1 == head && n-1 == i)
                head = head.next;
            if (p1.next != null)
                p1.next = p1.next.next;
            else
                return null;
            return head;
        }
    }
    public static void main (String[] args) {
        ListNode a5 = new ListNode(5);
        ListNode a4 = new ListNode(4, a5);
        ListNode a3 = new ListNode(3, a4);
        ListNode a2 = new ListNode(2, a3);
        ListNode a1 = new ListNode(1);
        long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
//        System.out.println(beforeUsedMem);
        long startTime = System.nanoTime();
//        System.out.println(startTime);
        ListNode op = new Solution().removeNthFromEnd(a1, 1);
        long endTime = System.nanoTime();
        long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
//        System.out.println(endTime);
//        System.out.println(afterUsedMem);
//        System.out.println(op.val);
        while (op != null) {
            System.out.print(op.val + " ");
            op = op.next;
        }
        System.out.println("\nTime Taken:" + (endTime - startTime)/1000000.0);
        System.out.println("Memory Used:" + (afterUsedMem-beforeUsedMem));
    }
}
