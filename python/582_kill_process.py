class Solution:
    # Time Complexity: O(N)
    # Space Complexity: O(N)
    def killProcess(self, pid: List[int], ppid: List[int], kill: int) -> List[int]:
        # apply dfs to delete process recursively
        def dfs(m, curr: int, res: List[int]) -> None:
            if curr == 0:
                return
            res.append(curr)
            for child in m[curr]:
                dfs(m, child, res)

        parent_to_child_map = collections.defaultdict(list)
        for i in range(len(pid)):
            parent_to_child_map[ppid[i]].append(pid[i])
        res = []
        dfs(parent_to_child_map, kill, res)
        return res
