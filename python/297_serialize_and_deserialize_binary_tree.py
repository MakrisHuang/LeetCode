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
        q = collections.deque()
        q.append(root)
        res = []

        while q:
            curr = q.popleft()
            if curr:
                res.append(curr.val)
                q.append(curr.left)
                q.append(curr.right)
            else:
                res.append(None)
        return str(res)

    def deserialize(self, data):
        """
        apply bfs and index for decoding string
        """
        orig = eval(data)
        root = TreeNode(orig[0]) if orig and orig[0] != None else None
        i = 1
        q = collections.deque([root])
        while q:
            node = q.popleft()
            if node is not None:
                # ensure it has child
                node.left = TreeNode(orig[i]) if orig[i] != None else None
                node.right = TreeNode(orig[i + 1]) if orig[i + 1] != None else None
                i += 2
                q.extend([node.left, node.right])
        return root






# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.deserialize(codec.serialize(root))
