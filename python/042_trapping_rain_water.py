class Solution:
    def trap_two_pointer(self, height: List[int]) -> int:
        # apply two pointer to accumulate trapped water
        left = 0
        right = len(height) - 1
        left_max = right_max = ans = 0

        while left < right:
            if height[left] < height[right]:
                if height[left] >= left_max:
                    left_max = height[left]
                else:
                    ans += (left_max - height[left])
                left += 1
            else:
                if height[right] >= right_max:
                    right_max = height[right]
                else:
                    ans += (right_max - height[right])
                right -= 1
        return ans

    def trap_left_right(self, height: List[int]) -> int:
        total_amount = 0
        left_highest = [0] * (len(height) + 1)
        for i in range(len(height)):
            left_highest[i + 1] = max(left_highest[i], height[i])
        right_max = 0
        for i in range(len(height) - 1, -1, -1):
            right_max = max(right_max, height[i])
            min_neighbor_height = min(left_highest[i], right_max)
            if min_neighbor_height > height[i]:
                total_amount += min_neighbor_height - height[i]
        return total_amount

    # take the platform as a mountain and divide them into two part by the peak
    # for left, starting from 0 to the peak
    # once current height is smaller than previous max height, we can create a trap
    # otherwise, update max height with current height
    def trap_mountain(self, height: List[int]) -> int:
        hei_len = len(height)
        if hei_len < 3:
            return 0

        res, peak = 0, 0
        max_val = height[0]
        for i in range(hei_len):
            if height[i] >= max_val:
                max_val = height[i]
                peak = i

        # start from left towards peak
        max_left, max_right = height[0], height[-1]
        for i in range(peak):
            if max_left < height[i]:
                max_left = height[i]
            else:
                res += max_left - height[i]

        for j in range(hei_len - 1, peak, -1):
            if max_right < height[j]:
                max_right = height[j]
            else:
                res += max_right - height[j]

        return res

    def trap(self, height: List[int]) -> int:
        # apply monotonous stack to form a decreasing valley that can trap water
        # there are 3 parts, left height, bottom and right height
        st = []
        water, i = 0, 0
        while i < len(height):
            if not st or height[st[-1]] >= height[i]:
                st.append(i)
                i += 1
            else:
                # pop the valley
                bottom = st.pop()
                if st:
                    # find smaller height between left and upcoming height
                    min_height = min(height[st[-1]], height[i])
                    water += (min_height - height[bottom]) * (i - st[-1] - 1)
        return water



