class Solution:
    # apply dp with bottom-up approach
    # Time Complexity: O(num of elements)
    # Space Complexity: O(num of rows)
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        dp = [val for val in triangle[-1]]
        for row in range(len(triangle) - 2, -1, -1):
            for k in range(len(triangle[row])):
                curr_val = triangle[row][k]
                dp[k] = min(curr_val + dp[k], curr_val + dp[k + 1])
        return dp[0]
