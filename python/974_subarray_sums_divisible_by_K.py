class Solution:
    """
    step1: accum = 4, accum % k = 4, mod_arr[4] = 0 + 1 = 1
    step2: accum = 9, accum % k = 4, res = 0 + mod_arr[4] = 0 + 1 = 1,
           mod_arr[4] = 1 + 1 = 2
    step3: accum = 9, accum % k = 4, res = 1 + mod_arr[4] = 1 + 2 = 3
           mod_arr[4] = 2 + 1 = 3
    ....

    Time Complexity: O(N)
    Space Complexity: O(N)
    """
    def subarraysDivByK(self, A: List[int], K: int) -> int:
        res = 0
        mod_array = [1] + [0] * K
        accum = 0
        for i in range(len(A)):
            accum += A[i]
            res += mod_array[accum % K]
            mod_array[accum % K] += 1
        return res
