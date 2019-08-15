class Solution:
    def threeSumClosest(self, nums: List[int], target: int) -> int:
        if len(nums) < 3:
            return 0
        nums.sort()
        closest = nums[0] + nums[1] + nums[2]
        for i in range(0, len(nums)):
            lo, hi = i + 1, len(nums) - 1
            while lo < hi:
                sum = nums[i] + nums[lo] + nums[hi]
                closest = sum if abs(sum - target) < abs(closest - target) else closest
                if sum == target:
                    return sum
                elif sum < target:
                    lo += 1
                else:
                    hi -= 1
        return closest
