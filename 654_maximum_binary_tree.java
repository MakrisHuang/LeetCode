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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return build(nums);
    }

    private TreeNode build(int[] nums) {
        if (nums.length == 0) return null;

        int largest = Integer.MIN_VALUE;
        int largestIdx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > largest) {
                largest = nums[i];
                largestIdx = i;
            }
        }
        TreeNode node = new TreeNode(largest);

        int[] leftSub = Arrays.copyOfRange(nums, 0, largestIdx);
        int[] rightSub = Arrays.copyOfRange(nums, largestIdx + 1, nums.length);
        node.left = build(leftSub);
        node.right = build(rightSub);

        return node;
    }
}
