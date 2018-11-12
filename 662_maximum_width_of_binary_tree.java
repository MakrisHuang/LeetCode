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
    int maxWidth = 0;
    
    public int widthOfBinaryTree(TreeNode root) {
        levelVisiting(new ArrayList<>(), root, 1, 0);
        return maxWidth;
    }
    
    private void levelVisiting(List<List<Integer>> result, TreeNode root, int num, int level) {
        if (root == null) return;
        if (level >= result.size()) {
            result.add(new ArrayList<>());
        }
        List<Integer> levelList = result.get(level);
        if (levelList.size() == 0) {    // need to put left most and right most child
            levelList.add(num);
            levelList.add(num);
        } else {
            int leftNum = levelList.get(0);
            int rightNum = levelList.get(1);
            if (num < leftNum) {
                levelList.set(0, num);
            } else if (num > rightNum) {
                levelList.set(1, num);
            }
        }
        maxWidth = Math.max(maxWidth, levelList.get(1) - levelList.get(0) + 1);
        levelVisiting(result, root.left, num * 2, level + 1);
        levelVisiting(result, root.right, num * 2 + 1, level + 1);
    }
}