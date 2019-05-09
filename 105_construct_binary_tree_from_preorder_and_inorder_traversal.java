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
    // Time Complexity: O(n + logn)
    // Space Complexity: O(2n) (copy array + create node)
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length != inorder.length) return null;
        return build(preorder, inorder);
    }

    private TreeNode build(int[] pre, int[] in) {
        if (pre.length == 0 || in.length == 0) return null;

        // get the head of preorder as the root node
        int rootVal = pre[0];
        // System.out.println("rootVal: " + rootVal);
        TreeNode root = new TreeNode(rootVal);

        // find out left and right array
        int rootIdx = -1;
        // System.out.println("pre: ");
        // print(pre);
        // System.out.println("in: ");
        // print(in);

        for (int i = 0; i < in.length; i++) {
            if (rootVal == in[i]) rootIdx = i;
        }
        int[] leftIn = Arrays.copyOfRange(in, 0, rootIdx);
        int[] rightIn = Arrays.copyOfRange(in, rootIdx + 1, in.length);
        int[] leftPre = Arrays.copyOfRange(pre, 1, 1 + leftIn.length);
        int[] rightPre = Arrays.copyOfRange(pre, 1 + leftPre.length, pre.length);

        root.left = build(leftPre, leftIn);
        root.right = build(rightPre, rightIn);

        return root;
    }

    private void print(int[] nums) {
        for (int num: nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
