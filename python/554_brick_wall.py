class Solution:
    # Time Complexity: O(W * H) (W = average bricks in a row, H = num of rows)
    def leastBricks(self, wall: List[List[int]]) -> int:
        for row in range(len(wall)):
            for col in range(1, len(wall[row])):
                wall[row][col] += wall[row][col - 1]
        gap_map = dict()
        for row in range(len(wall)):
            for col in range(len(wall[row]) - 1):
                count = gap_map.setdefault(wall[row][col], 0)
                count += 1
                gap_map[wall[row][col]] = count

        # find out top frequent number (has the most gap)
        largest_gaps = 0
        for width, count in gap_map.items():
            if count > largest_gaps:
                largest_gaps = count
        height = len(wall)
        return height - largest_gaps

