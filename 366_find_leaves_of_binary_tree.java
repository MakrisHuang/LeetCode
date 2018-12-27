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
    // Time Complexity: O(log(n)) (traverse all nodes till leaves)
    // Space Complexity: O(n)

    // 特色：用 boolean 判斷是否為葉子，並移除掉該 leaf；同時保留非 leaf 的節點
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        while (root != null) {
            List<Integer> temp = new ArrayList<>();
            // check root node is the leave
            if (isLeave(temp, root)) root = null;
            res.add(temp);
        }
        return res;
    }

    public boolean isLeave(List<Integer> temp, TreeNode node) {
        if (node != null && node.left == null && node.right == null) {
            temp.add(node.val);
            return true;
        }

        if (node != null && node.left != null) {
            // only remove leaf
            if (isLeave(temp, node.left)) node.left = null;
        }

        if (node != null && node.right != null) {
            // only remove leaf
            if (isLeave(temp, node.right)) node.right = null;
        }

        return false;
    }
}
