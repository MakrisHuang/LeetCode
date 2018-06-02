class Solution {
    public ListNode reverseList(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        ListNode reverseHead = reverse(curr, prev);
        return reverseHead;
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
