# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Codec:

    def serialize(self, root):
        """Encodes a tree to a single string.

        :type root: TreeNode
        :rtype: str
        """
        tokens = []
        self.build_str(root, tokens)
        return "".join(tokens)

    def build_str(self, root, tokens):
        if not root:
            tokens.append("null")
            tokens.append("#")
        else:
            tokens.append(str(root.val))
            tokens.append("#")
            self.build_str(root.left, tokens)
            self.build_str(root.right, tokens)

    def deserialize(self, data):
        """Decodes your encoded data to tree.

        :type data: str
        :rtype: TreeNode
        """
        from collections import deque
        q = deque(data.split("#"))
        q.pop()
        return self.build_tree(q)

    def build_tree(self, queue):
        curr = queue.popleft()
        if curr == "null":
            return None
        node = TreeNode(int(curr))
        node.left = self.build_tree(queue)
        node.right = self.build_tree(queue)
        return node

# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.deserialize(codec.serialize(root))
