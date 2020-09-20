class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [float('inf') for _ in range(amount + 1)]
        dp[0] = 0
        for i in range(1, amount + 1):
            for coin in coins:
                if coin <= i:
                    dp[i] = min(dp[i], dp[i - coin] + 1)
        return dp[amount] if dp[amount] <= amount else -1

    def coinChange_topDown(self, coins: List[int], amount: int) -> int:
        def recursive(coins: List[int], remaining: int, mem: List[int]) -> int:
            if remaining < 0:
                return -1
            if remaining == 0:
                return 0
            if mem[remaining] != 0: return mem[remaining]
            res = float('inf')
            for coin in coins:
                subproblem = recursive(coins, remaining - coin, mem)
                if subproblem == -1:
                    continue
                res = min(res, subproblem + 1)
            mem[remaining] = res if res != float('inf') else -1
            return mem[remaining]

        mem = [0 for _ in range(amount + 1)]
        return recursive(coins, amount, mem)
