"""
# Definition for a Node.
class Node:
    def __init__(self, val, next, random):
        self.val = val
        self.next = next
        self.random = random
"""
class Solution:
    def __init__(self):
        self.visited = dict()

    # Time Complexity: O(N)
    # Space Complexity: O(N)
    def copyRandomList(self, head: 'Node') -> 'Node':
        if head == None:
            return None
        if head in self.visited:
            return self.visited[head]

        node = Node(head.val, None, None)
        self.visited[head] = node

        # apply recursive to visit nodes in next and random pointers
        node.next = self.copyRandomList(head.next)
        node.random = self.copyRandomList(head.random)
        return node
