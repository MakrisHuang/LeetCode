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
    // O(logN) -> height of this tree
    public int closestValue(TreeNode root, double target) {
        int ret = root.val;   
        while(root != null){
            if(Math.abs(target - root.val) < Math.abs(target - ret)){
                ret = root.val;
            }      
            root = root.val > target? root.left: root.right;
        }     
        return ret;
    }
    
    public int closestValue(TreeNode root, double target) {
        long source = Math.round(target);
        System.out.println(source);
        long[] ans = new long[] {root.val};
        findClosest(root, source, ans);
        return (int)ans[0];
    }
    
    private void findClosest(TreeNode root, long source, long[] ans) {
        if (root == null) return;
        if (root.val == source) {
            ans[0] = root.val;
        } else if (Math.abs(root.val - source) < Math.abs(ans[0] - source)) {
            ans[0] = root.val;
        }
        findClosest(root.left, source, ans);
        findClosest(root.right, source, ans);
    }
}