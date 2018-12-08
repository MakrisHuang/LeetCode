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
    public String tree2str(TreeNode t) {
        StringBuilder sb = new StringBuilder();
        build(t, sb);
        return sb.toString();
    }

    public void build(TreeNode t, StringBuilder sb) {
        if (t == null) return;
        sb.append(t.val);
        if (t.left != null || (t.left == null && t.right != null)) {
            sb.append("(");
            build(t.left, sb);
            sb.append(")");
        }

        if (t.right != null) {
            sb.append("(");
            build(t.right, sb);
            sb.append(")");
        }
    }
}
