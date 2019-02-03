class Solution {
    // Apply Divide and Conquer
    // Time Complexity: O(nlogn)
    // Space Complexity: O(1)
    public int largestRectangleArea(int[] heights) {
        return calculateMaxArea(heights, 0, heights.length - 1);
    }

    public int calculateMaxArea(int[] heights, int start, int end) {
        if (start > end) return 0;
        int minIdx = start;
        for (int i = start; i <= end; i++) {
            if (heights[i] < heights[minIdx]) {
                minIdx = i;
            }
        }
        return Math.max(heights[minIdx] * (end - start + 1), Math.max(calculateMaxArea(heights, start, minIdx - 1), calculateMaxArea(heights, minIdx + 1, end)));
    }

    // Time Complexity: O(n ^ 3)
    // public int largestRectangleArea(int[] heights) {
    //     int maxArea = 0;
    //     for (int i = 0; i < heights.length; i++) {
    //         for (int j = i; j < heights.length; j++) {
    //             int minHeight = Integer.MAX_VALUE;
    //             for (int k = i; k <= j; k++) {
    //                 minHeight = Math.min(minHeight, heights[k]);
    //             }
    //             maxArea = Math.max(maxArea, minHeight * (j - i + 1));
    //         }
    //     }
    //     return maxArea;
    // }
}
