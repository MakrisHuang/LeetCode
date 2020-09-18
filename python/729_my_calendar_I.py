class Node:
    def __init__(self, start, end):
        self.start = start
        self.end = end
        self.left = self.right = None

class Tree:
    def __init__(self):
        self.root = None

    def insert(self, node, root=None):
        if not root:
            if not self.root:
                self.root = node
                return True
            else:
                root = self.root

        # do binary search
        if node.start >= root.end:
            if not root.right:
                root.right = node
                return True
            return self.insert(node, root.right)
        elif node.end <= root.start:
            if not root.left:
                root.left = node
                return True
            return self.insert(node, root.left)
        else:
            return False

# Time Complexity: O(logN) for insert
# Space Complexity: O(N)
class MyCalendar:

    def __init__(self):
        self.tree = Tree()

    def book(self, start: int, end: int) -> bool:
        return self.tree.insert(Node(start, end))


# Your MyCalendar object will be instantiated and called as such:
# obj = MyCalendar()
# param_1 = obj.book(start,end)
