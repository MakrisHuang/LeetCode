class Solution:
    def findTargetSumWays(self, nums: List[int], S: int) -> int:
        # use dict to prune search space
        # since at different index i, j, there could be same value
        # so using (index, sum) as key
        def dfs(curr_sum, i, d = {}):
            if i < len(nums) and (i, curr_sum) not in d:
                d[(i, curr_sum)] = dfs(curr_sum + nums[i], i + 1) + dfs(curr_sum - nums[i], i + 1)
            if (i, curr_sum) not in d:
                return 1 if curr_sum == S else 0
            else:
                return d.get((i, curr_sum))
        return dfs(0, 0)

