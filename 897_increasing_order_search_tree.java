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
    TreeNode curr;

    public TreeNode increasingBST(TreeNode root) {
        TreeNode dummy = new TreeNode(0);
        curr = dummy;
        inorder(root);
        return dummy.right;
    }

    public void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);
        root.left = null;
        curr.right = root;
        curr = root;
        inorder(root.right);
    }
}
