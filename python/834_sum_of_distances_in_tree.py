# https://leetcode.com/problems/sum-of-distances-in-tree/discuss/1308366/C%2B%2B-solution-using-dfs-with-explanation-O(N)-time-complexity
class Solution:
    def sumOfDistancesInTree(self, N: int, edges: List[List[int]]) -> List[int]:
        tree = collections.defaultdict(set)
        res = [0] * N       # store the distance of ith node to all other nodes
        count = [1] * N     # count[i] stores the number of nodes under the current subtree
        for i, j in edges: # build connected graph
            tree[i].add(j)
            tree[j].add(i)

        def dfs(root, pre):
            for i in tree[root]:
                if i != pre:
                    dfs(i, root)
                    # add the number of nodes in subtree to the current node
                    count[root] += count[i]

                    # res[0] = res[2] + number of nodes in subtree with root 2
                    #        + res[1] + number of nodes in subtree with root 1
                    res[root] += res[i] + count[i]

        def dfs2(root, pre):    # re-rooting techinque
            for new_root in tree[root]:
                if new_root != pre:
                    # count[new_root]: The number of nodes that will be one step closer.
                    # N - count[new_root]: The number of nodes that will be one step further
                    res[new_root] = res[root] - count[new_root] + (N - count[new_root])
                    dfs2(new_root, root)
        dfs(0, -1)
        # print('res', res)
        dfs2(0, -1)
        # print('res', res)
        return res
