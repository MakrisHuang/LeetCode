/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private ListNode list;
    
    public TreeNode sortedListToBST(ListNode head) {
        int n = 0;
        ListNode p = head;
        while (p != null){
            n++;
            p = p.next;
        }
        list = head;
        return sortedLinkedListToBST(0, n - 1);
    }
    
    private TreeNode sortedLinkedListToBST(int start, int end){
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode leftChild = sortedLinkedListToBST(start, mid - 1);
        
        TreeNode parent = new TreeNode(list.val);
        
        parent.left = leftChild;
        list = list.next; // move to next element
        
        TreeNode rightChild = sortedLinkedListToBST(mid + 1, end);
        parent.right = rightChild;
        
        return parent;
    }
}