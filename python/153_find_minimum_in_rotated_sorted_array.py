class Solution:
    # Time Complexity: O(n)
    # Space Complexity: O(1)
    def findMin(self, nums: List[int]) -> int:
        def find_min_ele_index(left, right):
            if nums[left] < nums[right]:
                return 0

            while left <= right:
                pivot = (left + right) // 2
                if nums[pivot] > nums[pivot + 1]:
                    return pivot + 1
                else:
                    if nums[pivot] < nums[left]:
                        right = pivot - 1
                    else:
                        left = pivot + 1

        n = len(nums)
        if n == 0:
            return -1
        if n == 1:
            return nums[0]
        left, right = 0, n - 1
        pivot = find_rotate_index(left, right)
        return nums[pivot]
