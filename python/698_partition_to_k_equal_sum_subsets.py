class Solution:
    # NP-hard question...should be well-prepared
    #
    def canPartitionKSubsets(self, nums: List[int], k: int) -> bool:
        def backtrace(nums: List[int], groups: List[int], target: int, index: int):
            if index == -1:
                for s in groups:
                    if s != target: return False
                return True

            num = nums[index]
            for i in range(len(groups)):
                if groups[i] + num <= target:
                    groups[i] += num
                    if backtrace(nums, groups, target, index - 1):
                        return True
                    groups[i] -= num
            return False

        nums.sort()
        accum = sum(nums)
        if accum % k != 0 or k > accum:
            return False
        target = accum / k
        return backtrace(nums, [0 for _ in range(k)], target, len(nums) - 1)




