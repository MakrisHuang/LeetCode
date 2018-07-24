/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    public static final String NULL_STATE = "N";
    public static final String SPLITER = ",";

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    private void buildString(TreeNode node, StringBuilder sb) {
        if (node == null){
            sb.append(NULL_STATE).append(SPLITER);
        }else {
            sb.append(node.val).append(SPLITER);
            buildString(node.left, sb);
            buildString(node.right, sb);
        }
    }

    public TreeNode deserialize(String data) {
        String[] content = data.split(SPLITER);
        Deque<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(content));
        TreeNode root = buildTree(queue);
        return root;
    }

    private TreeNode buildTree(Deque<String> queue) {
        String s = queue.remove();
        if (s.equals(NULL_STATE)) {
            return null;
        } else {
            TreeNode node = new TreeNode(Integer.valueOf(s));
            node.left = buildTree(queue);
            node.right = buildTree(queue);
            return node;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
