class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        res = []
        for i in range(0, len(nums)):
            if i > 0 and nums[i - 1] == nums[i]: continue

            low, high = i + 1, len(nums) - 1
            sum = 0 - nums[i]
            while low < high:
                curr_sum = nums[low] + nums[high]
                if curr_sum == sum:
                    res.append([nums[i], nums[low], nums[high]])
                    low += 1
                    high -= 1

                    while low < high and nums[low - 1] == nums[low]:
                        low += 1
                    while low < high and nums[high] == nums[high + 1]:
                        high -= 1
                elif curr_sum < sum:
                    low += 1
                else:
                    high -= 1
        return res
