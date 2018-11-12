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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] res = new int[] {0};
        calPathLeng(root, res);
        return res[0];
    }
    
    private int calPathLeng(TreeNode node, int[] res) {
        if (node == null) return 0;
        int leftLen = calPathLeng(node.left, res);
        System.out.println("left len: " + leftLen);
        int rightLen = calPathLeng(node.right, res);
        System.out.println("right len: " + rightLen);
        int sum = leftLen + rightLen;
        if (res[0] < sum) {
            res[0] = sum;
        }
        return(leftLen > rightLen ? leftLen + 1 : rightLen + 1); 
    }
}