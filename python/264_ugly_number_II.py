class Solution:
    def nthUglyNumber(self, n: int) -> int:
        res = [1]
        multi_i = multi_j = multi_k = 0
        while len(res) < n:
            res.append(min(res[multi_i] * 2, res[multi_j] * 3, res[multi_k] * 5))
            if res[-1] == res[multi_i] * 2: multi_i += 1
            if res[-1] == res[multi_j] * 3: multi_j += 1
            if res[-1] == res[multi_k] * 5: multi_k += 1
        return res[-1]

