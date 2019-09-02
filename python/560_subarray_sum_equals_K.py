class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        from collections import defaultdict
        sum = res = 0
        pre_sum_map = defaultdict(int)
        # key: sum, value: count
        pre_sum_map[0] = 1

        for val in nums:
            sum += val
            if sum - k in pre_sum_map:
                res += pre_sum_map[sum - k]
            pre_sum_map[sum] += 1

        return res
