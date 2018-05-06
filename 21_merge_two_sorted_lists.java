/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode head = result;
        while (l1 != null && l2 != null){
            ListNode node = new ListNode(0);
            if (l1.val > l2.val){
                node.val = l2.val;
                l2 = l2.next;
            }
            else if (l1.val < l2.val){
                node.val = l1.val;
                l1 = l1.next;
            }else{
                // select l1 to consume
                node.val = l1.val;
                l1 = l1.next;
            }

            if (result == null){
                result = node;
                head = result;
            }else{
                result.next = node;
                result = result.next;
            }
        }
        // append remaining node
        if (l1 != null){
            if (result == null){
                result = l1;
                head = result;
            }else{
                result.next = l1;
            }
        }
        if (l2 != null){
            if (result == null){
                result = l2;
                head = result;
            }else{
                result.next = l2;
            }
        }
        return head;
    }
}
