/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getListLength(headA);
        int lenB = getListLength(headB);

        ListNode currA = headA, currB = headB;
        if (lenA > lenB) {
            int diff = lenA - lenB;
            while (diff-- > 0) currA = currA.next;
        } else{
            int diff = lenB - lenA;
            while (diff-- > 0) currB = currB.next;
        }

        while (currA != null && currB != null && (currA != currB)) {
            currA = currA.next;
            currB = currB.next;
        }
        return currA;
    }

    private int getListLength(ListNode node) {
        int len = 0;
        while (node != null) {
            len++;
            node = node.next;
        }
        return len;
    }
}
