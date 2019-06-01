/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        ListNode curr = head;
        ListNode prev = dummy;
        while (curr != null) {
            while (curr != null && curr.val == val) curr = curr.next;
            prev.next = curr;
            prev = curr;
            if (curr != null) curr = curr.next;
        }
        return dummy.next;
    }
}
