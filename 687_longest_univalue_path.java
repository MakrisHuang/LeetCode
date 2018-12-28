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
    int count = 0;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return count;
        dfsVisit(root);
        return count;
    }

    public int dfsVisit(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = dfsVisit(node.left);
        int right = dfsVisit(node.right);

        int curr = 0;
        // Case 1: node.left.val == node.val
        if (node.left != null && node.val == node.left.val) {
            curr = Math.max(curr, left + 1);
        }
        // Case 2: node.right.val == node.val
        if (node.right != null && node.val == node.right.val) {
            curr = Math.max(curr, right + 1);
        }
        // Case 3: node.right.val == node.left.val == node.val
        if (node.left != null && node.val == node.left.val &&
           node.right != null && node.val == node.right.val) {
            count = Math.max(count, left + right + 2);
        }
        count = Math.max(count, curr);
        return curr;
    }
}
