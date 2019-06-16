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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);

        int largest = Integer.MIN_VALUE;
        while (q.size() > 0) {
            TreeNode curr = q.poll();
            if (curr != null) {
                if (curr.val > largest) {
                    largest = curr.val;
                }
                if (curr.left != null) {
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                }
            } else {
                res.add(largest);
                largest = Integer.MIN_VALUE;
                if (q.size() > 0) {
                    q.offer(null);
                }
            }
        }

        return res;
    }
}
