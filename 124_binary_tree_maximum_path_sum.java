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
    
    public int maxPathSum(TreeNode root) {
        int[] ans = new int[] {Integer.MIN_VALUE};
        findMaxPathSum(root, ans);
        return ans[0];
    }
    
    private int findMaxPathSum(TreeNode root, int[] ans) {
        if (root == null) return 0;
        int left = findMaxPathSum(root.left, ans);
        int right = findMaxPathSum(root.right, ans);
        ans[0] = Math.max(ans[0], left + right + root.val);
        
        // compared to 0 to skip negative values
        return Math.max(0, Math.max(left, right) + root.val);
    }
}