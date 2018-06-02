/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode reverseHead = null;
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null){
            ListNode next = curr.next;

            if (next == null){
                reverseHead = curr;
            }

            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return reverseHead;
    }
}
