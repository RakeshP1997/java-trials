package easy;

/** Problem statement: 141. Linked List Cycle
 * https://leetcode.com/problems/linked-list-cycle/
 *
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 *
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously
 * following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is
 * connected to. Note that pos is not passed as a parameter.
 *
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 */
public class LinkedListCycle {

     static class ListNode {
         int val;
         ListNode next;
         ListNode(int x) {
             val = x;
             next = null;
         }
         ListNode(int x, ListNode next) {
             val = x;
             this.next = next;
         }
         void setNext(ListNode next) {
             this.next = next;
         }
     }
    static class Solution {
        public boolean hasCycle(ListNode head) {
            if (head == null || head.next == null) {
                return false;
            }
            ListNode temp1 = head;
            ListNode temp2 = head.next;
            while (temp1 != null && temp2!= null && temp2.next != null) {
                if (temp1 == temp2) {
                    return true;
                }
                temp1 = temp1.next;
                temp2 = temp2.next.next;
            }
            return false;
        }
    }

    public static void main(String[] args) {
         ListNode n3 = new ListNode(-4);
         ListNode n2 = new ListNode(0, n3);
         ListNode n1 = new ListNode(2, n2);
         ListNode head = new ListNode(3, n1);
         n3.setNext(n1);
        long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        long startTime = System.nanoTime();
        boolean op = new Solution().hasCycle(head);
        long endTime = System.nanoTime();
        long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println();
        System.out.print("Output: ");
        System.out.println(op);
        System.out.println("\nTime Taken:" + (endTime - startTime)/1000000.0);
        System.out.println("Memory Used:" + (afterUsedMem-beforeUsedMem));
    }
}
