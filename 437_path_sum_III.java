/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Use prefix sum (similar to Two Sum)
class Solution {
    public int pathSum(TreeNode root, int sum) {
        HashMap<Integer, Integer> preSum = new HashMap();
        preSum.put(0,1);
        return helper(root, 0, sum, preSum);
    }
    
    public int helper(TreeNode root, int currSum, int target, HashMap<Integer, Integer> preSum) {
        if (root == null) {
            return 0;
        }
        
        currSum += root.val;
        int res = preSum.getOrDefault(currSum - target, 0);
        preSum.put(currSum, preSum.getOrDefault(currSum, 0) + 1);
        
        res += helper(root.left, currSum, target, preSum) + helper(root.right, currSum, target, preSum);
        preSum.put(currSum, preSum.get(currSum) - 1);
        return res;
    }
}

// Slow version
class Solution {
    int count = 0;
    
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        List<Integer> sumList = new ArrayList<>();
        countNumOfPath(root, sumList, sum);
        return count;
    }
    
    public void countNumOfPath(TreeNode root, List<Integer> sumList, int sum) {
        if (root == null) return;
        // update all previous sums
        for (int i = 0; i < sumList.size(); i++) {
            int newSum = sumList.get(i) + root.val;
            if (newSum == sum) {
                count++;
            }
            sumList.set(i, newSum);
        }
        
        // add initial value for current node
        int val = root.val;
        if (val == sum) {
            count++;
        }
        
        // and put to sumList
        sumList.add(val);
        countNumOfPath(root.left, sumList, sum);
        countNumOfPath(root.right, sumList, sum);
        sumList.remove(sumList.size() - 1);
        
        // restore the values in sum list
        for (int i = 0; i < sumList.size(); i++) {
            sumList.set(i, sumList.get(i) - root.val);
        }
    }
}