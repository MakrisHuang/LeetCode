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
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);

        List<Integer> nodes = new ArrayList<>();
        while (q.size() != 0) {
            TreeNode node = q.poll();
            if (node != null) {
                nodes.add(node.val);
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            } else {
                res.add(nodes);
                nodes = new ArrayList<>();
                if (q.size() != 0) {
                    q.offer(null);
                }
            }
        }
        return res;
    }
}
