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
        // move values (from current to tail) 1 step forward
        // Time Complexity: O(n);
        while (curr.next != null) {
            ListNode next = curr.next;
            curr.val = next.val;
            if (next.next == null) prev = curr;

            curr = next;
        }
        prev.next = null;
    }
}
