/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode curr = head;
        ListNode prev = null;

        // initialize curr and prev position
        while (m > 1) {
            prev = curr;
            curr = curr.next;
            m--;
            n--;
        }

        ListNode con = prev, tail = curr;
        while (n > 0) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            n--;
        }

        // Adjust the final connections as explained in the algorithm
        if (con != null) {
            con.next = prev;
        } else {
            head = prev;
        }

        tail.next = curr;
        return head;
    }
}
