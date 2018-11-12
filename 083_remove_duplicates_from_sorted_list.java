/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode first = head;
        while(first.next != null){
            ListNode dup = first;
            while (dup.next != null){           // find duplicated values
                if (dup.val == dup.next.val){
                    dup = dup.next;
                }else break;
            }
            if (dup.next != null){
                if (first.val != dup.next.val){ // find new unique value
                    first.next = dup.next;      // set next element with new unique one
                    first = dup.next;           // move first index to next unique value
                }
            }else{                              // meet the end of the list
                first.next = null;
            }
        }
        return head;
    }
}
