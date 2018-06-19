/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {

    private Queue<Integer> queue;

    public BSTIterator(TreeNode root) {
        queue = new LinkedList<>();
        iterateTree(queue, root);
    }

    private void iterateTree(Queue<Integer> queue, TreeNode node) {
        if (node == null) return;

        iterateTree(queue, node.left);
        if (node != null) queue.offer(node.val);
        iterateTree(queue, node.right);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return ! queue.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        if (hasNext()) return queue.poll();
        else return 0;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
