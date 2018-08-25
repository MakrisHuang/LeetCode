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
    int t;
    Map<String, Integer> trees;
    Map<Integer, Integer> count;
    List<TreeNode> ans;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        t = 1;
        trees = new HashMap();
        count = new HashMap();
        ans = new ArrayList();
        lookup(root);
        return ans;
    }

    public int lookup(TreeNode node) {
        if (node == null) return 0;
        String serial = node.val + "," + lookup(node.left) + "," + lookup(node.right);
        int uid = trees.computeIfAbsent(serial, x-> t++);
        count.put(uid, count.getOrDefault(uid, 0) + 1);
        if (count.get(uid) == 2)
            ans.add(node);
        return uid;
    }

//     Map<String, Integer> map;
//     List<TreeNode> res;
//     public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
//         map = new HashMap<>();
//         res = new ArrayList<>();
//         serialize(root);
//         return res;
//     }

//     private String serialize(TreeNode node) {
//         if (node == null) return "#";
//         String serializedStr = node.val + "," + serialize(node.left) + "," + serialize(node.right);
//         map.put(serializedStr, map.getOrDefault(serializedStr, 0) + 1);
//         if (map.get(serializedStr) == 2) {
//             res.add(node);
//         }
//         return serializedStr;
//     }
}
