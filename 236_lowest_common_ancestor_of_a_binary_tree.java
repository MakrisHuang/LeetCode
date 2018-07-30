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
    private void getNodePath(TreeNode root, TreeNode node, LinkedList<TreeNode> path) {
        if (root == null || path.peekLast() == node) return;
        path.addLast(root);

        getNodePath(root.left, node, path);
        getNodePath(root.right, node, path);
        if (path.peekLast() != node) {
            path.removeLast();
        }
    }

    public TreeNode getLowestCommonNode(LinkedList<TreeNode> l1, LinkedList<TreeNode> l2) {
        TreeNode node = null;

        Iterator it1 = l1.iterator();
        Iterator it2 = l2.iterator();
        TreeNode node1 = null, node2 = null;

        while (it1.hasNext() || it2.hasNext()) {
            if (it1.hasNext()) {
                node1 = (TreeNode)it1.next();
            }
            if (it2.hasNext()) {
                node2 = (TreeNode)it2.next();
            }
            if (node1 != null && node2 != null && node1.val == node2.val) {
                node = node1;
            }
        }
        return node;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) return null;

        LinkedList<TreeNode> listP = new LinkedList<>();
        getNodePath(root, p, listP);

        LinkedList<TreeNode> listQ = new LinkedList<>();
        getNodePath(root, q, listQ);

        TreeNode res = getLowestCommonNode(listP, listQ);
        return res;
    }

    private void printList(LinkedList<TreeNode> list) {
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.print(((TreeNode)iterator.next()).val + " ");
        }
        System.out.println();
    }
}
