class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        lowest = prices[0]
        profit = 0
        for i in range(1, len(prices)):
            profit = max(profit, prices[i] - lowest)
            if prices[i] < lowest:  # update the lowest since we only can sell after buy
                lowest = prices[i]
        return profit
