"""
# Definition for a Node.
class Node(object):
    def __init__(self, val, children):
        self.val = val
        self.children = children
"""
from collections import deque
class Codec:
    def serialize(self, root):
        serial = []

        def preorder(node):
            if not node:
                return

            serial.append(str(node.val))
            for child in node.children:
                preorder(child)
            serial.append("#")      # indicates no more children, continue serialization from parent

        preorder(root)
        return " ".join(serial)

    def deserialize(self, data):
        print data
        if not data:
            return None

        tokens = deque(data.split())
        root = Node(int(tokens.popleft()), [])

        def helper(node):
            if not tokens:
                return
            while tokens[0] != "#": # add child nodes with subtrees
                value = tokens.popleft()
                child = Node(int(value), [])
                node.children.append(child)
                helper(child)
            tokens.popleft()        # discard the "#"
        helper(root)
        return root

# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.deserialize(codec.serialize(root))
