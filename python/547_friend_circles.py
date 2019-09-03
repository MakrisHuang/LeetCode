class Solution:
    def findCircleNum(self, M: List[List[int]]) -> int:
        parent = [-1] * len(M)
        for i in range(len(M)):
            for j in range(len(M[0])):
                if M[i][j] == 1 and i != j:
                    self.union(parent, i, j)
        # count how many parent (aka -1)
        return dict(collections.Counter(parent))[-1]

    def find(self, parent: List[int], i: int):
        if parent[i] == -1:
            return i
        return self.find(parent, parent[i])

    def union(self, parent: List[int], x, y):
        x_parent = self.find(parent, x)
        y_parent = self.find(parent, y)
        if x_parent != y_parent:
            parent[x_parent] = y_parent
