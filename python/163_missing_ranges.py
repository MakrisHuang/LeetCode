class Solution:
    def findMissingRanges(self, nums: List[int], lower: int, upper: int) -> List[str]:
        res = []
        if not nums:
            self.addRange(lower, upper, res)
            return res

        if lower < nums[0]:
            self.addRange(lower, nums[0] - 1, res)

        for i in range(1, len(nums)):
            if nums[i] == nums[i - 1] + 1 or nums[i] == nums[i - 1]:
                continue
            else:
                self.addRange(nums[i - 1] + 1, nums[i] - 1, res)

        if nums[-1] < upper:
            self.addRange(nums[-1] + 1, upper, res)

        return res

    def addRange(self, lower: int, upper: int, res: List[str]):
        if lower == upper:
            res.append(str(lower))
        else:
            res.append(str(lower) + "->" + str(upper))
