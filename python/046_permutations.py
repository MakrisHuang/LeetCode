class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        res = []
        self.backtrace(nums, res, [])
        return res

    def backtrace(self, nums: List[int], res: List[List[int]], temp: List[int]):
        if len(temp) == len(nums):
            res.append(list(temp))
        for val in nums:
            if val in temp: continue
            temp.append(val)
            self.backtrace(nums, res, temp)
            temp.pop()
