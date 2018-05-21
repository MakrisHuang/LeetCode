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
        List<List<Integer>> result = new ArrayList<>();
        traverse(result, new ArrayList<>(), root);

        List<String> strResult = new ArrayList<>();
        for (List<Integer> list: result){
            String str = "";
            int listLen = list.size();
            for (int i = 0; i < listLen; i++){
                str += list.get(i);
                if (i != listLen - 1) str += "->";
            }
            strResult.add(str);
        }
        return strResult;
    }

    // use dynamic programming: record previous visited elements in path
    private void traverse(List<List<Integer>> result, List<Integer> temp, TreeNode node){
        if (node == null) return;
        temp.add(node.val);

        if (node.left == null & node.right == null){
            List<Integer> newTemp = new ArrayList<>(temp);
            result.add(newTemp);
            temp.remove(temp.size() - 1);
            return;
        }
        traverse(result, temp, node.left);
        traverse(result, temp, node.right);
        temp.remove(temp.size() - 1);
    }
}
