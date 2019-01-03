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
        ListNode curr = head;
        ListNode temp = null;
        ListNode reverseHead = head;

        while (curr != null && curr.next != null) {
            ListNode next = curr.next;

            curr.next = next.next;      // connect to third node: curr -> next -> next.next => curr.next = next.next
            next.next = reverseHead;    // connect to previous node

            reverseHead = next;         // set reverse head with new node
        }

        return reverseHead;
    }
}
