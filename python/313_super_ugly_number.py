class Solution:
    def nthSuperUglyNumber(self, n: int, primes: List[int]) -> int:
        # similar to ugly number II
        res = [1]
        multiply = [0] * len(primes)
        while len(res) < n:
            res.append(min([res[multiply[i]] * primes[i] for i in range(len(primes))]))

            for i in range(len(primes)):
                if res[-1] == res[multiply[i]] * primes[i]:
                    multiply[i] += 1
        return res[-1]
