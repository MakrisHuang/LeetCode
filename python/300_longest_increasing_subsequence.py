class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        # in brute force it gives us O(n^2) time complexity
        # here we will maintain a global array that store the longest chain
        # To maintain this, every time we iterate the element, we insert the
        # elements with binary search. This will give us O(NlogN) time complexity
        def binary_search_get_index(nums, target) -> int:
            left, right = 0, len(nums) - 1
            while left < right:
                mid = left + (right - left) // 2
                if nums[mid] == target:
                    return mid
                elif nums[mid] < target:
                    left = mid + 1
                else:
                    right = mid
            return left

        sub = [nums[0]]
        for num in nums[1:]:
            if num > sub[-1]:
                sub.append(num)
            else:
                i = binary_search_get_index(sub, num)
                sub[i] = num
        return len(sub)

    def lengthOfLIS_python_binary_search(self, nums: List[int]) -> int:
        sub = []
        for num in nums:
            i = bisect_left(sub, num)

            # If num is greater than any element in sub
            if i == len(sub):
                sub.append(num)

            # Otherwise, replace the first element in sub greater than or equal to num
            else:
                sub[i] = num

        return len(sub)

