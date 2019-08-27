from bisect import bisect_right
from typing import List
from collections import defaultdict

class Solution:
    def isEscapePossible(self, blocked: List[List[int]], source: List[int], target: List[int]) -> bool:
        blocked_rows = defaultdict(list)
        bloked_cols = defaultdict(list)

        for row, col in sorted(blocked):
            blocked_rows[col].append(row)
            bloked_cols[row].append(col)

        target_col = target[1]
        target_row = target[0]

        visited = set()

        # directions
        RIGHT = 0
        DOWN = 1
        LEFT = 2
        TOP = 3

        def dfs(row, col):
            if row == target_row and col == target_col:
                return True

            for direction in RIGHT, DOWN, LEFT, TOP:
                next_row = row
                next_col = col
                if direction == RIGHT:
                    i = bisect_right(bloked_cols[row], col)

                    next_blocked_col = float('inf')
                    if i < len(bloked_cols[row]):
                        next_blocked_col = bloked_cols[row][i]

                    next_col = min(next_blocked_col - 1, target_col)
                elif direction == LEFT:
                    i = bisect_right(bloked_cols[row], col) - 1

                    next_blocked_col = -1
                    if i >= 0:
                        next_blocked_col = bloked_cols[row][i]

                    next_col = min(next_blocked_col + 1, target_col)
                elif direction == DOWN:
                    i = bisect_right(blocked_rows[col], row)

                    next_blocked_row = float('inf')
                    if i < len(blocked_rows[col]):
                        next_blocked_row = blocked_rows[col][i]

                    next_row = min(next_blocked_row - 1, target_row)
                elif direction == TOP:
                    i = bisect_right(blocked_rows[col], row) - 1

                    next_blocked_row = -1
                    if i >= 0:
                        next_blocked_row = blocked_rows[col][i]

                    next_row = min(next_blocked_row + 1, target_row)

                key = (next_row, next_col)

                if key in visited:
                    continue

                visited.add(key)

                if dfs(next_row, next_col):
                    return True

            return False

        return dfs(source[0], source[1])



