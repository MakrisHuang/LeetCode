/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    // Time Complexity: O(N)
    // Space Complexity: O(logN)
    public int maxDepth(Node root) {
        if (root == null) return 0;
        return depth(root, 1);
    }

    private int depth(Node root, int dep) {
        if (root == null) return dep;
        int max = dep;
        for (Node child: root.children) {
            int len = depth(child, dep + 1);
            if (len > max) {
                max = len;
            }
        }
        return max;
    }
}
