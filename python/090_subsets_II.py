class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        def backtrace(nums: List[int], res: List[List[int]], temp: List[int], start: int):
            res.append(list(temp))
            for i in range(start, len(nums)):
                if i > start and nums[i] == nums[i - 1]: continue
                temp.append(nums[i])
                backtrace(nums, res, temp, i + 1)
                temp.pop()

        nums.sort()
        res = []
        backtrace(nums, res, [], 0)
        return res
