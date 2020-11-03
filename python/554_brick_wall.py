class Solution:
    def leastBricks(self, wall: List[List[int]]) -> int:
        for i in range(len(wall)):
            wall[i].pop()
            for j in range(1, len(wall[i])):
                wall[i][j] += wall[i][j - 1]
        count_map = collections.defaultdict(int)
        for w in wall:
            for num in w:
                count_map[num] += 1
        key_with_max_value = 0
        if count_map:
            key_with_max_value = max(count_map, key=count_map.get)
        return len(wall) - count_map[key_with_max_value]
