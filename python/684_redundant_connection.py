class Solution:
    # Time Complexity: O(N)
    # Space Complexity: O(N)
    def findRedundantConnection(self, edges: List[List[int]]) -> List[int]:
        # apply union find
        def find(parent, curr):
            if parent[curr] != curr:
                parent[curr] = find(parent, parent[curr])
            return parent[curr]

        # union two elements by setting identical parent
        # if different, set x's parent to y's parent
        def union(parent, x, y):
            x_par = find(parent, x)
            y_par = find(parent, y)
            parent[x_par] = parent[y_par]

        eles = set()
        for node1, node2 in edges:
            eles.add(node1)
            eles.add(node2)
        N = len(eles)
        parent = [i for i in range(N + 1)]

        for node1, node2 in edges:
            if find(parent, node1) == find(parent, node2):
                return [node1, node2]
            else:
                union(parent, node1, node2)
        return []

