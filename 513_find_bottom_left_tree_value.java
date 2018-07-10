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
        // dfs(root, 1);
        // return value;
        
        return bfs(root);
        
//         List<List<Integer>> result = new ArrayList<>();
//         visitRow(root, 0, result);
    
//         List<Integer> lastLayer = result.get(result.size() - 1);
//         return lastLayer.get(0);
        
    }
    
    int value = 0;
    int maxLevel = 0;
    
    private void dfs(TreeNode node, int level) {
        if (level > maxLevel) {
            maxLevel = level;
            value = node.val;
        }
        
        level++;
        
        if (node.left != null) {
            dfs(node.left, level);    
        }
        
        if (node.right != null) {
            dfs(node.right, level);
        }
    }
    
    private int bfs(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        
        TreeNode result = null;
        
        while (! queue.isEmpty()) {
            result = queue.peek();       
            int count = queue.size();
            while (count > 0) {
                TreeNode temp = queue.poll();
                
                if (temp.left != null) queue.offer(temp.left);
                if (temp.right != null) queue.offer(temp.right);
                count--;
            }
        }
        
        return result.val;
    }
    
//     private void visitRow(TreeNode node, int level, List<List<Integer>> result) {
//         if (node == null) return;
//         else {
//             if (level >= result.size()) {
//                 result.add(new ArrayList<>());
//             }
            
//             List<Integer> layer = result.get(level);
//             layer.add(node.val);
//             level++;
//             visitRow(node.left, level, result);
//             visitRow(node.right, level, result);
//         }
//     }
}