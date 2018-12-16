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
    /*
        Time Complexity: O(len(s))
        Space Complexity: O(log(s))
    */

    int curr;

    public TreeNode str2tree(String s) {
        if (s == null || s.length() == 0) return null;
        curr = 0;
        s = "(" + s + ")";  // init string in a uniform format to parse it easily
        return construct(s);
    }

    public TreeNode construct(String s) {
        int start = curr + 1;
        int end = start;
        while (Character.isDigit(s.charAt(end)) || s.charAt(end) == '-') {
            end++;
        }
        TreeNode node = new TreeNode(Integer.valueOf(s.substring(start, end)));
        curr = end;

        if (s.charAt(curr) == '(') {
            node.left = construct(s);
            if (s.charAt(curr) == '(') {
                node.right = construct(s);
            }
        }
        curr++; // once finish constructing, increase by 1 to skip ')'
        return node;
    }
}
