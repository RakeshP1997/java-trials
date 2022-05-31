package easy;

public class MergeTwoSortedLinkedList {

    static public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
    static class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            if (list1 == null) {
                return list2;
            } else if (list2 == null) {
                return list1;
            } else if (list1 == null && list2 == null) {
                return null;
            }
            ListNode head = new ListNode(-1);
            ListNode temp = head;
            while (list1 != null && list2 != null) {
                if (list1.val < list2.val) {
                    temp.next = list1;
                    list1 = list1.next;
                } else {
                    temp.next = list2;
                    list2 = list2.next;
                }
                temp = temp.next;
            }
            while (list1 != null) {
                temp.next = list1;
                temp = temp.next;
                list1 = list1.next;
            }
            while (list2 != null) {
                temp.next = list2;
                temp = temp.next;
                list2 = list2.next;
            }
            return head.next;
        }
    }
    public static void main(String[] args) {
        ListNode n2 = new ListNode(4);
        ListNode n1 = new ListNode(2, n2);
        ListNode m1 = new ListNode(1, n1);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(3, n3);
        ListNode m2 = new ListNode(1, n4);
        long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        long startTime = System.nanoTime();
        ListNode head = new Solution().mergeTwoLists(m1, m2);
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
