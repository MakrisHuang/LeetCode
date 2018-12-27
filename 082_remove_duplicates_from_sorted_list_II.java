/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = head;
        ListNode prev = dummy;
        while (curr != null) {
            ListNode next = curr.next;
            // keep searching for duplicate ones
            int count = 1;
            while (next != null && next.val == curr.val) {
                next = next.next;
                count++;
            }
            if (count > 1) {
                prev.next = next;
            }
            if (count == 1) {
                prev = curr;
            }
            curr = next;
        }

        return dummy.next;
    }
}
