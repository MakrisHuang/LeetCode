class Solution:
    def checkPossibility(self, nums: List[int]) -> bool:
        # check num of decrease in each pair, and it should appear only 1 time
        if len(nums) == 1: return True
        count, index = 1, 0
        for i in range(1, len(nums)):
            if nums[i] < nums[i - 1]:
                count += 1
                index = i
        if count == 1: return True
        elif count == 2:
            # if the discord happens at start or end position, we can modify
            # it to match the condition
            if index == 1 or index == len(nums) - 1: return True

            # valley
            if nums[index + 1] >= nums[index - 1] or \
                nums[index] >= nums[index - 2]:         # peak
                return True
            return False
        else:
            return False


