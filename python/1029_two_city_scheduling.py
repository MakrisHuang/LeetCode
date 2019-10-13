class Solution:
    def twoCitySchedCost(self, costs: List[List[int]]) -> int:
        # sort by the additional cost that a company has
        # by sending a persion to city A and not to city B
        costs.sort(key=lambda x: x[0] - x[1])

        total = 0
        n = len(costs) // 2
        # to optimize the company expenses,
        # send the first n persons to the city A
        # and the others to the city B
        for i in range(n):
            total += costs[i][0] + costs[i + n][1]
        return total
