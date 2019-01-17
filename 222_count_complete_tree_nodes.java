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
    public int countNodes(TreeNode root) {
        int[] ans = new int[] {0};
        preorder(root, ans);
        return ans[0];
    }

    public void preorder(TreeNode root, int[] ans) {
        if (root == null) return;

        ans[0]++;
        preorder(root.left, ans);
        preorder(root.right, ans);
    }
}
