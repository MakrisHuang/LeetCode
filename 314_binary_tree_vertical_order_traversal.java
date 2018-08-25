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
    class Node {
        int val;
        int col;
        Node (int val, int col) {
            this.val = val;
            this.col = col;
        }
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Node>> levelList = new ArrayList<>();
        levelVisist(root, 0, levelList, 0);

        return convertRowToVertical(levelList);
    }

    private List<List<Integer>> convertRowToVertical(List<List<Node>> source) {
        Map<Integer, List<Integer>> colToValMap = new TreeMap<>();
        for (List<Node> row: source) {
            for (Node node: row) {
                List<Integer> colList = null;
                if (!colToValMap.containsKey(node.col)) {
                    colList = new ArrayList<>();
                    colList.add(node.val);
                    colToValMap.put(node.col, colList);
                } else {
                    colList = colToValMap.get(node.col);
                    colList.add(node.val);
                }
            }
        }

        // flatten map to list
        List<List<Integer>> res = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry: colToValMap.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
    }

    // Time Complexity: O(n), Space Complexity: O(n)
    private void levelVisist(TreeNode node, int level, List<List<Node>> result, int col) {
        if (node == null) return;
        else {
            if (level >= result.size()) {
                result.add(new ArrayList<>());
            }
            List<Node> layer = result.get(level);

            layer.add(new Node(node.val, col));
            level++;
            levelVisist(node.left, level, result, col - 1);
            levelVisist(node.right, level, result, col + 1);
        }
    }
}
