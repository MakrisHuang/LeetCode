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
    public boolean isValidBST(TreeNode root) {
        return valid(root, null, null);
    }
    
    private boolean valid(TreeNode curr, Integer low, Integer high){
        if (curr == null) return true;
        return (low == null || curr.val > low) &&
               (high == null || curr.val < high) &&
            
                // the curr.val will be high node for next comparison (i.e. next recursion)
               valid(curr.left, low, curr.val) && 
               valid(curr.right, curr.val, high);
    }
}