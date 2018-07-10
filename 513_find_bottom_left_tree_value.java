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
    public int findBottomLeftValue(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        visitRow(root, 0, result);

        List<Integer> lastLayer = result.get(result.size() - 1);
        return lastLayer.get(0);
    }

    private void visitRow(TreeNode node, int level, List<List<Integer>> result) {
        if (node == null) return;
        else {
            if (level >= result.size()) {
                result.add(new ArrayList<>());
            }

            List<Integer> layer = result.get(level);
            layer.add(node.val);
            level++;
            visitRow(node.left, level, result);
            visitRow(node.right, level, result);
        }
    }
}
