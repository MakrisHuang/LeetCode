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
    Map<String, Integer> map;
    List<TreeNode> res;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        map = new HashMap<>();
        res = new ArrayList<>();
        serialize(root);
        return res;
    }

    private String serialize(TreeNode node) {
        if (node == null) return "#";
        String serializedStr = node.val + "," + serialize(node.left) + "," + serialize(node.right);
        map.put(serializedStr, map.getOrDefault(serializedStr, 0) + 1);
        if (map.get(serializedStr) == 2) {
            res.add(node);
        }
        return serializedStr;
    }
}
