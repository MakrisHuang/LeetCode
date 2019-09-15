class Solution:
    # Time Complexity: O(num of rooms + total num of all keys in each room)
    # Space Complexity: O(num of rooms)
    def canVisitAllRooms(self, rooms: List[List[int]]) -> bool:
        def dfs(rooms: List[List[int]], visited: set, room: int):
            if room in visited:
                return
            visited.add(room)
            for next_room_key in rooms[room]:
                dfs(rooms, visited, next_room_key)

        visited = set()
        dfs(rooms, visited, 0)
        return len(visited) == len(rooms)

