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
    // Time Complexity: O(num(nodes))
    // Space Complexity: O(num(nodes))
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>>  result = new ArrayList();
        if(root==null) return result;
        List<Integer> temp = new ArrayList();
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        while(!q.isEmpty()){
            temp = new ArrayList();
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode node = q.remove();
                temp.add(node.val);
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            result.add(temp);
        }

        Collections.reverse(result);
        return result;
    }
}
