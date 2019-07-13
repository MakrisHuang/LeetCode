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
        TreeNode curr = root;
        List<Integer> res = new ArrayList<>();

        Stack<TreeNode> st = new Stack<>();
        while (curr != null || st.size() > 0) {
            while (curr != null) {
                st.push(curr);
                curr = curr.left;
            }
            curr = st.pop();
            res.add(curr.val);
            // update to right child
            // and be ready for next push of left children
            curr = curr.right;
        }
        return res;
    }
}
