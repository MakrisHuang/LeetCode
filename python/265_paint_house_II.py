class Solution:
    def minCostII(self, costs: List[List[int]]) -> int:
        if not costs: return 0
        num_colors = len(costs[0])
        N = len(costs)
        dp = [[0] * num_colors for _ in range(N)]
        dp[0] = costs[0]

        # initialization
        for house_index in range(1, N):
            for color_index in range(num_colors):
                cand_costs = list(dp[house_index - 1])

                # remove current color to get available colors
                cand_costs.pop(color_index)

                min_cost = min(cand_costs)

                dp[house_index][color_index] = costs[house_index][color_index] + min_cost

        return min(dp[N - 1])
