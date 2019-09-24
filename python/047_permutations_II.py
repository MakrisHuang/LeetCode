class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        res = []
        used = [False for _ in range(len(nums))]
        self.permuateRecursion(nums, res, [], used)
        return res

    def permuateRecursion(self, nums: List[int], res: List[List[int]], temp: List[int], used: List[bool]):
        if len(temp) == len(nums):
            res.append(list(temp))
        for i in range(len(nums)):
            if used[i] or (i > 0 and nums[i] == nums[i - 1] and not used[i - 1]):
                continue
            used[i] = True
            temp.append(nums[i])
            self.permuateRecursion(nums, res, temp, used)
            used[i] = False
            temp.pop()

