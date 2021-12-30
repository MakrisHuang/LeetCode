from collections import defaultdict


class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        count = 0
        sum = 0
        occurrences = defaultdict(int)    # key: sum, value: occurrence times
        occurrences[0] = 1
        for i in nums:
            sum += i
            if sum - k in occurrences:
                count += occurrences[sum - k]
            occurrences[sum] = occurrences[sum] + 1
        return count

    def subarraySum_n2(self, nums: List[int], k: int) -> int:
        # use cumulative sum
        count = 0
        prefix = [0 for i in range(len(nums) + 1)]
        for i in range(1, len(nums) + 1):
            prefix[i] = prefix[i - 1] + nums[i - 1]

        for i in range(len(nums)):
            for j in range(i + 1, len(nums) + 1):
                if prefix[j] - prefix[i] == k:
                    count += 1
        return count

