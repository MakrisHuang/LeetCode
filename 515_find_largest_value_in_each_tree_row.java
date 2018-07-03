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
        List<List<Integer>> result = new ArrayList<>();
        visit(root, 0, result);

        List<Integer> largest = new ArrayList<>();
        for (int row = 0; row < result.size(); row++) {
            List<Integer> layer = result.get(row);
            int max = layer.get(0);
            for (int i = 1; i < layer.size(); i++) {
                if (layer.get(i) > max) max = layer.get(i);
            }

            largest.add(max);
        }
        return largest;
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

    private void print(List<List<Integer>> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                System.out.print(list.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
