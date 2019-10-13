class Solution:
    # Time Complexity: O(n)
    # Space Complexity: O(n)
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        # double the size of array and visit them
        # for curr value i, and for the duplicate value j in the stock
        # do not pop it out since we need to find out greater element
        st = []
        size = len(nums)
        res = [-1 for _ in range(size)]
        for i in range(size * 2):
            while st and nums[st[-1]] < nums[i % size]:
                res[st.pop()] = nums[i % size]
            st.append(i % size)
        return res

