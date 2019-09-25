class Solution:
    # Time Complexity: O(N * logN), worst: O(N ^ 2)
    # Space Complexity: O(N)
    def largestRectangleArea(self, heights: List[int]) -> int:
        def calculateArea(heights: List[int], start: int, end: int):
            if start > end:
                return 0
            min_idx = start
            for i in range(start, end + 1):
                if heights[min_idx] > heights[i]:
                    min_idx = i
            # 1. current high * all width
            # 2. left part
            # 3. right part
            return max(heights[min_idx] * (end - start + 1), \
                      calculateArea(heights, start, min_idx - 1), \
                      calculateArea(heights, min_idx + 1, end))

        return calculateArea(heights, 0, len(heights) - 1)
