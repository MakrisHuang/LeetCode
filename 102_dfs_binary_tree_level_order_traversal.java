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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        visit(root, 0, result);
        return result;
    }

    // Time Complexity: O(n), Space Complexity: O(n)
    private void visit(TreeNode node, int level, List<List<Integer>> result) {
        if (node == null) return;
        else {
            if (level >= result.size()) {
                result.add(new ArrayList<>());
            }
            List<Integer> layer = result.get(level);

            layer.add(node.val);
            level++;
            visit(node.left, level, result);
            visit(node.right, level, result);
        }
    }
}
