/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    // Queue Version
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public void connect(TreeLinkNode root) {
        Queue<TreeLinkNode> queue = new LinkedList<>();
        if (root == null) return ;
        
        queue.add(root);
        queue.add(null);
        while ( queue.size() != 0) {
            TreeLinkNode curr = queue.poll();
            if (curr == null) {
                if (queue.size() > 0) queue.offer(null);
            } else {
                curr.next = queue.peek();
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
        }
    }
}