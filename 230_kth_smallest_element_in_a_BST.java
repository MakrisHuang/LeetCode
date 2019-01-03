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
    // Version 1: apply binary search
    // Space Complexity: O(1)
    public int kthSmallest(TreeNode root, int k) {
        int count = countNodes(root.left);
        if (k <= count) {
            return kthSmallest(root.left, k);
        } else if (k > count + 1) {
            return kthSmallest(root.right, k-1-count); // 1 is counted as current node
        }

        return root.val;
    }

    public int countNodes(TreeNode n) {
        if (n == null) return 0;

        return 1 + countNodes(n.left) + countNodes(n.right);
    }

    // Version 2: in-order traversal and get all values
//     public int kthSmallest(TreeNode root, int k) {
//         List<Integer> result = new ArrayList<>();
//         inOrder(k, root, result);
//         return result.get(k - 1);
//     }

//     private void inOrder(int k, TreeNode node, List<Integer> result){
//         if (node == null) return;
//         inOrder(k, node.left, result);
//         result.add(node.val);
//         inOrder(k, node.right, result);
//     }
}

/*
    Other solution: by consuming each node between k

    Integer search(TreeNode root, int[] k) {
        if (root == null) return null;

        Integer result = search(root.left, k);
        if (result != null) return result;

        if ((k[0] -= 1) == 0) return root.val;

        return search(root.right, k);
    }

    public int kthSmallest(TreeNode root, int k) {
        return search(root, new int[]{k});
    }
*/
