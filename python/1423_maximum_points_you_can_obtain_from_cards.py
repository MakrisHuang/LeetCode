class Solution:
    def maxScore(self, card_points: List[int], k: int) -> int:
        prefix_from_left = [0, card_points[0]]
        for i in range(1, len(card_points)):
            prefix_from_left.append(prefix_from_left[-1] + card_points[i])

        prefix_from_right = [0]
        for i in range(len(card_points) - 1, -1, -1):
            prefix_from_right.append(prefix_from_right[-1] + card_points[i])

        largest = 0
        for i in range(k + 1):
            left_sum = prefix_from_left[i]
            right_sum = prefix_from_right[k - i]
            # print("left_sum", left_sum, "right_sum", right_sum)
            largest = max(largest, left_sum + right_sum)
        return largest
