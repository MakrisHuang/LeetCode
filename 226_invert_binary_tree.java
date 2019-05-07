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
    // need to consider the base case of recursion
    // doing base case will merge to bigger one
    // which is what we desire
    // Time Complexity: O(n)
    // Space Complexity: O(height) -> O(n)
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode rightTree = invertTree(root.right);
        TreeNode leftTree = invertTree(root.left);
        root.left = rightTree;
        root.right = leftTree;
        return root;
    }
}
