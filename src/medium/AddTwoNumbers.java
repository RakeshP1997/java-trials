package medium;

/** Problem statement: 2. Add Two Numbers
 * https://leetcode.com/problems/add-two-numbers/
 *
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
public class AddTwoNumbers {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode head = new ListNode();
            ListNode tempHead = head;
            int carry = 0;
            while (l1 != null && l2 != null) {
                int sum = l1.val + l2.val + carry;
                tempHead.next = new ListNode(sum%10);
                carry = sum/10;
                tempHead = tempHead.next;
                l1 = l1.next;
                l2 = l2.next;
            }
            while (l1 != null) {
                int sum = l1.val + carry;
                tempHead.next = new ListNode(sum%10);
                carry = sum/10;
                tempHead = tempHead.next;
                l1 = l1.next;
            }
            while (l2 != null) {
                int sum = l2.val + carry;
                tempHead.next = new ListNode(sum%10);
                carry = sum/10;
                tempHead = tempHead.next;
                l2 = l2.next;
            }
            if (carry != 0) {
                tempHead.next = new ListNode(carry);
            }
            return head.next;
        }
    }

    public static void main(String[] args) {
        ListNode l13 = new ListNode(3);
        ListNode l12 = new ListNode(4, l13);
        ListNode l11 = new ListNode(2, l12);
        ListNode l23 = new ListNode(4);
        ListNode l22 = new ListNode(6, l23);
        ListNode l21 = new ListNode(5, l22);
        long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        long startTime = System.nanoTime();
        ListNode op = new Solution().addTwoNumbers(l11, l21);
        long endTime = System.nanoTime();
        long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        while (op != null) {
            System.out.print(op.val + " ");
            op = op.next;
        }
        System.out.println("\nTime Taken:" + (endTime - startTime)/1000000.0);
        System.out.println("Memory Used:" + (afterUsedMem-beforeUsedMem));
    }
}
