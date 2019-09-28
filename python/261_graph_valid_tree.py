class Solution:
    def validTree(self, n: int, edges: List[List[int]]) -> bool:
        parent = [i for i in range(n)]
        def find(x):
            return x if parent[x] == x else find(parent[x])
        for u, v in edges:
            u_par = find(u)
            v_par = find(v)
            if u_par == v_par:
                return False
            parent[u_par] = v_par
        # check if all of them are connected
        # n nodes need at least (n - 1) edges
        return len(edges) == n - 1
