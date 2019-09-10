class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        arr = [None] * 366
        day_set = set(days)

        def dp(i: int, arr: list, day_set: set) -> int:
            if i > 365:
                return 0
            if arr[i]:
                return arr[i]
            ans = -1
            if i in day_set:
                ans = min(dp(i + 1, arr, day_set) + costs[0],   \
                          dp(i + 7, arr, day_set) + costs[1], dp(i + 30, arr, day_set) + costs[2])
            else:
                ans = dp(i + 1, arr, day_set)

            arr[i] = ans
            return ans

        return dp(1, arr, day_set)
