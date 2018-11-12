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
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (! queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (set.contains(k - node.val)) return true;
            set.add(node.val);
            
            if (node.right != null) queue.offer(node.right);
            if (node.left != null) queue.offer(node.left);
        }
        return false;
    }
    
    
//     public boolean findTarget(TreeNode root, int k) {
//         Set<Integer> set = new HashSet<>();
//         return traversal(root, k, set);
//     }
    
//     private boolean traversal(TreeNode node, int sum, Set<Integer> set) {
//         if (node == null) return false;
//         if (set.contains(sum - node.val)) return true;
        
//         set.add(node.val);
//         return traversal(node.left, sum, set) || traversal(node.right, sum, set);
//     }
}