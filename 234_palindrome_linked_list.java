/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;

        // 0. count the length
        int len = 0;
        ListNode curr = head;
        while (curr != null) {
            len++;
            curr = curr.next;
        }
        // 1. find the middle node
        ListNode mid = head;
        for (int i = 0; i < (len / 2); i++) {
            mid = mid.next;
        }

        ListNode rev = reverse(mid, null);

        // 2. compare two linked list
        ListNode revCurr = rev, headCurr = head;
        while (revCurr != null && headCurr != null) {
            if (revCurr.val != headCurr.val) return false;
            revCurr = revCurr.next;
            headCurr = headCurr.next;
        }
        return true;
    }

    private ListNode reverse(ListNode curr, ListNode prev){
        if (curr == null) return null;

        ListNode next = curr.next;

        curr.next = prev;
        prev = curr;
        curr = next;

        if (next == null){
            ListNode reverseHead = prev;
            return reverseHead;
        }
        return reverse(curr, prev);
    }
}
