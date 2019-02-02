/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        // create two list then combine together
        ListNode dumm1 = new ListNode(0);
        ListNode dumm2 = new ListNode(0);
        ListNode l1 = dumm1;
        ListNode l2 = dumm2;
        ListNode curr = head;

        while (curr != null) {
            if (curr.val < x) {
                l1.next = curr;
                l1 = l1.next;
            } else {
                l2.next = curr;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        // concate
        l1.next = dumm2.next;
        l2.next = null;
        return dumm1.next;
    }
}
