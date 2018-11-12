/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = head;
        ListNode prev = dummy;
        while (p != null && p.next != null){
            ListNode q = p.next;
            ListNode r = q.next;
            prev.next = q;

            // then swap two of them
            q.next = p;
            p.next = r;

            // move to next pair
            prev = p;
            p = r;
        }
        return dummy.next;
    }
}
