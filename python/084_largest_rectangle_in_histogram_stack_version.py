class Solution:
    # Time Complexity: O(n)
    # Space Complexity: O(n)
    def largestRectangleArea(self, heights: List[int]) -> int:
        st = []
        st.append(-1)
        max_area = 0
        for i in range(len(heights)):
            while st and st[-1] != -1 and heights[st[-1]] >= heights[i]:
                new_area = heights[st.pop()] * (i - st[-1] - 1)
                max_area = max(max_area, new_area)
            st.append(i)
        while st and st[-1] != -1:
            max_area = max(max_area, heights[st.pop()] * (len(heights) - st[-1] - 1))
        return max_area
