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
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return traversal(root, k, set);
    }

    private boolean traversal(TreeNode node, int sum, Set<Integer> set) {
        if (node == null) return false;
        if (set.contains(sum - node.val)) return true;

        set.add(node.val);
        return traversal(node.left, sum, set) || traversal(node.right, sum, set);
    }
}
