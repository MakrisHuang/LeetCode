class Solution:
    def countPrimes(self, n: int) -> int:
        # apply Sieve of Eratosthenes
        if n == 0 or n == 1: return 0
        visited = [True for _ in range(n + 1)]
        visited[1] = False

        m = int(math.sqrt(n))
        for i in range(2, m + 1):
            if visited[i]:
                # not need to start from i * 2 since they are marked
                multiply = i * i
                while multiply <= n:
                    visited[multiply] = False
                    multiply += i

        count = 0
        for i in range(1, n):
            if visited[i]:
                count += 1
        return count

