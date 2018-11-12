/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;

        ListNode curr = head;
        int len = 1;
        while (curr.next != null) {
            curr = curr.next;
            len++;
        }
        if (len == 1) return head;

        int offset = len - (k % len);

        ListNode newHead = head;
        ListNode newHeadBefOne = null;
        while (offset > 0) {
            if (offset == 1) newHeadBefOne = newHead;
            newHead = newHead.next;
            if (newHead == null) newHead = head;
            offset--;
        }

        if (newHead != head){ // then append remaining to newHead
            ListNode node = newHead;
            while (node.next != null) node = node.next;
            node.next = head; // append from the first
            newHeadBefOne.next = null; // cut off the remaining
        }
        return newHead;
    }
}
