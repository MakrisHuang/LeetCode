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
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode parent = null;
        if (t1 != null && t2 == null) parent = t1;
        else if (t1 == null && t2 != null) parent = t2;
        else if (t1 == null && t2 == null) return null;
        else parent = new TreeNode(t1.val + t2.val);

        if (t1 == null && t2 != null) return t2;
        else if (t1 != null & t2 == null) return t1;
        else {
            create(t1.left, t2.left, parent, true);
            create(t1.right, t2.right, parent, false);
        }
        return parent;
    }

    private void create(TreeNode t1, TreeNode t2, TreeNode parent, boolean dir) {
        if (t1 == null && t2 == null) return;

        TreeNode curr = null;
        if (t1 != null && t2 == null) {
            curr = t1;
        }
        else if (t1 == null && t2 != null) {
            curr = t2;
        }
        else {
            curr = new TreeNode(t1.val + t2.val);
        }

        // true for left, false for right
        if (dir == true) {
            parent.left = curr;
        } else {
            parent.right = curr;
        }
        parent = curr;

        TreeNode tempT1 = t1, tempT2 = t2;
        if (t1 != null) t1 = t1.left;
        if (t2 != null) t2 = t2.left;
        create(t1, t2, parent, true);
        t1 = tempT1; t2 = tempT2;

        if (t1 != null) t1 = t1.right;
        if (t2 != null) t2 = t2.right;
        create(t1, t2, parent, false);
        t1 = tempT1; t2 = tempT2;
    }
}
