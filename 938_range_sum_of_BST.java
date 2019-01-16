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
    public int rangeSumBST(TreeNode root, int L, int R) {
        int[] ans = new int[] {0};
        preorder(root, L, R, ans);
        return ans[0];
    }

    public void preorder(TreeNode root, int L, int R, int[] ans) {
        if (root == null) return;

        if (L <= root.val && root.val <= R) {
            ans[0] += root.val;
        }
        preorder(root.left, L, R, ans);
        preorder(root.right, L, R, ans);
    }
}
