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
    // Apply two pass: First, find how many modes are and its size; Second, find the elements whose occurances time is the mode size
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public int[] findMode(TreeNode root) {
        inorder(root);
        modes = new int[modeCount];
        modeCount = 0;
        currCount = 0;
        inorder(root);
        return modes;
    }

    private int currVal;
    private int currCount = 0;
    private int maxCount = 0;
    private int modeCount = 0;

    private int[] modes;

    private void handleValue(int val) {
        if (val != currVal) {
            currVal = val;
            currCount = 0;
        }
        currCount++;
        if (currCount > maxCount) {
            maxCount = currCount;
            modeCount = 1;
        } else if (currCount == maxCount) {
            if (modes != null)
                modes[modeCount] = currVal;
            modeCount++;
        }
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        handleValue(root.val);
        inorder(root.right);
    }

//     public int[] findMode(TreeNode root) {
//         Map<Integer, Integer> map = new HashMap<>();
//         visit(map, root);
//         List<Integer> res = new ArrayList<>();
//         int largest = Integer.MIN_VALUE;
//         for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
//             if (entry.getValue() >= largest) {
//                 largest = entry.getValue();
//             }
//         }

//         for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
//             if (entry.getValue() == largest) {
//                 res.add(entry.getKey());
//             }
//         }
//         return res.stream().mapToInt(i -> i).toArray();
//     }

//     public void visit(Map<Integer, Integer> map, TreeNode node) {
//         if (node == null) return;

//         visit(map, node.left);
//         map.put(node.val, map.getOrDefault(node.val, 0) + 1);
//         visit(map, node.right);
//     }
}
