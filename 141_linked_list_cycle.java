/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
//         if (head == null) return false;

//         Map<ListNode, Boolean> map = new HashMap<>();
//         ListNode curr = head;
//         while (curr != null) {
//             if (!map.containsKey(curr)) {
//                 map.put(curr, true);
//             } else {
//                 if (map.get(curr)) return true;
//             }
//             curr = curr.next;
//         }
//         return false;

        // O(1) space with O(n) time complexity
        ListNode slow=head, fast=head;
        while(fast!=null&& fast.next!=null){
            // 一個走一步，另一個走兩步。就算走兩步的走比較快，
            // 走比較慢的至少可以確保每個節點都有走過
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)return true;
        }
        return false;

    }
}
