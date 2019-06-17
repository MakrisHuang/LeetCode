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
    /* Instead of dealing with ancestor problem
       think about finding out maximum and minimum within a path
       from root to leaf
       keep updating max and min in that path
       Time Complexity: O(N)
       Space Complexity: O(1)
    */
    public int maxAncestorDiff(TreeNode root) {
        return calculateMaxDiff(root, root.val, root.val);
    }

    private int calculateMaxDiff(TreeNode root, int max, int min) {
        if (root == null) return max - min;
        max = Math.max(max, root.val);
        min = Math.min(min, root.val);
        return Math.max(calculateMaxDiff(root.left, max, min), calculateMaxDiff(root.right, max, min));
    }
}
