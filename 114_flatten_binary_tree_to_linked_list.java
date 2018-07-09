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
    private TreeNode prev = null;

    public void flatten(TreeNode root) {
        if (root == null)
            return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
//     public void flatten(TreeNode root) {
//         mirror(root);
//         TreeNode rightTail = findRightTail(root);

//     }

//     private void mirror(TreeNode node) {
//         if (node == null) return ;
//         if (node.left != null || node.right != null) {
//             System.out.println("exchange left: " + node.left + " with right: " + node.right);
//             TreeNode temp = node.right;
//             node.right = node.left;
//             node.left = temp;
//         }
//         TreeNode curr = node;
//         node = curr.left;
//         mirror(node);

//         node = curr.right;
//         mirror(node);
//     }

//     private TreeNode findRightTail(TreeNode root) {
//         TreeNode curr = root;
//         while (curr.right != null) {
//             curr = curr.right;
//         }
//         return curr;
//     }

//     private void mountToRight(TreeNode, root, TreeNode node, TreeNode tail) {
//         if (node == null) return;

//         if (node == root)
//     }
}
