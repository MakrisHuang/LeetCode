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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        build(root, "", paths);
        return paths;
    }

    private void build(TreeNode root, String path, List<String> paths) {
        if (root != null) {
            path += Integer.toString(root.val);
            if ((root.left == null) && (root.right == null)) {
                paths.add(path);
            } else {
                path += "->";   // extend the current path
            }
            build(root.left, path, paths);
            build(root.right, path, paths);
        }
    }
}
