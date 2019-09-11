class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res = []
        self.backtrace(nums, res, [], 0)
        return res

    def backtrace(self, nums: List[int], res: List[List[int]], temp: List[int], start: int):
        res.append(list(temp))
        for i in range(start, len(nums)):
            temp.append(nums[i])
            self.backtrace(nums, res, temp, i + 1)
            temp.pop()

