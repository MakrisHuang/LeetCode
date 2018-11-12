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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> layers = new ArrayList<>();
        visit(layers, 0, root);
        
        for (int row = 0; row < layers.size(); row++) {
            if (row % 2 == 1) {
                List<Integer> layer = layers.get(row);
                Collections.reverse(layer);
            } 
        }
        return layers;
    }
    
    private void visit(List<List<Integer>> result, int level, TreeNode node) {
        if (node == null) return;
        
        if (level >= result.size()){
            result.add(new ArrayList<>());
        }
        List<Integer> layer = result.get(level);
        
        layer.add(node.val);
        level++;
        visit(result, level, node.left);
        visit(result, level, node.right);
    }
}