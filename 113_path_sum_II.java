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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        findAllPaths(res, root, sum, new ArrayList<>());
        return res;
    }
    
    private void findAllPaths(List<List<Integer>> res, TreeNode root,
                              int sum, List<Integer> temp) {
        if (root == null) return;
        
        sum -= root.val;
        temp.add(root.val);
        
        if (root.left == null && root.right == null) {
            if (sum == 0) {
                res.add(new ArrayList<>(temp));   
            }
        }
        
        findAllPaths(res, root.left, sum, temp);
        findAllPaths(res, root.right, sum, temp);
        temp.remove(temp.size() - 1);
    }
}