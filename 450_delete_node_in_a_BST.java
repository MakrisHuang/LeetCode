i/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;

        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            // found node here
            if (root.left == null) {    // case 1: node has only right child
                root = root.right;
            } else if (root.right == null) {    // case 2: node has only left child
                root = root.left;
            } else {    // case 3: node has 2 children
                // find the left most child at right children
                // assign this value to current node
                root.val = findInorderSuccessor(root.right);

                // then delete the right node in the right children nodes
                root.right = deleteNode(root.right, root.val);
            }
        }
        return root;
    }

    private int findInorderSuccessor(TreeNode root) {
        int value = root.val;
        while (root.left != null) {
            value = root.left.val;
            root = root.left;
        }
        return value;
    }
}
