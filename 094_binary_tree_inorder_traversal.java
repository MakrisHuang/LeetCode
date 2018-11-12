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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inOrder(root, result);
        return result;
    }

    // iterative solution
//     public List<Integer> inorderTraversal(TreeNode root) {
//         List<Integer> res = new ArrayList();
//         Stack<TreeNode> stack = new Stack();
//         while(!stack.isEmpty() || root != null){
//             while(root != null){
//                 stack.push(root);
//                 root = root.left;
//             }
//             root = stack.pop();
//             res.add(root.val);
//             root = root.right;
//         }

//         return res;
//     }

    private void inOrder(TreeNode node, List<Integer> result) {
        if (node == null) return;

        inOrder(node.left, result);
        result.add(node.val);
        inOrder(node.right, result);
    }

}
