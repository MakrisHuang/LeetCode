/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode curr = node;
        ListNode prev = null;
        while (curr.next != null) {
            ListNode next = curr.next;
            curr.val = next.val;
            if (next.next == null) prev = curr;

            curr = next;
        }
        prev.next = null;
    }
}
