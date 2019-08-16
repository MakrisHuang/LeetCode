"""
# Definition for a Node.
class Node:
    def __init__(self, val, neighbors):
        self.val = val
        self.neighbors = neighbors
"""
class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        visited = dict()

        def dfs(old):
            if old not in visited:
                visited[old] = new = Node(old.val, [])

                new.neighbors = [*map(dfs, old.neighbors)]
            return visited[old]
        return dfs(node)
