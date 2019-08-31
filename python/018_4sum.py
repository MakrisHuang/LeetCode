class Solution:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        res = []
        nums.sort()
        for i in range(len(nums) - 3):
            if i > 0 and nums[i - 1] == nums[i]: continue
            if nums[i] * 4 > target: break
            if nums[i] + 3 * nums[len(nums) - 1] < target: continue

            for j in range(i + 1, len(nums) - 2):
                if j > i + 1 and nums[j - 1] == nums[j]: continue
                if nums[j] * 3 > target - nums[i]: break;
                if nums[j] + 2 * nums[len(nums) - 1] < target - nums[i]: continue

                left = j + 1
                right = len(nums) - 1
                sum = target - nums[i] - nums[j]

                while left < right:
                    curr_sum = nums[left] + nums[right]
                    if curr_sum < sum:
                        left += 1
                    elif curr_sum > sum:
                        right -= 1
                    else:
                        res.append([nums[i], nums[j], nums[left], nums[right]])
                        left += 1
                        right -= 1
                        while left < right and nums[left - 1] == nums[left]: left += 1
                        while left < right and nums[right + 1] == nums[right]: right -= 1
        return res
