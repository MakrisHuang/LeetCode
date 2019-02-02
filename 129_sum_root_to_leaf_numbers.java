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
    int sum=0;
    public int sumNumbers(TreeNode root) {
        if(root==null) return 0;
        sumNumber(root,0);
        return sum;
    }

    private void sumNumber(TreeNode node, int number){
        number=number*10+node.val;
        if(node.left==null && node.right == null) sum += number;
        else{
            if(node.left!=null) sumNumber(node.left,number);
            if(node.right!=null) sumNumber(node.right,number);
        }
    }
}
