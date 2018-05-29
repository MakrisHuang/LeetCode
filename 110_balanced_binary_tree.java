/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Brute-force version
// O(n^2) runtime, O(n) for space
/*
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return Math.abs(getDepth(root.left) - getDepth(root.right)) <= 1
            && isBalanced(root.left)
            && isBalanced(root.right);
    }

    private int getDepth(TreeNode node){
        if (node == null) return 0;
        return Math.max(getDepth(node.left), getDepth(node.right)) + 1;
    }
}
*/

// Bottom-up recursion
// O(n) runtime, O(n) space
class Solution {
    public boolean isBalanced(TreeNode root) {
        return maxDepth(root) != -1;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left);
        if (left == -1) return -1;
        int right = maxDepth(root.right);
        if (right == -1) return -1;
        return (Math.abs(left - right) <= 1) ? Math.max(left, right) + 1 : -1;
    }
}
