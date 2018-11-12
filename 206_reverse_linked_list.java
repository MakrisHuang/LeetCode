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
        if (head == null) return null;
        
        ListNode reverseHead = null;
        ListNode curr = head;
        ListNode temp = null;
        
        while (curr != null) {
            ListNode node = new ListNode(curr.val);
            
            node.next = temp;
            reverseHead = node;
            
            temp = reverseHead;
            
            curr = curr.next;
        }
        return reverseHead;
    }
}